package com.online.balances.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.online.balances.model.entity.consts.BalanceType;

import jakarta.annotation.PostConstruct;

@Controller
@RequestMapping("member/entry")
public class MemberLedgerEntryController {
   @GetMapping("{type}")
	String index(@PathVariable String type,
			ModelMap modelMap) {
	   modelMap.put("type", BalanceType.from(type));
	   
		return "member/entries/list";
	}
   
   @GetMapping("add-new/{type}")
   String addNew(@PathVariable String type, ModelMap modelMap) {
	   
    modelMap.put("type", BalanceType.from(type));
	return "member/entries/edit";	   
   }
   
   @GetMapping("edit/{id}")
   String edit(@PathVariable String id) {
	   return "member/entries/edit";
	   
   }
   
   @PostMapping("save")
   String save() {
	   return "redirect:/member/balance/2025-02-01";
   }
   
   @PostMapping("save/add-item")
   String addNew() {
	   return "member/entries/edit";
   }
   
   @PostMapping("save/remove-item")
   String removeItem() {
	   return "member/entries/edit";
   }
}
