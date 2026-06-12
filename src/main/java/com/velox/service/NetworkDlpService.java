package com.velox.service;

import java.util.List;

import com.velox.dto.EventTypeCountDto;
import com.velox.dto.ExtensionCountDto;

public interface NetworkDlpService {

	List<EventTypeCountDto> getEventTypeCounts();

	List<ExtensionCountDto> getExtensionCounts();

}
