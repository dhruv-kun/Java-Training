package com.visa.prj.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visa.prj.dao.CampaignDao;
import com.visa.prj.dao.DonationDao;
import com.visa.prj.dao.UserDao;
import com.visa.prj.entity.Campaign;
import com.visa.prj.entity.Donation;
import com.visa.prj.entity.User;

@Service
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

	public List<Campaign> getCampaigns(String criteria) {
		return campaignDao.getCampaigns(criteria);
	}

	@Transactional
	public void makeDonation(Donation d) {
		System.out.println(d.getCampaign().getCid());
		Campaign c = campaignDao.findById(d.getCampaign().getCid()).get();
		System.out.println("===================" + "active".equals(c.getStatus()) + "=================");
		System.out.println(c.getStatus());
		if ("active".equals(c.getStatus())) {
			c.setCurrAmount(c.getCurrAmount() + d.getAmount());
			if (c.getCurrAmount() >= c.getMaxAmount()) {
				campaignDao.updateStatus("closed", c.getCid());
			}
			userDao.save(d.getUser());
			campaignDao.updateCurrAmount(d.getAmount(), c.getCid());
			donationDao.save(d);
		}
	}

	public List<Donation> getDonations() {
		return donationDao.findAll();
	}

	public List<User> getUsers() {
		return userDao.findAll();
	}

	@Transactional
	public void addUser(User u) {
		userDao.save(u);
	}
}
