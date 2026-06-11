package com.velox.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.velox.dto.AgentStatusCountDto;
import com.velox.repository.AllIpAddressRepository;
import com.velox.service.DeviceManager;

@Service
public class DeviceManagerServicImpl implements DeviceManager {

	@Autowired
	private AllIpAddressRepository repository;

	@Override
	public AgentStatusCountDto getAgentStatusCounts() {
		System.out.println("DeviceManagerServiceImpl.getAgentStatusCounts() called");

		try {
			String activeStatus = "Up";
			String inactiveStatus = "Down";

			System.out.println("Counting devices with status = '" + activeStatus + "' (case‑insensitive)");
			long activeCount = repository.countByAgentStatusIgnoreCase(activeStatus);
			System.out.println("Active count = " + activeCount);

			System.out.println("Counting devices with status = '" + inactiveStatus + "' (case‑insensitive)");
			long inactiveCount = repository.countByAgentStatusIgnoreCase(inactiveStatus);
			System.out.println("Inactive count = " + inactiveCount);

			long totalCount = repository.count();

			AgentStatusCountDto dto = new AgentStatusCountDto(activeCount, inactiveCount);
			dto.setTotal(totalCount);
			return dto;

		} catch (Exception e) {
			System.err.println("ERROR in DeviceManagerServiceImpl: " + e.getMessage());
			e.printStackTrace();
			AgentStatusCountDto errorDto = new AgentStatusCountDto();
			errorDto.setMessage("Failed to retrieve agent status counts from database");
			return errorDto;
		}
	}

}
