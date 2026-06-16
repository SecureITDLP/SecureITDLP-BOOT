package com.velox.controller;

import com.velox.service.PrinterDLPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/SecureIT/PrinterDLP")
public class PrinterDLPController {

    @Autowired
    private PrinterDLPService service;

    @GetMapping("/printerIncidentcount")
    public ResponseEntity<?> getPrinterDetails() {

        System.out.println("INFO: Received request to fetch printer details");

        try {

            Long totalCount = service.getTotalPrinterLogs();
            String peakDay = service.getPeakDayIncident();

            System.out.println("SUCCESS: Total printer log records = " + totalCount);
            System.out.println("SUCCESS: Peak Day = " + peakDay);

            Map<String, Object> response = new HashMap<>();
            response.put("status", "success");
            response.put("totalCount", totalCount);
            response.put("peakDay", peakDay);

            return ResponseEntity.ok(response);
        } catch (Exception e) {

            System.err.println("ERROR: Failed to fetch printer details - " + e.getMessage());
            e.printStackTrace();

            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("status", "error");
            errorResponse.put("message", "Unable to retrieve printer details. Please try again later.");

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(errorResponse);
        }
    }
}