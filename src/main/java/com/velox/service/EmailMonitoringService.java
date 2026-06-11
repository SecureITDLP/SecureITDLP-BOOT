package com.velox.service;

import com.velox.repository.EmailMonitoringRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailMonitoringService {

    @Autowired
    private EmailMonitoringRepository repository;

    public long getTotalEmailCount() {
        return repository.count();
    }
}
