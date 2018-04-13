import { Component, OnInit } from '@angular/core';
import { Node } from '../../d3/models/node';
import { Link } from '../../d3/models/link';
import * as d3 from 'd3';
import { ForceDirectedGraph } from '../../d3/models/force-directed-graph';
import { D3Service } from '../../d3/d3.service';

@Component({
    selector: 'pmd-dashboard',
    templateUrl: 'pmd-dashboard.component.html'
})
export class PMDDashboardComponent implements OnInit {

    graph: ForceDirectedGraph;

    constructor(
        private d3Service: D3Service
    ) { }

    ngOnInit() {
        /*
        d3.json('http://localhost:4200/assets/mocks/products.json', (err, graph) => {

            let nodes: Node[] = [];
            let links: Link[] = []

            graph.nodes.forEach(element => {
                let node = new Node(element.id);
                nodes.push(node);
            })

            graph.links.forEach(element => {
                let link = new Link(element.source, element.target);
                links.push(link);
            });
            
            this.graph = this.d3Service.getForceDirectedGraph(nodes, links, {
                width: 600, height: 600
            });

        });
        */
    }
}