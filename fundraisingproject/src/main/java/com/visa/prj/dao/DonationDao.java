package com.visa.prj.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.visa.prj.entity.Donation;

public interface DonationDao extends JpaRepository<Donation, Integer>{
}
