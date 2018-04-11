import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EquipmentModelsComponent } from './equipment-models.component';

const routes: Routes = [
    {
        path: '',
        component: EquipmentModelsComponent
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class EquipmentModelsRoutingModule { }