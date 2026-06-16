package com.velox.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.velox.repository.ClipboardControlRepository;
import com.velox.service.ClipboardControlService;

@Service
public class ClipboardControlServiceImpl implements ClipboardControlService {

    @Autowired
    private ClipboardControlRepository repository;

    @Override
    public List<Object[]> getTotalClipboardCount() {
        return repository.getLastSevenDaysIncidents();
    }
}