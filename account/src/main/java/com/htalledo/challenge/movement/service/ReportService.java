package com.htalledo.challenge.movement.service;

import com.htalledo.challenge.movement.dto.ReportDto;

import java.util.Date;
import java.util.List;

public interface ReportService {
    List<ReportDto> getReportByClientIdAndDate(Long accountId, Date startDate, Date endDate);

}
