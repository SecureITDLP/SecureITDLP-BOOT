package com.velox.service;

import java.util.List;

import com.velox.dto.DashboardModalDto;
import com.velox.dto.EmailModalDto;

public interface DashboardModalService {

	List<DashboardModalDto> getDashboardData(String extension);

	List<EmailModalDto> getEmailData(String date);

	List<?> getClipboardData(String date);

	List<?> printerincident();

	List<?> networkincident();

	List<?> clipboardincident();

	List<?> EmailModalDto();

	List<?> getNetworkincidentchannel();

	List<?> getDriveincident();

	List<?> getIncidentbyChannel(String channel);

	List<?> getFileUploadData(String file);
}