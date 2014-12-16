package com.elwin013.arweb.dao.impl;

import org.springframework.stereotype.Repository;

import com.elwin013.arweb.dao.SpotDao;
import com.elwin013.arweb.dao.model.Spot;

@Repository("spotDao")
public class SpotDaoImpl extends GenericDaoImpl<Spot> implements SpotDao {
	public SpotDaoImpl() {
		setClazz(Spot.class);
	}

}
