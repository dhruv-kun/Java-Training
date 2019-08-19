package com.visa.prj.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.visa.prj.entity.Report;
import com.visa.prj.entity.Ticket;

@Repository
public class TicketDaoJpaImpl implements TicketDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void raiseTicket(Ticket t) {
		em.persist(t);
	}

	@Override
	public List<Ticket> getAllOpenTickets() {
		return em.createQuery("select t from Ticket t where t.resolvedBy = null", Ticket.class).getResultList();
	}

	@Override
	public Ticket getOpenTicket() {
		return em.createQuery("select t from Ticket t where t.resolvedBy = null", Ticket.class).getSingleResult();
	}

	@Override
	public void resolveTicket(Ticket t) {
		em.merge(t);
	}

	@Override
	public List<Report> getResolvedTicketReports() {
		String jpql = "select new com.visa.prj.entity.Report(t.ticketId, t.ticketDesc, t.resolvedBy, t.raisedDate, t.resolvedDate) from Ticket t where t.resolvedBy != null";
		return em.createQuery(jpql, Report.class).getResultList();
	}
	
	

}
