import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Addon } from 'src/app/model/addon';
import { AddonService } from 'src/app/services/addon.service';

@Component({
  selector: 'app-admin-list-addon',
  templateUrl: './admin-list-addon.component.html',
  styleUrls: ['./admin-list-addon.component.css']
})
export class AdminListAddonComponent implements OnInit {

  searchGroup: FormGroup;

  constructor(private addonService: AddonService, private router: Router, private fb: FormBuilder) { }

  addonList: Addon[] = [];

  ngOnInit(): void {

    this.getAddonList();

    this.searchGroup = this.fb.group({
      p: new FormControl('')

    })


  }

  getAddonList() {
    this.addonService.getAddonList().subscribe((res) => { this.addonList = res })
  }

  delete(addonId: any) {

    this.addonService.deleteAddonById(addonId).subscribe(() => this.getAddonList())

  }

  edit(updateAddonId: any) {
    this.router.navigate(['/admin/updateaddon', updateAddonId])
  }



  searchByPrice(): any {
    console.log(this.searchGroup.value.p)


    this.addonService.searchAddons(this.searchGroup.value.p).subscribe((res: Addon[]) => this.addonList = res);

  }



}
