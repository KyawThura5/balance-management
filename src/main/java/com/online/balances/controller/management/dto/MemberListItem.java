package com.online.balances.controller.management.dto;

import java.time.LocalDateTime;

import com.online.balances.model.entity.Member;
import com.online.balances.model.entity.consts.MemberStatus;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public record MemberListItem(long id, String name, LocalDateTime registerAt, LocalDateTime lastLogin,
		MemberStatus status,
		LocalDateTime changeAt, String remark) {

	public static void select(CriteriaQuery<MemberListItem> cq, Root<Member> root, CriteriaBuilder cb) {
		cq.select(cb.construct(MemberListItem.class, root.get("id"), root.get("name"),
				root.get("activity").get("registerAt"), root.get("activity").get("lastAccessAt"),
				root.get("activity").get("status"), root.get("activity").get("updatedAt"),
				root.get("activity").get("statusChangeReason")));
	}
}
