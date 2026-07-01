package com.velox.service;

import com.velox.dto.ModeAccessCountDto;
import com.velox.dto.RestrictExternalDeviceDto;

import java.util.List;

public interface UsbProtectionService {

    List<String> getAllBranches();

    List<String> getDevicesByBranch(String branchName);

    ModeAccessCountDto getModeAccessCounts();

	List<RestrictExternalDeviceDto> getAllRestrictedDevices();
}