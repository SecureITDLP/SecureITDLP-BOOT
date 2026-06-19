package com.velox.controller;

import com.velox.dto.DailyApplicationCountDto;
import com.velox.service.ApplicationInfoReportService;
import com.velox.utils.ApiResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/SecureIT/application-info")
public class ApplicationInfoReportController {

    @Autowired
    private ApplicationInfoReportService service;

    @GetMapping("/last7daysapplicationinfo-counts")
    public ResponseEntity<ApiResponse<List<DailyApplicationCountDto>>> getLastSevenDaysCounts() {
        System.out.println("ApplicationInfoReportController.getLastSevenDaysCounts() called");
        try {
            List<DailyApplicationCountDto> result = service.getLastSevenDaysCounts();
            System.out.println("Fetched " + result.size() + " daily counts");
            ApiResponse<List<DailyApplicationCountDto>> response = new ApiResponse<>(
                true,
                "FETCH_SUCCESS",
                "Last 7 days counts fetched successfully",
                LocalDateTime.now(),
                result
            );
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
            ApiResponse<List<DailyApplicationCountDto>> errorResponse = new ApiResponse<>(
                false,
                "FETCH_FAILED",
                e.getMessage(),
                LocalDateTime.now(),
                null
            );
            // Use HTTP 500, not -1 (that's invalid)
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }
}
