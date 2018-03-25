import { Injectable } from '@angular/core'
import { Http } from '@angular/http'

import { Client } from '../models/client.model';
import { EAGLE_API_CLIENTS } from './../../app.api';
import { Observable } from 'rxjs/Observable';
import { ErrorHandler } from '../../app.error-handler';
import 'rxjs/add/operator/map'
import 'rxjs/add/operator/catch'

@Injectable()
export class ClientsService {

    constructor(private http: Http) { }

    clients(): Observable<Client[]> {
        return this.http.get(`${EAGLE_API_CLIENTS}`)
            .map(response => response.json().data)
            .catch(ErrorHandler.handleError)
    }

}