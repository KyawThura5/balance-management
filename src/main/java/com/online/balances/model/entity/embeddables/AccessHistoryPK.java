package com.online.balances.model.entity.embeddables;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class AccessHistoryPK {

	private String username;
	private String accessAt;

}
