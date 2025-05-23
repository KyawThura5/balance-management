package com.online.balances.controller.management;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("admin/member")
public class MemberManagementController {
		
		@GetMapping
		String index() {
			return "management/members/list";
		}
		
		@GetMapping("{id}")
		String detail(@PathVariable int id) {
			return "management/members/details";
		}
}
