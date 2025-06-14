package com.online.balances.security;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;


@Component
public class AuditorAwareBean implements AuditorAware<String> {

	// AuditorAware to get user who created and updatedby currently.
	// Declare EntityListeners at AbstractEntity.class
	// Declare EnableJpaAuditing at JpaApplicationConfig.java
	@Override
	public Optional<String> getCurrentAuditor() {
		return Optional.ofNullable(SecurityContextHolder.getContext()).map(a -> a.getAuthentication())
				.map(a -> a.getName());
	}

}
