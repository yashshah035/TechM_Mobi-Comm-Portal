import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Plan } from 'src/app/model/plan';
import { PlanService } from 'src/app/services/plan.service';

@Component({
    selector: 'app-updateplan',
    templateUrl: './updateplan.component.html',
    styleUrls: ['./updateplan.component.css']
})
export class UpdateplanComponent implements OnInit {

    planForm: FormGroup;

    constructor(private route: ActivatedRoute,
        private planService: PlanService,
        private fb: FormBuilder,
        private router: Router

    ) { }

    updatePlanId: any;




    ngOnInit(): void {


        this.planForm = this.fb.group(
            {
                planType: new FormControl(''),
                planName: new FormControl(''),
                planValidity: new FormControl(''),
                planDetails: new FormControl(''),
                planPrice: new FormControl('')
            }
        );

        this.route.params.subscribe((params) => {
            this.updatePlanId = params['updatePlanId'];
            console.log("plan Id ", this.updatePlanId);
            this.getPlanById(this.updatePlanId);
        });
    }

    getPlanById(id: any) {

        this.planService.getPlanById(id).subscribe((res) => { this.planForm.patchValue(res) });


    }

    updatePlan() {

        this.planService.updatePlan(this.planForm.value, this.updatePlanId).subscribe(() => { this.router.navigate(['/admin/listplan']) })

    }

}
