import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ClientsRoutingModule } from './clients-routing.module';
import { ClientsComponent } from './clients.component';
import { PageHeaderModule } from './../shared';

@NgModule({
    imports: [CommonModule, ClientsRoutingModule, PageHeaderModule],
    declarations: [ClientsComponent]
})
export class ClientsModule { }