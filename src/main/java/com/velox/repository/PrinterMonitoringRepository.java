package com.velox.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.velox.model.PrinterMonitoring;

import java.util.List;

@Repository
public interface PrinterMonitoringRepository extends JpaRepository<PrinterMonitoring, Integer> {
    
    // Get all records
    List<PrinterMonitoring> findAll();
    
    // Get records where ALLOW_PREVENT = "allow prevent"
    List<PrinterMonitoring> findByAllowPrevent(String allowPrevent);
    
    // Get records where ALLOW_PREVENT = "allow prevent" using JPQL
    @Query("SELECT p FROM PrinterMonitoring p WHERE p.allowPrevent = :allowPrevent")
    List<PrinterMonitoring> findRecordsByAllowPrevent(@Param("allowPrevent") String allowPrevent);
}