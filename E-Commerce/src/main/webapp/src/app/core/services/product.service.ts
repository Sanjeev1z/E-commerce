import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { enviroment } from 'src/enviroments/enviroment';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private httpClient: HttpClient) {}

  private readonly API_URL = enviroment.api;

  addProduct(product: any){
    const url = this.getUrl(this.API_URL.addNewProduct);
    return this.httpClient.post(url,product);
  }

  getUrl(suffix: string){
    return this.API_URL.baseURL + suffix;
  }

}
