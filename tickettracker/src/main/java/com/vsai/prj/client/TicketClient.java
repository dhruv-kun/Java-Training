package com.vsai.prj.client;

import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.visa.prj.entity.Employee;
import com.visa.prj.entity.Report;
import com.visa.prj.entity.Ticket;
import com.visa.prj.service.TicketService;

public class TicketClient {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();

		ctx.scan("com.visa.prj");
		ctx.refresh();
		
		TicketService ts = ctx.getBean("ticketService", TicketService.class);
		
//		Employee a1 = new Employee();
//		a1.setName("dhruv");
//		a1.setEmail("d@visa.com");
//		a1.setDept("map");
//		
//		Employee a2 = new Employee();
//		a2.setName("vignesh");
//		a2.setEmail("v@visa.com");
//		a2.setDept("np");
//		
//		Employee a3 = new Employee();
//		a3.setName("rishi");
//		a3.setEmail("r@visa.com");
//		a3.setDept("it");
//	
//		
//		Ticket t = new Ticket();
//		t.setRaisedBy(a1);
//		t.setRaisedDate(new Date());
//		t.setTicketDesc("Lorem Epslum");
//		
//		
//		
//		ts.raiseTicket(t);
//		
//		
//		t = ts.getOpenTicket();
//		System.out.println(t);
//		
//		t.setResolvedBy(a3);
//		t.setResolvedDate(new Date());
//		t.setResolveText("Lorem Epslum");
//		
//		ts.resolveTicket(t);
//		
//		System.out.println(t);
		
		List<Report> reportList = ts.getResolvedTicketReports();
		
		for (Report r: reportList)
			System.out.println(r);
		

	}

}
