package com.velox.dto;

public class EventTypeCountDto {
    private String eventType;
    private Long count;

    public EventTypeCountDto(String eventType, Long count) {
        this.eventType = eventType;
        this.count = count;
    }

    public String getEventType() { return eventType; }
    public void setEventType(String eventType) { this.eventType = eventType; }

    public Long getCount() { return count; }
    public void setCount(Long count) { this.count = count; }
}
