package com.htalledo.challenge.account.event;

import com.htalledo.challenge.account.config.RabbitMQConfig;
import com.htalledo.challenge.account.dto.AccountDto;
import com.htalledo.challenge.account.dto.request.AccountRequest;
import com.htalledo.challenge.account.service.AccountService;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class AccountConsumer {

    private final AccountService accountService;

    public AccountConsumer(AccountService accountService) {
        this.accountService = accountService;
    }

    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void receiveAccountClientCreationMessage(AccountRequest accountRequest) {
        // Lógica para crear la cuenta en base a los datos recibidos
        log.info("Mensaje recibido para crear cuenta de cliente: {}", accountRequest.getClientId());

        // Implementa la lógica de creación de cuenta usando los datos de id
        AccountDto accountDto = new AccountDto();
        accountDto.setClientId(accountRequest.getClientId());
        accountService.updateAccount(accountRequest.getAccount().getAccountNumber(), accountDto);
    }
}
