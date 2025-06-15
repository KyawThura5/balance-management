package com.online.balances.controller.member;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.online.balances.service.MemberProfileService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("member/home")
public class MemberHomeController {

	private final MemberProfileService profileService;

	@GetMapping
	String index(ModelMap model) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();

		var profile = profileService.loadProfile(username);
		model.put("profile", profile);
		return "/member/home";
	}
}
