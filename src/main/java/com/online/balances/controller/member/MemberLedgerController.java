package com.online.balances.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.online.balances.model.entity.consts.BalanceType;

@Controller
@RequestMapping("member/ledger")
public class MemberLedgerController {
	
	@GetMapping
	String index() {
		return "member/ledgers/list";
	}
	
	@ModelAttribute("balanceType")
	BalanceType[] types(){
		return BalanceType.values();
	}

}
