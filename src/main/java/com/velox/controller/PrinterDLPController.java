package com.velox.controller;

import com.velox.service.PrinterDLPService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger =LoggerFactory.getLogger(AuthController.class);
	
    
    @GetMapping("/printerIncidentcount")
    public ResponseEntity<?> getPrinterDetails() {

        try {

            Long totalCount = service.getTotalPrinterLogs();
            String peakDay = service.getPeakDayIncident();
            logger.info("Peak Day", peakDay);
            Map<String, Object> response = new HashMap<>();
            response.put("status", "success");
            response.put("totalCount", totalCount);
            response.put("peakDay", peakDay);
            return ResponseEntity.ok(response);
            
        } catch (Exception e) {

            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("status", "error");
            errorResponse.put("message", "Unable to retrieve printer details. Please try again later.");

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR) .body(errorResponse);
        }
    }
}