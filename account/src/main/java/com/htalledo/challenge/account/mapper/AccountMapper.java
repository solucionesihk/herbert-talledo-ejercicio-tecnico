package com.htalledo.challenge.account.mapper;

import com.htalledo.challenge.account.dto.AccountDto;
import com.htalledo.challenge.account.entity.AccountEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "accountNumber", target = "accountNumber")
    @Mapping(source = "accountType", target = "accountType")
    @Mapping(source = "initialBalance", target = "initialBalance")
    @Mapping(source = "availableBalance", target = "availableBalance")
    @Mapping(source = "status", target = "status")
    AccountDto entityToDto(AccountEntity accountEntity);

    List<AccountDto> entityToDto(List<AccountEntity> accountDto);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "accountNumber", target = "accountNumber")
    @Mapping(source = "accountType", target = "accountType")
    @Mapping(source = "initialBalance", target = "initialBalance")
    @Mapping(source = "availableBalance", target = "availableBalance")
    @Mapping(source = "status", target = "status")
    @Mapping(target = "movements", ignore = true)
    AccountEntity dtoToEntity(AccountDto accountDto);
}