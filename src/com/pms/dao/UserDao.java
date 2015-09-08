package com.pms.dao;

import java.util.List;

import com.pms.pojo.Country;
import com.pms.pojo.State;
import com.pms.pojo.User;

public interface UserDao {
public void addUser(User user);
public List<User> listUsers(int startIndex, int pageSize);
public int getUserCount();
public void removeUser(Integer id);

public void updateUser(User user);

public List<Country> listCountries();

public Country getCountry(Integer country);

public User getUser(Integer id);

public State getState(Integer state);

public List<State> listStates();

public List<State> getStateForCountry(String countryId);

}
