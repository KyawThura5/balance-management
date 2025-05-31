package com.online.balances.controller.management.dto;

import java.time.LocalDateTime;

import com.online.balances.model.entity.consts.Gender;

public record MemberDetails(long id, String name, LocalDateTime dateOfBirth, Gender gender, String phone, String email,
		String address, String township, String region, boolean status, LocalDateTime registerAt,
		LocalDateTime LastAccessAt) {

}
