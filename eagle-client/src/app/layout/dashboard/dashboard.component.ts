import { Component, OnInit } from '@angular/core';
import { routerTransition } from '../../router.animations';

@Component({
    selector: 'app-dashboard',
    templateUrl: './dashboard.component.html',
    animations: [routerTransition()]
})
export class DashboardComponent implements OnInit {

    constructor() {
    }

    ngOnInit() { }

}
