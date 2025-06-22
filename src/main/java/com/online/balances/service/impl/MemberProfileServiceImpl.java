package com.online.balances.service.impl;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.online.balances.controller.member.dto.MemberProfileDetails;
import com.online.balances.controller.member.dto.ProfileEditForm;
import com.online.balances.model.repo.MemberRepo;
import com.online.balances.model.repo.TownshipRepo;
import com.online.balances.service.MemberProfileService;
import com.online.balances.utils.EntityOperations;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberProfileServiceImpl implements MemberProfileService {

	private final MemberRepo memberRepo;

	private final TownshipRepo townshipRepo;

	// args username and authentication of name must same
	// insert @EnableMethodSecurity at security.config when use @preAuthorize
	@Override
	@PreAuthorize("hasAuthority('Admin') or #username eq authentication.name")
	public MemberProfileDetails loadProfile(String username) {

		return EntityOperations.safeCalls(memberRepo.findOneByAccountUsername(username).map(MemberProfileDetails::from),
				"Member", "login Id",
				username);
	}

	@Override
	@PreAuthorize("hasAuthority('Admin') or #username eq authentication.name")
	public ProfileEditForm getEditForm(String username) {
		return EntityOperations.safeCalls(memberRepo.findOneByAccountUsername(username).map(ProfileEditForm::from),
				"Member", "login Id", username);
	}

	@Override
	@Transactional
	@PreAuthorize("hasAuthority('Admin') or #username eq authentication.name")
	public void save(String username, ProfileEditForm form) {
		var member = EntityOperations.safeCalls(memberRepo.findOneByAccountUsername(username), "Member", "login Id",
				username);

		member.setName(form.getName());
		member.setGender(form.getGender());
		member.setDob(form.getDob());
		member.setPhone(form.getPhone());

		townshipRepo.findById(form.getTownship()).ifPresent(member::setTownship);

		member.setAddress(form.getAddress());
	}

}
