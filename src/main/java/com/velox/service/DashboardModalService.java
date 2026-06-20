package com.velox.service;

import java.util.List;
import com.velox.dto.DashboardModalDto;

public interface DashboardModalService {

    List<DashboardModalDto> getDashboardData(String extension);

}