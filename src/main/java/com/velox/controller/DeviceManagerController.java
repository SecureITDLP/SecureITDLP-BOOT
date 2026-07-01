
package com.velox.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.velox.dto.AgentStatusCountDto;
import com.velox.dto.DeviceDetailsDto;
import com.velox.dto.LoginResponse;
import com.velox.service.DeviceManager;
import com.velox.utils.ApiResponse;

@RestController
@CrossOrigin("*")
@RequestMapping("/SecureIT/DeviceManager")
public class DeviceManagerController {

	@Autowired
	private DeviceManager deviceManager;

	
	 private static final Logger logger =LoggerFactory.getLogger(AuthController.class);

	 @GetMapping("/agentStatusCounts")
		public ResponseEntity<ApiResponse<AgentStatusCountDto>> getAgentStatusCounts() {
			
			try {
				AgentStatusCountDto result = deviceManager.getAgentStatusCounts();
				ApiResponse<AgentStatusCountDto>response = new ApiResponse<>(true,"FETCH_SUCCESS","Device fetch successful", LocalDateTime.now(),result);
				logger.info("FETCH_SUCCESS");
				return ResponseEntity.ok(response);
			}catch(Exception ex) {
			
				ApiResponse<AgentStatusCountDto> response =new ApiResponse<>( false,"FETCH_FAILED", ex.getMessage(), LocalDateTime.now() ,null);
				logger.error("FETCH_FAILED");
				return ResponseEntity.status(-1).body(response);

			}

		}
	
	 
	 @GetMapping("/allDevices")
		public ResponseEntity<ApiResponse<List<DeviceDetailsDto>>> getAllDevices() {

			try {
				List<DeviceDetailsDto> result = deviceManager.getAllDevices();
				ApiResponse<List<DeviceDetailsDto>> response = new ApiResponse<>(true, "FETCH_SUCCESS","All device details fetched successfully", LocalDateTime.now(), result);
				logger.info("FETCH_SUCCESS");
				return ResponseEntity.ok(response);
			} catch (Exception ex) {
				ApiResponse<List<DeviceDetailsDto>> response = new ApiResponse<>(false, "FETCH_FAILED", ex.getMessage(),LocalDateTime.now(), null);

				logger.error("FETCH_FAILED", ex);
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
			}
		}
	 
	 
	// NEW ENDPOINTS FOR BRANCH NAMES
	
		@GetMapping("/allBranchNames")
		public ResponseEntity<ApiResponse<List<String>>> getAllBranchNames() {
			try {
				List<String> branchNames = deviceManager.getAllBranchNames();
				ApiResponse<List<String>> response = new ApiResponse<>(
					true, 
					"FETCH_SUCCESS", 
					"All branch names fetched successfully", 
					LocalDateTime.now(), 
					branchNames
				);
				logger.info("All branch names fetched successfully, count: {}", branchNames.size());
				return ResponseEntity.ok(response);
			} catch (Exception ex) {
				ApiResponse<List<String>> response = new ApiResponse<>(
					false, 
					"FETCH_FAILED", 
					ex.getMessage(), 
					LocalDateTime.now(), 
					null
				);
				logger.error("Failed to fetch branch names", ex);
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
			}
		}
		
		
		@GetMapping("/distinctBranchNames")
		public ResponseEntity<ApiResponse<List<String>>> getDistinctBranchNames() {
			try {
				List<String> distinctBranchNames = deviceManager.getDistinctBranchNames();
				ApiResponse<List<String>> response = new ApiResponse<>(
					true, 
					"FETCH_SUCCESS", 
					"Distinct branch names fetched successfully", 
					LocalDateTime.now(), 
					distinctBranchNames
				);
				logger.info("Distinct branch names fetched successfully, count: {}", distinctBranchNames.size());
				return ResponseEntity.ok(response);
			} catch (Exception ex) {
				ApiResponse<List<String>> response = new ApiResponse<>(
					false, 
					"FETCH_FAILED", 
					ex.getMessage(), 
					LocalDateTime.now(), 
					null
				);
				logger.error("Failed to fetch distinct branch names", ex);
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
			}
		}
		
		
		@GetMapping("/branchNamesCount")
		public ResponseEntity<ApiResponse<Long>> getBranchNamesCount() {
			try {
				List<String> branchNames = deviceManager.getAllBranchNames();
				long count = branchNames.size();
				ApiResponse<Long> response = new ApiResponse<>(
					true, 
					"FETCH_SUCCESS", 
					"Branch names count fetched successfully", 
					LocalDateTime.now(), 
					count
				);
				logger.info("Total branch names count: {}", count);
				return ResponseEntity.ok(response);
			} catch (Exception ex) {
				ApiResponse<Long> response = new ApiResponse<>(
					false, 
					"FETCH_FAILED", 
					ex.getMessage(), 
					LocalDateTime.now(), 
					null
				);
				logger.error("Failed to fetch branch names count", ex);
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
			}
		}
}