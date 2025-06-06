package com.online.balances.controller.member.dto;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;

import org.springframework.util.StringUtils;

import com.online.balances.model.entity.AccessHistory;
import com.online.balances.model.entity.consts.AccessStatus;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.Data;

@Data
public class AccessHistorySearch {
	private String username;
	private AccessStatus status;
	private LocalDate dateFrom;
	private LocalDate dateTo;
	private String keyword;

	public Predicate[] where(CriteriaBuilder cb, Root<AccessHistory> root) {
		var predicates = new ArrayList<Predicate>();

		if (StringUtils.hasLength(username)) {
			predicates.add(cb.equal(root.get("id").get("username"), username));
		}

		if (status != null) {
			predicates.add(cb.equal(root.get("status"), status));
		}

		if (dateFrom != null) {
			var value = dateFrom.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
			predicates.add(cb.greaterThanOrEqualTo(root.get("id").get("accessAt"), value));
		}

		if (dateTo != null) {
			var value = dateTo.plusDays(1).atStartOfDay(ZoneId.systemDefault()).toInstant();
			predicates.add(cb.lessThanOrEqualTo(root.get("id").get("accessAt"), value));
		}

		if (StringUtils.hasLength(keyword)) {
			predicates.add(cb.like(cb.lower(root.get("remark")), "%" + keyword.toLowerCase() + "%"));
		}

		return predicates.toArray(size -> new Predicate[size]);
	}

}
