import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Addon } from 'src/app/model/addon';
import { AddonService } from 'src/app/services/addon.service';

@Component({
  selector: 'app-updateaddon',
  templateUrl: './updateaddon.component.html',
  styleUrls: ['./updateaddon.component.css']
})
export class UpdateaddonComponent implements OnInit {

  addonForm: FormGroup;
  updateAddonId:any;


  constructor(private addonService: AddonService,
    private fb: FormBuilder,
    private router: Router,
    private route: ActivatedRoute

  ) { }

  ngOnInit() {
    this.addonForm = this.fb.group(
      {

        addonName: new FormControl(''),
        addonValidity: new FormControl(''),
        addonDetails: new FormControl(''),
        addonPrice: new FormControl('')
      }
    );


    this.route.params.subscribe((params) => {
      this.updateAddonId = params['updateAddonId'];
      console.log("Update Addon Id ", this.updateAddonId);
      this.getAddonById(this.updateAddonId);
    });


  }

  updateaddon() {

    console.log(this.addonForm.value);

    this.addonService.updateAddonById(this.addonForm.value,this.updateAddonId).subscribe(()=>{this.router.navigate(['/admin/listaddon'])})



  }


  getAddonById(id:any){

    this.addonService.getAddonById(id).subscribe((res)=>{this.addonForm.patchValue(res)})
  }



}
