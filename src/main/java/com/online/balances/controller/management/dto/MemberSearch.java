package com.online.balances.controller.management.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.online.balances.model.entity.Member;
import com.online.balances.model.entity.consts.MemberStatus;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.Data;

@Data
public class MemberSearch {
	private MemberStatus status;
	private LocalDate dateFrom;
	private LocalDate dateTo;
	private String name;

	public Predicate[] where(CriteriaBuilder cb, Root<Member> root) {
		List<Predicate> predicates = new ArrayList<>();

		if (status != null) {
			predicates.add(cb.equal(root.get("activity").get("status"), status));
		}

		if (dateFrom != null) {
			predicates.add(cb.greaterThanOrEqualTo(root.get("activity").get("registerAt"), dateFrom.atStartOfDay()));
		}

		if (dateTo != null) {
			predicates.add(
					cb.lessThanOrEqualTo(root.get("activity").get("registerAt"), dateTo.plusDays(1).atStartOfDay()));
		}

		if (name != null && !name.isBlank()) {
			predicates.add(cb.like(cb.lower(root.get("name")), "%" + name.toLowerCase() + "%"));
		}

		return predicates.toArray(size -> new Predicate[size]);
	}
}
