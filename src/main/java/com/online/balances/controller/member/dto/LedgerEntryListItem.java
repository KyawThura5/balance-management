package com.online.balances.controller.member.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record LedgerEntryListItem(String code, LocalDateTime issueAt, String LedgerName, String particular,
		BigDecimal amount) {

}
