package com.online.balances.service;

import java.util.List;

import com.online.balances.model.entity.District;
import com.online.balances.model.entity.Region;
import com.online.balances.model.entity.Township;

public interface LocationService {

	List<Region> getAllLocations();

	List<District> findDistrictByRegion(int regionId);

	List<Township> findTownshipByDistrict(int districtId);

}
