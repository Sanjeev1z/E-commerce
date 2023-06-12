package com.project.ecommerce.mappers;

import org.mapstruct.Mapper;

import com.project.ecommerce.dtos.ProductDto;
import com.project.ecommerce.entities.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {

	ProductDto toDto(Product product);
	
	Product toEntity(ProductDto productDto);
}
