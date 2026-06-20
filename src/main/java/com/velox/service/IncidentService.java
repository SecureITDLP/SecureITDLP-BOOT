package com.velox.service;

import com.velox.dto.IncidentByChannelDto;

public interface IncidentService {
    IncidentByChannelDto getIncidentCountsByChannel();
}
