package com.velox.service;

import java.util.List;

import com.velox.dto.EventTypeCountDto;
import com.velox.dto.ExtensionCountDto;
import com.velox.dto.LatestIncidentDto;
import com.velox.dto.PeripheralCountDto;
import com.velox.dto.UploadCountDTO;

public interface NetworkDlpService {

	List<EventTypeCountDto> getEventTypeCounts();
	
	List<UploadCountDTO> getTodaysUploadCount();

	List<ExtensionCountDto> getExtensionCounts();

	 List<PeripheralCountDto> getPeripheralCounts();
	 
	 List<LatestIncidentDto> getLatestIncidents(int limit);
}
