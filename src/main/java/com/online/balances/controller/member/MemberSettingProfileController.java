package com.online.balances.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("member/profile")
public class MemberSettingProfileController {
	@GetMapping
	String index() {
		return "";
	}
}
