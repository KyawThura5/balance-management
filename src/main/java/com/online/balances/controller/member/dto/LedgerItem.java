package com.online.balances.controller.member.dto;

import java.time.LocalDateTime;

import com.online.balances.model.entity.consts.BalanceType;

public record LedgerItem(long id, String Name, BalanceType type, boolean status, LocalDateTime createdAt,
		LocalDateTime modifiedAt, int total) {

}
