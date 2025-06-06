package com.online.balances.service.impl;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.online.balances.controller.anonymous.dto.SignUpForm;
import com.online.balances.model.entity.Account;
import com.online.balances.model.entity.Member;
import com.online.balances.model.entity.MemberActivity;
import com.online.balances.model.entity.consts.MemberStatus;
import com.online.balances.model.entity.consts.Role;
import com.online.balances.model.repo.AccountRepo;
import com.online.balances.model.repo.MemberActivityRepo;
import com.online.balances.model.repo.MemberRepo;
import com.online.balances.service.AccessHistoryService;
import com.online.balances.service.SignUpService;
import com.online.balances.utils.exception.AppBussinessException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SignUpServiceImpl implements SignUpService {

	private final AccountRepo accountRepo;
	private final MemberRepo memberRepo;
	private final MemberActivityRepo memberActivityRepo;
	private final AccessHistoryService accessHistoryService;
	private final PasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public Object signUp(SignUpForm signUpForm) {
		if (accountRepo.existsById(signUpForm.getUsername())) {
			throw new AppBussinessException("Your email is already registered. Please try another email!");
		}

		var account = new Account();
		account.setUsername(signUpForm.getUsername());
		account.setPassword(passwordEncoder.encode(signUpForm.getPassword()));
		account.setActive(true);
		account.setRole(Role.Member);
		accountRepo.save(account);

		var member = new Member();
		member.setAccount(account);
		member.setName(signUpForm.getName());
		member.setEmail(signUpForm.getUsername());
		memberRepo.save(member);

		var activity = new MemberActivity();
		activity.setMember(member);
		activity.setBalance(BigDecimal.ZERO);
		activity.setRegisterAt(LocalDateTime.now());
		activity.setStatus(MemberStatus.Active);

		memberActivityRepo.save(activity);

		accessHistoryService.signUp(signUpForm.getUsername());

		return "Your account has been created successfully! Please sign in again.";
	}

}
