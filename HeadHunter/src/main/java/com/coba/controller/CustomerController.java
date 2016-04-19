package com.coba.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.coba.mapper.CustomerMapper;
import com.coba.model.Customer;

@RestController
@ComponentScan
@EnableAutoConfiguration
public class CustomerController {

	@Autowired
	private CustomerMapper customerMapper;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView login(ModelAndView mv) {
		
		mv.setViewName("home");
		return mv;
	}

	@RequestMapping(value = "/HeadHunter/insert", method = RequestMethod.POST)
	public ModelAndView insert(ModelAndView mv, String nik, String firstname, String lastname, String username,
			String password, String address, String noTelp, String email, Date dob) {

		mv.addObject("nik", nik);
		mv.addObject("firstname", firstname);
		mv.addObject("lastname", lastname);
		mv.addObject("username", username);
		mv.addObject("password", password);
		mv.addObject("address", address);
		mv.addObject("noTelp", noTelp);
		mv.addObject("email", email);
		mv.addObject("dob", dob);

		Customer c = new Customer(nik, firstname, lastname, username, password, address, noTelp, email, dob, 2);
		customerMapper.insert(c);

		mv.setViewName("insert");
		return mv;
	}

}