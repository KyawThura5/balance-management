package com.online.balances.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.online.balances.controller.member.dto.LedgerForm;
import com.online.balances.controller.member.dto.LedgerSearch;
import com.online.balances.model.entity.consts.BalanceType;

@Controller
@RequestMapping("member/ledger")
public class MemberLedgerController {
	
	@GetMapping
	String index(ModelMap model, LedgerSearch search) {
		return "member/ledgers/list";
	}
	
	@ModelAttribute("balanceType")
	BalanceType[] types(){
		return BalanceType.values();
	}

	@PostMapping
	String save(ModelMap map, @Validated @ModelAttribute(name = "form") LedgerForm ledgerForm, BindingResult result) {
		if (result.hasErrors()) {
			return "member/ledgers/list";
		}
		return "redirect:/member/ledger";

	}

	@ModelAttribute(name = "form")
	LedgerForm ledgerForm(@RequestParam(required = false) Integer id) {
		if (id != null) {
			// Search from database
		}
		return new LedgerForm();

	}

}
