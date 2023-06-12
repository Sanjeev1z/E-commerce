import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { ProductService } from 'src/app/core/services/product.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

                        
productForm = this.fb.group({
  produtName : ['', Validators.required],
  productDescription: ['', Validators.required],
  productDiscountedPrice: ['', Validators.required],
  productActualPrice: ['', Validators.required], 
})

constructor(
  private fb: FormBuilder,
  private productService: ProductService
) { }
  

ngOnInit(): void {

}

submitForm(){
  console.log(this.productForm.value);
  if(this.productForm.valid){
    this.addProduct(this.productForm.value);
  }
}

reset() {
  this.productForm.reset();
}

addProduct(data: any){
  this.productService.addProduct(data).subscribe({
    next: (data) =>{
      console.log(data);      
    },
    error: (error) => {
      console.log(error);      
    },
    complete() {
        console.log("complete");       
    }
  })
}


}
