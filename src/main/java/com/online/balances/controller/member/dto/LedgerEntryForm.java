package com.online.balances.controller.member.dto;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LedgerEntryForm {
	@NotNull(message = "Please select ledger.")
	private Integer ledgerId;
	@NotBlank(message = "Please enter particular.")
	private String particular;
	@NotEmpty(message = "Please enter entry item. ")
	private List<@Valid LedgerEntryFormItem> items;
}
