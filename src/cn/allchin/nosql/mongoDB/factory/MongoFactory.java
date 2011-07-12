package cn.allchin.nosql.mongoDB.factory;

import java.util.List;

import com.mongodb.Mongo;

public interface MongoFactory {
	
	public   Mongo getMongo()throws Exception;
	
	public void setServerAddress(List<String> serverAddress);
	
	public List<String> getServerAddress();
}
