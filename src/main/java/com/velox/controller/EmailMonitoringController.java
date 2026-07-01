/*
 * package com.velox.controller;
 * 
 * import com.velox.service.EmailMonitoringService; import
 * com.velox.utils.ApiResponse; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.http.HttpStatus; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.web.bind.annotation.CrossOrigin; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import java.time.LocalDateTime; import java.util.HashMap; import
 * java.util.List; import java.util.Map;
 * 
 * @CrossOrigin("*")
 * 
 * @RestController
 * 
 * @RequestMapping("/SecureIT/email-monitoring") public class
 * EmailMonitoringController {
 * 
 * @Autowired private EmailMonitoringService service;
 * 
 * @GetMapping("/emailwisecount") public
 * ResponseEntity<ApiResponse<List<Object[]>>> getTotalEmailCount() {
 * 
 * System.out.
 * println("INFO: Received request to fetch total email monitoring count");
 * 
 * try { List<Object[]> emailData = service.getTotalEmailCount();
 * 
 * System.out.println("SUCCESS: Total email monitoring records = " + emailData);
 * 
 * ApiResponse<List<Object[]>> response = new ApiResponse<>(true,
 * "FETCH_SUCCESS", "Email monitoring count fetched successfully",
 * LocalDateTime.now(), emailData);
 * 
 * return ResponseEntity.ok(response);
 * 
 * } catch (Exception e) {
 * System.err.println("ERROR: Failed to fetch email monitoring count - " +
 * e.getMessage()); e.printStackTrace();
 * 
 * ApiResponse<List<Object[]>> errorResponse = new ApiResponse<>(false,
 * "FETCH_FAILED", "Unable to retrieve email count. Please try again later.",
 * LocalDateTime.now(), null);
 * 
 * return
 * ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
 * } } }
 */


package com.velox.controller;

import com.velox.service.EmailMonitoringService;
import com.velox.utils.ApiResponse;
import com.velox.dto.EmailMonitoringCountDTO;          // NEW import
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;                    // NEW import

@CrossOrigin("*")
@RestController
@RequestMapping("/SecureIT/email-monitoring")
public class EmailMonitoringController {

    @Autowired
    private EmailMonitoringService service;

    @GetMapping("/emailwisecount")
    public ResponseEntity<ApiResponse<List<EmailMonitoringCountDTO>>> getTotalEmailCount() {   // CHANGED return type

        System.out.println("INFO: Received request to fetch total email monitoring count");

        try {
            List<Object[]> emailData = service.getTotalEmailCount();

            // ========== NEW CODE: Convert raw data to DTO list ==========
            List<EmailMonitoringCountDTO> dtoList = emailData.stream()
                .map(arr -> {
                    // Adjust casting based on your actual database column types
                    // Assuming arr[0] is a date (java.sql.Date or Timestamp) and arr[1] is a number
                    LocalDate date = ((java.sql.Date) arr[0]).toLocalDate(); 
                    long count = ((Number) arr[1]).longValue();
                    return new EmailMonitoringCountDTO(date, count);
                })
                .collect(Collectors.toList());
            // ========== END NEW CODE ==========

            System.out.println("SUCCESS: Total email monitoring records = " + dtoList.size());  // OPTIONAL log size

            // Use dtoList instead of emailData in the response
            ApiResponse<List<EmailMonitoringCountDTO>> response = new ApiResponse<>(
                    true, "FETCH_SUCCESS",
                    "Email monitoring count fetched successfully",
                    LocalDateTime.now(),
                    dtoList   // <-- CHANGED from emailData to dtoList
            );

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            System.err.println("ERROR: Failed to fetch email monitoring count - " + e.getMessage());
            e.printStackTrace();

            // Error response also uses the new generic type
            ApiResponse<List<EmailMonitoringCountDTO>> errorResponse = new ApiResponse<>(
                    false, "FETCH_FAILED",
                    "Unable to retrieve email count. Please try again later.",
                    LocalDateTime.now(),
                    null
            );

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }
}