package com.online.balances.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

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

	@Override
	@Transactional
	@PreAuthorize("#username eq authentication.name")
	public void saveImage(String username, String imageFolder, MultipartFile file) {

		try {
			var profileImageName = getProfileImageName(username, file);

			var member = EntityOperations.safeCalls(memberRepo.findOneByAccountUsername(username), "Member", "Login Id",
					username);

			var profileImagePath = Path.of(imageFolder, profileImageName);

			Files.copy(file.getInputStream(), profileImagePath, StandardCopyOption.REPLACE_EXISTING);

			member.setProfileImage(profileImageName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String getProfileImageName(String username, MultipartFile file) {

		var fileName = file.getOriginalFilename();

		var array = fileName.split("\\.");

		var extension = array[array.length - 1];

		return "%s.%s".formatted(fileName, extension);
	}

}
