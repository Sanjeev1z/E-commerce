import { Component, OnInit } from '@angular/core';
import { UserAuthService } from '../../core/services/user-auth.service';
import { Router } from '@angular/router';
import { UserService } from '../../core/services/user.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  isNavbarOpen = false;

  toggleNavbar(): void {
    this.isNavbarOpen = !this.isNavbarOpen;
  }

  ngOnInit(): void { }

  constructor(
    private userAuthService: UserAuthService,
    private router: Router,
  ){}

  public isLoggedIn(){
    // console.log(this.userAuthService.isUserLoggedIn());
    return this.userAuthService.isUserLoggedIn();
  }

  public logout(){
    this.userAuthService.logoutUser();
    this.router.navigate(['/dashboard']);
  }

  public roleMatch(role: any){
    let userRole = this.userAuthService.getUserRole();
    if(userRole){
      return userRole == role ;
    }
    return false;    
  }

  public isAdmin(){ 
    const role = this.userAuthService.getUserRole()
    return role == 'Admin'? true : false; 
  }

}
