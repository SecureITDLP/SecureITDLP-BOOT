package com.velox.dto;

public class ModeAccessCountDto {

    private Long preventCount;
    private Long allowCount;

    public ModeAccessCountDto(Long preventCount, Long allowCount) {
        this.preventCount = preventCount;
        this.allowCount = allowCount;
    }

    public Long getPreventCount() {
        return preventCount;
    }

    public void setPreventCount(Long preventCount) {
        this.preventCount = preventCount;
    }

    public Long getAllowCount() {
        return allowCount;
    }

    public void setAllowCount(Long allowCount) {
        this.allowCount = allowCount;
    }
}