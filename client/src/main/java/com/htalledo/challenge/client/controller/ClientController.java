package com.htalledo.challenge.client.controller;

import com.htalledo.challenge.client.dto.ClientDto;
import com.htalledo.challenge.client.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<ClientDto> crearCliente(@Validated @RequestBody ClientDto clientDto) {
        ClientDto newClient = clientService.createClient(clientDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(newClient);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDto> obtenerCliente(@PathVariable Long id) {
        ClientDto client = clientService.getClient(id);
        return ResponseEntity.ok(client);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientDto> actualizarCliente(@PathVariable Long id, @RequestBody ClientDto clientDto) {
        ClientDto updatedClient = clientService.updateClient(id, clientDto);
        return ResponseEntity.ok(updatedClient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminarCliente(@PathVariable Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.ok().body("Cliente eliminado por id");
    }
}
