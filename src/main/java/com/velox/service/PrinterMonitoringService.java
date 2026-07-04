package com.velox.service;

import com.velox.dto.PrinterMonitoringDTO;
import java.util.List;

public interface PrinterMonitoringService {
    List<PrinterMonitoringDTO> getRecordsByAllowPrevent(String allowPrevent);
    List<PrinterMonitoringDTO> getAllRecords();
}