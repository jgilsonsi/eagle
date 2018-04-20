import { Injectable } from '@angular/core'
import { Http } from '@angular/http'

import { Order } from '../models/order.model';
import { EAGLE_API_ORDERS } from './../../app.api';
import { Observable } from 'rxjs/Observable';
import { ErrorHandler } from '../../app.error-handler';
import 'rxjs/add/operator/map'
import 'rxjs/add/operator/catch'

@Injectable()
export class OrdersService {

    private url: string = EAGLE_API_ORDERS;

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