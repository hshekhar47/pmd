import { EventEmitter } from "@angular/core";
import { Link } from "./link";
import { Node } from "./node";

import * as d3 from 'd3';


const FORCES = {
    LINKS: 1 / 50,
    COLLISION: 1,
    CHARGE: -1
}

  
export class ForceDirectedGraph {
    public ticker: EventEmitter<d3.Simulation<Node, Link>> = new EventEmitter();
    public simulation: d3.Simulation<any, any>;

    public nodes: Node[] = [];
    public links: Link[] = [];
    public options: { width: number, height: number};

    constructor(nodes, links, options: { width: number, height: number}) {
        this.nodes = nodes;
        this.links = links;
        this.options = options;
        this.initSimulation();
    }

    initNodes() {
        if(!this.simulation) {
            throw new Error('Simulation was not initiallized yet');
        }

        this.simulation.nodes(this.nodes);
    }

    initLinks() {
        if(!this.simulation) {
            throw new Error('Simulation was not initiallized yet');
        }

        this.simulation.force('links', 
                d3.forceLink(this.links)
                    .id(d => d['id'])
                    .strength(FORCES.LINKS)
                    .distance(100));
    }

    initSimulation() {
        if(!this.options || !this.options.width || !this.options.height) {
            throw new Error('Missing options when initializing simulation');
        }

        if(!this.simulation) {
            const ticker = this.ticker;

            this.simulation = d3.forceSimulation()
                                .force('charge', 
                                        d3.forceManyBody()
                                            .strength(d => FORCES.CHARGE * d['r]'])
                                ).force('centers', 
                                        d3.forceCenter(this.options.width/2, this.options.height/2));

            // this.simulation = d3.forceSimulation()
            //                         .force('charge', d3.forceManyBody())
            //                         .force('center', d3.forceCenter())
                                    ;
            this.simulation.on('tick', function() {
                ticker.emit(this);
            });
               
            this.initNodes();
            this.initLinks();
        }
        this.simulation.restart();
    }
}