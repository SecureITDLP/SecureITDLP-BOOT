package com.velox.repository;

import com.velox.model.NetworkDlpEntity;
import com.velox.dto.EventTypeCountDto;
import com.velox.dto.ExtensionCountDto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface NetworkDlpRepository extends JpaRepository<NetworkDlpEntity, Long> {

	@Query("SELECT new com.velox.dto.EventTypeCountDto(n.eventType, COUNT(n)) "
			+ "FROM NetworkDlpEntity n GROUP BY n.eventType")
	List<EventTypeCountDto> countEventsByEventType();

	@Query("SELECT new com.velox.dto.ExtensionCountDto(n.extension, COUNT(n)) " + "FROM NetworkDlpEntity n "
			+ "WHERE n.extension IS NOT NULL AND n.extension != '' " + "GROUP BY n.extension")
	List<ExtensionCountDto> countByExtension();

}
