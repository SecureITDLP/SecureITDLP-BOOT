package com.velox.dto;

public class DailyApplicationCountDto {
    private String date;    // or java.util.Date if you prefer
    private Long count;

    // Default constructor (for JSON serialization)
    public DailyApplicationCountDto() {}

    // Constructor for manual mapping
    public DailyApplicationCountDto(String date, Long count) {
        this.date = date;
        this.count = count;
    }

    // Getters & Setters
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public Long getCount() { return count; }
    public void setCount(Long count) { this.count = count; }
}
