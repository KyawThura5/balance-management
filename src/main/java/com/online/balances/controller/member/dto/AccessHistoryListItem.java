package com.online.balances.controller.member.dto;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import com.online.balances.model.entity.AccessHistory;
import com.online.balances.model.entity.consts.AccessStatus;
import com.online.balances.model.entity.consts.AccessType;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public record AccessHistoryListItem(
		String member, Instant accessAt,
		AccessType type, AccessStatus status, String remark)
{
	public LocalDateTime getAccessDateTime() {
		return accessAt.atZone(ZoneId.systemDefault()).toLocalDateTime();
	}

	public static void select(CriteriaBuilder cb, CriteriaQuery<AccessHistoryListItem> cq, Root<AccessHistory> root) {
		cq.select(cb.construct(AccessHistoryListItem.class, root.get("id").get("username"),
				root.get("id").get("accessAt"), root.get("type"), root.get("status"), root.get("remark")));
	}
}
