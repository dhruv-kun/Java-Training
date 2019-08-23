package com.visa.prj.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.visa.prj.entity.Campaign;
import com.visa.prj.service.CampaignService;

@RestController
public class CampaignController {
	@Autowired
	private CampaignService campaignService;

	@GetMapping("campaigns/{criteria}")
	public @ResponseBody List<Campaign> getCampaigns(@PathVariable("criteria") String criteria) {
		return campaignService.getCampaigns(criteria);
	}

	@PostMapping("campaigns") 
	public ResponseEntity<Campaign> addCustomer(@RequestBody Campaign c) {
		campaignService.makeCampaign(c);;
		return new ResponseEntity<>(c, HttpStatus.CREATED);
	}

}
