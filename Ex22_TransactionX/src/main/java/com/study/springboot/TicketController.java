package com.study.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.springboot.service.IBuyTicketService;

@Controller
public class TicketController {
	@Autowired
	private IBuyTicketService buyTicket;
	
	@RequestMapping("/buy_ticket")
	public String buy_ticket() {
		return "buy_ticket";
	}

}
