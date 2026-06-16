package com.velox.dto;

public class PeripheralCountDto {
    private String eventType;
    private Long count;

    public PeripheralCountDto() {}

    public PeripheralCountDto(String eventType, Long count) {
        this.eventType = eventType;
        this.count = count;
    }

    // Getters & Setters
    public String getEventType() { return eventType; }
    public void setEventType(String eventType) { this.eventType = eventType; }

    public Long getCount() { return count; }
    public void setCount(Long count) { this.count = count; }
}
