package com.elwin013.arweb.dao.impl;

import org.springframework.stereotype.Repository;

import com.elwin013.arweb.dao.AuthoritiesDao;
import com.elwin013.arweb.dao.model.Authorities;

@Repository("authoritiesDao")
public class AuthoritiesDaoImpl extends GenericDaoImpl<Authorities> implements
		AuthoritiesDao {
	public AuthoritiesDaoImpl() {
		setClazz(Authorities.class);
	}

}
