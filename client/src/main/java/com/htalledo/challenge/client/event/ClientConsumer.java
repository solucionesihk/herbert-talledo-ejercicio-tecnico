package com.htalledo.challenge.client.event;

import com.htalledo.challenge.client.config.RabbitMQConfig;
import com.htalledo.challenge.client.dto.request.AccountRequest;
import com.htalledo.challenge.client.service.ClientService;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Log4j2
public class ClientConsumer {

    private final ClientService clientService;
    private final AccountPublisher accountPublisher;

    public ClientConsumer(ClientService clientService, AccountPublisher accountPublisher) {
        this.clientService = clientService;
        this.accountPublisher = accountPublisher;
    }

    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void receiveAccountClientCreationMessage(AccountRequest accountRequest) {
        // Lógica para crear la cuenta en base a los datos recibidos
        log.info("Mensaje recibido para crear cuenta de cliente: {}", accountRequest.getClientId());

        // Implementa la lógica de creación de cuenta usando los datos de id
        if(Objects.nonNull(clientService.getClient(accountRequest.getClientId()))){
            accountPublisher.sendClientMessage(accountRequest);
        }
        else{
            log.info("Cliente no encontrado: {}", accountRequest.getClientId());
        }
    }
}
