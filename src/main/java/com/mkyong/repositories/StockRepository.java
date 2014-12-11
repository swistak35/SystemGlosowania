package com.mkyong.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mkyong.common.Stock;

public interface StockRepository extends CrudRepository<Stock, Long> {
	
	List<Stock> findByStockCode(String stockCode);
	List<Stock> findByStockNameOrderByStockCodeAsc(String stockName);

}
