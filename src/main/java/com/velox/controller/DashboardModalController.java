package com.velox.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.velox.dto.DashboardModalDto;
import com.velox.dto.ExtensionRequestDto;
import com.velox.service.DashboardModalService;
import com.velox.service.NetworkDlpService;

@RestController
@CrossOrigin("*")
@RequestMapping("/SecureIT/DashboardModal")
public class DashboardModalController {

    @Autowired
    private DashboardModalService dashboardmodalservice;

    @PostMapping("/Dashboard/{request}")
    public ResponseEntity<Object>
    getDashboardData(@PathVariable String request){

        return ResponseEntity.ok(
        		dashboardmodalservice.getDashboardData(request));
    }

}