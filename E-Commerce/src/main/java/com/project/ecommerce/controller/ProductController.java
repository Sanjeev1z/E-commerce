package com.project.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.ecommerce.dtos.ProductDto;
import com.project.ecommerce.service.ProductService;

@RestController
@RequestMapping("api/product")
public class ProductController {

	@Autowired 
	private ProductService productService;
	
	@PostMapping("/add")
	@PreAuthorize("hasRole('Admin')")
	public ProductDto addProduct(@RequestBody ProductDto productDto) {
		return this.productService.addProduct(productDto);
	}
}
