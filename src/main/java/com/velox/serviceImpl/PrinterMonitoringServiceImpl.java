package com.velox.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.velox.dto.PrinterMonitoringDTO;
import com.velox.model.PrinterMonitoring;
import com.velox.repository.PrinterMonitoringRepository;
import com.velox.service.PrinterMonitoringService;

import java.util.ArrayList;
import java.util.List;

@Service
public class PrinterMonitoringServiceImpl implements PrinterMonitoringService {
    
    @Autowired
    private PrinterMonitoringRepository printerMonitoringRepository;
    
    @Override
    public List<PrinterMonitoringDTO> getRecordsByAllowPrevent(String allowPrevent) {
        // Get records where ALLOW_PREVENT matches
        List<PrinterMonitoring> entities = printerMonitoringRepository.findByAllowPreventIgnoreCase(allowPrevent);
        
        // Convert to DTO (only 4 fields)
        List<PrinterMonitoringDTO> dtos = new ArrayList<>();
        for (PrinterMonitoring entity : entities) {
            PrinterMonitoringDTO dto = new PrinterMonitoringDTO();
            dto.setSrNo(entity.getSrNo());
            dto.setAllowPrevent(entity.getAllowPrevent());
            dto.setBranch(entity.getBranch());
            dto.setIpAddress(entity.getIpAddress());
            dtos.add(dto);
        }
        
        return dtos;
    }
    
    @Override
    public List<PrinterMonitoringDTO> getAllRecords() {
        // Get all records
        List<PrinterMonitoring> entities = printerMonitoringRepository.findAll();
        
        // Convert to DTO (only 4 fields)
        List<PrinterMonitoringDTO> dtos = new ArrayList<>();
        for (PrinterMonitoring entity : entities) {
            PrinterMonitoringDTO dto = new PrinterMonitoringDTO();
            dto.setSrNo(entity.getSrNo());
            dto.setAllowPrevent(entity.getAllowPrevent());
            dto.setBranch(entity.getBranch());
            dto.setIpAddress(entity.getIpAddress());
            dtos.add(dto);
        }
        
        return dtos;
    }
}