package com.velox.controller;

import com.velox.dto.DailyApplicationCountDto;
import com.velox.service.ApplicationInfoReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/SecureIT/application-info")
public class ApplicationInfoReportController {

    @Autowired
    private ApplicationInfoReportService service;

    @GetMapping("/last7days-counts")
    public ResponseEntity<List<DailyApplicationCountDto>> getLastSevenDaysCounts() {
        System.out.println("ApplicationInfoReportController.getLastSevenDaysCounts() called");
        try {
            List<DailyApplicationCountDto> result = service.getLastSevenDaysCounts();
            System.out.println("Fetched " + result.size() + " daily counts");
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
