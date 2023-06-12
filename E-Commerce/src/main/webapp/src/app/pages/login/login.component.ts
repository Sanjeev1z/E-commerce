import { Component, OnInit } from '@angular/core';
import { UserService } from '../../core/services/user.service';
import { UserAuthService } from '../../core/services/user-auth.service';
import { Router } from '@angular/router';
import { FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{

  loginForm = this.fb.group({
    username: ['', Validators.required],
    password: ['', Validators.required],
  })
  constructor(
    private userService: UserService,
    private userAuthService: UserAuthService,
    private router: Router,
    private fb: FormBuilder,
    ){}

  ngOnInit(): void {
  }

  submitForm(){
    if (this.loginForm.valid) {
      console.log(this.loginForm.value);
      
      if(this.loginForm.value.username === null || this.loginForm.value.username === undefined || this.loginForm.value.username.trim() == '' ){
        alert("username not valid")
        
      }
      this.loginUser(this.loginForm.value);
    }
  }

  loginUser(data: any) {

    this.userService.login(data).subscribe({
      next: (data:any) => {
        
        this.userAuthService.loginUser(data.jwtToken,data.user);
        const role = this.userAuthService.getUserRole();

        if(role == 'Admin'){
          this.router.navigate(['/admin']);
        }        
        else if(role == 'User'){
          this.router.navigate(['/user']);
        }
        else() => {
          this.userAuthService.logoutUser();
          this.router.navigate(['/error']);
        }
      },
      error: (err) => {
        console.log(err);        
      },
      complete: () => console.info('complete')
    });
  }

}

  
  // login(data: any){
  
  //   console.log(data);
    
  //   this.userService.login(data).subscribe({
  //     next: (data:any) => {
        
  //       this.userAuthService.setToken(data.jwtToken);
  //       this.userAuthService.setRoles(data.user.role);

  //       const role = data.user.role[0].roleName;
  //       if(role == 'Admin'){
  //         this.router.navigate(['/admin']);
  //       }        
  //       else if(role == 'User'){
  //         this.router.navigate(['/user']);
  //       }
  //       else() => {
  //         this.router.navigate(['/error']);
  //       }
  //     },
  //     error: (err) => {
  //       console.log(err);        
  //     },
  //     complete: () => console.info('complete')
  //   }); 
    
  // }









