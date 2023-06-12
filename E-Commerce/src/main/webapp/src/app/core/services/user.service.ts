import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { enviroment } from 'src/enviroments/enviroment';
import { UserAuthService } from './user-auth.service';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(
    private httpClient: HttpClient,
    ) { }

  private readonly API_URL = enviroment.api; 

  requestHeader = new HttpHeaders(
    {"No-Auth":"True"}
  )

  public login(loginData: any) {
    const url = this.getUrl(this.API_URL.createJwtToken);
    return this.httpClient.post(url,loginData,{headers: this.requestHeader});
  }

  public signUp(signUpData: any){
    const url = this.getUrl(this.API_URL.signUp)
    return this.httpClient.post(url, signUpData, {headers: this.requestHeader})
  }

  private getUrl(suffix: string): string {
    return this.API_URL.baseURL + suffix;
  }

}