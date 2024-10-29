package com.study.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot.dao.ITransaction1Dao;
import com.study.springboot.dao.ITransaction2Dao;

@Service
public class BuyTicketService 
          implements IBuyTicketService {
	@Autowired
	ITransaction1Dao transaction1;
	@Autowired
	ITransaction2Dao transaction2;

	@Override
	public int buy(String consumerId, int money, String error) {
		try {
			//정상입력처리
			transaction1.pay(consumerId, money);
			
			 //의도적 에러 발생
			if(error.equals("1")) {
				int n = 10/0;
			}
			//입력불가
			transaction2.pay(consumerId, money);
			
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

}
