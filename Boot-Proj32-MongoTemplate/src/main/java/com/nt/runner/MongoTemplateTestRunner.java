package com.nt.runner;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.document.StockInfo;
import com.nt.service.IStockInfoMgmt;

@Component
public class MongoTemplateTestRunner implements CommandLineRunner {
	@Autowired
	private IStockInfoMgmt stockService;
	@Override
	public void run(String... args) throws Exception {
//		System.out.println(stockService.registerStock(new StockInfo(new Random().nextInt(1000), 
//				"ICICI-Prodential","ICICI",3333,"BSE")));
//		
//	     System.out.println("__________________Inset ALL to save mulitple documents _______________");
//	       StockInfo s1=new StockInfo(new Random().nextInt(1000), 
//					"HDFC-Life","HDFC",4444,"NSE");
//	       StockInfo s2=new StockInfo(new Random().nextInt(1000), 
//					"HSBC-Life","HSBC",6666,"BSE");
//	       StockInfo s3=new StockInfo(new Random().nextInt(1000), 
//					"HDFC-Life","HDFC",4444,"NSE");
//	       StockInfo s4=new StockInfo(new Random().nextInt(1000), 
//					"SBI-Insrance","SBI",5555,"BSE");
//	       String msg = stockService.registerStockDetailsBatch(List.of(s1,s2,s3,s4));
//	       System.out.println(msg);
		// TODO Auto-generated method stub
		
		System.out.print("________________Fetch the Records Exchange Type________");
        stockService.fetchStockDetailsByExchange("BSE").forEach(System.out::println);
        
        System.out.println("________________Fetch the Records by Prize____________");
        stockService.fetchStockDetailsByPriceRange(3000, 5000).forEach(System.out::println);
        System.out.println("________________Fetch and Update by ID____________");
        System.out.println(stockService.updateStockDetailsById(663, 9999, "NSE"));
        System.out.println("________________Fetch and Update Multiple documents____________");
        System.out.println(stockService.updateStockExchangeNameByPriceRange(3000, 6000, "NSE"));
        System.out.println("________________Update the document or Insert the document____________");
        System.out.println(stockService.saveOrUpdateStock("G-Life", 6000, "BSE"));
        System.out.println("________________Document deletion____________");
        System.out.println(stockService.removeStocksByPriceRange(2000, 5000));
	}

}
