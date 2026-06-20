package com.velox.repository;

import com.velox.model.NetworkDlpEntity;
import com.velox.dto.DashboardModalDto;
import com.velox.dto.EventTypeCountDto;
import com.velox.dto.ExtensionCountDto;
import com.velox.dto.LatestIncidentDto;
import com.velox.dto.PeripheralCountDto;
import com.velox.dto.UploadCountDTO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface NetworkDlpRepository extends JpaRepository<NetworkDlpEntity, Long> {

	@Query("SELECT new com.velox.dto.EventTypeCountDto(n.eventType, COUNT(n)) "
			+ "FROM NetworkDlpEntity n GROUP BY n.eventType")
	List<EventTypeCountDto> countEventsByEventType();

	@Query("SELECT new com.velox.dto.ExtensionCountDto(n.extension, COUNT(n)) " + "FROM NetworkDlpEntity n "
			+ "WHERE n.extension IS NOT NULL AND n.extension != '' " + "GROUP BY n.extension")
	List<ExtensionCountDto> countByExtension();


//	 @Query(value = """
//			 SELECT
//			     CASE
//			         WHEN HOUR(timestamp) BETWEEN 0 AND 3 THEN '00:00-03:59'
//			         WHEN HOUR(timestamp) BETWEEN 4 AND 7 THEN '04:00-07:59'
//			         WHEN HOUR(timestamp) BETWEEN 8 AND 11 THEN '08:00-11:59'
//			         WHEN HOUR(timestamp) BETWEEN 12 AND 15 THEN '12:00-15:59'
//			         WHEN HOUR(timestamp) BETWEEN 16 AND 19 THEN '16:00-19:59'
//			         ELSE '20:00-23:59'
//			     END,
//			     GROUP_CONCAT(DISTINCT hostname),
//			     COUNT(DISTINCT hostname)
//			 FROM network_dlp
//			 GROUP BY 1
//			 ORDER BY MIN(HOUR(timestamp))
//			 """, nativeQuery = true)
//			 List<Object[]> getTimeSlotWiseUniqueHostCount();
//		

			

			     @Query("SELECT new com.velox.dto.DashboardModalDto(" +
			            "n.branchName, n.username, n.eventType, n.fileSourcePath, n.timestamp) " +
			            "FROM NetworkDlpEntity n " +
			            "WHERE n.extension = :extension")
			     List<DashboardModalDto> findDashboardDataByExtension(
			             @Param("extension") String extension);

			 		 


	@Query("SELECT new com.velox.dto.PeripheralCountDto(n.eventType, COUNT(n)) "
			+ "FROM NetworkDlpEntity n WHERE n.eventType IN ('USB Transfer', 'DVD Burn') GROUP BY n.eventType")
	List<PeripheralCountDto> countPeripheralEventTypes();

	@Query("SELECT new com.velox.dto.LatestIncidentDto(n.ipAddress, n.username, n.eventType, n.fileSourcePath, n.timestamp) FROM NetworkDlpEntity n ORDER BY n.timestamp DESC")
	List<LatestIncidentDto> findLatestIncidents(org.springframework.data.domain.Pageable pageable);

	@Query("SELECT COUNT(n) FROM NetworkDlpEntity n WHERE n.eventType = :eventType")
	long countByEventType(@Param("eventType") String eventType);

	@Query(value = """
			SELECT
			    CASE
			        WHEN HOUR(timestamp) BETWEEN 0 AND 3 THEN '00:00-03:59'
			        WHEN HOUR(timestamp) BETWEEN 4 AND 7 THEN '04:00-07:59'
			        WHEN HOUR(timestamp) BETWEEN 8 AND 11 THEN '08:00-11:59'
			        WHEN HOUR(timestamp) BETWEEN 12 AND 15 THEN '12:00-15:59'
			        WHEN HOUR(timestamp) BETWEEN 16 AND 19 THEN '16:00-19:59'
			        ELSE '20:00-23:59'
			    END,
			    GROUP_CONCAT(DISTINCT hostname),
			    COUNT(DISTINCT hostname)
			FROM network_dlp
			GROUP BY 1
			ORDER BY MIN(HOUR(timestamp))
			""", nativeQuery = true)
	List<Object[]> getTimeSlotWiseUniqueHostCount();

	@Query(value = "SELECT event_type as eventType, COUNT(event_type) as count FROM network_dlp WHERE DATE(timestamp) = DATE(:date) GROUP BY event_type", nativeQuery = true)
	List<UploadCountDTO> getUploadCountByDate(@Param("date") LocalDate date);

}
