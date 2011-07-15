package cn.allchin.nosql.mongoDB.factory.impl;

import cn.allchin.nosql.mongoDB.factory.DBFactory;
import cn.allchin.nosql.mongoDB.factory.MongoFactory;

import com.mongodb.DB;

public class SimpleDBFactory implements DBFactory{
	private String dbName=null;
	private MongoFactory mongoFactory=null;
	
	private DB db=null;
	
	public DB getDB()throws Exception{
		if(db!=null){
			return db;
		}
		
		db=getMongoFactory().getMongo().getDB(dbName);
		
		return db;
	}
	
	public String getDbName() {
		return dbName;
	}
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	
	public MongoFactory getMongoFactory() {
		return mongoFactory;
	}
	public void setMongoFactory(MongoFactory mongoFactory) {
		this.mongoFactory = mongoFactory;
	}
	
}
