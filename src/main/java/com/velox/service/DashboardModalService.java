package com.velox.service;

import java.time.LocalDate;
import java.util.List;
import com.velox.dto.DashboardModalDto;
import com.velox.dto.EmailModalDto;

public interface DashboardModalService {

    List<DashboardModalDto> getDashboardData(String extension);

	List<EmailModalDto> getEmailData(String date);

}