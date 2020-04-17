package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.converter.CustomerConverter;
import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.entity.CustomerEntity;
import com.laptrinhjavaweb.repository.CustomerRepository;
import com.laptrinhjavaweb.service.ICustomerService;

@Service
public class CustomerService implements ICustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerConverter customerConverter;

	
	@Override
	public List<CustomerDTO> findAll() {
		List<Object[]> list = customerRepository.findAllCustomerWithStaff();	
		List<CustomerDTO> listDTO=  new ArrayList<>();	
		for(Object[] item : list) {
			CustomerDTO customerDto = new CustomerDTO();
			customerDto.setId(Long.parseLong(item[0].toString()));
			customerDto.setName(item[1].toString());
			customerDto.setSodt(item[2].toString());
			customerDto.setStaffName(item[3].toString());
			listDTO.add(customerDto);
		}
		return listDTO;
	}

}
