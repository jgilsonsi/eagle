import { Component, OnInit } from '@angular/core';

import { routerTransition } from '../router.animations';
import { ClientsService } from './clients.service';
import { Client } from '../models/client.model';

@Component({
    selector: 'app-clients',
    templateUrl: './clients.component.html',
    animations: [routerTransition()]
})
export class ClientsComponent implements OnInit {

    clients: Client[]

    constructor(private clientsService: ClientsService) { }

    ngOnInit() {
        this.clientsService.getItems().subscribe(
            res => this.clients = res);
    }

    deleteItem(item) {
        if (confirm("Do you really want to delete the item: " + item.name + "?")) {
            var index = this.clients.indexOf(item);
            this.clients.splice(index, 1);

            this.clientsService.deleteItem(item.id)
                .subscribe(null,
                    err => {
                        alert("Could not delete the item.");
                        this.clients.splice(index, 0, item);
                    });
        }
    }

}
