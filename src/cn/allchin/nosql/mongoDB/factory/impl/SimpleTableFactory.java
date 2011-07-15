package cn.allchin.nosql.mongoDB.factory.impl;

import cn.allchin.nosql.mongoDB.factory.DBCollectionFactory;

import com.mongodb.DB;
import com.mongodb.DBCollection;

public class SimpleTableFactory implements DBCollectionFactory {
	private String collectionName=null;
	private DB db=null;
	private DBCollection dbCollection =null;
	
	/**
	 * Thinking:
	 * 我发现,如果你的方法要return 一个对象,如果先判断这个对象不为null,直接 return改对象的话,
	 * <br>
	 * 能够有效的减少方法嵌套的层次. 
	 */
	public DBCollection getDBCollection(){
		if(dbCollection!=null){
			return dbCollection;
		}
		
		dbCollection=getDb().getCollection(collectionName);
		
		return dbCollection;
		
		
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
