package com.online.balances.model.entity;

import com.online.balances.model.entity.consts.AccessStatus;
import com.online.balances.model.entity.consts.AccessType;
import com.online.balances.model.entity.embeddables.AccessHistoryPK;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class AccessHistory {

	@EmbeddedId
	private AccessHistoryPK id;

	@Column(nullable = false)
	private AccessType type;
	private AccessStatus status;
	private String remark;
}
