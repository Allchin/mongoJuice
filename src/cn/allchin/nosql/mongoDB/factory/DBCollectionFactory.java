package cn.allchin.nosql.mongoDB.factory;

import com.mongodb.DB;
import com.mongodb.DBCollection;

public interface DBCollectionFactory {
	public DBCollection getDBCollection();

	public String getCollectionName() ;

	public void setCollectionName(String collectionName) ;

	public DB getDb() ;

	public void setDb(DB db) ;
}
