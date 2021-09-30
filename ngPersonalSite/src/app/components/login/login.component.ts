import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginUser: User = new User();

  constructor(
    private auth : AuthService,
    private route : Router
    ) { }

  ngOnInit(): void {
  }

  login(user : User){

    // console.log(user);

    //Personal Site user auth service
    this.auth.login(user.username, user.password).subscribe(
      loggedInUser => {
        console.log("LoginComponent.login() : login successful");
        this.route.navigateByUrl('/home');
      },
      fail => {
        console.log("LoginComponent.login() : login fail");
        this.route.navigateByUrl('/login');
      }
    );
  }

}
