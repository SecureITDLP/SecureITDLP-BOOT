package com.velox.service;

import java.util.List;

import com.velox.dto.AgentStatusCountDto;
import com.velox.dto.DeviceDetailsDto;

public interface DeviceManager {

	AgentStatusCountDto getAgentStatusCounts();

	List<DeviceDetailsDto> getAllDevices();

	List<String> getAllBranchNames();

	List<String> getDistinctBranchNames();
}
