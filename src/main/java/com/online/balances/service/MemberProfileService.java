package com.online.balances.service;

import org.springframework.web.multipart.MultipartFile;

import com.online.balances.controller.member.dto.ProfileEditForm;

public interface MemberProfileService {

	Object loadProfile(String username);

	ProfileEditForm getEditForm(String username);

	void save(String username, ProfileEditForm editForm);

	void saveImage(String username, String imageFolder, MultipartFile file);

}
