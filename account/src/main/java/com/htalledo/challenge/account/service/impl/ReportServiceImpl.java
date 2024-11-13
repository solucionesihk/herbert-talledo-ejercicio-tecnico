package com.htalledo.challenge.account.service.impl;

import com.htalledo.challenge.account.dto.ReportDto;
import com.htalledo.challenge.account.service.AccountService;
import com.htalledo.challenge.account.service.ClientService;
import com.htalledo.challenge.account.service.MovementService;
import com.htalledo.challenge.account.service.ReportService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportServiceImpl implements ReportService {

    private final AccountService accountService;
    private final ClientService clientService;
    private final MovementService movementService;

    public ReportServiceImpl(AccountService accountService, ClientService clientService, MovementService movementService) {
        this.accountService = accountService;
        this.clientService = clientService;
        this.movementService = movementService;
    }

    @Override
    public List<ReportDto> getReportByClientIdAndDate(Long clientId, Date startDate, Date endDate) {
        var accountDto = accountService.getAccountsByClientId(clientId);
        var clientDto = clientService.getClientById(clientId);

        List<ReportDto> reports = accountDto.stream()
                .flatMap(a -> {
                    var movements = movementService.getMovementsByAccountIdAndDate(a.getId(), startDate, endDate);
                    return movements.stream().map(m -> {
                        ReportDto reportDto = new ReportDto();
                        reportDto.setDate(m.getDate());
                        reportDto.setClient(clientDto.getName());
                        reportDto.setAccountNumber(a.getAccountNumber());
                        reportDto.setAccountType(a.getAccountType());
                        reportDto.setInitialBalance(a.getInitialBalance());
                        reportDto.setStatus(a.getStatus());
                        reportDto.setMovement(m.getValue());
                        reportDto.setAvailableBalance(m.getValue() + a.getInitialBalance());
                        return reportDto;
                    });
                })
                .collect(Collectors.toList());

        return reports;

    }
}
