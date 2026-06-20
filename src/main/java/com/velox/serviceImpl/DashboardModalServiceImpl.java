package com.velox.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.velox.dto.DashboardModalDto;
import com.velox.repository.NetworkDlpRepository;
import com.velox.service.DashboardModalService;

@Service
public class DashboardModalServiceImpl implements DashboardModalService {

    @Autowired
    private NetworkDlpRepository repository;

    public List<DashboardModalDto> getDashboardData(String extension) {

        return repository.findDashboardDataByExtension(extension);

    }

}