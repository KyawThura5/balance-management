package com.online.balances.service;

import com.online.balances.controller.member.dto.ProfileEditForm;

public interface MemberProfileService {

	Object loadProfile(String username);

	ProfileEditForm getEditForm(String username);

	void save(String username, ProfileEditForm editForm);

}
