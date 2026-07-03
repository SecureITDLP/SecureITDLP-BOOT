package com.velox.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.velox.model.PrinterMonitoring;
import com.velox.repository.PrinterMonitoringRepository;
import com.velox.service.PrinterMonitoringService;

import java.util.List;

@Service
public class PrinterMonitoringServiceImpl implements PrinterMonitoringService {
    
    @Autowired
    private PrinterMonitoringRepository printerMonitoringRepository;
    
    @Override
    public List<PrinterMonitoring> getAllRecords() {
        return printerMonitoringRepository.findAll();
    }
    
    @Override
    public List<PrinterMonitoring> getRecordsByAllowPrevent(String allowPrevent) {
        return printerMonitoringRepository.findByAllowPrevent(allowPrevent);
    }
}