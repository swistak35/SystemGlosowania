package com.mkyong.dao;

import java.util.List;

import com.mkyong.common.Stock;

public interface StockDao {
	
	public void save(Stock stock);
	
	public List<Stock> list();
	
}
