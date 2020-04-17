package com.laptrinhjavaweb.service.impl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.converter.BuildingConverter;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.RentAreaEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.enums.BuildingTypeEnum;
import com.laptrinhjavaweb.enums.DistrictEnum;
import com.laptrinhjavaweb.repository.BuildingRepository;
import com.laptrinhjavaweb.repository.UserRepository;
import com.laptrinhjavaweb.service.IBuildingService;


@Service
public class BuildingService implements IBuildingService {

	@Autowired
	private BuildingRepository buildingRepository;
	
	@Autowired
	private BuildingConverter buildingConverter;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<BuildingDTO> findAll() {
		List<BuildingEntity> entities = buildingRepository.findAll();
		List<BuildingDTO> listDto = new ArrayList<>();
		
		for(BuildingEntity entity : entities) {		
			StringBuilder strRentarea = new StringBuilder(""); 
			for(RentAreaEntity rentarea : entity.getRentAreas()) {
					if(strRentarea.length() > 1) {
						strRentarea.append(",");
					}
					strRentarea.append(rentarea.getValue());
			}
			BuildingDTO dto = buildingConverter.convertEntityToDTO(entity);
			dto.setRentAreas(strRentarea.toString());
			listDto.add(dto);
		}
		return listDto;
	}

	@Override
	public Map<String, String> mapdistrict() {
		Map<String, String> mapdistrict = new HashMap<String, String>();
		for(DistrictEnum item : DistrictEnum.values()) {
			mapdistrict.put(item.toString(),item.getEnumValue());
		}
		return mapdistrict;
	}

	@Override
	public Map<String, String> mapbuildingtype() {
		Map<String, String> mapbuildingtype = new HashMap<String, String>();
		for(BuildingTypeEnum item : BuildingTypeEnum.values()) {
			mapbuildingtype.put(item.toString(),item.getEnumValue());
		}
		return mapbuildingtype;
	}

	@Override
	public List<UserEntity> findByRoles_code() {
		return userRepository.findByRoles_code("STAFF");
	}

	@Override
	public List<BuildingDTO> findAll(BuildingSearchBuilder builder) {
		Map<String, Object> params = convertMaptoProperty(builder);
		List<BuildingEntity> entities = buildingRepository.findAll(params, builder);
		return entities.stream()
						.map(item-> buildingConverter.convertEntityToDTO(item))
						.collect(Collectors.toList());
	}
	private Map<String, Object> convertMaptoProperty(BuildingSearchBuilder builder) {
		Map<String,Object> properties = new HashMap<>();
		try {
			Field[] fields = BuildingSearchBuilder.class.getDeclaredFields();
			for(Field field : fields) {
				if(!field.getName().startsWith("rentArea") && !field.getName().equals("types") 
						&& !field.getName().equals("staffId") && !field.getName().startsWith("rentCost"))
				{					
					field.setAccessible(true);
					if(field.get(builder) instanceof String) {
						properties.put(field.getName().toLowerCase(), field.get(builder));
					}else {
						if(field.get(builder) != null && StringUtils.isNotEmpty((String)field.get(builder))) {
							properties.put(field.getName().toLowerCase(), Integer.parseInt((String)field.get(builder)));	
						}
					}
				}
			}
		}catch(IllegalAccessException e) {
			System.out.println(e.getMessage());
		}
		return properties;
	}

	@Override
	@Transactional
	public void insertBuilding(BuildingDTO buildingDto) {
		String[] rentarea = buildingDto.getRentAreas().split(",");
		StringBuilder sbtype = new StringBuilder("");
		for(String types : buildingDto.getBuildingTypes()) {
			if(sbtype.length() > 1) {
				sbtype.append(",");
			}
				sbtype.append(types);			
		}
		buildingDto.setType(sbtype.toString());
		BuildingEntity buildingentity = buildingConverter.convertDTOToEntity(buildingDto);
		BuildingEntity newBuildingEntity = buildingRepository.save(buildingentity);
		List<RentAreaEntity> listrenareas = new ArrayList<>();
		
		for(String item : rentarea) {
			RentAreaEntity re = new RentAreaEntity();
			re.setValue(Integer.parseInt(item));
			re.setBuilding(newBuildingEntity);
			listrenareas.add(re);
		}
		
		newBuildingEntity.setRentAreas(listrenareas);
		buildingRepository.save(newBuildingEntity);
	//return
	}

	@Override
	@Transactional
	public void deleteBuilding(Long[] ids) {		
		for(Long id : ids) {
			BuildingEntity buildingEntity = buildingRepository.findOne(id);
			
			if(buildingEntity.getRentAreas()!= null && buildingEntity.getRentAreas().size()>0) {
				buildingEntity.getRentAreas().remove(buildingEntity.getRentAreas().iterator().next());
			}
			if(buildingEntity.getStaffs()!= null && buildingEntity.getStaffs().size()>0) {
				buildingEntity.getStaffs().remove(buildingEntity.getStaffs().iterator().next());
			}
			buildingRepository.delete(buildingEntity);
		}
	}

	@Override
	public BuildingDTO findById(Long id) {
		BuildingEntity entity = buildingRepository.findOne(id);
		//phải có dc danh sách loại toà nhà
		String[] buildingTypes = entity.getType().split(",");
		//phải co dc dien tích thuê 
		StringBuilder sbRentAreas = new StringBuilder("");
		    List<RentAreaEntity> listRentAreas = entity.getRentAreas();
		    for(RentAreaEntity rae : listRentAreas) {
		    	 Integer value = rae.getValue();
		    	 if(sbRentAreas.length() > 1) {
		    		 sbRentAreas.append(",");
		    	 }
		    	 sbRentAreas.append(value);
		    }
		BuildingDTO dto =  buildingConverter.convertEntityToDTO(entity);
		dto.setBuildingTypes(buildingTypes);
		dto.setRentAreas(sbRentAreas.toString());
		return dto;
	}

	@Override
	public void updateBuilding(BuildingDTO buildingUpdate) {
		String[] rentarea = buildingUpdate.getRentAreas().split(",");
		BuildingEntity entity = buildingRepository.findOne(buildingUpdate.getId());		
		
		if(entity.getRentAreas()!= null && entity.getRentAreas().size()>0) {
			entity.getRentAreas().remove(entity.getRentAreas().iterator().next());
		}
		if(entity.getStaffs()!= null && entity.getStaffs().size()>0) {
			entity.getStaffs().remove(entity.getStaffs().iterator().next());
		}
		
		StringBuilder sbtype = new StringBuilder("");
		//chỉ để làm ra 1 dòng type 
		for(String types : buildingUpdate.getBuildingTypes()) {
			if(sbtype.length() > 1) {
				sbtype.append(",");
			}
				sbtype.append(types);			
		}
		buildingUpdate.setType(sbtype.toString());
		BuildingEntity buildingUpdateEntity = buildingConverter.convertDTOToEntity(buildingUpdate);
		BuildingEntity newBuildingEntity = buildingRepository.save(buildingUpdateEntity);
		
	    List<RentAreaEntity> listrenareas = new ArrayList<>();
		
		for(String item : rentarea) {
			RentAreaEntity re = new RentAreaEntity();
			re.setValue(Integer.parseInt(item));
			re.setBuilding(newBuildingEntity);
			listrenareas.add(re);
		}
		newBuildingEntity.setRentAreas(listrenareas);
		buildingRepository.save(buildingUpdateEntity);
		
	}

}
