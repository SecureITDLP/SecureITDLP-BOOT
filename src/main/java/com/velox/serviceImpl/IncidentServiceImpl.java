package com.velox.serviceImpl;

import com.velox.dto.IncidentByChannelDto;
import com.velox.dto.PeripheralCountDto;
import com.velox.repository.*;
import com.velox.service.IncidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncidentServiceImpl implements IncidentService {

    @Autowired
    private EmailMonitoringRepository emailRepo;

    @Autowired
    private NetworkDlpRepository networkDlpRepo;

    @Autowired
    private PrinterLogRepository printerRepo;

    @Autowired
    private ClipboardControlRepository clipboardRepo;

    @Autowired
    private MonitoringFolderRepository monitoringFolderRepo;

    @Override
    public IncidentByChannelDto getIncidentCountsByChannel() {
        long emailIncident = emailRepo.count();
        // Network Upload – adjust the event type string to match your actual data
        long networkIncident = networkDlpRepo.countByEventType("Network Upload");

        long printerIncident = printerRepo.count();
        long clipboardIncident = clipboardRepo.count();
        long driveIncident = monitoringFolderRepo.count();

        // Peripheral count = sum of DVD Burn + USB Transfer
        List<PeripheralCountDto> peripheralList = networkDlpRepo.countPeripheralEventTypes();
        long peripheralIncident = peripheralList.stream()
                .mapToLong(PeripheralCountDto::getCount)
                .sum();

        return new IncidentByChannelDto(
        		emailIncident,
        		networkIncident,
        		printerIncident,
        		clipboardIncident,
        		driveIncident,
        		peripheralIncident
        );
    }
}
