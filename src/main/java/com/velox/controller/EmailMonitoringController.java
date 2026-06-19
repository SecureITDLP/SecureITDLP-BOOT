package com.velox.controller;

import com.velox.service.EmailMonitoringService;
import com.velox.utils.ApiResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/SecureIT/email-monitoring")
public class EmailMonitoringController {

    @Autowired
    private EmailMonitoringService service;

    @GetMapping("/emailwisecount")
    public ResponseEntity<ApiResponse<List<Object[]>>> getTotalEmailCount() {

        System.out.println("INFO: Received request to fetch total email monitoring count");

        try {
            List<Object[]> emailData = service.getTotalEmailCount();

            System.out.println("SUCCESS: Total email monitoring records = " + emailData);

            ApiResponse<List<Object[]>> response = new ApiResponse<>(
                true,
                "FETCH_SUCCESS",
                "Email monitoring count fetched successfully",
                LocalDateTime.now(),
                emailData
            );

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            System.err.println("ERROR: Failed to fetch email monitoring count - " + e.getMessage());
            e.printStackTrace();

            ApiResponse<List<Object[]>> errorResponse = new ApiResponse<>(
                false,
                "FETCH_FAILED",
                "Unable to retrieve email count. Please try again later.",
                LocalDateTime.now(),
                null
            );

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(errorResponse);
        }
    }
}
