import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Addon } from '../model/addon';

@Injectable({
  providedIn: 'root'
})
export class AddonService {

  constructor(private http: HttpClient) { }

  public baseUrl = "http://localhost:8001"

  public getAddonList(): Observable<Addon[]> {
    return this.http.get<Addon[]>(this.baseUrl + "/getaddonlist")
  }


  public getAddonById(id: number): any {
    console.log(id);
    if (id != null) {

      return this.http.get<Addon>(this.baseUrl + "/getaddonbyid/" + id);

    } else {
      console.log("empty id")
    }
  }


  public deleteAddonById(addonId: any) {
    return this.http.delete(this.baseUrl + "/deleteaddonbyid/" + addonId);
  }

  public addAddon(addon: Addon) {

    return this.http.post<Addon>(this.baseUrl + "/api/addon", addon);
  }

  public updateAddonById(addon: Addon, id: any) {

    return this.http.put<Addon>(this.baseUrl + "/update/addon/" + id, addon);

  }

  public searchAddons(value: any):any {
    return this.http.get<Addon[]>(this.baseUrl + "/search/"+ value);
  }

}
