package com.velox.repository;

import com.velox.model.NetworkDlpEntity;
import com.velox.dto.EventTypeCountDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface NetworkDlpRepository extends JpaRepository<NetworkDlpEntity, Long> {

    @Query("SELECT new com.velox.dto.EventTypeCountDto(n.eventType, COUNT(n)) " +
           "FROM NetworkDlpEntity n GROUP BY n.eventType")
    List<EventTypeCountDto> countEventsByEventType();
}
