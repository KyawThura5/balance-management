package com.online.balances.controller.member;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.online.balances.model.entity.District;
import com.online.balances.model.entity.Township;
import com.online.balances.service.LocationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("member/location")
public class MemberLocationApi {

	private final LocationService locationService;

	@GetMapping("district")
	List<District> findDistricts(@RequestParam("regionId") int regionId) {
		return locationService.findDistrictByRegion(regionId);

	}

	@GetMapping("township")
	List<Township> findTownships(@RequestParam("districtId") int districtId) {
		return locationService.findTownshipByDistrict(districtId);

	}

}
