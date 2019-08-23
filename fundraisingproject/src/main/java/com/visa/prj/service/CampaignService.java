package com.visa.prj.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.visa.prj.dao.CampaignDao;
import com.visa.prj.dao.DonationDao;
import com.visa.prj.dao.UserDao;
import com.visa.prj.entity.Campaign;
import com.visa.prj.entity.Donation;

public class CampaignService {
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private CampaignDao campaignDao;
	
	@Autowired
	private DonationDao donationDao;
	
	@Transactional
	public void makeCampaign(Campaign c) {
		campaignDao.save(c);
	}
	
	public List<Campaign> getCampaigns() {
		return campaignDao.getCampaigns("active");
	}
	
	@Transactional
	public void makeDonation(Donation d) {
		Campaign c = d.getCampaign();
		c.setCurrAmount(c.getCurrAmount() + d.getAmount());
		if (c.getCurrAmount() >= c.getMaxAmount()) {
			campaignDao.updateStatus("closed");
		}
		userDao.save(d.getUser());
		campaignDao.updateCurrAmount(d.getAmount());
		donationDao.save(d);
	}
	
	public List<Donation> getDonations() {
		return donationDao.findAll();
	}
}
