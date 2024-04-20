import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Plan } from 'src/app/model/plan';
import { PlanService } from 'src/app/services/plan.service';

@Component({
  selector: 'app-list-plan',
  templateUrl: './list-plan.component.html',
  styleUrls: ['./list-plan.component.css']
})
export class ListPlanComponent implements OnInit {

  constructor(private planService: PlanService, private router: Router) { }

  planList: Plan[] = [];

  ngOnInit(): void {

    this.getPlanList();

  }

  getPlanList() {
    this.planService.getlistplan().subscribe((res) => { this.planList = res })
  }

  selectedPlan(id:number){
    sessionStorage.setItem("planId",id.toString());

    this.router.navigate(['/listaddon'])

  }

  default:any="0";

  skip(){
    sessionStorage.setItem("planId",this.default);
    this.router.navigate(['/listaddon'])
  }

}
