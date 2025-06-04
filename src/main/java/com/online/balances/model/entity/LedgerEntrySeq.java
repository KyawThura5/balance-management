package com.online.balances.model.entity;

import com.online.balances.model.entity.embeddables.LedgerEntrySeqPK;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class LedgerEntrySeq {
	@EmbeddedId
	private LedgerEntrySeqPK id;

	@Column(nullable = false)
	private int seqNumber;

}
