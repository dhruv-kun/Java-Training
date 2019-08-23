package com.visa.prj.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "campaigns")
public class Campaign {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cid;
	
	private String title;
	private String descpretion;
	
	@Temporal(TemporalType.DATE)
	private Date deadline;
	
	private double currAmount;
	private double maxAmount;
	private String terms;
	private String status;
	
	public Campaign() {
	}
	

	public Campaign(int cid, String title, String descpretion, Date deadline, double currAmount, double maxAmount,
			String terms, String status) {
		this.cid = cid;
		this.title = title;
		this.descpretion = descpretion;
		this.deadline = deadline;
		this.currAmount = currAmount;
		this.maxAmount = maxAmount;
		this.terms = terms;
		this.status = status;
	}


	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescpretion() {
		return descpretion;
	}
	public void setDescpretion(String descpretion) {
		this.descpretion = descpretion;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	public String getTerms() {
		return terms;
	}
	public void setTerms(String terms) {
		this.terms = terms;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}


	public double getCurrAmount() {
		return currAmount;
	}


	public void setCurrAmount(double currAmount) {
		this.currAmount = currAmount;
	}


	public double getMaxAmount() {
		return maxAmount;
	}


	public void setMaxAmount(double maxAmount) {
		this.maxAmount = maxAmount;
	}

	
	
}
