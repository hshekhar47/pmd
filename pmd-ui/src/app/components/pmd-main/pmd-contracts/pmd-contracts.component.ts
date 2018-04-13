import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs/Subscription';
import { PMDContractService } from '../../../services/pmd-contract.service';

@Component({
    selector: 'pmd-contracts',
    templateUrl: 'pmd-contracts.component.html'
})
export class PMDContractsComponent implements OnInit {


    constructor() { }

    ngOnInit() {
    }

}