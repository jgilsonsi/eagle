import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LayoutComponent } from './layout.component';

const routes: Routes = [
    {
        path: '',
        component: LayoutComponent,
        children: [
            { path: '', redirectTo: 'dashboard' },
            { path: 'dashboard', loadChildren: './dashboard/dashboard.module#DashboardModule' },
            { path: 'clients', loadChildren: '../clients/clients.module#ClientsModule' },
            { path: 'orders', loadChildren: '../orders/orders.module#OrdersModule' },
            { path: 'equipment-types', loadChildren: '../equipment-types/equipment-types.module#EquipmentTypesModule' },
            { path: 'equipment-type/:id', loadChildren: '../equipment-types/equipment-type/equipment-type.module#EquipmentTypeModule' },
            { path: 'equipment-models', loadChildren: '../equipment-models/equipment-models.module#EquipmentModelsModule' },
            { path: 'equipment-model/:id', loadChildren: '../equipment-models/equipment-model/equipment-model.module#EquipmentModelModule' }
        ]
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class LayoutRoutingModule { }
