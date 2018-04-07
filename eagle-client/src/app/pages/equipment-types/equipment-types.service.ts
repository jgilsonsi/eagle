import { Injectable } from '@angular/core'
import { Http, Headers, RequestOptions } from '@angular/http'

import { EquipmentType } from './../models/equipment-type.model';
import { EAGLE_API_EQUIPMENT_TYPES } from './../../app.api';
import { Observable } from 'rxjs/Observable';
import { ErrorHandler } from '../../app.error-handler';
import 'rxjs/add/operator/map'
import 'rxjs/add/operator/catch'

@Injectable()
export class EquipmentTypesService {

    private url: string = EAGLE_API_EQUIPMENT_TYPES;

    constructor(private http: Http) { }

    getItems() {
        return this.http.get(this.url)
            .map(res => res.json().data)
            .catch(ErrorHandler.handleError)
    }

    getItem(id) {
        return this.http.get(this.url + `/${id}`)
            .map(res => res.json().data)
            .catch(ErrorHandler.handleError);
    }

    addItem(item) {
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });
        return this.http.post(this.url, JSON.stringify(item), options)
            .map(res => res.json().data)
            .catch(ErrorHandler.handleError);
    }

    updateItem(item) {
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });
        return this.http.put(this.url + `/${item.id}`, JSON.stringify(item), options)
            .map(res => res.json().data)
            .catch(ErrorHandler.handleError);
    }

    deleteItem(id) {
        return this.http.delete(this.url + `/${id}`)
            .map(res => res.json().data)
            .catch(ErrorHandler.handleError);
    }

}