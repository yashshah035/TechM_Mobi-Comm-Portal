import { Component, OnInit } from '@angular/core';
import { Payment } from 'src/app/model/payment';
import { PaymentService } from 'src/app/services/payment.service';

@Component({
  selector: 'app-admin-list-payment',
  templateUrl: './admin-list-payment.component.html',
  styleUrls: ['./admin-list-payment.component.css']
})
export class AdminListPaymentComponent implements OnInit {

  constructor(private paymentService:PaymentService) { }

  paymentList:Payment[]=[];

  ngOnInit()  {

    this.paymentService.getAllPayments().subscribe((res)=>{this.paymentList=res})

  }



}
