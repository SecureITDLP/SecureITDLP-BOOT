package com.velox.dto;

import java.time.LocalDate;

public class EmailMonitoringCountDTO {
    private LocalDate date;
    private long count;

    public EmailMonitoringCountDTO(LocalDate date, long count) {
        this.date = date;
        this.count = count;
    }

    // Getters and setters (or use Lombok @Data)
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
    public long getCount() { return count; }
    public void setCount(long count) { this.count = count; }
}