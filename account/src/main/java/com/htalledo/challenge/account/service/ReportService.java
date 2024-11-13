package com.htalledo.challenge.account.service;

import com.htalledo.challenge.account.dto.ReportDto;

import java.util.Date;
import java.util.List;

public interface ReportService {
    List<ReportDto> getReportByClientIdAndDate(Long accountId, Date startDate, Date endDate);

}
