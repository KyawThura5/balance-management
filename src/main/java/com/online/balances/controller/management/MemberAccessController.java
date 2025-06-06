package com.online.balances.controller.management;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.online.balances.controller.member.dto.AccessHistorySearch;
import com.online.balances.service.AccessHistoryService;

import lombok.RequiredArgsConstructor;

@Controller("adminMemberAccessController")
@RequestMapping("admin/access")
@RequiredArgsConstructor
public class MemberAccessController {
	private final AccessHistoryService accessHistoryService;
	@GetMapping
	String search(ModelMap map, AccessHistorySearch form,
			@RequestParam(required = false, defaultValue = "0") int page,
			@RequestParam(required = false, defaultValue = "10") int size, ModelMap model) {

		var username = SecurityContextHolder.getContext().getAuthentication().getName();
		form.setUsername(username);
		var result = accessHistoryService.search(form, page, size);

		model.put("result", result);
		return "management/access/list";
	}
}
