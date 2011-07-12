package cn.allchin.nosql.mongoDB.factory;

import com.mongodb.DB;

public interface DBFactory {
	public DB getDB()throws Exception;
	
	public String getDbName();
	public void setDbName(String dbName) ;
	
	public MongoFactory getMongoFactory() ;
	public void setMongoFactory(MongoFactory mongoFactory);
}
