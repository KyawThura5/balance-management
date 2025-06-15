package com.online.balances.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.online.balances.model.entity.District;
import com.online.balances.model.entity.Region;
import com.online.balances.model.entity.Township;
import com.online.balances.model.repo.DistrictRepo;
import com.online.balances.model.repo.RegionRepo;
import com.online.balances.model.repo.TownshipRepo;
import com.online.balances.service.LocationService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LocationServiceImpl implements LocationService {

	private final RegionRepo regionRepo;

	private final DistrictRepo districtRepo;

	private final TownshipRepo townshipRepo;

	@Override
	public List<Region> getAllLocations() {
		return regionRepo.findAll();
	}

	@Override
	public List<District> findDistrictByRegion(int regionId) {
		return districtRepo.findByRegionId(regionId);
	}

	@Override
	public List<Township> findTownshipByDistrict(int districtId) {
		return townshipRepo.findByDistrictId(districtId);
	}

}
