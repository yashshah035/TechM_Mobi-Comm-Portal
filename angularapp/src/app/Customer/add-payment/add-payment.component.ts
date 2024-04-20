


// add-payment.component.ts
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Addon } from 'src/app/model/addon';
import { Payment } from 'src/app/model/payment';
import { Plan } from 'src/app/model/plan';
import { Recharge } from 'src/app/model/recharge';
import { AddonService } from 'src/app/services/addon.service';
import { PaymentService } from 'src/app/services/payment.service';
import { PlanService } from 'src/app/services/plan.service';
import { RechargeService } from 'src/app/services/recharge.service';

@Component({
  selector: 'app-add-payment',
  templateUrl: './add-payment.component.html',
  styleUrls: ['./add-payment.component.css']
})
export class AddPaymentComponent implements OnInit {

  constructor(
    private planService: PlanService,
    private addonService: AddonService,
    private route: ActivatedRoute,
    private rechargeService: RechargeService,
    private paymentService: PaymentService,
    private router: Router
  ) { }

  plan: Plan = null;
  addon: Addon = null;
  recharge: Recharge = null;
  rechargeId: number;
  selectedModeOfPayment: string = '';

  payment = {
    totalAmount: 0, // Set appropriate initial values
    paymentDate: '', // Set appropriate initial values
    modeOfPayment: '', // Set appropriate initial values
    // ... other properties
  };

  planId: any;
  addonId: any;
  customerId: any = null;

  ngOnInit(): void {



    this.planId = sessionStorage.getItem("planId");
    this.addonId = sessionStorage.getItem("addonId");

    if (this.planId != null) {
      this.getPlan(this.planId);
    }

    if (this.addonId != null) {
      this.getAddon(this.addonId);
    }

    this.route.params.subscribe((params) => {
      this.rechargeId = params['rechargeId'];
      console.log("Recharge Id ", this.rechargeId);
      this.getRechargeById(this.rechargeId);
    });


  }

  getPlan(planId: number): void {
    if (planId != null) {
      this.planService.getPlanById(planId).subscribe((res: any) => {
        this.plan = res;
      });
    }
  }

  getAddon(addonId: number): void {
    if (addonId != null) {
      this.addonService.getAddonById(addonId).subscribe((data: any) => {
        this.addon = data;
      });
    }
  }

  getRechargeById(id: any): void {
    this.rechargeService.getRechargeById(id).subscribe((res: Recharge) => { this.recharge = res; })
  }

  addPayment(): void {

    if (this.recharge) {
      this.payment.totalAmount = this.recharge.rechargePrice;
      this.payment.paymentDate = this.recharge.date;
      this.payment.modeOfPayment = this.selectedModeOfPayment;

      this.paymentService.addPayemt(this.rechargeId, this.payment).subscribe(() => {
        alert("Your recharge is successful!");
        this.router.navigate(['/notifications'])
      });

    }
  }
}
