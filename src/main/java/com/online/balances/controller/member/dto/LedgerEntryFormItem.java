package com.online.balances.controller.member.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class LedgerEntryFormItem {
	@NotBlank(message = "Please enter item name.")
	private String itemName;
	@NotEmpty(message = "Please enter unit price.")
	private Integer unitPrice;
	@NotEmpty(message = "Please enter quantity")
	private Integer quantity;
}
