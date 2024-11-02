package com.htalledo.challenge.client.event;

import com.htalledo.challenge.client.config.RabbitMQConfig;
import com.htalledo.challenge.client.dto.request.AccountRequest;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class AccountPublisher {
    private final RabbitTemplate rabbitTemplate;

    public AccountPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendClientMessage(AccountRequest accountRequest) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY, accountRequest);
    }
}
