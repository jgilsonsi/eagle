import { Injectable } from '@angular/core'
import { Http } from '@angular/http'

import { Client } from "./client.model";
import { EAGLE_API } from './../../app.api';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map'

@Injectable()
export class ClientsService {

    constructor(private http: Http) { }

    clients(): Observable<Client[]> {
        return this.http.get(`${EAGLE_API}`)
            .map(response => response.json().data)
    }

}