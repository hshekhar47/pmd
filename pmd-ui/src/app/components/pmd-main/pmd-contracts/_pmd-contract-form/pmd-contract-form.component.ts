import { Component, OnInit, Input } from '@angular/core';
import { FormControl, FormGroup, FormBuilder, Validators } from '@angular/forms';

class PMDContractFormModel {
    id?:            number;
    name?:          string;
    description?:   string;
}

@Component({
    selector: 'pmd-contract-form',
    templateUrl: 'pmd-contract-form.component.html'
})
export class PMDContractFormComponent implements OnInit {

    @Input("contract") private contract;
    private form: FormGroup;
    private inProgress: boolean = false;

    constructor(
        private fb: FormBuilder
    ) { }

    createForm(model: PMDContractFormModel) {
        this.form = this.fb.group({
            'id':           new FormControl(model.id || null),
            'name':         new FormControl(model.name  || '', Validators.compose([Validators.required, Validators.minLength(5)])),
            'description':  new FormControl(model.description || '')
        });
    }

    ngOnInit() { 
        if(this.contract) {
            this.createForm(this.contract);
        } else {
            this.createForm(new PMDContractFormModel());
        }
    }

    onSubmit() {
        if(this.form.valid) {
            console.log(this.form.value);
        }
    }
}