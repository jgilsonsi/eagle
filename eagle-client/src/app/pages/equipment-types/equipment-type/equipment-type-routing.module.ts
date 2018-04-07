import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EquipmentTypeComponent } from './equipment-type.component';

const routes: Routes = [
    {
        path: '',
        component: EquipmentTypeComponent
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class EquipmentTypeRoutingModule { }