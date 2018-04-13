import { Component, OnInit, OnDestroy } from '@angular/core';
import { Subscription } from 'rxjs/Subscription';
import { PMDContractService } from '../../../../services/pmd-contract.service';
import { PMDApiResponse } from '../../../../models/index';

@Component({
    selector: 'pmd-contract-list-view',
    templateUrl: 'pmd-contract-list-view.component.html'
})
export class PMDContractListViewComponent implements OnInit, OnDestroy {
    private httpSubscription: Subscription
    private contracts: any[] = [];

    constructor(
        private contractService: PMDContractService
    ) { }

    ngOnInit() {
        this.httpSubscription = 
            this.contractService.getAll()
                .subscribe( (response:PMDApiResponse) => {
                    this.contracts = response.data;
                },
                err => {
                    console.log(err);
                });
    }

    ngOnDestroy() {
        if(this.httpSubscription) {
            this.httpSubscription.unsubscribe();
        }
    }
}