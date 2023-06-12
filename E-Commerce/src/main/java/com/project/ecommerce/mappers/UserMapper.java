package com.project.ecommerce.mappers;

import org.mapstruct.Mapper;

import com.project.ecommerce.dtos.UserDto;
import com.project.ecommerce.entities.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
	
	UserDto toUserDto(User user);
	
	User toUserEntity(UserDto userDto);
}
