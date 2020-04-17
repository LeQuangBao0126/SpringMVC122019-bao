package com.laptrinhjavaweb.service;

import java.util.List;
import java.util.Map;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.entity.UserEntity;

public interface IBuildingService {
	List<BuildingDTO> findAll();
	Map<String,String> mapdistrict();
	Map<String,String> mapbuildingtype();
	List<UserEntity> findByRoles_code();
	List<BuildingDTO> findAll(BuildingSearchBuilder builder);
	void insertBuilding(BuildingDTO buildingDto);
	void deleteBuilding(Long[] ids);
	void updateBuilding(BuildingDTO buildingUpdate);
	BuildingDTO findById(Long id);
}
