package com.project.ecommerce.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ecommerce.dtos.ProductDto;
import com.project.ecommerce.entities.Product;
import com.project.ecommerce.mappers.ProductMapper;
import com.project.ecommerce.repositories.ProductRepository;
import com.project.ecommerce.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductMapper productMapper;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public ProductDto addProduct(ProductDto productDto) {
		Product entity =  this.productMapper.toEntity(productDto);
		entity = this.productRepository.save(entity);
		return this.productMapper.toDto(entity);
	}
	

}
