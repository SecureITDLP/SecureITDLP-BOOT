package com.velox.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.velox.dto.AgentStatusCountDto;
import com.velox.dto.DeviceDetailsDto;
import com.velox.repository.AllIpAddressRepository;
import com.velox.service.DeviceManager;

@Service
public class DeviceManagerServicImpl implements DeviceManager {

	@Autowired
	private AllIpAddressRepository repository;

	
	@Override
	public AgentStatusCountDto getAgentStatusCounts() {

		AgentStatusCountDto AgentStatus = repository.getDeviceStatusCounts();
		return AgentStatus;
	}

	  @Override
	    public List<DeviceDetailsDto> getAllDevices() {
			return repository.getAllDevices();
	    }
	  
	  @Override
		public List<String> getAllBranchNames() {
			return repository.findAllBranchNames();
		}
		
		@Override
		public List<String> getDistinctBranchNames() {
			return repository.findDistinctBranchNames();
		}

}
