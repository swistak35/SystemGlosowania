package com.mkyong.common;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "stock", uniqueConstraints = {
		@UniqueConstraint(columnNames = "STOCK_CODE") })
public class Stock implements java.io.Serializable {

	private Integer stockId;
	private String stockCode;
	private String stockName;
	private StockDetail stockDetail;
	private Set<StockDailyRecord> stockDailyRecords = new HashSet<StockDailyRecord>(0);
	private Set<Category> categories = new HashSet<Category>(0);
	
	public Stock() {
	}

	public Stock(String stockCode, String stockName) {
		this.stockCode = stockCode;
		this.stockName = stockName;
	}

	public Stock(String stockCode, String stockName,StockDetail stockDetail,
			Set<StockDailyRecord> stockDailyRecords, Set<Category> categories) {
		this.stockCode = stockCode;
		this.stockName = stockName;
		this.setStockDetail(stockDetail);
		this.stockDailyRecords = stockDailyRecords;
		this.setCategories(categories);
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "STOCK_ID", unique = true, nullable = false)
	public Integer getStockId() {
		return this.stockId;
	}

	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}

	@Column(name = "STOCK_CODE", unique = true, nullable = false, length = 10)
	public String getStockCode() {
		return this.stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	@Column(name = "STOCK_NAME", nullable = false, length = 20)
	public String getStockName() {
		return this.stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "stock", cascade = CascadeType.ALL)
	public StockDetail getStockDetail() {
		return stockDetail;
	}

	public void setStockDetail(StockDetail stockDetail) {
		this.stockDetail = stockDetail;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "stock")
	public Set<StockDailyRecord> getStockDailyRecords() {
		return stockDailyRecords;
	}

	public void setStockDailyRecords(Set<StockDailyRecord> stockDailyRecords) {
		this.stockDailyRecords = stockDailyRecords;
	}

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "stock_category", joinColumns = { @JoinColumn(name = "STOCK_ID", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "CATEGORY_ID", nullable = false, updatable = false) })
	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

}
