package com.online.balances.model.repo;

import java.util.List;

import com.online.balances.model.BaseRepository;
import com.online.balances.model.entity.Township;

public interface TownshipRepo extends BaseRepository<Township, Integer> {

	List<Township> findByDistrictId(int districtId);

}
