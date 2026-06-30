package com.velox.repository;

import com.velox.model.NetworkDlpEntity;
import com.velox.dto.DashboardModalDto;
import com.velox.dto.EventTypeCountDto;
import com.velox.dto.ExtensionCountDto;
import com.velox.dto.LatestIncidentDto;
import com.velox.dto.NetworkDlpRequestDto;
import com.velox.dto.PeripheralCountDto;
import com.velox.dto.UploadCountDTO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Repository
public interface NetworkDlpRepository extends JpaRepository<NetworkDlpEntity, Long> {

	@Query("SELECT new com.velox.dto.EventTypeCountDto(n.eventType, COUNT(n)) "
			+ "FROM NetworkDlpEntity n GROUP BY n.eventType")
	List<EventTypeCountDto> countEventsByEventType();

	@Query("SELECT new com.velox.dto.ExtensionCountDto(n.extension, COUNT(n)) FROM NetworkDlpEntity n WHERE n.extension IS NOT NULL AND n.extension != '' " + "GROUP BY n.extension")
	List<ExtensionCountDto> countByExtension();

	@Query("SELECT new com.velox.dto.DashboardModalDto(n.branchName, n.username, n.eventType, n.fileSourcePath, n.timestamp) FROM NetworkDlpEntity n WHERE n.extension = :extension")
	List<DashboardModalDto> findDashboardDataByExtension(@Param("extension") String extension);

	@Query("SELECT new com.velox.dto.PeripheralCountDto(n.eventType, COUNT(n)) "
			+ "FROM NetworkDlpEntity n WHERE n.eventType IN ('USB Transfer', 'DVD Burn') GROUP BY n.eventType")
	List<PeripheralCountDto> countPeripheralEventTypes();

	@Query("SELECT new com.velox.dto.LatestIncidentDto(n.ipAddress, n.username, n.eventType, n.fileSourcePath, n.timestamp) FROM NetworkDlpEntity n ORDER BY n.timestamp DESC")
	List<LatestIncidentDto> findLatestIncidents(org.springframework.data.domain.Pageable pageable);

	@Query("SELECT COUNT(n) FROM NetworkDlpEntity n WHERE n.eventType = :eventType")
	long countByEventType(@Param("eventType") String eventType);

	@Query(value = """
			SELECT
			    ts.timeSlot,
			    GROUP_CONCAT(DISTINCT n.hostname) AS hostnames,
			    COUNT(DISTINCT n.hostname) AS uniqueHostCount
			FROM
			(
			    SELECT '00:00-03:59' AS timeSlot, 0 AS slotOrder
			    UNION ALL
			    SELECT '04:00-07:59', 1
			    UNION ALL
			    SELECT '08:00-11:59', 2
			    UNION ALL
			    SELECT '12:00-15:59', 3
			    UNION ALL
			    SELECT '16:00-19:59', 4
			    UNION ALL
			    SELECT '20:00-23:59', 5
			) ts
			LEFT JOIN network_dlp n
			ON (
			    (ts.slotOrder = 0 AND HOUR(n.timestamp) BETWEEN 0 AND 3) OR
			    (ts.slotOrder = 1 AND HOUR(n.timestamp) BETWEEN 4 AND 7) OR
			    (ts.slotOrder = 2 AND HOUR(n.timestamp) BETWEEN 8 AND 11) OR
			    (ts.slotOrder = 3 AND HOUR(n.timestamp) BETWEEN 12 AND 15) OR
			    (ts.slotOrder = 4 AND HOUR(n.timestamp) BETWEEN 16 AND 19) OR
			    (ts.slotOrder = 5 AND HOUR(n.timestamp) BETWEEN 20 AND 23)
			)
			GROUP BY ts.slotOrder, ts.timeSlot
			ORDER BY ts.slotOrder
			""", nativeQuery = true)
			List<Object[]> getTimeSlotWiseUniqueHostCount();

	@Query(value = "SELECT event_type as eventType, COUNT(event_type) as count FROM network_dlp WHERE DATE(timestamp) = DATE(:date) GROUP BY event_type", nativeQuery = true)
	List<UploadCountDTO> getUploadCountByDate(@Param("date") LocalDate date);
	
	@Query(value = """
	        SELECT branchname,
	               event_type,
	               hostname,
	               username,
	               timestamp
	        FROM network_dlp WHERE event_type='NETWORK UPLOAD' 
	        ORDER BY `timestamp` DESC
	        """, nativeQuery = true)
	List<Object[]> getNetworkincidentchannel();
	
	
	@Query(value = """
		    SELECT branchname,
		           event_type,
		           hostname,
		           username,
		           timestamp
		    FROM network_dlp
		    WHERE event_type IN ('DVD BURN', 'USB TRANSFER')
		    ORDER BY `timestamp` DESC
		    """, nativeQuery = true)
		List<Object[]> getNetworkincidentchannel1();

		@Query(value = """
		        SELECT branchname AS branchname,
		               username AS username,
		               event_type AS eventType,
		               file_source_path AS fileSourcePath,
		               timestamp AS timestamp
		        FROM network_dlp_log
		        """, nativeQuery = true)
		List<Map<String, Object>> networkincident();

	


//		@Query("""
//			       SELECT new com.velox.dto.NetworkDlpRequestDto(
//			           n.branchname,
//			           n.username,
//			           n.eventType,
//			           n.fileSourcePath,
//			           n.timestamp
//			       )
//			       FROM NetworkDlpEntity n
//			       """)
//			List<NetworkDlpRequestDto> getPeripheralincident();
		
		@Query("""
				SELECT new com.velox.dto.NetworkDlpRequestDto(
				    n.branchName,
				    n.username,
				    n.eventType,
				    n.fileSourcePath,
				    n.timestamp
				)
				FROM NetworkDlpEntity n
				WHERE n.eventType = :eventType
				""")
				List<NetworkDlpRequestDto> getFileUploadData(@Param("eventType") String eventType);
	

}
