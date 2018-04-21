import { Injectable } from '@angular/core'
import { Http } from '@angular/http'

import { Client } from '../models/client.model';
import { EAGLE_API_CLIENTS } from './../app.api';
import { Observable } from 'rxjs/Observable';
import { ErrorHandler } from '../app.error-handler';
import 'rxjs/add/operator/map'
import 'rxjs/add/operator/catch'

@Injectable()
export class ClientsService {

    private url: string = EAGLE_API_CLIENTS;

    constructor(private http: Http) { }

    getItems() {
        return this.http.get(this.url)
            .map(res => res.json().data)
            .catch(ErrorHandler.handleError)
    }

    deleteItem(id) {
        return this.http.delete(this.url + `/${id}`)
            .map(res => res.json().data)
            .catch(ErrorHandler.handleError);
    }

}