package com.htalledo.challenge.movement.controller;

import com.htalledo.challenge.movement.dto.ReportDto;
import com.htalledo.challenge.movement.service.ReportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/reportes")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<List<ReportDto>> obtenerReporteCliente(@PathVariable Long clientId,
                                                                 @RequestParam String fechaInicial,
                                                                 @RequestParam String fechaFinal) throws ParseException {

        var report = reportService.getReportByClientIdAndDate(clientId, formatDate(fechaInicial), formatDate(fechaFinal));
        return ResponseEntity.ok(report);
    }

    private static Date formatDate(String date) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd").parse(date);
    }
}

