
package com.velox.repository;

import com.velox.model.AllIpAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AllIpAddressRepository extends JpaRepository<AllIpAddress, Long> {

	@Query("SELECT COUNT(a) FROM AllIpAddress a WHERE LOWER(a.agentStatus) = LOWER(:status)")
	long countByAgentStatusIgnoreCase(@Param("status") String status);

	long count();
}