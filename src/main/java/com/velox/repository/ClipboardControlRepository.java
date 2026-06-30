package com.velox.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.velox.dto.ClipboardModalDto;
import com.velox.model.ClipboardControl;

@Repository
public interface ClipboardControlRepository extends JpaRepository<ClipboardControl, Long> {

	@Query(value = "SELECT " + "    d.date AS incident_date, " + "    COUNT(c.created_at) AS count " + "FROM ( "
			+ "    SELECT CURDATE() - INTERVAL 6 DAY AS date " + "    UNION ALL SELECT CURDATE() - INTERVAL 5 DAY "
			+ "    UNION ALL SELECT CURDATE() - INTERVAL 4 DAY " + "    UNION ALL SELECT CURDATE() - INTERVAL 3 DAY "
			+ "    UNION ALL SELECT CURDATE() - INTERVAL 2 DAY " + "    UNION ALL SELECT CURDATE() - INTERVAL 1 DAY "
			+ "    UNION ALL SELECT CURDATE() " + ") d " + "LEFT JOIN clipboard_control_log c "
			+ "    ON c.created_at >= d.date " + "   AND c.created_at < d.date + INTERVAL 1 DAY " + "GROUP BY d.date "
			+ "ORDER BY d.date", nativeQuery = true)
	List<Object[]> getLastSevenDaysIncidents();

//	@Query("SELECT new com.velox.dto.ClipboardModalDto(" + "c.application, c.branch, c.hostname, c.keyword) "
//			+ "FROM ClipboardControl c " + "WHERE FUNCTION('DATE_FORMAT', c.createdAt, '%Y-%m-%d') = :date")
//	List<ClipboardModalDto> getClipboardData(@Param("date") String date);

	@Query("SELECT c.branch, c.hostname, c.ipaddress, c.keyword, c.createdAt " + "FROM ClipboardControl c "
			+ "ORDER BY c.createdAt DESC")
	List<Object[]> getClipboardincidentchannel();

	@Query("SELECT new com.velox.dto.ClipboardModalDto("
			+ "c.application, c.branch, c.hostname, c.keyword) " + "FROM ClipboardControl c "
			+ "WHERE FUNCTION('DATE_FORMAT', c.createdAt, '%Y-%m-%d') = :date")
	List<?> getClipboardData(@Param("date") String date);

//
//		    @Query("SELECT new com.velox.dto.ClipboardModalDto(" +
//		           "c.application, c.branch, c.hostname, c.keyword) " +
//		           "FROM ClipboardControl c " +
//		           "WHERE FUNCTION('DATE_FORMAT', c.createdAt, '%Y-%m-%d') = :date")
//		

	
	@Query(value = """
		       SELECT hostname,
		              ipaddress,
		              keyword,
		              branch
		       FROM clipboard_control_log
		       """, nativeQuery = true)
		List<Object[]> clipboardincident();
}
