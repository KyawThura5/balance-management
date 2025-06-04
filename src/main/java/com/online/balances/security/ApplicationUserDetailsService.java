package com.online.balances.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.online.balances.model.repo.AccountRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ApplicationUserDetailsService implements UserDetailsService {

	private final AccountRepo accontRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		return accontRepo.findById(username)
				.map(account -> User.withUsername(username).password(account.getPassword())
						.authorities(account.getRole().name()).disabled(!account.isActive()).build())
				.orElseThrow(() -> new UsernameNotFoundException("Invalid Login ID"));
	}

}
