package com.mkyong.common;

import java.util.List;

import org.hamcrest.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mkyong.config.AppConfig;
import com.mkyong.repositories.StockRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class StockRepositoryIntegrationTest {
	
	@Autowired
	StockRepository repository;
	
	@Test
	public void sampleTestCase() {
		Stock padem = new Stock("7057", "PADEM");
		padem = repository.save(padem);
		
		Stock padum1 = new Stock("7059", "PADUM");
		padum1 = repository.save(padum1);

		Stock padum2 = new Stock("7058", "PADUM");
		padum2 = repository.save(padum2);

		List<Stock> result = repository.findByStockNameOrderByStockCodeAsc("PADUM");
		MatcherAssert.assertThat(result.size(), Matchers.is(2));
		MatcherAssert.assertThat(result.get(0).getStockCode(), Matchers.is(padum2.getStockCode()));
		MatcherAssert.assertThat(result.get(1).getStockCode(), Matchers.is(padum1.getStockCode()));
	}
	
}
