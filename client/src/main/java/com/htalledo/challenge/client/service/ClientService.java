package com.htalledo.challenge.client.service;

import com.htalledo.challenge.client.dto.ClientDto;

public interface ClientService {
    ClientDto createClient(ClientDto clientDto);

    ClientDto getClient(Long id);

    ClientDto updateClient(Long id, ClientDto clientDto);

    void deleteClient(Long id);
}
