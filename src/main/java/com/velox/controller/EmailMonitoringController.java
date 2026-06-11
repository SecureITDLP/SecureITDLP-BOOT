package com.velox.controller;

import com.velox.service.EmailMonitoringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/SecureIT/email-monitoring")
public class EmailMonitoringController {

    @Autowired
    private EmailMonitoringService service;

    @GetMapping("/count")
    public ResponseEntity<?> getTotalEmailCount() {
        System.out.println("INFO: Received request to fetch total email monitoring count");
        try {
            long count = service.getTotalEmailCount();
            System.out.println("SUCCESS: Total email monitoring records = " + count);
            
            Map<String, Object> response = new HashMap<>();
            response.put("status", "success");
            response.put("totalCount", count);
            return ResponseEntity.ok(response);
            
        } catch (Exception e) {
            System.err.println("ERROR: Failed to fetch email monitoring count - " + e.getMessage());
            e.printStackTrace();
            
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("status", "error");
            errorResponse.put("message", "Unable to retrieve email count. Please try again later.");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }
}
