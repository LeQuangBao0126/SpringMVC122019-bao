package com.laptrinhjavaweb.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.service.IBuildingService;
import com.laptrinhjavaweb.service.impl.BuildingService;

@Controller(value = "buildingControllerOfAdmin")
public class BuildingController {
	
	@Autowired
	private IBuildingService buildingService;
	 
	
	@RequestMapping(value = "/admin/building/list",method =RequestMethod.GET)
	public ModelAndView showlist() {
		ModelAndView mav = new ModelAndView("/admin/building/list");
		List<BuildingDTO> list = buildingService.findAll();
		Map<String,String> mapdistrict = buildingService.mapdistrict();
		Map<String,String> mapbuildingtype = buildingService.mapbuildingtype();
		List<UserEntity> listStaff = buildingService.findByRoles_code();
		mav.addObject("mapbuildingtype", mapbuildingtype);
		mav.addObject("mapdistrict", mapdistrict);
		mav.addObject("list", list);
		mav.addObject("listStaff",listStaff );
		return mav;
	}
	
	@RequestMapping(value = "/admin/building/seach",method =RequestMethod.GET)
	public ModelAndView searchBuilding(@RequestParam Map<String,String> model,
									   @RequestParam("buildingTypes") String[] types ) {
		ModelAndView mav = new ModelAndView("/admin/building/list");
		BuildingSearchBuilder builder = new BuildingSearchBuilder.Builder()
				.setName(model.get("name"))
				.setDistrict(model.get("district"))
				.setFloorArea(model.get("floorArea"))
				.setNumberOfBasement(model.get("numberOfBasement"))
				.setRentAreaFrom(model.get("rentAreaFrom"))
				.setRentAreaTo(model.get("rentAreaTo"))
				.setRentCostFrom(model.get("rentCostFrom"))
				.setRentCostTo(model.get("rentCostTo"))
				.setStaffId(Long.parseLong(model.get("staffId")))
				.setTypes(types)
				.build();
		 List<BuildingDTO> list = buildingService.findAll(builder);
		mav.addObject("list",list);
		return mav;
	}
	@RequestMapping(value="/admin/building/insert",method = RequestMethod.GET)
	public ModelAndView insertPage() {
		ModelAndView mav = new ModelAndView("/admin/building/insert");
		
		return mav;
	}
	@RequestMapping(value="/admin/building/insert",method = RequestMethod.POST)
	public ModelAndView insertBuilding(@ModelAttribute BuildingDTO buildingDto) {
		ModelAndView mav = new ModelAndView("/admin/building/list");
		buildingService.insertBuilding(buildingDto);
		List<BuildingDTO> list = buildingService.findAll();
		mav.addObject("list",list);
		return mav;
	}
	
	@RequestMapping(value="/admin/building/edit",method = RequestMethod.GET)
	public ModelAndView editPage( @RequestParam("id") String id ) {
		ModelAndView mav = new ModelAndView("/admin/building/edit");
		Long buildingId = Long.parseLong(id);
		 BuildingDTO buildingDto = buildingService.findById(buildingId);
		 mav.addObject("buildingDto", buildingDto);
		return mav;
	}
	
}
