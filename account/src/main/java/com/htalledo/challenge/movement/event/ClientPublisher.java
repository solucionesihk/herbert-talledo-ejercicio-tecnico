package com.htalledo.challenge.movement.event;

import com.htalledo.challenge.movement.config.RabbitMQConfig;
import com.htalledo.challenge.movement.dto.request.AccountRequest;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class ClientPublisher {

    private final RabbitTemplate rabbitTemplate;

    public ClientPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendClientMessage(AccountRequest accountRequest) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY, accountRequest);
    }

}
