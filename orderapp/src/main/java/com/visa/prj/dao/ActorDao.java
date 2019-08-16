package com.visa.prj.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.visa.prj.entity.Actor;

@Repository
@Transactional
public class ActorDao {
	@PersistenceContext
	private EntityManager em;
	
	public void addActor(Actor a) {
		em.persist(a);
	}
	
	public Actor getActorById(int id) {
		return em.find(Actor.class, id);
	}
	

}
