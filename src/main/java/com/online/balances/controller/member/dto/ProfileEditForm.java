package com.online.balances.controller.member.dto;

import java.time.LocalDate;
import java.util.Optional;

import com.online.balances.model.entity.Member;
import com.online.balances.model.entity.Township;
import com.online.balances.model.entity.consts.Gender;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfileEditForm {

	@NotBlank(message = "Please enter name.")
	private String name;

	@NotNull(message = "Please select gender.")
	private Gender gender;

	@NotNull(message = "Please enter date of birth.")
	private LocalDate dob;

	@NotBlank(message = "Please enter phone number.")
	private String phone;

	@NotBlank(message = "Please enter email. ")
	private String email;

	@NotNull(message = "Please select township.")
	private Integer township;

	@NotBlank(message = "Please enter address. ")
	private String address;

	private String profileImage;

	public static ProfileEditForm from(Member entity) {
		return new Builder().name(entity.getName()).gender(entity.getGender()).dob(entity.getDob())
				.phone(entity.getPhone()).email(entity.getEmail())
				.township(Optional.ofNullable(entity.getTownship()).map(Township::getId).orElse(null))
				.address(entity.getAddress())
				.profileImage(Optional.ofNullable(entity.getProfileImage()).orElse("default-profile.png")).build();
	}

	// Classic-style Builder pattern
	public static class Builder {
		private String name;
		private Gender gender;
		private LocalDate dob;
		private String phone;
		private String email;
		private Integer township;
		private String address;
		private String profileImage;

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder gender(Gender gender) {
			this.gender = gender;
			return this;
		}

		public Builder dob(LocalDate dob) {
			this.dob = dob;
			return this;
		}

		public Builder phone(String phone) {
			this.phone = phone;
			return this;
		}

		public Builder email(String email) {
			this.email = email;
			return this;
		}

		public Builder township(Integer township) {
			this.township = township;
			return this;
		}

		public Builder address(String address) {
			this.address = address;
			return this;
		}

		public Builder profileImage(String profileImage) {
			this.profileImage = profileImage;
			return this;
		}

		public ProfileEditForm build() {
			return new ProfileEditForm(name, gender, dob, phone, email, township, address, profileImage);
		}
		}
	}
