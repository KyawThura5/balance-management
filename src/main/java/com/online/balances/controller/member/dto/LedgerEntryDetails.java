package com.online.balances.controller.member.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record LedgerEntryDetails(
		String code, String LedgerName,
		BigDecimal count,
		LocalDateTime issueAt, String particular, java.util.List<LedgerEntryDetailsItem> items)
{

}
