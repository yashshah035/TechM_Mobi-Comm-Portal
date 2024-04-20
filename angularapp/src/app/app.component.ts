import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'angularapp';
  empty: boolean = false;

  userRole = "";

  ngOnInit() {

    const currentRole = sessionStorage.getItem('role');
    console.log(currentRole);

    if (currentRole == "ADMIN") {
      this.userRole = "ADMIN";
    } else if (currentRole == "USER") {
      this.userRole="USER"
    }else{
      this.userRole="";
    }



  }















}
