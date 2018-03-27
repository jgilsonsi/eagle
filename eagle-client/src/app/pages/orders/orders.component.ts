import { Component, OnInit } from '@angular/core';

import { routerTransition } from '../../router.animations';
import { OrdersService } from './orders.service';
import { Order } from '../models/order.model';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  animations: [routerTransition()]
})
export class OrdersComponent implements OnInit {

  orders: Order[]

  constructor(private ordersService: OrdersService) { }

  ngOnInit() {
    this.ordersService.orders().subscribe(
      orders => this.orders = orders);
  }
}