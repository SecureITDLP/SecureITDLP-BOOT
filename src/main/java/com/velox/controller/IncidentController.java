package com.velox.controller;

import com.velox.dto.IncidentByChannelDto;
import com.velox.service.IncidentService;
import com.velox.utils.ApiResponse;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/SecureIT/incidents")
public class IncidentController {

    @Autowired
    private IncidentService incidentService;

    @GetMapping("/by-channel")
    public ResponseEntity<ApiResponse<IncidentByChannelDto>> getIncidentCountsByChannel() {
        System.out.println("INFO: Received request to fetch incident counts by channel");

        try {
            IncidentByChannelDto counts = incidentService.getIncidentCountsByChannel();

            System.out.println("SUCCESS: Incident counts fetched = " + counts);

            ApiResponse<IncidentByChannelDto> response = new ApiResponse<>(
                    true,
                    "FETCH_SUCCESS",
                    "Incident counts by channel fetched successfully",
                    LocalDateTime.now(),
                    counts
            );

     return ResponseEntity.ok(response);

        } catch (Exception e) {
     System.err.println("ERROR: Failed to fetch incident counts - " + e.getMessage());
            e.printStackTrace();

            ApiResponse<IncidentByChannelDto> errorResponse = new ApiResponse<>(
    false,
                    "FETCH_FAILED",
                    "Unable to retrieve incident counts. Please try again later.",
                    LocalDateTime.now(),
                    null
            );

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(errorResponse);
        }
    }
}