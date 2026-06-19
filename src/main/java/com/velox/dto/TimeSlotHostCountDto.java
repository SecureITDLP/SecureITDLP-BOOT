package com.velox.dto;

public class TimeSlotHostCountDto {

    private String timeSlot;
    private String hostnames;
    private Long uniqueHostCount;

    public TimeSlotHostCountDto() {
        super();
    }

    public TimeSlotHostCountDto(String timeSlot, String hostnames, Long uniqueHostCount) {
        super();
        this.timeSlot = timeSlot;
        this.hostnames = hostnames;
        this.uniqueHostCount = uniqueHostCount;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    public String getHostnames() {
        return hostnames;
    }

    public void setHostnames(String hostnames) {
        this.hostnames = hostnames;
    }

    public Long getUniqueHostCount() {
        return uniqueHostCount;
    }

    public void setUniqueHostCount(Long uniqueHostCount) {
        this.uniqueHostCount = uniqueHostCount;
    }

    @Override
    public String toString() {
        return "TimeSlotHostCountDto [timeSlot=" + timeSlot
                + ", hostnames=" + hostnames
                + ", uniqueHostCount=" + uniqueHostCount + "]";
    }
}