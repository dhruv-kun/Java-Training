package com.visa.prj.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.visa.prj.entity.Movie;

@Repository
@Transactional
public class MovieDao {

	@PersistenceContext
	private EntityManager em;
	
	public void addMovie(Movie m) {
		em.persist(m);
	}
	
	public Movie getMovie(int id) {
		return em.find(Movie.class, id);
	}
	
	public void updateMovie(Movie m) {
		em.merge(m);
	}
}
