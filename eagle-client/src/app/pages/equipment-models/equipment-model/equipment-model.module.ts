import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';

import { EquipmentModelRoutingModule } from './equipment-model-routing.module';
import { EquipmentModelComponent } from './equipment-model.component';
import { PageHeaderModule } from './../../../shared';

@NgModule({
    imports: [CommonModule, EquipmentModelRoutingModule, PageHeaderModule, ReactiveFormsModule],
    declarations: [EquipmentModelComponent]
})
export class EquipmentModelModule { }