package com.velox.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.velox.dto.EventTypeCountDto;
import com.velox.dto.ExtensionCountDto;
import com.velox.dto.LatestIncidentDto;
import com.velox.dto.PeripheralCountDto;
import com.velox.dto.TimeSlotHostCountDto;
import com.velox.dto.UploadCountDTO;
import com.velox.service.NetworkDlpService;
import com.velox.utils.ApiResponse;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

	
	@GetMapping("/eventWiseCount")
	public ResponseEntity<ApiResponse<List<EventTypeCountDto>>> getEventTypeCounts() {
		List<EventTypeCountDto> counts = service.getEventTypeCounts();

		ApiResponse<List<EventTypeCountDto>> response = new ApiResponse<>(true, "FETCH_SUCCESS", "fetch successful",
				LocalDateTime.now(), counts);
		return ResponseEntity.ok(response);
	}

	@GetMapping("/extensionCounts")
	public ResponseEntity<ApiResponse<List<ExtensionCountDto>>> getExtensionCounts() {
		try {
			List<ExtensionCountDto> result = service.getExtensionCounts();
			ApiResponse<List<ExtensionCountDto>> response = new ApiResponse<>(true, "FETCH_SUCCESS",
					"Extension counts fetched successfully", LocalDateTime.now(), result);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			e.printStackTrace();
			ApiResponse<List<ExtensionCountDto>> errorResponse = new ApiResponse<>(false, "FETCH_FAILED",
					"Unable to retrieve extension counts. Please try again later.", LocalDateTime.now(), null);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
		}
	}

	@GetMapping("/peripheralCounts")
	public ResponseEntity<ApiResponse<List<PeripheralCountDto>>> getPeripheralCounts() {
		try {
			List<PeripheralCountDto> result = service.getPeripheralCounts();
			ApiResponse<List<PeripheralCountDto>> response = new ApiResponse<>(true, "FETCH_SUCCESS",
					"Peripheral counts fetched successfully", LocalDateTime.now(), result);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			e.printStackTrace();
			ApiResponse<List<PeripheralCountDto>> errorResponse = new ApiResponse<>(false, "FETCH_FAILED",
					"Unable to retrieve peripheral counts. Please try again later.", LocalDateTime.now(), null);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
		}
	}

	@GetMapping("/latest-incidents")
	public ResponseEntity<ApiResponse<List<LatestIncidentDto>>> getLatestIncidents(
			@RequestParam(value = "limit", defaultValue = "50") int limit) {
		try {
			List<LatestIncidentDto> result = service.getLatestIncidents(limit);
			ApiResponse<List<LatestIncidentDto>> response = new ApiResponse<>(true, "FETCH_SUCCESS",
					"Latest incidents fetched successfully", LocalDateTime.now(), result);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			e.printStackTrace();
			ApiResponse<List<LatestIncidentDto>> errorResponse = new ApiResponse<>(false, "FETCH_FAILED",
					"Unable to retrieve latest incidents. Please try again later.", LocalDateTime.now(), null);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
		}
	}

	@GetMapping("/timeSlotHostCounts")
	public ResponseEntity<ApiResponse<List<TimeSlotHostCountDto>>> getTimeSlotHostCounts() {

		try {


//			List<TimeSlotHostCountDto> result = service.getTimeSlotWiseUniqueHostCount();
//
//			ApiResponse<List<TimeSlotHostCountDto>> response = new ApiResponse<>(true, "FETCH_SUCCESS",
//					"Time slot wise unique host count fetched successfully", LocalDateTime.now(), result);
//
//			return ResponseEntity.ok(response);
//
//		} catch (Exception e) {
//
//			e.printStackTrace();
//
//			ApiResponse<List<TimeSlotHostCountDto>> errorResponse = new ApiResponse<>(false, "FETCH_FAILED",
//					e.getMessage(), LocalDateTime.now(), null);
//
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
//		}

			List<TimeSlotHostCountDto> result = service.getTimeSlotWiseUniqueHostCount();
			ApiResponse<List<TimeSlotHostCountDto>> response = new ApiResponse<>(true, "FETCH_SUCCESS",
					"Time slot fetched successfully", LocalDateTime.now(), result);
			return ResponseEntity.ok(response);
		} catch (Exception e) {

			ApiResponse<List<TimeSlotHostCountDto>> errorResponse = new ApiResponse<>(false, "FETCH_FAILED",e.getMessage(), LocalDateTime.now(), null);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
		}
	}
	
	@GetMapping("/getTodaysUploadCount")
	public ResponseEntity<ApiResponse<List<UploadCountDTO>>>getTodaysUploadCount(){
		try {
		List<UploadCountDTO> uploadcount = service.getTodaysUploadCount();
		ApiResponse<List<UploadCountDTO>> response = new ApiResponse<>(true, "FETCH_SUCCESS", "fetch successful",LocalDateTime.now(), uploadcount);
		return ResponseEntity.ok(response);
		
		}catch(Exception ex) {
			ApiResponse<List<UploadCountDTO>> errorResponse = new ApiResponse<>(false, "FETCH_FAILED",ex.getMessage(), LocalDateTime.now(), null);
			logger.error(ex.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
		}
		

	}
}
