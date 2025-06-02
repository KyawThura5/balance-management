package com.online.balances.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.online.balances.controller.member.dto.LedgerEntryForm;
import com.online.balances.controller.member.dto.LedgerEntrySearch;
import com.online.balances.model.entity.consts.BalanceType;

@Controller
@RequestMapping("member/entry")
public class MemberLedgerEntryController {
   @GetMapping("{type}")
	String index(ModelMap modelMap, @PathVariable BalanceType type, LedgerEntrySearch search,
			@RequestParam(required = false, defaultValue = "0") int page,
			@RequestParam(required = false, defaultValue = "10") int size) {
	   
		return "member/entries/list";
	}
   
   @GetMapping("add-new/{type}")
	String addNew(@PathVariable BalanceType type, ModelMap modelMap) {
	return "member/entries/edit";	   
   }
   
   @GetMapping("edit/{id}")
   String edit(@PathVariable String id) {
	   return "member/entries/edit";
	   
   }
   
   @PostMapping("save")
	String save(@Validated @ModelAttribute(name = "form") LedgerEntryForm form, BindingResult result) {
		if (result.hasErrors()) {
			return "member/entries/edit";
		}
	   return "redirect:/member/balance/2025-02-01";
   }
   @PostMapping("save/add-item")
	String addNew(@ModelAttribute(name = "form") LedgerEntryForm form, BindingResult result) {
	   return "member/entries/edit";
   }
   
   @PostMapping("save/remove-item")
   String removeItem() {
	   return "member/entries/edit";
   }
}
