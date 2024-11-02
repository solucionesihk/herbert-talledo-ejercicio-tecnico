package com.htalledo.challenge.client.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.htalledo.challenge.client.dto.ClientDto;
import com.htalledo.challenge.client.mapper.ClientMapper;
import com.htalledo.challenge.client.model.ClientEntity;
import com.htalledo.challenge.client.repository.ClientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ClientControllerTest {

    @Autowired
    private ClientMapper clientMapper;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ClientRepository clientRepository;

    @Test
    public void testCrearCliente() throws Exception {
        ClientDto clientDto = new ClientDto();
        clientDto.setName("Jose Ramirez");
        clientDto.setPassword("Jose Ramirez");
        clientDto.setStatus(true);

        mockMvc.perform(post("/clientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(clientDto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Jose Ramirez"));
    }

    @Test
    public void testObtenerCliente() throws Exception {
        ClientEntity client = new ClientEntity();
        client.setId(2L);
        client.setName("Jose Ramirez");
        client.setPassword("Jose Ramirez");
        client.setStatus(true);
        client = clientRepository.save(client); // Guardamos el cliente en la base de datos

        mockMvc.perform(get("/clientes/" + client.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Jose Ramirez"));
    }

    @Test
    public void testActualizarCliente() throws Exception {
        ClientDto updatedClientDto = new ClientDto();
        updatedClientDto.setId(2L);
        updatedClientDto.setName("Jackie Smith");

        mockMvc.perform(put("/clientes/" + updatedClientDto.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedClientDto)))
                .andExpect(status().is4xxClientError())
                .andExpect(content().string(""));
    }

    @Test
    public void testEliminarCliente() throws Exception {
        ClientDto client = new ClientDto();
        client.setId(1L);
        mockMvc.perform(delete("/clientes/" + client.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is5xxServerError())
                .andExpect(content().string("Ocurrió un error: Cliente no encontrado"));
    }
}
