package com.htalledo.challenge.client.service.impl;

import com.htalledo.challenge.client.dto.ClientDto;
import com.htalledo.challenge.client.exception.ResourceNotFoundException;
import com.htalledo.challenge.client.mapper.ClientMapper;
import com.htalledo.challenge.client.model.ClientEntity;
import com.htalledo.challenge.client.repository.ClientRepository;
import com.htalledo.challenge.client.service.ClientService;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientMapper mapper;
    private final ClientRepository clientRepository;
    
    public ClientServiceImpl(ClientMapper mapper, ClientRepository clientRepository) {
        this.mapper = mapper;
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientDto createClient(ClientDto clientDto) {
        return mapper.entityToDto(clientRepository.save(mapper.dtoToEntity(clientDto)));
    }

    @Override
    public ClientDto getClient(Long id) {
        return mapper.entityToDto(verifyClientById(id));
    }

    @Override
    public ClientDto updateClient(Long id, ClientDto clientDto) {
        ClientEntity clientEntity = verifyClientById(id);
        validateDtoAndSetEntity(clientEntity, clientDto);
        return mapper.entityToDto(clientRepository.save(clientEntity));
    }

    @Override
    public void deleteClient(Long id) {
        ClientEntity clientEntity = verifyClientById(id);
        clientRepository.delete(clientEntity);
    }

    private ClientEntity verifyClientById(Long id){
        return clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado"));
    }

    private void validateDtoAndSetEntity(ClientEntity clientEntity, ClientDto clientDto){
        if(Objects.nonNull(clientDto.getName())){
            clientEntity.setName(clientDto.getName());
        }
        if(Objects.nonNull(clientDto.getGender())){
            clientEntity.setGender(clientDto.getGender());
        }
        if(Objects.nonNull(clientDto.getAge())){
            clientEntity.setAge(clientDto.getAge());
        }
        if(Objects.nonNull(clientDto.getAddress())){
            clientEntity.setAddress(clientDto.getAddress());
        }
        if(Objects.nonNull(clientDto.getPhone())){
            clientEntity.setPhone(clientDto.getPhone());
        }
        if(Objects.nonNull(clientDto.getPassword())){
            clientEntity.setPassword(clientDto.getPassword());
        }
        if(Objects.nonNull(clientDto.getStatus())){
            clientEntity.setStatus(clientDto.getStatus());
        }
    }
}
