package com.htalledo.challenge.client.controller;

import com.htalledo.challenge.client.dto.ClientDto;
import com.htalledo.challenge.client.service.ClientService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class ClientControllerTest {

    @Mock
    ClientService clientService;

    @InjectMocks
    ClientController clientController;

    @Test
    public void testCrearCliente() throws Exception {

        ClientDto clientDto = new ClientDto();
        clientDto.setId(1L);
        clientDto.setName("John");

        when(clientService.createClient(clientDto)).thenReturn(clientDto);

        var dto = clientController.crearCliente(clientDto);
        assertNotNull(dto);
        assertEquals(dto.getBody(), clientDto);
    }

    @Test
    public void testObtenerCliente() throws Exception {
        ClientDto clientDto = new ClientDto();
        clientDto.setId(1L);
        clientDto.setName("John");

        when(clientService.getClient(1L)).thenReturn(clientDto);

        var dto = clientController.obtenerCliente(1L);
        assertNotNull(dto);
        assertEquals(dto.getBody(), clientDto);
    }

    @Test
    public void testActualizarCliente() throws Exception {
        ClientDto clientDto = new ClientDto();
        clientDto.setId(1L);
        clientDto.setName("John");

        when(clientService.updateClient(1L, clientDto)).thenReturn(clientDto);

        var dto = clientController.actualizarCliente(1L, clientDto);
        assertNotNull(dto);
        assertEquals(dto.getBody(), clientDto);
    }

}
