package com.online.balances.utils.formatter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class AppDateTimeFormatterModelAttribute {

	@ModelAttribute(name = "dtf")
	public AppDateTimeFormatter appDateTimeFormatter() {
		return new AppDateTimeFormatter();
	}

}
