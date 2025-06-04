package com.online.balances.model.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.online.balances.model.entity.embeddables.LedgerEntryPK;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class LedgerEntry extends AbstractEntity {

	@EmbeddedId
	private LedgerEntryPK id;

	@ManyToOne(optional = false)
	private Ledger ledger;

	@Column(nullable = false)
	private BigDecimal lastAmount;

	@Column(nullable = false)
	private BigDecimal amount;

	@Column(nullable = false)
	private String particular;

	@Column(nullable = false)
	private LocalDateTime issueAt;
}
