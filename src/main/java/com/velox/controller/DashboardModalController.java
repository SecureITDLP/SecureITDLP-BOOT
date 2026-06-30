package com.velox.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.velox.dto.ClipboardModalDto;
import com.velox.dto.DashboardModalDto;
import com.velox.dto.EmailModalDto;
import com.velox.dto.ExtensionRequestDto;
import com.velox.dto.IncidentByChannelDto;
import com.velox.dto.LoginResponse;
import com.velox.service.DashboardModalService;
import com.velox.service.NetworkDlpService;
import com.velox.utils.ApiResponse;

@RestController
@CrossOrigin("*")
@RequestMapping("/SecureIT/DashboardModal")
public class DashboardModalController {

	@Autowired
	private DashboardModalService dashboardmodalservice;

	private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

	@PostMapping("/ExtensionModalData/{request}")
	public ResponseEntity<ApiResponse<List<DashboardModalDto>>> ExtensionModalData(@PathVariable String request) {
		logger.info("api call ");

		List<DashboardModalDto> extBasedData = dashboardmodalservice.getDashboardData(request);
		try {
			ApiResponse<List<DashboardModalDto>> response = new ApiResponse<>(true, "FETCH_SUCCESS", "Data Fetched",
					LocalDateTime.now(), extBasedData);
			logger.info("ExtensionModalData Fetched");
			return ResponseEntity.ok(response);
		} catch (Exception ex) {

			ApiResponse<List<DashboardModalDto>> response = new ApiResponse<>(false, "FETCH_FAILED", ex.getMessage(),
					LocalDateTime.now(), null);
			logger.error(ex.getMessage());
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
		}
	}

	@PostMapping("/EmailModalData/{date}")
	public ResponseEntity<ApiResponse<List<EmailModalDto>>> EmailModalData(@PathVariable String date) {
		List<EmailModalDto> dateBasedData = dashboardmodalservice.getEmailData(date);

		try {
			ApiResponse<List<EmailModalDto>> response = new ApiResponse<>(true, "FETCH_SUCCESS", "Data Fetched",
					LocalDateTime.now(), dateBasedData);
			logger.info("EmailModalData Fetched");
			return ResponseEntity.ok(response);

		} catch (Exception ex) {
			ApiResponse<List<EmailModalDto>> response = new ApiResponse<>(false, "FETCH_FAILED", ex.getMessage(),
					LocalDateTime.now(), null);
			logger.error(ex.getMessage());
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
		}
	}

	@PostMapping("/ClipboardModalData/{date}")
	public ResponseEntity<ApiResponse<List<?>>> ClipboardModalData(@PathVariable String date) {

		System.out.println("Date from URL : " + date);
		try {
			List<?> data = dashboardmodalservice.getClipboardData(date);
			ApiResponse<List<?>> response = new ApiResponse<>(true, "FETCH_SUCCESS", "Data Fetched",
					LocalDateTime.now(), data);
			return ResponseEntity.ok(response);

		} catch (Exception ex) {
			ApiResponse<List<?>> response = new ApiResponse<>(false, "FETCH_FAILED", ex.getMessage(),
					LocalDateTime.now(), null);

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
	}

	@PostMapping("/IncidentbyChannelModal/{channel}")
	public ResponseEntity<ApiResponse<List<?>>> IncidentModalData(@PathVariable String channel) {

		try {
			List<?> data = dashboardmodalservice.getIncidentbyChannel(channel);

			ApiResponse<List<?>> response = new ApiResponse<>(true, "FETCH_SUCCESS", "Data Fetched",
					LocalDateTime.now(), data);

			logger.info("IncidentbyChannelModalData Fetched");
			return ResponseEntity.ok(response);

		} catch (Exception ex) {

			ApiResponse<List<?>> response = new ApiResponse<>(false, "FETCH_FAILED", ex.getMessage(),
					LocalDateTime.now(), null);

			logger.error(ex.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
	}

	@PostMapping("/FileUploadModalData/{file}")
	public ResponseEntity<ApiResponse<List<?>>> FileUploadData(@PathVariable String file) {

		try {
			List<?> data = dashboardmodalservice.getFileUploadData(file);

			ApiResponse<List<?>> response = new ApiResponse<>(true, "FETCH_SUCCESS", "Data Fetched",
					LocalDateTime.now(), data);

			logger.info("FileUploadData Fetched");
			return ResponseEntity.ok(response);

		} catch (Exception ex) {

			ApiResponse<List<?>> response = new ApiResponse<>(false, "FETCH_FAILED", ex.getMessage(),
					LocalDateTime.now(), null);

			logger.error(ex.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
	}

}
