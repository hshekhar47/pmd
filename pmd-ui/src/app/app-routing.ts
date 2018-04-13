import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { PMDDashboardComponent } from './components/pmd-dashboard/pmd-dashboard.component';
import { PMDHeaderComponent } from './components/pmd-header/pmd-header.component';

import { PMDVersionsComponent } from './components/pmd-main/pmd-versions/index';

import { 
    PMDContractsComponent,
    PMDContractListViewComponent,
    PMDContractItemComponent,
    PMDContractViewComponent,
    PMDContractNewComponent,
    PMDContractEditComponent,

} from './components/pmd-main/pmd-contracts/index';

import { 
    PMDProductsComponent, 
    PMDProductListViewComponent, 
    PMDProductViewComponent
} from './components/pmd-main/pmd-products/index';
import { PMDProductItemComponent } from './components/pmd-main/pmd-products/pmd-product-item/pmd-product-item.component';

const routes: Routes = [
    { path: '', pathMatch: 'full', redirectTo: '/dashboard' },
    { path: 'dashboard', component: PMDDashboardComponent},
    { path: 'versions', component: PMDVersionsComponent},
    { path: 'contracts', component: PMDContractsComponent, 
        children: [
            { path: '', component: PMDContractListViewComponent },
            { path: 'new', pathMatch: 'full', component: PMDContractNewComponent },
            { path: ':id', component: PMDContractItemComponent,
                children: [
                    { path: '', component: PMDContractViewComponent},
                    { path: 'edit', component: PMDContractEditComponent}
                ]
            }
            
        ]
    },
    { path: 'products', component: PMDProductsComponent,
        children: [
            { path: '', component: PMDProductListViewComponent},
            { path: ':id', component: PMDProductItemComponent,
                children: [
                    { path: '', component: PMDProductViewComponent}
                ]}
        ]
    }
];

@NgModule({
    exports: [
        RouterModule
    ],
    imports: [
        RouterModule.forRoot(routes)
    ]
})
export class AppRoutingModule {

}