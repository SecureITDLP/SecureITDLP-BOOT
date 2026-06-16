package com.velox.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.velox.repository.EmailMonitoringRepository;
import com.velox.service.EmailMonitoringService;

@Service
public class EmailMonitoringServiceImpl implements EmailMonitoringService {

	@Autowired
	private EmailMonitoringRepository repository;


	 @Override
	    public List<Object[]> getTotalEmailCount() {
	        return repository.getTotalEmailCount();
	    }
	
	 
	  

	



	
}
