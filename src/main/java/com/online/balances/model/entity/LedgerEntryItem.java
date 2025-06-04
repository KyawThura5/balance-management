package com.online.balances.model.entity;

import java.math.BigDecimal;

import com.online.balances.model.entity.embeddables.LedgerEntryPK;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class LedgerEntryItem {

	@EmbeddedId
	private LedgerEntryPK id;

	@ManyToOne(optional = false)
	private LedgerEntry entry;

	@Column(nullable = false)
	private String item;

	@Column(nullable = false)
	private BigDecimal unitPrice;

	@Column(nullable = false)
	private int quantity;
}

