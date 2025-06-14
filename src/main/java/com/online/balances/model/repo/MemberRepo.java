package com.online.balances.model.repo;

import java.util.Optional;

import com.online.balances.model.BaseRepository;
import com.online.balances.model.entity.Member;

public interface MemberRepo extends BaseRepository<Member, Long> {

	Optional<Member> findOneByAccountUsername(String username);

}
