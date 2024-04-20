import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Addon } from 'src/app/model/addon';
import { AddonService } from 'src/app/services/addon.service';

@Component({
  selector: 'app-add-addon',
  templateUrl: './add-addon.component.html',
  styleUrls: ['./add-addon.component.css']
})
export class AddAddonComponent implements OnInit {

  addonForm:FormGroup;

  constructor(private addonService:AddonService, private fb:FormBuilder,private router:Router)
  { }

  ngOnInit() {
    this.addonForm=this.fb.group(
      {

        addonName: new FormControl(''),
        addonValidity: new FormControl(''),
        addonDetails: new FormControl(''),
        addonPrice: new FormControl('')
      }
    );
  }


  addaddon(addon:Addon){

    this.addonService.addAddon(addon).subscribe(()=>{this.router.navigate(['/admin/listaddon'])})

  }

}
