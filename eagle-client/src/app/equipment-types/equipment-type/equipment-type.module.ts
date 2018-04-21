import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';

import { EquipmentTypeRoutingModule } from './equipment-type-routing.module';
import { EquipmentTypeComponent } from './equipment-type.component';
import { PageHeaderModule } from './../../shared';

@NgModule({
    imports: [CommonModule, EquipmentTypeRoutingModule, PageHeaderModule, ReactiveFormsModule],
    declarations: [EquipmentTypeComponent]
})
export class EquipmentTypeModule { }