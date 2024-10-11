package com.example.demo.mapper;

import com.example.demo.dto.UserDto;
import com.example.demo.dto.UserEditDto;
import com.example.demo.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "Spring")
public interface UserMapper {

    //Mapeando Dto para Entidade
    @Mapping(target = "id", ignore = true) // Ignora o campo id
    User toEntity(UserDto userDto);

    //Mapeando entidade para DTO
    UserDto toDto(User user);

    UserEditDto toEditDto(User user);
}
