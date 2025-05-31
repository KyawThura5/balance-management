package com.online.balances.controller.member.dto;

import java.time.LocalDateTime;

import com.online.balances.model.entity.consts.BalanceType;

import lombok.Data;

@Data
public class LedgerEntrySearch {

	private BalanceType type;
	private LocalDateTime dateFrom;
	private LocalDateTime dateTo;
	private String keyword;

}
