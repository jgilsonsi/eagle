import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { OrdersRoutingModule } from './orders-routing.module';
import { OrdersComponent } from './orders.component';
import { PageHeaderModule } from './../shared';

@NgModule({
    imports: [CommonModule, OrdersRoutingModule, PageHeaderModule],
    declarations: [OrdersComponent]
})
export class OrdersModule { }