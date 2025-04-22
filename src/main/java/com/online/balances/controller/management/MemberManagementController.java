package com.online.balances.controller.management;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

public class MemberManagementController {

	@Controller
	@RequestMapping("member/home")
	public class AdminHomeController {
		
		@GetMapping
		String index() {
			return "member/home";
		}
	}
}
