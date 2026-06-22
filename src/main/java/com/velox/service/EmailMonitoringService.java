package com.velox.service;

import java.time.LocalDate;
import java.util.List;

import com.velox.dto.EmailModalDto;

public interface EmailMonitoringService {

	public List<EmailModalDto> getEmailData(LocalDate date);
}
