package cn.allchin.nosql.mongoDB.objStoneFormat;

import java.util.LinkedHashMap;
import java.util.Map;

import cn.allchin.jackson.SimpleWraper;
import cn.allchin.jackson.WithoutNullWraper;
import cn.allchin.nosql.mongoDB.local.LocalMongo;
import cn.allchin.test.pojo.Word;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

/**
 * <p>Title:ObjAndJSON</p>
 * <p>Description:
 * 在普通对象与DBOBject中转换
 *
 * </p>	
 * <p>Copyright: Copyright (c) 2011</p>
 

 * @author Allchin
 *
 * @version 1.0 $ 2011-6-16 下午04:03:28
 *
 *
 */
public class ObjectAndDBObject {
	public static void main(String[] args) {
		
		try {
			DBObject odb=ObjectAndDBObject.obj2DBObject(Word.getTestWord());
			
			DB db=LocalMongo.getMongo().getDB("test");
			DBCollection table=db.getCollection("test");
			//保存
			table.insert(odb);
			
			//查询
 
			
			
			DBObject cnd=new BasicDBObject();
			cnd.put("id", 2);
			
			DBObject twoDBO=table.findOne(cnd);
			
			Word three=ObjectAndDBObject.dbo2Object(twoDBO, Word.class);
			
			String odbStr=odb.toString();
			
			System.out.println(odbStr);
			
			Word word=ObjectAndDBObject.dbo2Object(odb,Word.class);
			
			
			System.out.println(word);
			
		}
		catch (Exception e) {
			 
			e.printStackTrace();
		}
	}
	
	/**
	   普通对象转DBObject
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public static DBObject obj2DBObject(Object obj)throws Exception{
		DBObject dbo=new BasicDBObject();
		
		String jsonStr=SimpleWraper.toJSON(obj);
		
		Map map=SimpleWraper.fromJSON(jsonStr, LinkedHashMap.class);
		
		dbo.putAll(map);
		 
		
		return dbo;
	}
	
	
	
	/**
	   普通对象转DBObject ,去掉为null的成员
	 * @param obj
	 * @return
	 * @throws Exception
	 * 
	 * TODO test
	 */
	public static DBObject obj2DBObjectWithoutNull(Object obj)throws Exception{
		DBObject dbo=new BasicDBObject();
		
		String jsonStr=WithoutNullWraper.toJSON(obj);
		
		Map map=SimpleWraper.fromJSON(jsonStr, LinkedHashMap.class);
		
		dbo.putAll(map);
		 
		
		return dbo;
	}
	/**
	    DBObject 转普通对象
	 * @param <T>
	 * @param dbo
	 * @return
	 * @throws Exception
	 */
	public static  <T> T dbo2Object(DBObject dbo,Class<T> clazz)throws Exception{
		String jsonStr=dbo.toString();
		 
	 
		
		
		return SimpleWraper.fromJSON(jsonStr,clazz);
		
		 
	}
}
