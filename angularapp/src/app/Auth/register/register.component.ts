import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { RegistrationService } from 'src/app/services/registration.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  registrationForm: FormGroup;

  constructor(private fb: FormBuilder, private router: Router, private registerService: RegistrationService) { }

  ngOnInit(): void {

    this.registrationForm = this.fb.group(
      {

        email: new FormControl('', [Validators.required, Validators.email]),
        username: new FormControl('', [Validators.required, Validators.minLength(3), Validators.maxLength(20)]),
        mobileNumber: new FormControl('', [Validators.required]),
        password: new FormControl('', [
          Validators.required,
          Validators.minLength(3),
          Validators.pattern(/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]+$/)

        ]),
        confirmPassword: new FormControl('', [ Validators.required]),
        userRole: new FormControl('', [Validators.required]),


      },{
        validators: [this.passwordMatchValidator]
      }

    );
  }


  passwordMatchValidator(formGroup: FormGroup) {
    const password = formGroup.get('password').value;
    const confirmPassword = formGroup.get('confirmPassword').value;

    if (password !== confirmPassword) {
      formGroup.get('confirmPassword').setErrors({ passwordMismatch: true });
      return
    } else {
      formGroup.get('confirmPassword').setErrors(null);
    }
  }

  submit(form: any) {

    this.registerService.registerUser(form).subscribe(() => {
      alert("Registration sucessfully !!");
      this.router.navigate(['/login'])
    }
    )

  }

}

