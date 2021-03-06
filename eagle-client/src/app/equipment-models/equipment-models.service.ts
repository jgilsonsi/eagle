import { Injectable } from '@angular/core'
import { Http, Headers, RequestOptions, ResponseContentType } from '@angular/http'

import { EquipmentModel } from './../models/equipment-model.model';
import { EAGLE_API_EQUIPMENT_MODELS, EAGLE_API_EQUIPMENT_MODEL_IMAGE } from './../app.api';
import { Observable } from 'rxjs/Observable';
import { ErrorHandler } from '../app.error-handler';
import 'rxjs/add/operator/map'
import 'rxjs/add/operator/catch'

@Injectable()
export class EquipmentModelsService {

    private url: string = EAGLE_API_EQUIPMENT_MODELS;
    private url_image: string = EAGLE_API_EQUIPMENT_MODEL_IMAGE;

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

    getImage(id) {
        return this.http.get(this.url_image + `/${id}`, { responseType: ResponseContentType.Blob })
            .map(res => res.blob())
            .catch(ErrorHandler.handleError);
    }

}