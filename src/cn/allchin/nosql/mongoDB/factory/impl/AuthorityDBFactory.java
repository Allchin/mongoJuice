package cn.allchin.nosql.mongoDB.factory.impl;

import java.util.ArrayList;
import java.util.List;

import cn.allchin.nosql.mongoDB.factory.DBFactory;
import cn.allchin.nosql.mongoDB.factory.MongoFactory;

import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoOptions;
import com.mongodb.ServerAddress;

/**
 * <p>Title:AuthorityDBFactory</p>
 * <p>Description:
 * 带有权限的DBFactory
 * <br>
 * 你可以使用这个factory完成大部分事情,可以刻使用其它的factory接口打出一记组合拳!
 * <br>
 * Thingking:
 * 一个factory提供
 * 提供它的产品的实例的产生方法,如buildProduct()
 * 同时是否该保有一个产品,以便单例或快速使用.
 * 
 * <br>
 * 一个使用产品的类从使用产品,改变为使用工厂的.getProduct()获取产品.
 * 工厂将耦合降低.
 * 但是在Spring环境不用工厂也能达到相同目的.
 * </p>	
 * <p>Copyright: Copyright (c) 2011</p>
 

 * @author Allchin
 *
 * @version 1.0 $ 2011-7-14 下午10:46:36
 *
 *
 */
public class AuthorityDBFactory implements  DBFactory  {
	
 
	private static DB db=null;
 
	private String userName=null;
	private String userPwd=null;
	
	private List<String> dbAddress=null;
 
	
	private String dbName=null;
	
	private Mongo mongo=null;
	
	private MongoFactory mongoFactory=null;
	
	private MongoOptions mo=null;
 

	/** 
	 * 根据工厂等等因素产生DB实例,
	 * 如果白手起家,默认127.0.0.0:27000下的testDB数据库
	 */
	@Override
	public DB getDB() throws Exception {
		
		
		if(db!=null){
			return db;
		}
		
		if(dbName==null){
			dbName="testDB"; 
		}
		
		if(mongo!=null){
			return db=mongo.getDB(dbName);
		}
		
		if(mongoFactory!=null){
			mongo=mongoFactory.getMongo();
			return db =mongo.getDB(dbName);
		}
		
		//Address
		List<ServerAddress> sAddList=new ArrayList<ServerAddress>();
		
		if(dbAddress==null){
			sAddList.add(new ServerAddress("127.0.0.1:27000"));
			 
		}
		else{
			for(String anAddr:dbAddress){
				ServerAddress sAddr=new ServerAddress(anAddr);
				sAddList.add(sAddr);
			}
			
		}
		 			
		//Options
		if(mo==null){
			mo=new MongoOptions();
		}
  
		mongo=new Mongo(sAddList,mo);
 
		db=mongo.getDB(dbName);
		
		db.authenticate(userName,userPwd.toCharArray());
		
		return db;
	}
	

	 
	public String getDbName() {
		 
		return dbName;
	}

	@Override
	public MongoFactory getMongoFactory() {
		// 
		return mongoFactory;
	}

	@Override
	public void setDbName(String dbName) {
		this.dbName=dbName; 
		
	}

	@Override
	public void setMongoFactory(MongoFactory mongoFactory) {
		this.mongoFactory=mongoFactory;
		
	}



	public static DB getDb() {
		return db;
	}



	public static void setDb(DB db) {
		AuthorityDBFactory.db = db;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getUserPwd() {
		return userPwd;
	}



	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}



	public List<String> getDbAddress() {
		return dbAddress;
	}



	public void setDbAddress(List<String> dbAddress) {
		this.dbAddress = dbAddress;
	}


 


	public Mongo getMongo() {
		return mongo;
	}



	public void setMongo(Mongo mongo) {
		this.mongo = mongo;
	}



	public MongoOptions getMo() {
		return mo;
	}



	public void setMo(MongoOptions mo) {
		this.mo = mo;
	}


}
