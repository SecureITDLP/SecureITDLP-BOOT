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
        long emailCount = emailRepo.count();
        // Network Upload – adjust the event type string to match your actual data
        long networkUploadCount = networkDlpRepo.countByEventType("Network Upload");

        long printerCount = printerRepo.count();
        long clipboardCount = clipboardRepo.count();
        long monitoringFolderCount = monitoringFolderRepo.count();

        // Peripheral count = sum of DVD Burn + USB Transfer
        List<PeripheralCountDto> peripheralList = networkDlpRepo.countPeripheralEventTypes();
        long peripheralCount = peripheralList.stream()
                .mapToLong(PeripheralCountDto::getCount)
                .sum();

        return new IncidentByChannelDto(
                emailCount,
                networkUploadCount,
                printerCount,
                clipboardCount,
                monitoringFolderCount,
                peripheralCount
        );
    }
}
