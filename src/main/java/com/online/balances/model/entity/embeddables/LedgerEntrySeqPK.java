package com.online.balances.model.entity.embeddables;

import java.time.LocalDate;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class LedgerEntrySeqPK {
	private Long memberId;
	private LocalDate issueDate;
}
