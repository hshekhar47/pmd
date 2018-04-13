import { Component, OnInit, OnDestroy } from '@angular/core';
import { Subscription } from 'rxjs/Subscription';
import { ActivatedRoute } from '@angular/router';
import { PMDContractService } from '../../../../../services/index';
import { PMDApiResponse } from '../../../../../models/index';

@Component({
    selector: 'pmd-contract-edit',
    templateUrl: 'pmd-contract-edit.component.html'
})
export class PMDContractEditComponent implements OnInit, OnDestroy {
    private httpSubscription: Subscription;
    private contract;

    constructor(
        private route: ActivatedRoute,
        private contractService: PMDContractService
    ) { }

    loadContractById(id: number) {
        console.log(`Loading contract with ${id}`);
        this.httpSubscription = 
            this.contractService.getOneById(id)
                .subscribe(
                    (response: PMDApiResponse) => {
                        if(!response.error) {
                            this.contract = response.data;
                        } else {
                            console.log(response.error);
                        }
                    },
                    err => {
                        console.log(err);
                    });
    }

    ngOnInit() {
        this.route.parent.params
            .subscribe(params => {
                this.loadContractById(+params['id'])
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