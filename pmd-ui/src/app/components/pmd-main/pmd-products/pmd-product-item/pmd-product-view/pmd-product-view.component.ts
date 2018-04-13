import { Component, OnInit, OnDestroy, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs/Subscription';
import { PMDProductService, PMDAppService } from '../../../../../services/index';
import { PMDApiResponse } from '../../../../../models/index';


@Component({
    selector: 'pmd-product-view',
    templateUrl: 'pmd-product-view.component.html'
})
export class PMDProductViewComponent implements OnInit, OnDestroy {
    private activeVersion;
    private httpSubscription: Subscription;
    @Input("product") private product;
    
    constructor(
        private appService: PMDAppService,
        private route: ActivatedRoute,
        private productService: PMDProductService
    ) { 
        this.appService.version.subscribe(version => this.activeVersion = version);
    }

    loadProduct(version, id) {
        console.log(`Loding product for version ${version} and id ${id}`)
        this.httpSubscription =
                this.productService.getOneById(version, id)
                    .subscribe(
                        (response: PMDApiResponse) => {
                            this.product = response.data;
                            console.log(this.product);
                        },
                        (err) => {
                            console.log(err);
                        });
    }
    
    ngOnInit() {
        if(!this.activeVersion) {
            this.activeVersion = this.appService.getActiveVersion();
        }
        this.route.parent.params
            .subscribe(params => 
                    this.loadProduct(this.activeVersion, +params['id']));
    }

    ngOnDestroy() {
        if(this.httpSubscription) {
            this.httpSubscription.unsubscribe();
        }
    }


}