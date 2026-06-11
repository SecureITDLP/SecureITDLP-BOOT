package com.velox.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.velox.dto.EventTypeCountDto;
import com.velox.repository.NetworkDlpRepository;
import com.velox.service.NetworkDlpService;

@Service
public class NetworkDlpServiceImpl implements NetworkDlpService {

	@Autowired
	private NetworkDlpRepository repository;

	public List<EventTypeCountDto> getEventTypeCounts() {
		return repository.countEventsByEventType();
	}

}
