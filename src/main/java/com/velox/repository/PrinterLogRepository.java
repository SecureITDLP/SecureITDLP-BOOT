package com.velox.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.velox.model.PrinterDLP;

@Repository
public interface PrinterLogRepository extends JpaRepository<PrinterDLP, Long> {

    @Query(value =
            "SELECT `DATE` AS peak_day " +
            "FROM printer_log " +
            "GROUP BY `DATE` " +
            "ORDER BY COUNT(*) DESC " +
            "LIMIT 1",
            nativeQuery = true)
    String getPeakDayIncident();

}

