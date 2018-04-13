import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';

@Component({
    selector: 'pmd-versions',
    templateUrl: 'pmd-versions.component.html'
})

export class PMDVersionsComponent implements OnInit {

    private form: FormGroup
    constructor(private fb: FormBuilder) { }

    createForm() {
        this.form = this.fb.group({
            'code':             new FormControl('', Validators.compose([Validators.required, Validators.minLength(2)])),
            'effectiveFrom':    new FormControl(new Date(), Validators.compose([Validators.required])),
            'effectiveUpTo':    new FormControl(new Date(), Validators.compose([Validators.required]))
        });
    }

    ngOnInit() {
        this.createForm();
    }
}