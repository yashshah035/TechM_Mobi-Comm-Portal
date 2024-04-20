import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/model/User';
import { RegistrationService } from 'src/app/services/registration.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;

  userList: User[];

  constructor(private fb: FormBuilder, private router: Router, private registerService: RegistrationService) { }

  ngOnInit(): void {

    this.loginForm = this.fb.group(
      {
        email: new FormControl(''),
        password: new FormControl(''),

      }
    );
  }

  login(): any {
    const email = this.loginForm.value.email;
    const password = this.loginForm.value.password;

    this.registerService.getAllUsers().subscribe((res) => {
      console.log(res);

      const foundUser = res.find((user) => user.email == email && user.password == password);

      if (foundUser) {



        if (foundUser.userRole == "ADMIN") {
          sessionStorage.setItem("role", "ADMIN");
          this.router.navigate(['/admin/listplan']).then(() => { window.location.reload() })


        } else if (foundUser.userRole == "USER") {
          sessionStorage.setItem("role", "USER");
          this.router.navigate(['/listplan']).then(() => { window.location.reload() })
        }
        alert("Login Successfull !!!");
      }
      else {
        alert("Invalid credentials try again !!")
      }
    });



  }
}
