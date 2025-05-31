package com.online.balances.controller.member.dto;

import com.online.balances.model.entity.consts.BalanceType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LedgerForm {
	private Integer id;
	@NotNull(message = "Please select Balance Type.")
	private BalanceType type;
	@NotBlank(message = "Please enter ledger name.")
	private String name;
	private Boolean status;

}
