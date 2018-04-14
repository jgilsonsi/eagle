import {Injectable }from '@angular/core'
import {Http, Headers, RequestOptions }from '@angular/http'

import {EAGLE_API_EQUIPMENT_STATISTICS }from './../../app.api'; 
import {Observable }from 'rxjs/Observable'; 
import {ErrorHandler }from '../../app.error-handler'; 
import 'rxjs/add/operator/map'
import 'rxjs/add/operator/catch'

@Injectable()
export class DashboardService {

    private url:string = EAGLE_API_EQUIPMENT_STATISTICS; 

    constructor(private http:Http) {}

    get() {
        return this.http.get(this.url)
            .map(res => res.json().data)
            .catch(ErrorHandler.handleError); 
    }

}