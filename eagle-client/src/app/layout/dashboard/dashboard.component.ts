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

    public numberOfContacts: number = 1;
    public numberOfClients: number = 2;
    public numberOfOrders: number = 3;

    // line chart ---------------------------------------------------
    public lineChartType: string = 'line';

    public lineChartLabels: Array<any> = [
        'Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
        'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'
    ];

    private lineChartVisits = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
    private lineChartClients = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
    private lineChartOrders = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
    public lineChartData: Array<any> = [
        { data: this.lineChartVisits, label: 'Visits' },
        { data: this.lineChartClients, label: 'New clients' },
        { data: this.lineChartOrders, label: 'Orders' }
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
        this.lineChartVisits = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
        this.lineChartClients = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
        this.lineChartOrders = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];

        for (let item of this.statistic.numberOfVisitsByMonth) {
            let month = Number(item.name);
            if (month >= 1 && month <= 12) {
                this.lineChartVisits[month - 1] = item.value;
            }
        }

        for (let item of this.statistic.numberOfClientsByMonth) {
            let month = Number(item.name);
            if (month >= 1 && month <= 12) {
                this.lineChartClients[month - 1] = item.value;
            }
        }

        for (let item of this.statistic.numberOfOrdersByMonth) {
            let month = Number(item.name);
            if (month >= 1 && month <= 12) {
                this.lineChartOrders[month - 1] = item.value;
            }
        }

        const lineChartDataClone = JSON.parse(JSON.stringify(this.lineChartData));
        lineChartDataClone[0].data = this.lineChartVisits;
        lineChartDataClone[1].data = this.lineChartClients;
        lineChartDataClone[2].data = this.lineChartOrders;
        this.lineChartData = lineChartDataClone;

        // pie chart ------------------------------------------------
        this.pieChartLabels.length = 0;
        this.pieChartData.length = 0;

        for (let item of this.statistic.numberOfOrdersByEquipmentType) {
            this.pieChartLabels.push(item.name);
            this.pieChartData.push(item.value);
        }

        this.pieChartLabels = JSON.parse(JSON.stringify(this.pieChartLabels));
    }

}