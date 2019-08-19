package com.visa.prj.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tickets")
public class Ticket {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ticketId;

	@Column(name="ticket_desc")
	private String ticketDesc;
	
	@Column(name="raised_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date raisedDate;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="raised_by")
	private Employee raisedBy;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="resolved_by")
	private Employee resolvedBy;
	
	@Column(name="resolved_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date resolvedDate;
	
	@Column(name="resolve_text")
	private String resolveText;

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

	public Date getRaisedDate() {
		return raisedDate;
	}

	public void setRaisedDate(Date raisedDate) {
		this.raisedDate = raisedDate;
	}

	public Employee getRaisedBy() {
		return raisedBy;
	}

	public void setRaisedBy(Employee raisedBy) {
		this.raisedBy = raisedBy;
	}

	public Employee getResolvedBy() {
		return resolvedBy;
	}

	public void setResolvedBy(Employee resolvedBy) {
		this.resolvedBy = resolvedBy;
	}

	public Date getResolvedDate() {
		return resolvedDate;
	}

	public void setResolvedDate(Date resolvedDate) {
		this.resolvedDate = resolvedDate;
	}

	public String getResolveText() {
		return resolveText;
	}

	public void setResolveText(String resolveText) {
		this.resolveText = resolveText;
	}

	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", ticketDesc=" + ticketDesc + ", raisedDate=" + raisedDate
				+ ", raisedBy=" + raisedBy + ", resolvedBy=" + resolvedBy + ", resolvedDate=" + resolvedDate
				+ ", resolveText=" + resolveText + "]";
	}
	
	
	
	
	
}
