package com.pms.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pms.pojo.Country;
import com.pms.pojo.State;
import com.pms.pojo.User;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	protected SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
       sessionFactory.getCurrentSession().save(user);
	}
	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().merge(user);

	}

	@Override
	public List<User> listUsers(int startIndex, int pageSize) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from User")
				.setFirstResult(startIndex)
		        .setMaxResults(pageSize)
				.list();
	}

	@Override
	public int getUserCount() {
		int count = 0;
        try {
            count = ((Long)sessionFactory.getCurrentSession().createQuery("select count(*) from User").uniqueResult()).intValue();
        } catch (Exception e) {
            System.out.println("Exception "+e.getMessage());
        }      
       return count;
	}

	@Override
	public void removeUser(Integer id) {
		// TODO Auto-generated method stub
		 User user = (User) sessionFactory.getCurrentSession().load(User.class, id);
	        if (null != user) {
	            sessionFactory.getCurrentSession().delete(user);
	        }
	}


	@Override
	public List<Country> listCountries() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Country").list();
	}

	@Override
	public Country getCountry(Integer country) {
		Country country1 = (Country)sessionFactory.getCurrentSession().load(
                Country.class, country);
        return country1;
   }

	@Override
	public User getUser(Integer id) {
		 User user = (User) sessionFactory.getCurrentSession().load(User.class, id);
	        if (user != null) {
	            return user;
	        } else {
	            return null;
	        }
	}

	@Override
	public State getState(Integer state) {
		State state1 = (State)sessionFactory.getCurrentSession().load(
                State.class, state);
        return state1;	}

	@Override
	public List<State> listStates() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from State").list();
	}

	@Override
	public List<State> getStateForCountry(String countryId) {
		 return sessionFactory.getCurrentSession().createQuery("from State s where s.country.countryId=:countryId")
	               .setParameter("countryId", new Integer(countryId))
	               .list();
	    	}

}
