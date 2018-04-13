import { Injectable } from '@angular/core';
import * as d3 from 'd3';
import { ForceDirectedGraph } from './models/force-directed-graph';
import { Node } from './models/node';
import { Link } from './models/link';

@Injectable()
export class D3Service {

    constructor() { }

    applyZoomable(svgElement, containerElement) {
        let svg, container, zoomed, zoom;

        zoomed = () => {
            container.attr("transform", d3.event.transform);
        }

        zoom = d3.zoom().on('zoom', zoomed);        

        svg = d3.select(svgElement);
        container = d3.select(containerElement);

        svg.call(zoom);
    }

    applyDraggable(element, node: Node, graph: ForceDirectedGraph) {
        const d3Element = d3.select(element);

        function started() {
            d3.event.sourceEvent.stopPropagation();

            if(!d3.event.active) { graph.simulation.alphaTarget(0.3).restart();}


            function dragged() {
                node.fx = d3.event.x;
                node.fy = d3.event.y;
            }

            function ended() {
                if(!d3.event.active) { graph.simulation.alphaTarget(0);}
                node.fx = null;
                node.fy = null;
            }
            
            d3.event.on('drag', dragged);
        }

        d3Element.call(d3.drag().on('start', started));
    }

    getForceDirectedGraph(nodes: Node[], links: Link[], options: { width, height }) {
        const sg = new ForceDirectedGraph(nodes, links, options);
        return sg;
    }
}