import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserAuthService {

  constructor() { }

  // public setRoles(roles: []){
  //   localStorage.setItem("roles", JSON.stringify(roles));
  // }

  // public getRoles(): any[]{
  //   const item = localStorage.getItem("roles");
  //     return item ? JSON.parse(item) : []; 
  // }

  // public setToken(jwtToken: string){
  //   localStorage.setItem("jwtToken", jwtToken);
  // }

  // public getToken() {
  //   return localStorage.getItem("jwtToken");
  // }

  // public logout(){
  //   localStorage.clear();
  // }

  // public isLoggedIn() {
  //   return this.getRoles() && this.getToken();
  // }

  








  public loginUser(token: string, user: any) {
    localStorage.setItem('token', token);
    localStorage.setItem('user' , JSON.stringify(user));
    return true;
  }

  public isUserLoggedIn() {
    let tokenStr = localStorage.getItem('token');
    if(tokenStr == undefined || tokenStr == '' || tokenStr == null){
      this.logoutUser();
      return false;
    }
    return true;
  }

  public logoutUser() {
    localStorage.removeItem('token');
    localStorage.removeItem('user');
    return true;
  }

  public getUserToken(){
    return localStorage.getItem("token");
  }
  
  public getUser(){
    let userStr = localStorage.getItem('user');
    if(userStr != null){
      return JSON.parse(userStr);
    }
    else{
      this.logoutUser();
      return null;
    }    
  }

  public getUserRole() {
    let user = this.getUser();
    return user?.authorities[0].authority;   
  }

}
