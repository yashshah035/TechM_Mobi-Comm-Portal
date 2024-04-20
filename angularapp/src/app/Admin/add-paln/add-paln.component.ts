import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Plan } from 'src/app/model/plan';
import { PlanService } from 'src/app/services/plan.service';

@Component({
  selector: 'app-add-paln',
  templateUrl: './add-paln.component.html',
  styleUrls: ['./add-paln.component.css']
})
export class AddPalnComponent implements OnInit {

  planForm:FormGroup;

  constructor(private planService:PlanService, private fb:FormBuilder,private router:Router)
  { }

  ngOnInit() {
    this.planForm=this.fb.group(
      {
        planType: new FormControl(''),
        planName: new FormControl(''),
        planValidity: new FormControl(''),
        planDetails: new FormControl(''),
        planPrice: new FormControl('')
      }
    );
  }

  addPlan(plan:Plan){

    this.planService.addPlan(plan).subscribe(()=>{this.router.navigate(['/admin/listplan'])})

  }

}
