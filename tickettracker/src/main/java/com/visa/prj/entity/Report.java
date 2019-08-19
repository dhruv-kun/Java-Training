package com.visa.prj.entity;

import java.util.Date;

public class Report {
	private int ticketId;
	private String ticketDesc;
	private Employee resolvedBy;
	private long timeDiff;
	
	public Report() {
	}
	
	public Report(int ticketId, String ticketDesc, Employee resolvedBy, Date startDate, Date endDate) {
		this.ticketId = ticketId;
		this.ticketDesc = ticketDesc;
		this.resolvedBy = resolvedBy;
		
		this.timeDiff = endDate.getTime() - startDate.getTime(); 
	}
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	public String getTicketDesc() {
		return ticketDesc;
	}
	public void setTicketDesc(String ticketDesc) {
		this.ticketDesc = ticketDesc;
	}
	public Employee getResolvedBy() {
		return resolvedBy;
	}
	public void setResolvedBy(Employee resolvedBy) {
		this.resolvedBy = resolvedBy;
	}

	public long getTimeDiff() {
		return timeDiff;
	}

	public void setTimeDiff(long timeDiff) {
		this.timeDiff = timeDiff;
	}

	@Override
	public String toString() {
		return "Report [ticketId=" + ticketId + ", ticketDesc=" + ticketDesc + ", resolvedBy=" + resolvedBy
				+ ", timeDiff=" + timeDiff + "]";
	}
	
	
	
	
}
