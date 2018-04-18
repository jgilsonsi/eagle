import { Component, OnInit } from '@angular/core';
import { routerTransition } from '../../router.animations';

import { DashboardService } from './dashboard.service';
import { forEach } from '@angular/router/src/utils/collection';
import { Color } from 'ng2-charts';

@Component({
    selector: 'app-dashboard',
    templateUrl: './dashboard.component.html',
    animations: [routerTransition()]
})
export class DashboardComponent implements OnInit {

    private statistic: any;

    // line chart ---------------------------------------------------
    public lineChartType: string = 'line';

    public lineChartLabels: Array<any> = [
        'Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
        'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'
    ];

    private visits = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
    private clients = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
    private orders = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
    public lineChartData: Array<any> = [
        { data: this.visits, label: 'Visits' },
        { data: this.clients, label: 'New clients' },
        { data: this.orders, label: 'Orders' }
    ];

    public lineChartColors: Array<Color>;

    public lineChartOptions: any = {
        responsive: true
    };

    // pie chart ----------------------------------------------------
    public pieChartType: string = 'doughnut';

    public pieChartLabels: string[] = [];
    public pieChartData: number[] = [];
    public pieChartColors: Array<Color>;

    //---------------------------------------------------------------
    constructor(private dashboardService: DashboardService) { }

    ngOnInit() {
        this.getValues();
        setInterval(() => this.getValues(), 60000);
    }

    private getValues() {
        this.dashboardService.get().subscribe(
            res => {
                this.statistic = res;
                if (this.statistic) {
                    this.populateGraphs()
                }
            });
    }

    private populateGraphs() {
        // line chart -----------------------------------------------
        this.visits = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
        this.clients = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
        this.orders = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];

        for (let item of this.statistic.amountOfVisitsByMonth) {
            let month = Number(item.item);
            if (month >= 1 && month <= 12) {
                this.visits[month - 1] = item.value;
            }
        }

        for (let item of this.statistic.amountOfClientsByMonth) {
            let month = Number(item.item);
            if (month >= 1 && month <= 12) {
                this.clients[month - 1] = item.value;
            }
        }

        for (let item of this.statistic.amountOfOrdersByMonth) {
            let month = Number(item.item);
            if (month >= 1 && month <= 12) {
                this.orders[month - 1] = item.value;
            }
        }

        const lineChartDataClone = JSON.parse(JSON.stringify(this.lineChartData));
        lineChartDataClone[0].data = this.visits;
        lineChartDataClone[1].data = this.clients;
        lineChartDataClone[2].data = this.orders;
        this.lineChartData = lineChartDataClone;

        // pie chart ------------------------------------------------
        this.pieChartLabels.length = 0;
        this.pieChartData.length = 0;

        for (let item of this.statistic.amountOfOrdersByEquipmentType) {
            this.pieChartLabels.push(item.item);
            this.pieChartData.push(item.value);
        }

        this.pieChartLabels = JSON.parse(JSON.stringify(this.pieChartLabels));
    }

}