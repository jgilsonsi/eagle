import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EquipmentModelsRoutingModule } from './equipment-models-routing.module';
import { EquipmentModelsComponent } from './equipment-models.component';
import { PageHeaderModule } from './../shared';

@NgModule({
    imports: [CommonModule, EquipmentModelsRoutingModule, PageHeaderModule],
    declarations: [EquipmentModelsComponent]
})
export class EquipmentModelsModule { }