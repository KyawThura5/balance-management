package com.online.balances.service.impl;

import java.util.function.Function;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.online.balances.controller.management.dto.MemberDetails;
import com.online.balances.controller.management.dto.MemberListItem;
import com.online.balances.controller.management.dto.MemberSearch;
import com.online.balances.controller.management.dto.MemberStatusForm;
import com.online.balances.model.PageResult;
import com.online.balances.model.entity.Member;
import com.online.balances.model.entity.consts.MemberStatus;
import com.online.balances.model.repo.MemberRepo;
import com.online.balances.service.MemberManagementService;
import com.online.balances.utils.EntityOperations;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberManagementServiceImpl implements MemberManagementService {

	private final MemberRepo memberRepo;

	@Override
	@Transactional
	public void updateStatus(long id, MemberStatusForm form) {
		var member = EntityOperations.safeCalls(memberRepo.findById(id), "member", "id", id);

		member.getAccount().setActive(form.getStatus());
		var activity = member.getActivity();
		activity.setStatus(form.getStatus() ? MemberStatus.Active : MemberStatus.Denied);
		activity.setStatusChangeReason(form.getReason());
	}

	@Override
	public MemberDetails findById(long id) {
		return EntityOperations.safeCalls(memberRepo.findById(id).map(MemberDetails::from), "member", "id", id);
	}


	@Override
	public PageResult<MemberListItem> search(MemberSearch search, int page, int size) {
		return memberRepo.search(queryFunc(search), countFunc(search), page, size);
	}

	private Function<CriteriaBuilder, CriteriaQuery<MemberListItem>> queryFunc(MemberSearch search) {

		return cb -> {
			var cq = cb.createQuery(MemberListItem.class);
			var root = cq.from(Member.class);
			MemberListItem.select(cq, root, cb);
			cq.where(search.where(cb, root));
			cq.orderBy(cb.desc(root.get("activity").get("updatedAt")));
			return cq;
		};
	}

	private Function<CriteriaBuilder, CriteriaQuery<Long>> countFunc(MemberSearch search) {

		return cb -> {
			var cq = cb.createQuery(Long.class);
			var root = cq.from(Member.class);
			cq.select(cb.count(root.get("id")));
			cq.where(search.where(cb, root));
			return cq;
		};
	}

}
