import { BrowserModule } from '@angular/platform-browser';
import  {BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing';

import {
    MatButtonModule, 
    MatCardModule,
    MatCheckboxModule,
    MatNativeDateModule,
    MatDatepickerModule,
    MatDividerModule,
    MatExpansionModule,
    MatFormFieldModule,
    MatIconModule,
    MatInputModule,
    MatProgressBarModule,
    MatSelectModule,
    MatToolbarModule,
    MatTooltipModule,
} from '@angular/material';

import { AppComponent } from './app.component';
import { PMDHeaderComponent } from './components/pmd-header/pmd-header.component';
import { PMDFooterComponent } from './components/pmd-footer/pmd-footer.component';
import { PMDDashboardComponent } from './components/pmd-dashboard/pmd-dashboard.component';
import { PMDMainComponent } from './components/pmd-main/pmd-main.component';

import { D3Service } from './d3/d3.service';
import { ZoomableOfDirective } from './d3/directives/zoomable.directive';
import { GraphComponent } from './d3/visuals/graph.component';
import { NodeVisualComponent } from './d3/visuals/node-visual.component';
import { LinkVisualComponent } from './d3/visuals/link-visual.component';
import { DraggableDirective } from './d3/directives/draggable.directive';

import {
  PMDVersionPickerComponent
} from './components/common/index';


import { PMDVersionsComponent } from './components/pmd-main/pmd-versions/index';

//pmd-contracts
import { 
  PMDContractsComponent,
  PMDContractListViewComponent,
  PMDContractViewComponent,
  PMDContractNewComponent,
  PMDContractFormComponent,
  PMDContractEditComponent,
  PMDContractItemComponent
} from './components/pmd-main/pmd-contracts/index';

import { 
  PMDProductsComponent ,
  PMDProductListViewComponent,
  PMDProductViewComponent,
  PMDProductAttributeViewComponent,
} from './components/pmd-main/pmd-products/index';

import { PMDContractService, PMDVersionService, PMDProductService, PMDAppService } from './services/index';
import { HttpClientModule } from '@angular/common/http';
import { PMDProductItemComponent } from './components/pmd-main/pmd-products/pmd-product-item/pmd-product-item.component';

@NgModule({
  declarations: [
    AppComponent,
    
    // -- structural components
    PMDHeaderComponent,
    PMDFooterComponent,
    PMDMainComponent,
    
    // -- d3 components
    ZoomableOfDirective,
    DraggableDirective,
    NodeVisualComponent,
    LinkVisualComponent,
    GraphComponent,

    //common
    PMDVersionPickerComponent,

    //Components
    PMDDashboardComponent,

    // -- versions
    PMDVersionsComponent,
    

    // -- -- pmd-contracts
    PMDContractsComponent,
    PMDContractListViewComponent,
    PMDContractItemComponent,
    PMDContractViewComponent,
    PMDContractFormComponent,
    PMDContractNewComponent,
    PMDContractEditComponent,

    // -- -- pmd-products
    PMDProductsComponent,
    PMDProductListViewComponent,
    PMDProductItemComponent,
    PMDProductViewComponent,
    PMDProductAttributeViewComponent,
  ],
  imports: [
    AppRoutingModule,
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,

    MatButtonModule,
    MatCardModule,
    MatCheckboxModule,
    MatDividerModule,
    MatNativeDateModule,
    MatDatepickerModule,
    MatExpansionModule,
    MatFormFieldModule,
    MatIconModule,
    MatInputModule,
    MatProgressBarModule,
    MatSelectModule,
    MatToolbarModule,
    MatTooltipModule
  ],
  providers: [
    D3Service,
    PMDAppService,
    PMDVersionService,
    PMDContractService,
    PMDProductService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
