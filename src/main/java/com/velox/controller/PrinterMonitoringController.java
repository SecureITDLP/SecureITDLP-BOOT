package com.velox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.velox.model.PrinterMonitoring;
import com.velox.service.PrinterMonitoringService;

import java.util.List;

@RestController
@RequestMapping("/SecureIT/printermonitoring")
public class PrinterMonitoringController {
    
    @Autowired
    private PrinterMonitoringService printerMonitoringService;
    
    // Endpoint 1: Get ALL records
    @GetMapping("/all")
    public ResponseEntity<List<PrinterMonitoring>> getAllRecords() {
        List<PrinterMonitoring> records = printerMonitoringService.getAllRecords();
        
        if (records.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(records);
    }
    
    // Endpoint 2: Get records where ALLOW_PREVENT = "allow prevent" (hardcoded)
    @GetMapping("/allowpreventrecords")
    public ResponseEntity<List<PrinterMonitoring>> getAllowPreventRecords() {
        List<PrinterMonitoring> records = printerMonitoringService.getRecordsByAllowPrevent("allow prevent");
        
        if (records.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(records);
    }
    
    // Endpoint 3: Get records by dynamic allowPrevent value
    @GetMapping("/byallowprevent")
    public ResponseEntity<List<PrinterMonitoring>> getRecordsByAllowPrevent(
            @RequestParam String allowPrevent) {
        
        List<PrinterMonitoring> records = printerMonitoringService.getRecordsByAllowPrevent(allowPrevent);
        
        if (records.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(records);
    }
    
    // Endpoint 4: Combined - Get ALL or filtered by allowPrevent
    @GetMapping("/records")
    public ResponseEntity<List<PrinterMonitoring>> getRecords(
            @RequestParam(required = false) String allowPrevent) {
        
        List<PrinterMonitoring> records;
        
        if (allowPrevent != null && !allowPrevent.isEmpty()) {
            // If allowPrevent parameter is provided, filter by it
            records = printerMonitoringService.getRecordsByAllowPrevent(allowPrevent);
        } else {
            // If no parameter, return ALL records
            records = printerMonitoringService.getAllRecords();
        }
        
        if (records.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(records);
    }
}