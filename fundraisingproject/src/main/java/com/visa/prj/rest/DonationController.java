package com.visa.prj.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.visa.prj.entity.Donation;
import com.visa.prj.service.CampaignService;

@RestController
public class DonationController {
	@Autowired
	private CampaignService campaignService;

	@GetMapping("donations")
	public @ResponseBody List<Donation> getDonations() {
		return campaignService.getDonations();
	}

	@PostMapping("donations") 
	public ResponseEntity<Donation> makeDonation(@RequestBody Donation d) {
		campaignService.makeDonation(d);
		return new ResponseEntity<>(d, HttpStatus.CREATED);
	}

}
