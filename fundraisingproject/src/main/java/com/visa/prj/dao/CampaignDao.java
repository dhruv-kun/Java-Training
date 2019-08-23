package com.visa.prj.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.visa.prj.entity.Campaign;

public interface CampaignDao extends JpaRepository<Campaign, Integer>{
	@Query("update Campaign set currAmount = currAmount + :increment")
	public void updateCurrAmount(@Param("incremnt") double increment);
	
	@Query("update Campaign set status = :status")
	public void updateStatus(@Param("status") String status);
	
	@Query("select Campaign where status = :status")
	public List<Campaign> getCampaigns(@Param("status") String status);
}
