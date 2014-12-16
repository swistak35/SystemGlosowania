package com.elwin013.arweb.dao.impl;

import org.springframework.stereotype.Repository;

import com.elwin013.arweb.dao.SpotTypeDao;
import com.elwin013.arweb.dao.model.SpotType;

@Repository("spotTypeDao")
public class SpotTypeDaoImpl extends GenericDaoImpl<SpotType> implements
		SpotTypeDao {

	public SpotTypeDaoImpl() {
		setClazz(SpotType.class);
	}
	

}
