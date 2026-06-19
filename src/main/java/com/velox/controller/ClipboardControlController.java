package com.velox.controller;

import com.velox.service.ClipboardControlService;
import com.velox.utils.ApiResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/SecureIT/clipboardcontrol")
public class ClipboardControlController {

    @Autowired
    private ClipboardControlService service;

    @GetMapping("/7daysclipboard_report")
    public ResponseEntity<ApiResponse<List<Object[]>>> getTotalClipboardCount() {

        System.out.println("INFO: Received request to fetch total clipboard control count");

        try {
            List<Object[]> clipboardData = service.getTotalClipboardCount();

            System.out.println("SUCCESS: Total clipboard control records = " + clipboardData);

            ApiResponse<List<Object[]>> response = new ApiResponse<>(
                true,
                "FETCH_SUCCESS",
                "Clipboard control count fetched successfully",
                LocalDateTime.now(),
                clipboardData
            );

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            System.err.println("ERROR: Failed to fetch clipboard control count - " + e.getMessage());
            e.printStackTrace();

            ApiResponse<List<Object[]>> errorResponse = new ApiResponse<>(
                false,
                "FETCH_FAILED",
                "Unable to retrieve clipboard control count. Please try again later.",
                LocalDateTime.now(),
                null
            );

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(errorResponse);
        }
    }
}