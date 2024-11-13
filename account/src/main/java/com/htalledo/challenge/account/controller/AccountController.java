package com.htalledo.challenge.account.controller;

import com.htalledo.challenge.account.dto.AccountDto;
import com.htalledo.challenge.account.dto.request.AccountRequest;
import com.htalledo.challenge.account.event.ClientPublisher;
import com.htalledo.challenge.account.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cuentas")
public class AccountController {

    private final AccountService accountService;
    private final ClientPublisher clientPublisher;

    public AccountController(AccountService accountService, ClientPublisher clientPublisher) {
        this.accountService = accountService;
        this.clientPublisher = clientPublisher;
    }

    @PostMapping
    public ResponseEntity<AccountDto> crearCuenta(@Validated @RequestBody AccountRequest accountRequest) throws Exception {
        AccountDto newAccount = accountService.createAccount(accountRequest.getAccount());
        //envío de client a la cola rabbit
        clientPublisher.sendClientMessage(accountRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(newAccount);
    }

    @GetMapping("/{accountNumber}")
    public ResponseEntity<AccountDto> obtenerCuenta(@PathVariable String accountNumber) {
        AccountDto accountDto = accountService.getAccountByNumber(accountNumber);
        return ResponseEntity.ok(accountDto);
    }

    @PutMapping("/{accountNumber}")
    public ResponseEntity<AccountDto> actualizarCuenta(@PathVariable String accountNumber, @RequestBody AccountDto accountDto) {
        AccountDto accountUpdated = accountService.updateAccount(accountNumber, accountDto);
        return ResponseEntity.ok(accountUpdated);
    }

    @DeleteMapping("/numero/{accountNumber}")
    public ResponseEntity<Object> eliminarCuenta(@PathVariable String accountNumber) {
        try{
            accountService.deleteAccountByNumber(accountNumber);
        }
        catch(Exception e){
            return ResponseEntity.internalServerError().body("Ocurrió un error: " + e.getMessage());
        }
        return ResponseEntity.ok().body("Cuenta eliminada por numero");
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Object> eliminarCuenta(@PathVariable Long id) {
        try {
            accountService.deleteAccountById(id);
        }
        catch(Exception e){
            return ResponseEntity.internalServerError().body("Ocurrió un error: " + e.getMessage());
        }
        return ResponseEntity.ok().body("Cuenta eliminada por id");
    }
}
