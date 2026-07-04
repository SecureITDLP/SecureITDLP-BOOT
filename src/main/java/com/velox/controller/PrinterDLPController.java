package com.velox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.velox.dto.PrinterMonitoringDTO;
import com.velox.service.PrinterMonitoringService;

import java.util.List;

@RestController
@RequestMapping("/api/printermonitoring")
public class PrinterDLPController {
    
    @Autowired
    private PrinterMonitoringService printerMonitoringService;
    
    // Get all records where ALLOW_PREVENT = 'Allow'
    @GetMapping("/allowrecords")
    public ResponseEntity<List<PrinterMonitoringDTO>> getAllowRecords() {
        List<PrinterMonitoringDTO> records = printerMonitoringService.getRecordsByAllowPrevent("Allow");
        
        if (records.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(records);
    }
    
    // Get all records
    @GetMapping("/all")
    public ResponseEntity<List<PrinterMonitoringDTO>> getAllRecords() {
        List<PrinterMonitoringDTO> allRecords = printerMonitoringService.getAllRecords();
        
        if (allRecords.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(allRecords);
    }
}