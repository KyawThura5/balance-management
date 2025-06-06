package com.online.balances.service;

import com.online.balances.controller.member.dto.AccessHistorySearch;

public interface AccessHistoryService {

	void signUp(String username);

	void loginSuccess(String name);

	void logoutSuccess(String name);

	void loginFails(String name, String message);

	Object search(AccessHistorySearch form, int page, int size);

}
