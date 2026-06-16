package com.velox.serviceImpl;

import com.velox.dto.DailyApplicationCountDto;
import com.velox.repository.ApplicationInfoReportRepository;
import com.velox.service.ApplicationInfoReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApplicationInfoReportServiceImpl implements ApplicationInfoReportService {

    @Autowired
    private ApplicationInfoReportRepository repository;

    @Override
    public List<DailyApplicationCountDto> getLastSevenDaysCounts() {
        List<Object[]> results = repository.getLastSevenDaysPreventedApplicationCounts();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        return results.stream()
            .map(row -> new DailyApplicationCountDto(
                sdf.format((Date) row[0]),   // ✅ Convert Date to String
                ((Number) row[1]).longValue()
            ))
            .collect(Collectors.toList());
    }
}