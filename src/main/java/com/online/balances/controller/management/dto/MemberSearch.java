package com.online.balances.controller.management.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class MemberSearch {
	private Boolean status;
	private LocalDateTime dateFrom;
	private LocalDateTime dateTo;
	private String name;

}
