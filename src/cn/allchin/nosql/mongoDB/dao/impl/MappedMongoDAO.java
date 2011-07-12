package cn.allchin.nosql.mongoDB.dao.impl;

import java.util.ArrayList;
import java.util.List;

import cn.allchin.nosql.mongoDB.objStoneFormat.ObjectAndDBObject;

import com.mongodb.DBCursor;
import com.mongodb.DBObject;

/**
 * <p>Title:MappedMongoDAO</p>
 * <p>Description:
 *  
 * TODO 强化的条件查询的映射 MongoDAO
 * <br/>
 * extends 自 MappedCRUDMongoDAO,
 * extends 在此处还是当做扩展比较好.
 * </p>	
 * <p>Copyright: Copyright (c) 2011</p>
 

 * @author Allchin
 *
 * @version 1.0 $ 2011-7-6 下午09:51:59
 *
 *
 */
public class  MappedMongoDAO extends MappedCRUDMongoDAO{
 
	
	
		 
	/**分页条件查询
	 *  
	 * <br>Last Modified @ 2011-7-9 下午07:09:30 
	 * By:Allchin<br>
	 * @Untest
	 * @param <T>
	 * @param cnd 条件
	 * @param returnType 返回类型
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public <T> List<T> listAllByCnd(DBObject cnd,T returnType,int pageNo,int pageSize)throws Exception{
		List<T> resultList=new ArrayList<T>();
		 
	 
		int skip=(pageNo-1)*pageSize;
		int fetchSize=pageSize;
		
		DBCursor cusor=getDAO(returnType).getTable().find(cnd,null,skip,fetchSize);//设置null会全部返回
	 
		while(cusor.hasNext()){
			T t=(T)ObjectAndDBObject.dbo2Object(cusor.next(),returnType.getClass()) ;
			
			resultList.add(t);
		}
		
		return resultList;
	}
	
	
}
