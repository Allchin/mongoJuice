package cn.allchin.nosql.mongoDB.factory.impl;

import java.util.ArrayList;
import java.util.List;

import cn.allchin.nosql.mongoDB.factory.MongoFactory;

import com.mongodb.Mongo;
import com.mongodb.MongoOptions;
import com.mongodb.ServerAddress;

/**
 * <p>Title:AbsMongoFactory</p>
 * <p>Description:
 * 简单的的mongoFactory
 *
 * </p>	
 * <p>Copyright: Copyright (c) 2011</p>
 

 * @author Allchin
 *
 * @version 1.0 $ 2011-6-16 下午08:26:14
 *
 *
 */
public class SimpleMongoFactory implements MongoFactory {
	private List<String> serverAddress=null;
	
	private Mongo mongo=null;
	
	public   Mongo getMongo()throws Exception{
		if(mongo!=null){
			return mongo;
		}
 
			//Address
			List<ServerAddress> sAddList=new ArrayList<ServerAddress>();
			
			for(String anAddr:getServerAddress()){
				ServerAddress sAddr=new ServerAddress(anAddr);
				sAddList.add(sAddr);
			}
			 			
			//Options
			MongoOptions mo=new MongoOptions();
	  
			mongo=new Mongo(sAddList,mo);
		 
 
		
		return mongo;
	}
	
	public void setServerAddress(List<String> serverAddress) {
		this.serverAddress = serverAddress;
	}
	public List<String> getServerAddress() {
		return serverAddress;
	}
}
