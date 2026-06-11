
package com.velox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.velox.dto.AgentStatusCountDto;
import com.velox.service.DeviceManager;

@RestController
@CrossOrigin("*")
@RequestMapping("/SecureIT/DeviceManager")
public class DeviceManagerController {

	@Autowired
	private DeviceManager deviceManager;

	@GetMapping("/agentStatusCounts")
	public ResponseEntity<AgentStatusCountDto> getAgentStatusCounts() {
		System.out.println("DeviceManagerController.getAgentStatusCounts() called");

		try {
			AgentStatusCountDto result = deviceManager.getAgentStatusCounts();
			System.out.println("Controller received: active=" + result.getActive() + ", inactive="
					+ result.getInactive() + ", total=" + result.getTotal());

			if (result.getMessage() != null && !result.getMessage().equals("Success")) {
				System.err.println("Service error: " + result.getMessage());
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
			}

			return ResponseEntity.ok(result);

		} catch (Exception e) {
			System.err.println("Unexpected controller exception: " + e.getMessage());
			e.printStackTrace();
			AgentStatusCountDto errorResponse = new AgentStatusCountDto();
			errorResponse.setMessage("An unexpected error occurred while processing your request");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
		}
	}
}