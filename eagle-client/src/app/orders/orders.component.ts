import { Component, OnInit } from '@angular/core';

import { routerTransition } from '../router.animations';
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
    this.ordersService.getItems().subscribe(
      orders => this.orders = orders);
  }

  deleteItem(item) {
    if (confirm("Do you really want to delete the item: " + item.id + "?")) {
      var index = this.orders.indexOf(item);
      this.orders.splice(index, 1);

      this.ordersService.deleteItem(item.id)
        .subscribe(null,
          err => {
            alert("Could not delete the item.");
            this.orders.splice(index, 0, item);
          });
    }
  }

}