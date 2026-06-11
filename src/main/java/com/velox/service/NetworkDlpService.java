package com.velox.service;

import java.util.List;

import com.velox.dto.EventTypeCountDto;

public interface NetworkDlpService {

	List<EventTypeCountDto> getEventTypeCounts();

}
