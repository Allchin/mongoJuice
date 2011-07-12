package cn.allchin.nosql.mongoDB.local;

import java.util.ArrayList;
import java.util.List;

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
public class LocalMongo {
	private static Mongo mongo=null;
	
	public static Mongo getMongo()throws Exception{
		if(mongo==null){
			//Address
			List<ServerAddress> sAddList=new ArrayList<ServerAddress>();
			
			
			ServerAddress sAddr=new ServerAddress("127.0.0.1:27000");
			sAddList.add(sAddr);
 		
			//Options
			MongoOptions mo=new MongoOptions();
	 
			
			mongo=new Mongo(sAddList,mo);
		}
		 
 
		
		return mongo;
	}
}
