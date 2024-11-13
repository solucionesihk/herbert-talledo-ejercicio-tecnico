package com.htalledo.challenge.account.mapper;

import com.htalledo.challenge.account.dto.MovementDto;
import com.htalledo.challenge.account.entity.MovementEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovementMapper {
    MovementMapper INSTANCE = Mappers.getMapper(MovementMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "date", target = "date")
    @Mapping(source = "movementType", target = "movementType")
    @Mapping(source = "value", target = "value")
    @Mapping(source = "accountEntity.id", target = "accountId")
    MovementDto entityToDto(MovementEntity movementEntity);

    List<MovementDto> entityToDto(List<MovementEntity> movementDto);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "date", target = "date")
    @Mapping(source = "movementType", target = "movementType")
    @Mapping(source = "value", target = "value")
    @Mapping(source = "accountId", target = "accountEntity.id")
    MovementEntity dtoToEntity(MovementDto movementDto);


}
