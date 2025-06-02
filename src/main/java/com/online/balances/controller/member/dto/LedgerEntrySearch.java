package com.online.balances.controller.member.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class LedgerEntrySearch {
	private LocalDateTime dateFrom;
	private LocalDateTime dateTo;
	private String keyword;

}
