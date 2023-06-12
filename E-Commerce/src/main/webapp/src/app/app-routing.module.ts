import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserComponent } from './pages/user/user.component';
import { LoginComponent } from './pages/login/login.component';
import { ErrorComponent } from './components/error/error.component';
import { AdminComponent } from './pages/admin/admin.component';
import { authGuard } from './core/auth/auth.guard';
import { SignupComponent } from './pages/signup/signup.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { ProductComponent } from './pages/product/product.component';

const routes: Routes = [
  { 
    path: 'dashboard',
    component: DashboardComponent
  },
  { 
    path: 'admin',
    component: AdminComponent,
    pathMatch: 'full',
    canActivate:[authGuard],
    data:{roles:['Admin']}
  },
  
  {
    path: 'user',
    component: UserComponent, 
    pathMatch: 'full',
    canActivate:[authGuard],
    data:{roles:['User']}
  },
  { 
    path: 'login', 
    component: LoginComponent 
  },
  { 
    path: 'signup', 
    component: SignupComponent
  },
  {
    path: 'addNewProduct',
    component: ProductComponent
  },
  {
    path: 'error',
    component: ErrorComponent 
  },
  {
    path: '',
    redirectTo: '/dashboard',
    pathMatch: 'full',
  },
  {
    path: '**',
    redirectTo: '/dashboard',
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
