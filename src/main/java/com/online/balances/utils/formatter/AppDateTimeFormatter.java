package com.online.balances.utils.formatter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AppDateTimeFormatter {

	private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
	private static final DateTimeFormatter DF = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public String formatDateTime(LocalDateTime dateTime) {
		if (dateTime != null) {
			return DTF.format(dateTime);
		}
		return null;
	}

	public String formatDate(LocalDate date) {
		if (date != null) {
			return DF.format(date);
		}
		return null;

	}
}
