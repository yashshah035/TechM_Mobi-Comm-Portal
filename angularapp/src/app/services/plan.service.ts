import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Plan } from '../model/plan';

@Injectable({
  providedIn: 'root'
})
export class PlanService {
  deleteAddonById(planId: any) {
    throw new Error('Method not implemented.');
  }

  constructor(private http: HttpClient) { }

  public baseUrl = "http://localhost:8001"


  public getlistplan(): Observable<Plan[]> {

    return this.http.get<Plan[]>(this.baseUrl + "/getlistplan");

  }

  public getPlanById(id: number) {

    if (id != null) {

      return this.http.get<Plan>(this.baseUrl + "/getplanbyid/" + id);
    }
  }

  public deletePlanById(planId: any) {

    return this.http.delete(this.baseUrl + "/deleteplanbyid/" + planId);

  }

  public addPlan(plan:Plan){

    return this.http.post<Plan>(this.baseUrl+"/addplan",plan);
  }

  updatePlan(plan:Plan,id:number){
    return this.http.put<Plan>(this.baseUrl+"/update/plan/"+id ,plan)
  }


  public searchPlans(value: any):any {
    return this.http.get<Plan[]>(this.baseUrl + "/searchplan/"+ value);
  }


}
