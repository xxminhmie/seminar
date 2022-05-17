import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms'
import { LoginService } from '../login.service';

import { Router, RouterModule, Routes } from '@angular/router';



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private loginSer: LoginService, private routes: Router) { }
   
  ngOnInit(): void {
  }

  auth:boolean | undefined;
  loginForm = new FormGroup({
    username: new FormControl( '' ),
    password: new FormControl( ' ')
  });

  s:string | undefined;
 login(){
    this.s = this.loginForm.value.username + "," + this.loginForm.value.password;
    this.loginSer.check( this.s ).subscribe((result) => console.log( result ))

  }

  navigate(){
    this.routes.navigate(['/return-book'])
  }

}
