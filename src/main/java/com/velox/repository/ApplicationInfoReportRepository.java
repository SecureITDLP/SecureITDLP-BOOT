package com.velox.repository;

import com.velox.model.ApplicationInfoReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ApplicationInfoReportRepository extends JpaRepository<ApplicationInfoReport, Long> {

    // Native query for MySQL – returns Object[] with [date, count]
	@Query(value = "SELECT " +
	        "d.date AS incident_date, " +
	        "COUNT(a.c_time) AS count " +   
	        "FROM ( " +
	        "    SELECT CURDATE() - INTERVAL 6 DAY AS date " +
	        "    UNION ALL SELECT CURDATE() - INTERVAL 5 DAY " +
	        "    UNION ALL SELECT CURDATE() - INTERVAL 4 DAY " +
	        "    UNION ALL SELECT CURDATE() - INTERVAL 3 DAY " +
	        "    UNION ALL SELECT CURDATE() - INTERVAL 2 DAY " +
	        "    UNION ALL SELECT CURDATE() - INTERVAL 1 DAY " +
	        "    UNION ALL SELECT CURDATE() " +
	        ") d " +
	        "LEFT JOIN application_info_report a " +
	        "    ON DATE(a.c_time) = d.date " +
	        "GROUP BY d.date " +
	        "ORDER BY d.date", nativeQuery = true)
	List<Object[]> getLastSevenDaysPreventedApplicationCounts();
}