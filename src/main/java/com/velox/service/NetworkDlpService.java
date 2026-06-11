package com.velox.service;

import com.velox.dto.EventTypeCountDto;
import com.velox.repository.NetworkDlpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NetworkDlpService {

    @Autowired
    private NetworkDlpRepository repository;

    public List<EventTypeCountDto> getEventTypeCounts() {
        return repository.countEventsByEventType();
    }
}
