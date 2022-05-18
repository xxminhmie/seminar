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
  if(this.loginForm.value.username==null){
    alert("Please type username date!");
    return;
  }
  if(this.loginForm.value.password==null){
    alert("Please type password date!");
    return;
  }
    this.s = this.loginForm.value.username + "," + this.loginForm.value.password;
    this.loginSer.check( this.s ).subscribe((result) => {
      console.log( result )
      if (result==true){
        this.navigate();
      }else{
        alert("Username or password is not valid!")
      }
    })
  }

  navigate(){
    this.routes.navigate(['/return-book'])
  }

}
