package com.velox.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.velox.dto.MonitoringFolderDto;
import com.velox.model.MonitoringFolderEntity;

@Repository
public interface MonitoringFolderRepository extends JpaRepository<MonitoringFolderEntity, Long> {

    @Query("""
        SELECT new com.velox.dto.MonitoringFolderDto(
            m.branchName,
            m.ipAddress,
            m.cdate,
            m.pcName
        )
        FROM MonitoringFolderEntity m
    """)
    List<MonitoringFolderDto> getDriveincident();
}