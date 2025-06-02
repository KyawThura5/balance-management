package com.online.balances.controller.member.dto;

import java.time.LocalDateTime;

public record MemberProfileDetails(Long id, String name, String phone,
String email, String address,
LocalDateTime registerAt,
		LocalDateTime LastAccessAt) {

}
