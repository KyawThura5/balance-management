package com.online.balances.controller.member.dto;

import java.time.LocalDate;

import com.online.balances.model.entity.consts.Gender;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
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
	@NotNull(message = "Please select region.")
	private int region;
	@NotNull(message = "Please select district.")
	private int district;
	private int township;
	private String address;

	private String profileImage;

}
