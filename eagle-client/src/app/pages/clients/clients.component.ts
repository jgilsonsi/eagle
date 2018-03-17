import { Component, OnInit } from '@angular/core';

import { routerTransition } from '../../router.animations';
import { Client } from './client.model';
import { ClientsService } from './clients.service';

@Component({
    selector: 'app-clients',
    templateUrl: './clients.component.html',
    animations: [routerTransition()]
})
export class ClientsComponent implements OnInit {

    clients: Client[]

    constructor(private clientsService: ClientsService) { }

    ngOnInit() {
        this.clientsService.clients().subscribe(
            clients => this.clients = clients);
    }
}
