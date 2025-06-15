package com.online.balances.service.impl;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.online.balances.controller.member.dto.MemberProfileDetails;
import com.online.balances.model.repo.MemberRepo;
import com.online.balances.service.MemberProfileService;
import com.online.balances.utils.EntityOperations;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberProfileServiceImpl implements MemberProfileService {
	private final MemberRepo memberRepo;
	@Override
	// args username and authentication of name must same
	// insert @EnableMethodSecurity at security.config when use @preAuthorize
	@Transactional(readOnly = true)
	@PreAuthorize("hasAuthority('Admin') or #username eq authentication.name")
	public MemberProfileDetails loadProfile(String username) {

		return EntityOperations.safeCalls(memberRepo.findOneByAccountUsername(username).map(MemberProfileDetails::from),
				"Member", "login Id",
				username);
	}

}
