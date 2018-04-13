import { Directive, Input, ElementRef } from '@angular/core';
import { D3Service } from '../d3.service';

@Directive({ 
    selector: '[zoomableOf]' 
})
export class ZoomableOfDirective {
    @Input('zoomableOf') zoomableOf: ElementRef

    constructor(
        private d3Service: D3Service,
        private _element : ElementRef) { }

    ngOnInit() {
        this.d3Service.applyZoomable(this.zoomableOf, this._element.nativeElement);
    }
}