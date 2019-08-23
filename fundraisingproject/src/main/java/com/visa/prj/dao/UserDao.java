package com.visa.prj.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.visa.prj.entity.User;

public interface UserDao extends JpaRepository<User, String> {

}
