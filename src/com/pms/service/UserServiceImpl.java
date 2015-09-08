package com.pms.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pms.busines.exception.UserException;
import com.pms.dao.UserDao;
import com.pms.dto.StateDto;
import com.pms.dto.UserDto;
import com.pms.dto.CountryDto;
import com.pms.pojo.Country;
import com.pms.pojo.State;
import com.pms.pojo.User;

@Service
public class UserServiceImpl implements UserService {
	private static final org.slf4j.Logger LOG = LoggerFactory
			.getLogger(UserServiceImpl.class);

	@Autowired
	private UserDao userDao;

	public UserServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}

	@Transactional(readOnly = true)
	public User getUser(String id) throws UserException {
		try {
			return userDao.getUser(new Integer(id));
		} catch (Exception e) {
			LOG.error("Exception thrown while while getting expense with id - "
					+ id + " - " + e.getMessage());
			throw new UserException(
					"Exception while getting expense with id - " + id + " - "
							+ e.getMessage());
		}
	}

	@Transactional
	public void addUser(UserDto userDto) throws UserException {
		try {
			LOG.info("adding User ...........");
			User user = new User();
			Country country = userDao.getCountry(new Integer(userDto
					.getCountryId()));
			State state = userDao.getState(new Integer(userDto.getStateId()));
			user.setCountry(country);
			user.setState(state);
			user.setUserName(userDto.getUserName());
			user.setDob(userDto.getDob());
			userDao.addUser(user);
		} catch (Exception e) {
			LOG.error("Exception thrown while adding " + e.getMessage());
			throw new UserException("Exception while adding record - "
					+ e.getMessage());
		}
	}

	@Transactional(readOnly = true)
	public List<UserDto> listUsers(int startIndex, int pageSize)
			throws UserException {
		List<UserDto> formatedUserList = new ArrayList<UserDto>();
		// TODO Auto-generated method stub
		try {
			List<User> userList = userDao.listUsers(startIndex, pageSize);
			for (User user : userList) {
				UserDto userDto = new UserDto();
				userDto.setUserId(user.getUserId().toString());
				userDto.setCountryId(user.getCountry().getCountryId()
						.toString());
				if (user.getState() != null) {
					userDto.setStateId(user.getState().getStateId().toString());
				} else {
					userDto.setStateId(userDao.getState(1).getStateId()
							.toString());
				}
				userDto.setUserName(user.getUserName());
				userDto.setDob(user.getDob());
				formatedUserList.add(userDto);
			}

		} catch (Exception e) {
			LOG.error("Exception thrown while listing users from - "
					+ startIndex + " to " + pageSize + " - " + e.getMessage());
			throw new UserException("Exception while listing users from - "
					+ startIndex + " to " + pageSize + " - " + e.getMessage());

		}
		return formatedUserList;
	}

	@Transactional(readOnly = true)
	public int getUserCount() throws UserException {
		try {
			return userDao.getUserCount();
		} catch (Exception e) {
			LOG.error("Exception thrown while getting user count "
					+ e.getMessage());
			throw new UserException(
					"Exception thrown while getting use count - "
							+ e.getMessage());
		}
	}

	@Transactional(readOnly=true)
	public void removeUser(Integer id) throws UserException {
		try {
            userDao.removeUser(id);
        } catch (Exception e) {
            LOG.error("Exception thrown while removing user" + e.getMessage());
            throw new UserException("Exception while removing user "+e.getMessage());
        } 
	}

	@Transactional(readOnly=true)
	public void updateUser(UserDto userDto) throws UserException {
		try {
			LOG.info("adding User ...........");
			User user = userDao.getUser(new Integer(userDto.getUserId()));
			Country country = userDao.getCountry(new Integer(userDto
					.getCountryId()));
			State state = userDao.getState(new Integer(userDto.getStateId()));
			LOG.info("user country is - " + userDto.getCountryId());
			LOG.info("user state is - " + userDto.getStateId());
			user.setCountry(country);
			user.setState(state);
			user.setUserName(userDto.getUserName());
			user.setDob(userDto.getDob());
			userDao.updateUser(user);
		} catch (Exception e) {
			LOG.error("Exception thrown while adding " + e.getMessage());
			throw new UserException("Exception while adding record - "
					+ e.getMessage());
		}
	}

	@Transactional(readOnly=true)
	public List<CountryDto> listCountries() throws UserException {
		List<CountryDto> lcList = new ArrayList<CountryDto>();
        try {
            List<Country> countries = userDao.listCountries();
            for (Country country : countries) {
            	CountryDto countryOptionsBean = new CountryDto(country.getCountryId().toString(),country.getCountryName());
                lcList.add(countryOptionsBean);
            }
        } catch (Exception e) {
            LOG.error("Exception thrown while listing user countries" + e.getMessage());
            throw new UserException("Exception while listing user countries "+e.getMessage());
        }      
        return lcList;
        }

	@Transactional(readOnly=true)
	public List<StateDto> listStates() throws UserException {
		 List<StateDto> lsList = new ArrayList<StateDto>();
	        try {
	            List<State> states = userDao.listStates();
	            for (State state : states) {
	            	StateDto stateOptionsBean = new StateDto(state.getStateId().toString(),state.getStateName());
	                lsList.add(stateOptionsBean);
	            }
	        } catch (Exception e) {
	            LOG.error("Exception thrown while listing all expense sub categories" + e.getMessage());
	            throw new UserException("Exception while listing all expense sub categories "+e.getMessage());
	        }      
	        return lsList;
	    	}

	@Transactional(readOnly=true)
	public List<StateDto> getStateForcountry(String countryId)
			throws UserException {
		List<StateDto> lblList = new ArrayList<StateDto>();
        try {
            List<State> states = userDao.getStateForCountry(countryId);
            for (State state : states) {
            	StateDto userOptionsBean = new StateDto(state.getStateId().toString(),state.getStateName());
                lblList.add(userOptionsBean);
            }
        } catch (Exception e) {
            LOG.error("Exception thrown while listing sub categories for category" + e.getMessage());
            throw new UserException("Exception while listing sub categories for category "+e.getMessage());
        }	
    	return lblList;
    
	}

}
