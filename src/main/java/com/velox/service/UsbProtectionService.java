package com.velox.service;

import java.util.List;

public interface UsbProtectionService {

    List<String> getAllBranches();

    List<String> getDevicesByBranch(String branchName);

}