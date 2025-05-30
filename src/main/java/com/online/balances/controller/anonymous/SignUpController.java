package com.online.balances.controller.anonymous;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.online.balances.controller.anonymous.dto.SignUpForm;

@Controller
@RequestMapping("/signup")
public class SignUpController {

	@GetMapping
	String index() {
		return "anonymous/signup";
	}

	@PostMapping
	String signUp(@Validated @ModelAttribute(name = "form") SignUpForm signUpForm, BindingResult result) {
		if (result.hasErrors()) {
			return "anonymous/singup";
		}
		return "redirect:/signin";

	}
	@ModelAttribute(name = "form")
	SignUpForm singUpForm() {
		return new SignUpForm();
	}

}
