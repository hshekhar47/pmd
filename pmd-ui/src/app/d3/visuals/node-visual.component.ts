import { Component, Input } from '@angular/core';
import { Node } from '../models/node';

@Component({
    selector: '[nodeVisual]',
    template: `
      <svg:g [attr.transform]="'translate(' + node.x + ',' + node.y + ')'">
        <svg:circle
            class="node" 
            [attr.fill]="node.color"
            cx="0"
            cy="0"
            [attr.r]="node.r">
        </svg:circle>
        <svg:text
            class="node-name"
            [attr.font-size]="node.fontSize">
          {{node.id}}
        </svg:text>
      </svg:g>
    `
  })
  export class NodeVisualComponent {
    @Input('nodeVisual') node: Node;
  }