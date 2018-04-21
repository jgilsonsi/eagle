import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EquipmentModelComponent } from './equipment-model.component';

const routes: Routes = [
    {
        path: '',
        component: EquipmentModelComponent
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class EquipmentModelRoutingModule { }