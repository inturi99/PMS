package com.pms.service;

import java.util.List;

import com.pms.busines.exception.UserException;
import com.pms.dto.StateDto;
import com.pms.dto.UserDto;
import com.pms.dto.CountryDto;
import com.pms.pojo.User;

public interface UserService {
	 public User getUser(String id)throws UserException;
	    
	    public void addUser(UserDto userDto)throws UserException;
	    
	    public List<UserDto> listUsers(int startIndex,int pageSize)throws UserException;
	    public int getUserCount()throws UserException;
	    public void removeUser(Integer id)throws UserException;
	    
	    public void updateUser(UserDto userDto)throws UserException;
	    
	    public List<CountryDto> listCountries()throws UserException;
	    
	    public List<StateDto> listStates()throws UserException;
	    
	    public List<StateDto> getStateForcountry(String countryId)throws UserException;

}
