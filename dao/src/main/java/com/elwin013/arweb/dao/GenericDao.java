package com.elwin013.arweb.dao;

import java.util.ArrayList;
import java.util.Set;

public interface GenericDao<T> {
	void save(T obj);
	void saveAll(Set<T> objects);
	void update(T obj);
	void delete(T obj);
	public T get(Integer id);
	public ArrayList<T> getAll();
	public int count();
}
