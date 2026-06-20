package com.velox.repository;

import com.velox.model.MonitoringFolderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonitoringFolderRepository extends JpaRepository<MonitoringFolderEntity, Integer> {
    // count() method is inherited from JpaRepository
}	
