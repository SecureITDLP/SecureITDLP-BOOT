package com.velox.serviceImpl;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.velox.controller.AuthController;
import com.velox.dto.ClipboardModalDto;
import com.velox.dto.DashboardModalDto;
import com.velox.dto.EmailModalDto;
import com.velox.repository.ClipboardControlRepository;
import com.velox.repository.EmailMonitoringRepository;
import com.velox.repository.NetworkDlpRepository;
import com.velox.repository.PrinterLogRepository;
import com.velox.service.DashboardModalService;

@Service
public class DashboardModalServiceImpl implements DashboardModalService {

    @Autowired
    private NetworkDlpRepository networkDlpRepository;

    @Autowired 
    private EmailMonitoringRepository emailMonitoringrepository;
    
    @Autowired
    private PrinterLogRepository printerLogrepository;
    
    @Autowired
    private ClipboardControlRepository clipboardControlrepository;
 
  
    
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
    
    public List<DashboardModalDto> getDashboardData(String extension) {

        return networkDlpRepository.findDashboardDataByExtension(extension);

    }
    
    
    public List<EmailModalDto> getEmailData(String date) {

        return emailMonitoringrepository.getEmailData(date);

    }
    
    @Override
    public List<ClipboardModalDto> getClipboarddata(String date) {

        return clipboardControlrepository.getClipboardData(date);

    }
  

    @Override
    public List<?> getIncidentbyChannel(String channel) {

        switch (channel.toLowerCase()) {

            case "email":
                logger.info("Calling email repo");
                return emailMonitoringrepository.incidentbychannel();

            case "printer":
                logger.info("Calling printer repo");
                return printerLogrepository.printerincident();

            case "network":
                logger.info("Calling network repo");
                return networkDlpRepository.getNetworkincidentchannel();

            case "clipboard":
                logger.info("Calling clipboard repo");
                return clipboardControlrepository.getClipboardincidentchannel();
                
            case  "Peripherals"  :
            	logger.info("calling peripheral repo");
            	return networkDlpRepository.getNetworkincidentchannel1();
            	
            default:
                throw new RuntimeException("Invalid channel : " + channel);
        }
    }
    }
    

