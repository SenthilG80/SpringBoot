package com.nt.service;

import java.util.List;

import com.nt.document.StockInfo;

public interface IStockInfoMgmt {
	public String registerStock(StockInfo info);
	public String registerStockDetailsBatch(List<StockInfo> list);
	public List<StockInfo> fetchStockDetailsByExchange(String Exchange);
	public List<StockInfo> fetchStockDetailsByPriceRange(double start, double end);
	public String updateStockDetailsById(int stockid, double newPrize, String newExchange);
	public String updateStockExchangeNameByPriceRange(double start,double end,String newExchange);
	public String saveOrUpdateStock(String stockName,double newPrize, String newExchange);
	public String removeStocksByPriceRange	(double start, double end);
	
	
	
	
	
	

}
