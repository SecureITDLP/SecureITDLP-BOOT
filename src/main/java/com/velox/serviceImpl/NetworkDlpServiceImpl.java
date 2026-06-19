package com.velox.serviceImpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.velox.dto.EventTypeCountDto;
import com.velox.dto.ExtensionCountDto;
import com.velox.dto.LatestIncidentDto;
import com.velox.dto.PeripheralCountDto;
import com.velox.dto.UploadCountDTO;
import com.velox.repository.NetworkDlpRepository;
import com.velox.service.NetworkDlpService;

import net.bytebuddy.asm.Advice.Local;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;

@Service
public class NetworkDlpServiceImpl implements NetworkDlpService {

	@Autowired
	private NetworkDlpRepository repository;

	public List<EventTypeCountDto> getEventTypeCounts() {
		return repository.countEventsByEventType();
	}

	public List<UploadCountDTO> getTodaysUploadCount() {
		return repository.getUploadCountByDate(LocalDate.now());
	}
	
	@Override
	public List<ExtensionCountDto> getExtensionCounts() {
	
		try {
			List<ExtensionCountDto> counts = repository.countByExtension();
//			System.out.println("Found " + counts.size() + " extension types");
			for (ExtensionCountDto dto : counts) {
//				System.out.println("Extension: " + dto.getExtension() + " -> Count: " + dto.getCount());
			}
			return counts;

		} catch (Exception e) {
//			System.err.println("ERROR in NetworkDlpServiceImpl: " + e.getMessage());
			e.printStackTrace();
			throw new RuntimeException("Failed to retrieve extension counts from database", e);
		}
	}
	
	 @Override
	    public List<PeripheralCountDto> getPeripheralCounts() {
	        // Using the JPQL query that returns DTOs directly
	        return repository.countPeripheralEventTypes();
	    }

	 @Override
	    public List<LatestIncidentDto> getLatestIncidents(int limit) {
	        Pageable pageable = PageRequest.of(0, limit);
	        return repository.findLatestIncidents(pageable);
	    }
}
