package com.project.ecommerce.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "roles")
@Data
public class Role {
	
	@Id
	private String roleName;
	
	private String roleDescription;
}