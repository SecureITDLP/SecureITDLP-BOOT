package com.velox.service;

import com.velox.dto.DailyApplicationCountDto;
import java.util.List;

public interface ApplicationInfoReportService {
    List<DailyApplicationCountDto> getLastSevenDaysCounts();
}
