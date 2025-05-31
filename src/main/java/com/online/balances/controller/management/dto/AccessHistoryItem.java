package com.online.balances.controller.management.dto;

import java.time.LocalDateTime;

import com.online.balances.model.entity.consts.AccessStatus;
import com.online.balances.model.entity.consts.AccessType;

public record AccessHistoryItem(
String member, LocalDateTime accessAt,
		AccessType type, AccessStatus status, String remark)
{

}
