package cn.allchin.nosql.mongoDB.factory.impl;

import cn.allchin.nosql.mongoDB.factory.DBFactory;
import cn.allchin.nosql.mongoDB.factory.MongoFactory;

import com.mongodb.DB;

public class SimpleDBFactory implements DBFactory{
	private String dbName=null;
	private MongoFactory mongoFactory=null;
	
	public DB getDB()throws Exception{
		
		return getMongoFactory().getMongo().getDB(dbName);
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
