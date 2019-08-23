package com.visa.prj.entity;

import java.util.Date;

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
@Table(name = "donations")
public class Donation {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int did;
	
	@ManyToOne
	@JoinColumn(name="campaign_id")
	private Campaign campaign;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	
	@Column(name="donated_on")
	@Temporal(TemporalType.TIMESTAMP)
	private Date donatedOn;
	
	private double amount;
	private String status;
	
	public Donation() {
	}

	public Donation(int did, Campaign campaign, User user, Date donatedOn, double amount, String status) {
		this.did = did;
		this.campaign = campaign;
		this.user = user;
		this.donatedOn = donatedOn;
		this.amount = amount;
		this.status = status;
	}

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public Campaign getCampaign() {
		return campaign;
	}

	public void setCampaign(Campaign campaign) {
		this.campaign = campaign;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getDonatedOn() {
		return donatedOn;
	}

	public void setDonatedOn(Date donatedOn) {
		this.donatedOn = donatedOn;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
