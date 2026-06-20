package com.velox.serviceImpl;

import com.velox.repository.MonitoringFolderRepository;
import com.velox.service.MonitoringFolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MonitoringFolderServiceImpl implements MonitoringFolderService {

    @Autowired
    private MonitoringFolderRepository repository;

    @Override
    public long getTotalCount() {
        return repository.count();
    }
}
