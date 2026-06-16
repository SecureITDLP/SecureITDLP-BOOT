package com.velox.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.velox.model.EmailMonitoringEntity;

@Repository
public interface EmailMonitoringRepository extends JpaRepository<EmailMonitoringEntity, Long> {
	@Query(value = """
		    SELECT
		        d.date AS incident_date,
		        COUNT(e.date_time) AS count
		    FROM (
		        SELECT CURDATE() - INTERVAL 6 DAY AS date
		        UNION ALL SELECT CURDATE() - INTERVAL 5 DAY
		        UNION ALL SELECT CURDATE() - INTERVAL 4 DAY
		        UNION ALL SELECT CURDATE() - INTERVAL 3 DAY
		        UNION ALL SELECT CURDATE() - INTERVAL 2 DAY
		        UNION ALL SELECT CURDATE() - INTERVAL 1 DAY
		        UNION ALL SELECT CURDATE()
		    ) d
		    LEFT JOIN email_monittoring e
		        ON e.date_time >= d.date
		       AND e.date_time < d.date + INTERVAL 1 DAY
		    GROUP BY d.date
		    ORDER BY d.date
		    """, nativeQuery = true)
		List<Object[]> getTotalEmailCount();
}