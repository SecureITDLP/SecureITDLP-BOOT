package com.velox.service;

import java.util.List;

import com.velox.model.PrinterMonitoring;

public interface PrinterMonitoringService {
    // Get all records
    List<PrinterMonitoring> getAllRecords();
    
    // Get records by allow prevent
    List<PrinterMonitoring> getRecordsByAllowPrevent(String allowPrevent);
}