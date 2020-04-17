package com.laptrinhjavaweb.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.entity.CustomerEntity;


@Component
public class CustomerConverter {
	@Autowired
	private ModelMapper modelMapper ;

	public CustomerDTO convertEntityToDTO(CustomerEntity entity) {
		CustomerDTO dto = modelMapper.map(entity, CustomerDTO.class);
		return dto;
	}

	public CustomerEntity convertDTOToEntity(CustomerDTO dto) {
		CustomerEntity entity = modelMapper.map(dto, CustomerEntity.class);
		return entity;
	}
}
