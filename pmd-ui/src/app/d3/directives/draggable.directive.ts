import { Directive, Input, ElementRef, OnInit } from '@angular/core';
import { ForceDirectedGraph } from '../models/force-directed-graph';
import { D3Service } from '../d3.service';
import { Node } from '../models/node';

@Directive({
    selector: '[draggableNode]'
})
export class DraggableDirective implements OnInit {
    
    @Input('draggableNode') draggableNode: Node;
    @Input('draggableInGraph') draggableInGraph: ForceDirectedGraph;

    constructor(private d3Service: D3Service, private _element: ElementRef) { }

    ngOnInit() {
        this.d3Service.applyDraggable(this._element.nativeElement, this.draggableNode, this.draggableInGraph);
    }
}