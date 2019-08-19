package com.visa.prj.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visa.prj.dao.EmployeeDao;
import com.visa.prj.dao.TicketDao;
import com.visa.prj.entity.Employee;
import com.visa.prj.entity.Report;
import com.visa.prj.entity.Ticket;

@Service
public class TicketService {
	@Autowired
	private EmployeeDao empDao;
	
	@Autowired
	private TicketDao ticketDao;
	
	@Transactional
	public void raiseTicket(Ticket t) {
		ticketDao.raiseTicket(t);
	}
	
	@Transactional
	public void resolveTicket(Ticket t) {
		Employee emp = t.getResolvedBy();
		if (emp.getDept() == "it") 
			ticketDao.resolveTicket(t);
	}
	public Ticket getOpenTicket() {
		return ticketDao.getOpenTicket();
	}
	public List<Ticket> getAllOpenTicket() {
		return ticketDao.getAllOpenTickets();
	}
	public List<Employee> getAllEmployees() {
		return empDao.getAllEmployees();
	}
	
	public List<Report> getResolvedTicketReports() {
		return ticketDao.getResolvedTicketReports();
	}
	
	
}
