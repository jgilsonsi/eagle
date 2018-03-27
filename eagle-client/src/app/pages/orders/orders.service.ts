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

    constructor(private http: Http) { }

    orders(): Observable<Order[]> {
        return this.http.get(`${EAGLE_API_ORDERS}`)
            .map(response => response.json().data)
            .catch(ErrorHandler.handleError)
    }

}