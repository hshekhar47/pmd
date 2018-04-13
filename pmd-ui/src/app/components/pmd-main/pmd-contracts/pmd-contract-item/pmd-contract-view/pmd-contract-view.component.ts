import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs/Subscription';
import { ActivatedRoute } from '@angular/router';
import { PMDContractService } from '../../../../../services/index';
import { PMDApiResponse } from '../../../../../models/index';

@Component({
    selector: 'pmd-contract-view',
    templateUrl: 'pmd-contract-view.component.html'
})
export class PMDContractViewComponent implements OnInit {
    private  httpSubscription: Subscription;
    private contract: any;

    constructor(
        private route: ActivatedRoute,
        private contractService: PMDContractService
    ) { }

    loadContract(id: number) {
        console.log(`loading contract with id ${id}`);
        this.httpSubscription = 
            this.contractService.getOneById(id)
                .subscribe((response:PMDApiResponse) => {
                    this.contract = response.data;
                },
                err => {
                    console.log(err);
                });
    }

    ngOnInit() {
        this.route.params.subscribe(params => {
            this.loadContract(+params['id']);
        })
    }

    ngOnDestroy() {
        if(this.httpSubscription) {
            this.httpSubscription.unsubscribe();
        }
    }
}