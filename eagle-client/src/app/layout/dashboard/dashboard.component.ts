import { Component, OnInit } from '@angular/core';
import { routerTransition } from '../../router.animations';

import { DashboardService } from './dashboard.service';
import { forEach } from '@angular/router/src/utils/collection';

@Component({
    selector: 'app-dashboard',
    templateUrl: './dashboard.component.html',
    animations: [routerTransition()]
})
export class DashboardComponent implements OnInit {

    private statistic: any;

    //line chart ----------------------------------------------------
    public lineChartType: string = 'line';
    public lineChartLegend: boolean = true;

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

    public lineChartOptions: any = {
        responsive: true
    };

    public lineChartColors: Array<any> = [{
        backgroundColor: 'rgba(255,225,154,0.2)',
        borderColor: 'rgba(255,225,154,1)',
        pointBackgroundColor: 'rgba(255,225,154,1)',
        pointBorderColor: '#fff',
        pointHoverBackgroundColor: '#fff',
        pointHoverBorderColor: 'rgba(255,225,154,0.8)'
    }, {
        backgroundColor: 'rgba(255,161,181,0.2)',
        borderColor: 'rgba(255,161,181,1)',
        pointBackgroundColor: 'rgba(255,161,181,1)',
        pointBorderColor: '#fff',
        pointHoverBackgroundColor: '#fff',
        pointHoverBorderColor: 'rgba(255,161,181,0.8)'
    }, {
        backgroundColor: 'rgba(134,199,243,0.2)',
        borderColor: 'rgba(134,199,243,1)',
        pointBackgroundColor: 'rgba(134,199,243,1)',
        pointBorderColor: '#fff',
        pointHoverBackgroundColor: '#fff',
        pointHoverBorderColor: 'rgba(134,199,243,1)'
    }];

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
    }

    // events -------------------------------------------------------
    public chartClicked(e: any): void {
        // console.log(e);
    }

    public chartHovered(e: any): void {
        // console.log(e);
    }

    /*
    // bar chart
    public barChartOptions: any = {
        scaleShowVerticalLines: false,
        responsive: true
    };
    public barChartLabels: string[] = [
        '2006',
        '2007',
        '2008',
        '2009',
        '2010',
        '2011',
        '2012'
    ];
    public barChartType: string = 'bar';
    public barChartLegend: boolean = true;

    public barChartData: any[] = [{ data: [65, 59, 80, 81, 56, 55, 40], label: 'Series A' }, { data: [28, 48, 40, 19, 86, 27, 90], label: 'Series B' }
    ];

    // Pie
    public pieChartLabels: string[] = [
        'Download Sales',
        'In-Store Sales',
        'Mail Sales'
    ];
    public pieChartData: number[] = [300, 500, 100];
    public pieChartType: string = 'pie';*/
}