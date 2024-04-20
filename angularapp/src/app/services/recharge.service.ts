import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Recharge } from '../model/recharge';

@Injectable({
  providedIn: 'root'
})
export class RechargeService {

  constructor(private http: HttpClient) { }

  public baseUrl="http://localhost:8001"


  postRecharge(pid:number,aid:number,body:Recharge):Observable<boolean> {

    return this.http.post<boolean>(this.baseUrl+"/postrecharge/"+pid+"/"+aid,body);

  }


  getRechargeById(id:any){
    return this.http.get<Recharge>(this.baseUrl+"/getRechargeById/"+id);
  }



}
