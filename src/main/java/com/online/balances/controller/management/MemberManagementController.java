package com.online.balances.controller.management;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.online.balances.controller.management.dto.MemberSearch;
import com.online.balances.controller.management.dto.MemberStatusForm;
import com.online.balances.service.MemberManagementService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("admin/member")
@RequiredArgsConstructor
public class MemberManagementController {

	private final MemberManagementService memberManagementService;

		@GetMapping
		String index(ModelMap model, MemberSearch form,
				@RequestParam(required = false, defaultValue = "0") int page,
				@RequestParam(required = false, defaultValue = "10") int size) {

			var result = memberManagementService.search(form, page, size);
			model.put("result", result);

			return "management/members/list";
		}
		@GetMapping("{id}")
		String showDetails(@PathVariable long id, ModelMap model) {

			var result = memberManagementService.findById(id);
			model.put("result", result);

			return "management/members/details";
		}

		@PostMapping("{id}/update")
		String updateStatus(ModelMap model, @PathVariable long id, @Validated MemberStatusForm form,
				BindingResult result) {

			if (result.hasErrors()) {
				var details = memberManagementService.findById(id);
				model.put("result", details);
				return "management/members/details";
			}

			memberManagementService.updateStatus(id, form);
			return "redirect:/admin/member/%d".formatted(id);

		}
}
