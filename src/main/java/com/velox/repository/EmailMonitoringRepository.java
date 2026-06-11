package com.velox.repository;

import com.velox.model.EmailMonitoringEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailMonitoringRepository extends JpaRepository<EmailMonitoringEntity, Long> {
    // JpaRepository already provides count() method
}
