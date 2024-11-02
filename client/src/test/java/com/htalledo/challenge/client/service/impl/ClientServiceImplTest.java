package com.htalledo.challenge.client.service.impl;

import com.htalledo.challenge.client.dto.ClientDto;
import com.htalledo.challenge.client.mapper.ClientMapper;
import com.htalledo.challenge.client.model.ClientEntity;
import com.htalledo.challenge.client.repository.ClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

class ClientServiceImplTest {

    @Mock
    ClientMapper mapper;

    @Mock
    ClientRepository clientRepository;

    @InjectMocks
    ClientServiceImpl service;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        service = new ClientServiceImpl(mapper, clientRepository);
    }

    @Test
    void createClientTest() {

        when(mapper.dtoToEntity(buildClientDto()))
                .thenReturn(buildClientEntity());
        when(clientRepository.save(buildClientEntity()))
                .thenReturn(buildClientEntity());
        when(mapper.entityToDto(buildClientEntity()))
                .thenReturn(buildClientDto());
        var dto = service.createClient(buildClientDto());
        assertNull(dto);
    }

    private static ClientDto buildClientDto(){
        ClientDto clientDto = new ClientDto();
        clientDto.setPassword("test");
        clientDto.setStatus(true);
        return clientDto;
    }

    private static ClientEntity buildClientEntity(){
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setGender("male");
        clientEntity.setStatus(true);
        return clientEntity;
    }
}