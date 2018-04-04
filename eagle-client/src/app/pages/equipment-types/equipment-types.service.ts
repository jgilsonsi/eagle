import { Injectable } from '@angular/core'
import { Http } from '@angular/http'

import { EquipmentType } from './../models/equipment-type.model';
import { EAGLE_API_EQUIPMENT_TYPES } from './../../app.api';
import { Observable } from 'rxjs/Observable';
import { ErrorHandler } from '../../app.error-handler';
import 'rxjs/add/operator/map'
import 'rxjs/add/operator/catch'

@Injectable()
export class EquipmentTypesService {

    constructor(private http: Http) { }

    equipmentTypes(): Observable<EquipmentType[]> {
        return this.http.get(`${EAGLE_API_EQUIPMENT_TYPES}`)
            .map(response => response.json().data)
            .catch(ErrorHandler.handleError)
    }

    deleteItem(id: number) {
        return this.http.delete(`${EAGLE_API_EQUIPMENT_TYPES}/${id}`)
            .map(res => res.json());
    }
}