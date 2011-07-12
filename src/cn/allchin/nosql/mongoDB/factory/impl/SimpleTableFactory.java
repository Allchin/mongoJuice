package cn.allchin.nosql.mongoDB.factory.impl;

import cn.allchin.nosql.mongoDB.factory.DBCollectionFactory;

import com.mongodb.DB;
import com.mongodb.DBCollection;

public class SimpleTableFactory implements DBCollectionFactory {
	private String collectionName=null;
	private DB db=null;
	
	public DBCollection getDBCollection(){
		return getDb().getCollection(collectionName);
		
		
	}

	public String getCollectionName() {
		return collectionName;
	}

	public void setCollectionName(String collectionName) {
		this.collectionName = collectionName;
	}

	public DB getDb() {
		return db;
	}

	public void setDb(DB db) {
		this.db = db;
	}
	
	
	
}
