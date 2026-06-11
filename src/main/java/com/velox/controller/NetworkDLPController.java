package com.velox.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.velox.dto.EventTypeCountDto;
import com.velox.service.NetworkDlpService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@CrossOrigin("*")
@RequestMapping("/SecureIT/NetworkDLP")
public class NetworkDLPController {

    @Autowired
    private NetworkDlpService service;

    @GetMapping("/event-counts")
    public ResponseEntity<List<EventTypeCountDto>> getEventTypeCounts() {
        List<EventTypeCountDto> counts = service.getEventTypeCounts();
        return ResponseEntity.ok(counts);
    }
}
