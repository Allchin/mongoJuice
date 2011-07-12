package cn.allchin.nosql.mongoDB.dao.impl;

import java.util.ArrayList;
import java.util.List;

import cn.allchin.nosql.mongoDB.objStoneFormat.ObjectAndDBObject;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

/**
 * <p>Title:MongoDAO</p>
 * <p>Description:
 *  
 *
 * </p>	
 * <p>Copyright: Copyright (c) 2011</p>
 

 * @author Allchin
 *
 * @version 1.0 $ 2011-6-16 下午09:12:14
 *
 *
 */
public class BasicCRUDMongoDAO {
	private DBCollection table=null;
 
	public BasicCRUDMongoDAO() {
			 
	}
	
	/**
	 * @param db
	 * @param objOfTable
	 */
	public BasicCRUDMongoDAO(DB db,Object objOfTable) {
	 
		this.table=db.getCollection(objOfTable.getClass().getSimpleName());
		
	}
	
	
	
	public void save(Object obj)throws Exception{
		getTable().insert(ObjectAndDBObject.obj2DBObject(obj));
	}
	
	public void update(Object obj,Object like)throws Exception{
		DBObject target=ObjectAndDBObject.obj2DBObject(obj);
		DBObject model=ObjectAndDBObject.obj2DBObjectWithoutNull(like);
		
		getTable().update(model,target);
	}
	
	public void delete(Object like)throws Exception{
		DBObject model=ObjectAndDBObject.obj2DBObjectWithoutNull(like);
		getTable().remove(model);
		
	}
	
	/**
	   根据模板来查询
	 * @param <T>
	 * @param like
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public <T> List<T> queryPage( T like,int pageNo,int pageSize )throws Exception{
		List<T> resultList=new ArrayList<T>();
		
		DBObject queryCnd=ObjectAndDBObject.obj2DBObjectWithoutNull(like);
	 
		int skip=(pageNo-1)*pageSize;
		int fetchSize=pageSize;
		
		DBCursor cusor= getTable().find(queryCnd,null,skip,fetchSize);//设置null会全部返回
	 
		while(cusor.hasNext()){
			T t=(T)ObjectAndDBObject.dbo2Object(cusor.next(),like.getClass()) ;
			
			resultList.add(t);
		}
		
		return resultList;
	}
	
	
	
	
	
	public DBCollection getTable() {
		return table;
	}
	
	public void setTable(DBCollection table) {
		this.table = table;
	}
 
	
}

