
package com.velox.dto;

public class AgentStatusCountDto {
	private long active;
	private long inactive;
	private long total;
	private String message;

	public AgentStatusCountDto() {
	}

	public AgentStatusCountDto(long active, long inactive) {
		this.active = active;
		this.inactive = inactive;
		this.total = active + inactive;
		this.message = "Success";
	}

	public AgentStatusCountDto(String errorMessage) {
		this.message = errorMessage;
	}

	// Getters & setters
	public long getActive() {
		return active;
	}

	public void setActive(long active) {
		this.active = active;
	}

	public long getInactive() {
		return inactive;
	}

	public void setInactive(long inactive) {
		this.inactive = inactive;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}