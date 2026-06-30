package com.velox.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.velox.dto.DashboardModalDto;
import com.velox.dto.EmailModalDto;
import com.velox.repository.ClipboardControlRepository;
import com.velox.repository.EmailMonitoringRepository;
import com.velox.repository.MonitoringFolderRepository;
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
	private ClipboardControlRepository clipboardControlRepository;

	@Autowired
	private MonitoringFolderRepository monitoringFolderRepository;

	@Override
	public List<DashboardModalDto> getDashboardData(String extension) {
		return networkDlpRepository.findDashboardDataByExtension(extension);
	}

	@Override
	public List<EmailModalDto> getEmailData(String date) {
		return emailMonitoringrepository.getEmailData(date);
	}

	@Override
	public List<?> getClipboardData(String date) {
		return clipboardControlRepository.getClipboardData(date);
	}

	@Override
	public List<?> printerincident() {
		return printerLogrepository.printerincident();
	}

	@Override
	public List<?> networkincident() {
		return networkDlpRepository.networkincident();
	}

	@Override
	public List<?> clipboardincident() {
		return clipboardControlRepository.clipboardincident();
	}

	@Override
	public List<?> EmailModalDto() {
		return emailMonitoringrepository.emailincident();
	}

	@Override
	public List<?> getNetworkincidentchannel() {
		return networkDlpRepository.getNetworkincidentchannel();
	}

	@Override
	public List<?> getDriveincident() {
		return monitoringFolderRepository.getDriveincident();
	}

	@Override
	public List<?> getIncidentbyChannel(String channel) {

		switch (channel.toLowerCase()) {

		case "email":
			return emailMonitoringrepository.emailincident();

		case "printer":
			return printerLogrepository.printerincident();

		case "network":
			return networkDlpRepository.getNetworkincidentchannel();

		case "clipboard":
			return clipboardControlRepository.getClipboardincidentchannel();

		case "drive":
			return monitoringFolderRepository.getDriveincident();

		default:
			throw new RuntimeException("Invalid channel : " + channel);
		}
	}

	@Override
	public List<?> getFileUploadData(String file) {
		return networkDlpRepository.getFileUploadData(file);
	}
}