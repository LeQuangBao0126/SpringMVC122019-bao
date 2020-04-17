package com.laptrinhjavaweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.service.ICustomerService;

@Controller()
public class CustomerController {
			
	@Autowired
	private ICustomerService customerService;

	@RequestMapping(value = "/admin/customer/list",method =RequestMethod.GET)
	public ModelAndView showlistCustomer() {
		ModelAndView mav = new ModelAndView("/admin/customer/list");
		List<CustomerDTO> list = customerService.findAll();
		mav.addObject("list", list);
		return mav;
	}
	@RequestMapping(value = "/admin/customer/edit",method =RequestMethod.GET)
	public ModelAndView updateCustomer() {
		ModelAndView mav = new ModelAndView("/admin/customer/edit");
		return mav;
	}
	
}
