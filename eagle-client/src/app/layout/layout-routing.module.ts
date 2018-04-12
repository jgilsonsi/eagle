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
            { path: 'charts', loadChildren: './charts/charts.module#ChartsModule' },
            { path: 'forms', loadChildren: './form/form.module#FormModule' },
            { path: 'components', loadChildren: './bs-component/bs-component.module#BsComponentModule' },
            { path: 'clients', loadChildren: '../pages/clients/clients.module#ClientsModule' },
            { path: 'orders', loadChildren: '../pages/orders/orders.module#OrdersModule' },
            { path: 'equipment-types', loadChildren: '../pages/equipment-types/equipment-types.module#EquipmentTypesModule' },
            { path: 'equipment-type/:id', loadChildren: '../pages/equipment-types/equipment-type/equipment-type.module#EquipmentTypeModule' },
            { path: 'equipment-models', loadChildren: '../pages/equipment-models/equipment-models.module#EquipmentModelsModule' },
            { path: 'equipment-model/:id', loadChildren: '../pages/equipment-models/equipment-model/equipment-model.module#EquipmentModelModule' }
        ]
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class LayoutRoutingModule { }
