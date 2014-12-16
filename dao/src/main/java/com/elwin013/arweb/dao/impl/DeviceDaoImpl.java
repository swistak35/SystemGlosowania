package com.elwin013.arweb.dao.impl;

import org.springframework.stereotype.Repository;

import com.elwin013.arweb.dao.DeviceDao;
import com.elwin013.arweb.dao.model.Device;

@Repository("deviceDao")
public class DeviceDaoImpl extends GenericDaoImpl<Device> implements DeviceDao {
	DeviceDaoImpl() {
		setClazz(Device.class);
	}

}
