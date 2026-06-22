package com.velox.serviceImpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.velox.dto.DashboardModalDto;
import com.velox.dto.EmailModalDto;
import com.velox.repository.EmailMonitoringRepository;
import com.velox.repository.NetworkDlpRepository;
import com.velox.service.DashboardModalService;

@Service
public class DashboardModalServiceImpl implements DashboardModalService {

    @Autowired
    private NetworkDlpRepository networkDlpRepository;

    @Autowired 
    private EmailMonitoringRepository emailMonitoringrepository;
    
    public List<DashboardModalDto> getDashboardData(String extension) {

        return networkDlpRepository.findDashboardDataByExtension(extension);

    }
    
    
    public List<EmailModalDto> getEmailData(String date) {

        return emailMonitoringrepository.getEmailData(date);

    }

}