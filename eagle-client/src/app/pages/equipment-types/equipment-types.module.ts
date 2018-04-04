import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EquipmentTypesRoutingModule } from './equipment-types-routing.module';
import { EquipmentTypesComponent } from './equipment-types.component';
import { PageHeaderModule } from './../../shared';

@NgModule({
    imports: [CommonModule, EquipmentTypesRoutingModule, PageHeaderModule],
    declarations: [EquipmentTypesComponent]
})
export class EquipmentTypesModule { }