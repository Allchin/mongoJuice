package cn.allchin.nosql.mongoDB.factory.impl;

import java.util.ArrayList;
import java.util.List;

import cn.allchin.nosql.mongoDB.factory.MongoFactory;

import com.mongodb.Mongo;
import com.mongodb.MongoOptions;
import com.mongodb.ServerAddress;

/**
 * <p>Title:LocalMongo</p>
 * <p>Description:
 * 单列的本地mongo链接
 *
 * </p>	
 * <p>Copyright: Copyright (c) 2011</p>
 

 * @author Allchin
 *
 * @version 1.0 $ 2011-6-16 下午04:08:11
 *
 *
 */
public class LocalMongoFactory implements MongoFactory {
	 
	@Override
	public Mongo getMongo() throws Exception {
			Mongo mongo=null;
			//Address
			List<ServerAddress> sAddList=new ArrayList<ServerAddress>();
			
			
			ServerAddress sAddr=new ServerAddress("127.0.0.1:27000");
			sAddList.add(sAddr);
 
			
			//Options
			MongoOptions mo=new MongoOptions();
	 
			
			mongo=new Mongo(sAddList,mo);
		 
		 
 
		
		return mongo;
	}

	@Override
	public List<String> getServerAddress() {
		 
		return null;
	}

	@Override
	public void setServerAddress(List<String> serverAddress) {
		 
	}
}
