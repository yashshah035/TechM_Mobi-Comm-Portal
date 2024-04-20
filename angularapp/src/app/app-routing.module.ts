import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListPlanComponent } from './Customer/list-plan/list-plan.component';
import { ListAddonComponent } from './Customer/list-addon/list-addon.component';
import { AddRechargeComponent } from './Customer/add-recharge/add-recharge.component';
import { AddPaymentComponent } from './Customer/add-payment/add-payment.component';
import { ShowNotifyComponent } from './Customer/show-notify/show-notify.component';
import { AdminListAddonComponent } from './Admin/admin-list-addon/admin-list-addon.component';
import { AdminListPlanComponent } from './Admin/admin-list-plan/admin-list-plan.component';
import { AddPalnComponent } from './Admin/add-paln/add-paln.component';
import { AddAddonComponent } from './Admin/add-addon/add-addon.component';
import { UpdateaddonComponent } from './Admin/updateaddon/updateaddon.component';
import { UpdateplanComponent } from './Admin/updateplan/updateplan.component';
import { RegisterComponent } from './Auth/register/register.component';
import { LoginComponent } from './Auth/login/login.component';
import { AdminListPaymentComponent } from './Admin/admin-list-payment/admin-list-payment.component';
import { LogoutComponent } from './Auth/logout/logout.component';
import { UserGuard } from './guards/user.guard';
import { AdminGuard } from './guards/admin.guard';
import { ContactComponent } from './Customer/contact/contact.component';
import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';
import { AuthGuard } from './guards/auth.guard';







const routes: Routes = [
  { path: '', component: HomeComponent},
  { path: 'home', component: HomeComponent },
  { path: 'about', component: AboutComponent },

  { path: 'listplan', component: ListPlanComponent, canActivate: [UserGuard] },
  { path: 'listaddon', component: ListAddonComponent, canActivate: [UserGuard] },
  { path: 'addrecharge', component: AddRechargeComponent, canActivate: [UserGuard] },
  { path: 'addpayment/:rechargeId', component: AddPaymentComponent, canActivate: [UserGuard] },
  { path: 'notifications', component: ShowNotifyComponent, canActivate: [UserGuard] },
  { path: 'recharge', component: AddRechargeComponent, canActivate: [UserGuard] },
  { path: 'admin/listaddon', component: AdminListAddonComponent, canActivate: [AdminGuard] },
  { path: 'admin/listplan', component: AdminListPlanComponent, canActivate: [AdminGuard] },
  { path: 'admin/addplan', component: AddPalnComponent, canActivate: [AdminGuard] },
  { path: 'admin/addaddon', component: AddAddonComponent, canActivate: [AdminGuard] },
  { path: 'admin/updateaddon/:updateAddonId', component: UpdateaddonComponent, canActivate: [AdminGuard] },
  { path: 'admin/updateplan/:updatePlanId', component: UpdateplanComponent, canActivate: [AdminGuard] },
  { path: 'registration', component: RegisterComponent },
  { path: 'login', component: LoginComponent, canActivate: [AuthGuard] },
  { path: 'admin/paymenthistory', component: AdminListPaymentComponent, canActivate: [AdminGuard] },
  { path: 'logout', component: LogoutComponent },
  { path: 'contact', component: ContactComponent, canActivate: [UserGuard] }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
