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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@CrossOrigin("*")
@RestController
@RequestMapping("/SecureIT/ClipboardControl")
public class ClipboardControlController {

	@Autowired
	private ClipboardControlService service;

	private static final Logger logger =LoggerFactory.getLogger(AuthController.class);

	@GetMapping("/7DaysClipboardIncident")
	public ResponseEntity<ApiResponse<List<Object[]>>> getTotalClipboardCount() {


		try {
			List<Object[]> clipboardData = service.getTotalClipboardCount();
			ApiResponse<List<Object[]>> response = new ApiResponse<>(true, "FETCH_SUCCESS","Clipboard count fetched successfully", LocalDateTime.now(), clipboardData);
			logger.info("7daysclipboard_report fetch Success");
			return ResponseEntity.ok(response);

		} catch (Exception e) {
			ApiResponse<List<Object[]>> errorResponse = new ApiResponse<>(false, "FETCH_FAILED","Unable to retrieve clipboard control count", LocalDateTime.now(), null);
			logger.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
		}
	}
}