package com.visa.prj.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.visa.prj.entity.Campaign;

public interface CampaignDao extends JpaRepository<Campaign, Integer>{
	@Query("update Campaign set currAmount = currAmount + :increment where cid = :id")
	public void updateCurrAmount(@Param("increment") double increment, @Param("id") int id);
	
	@Query("update Campaign set status = :status where cid = :id")
	public void updateStatus(@Param("status") String status, @Param("id") int id);
	
	@Query("from Campaign where status = :status")
	public List<Campaign> getCampaigns(@Param("status") String status);
}
