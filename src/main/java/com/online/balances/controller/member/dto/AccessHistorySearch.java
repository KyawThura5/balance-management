package com.online.balances.controller.member.dto;

import java.time.LocalDateTime;

import com.online.balances.model.entity.consts.AccessStatus;

import lombok.Data;

@Data
public class AccessHistorySearch {
	private AccessStatus status;
	private LocalDateTime dateFrom;
	private LocalDateTime dateTo;
	private String keyword;

}
