package com.project.ecommerce.dtos;

import lombok.Data;

@Data
public class ProductDto {

	private String id;
	private String produtName;
	private String productDescription;
	private Double productDiscountedPrice;
	private Double productActualPrice;
	
}
