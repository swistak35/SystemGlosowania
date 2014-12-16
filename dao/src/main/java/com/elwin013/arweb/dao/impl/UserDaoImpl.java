package com.elwin013.arweb.dao.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.elwin013.arweb.dao.UserDao;
import com.elwin013.arweb.dao.model.Authorities;
import com.elwin013.arweb.dao.model.User;

@Repository("userDao")
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {
	UserDaoImpl() {
		setClazz(User.class);
	}

	@Transactional(readOnly = true)
	public User getByName(String username) {
		return (User) getCurrentSession().createQuery("from User where username like :name")
				.setString("name", username)
				.uniqueResult();
	}

	@Transactional(readOnly = true)
	public List<String> getPermissions(User user) {
		@SuppressWarnings("unchecked")
		List<Authorities> authorities = getCurrentSession().createQuery("from Authorities a where a.id = :id")
				.setInteger("id", user.getIdUser()).list();
		
		List<String> permissions = new ArrayList<String>();
		for (Authorities authorities2 : authorities) {
			permissions.add(authorities2.getAuthority());
		}
		return permissions;
		
	}
}
