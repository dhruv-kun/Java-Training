package com.visa.prj.dao;

import java.util.List;

import com.visa.prj.entity.Report;
import com.visa.prj.entity.Ticket;

public interface TicketDao {
	public void raiseTicket(Ticket t);
	public List<Ticket> getAllOpenTickets();
	public Ticket getOpenTicket();
	public void resolveTicket(Ticket t);
	public List<Report> getResolvedTicketReports();
}
