package com.study.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.springboot.service.BuyAndLogService;
import com.study.springboot.service.IBuyTicketService;

@Controller
public class TicketController {
//	@Autowired
//	private IBuyTicketService buyTicket;
	@Autowired
	BuyAndLogService buyTicketLog;
	
	
	@RequestMapping("/buy_ticket")
	public String buy_ticket() {
		return "buy_ticket";
	}
	
	@RequestMapping("/buy_ticket_card")
	public String buy_ticket_card(
			@RequestParam("consumerId") String consumerId,
			@RequestParam("amount") int amount,//String -> int
			@RequestParam("error") String error,
			Model model
			) {
		int nResult = buyTicketLog.buy(consumerId, amount, error);
		
		model.addAttribute("consumerId", consumerId);
		model.addAttribute("amount", amount);
		
		if(nResult == 1) {
			return "buy_ticket_end";
		}else {
			return "buy_ticket_error";
		}
		
	}

}
