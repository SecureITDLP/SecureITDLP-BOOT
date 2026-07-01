
package com.velox.repository;

import com.velox.dto.AgentStatusCountDto;
import com.velox.dto.DeviceDetailsDto;
import com.velox.model.AllIpAddress;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AllIpAddressRepository extends JpaRepository<AllIpAddress, Long> {

	@Query("SELECT COUNT(a) FROM AllIpAddress a WHERE LOWER(a.agentStatus) = LOWER(:status)")
	long countByAgentStatusIgnoreCase(@Param("status") String status);

	long count();
	
    @Query("SELECT NEW com.velox.dto.AgentStatusCountDto(SUM(CASE WHEN LOWER(a.agentStatus) = 'up' THEN 1 ELSE 0 END), SUM(CASE WHEN LOWER(a.agentStatus) = 'down' THEN 1 ELSE 0 END)) FROM AllIpAddress a")
    AgentStatusCountDto getDeviceStatusCounts();
	
	@Query("SELECT new com.velox.dto.DeviceDetailsDto(a.branchName,a.ipAddress,a.deviceIp, a.userName,a.agentStatus,a.agentCommunication,a.zoneName,a.fixedUser)FROM AllIpAddress a")
	List<DeviceDetailsDto> getAllDevices();

	
	   @Query("SELECT DISTINCT a.branchName FROM AllIpAddress a")
	List<String> getAllBranches();

	   
	   
	   @Query("SELECT DISTINCT a.pcName FROM AllIpAddress a WHERE a.branchName = :branchName")
	   List<String> getDevicesByBranch(@Param("branchName") String branchName);
    
}