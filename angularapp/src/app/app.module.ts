import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddPaymentComponent } from './Customer/add-payment/add-payment.component';
import { AddRechargeComponent } from './Customer/add-recharge/add-recharge.component';
import { ListAddonComponent } from './Customer/list-addon/list-addon.component';
import { ListPlanComponent } from './Customer/list-plan/list-plan.component';
import { ShowNotifyComponent } from './Customer/show-notify/show-notify.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { LoginComponent } from './Auth/login/login.component';
import { RegisterComponent } from './Auth/register/register.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { AdminListAddonComponent } from './Admin/admin-list-addon/admin-list-addon.component';
import { AdminListPlanComponent } from './Admin/admin-list-plan/admin-list-plan.component';
import { AddPalnComponent } from './Admin/add-paln/add-paln.component';
import { AddAddonComponent } from './Admin/add-addon/add-addon.component';
import { UpdateaddonComponent } from './Admin/updateaddon/updateaddon.component';
import { UpdateplanComponent } from './Admin/updateplan/updateplan.component';
import { AdminListPaymentComponent } from './Admin/admin-list-payment/admin-list-payment.component';
import { LogoutComponent } from './Auth/logout/logout.component';
import { AdminHeaderComponent } from './admin-header/admin-header.component';
import { ContactComponent } from './Customer/contact/contact.component';
import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';


@NgModule({
  declarations: [
    AppComponent,
    AddPaymentComponent,
    AddRechargeComponent,
    ListAddonComponent,
    ListPlanComponent,
    ShowNotifyComponent,
    HeaderComponent,
    FooterComponent,
    LoginComponent,
    RegisterComponent,
    AdminListAddonComponent,
    AdminListPlanComponent,
    AddPalnComponent,
    AddAddonComponent,
    UpdateaddonComponent,
    UpdateplanComponent,
    AdminListPaymentComponent,
    LogoutComponent,
    AdminHeaderComponent,
    ContactComponent,
    HomeComponent,
    AboutComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule,
    RouterModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
