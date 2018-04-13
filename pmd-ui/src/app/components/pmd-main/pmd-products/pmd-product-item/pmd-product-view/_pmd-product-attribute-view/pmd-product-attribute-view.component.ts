import { Component, OnInit, Input } from '@angular/core';
import { ProductAttribute } from './../../../../../../models/index';

@Component({
    selector: 'pmd-product-attribute-view',
    templateUrl: 'pmd-product-attribute-view.component.html'
})
export class PMDProductAttributeViewComponent implements OnInit {
    @Input("attribute") private attribute: ProductAttribute;

    constructor() { }

    ngOnInit() { }
}