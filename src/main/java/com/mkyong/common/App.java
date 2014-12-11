package com.mkyong.common;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mkyong.dao.StockDao;

public class App 
{
	public static void main( String[] args )
	{
		System.out.println("Hibernate with spring.");
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring4.xml");
		
		StockDao stockDao = context.getBean(StockDao.class);
		
		Stock stock = new Stock();
		stock.setStockCode("7056");
		stock.setStockName("PADAM");

		StockDailyRecord stockDailyRecords = new StockDailyRecord();
        stockDailyRecords.setPriceOpen(new Float("1.3"));
        stockDailyRecords.setPriceClose(new Float("1.2"));
        stockDailyRecords.setPriceChange(new Float("9.0"));
        stockDailyRecords.setVolume(2000000L);
        stockDailyRecords.setDate(new Date());
 
        stockDailyRecords.setStock(stock);
        stock.getStockDailyRecords().add(stockDailyRecords);
        
        Category category1 = new Category("CONSUMER", "CONSUMER COMPANY");
        Category category2 = new Category("INVESTMENT", "INVESTMENT COMPANY");
        
        Set<Category> categories = new HashSet<Category>();
        categories.add(category1);
        categories.add(category2);
        
        stock.setCategories(categories);
		
        stockDao.save(stock);
        
        System.out.println("Stock::" + stock);
        
        context.close();
		
//		session.beginTransaction();
		
//        session.save(stockDailyRecords);
		
		//session.saveOrUpdate(stockDetail);
		//session.saveOrUpdate(stock);
        
        
		//session.delete(stock);
		
//		session.getTransaction().commit();
		
		System.out.println("Done");
		
	}
}
