package cn.allchin.nosql.mongoDB.local;

import com.mongodb.DB;

public class LocalTestDB {
	private static DB db=null;
	
	
	public static DB getDb()throws Exception {
		db=LocalMongo.getMongo().getDB("test");
		
		return db;
	}
}
