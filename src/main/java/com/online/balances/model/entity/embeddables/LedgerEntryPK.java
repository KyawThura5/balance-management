package com.online.balances.model.entity.embeddables;

import java.time.LocalDate;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class LedgerEntryPK {
	private long memberId;
	private LocalDate issueDate;
	private int seqNumber;
}
