import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';
import { UserAuthService } from '../services/user-auth.service';

export const authGuard: CanActivateFn = (route, state) => {
  
  const userAuthService = inject(UserAuthService);
  const router = inject(Router);

  //  if(userAuthService.getToken != null){
  //   const role = route.data["roles"] as Array<string>;
    

  //   if(role && role!=null){
  //     let match = userService.roleMatch(role);
  //     if(match){
  //       return true;
  //     }
  //     else{
  //       router.navigate(['/error']);
  //       return false;
  //     }
  //   }
  //  }


  if(userAuthService.isUserLoggedIn()) {
    
    const role = route.data["roles"] as Array<string>;
    console.log("role "+role);
    
    
    if(role && role!=null) {
      let userRole = userAuthService.getUserRole();
      console.log("userRole "+ userRole);
      
      if (userRole && role.includes(userRole)) {
        return true;
      }
      else{
        router.navigate(['/error']);
        return false;
      }
      
    }
  }
  
  router.navigate(['/login']);
  return false;  

};
