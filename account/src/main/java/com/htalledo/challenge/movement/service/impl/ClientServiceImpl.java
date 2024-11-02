package com.htalledo.challenge.movement.service.impl;

import com.htalledo.challenge.movement.dto.ClientDto;
import com.htalledo.challenge.movement.service.ClientService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ClientServiceImpl implements ClientService {

    private final RestTemplate restTemplate;

    public ClientServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public ClientDto getClientById(Long id) {
        return restTemplate.getForObject("http://client-service:8080/clientes/" + id, ClientDto.class);
    }
}
