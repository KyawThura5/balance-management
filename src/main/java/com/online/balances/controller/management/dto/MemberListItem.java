package com.online.balances.controller.management.dto;

import java.time.LocalDateTime;

public record MemberListItem(long id, String name, LocalDateTime registerAt, LocalDateTime lastLogin,
		boolean status, LocalDateTime changeAt, String remark

) {

}
