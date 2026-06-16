package com.velox.controller;

import com.velox.service.ClipboardControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/SecureIT/clipboardcontrol")
public class ClipboardControlController {

    @Autowired
    private ClipboardControlService service;

    @GetMapping("/clipboardControl")
    public ResponseEntity<?> getTotalClipboardCount() {

        System.out.println("INFO: Received request to fetch total clipboard control count");

        try {

        	 List<Object[]> Clipboard = service.getTotalClipboardCount();

            System.out.println("SUCCESS: Total clipboard control records = " + Clipboard);

            Map<String, Object> response = new HashMap<>();
            response.put("status", "success");
            response.put("totalCount", Clipboard);

            return ResponseEntity.ok(response);

        } catch (Exception e) {

            System.err.println("ERROR: Failed to fetch clipboard control count - " + e.getMessage());
            e.printStackTrace();

            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("status", "error");
            errorResponse.put("message", "Unable to retrieve clipboard control count. Please try again later.");

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(errorResponse);
        }
    }
}