
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Addon } from 'src/app/model/addon';
import { Plan } from 'src/app/model/plan';
import { Recharge } from 'src/app/model/recharge';
import { AddonService } from 'src/app/services/addon.service';
import { PlanService } from 'src/app/services/plan.service';
import { RechargeService } from 'src/app/services/recharge.service';

@Component({
  selector: 'app-add-recharge',
  templateUrl: './add-recharge.component.html',
  styleUrls: ['./add-recharge.component.css']
})
export class AddRechargeComponent implements OnInit {

  myForm: FormGroup;

  constructor(private planService: PlanService,
    private addonService: AddonService,
     private router: Router,
     private fb: FormBuilder,
     private rechargeService:RechargeService) {

    this.myForm = this.fb.group({
      username: [],
      address : [],
      email: []
    })
  }

  recharge: Recharge = null;

  plan: Plan = null;
  addon: Addon = null;
  isCustomerExists:boolean=true;







  planId: any;
  addonId: any;



  ngOnInit(): void {
    this.planId = sessionStorage.getItem("planId");
    this.addonId = sessionStorage.getItem("addonId");

    if (this.planId) {
      this.getPlan(this.planId);
    }

    if (this.addonId) {
      this.getAddon(this.addonId);
    }


  }


  getPlan(planId: number): void {

    if (planId) {
      this.planService.getPlanById(planId).subscribe((res) => {
        this.plan = res;
        this.calculateTotalAmount();
      });
    }else{
      console.log("plan Id is Null")
    }
  }

  getAddon(addonId: number): void {

    if (addonId) {
      this.addonService.getAddonById(addonId).subscribe((data: any) => {
        this.addon = data;
        this.calculateTotalAmount();
      });
    }else{
      console.log("addoin Id is Null")
    }
  }

  totalAmount:number;


  calculateTotalAmount() {

    if (this.plan != null && this.addon != null) {
      this.totalAmount = this.plan.planPrice + this.addon.addonPrice;
    } else if (this.plan != null) {
      this.totalAmount = this.plan.planPrice;
    } else if (this.addon != null) {
      this.totalAmount = this.addon.addonPrice;
    }
  }



  clickRecharge():any {



    const rechargeDate = new Date();  // This is your date variable
    const formattedDate = rechargeDate.toISOString().split('T')[0];

    if (!this.recharge) {
      this.recharge = { date:formattedDate , rechargePrice: 0 };
    }


    this.recharge.rechargePrice = this.totalAmount;

    console.log(this.recharge)


    this.rechargeService.postRecharge(this.planId, this.addonId, this.recharge).subscribe((response: any) => {
      const createdRechargeId = response?.rechargeId; // Adjust the property name based on your API response
      console.log('Created Recharge ID:', createdRechargeId);

      // Now you can use createdRechargeId in subsequent steps
      this.router.navigate(['/addpayment', createdRechargeId]);
    });
  }




  submitForm(form:any){
    console.log(form)
  }




}



