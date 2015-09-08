package com.pms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pms.dto.StateDto;
import com.pms.dto.StateDtoResponse;
import com.pms.dto.UserDto;
import com.pms.dto.UserDtoListResponse;
import com.pms.dto.CountryDto;
import com.pms.dto.CountryDtoResponse;
import com.pms.dto.UserDtoResponse;
import com.pms.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/usertable", method = RequestMethod.GET)
	public String show(ModelMap model) {
		return "usertable";
	}

	/* Table data load - This loads the data for the table */
	@RequestMapping(value = "/usertable/getAllUsers", method = RequestMethod.POST)
	@ResponseBody
	public UserDtoListResponse getAllUsers(@RequestParam int jtStartIndex,
			@RequestParam int jtPageSize) {
		UserDtoListResponse jstr = null;
		List<UserDto> userDtoList;
		try {
			int userCount = userService.getUserCount();
			userDtoList = userService.listUsers(jtStartIndex, jtPageSize);
			jstr = new UserDtoListResponse( userDtoList, userCount);
		} catch (Exception e) {
		e.printStackTrace();
		}

		return jstr;
	}

	/* Cascaded drop down part one - loads the countries */
	@RequestMapping(value = "/usertable/countries", method = RequestMethod.POST)
	public @ResponseBody
	CountryDtoResponse getCountries() {
		CountryDtoResponse jstr = null;
		List<CountryDto> countries;
		try {
			countries = userService.listCountries();
			jstr = new CountryDtoResponse(countries);
		} catch (Exception e) {
			e.printStackTrace() ;
		}
		return jstr;
	}

	/* Cascaded drop down part two - loads the states */
	@RequestMapping(value = "/usertable/states", method = RequestMethod.POST)
	public @ResponseBody
	StateDtoResponse getStateByCountry(
			@RequestParam(value = "countryId", required = true) String countryId) {
		StateDtoResponse jstr = null;
		List<StateDto> states;
		try {
			if (countryId.equals("0")) {
				states = userService.listStates();
			} else {
				states = userService.getStateForcountry(countryId);
			}
			jstr = new StateDtoResponse(states);
		} catch (Exception e) {
		 e.printStackTrace();	
		}
		return jstr;
	}

	/* CRUD operation - Add the user */
	@RequestMapping(value = "/usertable/addUser", method = RequestMethod.POST)
	@ResponseBody
	public UserDtoResponse insertGroup(@ModelAttribute UserDto userDto,
			BindingResult result) {
		UserDtoResponse userDtoResponse = null;
		
		try {
			userService.addUser(userDto);
			userDtoResponse = new UserDtoResponse(userDto);
		} catch (Exception e) {
		e.printStackTrace();	
		}
		return userDtoResponse;
	}

	/* CRUD operation - Update the expense */
	@RequestMapping(value = "/usertable/updateUser", method = RequestMethod.POST)
	@ResponseBody
	public UserDtoResponse updateRole(@ModelAttribute UserDto userDto,
			BindingResult result) {
		UserDtoResponse userDtoResponse = null;
		
		try {
			userService.updateUser(userDto);
			userDtoResponse = new UserDtoResponse(userDto);
		} catch (Exception e) {
		e.printStackTrace();
		}
		return userDtoResponse;
	}

	/* CRUD operation - Delete the user */
	@RequestMapping(value = "/usertable/deleteUser", method = RequestMethod.POST)
	@ResponseBody
	public UserDtoResponse delete(@RequestParam String userId) {
		UserDtoResponse userDtoResponse = null;
		try {
			userService.removeUser(new Integer(userId));
			} catch (Exception e) {
			
			}
		return userDtoResponse;
	}

}
