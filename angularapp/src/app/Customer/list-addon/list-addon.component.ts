import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Addon } from 'src/app/model/addon';
import { AddonService } from 'src/app/services/addon.service';

@Component({
  selector: 'app-list-addon',
  templateUrl: './list-addon.component.html',
  styleUrls: ['./list-addon.component.css']
})
export class ListAddonComponent implements OnInit {

  constructor(private addonService:AddonService,private router:Router) { }

  addonList:Addon[]=[];

  ngOnInit(): void {

    this.getAddonList();
  }

  getAddonList(){
    this.addonService.getAddonList().subscribe((res)=>{this.addonList=res})
  }

  default:any="0";

  skip(){
    sessionStorage.setItem("addonId", this.default);
    this.router.navigate(['/recharge'])
  }

  selectedAddon(id:number){
    sessionStorage.setItem("addonId",id.toString())
    this.router.navigate(['/recharge'])


  }



}
