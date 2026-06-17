
package com.velox.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.velox.dto.AgentStatusCountDto;
import com.velox.dto.LoginResponse;
import com.velox.service.DeviceManager;
import com.velox.utils.ApiResponse;

@RestController
@CrossOrigin("*")
@RequestMapping("/SecureIT/DeviceManager")
public class DeviceManagerController {

	@Autowired
	private DeviceManager deviceManager;

//	@GetMapping("/agentStatusCounts")
//	public ResponseEntity<AgentStatusCountDto> getAgentStatusCounts() {
//		
//		try {
//			AgentStatusCountDto result = deviceManager.getAgentStatusCounts();
////			System.out.println("Controller received: active=" + result.getActive() + ", inactive="+ result.getInactive() + ", total=" + result.getTotal());
//
//			if (result.getMessage() != null && !result.getMessage().equals("Success")) {
////				System.err.println("Service error: " + result.getMessage());
//				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
//			}
//
//			return ResponseEntity.ok(result);
//
//		} catch (Exception e) {
//			System.err.println("Unexpected controller exception: " + e.getMessage());
//			e.printStackTrace();
//			AgentStatusCountDto errorResponse = new AgentStatusCountDto();
//			errorResponse.setMessage("An unexpected error occurred while processing your request");
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
//		}
//	}
	
	@GetMapping("/agentStatusCounts")
	public ResponseEntity<ApiResponse<AgentStatusCountDto>> getAgentStatusCounts() {
		
		try {
			AgentStatusCountDto result = deviceManager.getAgentStatusCounts();
			ApiResponse<AgentStatusCountDto>response = new ApiResponse<>(true,"FETCH_SUCCESS","Device fetch successful", LocalDateTime.now(),result);
			return ResponseEntity.ok(response);
		}catch(Exception ex) {
			
			ApiResponse<AgentStatusCountDto> response =new ApiResponse<>( false,"LOGIN_FAILED", ex.getMessage(), LocalDateTime.now() ,null);
			return ResponseEntity.status(-1).body(response);

		}

	}
	
}