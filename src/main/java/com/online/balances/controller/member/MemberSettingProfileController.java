package com.online.balances.controller.member;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.online.balances.controller.member.dto.ProfileEditForm;
import com.online.balances.model.entity.Region;
import com.online.balances.service.LocationService;
import com.online.balances.service.MemberProfileService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("member/profile")
public class MemberSettingProfileController {

	private final LocationService locationService;
	private final MemberProfileService memberProfileService;
	@GetMapping
	String editProfile() {
		return "member/profile/edit";
	}

	@PostMapping
	String updateProfile(@Validated @ModelAttribute(name = "form") ProfileEditForm editForm, BindingResult result) {

		if (result.hasErrors()) {
			return "member/profile/edit";
		}
		var username = SecurityContextHolder.getContext().getAuthentication().getName();
		memberProfileService.save(username, editForm);
		return "redirect:/member/home";
	}

	@PostMapping("photo")
	String uploadPhoto(@RequestParam MultipartFile file) {
		System.out.println(file.getOriginalFilename());
		return "redirect:/member/profile";
	}

	@ModelAttribute(name = "regions")
	List<Region> getRegions() {
		return locationService.getAllLocations();
	}

	@ModelAttribute(name = "form")
	ProfileEditForm form() {

		var username = SecurityContextHolder.getContext().getAuthentication().getName();
		return memberProfileService.getEditForm(username);
	}
}
