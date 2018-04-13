import { Component, OnInit, OnChanges, Input, ViewChild, ElementRef, HostListener, ChangeDetectorRef } from '@angular/core';
import { ForceDirectedGraph } from '../models/force-directed-graph';
import { D3Service } from '../d3.service';

@Component({
    selector: 'graph',
    template: `
        <div class="graph-container" #svg>
            <svg [attr.width]="600" [attr.height]="600">
                <g [zoomableOf]="svg">
                    <g [linkVisual]="link" *ngFor="let link of graph.links"></g>
                    <g [nodeVisual]="node" *ngFor="let node of graph.nodes"
                        [draggableNode]="node" [draggableInGraph]="graph"></g>
                </g>
            </svg>
        </div>`
})
export class GraphComponent implements OnInit, OnChanges {
    @ViewChild('svg') private svgElement: ElementRef;
    @Input("graph") graph: ForceDirectedGraph;


    @HostListener('window:resize', ['$event'])
    onResize(event) {
      this.graph.initSimulation();
    }

    constructor(
        private d3Service: D3Service,
        private ref: ChangeDetectorRef
    ) { }

    ngOnInit() { 
        console.log(this.graph);
        this.graph.ticker.subscribe(d => {
            this.ref.markForCheck();
        });
    }

    ngAfterViewInit() {
        this.graph.initSimulation();
    }

    ngOnChanges() {
        console.log("changes..");
    }

}