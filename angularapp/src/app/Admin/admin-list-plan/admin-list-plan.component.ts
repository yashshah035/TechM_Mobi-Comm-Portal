import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Plan } from 'src/app/model/plan';
import { PlanService } from 'src/app/services/plan.service';

@Component({
  selector: 'app-admin-list-plan',
  templateUrl: './admin-list-plan.component.html',
  styleUrls: ['./admin-list-plan.component.css']
})
export class AdminListPlanComponent implements OnInit {

  searchGroup:FormGroup;

  constructor(private planService: PlanService, private router: Router,private fb:FormBuilder) { }

  planList: Plan[] = [];

  ngOnInit(): void {

    this.getPlanList();
    this.searchGroup = this.fb.group({
      p: new FormControl('')

    })

  }

  getPlanList() {
    this.planService.getlistplan().subscribe((res) => { this.planList = res })
  }

  delete(planId: any) {

    this.planService.deletePlanById(planId).subscribe(() => this.getPlanList())

  }

  edit(updatePlanId:any) {
    this.router.navigate(['/admin/updateplan',updatePlanId])
  }

  searchByPrice(): any {
    console.log(this.searchGroup.value.p)


    this.planService.searchPlans(this.searchGroup.value.p).subscribe((res: Plan[]) => this.planList = res);

  }

}
