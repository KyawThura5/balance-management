package com.online.balances.controller.member.dto;

import com.online.balances.model.entity.consts.BalanceType;

import lombok.Data;

@Data
public class LedgerSearch {
	private BalanceType type;
	private String keyword;
}
