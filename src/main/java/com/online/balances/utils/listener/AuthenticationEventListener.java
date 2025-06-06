package com.online.balances.utils.listener;

import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.authentication.event.AuthenticationFailureDisabledEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.authentication.event.LogoutSuccessEvent;
import org.springframework.stereotype.Component;

import com.online.balances.service.AccessHistoryService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AuthenticationEventListener {

	private final AccessHistoryService accessHistoryService;

	@EventListener
	public void handler(AuthenticationSuccessEvent event) {
		accessHistoryService.loginSuccess(event.getAuthentication().getName());
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
