package com.velox.controller;

import com.velox.service.PrinterDLPService;
import com.velox.utils.ApiResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/SecureIT/PrinterDLP")
public class PrinterDLPController {

    @Autowired
    private PrinterDLPService service;

    private static final Logger logger =LoggerFactory.getLogger(AuthController.class);
	
    
    @GetMapping("/printerIncidentcount")
    public ResponseEntity<ApiResponse<Map<String, Object>>> getPrinterDetails() {
        try {
            Long totalCount = service.getTotalPrinterLogs();
            String peakDay = service.getPeakDayIncident();
            // Fix logger: use placeholder
            logger.info("Peak Day: {}", peakDay);

            Map<String, Object> data = new HashMap<>();
            data.put("totalCount", totalCount);
            data.put("peakDay", peakDay);

            ApiResponse<Map<String, Object>> response = new ApiResponse<>(
                true,
                "FETCH_SUCCESS",
                "Printer incident details fetched successfully",
                LocalDateTime.now(),
                data
            );
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            logger.error("Error fetching printer incident details", e);
            ApiResponse<Map<String, Object>> errorResponse = new ApiResponse<>(
                false,
                "FETCH_FAILED",
                "Unable to retrieve printer details. Please try again later.",
                LocalDateTime.now(),
                null
            );
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }
}