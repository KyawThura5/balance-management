package com.online.balances.service;

import com.online.balances.controller.management.dto.MemberSearch;
import com.online.balances.controller.management.dto.MemberStatusForm;

public interface MemberManagementService {

	Object search(MemberSearch form, int page, int size);

	Object findById(long id);

	void updateStatus(long id, MemberStatusForm form);

}
