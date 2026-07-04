package com.velox.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.velox.model.PrinterMonitoring;

import java.util.List;

@Repository
public interface PrinterMonitoringRepository extends JpaRepository<PrinterMonitoring, Integer> {
    
    // Get records where ALLOW_PREVENT = 'Allow'
    @Query("SELECT p FROM PrinterMonitoring p WHERE LOWER(p.allowPrevent) = LOWER(:allowPrevent)")
    List<PrinterMonitoring> findByAllowPreventIgnoreCase(@Param("allowPrevent") String allowPrevent);
    
    // Get all records
    List<PrinterMonitoring> findAll();
}