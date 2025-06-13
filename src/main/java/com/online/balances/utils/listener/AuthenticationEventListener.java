package com.online.balances.utils.listener;

import java.time.LocalDateTime;

import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.authentication.event.AuthenticationFailureDisabledEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.authentication.event.LogoutSuccessEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.online.balances.model.entity.consts.Role;
import com.online.balances.model.repo.MemberActivityRepo;
import com.online.balances.service.AccessHistoryService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AuthenticationEventListener {

	private final AccessHistoryService accessHistoryService;

	private final MemberActivityRepo memberActivityRepo;

	@EventListener
	@Transactional
	public void handler(AuthenticationSuccessEvent event) {
		accessHistoryService.loginSuccess(event.getAuthentication().getName());

		var authentication = event.getAuthentication();
		if (authentication.getAuthorities().stream().map(a -> a.getAuthority())
				.filter(a -> Role.Member.name().equals(a)).count() > 0) {

			var username = authentication.getName();
			memberActivityRepo.updateLastAccess(LocalDateTime.now(), username);
		}

	}

	@EventListener
	public void handler(AbstractAuthenticationFailureEvent event) {
		var message = switch (event) {
		case AuthenticationFailureBadCredentialsEvent e -> "Missing Login ID or Password!";
		case AuthenticationFailureDisabledEvent e -> "Account is disabled!";
		default -> "Other Authentication Failures";
		};

		accessHistoryService.loginFails(event.getAuthentication().getName(), message);

	}

	@EventListener
	public void handler(LogoutSuccessEvent event) {
		accessHistoryService.logoutSuccess(event.getAuthentication().getName());
	}

}
