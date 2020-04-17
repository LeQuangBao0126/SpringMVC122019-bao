package com.laptrinhjavaweb.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.api.input.DeleteBuildings;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.service.IBuildingService;

@RestController
public class BuildingAPI {
			
	@Autowired
	private IBuildingService buildingService;
	
	@DeleteMapping(value = "/admin/building/delete")
	public void deleteBuilding(@RequestBody DeleteBuildings deleteBuilding ) {
		System.out.println("hello");
		buildingService.deleteBuilding(deleteBuilding.getIds());
	}
	
	@PutMapping(value="/admin/building/edit")
	public ModelAndView editBuilding(@RequestBody BuildingDTO buildingDtoUpdate) {
		ModelAndView mav = new ModelAndView("/admin/building/list");
		buildingService.updateBuilding(buildingDtoUpdate);	 
		return mav;
	}
}
