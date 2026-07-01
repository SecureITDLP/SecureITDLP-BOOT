package com.velox.controller;

import com.velox.service.UsbProtectionService;
import com.velox.utils.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/SecureIT/UsbProtection")
public class UsbProtectionController {

	@Autowired
	private UsbProtectionService service;

	private static final Logger logger = LoggerFactory.getLogger(UsbProtectionController.class);

	@GetMapping("/getBranches")
	public ResponseEntity<ApiResponse<List<String>>> getAllBranches() {

		List<String> branches = service.getAllBranches();

		ApiResponse<List<String>> response = new ApiResponse<>(true, "FETCH_SUCCESS", "Branches fetched successfully",
				LocalDateTime.now(), branches);

		return ResponseEntity.ok(response);
	}

	@GetMapping("/devices/{branchName}")
	public ResponseEntity<ApiResponse<List<String>>> getDevicesByBranch(@PathVariable String branchName) {

		List<String> devices = service.getDevicesByBranch(branchName);

		ApiResponse<List<String>> response = new ApiResponse<>(true, "FETCH_SUCCESS", "Devices fetched successfully",
				LocalDateTime.now(), devices);

		return ResponseEntity.ok(response);
	}

}