package com.htalledo.challenge.client.mapper;

import com.htalledo.challenge.client.dto.ClientDto;
import com.htalledo.challenge.client.model.ClientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    ClientDto entityToDto(ClientEntity entity);
    ClientEntity dtoToEntity(ClientDto dto);

}