import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs/Subscription';

import { PMDApiResponse } from '../../../../models/index';
import { PMDProductService, PMDAppService } from '../../../../services/index';


@Component({
    selector: 'pmd-product-list-view',
    templateUrl: 'pmd-product-list-view.component.html'
})
export class PMDProductListViewComponent implements OnInit {
    private activeVersion;
    private httpSubscription: Subscription;
    private products: any[] = [];

    constructor(
        private appService: PMDAppService,
        private productService: PMDProductService
    ) { 
        this.appService.version.subscribe(version => this.initialize(version));
    }

    initialize(version) {
        //load only when route matches

        console.log(`initialize(${version})`);
        this.activeVersion = version
        this.httpSubscription = 
            this.productService.getAll(this.activeVersion, 0, 10)
                .subscribe(
                        (response:PMDApiResponse) => {
                            this.products = response.data;
                            console.log(this.products);
                        },
                        (err) => {
                            console.log(err);
                        });
    }

    ngOnInit() {
        console.log(`ngOnInit(${this.activeVersion})`);
        if(!this.activeVersion) {
            this.initialize(this.appService.getActiveVersion());
        }
    }

    ngOnDestroy() {
        if(this.httpSubscription) {
            this.httpSubscription.unsubscribe();
        }
    }
}