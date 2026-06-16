package com.velox.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.velox.repository.PrinterLogRepository;
import com.velox.service.PrinterDLPService;

@Service
public class PrinterDLPServiceImpl implements PrinterDLPService {

    @Autowired
    private PrinterLogRepository repository;

    @Override
    public Long getTotalPrinterLogs() {

        return repository.count();

    }

	@Override
	public String getPeakDayIncident() {
		return (String) repository.getPeakDayIncident();
	}
}