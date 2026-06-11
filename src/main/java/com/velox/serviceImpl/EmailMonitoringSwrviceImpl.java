package com.velox.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.velox.repository.EmailMonitoringRepository;
import com.velox.service.EmailMonitoringService;

@Service
public class EmailMonitoringSwrviceImpl implements EmailMonitoringService {

	@Autowired
	private EmailMonitoringRepository repository;

	public long getTotalEmailCount() {
		return repository.count();
	}

}
