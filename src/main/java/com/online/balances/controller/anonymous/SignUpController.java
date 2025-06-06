package com.online.balances.controller.anonymous;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.online.balances.controller.anonymous.dto.SignUpForm;
import com.online.balances.service.SignUpService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/signup")
@RequiredArgsConstructor
public class SignUpController {

	private final SignUpService signUpService;

	@GetMapping
	public String index() {
		return "anonymous/signup";
	}

	@PostMapping
	public String signUp(@Validated @ModelAttribute(name = "form") SignUpForm signUpForm, BindingResult result,
			RedirectAttributes redirectAttributes, ModelMap model) {
		if (result.hasErrors()) {
			return "anonymous/signup";
		}

		try {
			var message = signUpService.signUp(signUpForm);
			redirectAttributes.addFlashAttribute("message", message);
		} catch (Exception e) {
			model.put("message", e.getMessage());
			return "anonymous/signup";
		}

		return "redirect:/signin";

	}
	@ModelAttribute(name = "form")
	public SignUpForm singUpForm() {
		return new SignUpForm();
	}

}
