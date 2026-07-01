package com.velox.serviceImpl;

import com.velox.dto.ModeAccessCountDto;
import com.velox.dto.RestrictExternalDeviceDto;
import com.velox.repository.AllIpAddressRepository;
import com.velox.repository.RestrictExternalDeviceRepository;
import com.velox.service.UsbProtectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsbProtectionServiceImpl implements UsbProtectionService {

    @Autowired
    private AllIpAddressRepository allIpAddressRepository;

    @Autowired
    private RestrictExternalDeviceRepository restrictExternalDeviceRepository;

    @Override
    public List<String> getAllBranches() {
        return allIpAddressRepository.getAllBranches();
    }

    @Override
    public List<String> getDevicesByBranch(String branchName) {
        return allIpAddressRepository.getDevicesByBranch(branchName);
    }

    @Override
    public ModeAccessCountDto getModeAccessCounts() {

        Long preventCount = restrictExternalDeviceRepository.getPreventCount();
        Long allowCount = restrictExternalDeviceRepository.getAllowCount();

        return new ModeAccessCountDto(preventCount, allowCount);
    }
    
    @Override
    public List<RestrictExternalDeviceDto> getAllRestrictedDevices() {
        return restrictExternalDeviceRepository.getAllRestrictedDevices();
    }
}