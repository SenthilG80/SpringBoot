package com.nt.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.mongodb.client.result.UpdateResult;
import com.nt.document.StockInfo;

@Service("stockService")
public class StockInfoMgmtImpl implements IStockInfoMgmt {
	
   @Autowired
   private MongoTemplate template;
   
	@Override
	public String registerStock(StockInfo info) {
		int idVal=template.save(info).getStockid();	
		return "Stock Information is save with ID Value"+idVal;
	}

	@Override
	public String registerStockDetailsBatch(List<StockInfo> list) {
     int size=((List<StockInfo>) template.insertAll(list)).size();
     
		return size+" Number of documnets saved";
	}

	@Override
	public List<StockInfo> fetchStockDetailsByExchange(String Exchange) {
		Query query=new Query();
		query.addCriteria(Criteria.where("exchangeName").is(Exchange));
		List<StockInfo> list=template.find(query, StockInfo.class);
		return list;
	}

	@Override
	public List<StockInfo> fetchStockDetailsByPriceRange(double start, double end) {
		Query query1=new Query();
		query1.addCriteria(Criteria.where("prize").gte(start).lte(end));
		List<StockInfo> list1=template.find(query1, StockInfo.class);
		return list1;
	}

	@Override
	public String updateStockDetailsById(int stockid, double newPrize, String newExchange) {
		//Prepare Query Object
		Query query=new Query();
		query.addCriteria(Criteria.where("stockid").is(stockid));
		
		//Prepare Update Object
		Update update=new Update();
		update.set("prize", newPrize);
		update.set("exchangeName", newExchange);
		
		//excute the query
		template.findAndModify(query, update, StockInfo.class);
		return "Document is updated";
	}

	@Override
	public String updateStockExchangeNameByPriceRange(double start, double end, String newExchange) {
		//Prepare Query Object
		Query query=new Query();
		query.addCriteria(Criteria.where("prize").gte(start).lte(end));
		
		//Prepare Update Object
		Update update=new Update();
		update.set("exchangeName", newExchange);


		//excute the query
		UpdateResult result= template.upsert(query, update, StockInfo.class);
		return result.getMatchedCount()==0?"document is inserted":"docment is updated";
	}

	@Override
	public String saveOrUpdateStock(String stockName, double newPrize, String newExchange) {
		//Prepare Query Object
				Query query=new Query();
				query.addCriteria(Criteria.where("stockName").is(stockName));
				
				//Prepare Update Object
				Update update=new Update();
				update.set("exchangeName", newExchange);
				update.set("prize", newPrize);
				update.setOnInsert("stockName", stockName);
				update.setOnInsert("stockid", new Random().nextInt(2000));

				//excute the query
				UpdateResult result= template.upsert(query, update, StockInfo.class);
				return result.getModifiedCount() ==0? "Document is Inserted": "Document is updated";
	}

	@Override
	public String removeStocksByPriceRange(double start, double end) {
		//Prepare Query Object
		Query query=new Query();
		query.addCriteria(Criteria.where("prize").gte(start).lte(end));
		int count=template.findAllAndRemove(query,StockInfo.class).size();
		return count+" documents are deleted";
	}

}
