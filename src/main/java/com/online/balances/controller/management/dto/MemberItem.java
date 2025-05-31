package com.online.balances.controller.management.dto;

import java.time.LocalDateTime;

public record MemberItem(long id, String name, LocalDateTime registerAt, LocalDateTime lastLogin,
		boolean status, LocalDateTime changeAt, String remark

) {

}
