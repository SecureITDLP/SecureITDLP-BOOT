package com.velox.serviceImpl;

import com.velox.repository.AllIpAddressRepository;
import com.velox.service.UsbProtectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsbProtectionServiceImpl implements UsbProtectionService {

    @Autowired
    private AllIpAddressRepository allIpAddressRepository;

    @Override
    public List<String> getAllBranches() {
        return allIpAddressRepository.getAllBranches();
    }

    @Override
    public List<String> getDevicesByBranch(String branchName) {
        return allIpAddressRepository.getDevicesByBranch(branchName);
    }
}