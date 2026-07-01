package com.velox.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.velox.dto.ModeAccessCountDto;
import com.velox.dto.RestrictExternalDeviceDto;
import com.velox.model.RestrictExternalDevice;

@Repository
public interface RestrictExternalDeviceRepository
        extends JpaRepository<RestrictExternalDevice, Integer> {

    @Query("SELECT COUNT(r) FROM RestrictExternalDevice r WHERE LOWER(r.modeAccess) = 'prevent'")
    Long getPreventCount();

    @Query("SELECT COUNT(r) FROM RestrictExternalDevice r WHERE LOWER(r.modeAccess) = 'allow'")
    Long getAllowCount();

    
    @Query("SELECT new com.velox.dto.RestrictExternalDeviceDto(" +
    	       "r.branchName, " +
    	       "r.ipAddress, " +
    	       "r.deviceName, " +
    	       "r.modeAccess, " +
    	       "r.cTime) " +
    	       "FROM RestrictExternalDevice r")
	List<RestrictExternalDeviceDto> getAllRestrictedDevices();
}
