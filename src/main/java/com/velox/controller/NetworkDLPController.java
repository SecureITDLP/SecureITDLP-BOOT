package com.velox.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.velox.dto.EventTypeCountDto;
import com.velox.dto.ExtensionCountDto;
import com.velox.dto.LatestIncidentDto;
import com.velox.dto.PeripheralCountDto;
import com.velox.service.NetworkDlpService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@CrossOrigin("*")
@RequestMapping("/SecureIT/NetworkDLP")
public class NetworkDLPController {

	@Autowired
	private NetworkDlpService service;

	@GetMapping("/event-counts")
	public ResponseEntity<List<EventTypeCountDto>> getEventTypeCounts() {
		List<EventTypeCountDto> counts = service.getEventTypeCounts();
		return ResponseEntity.ok(counts);
	}

	@GetMapping("/extensionCounts")
	public ResponseEntity<List<ExtensionCountDto>> getExtensionCounts() {
//		System.out.println("NetworkDLPController.getExtensionCounts() called");

		try {
			List<ExtensionCountDto> result = service.getExtensionCounts();
//			System.out.println("Controller received " + result.size() + " extension counts");
			return ResponseEntity.ok(result);

		} catch (Exception e) {
//			System.err.println("Unexpected controller exception: " + e.getMessage());
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	 @GetMapping("/peripheralCounts")
	    public ResponseEntity<List<PeripheralCountDto>> getPeripheralCounts() {
//	        System.out.println("NetworkDlpController.getPeripheralCounts() called");
	        try {
	            List<PeripheralCountDto> result = service.getPeripheralCounts();
//	            System.out.println("Controller received " + result.size() + " peripheral counts");
	            return ResponseEntity.ok(result);
	        } catch (Exception e) {
//	            System.err.println("Unexpected controller exception: " + e.getMessage());
	            e.printStackTrace();
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	        }
	    }
	 
	 @GetMapping("/latest-incidents")
	    public ResponseEntity<List<LatestIncidentDto>> getLatestIncidents(
	            @RequestParam(value = "limit", defaultValue = "50") int limit) {
//	        System.out.println("NetworkDlpController.getLatestIncidents() called with limit=" + limit);
	        try {
	            List<LatestIncidentDto> result = service.getLatestIncidents(limit);
//	            System.out.println("Controller fetched " + result.size() + " incidents");
	            return ResponseEntity.ok(result);
	        } catch (Exception e) {
//	            System.err.println("Error fetching latest incidents: " + e.getMessage());
	            e.printStackTrace();
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	        }
	    }
}
