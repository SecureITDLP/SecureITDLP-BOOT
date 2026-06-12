package com.velox.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.velox.dto.EventTypeCountDto;
import com.velox.dto.ExtensionCountDto;
import com.velox.repository.NetworkDlpRepository;
import com.velox.service.NetworkDlpService;

@Service
public class NetworkDlpServiceImpl implements NetworkDlpService {

	@Autowired
	private NetworkDlpRepository repository;

	public List<EventTypeCountDto> getEventTypeCounts() {
		return repository.countEventsByEventType();
	}

	@Override
	public List<ExtensionCountDto> getExtensionCounts() {
		System.out.println("NetworkDlpServiceImpl.getExtensionCounts() called");

		try {
			List<ExtensionCountDto> counts = repository.countByExtension();
			System.out.println("Found " + counts.size() + " extension types");
			for (ExtensionCountDto dto : counts) {
				System.out.println("Extension: " + dto.getExtension() + " -> Count: " + dto.getCount());
			}
			return counts;

		} catch (Exception e) {
			System.err.println("ERROR in NetworkDlpServiceImpl: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException("Failed to retrieve extension counts from database", e);
		}
	}

}
