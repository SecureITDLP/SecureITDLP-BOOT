package com.velox.controller;

import com.velox.service.MonitoringFolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/SecureIT/monitoring")
public class MonitoringFolderController {

    @Autowired
    private MonitoringFolderService service;

    @GetMapping("/count")
    public ResponseEntity<Map<String, Long>> getTotalCount() {
        long count = service.getTotalCount();
        Map<String, Long> response = new HashMap<>();
        response.put("totalRecords", count);
        return ResponseEntity.ok(response);
    }
}
