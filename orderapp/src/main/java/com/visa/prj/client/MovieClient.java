package com.visa.prj.client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.visa.prj.dao.ActorDao;
import com.visa.prj.dao.MovieDao;
import com.visa.prj.entity.Actor;
import com.visa.prj.entity.Movie;

public class MovieClient {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();

		ctx.scan("com.visa.prj");
		ctx.refresh();
		
		MovieDao dao = ctx.getBean("movieDao", MovieDao.class);
		
		
		Movie m = new Movie();
//		m.setName("Pulp Fiction");
		
//		Actor a1 = new Actor();
//		a1.setName("John Travota");
//		
//		Actor a2 = new Actor();
//		a2.setName("Uma Thruman");

		
//		m.getActors().add(a1);
//		m.getActors().add(a2);
		
		ActorDao aDao = ctx.getBean("actorDao", ActorDao.class);
		Actor a = aDao.getActorById(1);
		
		m.setName("Kill Bill Vol 1");
		m.getActors().add(a);
		
		dao.addMovie(m);
		System.out.println("Saved!!!");
	}

}
