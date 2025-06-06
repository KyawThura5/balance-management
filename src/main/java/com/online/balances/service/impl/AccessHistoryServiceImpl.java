package com.online.balances.service.impl;

import java.time.Instant;
import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.online.balances.controller.member.dto.AccessHistoryListItem;
import com.online.balances.controller.member.dto.AccessHistorySearch;
import com.online.balances.model.PageResult;
import com.online.balances.model.entity.AccessHistory;
import com.online.balances.model.entity.consts.AccessStatus;
import com.online.balances.model.entity.consts.AccessType;
import com.online.balances.model.entity.embeddables.AccessHistoryPK;
import com.online.balances.model.repo.AccessHistoryRepo;
import com.online.balances.service.AccessHistoryService;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccessHistoryServiceImpl implements AccessHistoryService {
	private final AccessHistoryRepo accessHistoryRepo;

	@Override
	public void signUp(String username) {
		creatHistory(username, AccessType.Signup, AccessStatus.Success);

	}

	@Override
	public void loginSuccess(String name) {
		creatHistory(name, AccessType.Login, AccessStatus.Success);

	}

	@Override
	public void logoutSuccess(String name) {
		creatHistory(name, AccessType.Logout, AccessStatus.Success);

	}

	@Override
	public void loginFails(String name, String message) {
		creatHistory(name, AccessType.Login, AccessStatus.Fails, message);

	}

	private void creatHistory(String username, AccessType type, AccessStatus status) {
		creatHistory(username, type, status, null);

	}

	@Override
	public PageResult<AccessHistoryListItem> search(AccessHistorySearch form, int page, int size) {

		return accessHistoryRepo.search(queryFunc(form), CountFunc(form), page, size);
	}

	private Function<CriteriaBuilder, CriteriaQuery<Long>> CountFunc(AccessHistorySearch form) {

		return cb -> {
			var cq = cb.createQuery(Long.class);
			var root = cq.from(AccessHistory.class);
			cq.select(cb.count(root.get("id")));
			cq.where(form.where(cb, root));
			return cq;
		};
	}

	private Function<CriteriaBuilder, CriteriaQuery<AccessHistoryListItem>> queryFunc(AccessHistorySearch form) {

		return cb -> {
			var cq = cb.createQuery(AccessHistoryListItem.class);
			var root = cq.from(AccessHistory.class);

			AccessHistoryListItem.select(cb, cq, root);
			cq.where(form.where(cb, root));
			cq.orderBy(cb.desc(root.get("id").get("accessAt")));
			return cq;
		};
	}

	private void creatHistory(String username, AccessType type, AccessStatus status, String message) {
		var id = new AccessHistoryPK();
		id.setAccessAt(Instant.now());
		id.setUsername(username);
		var accessHistory = new AccessHistory();
		accessHistory.setId(id);
		accessHistory.setType(type);
		accessHistory.setStatus(status);
		accessHistory.setRemark(message);
		accessHistoryRepo.save(accessHistory);

	}
}
