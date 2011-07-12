package cn.allchin.nosql.mongoDB.cnd.impl;


import cn.allchin.nosql.mongoDB.cnd.MongoDBCndConstant;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

/**
 * <p>Title:Cnd</p>
 * <p>Description:
 *  查询条件
 *
 * </p>	
 * <p>Copyright: Copyright (c) 2011</p>
 

 * @author Allchin
 *
 * @version 1.0 $ 2011-7-7 下午10:03:57
 *
 *
 */
public class Cnd   {
	
	/**
	 * 条件的根元素
	 */
	private  DBObject root=null;
	
	/**大于某条件
	 *  
	 * <br>Last Modified @ 2011-7-6 下午10:51:10 
	 * By:Allchin<br>
	 * @Untest
	 *  
	 * @param field
	 * @param value
	 */
	public void gt(DBObject root,String field,Object value){
		if(root==null){
			root=new BasicDBObject(); 
		}
		
		DBObject cnd=new BasicDBObject();
		
		cnd.put(MongoDBCndConstant.GT, value.toString());
		
		root.put(field, cnd);
		 
	}
	
	/**条件包装类,代码复用
	 *  
	 * <br>Last Modified @ 2011-7-7 下午09:19:01 
	 * By:Allchin<br>
	 *  
	 * @param matchType
	 *  
	 * @param field
	 * @param value
	 */
	private void cndWraper(String matchType,String field,Object value){
		if(root==null){
			root=new BasicDBObject(); 
		}
		
		DBObject cnd=new BasicDBObject();
		
		cnd.put(matchType, value.toString());
		
		root.put(field, cnd);
	}
 
	/**小于某条件
	 * 
	 * <br>Last Modified @ 2011-7-7 下午09:20:55 
	 * By:Allchin<br>
	 * @Untest
	 *  
	 * @param field
	 * @param value
	 */
	public void lt(String field,Object value){
		cndWraper(MongoDBCndConstant.LT, field, value);
	}
	
	 
	/**大于等于某条件
	 * greater and equal
	 * <br>Last Modified @ 2011-7-7 下午09:21:48 
	 * By:Allchin<br>
	 * @Untest
	 *  
	 * @param field
	 * @param value
	 */
	public void ge(String field,Object value){
		cndWraper(MongoDBCndConstant.GTE, field, value);
	}
 
	/**小于等于某条件
	 * 
	 * <br>Last Modified @ 2011-7-7 下午09:22:32 
	 * By:Allchin<br>
	 * @Untest
	 *  
	 * @param field
	 * @param value
	 */
	public void le(String field,Object value){
		cndWraper(MongoDBCndConstant.LTE, field, value);
	}
 
	/**等于某条件
	 * 
	 * <br>Last Modified @ 2011-7-7 下午09:24:16 
	 * By:Allchin<br>
	 * @Untest
	 *  
	 * @param field
	 * @param value
	 */
	public void eq(String field,Object value){
		if(root==null){
			root=new BasicDBObject(); 
		} 
		root.put(field, value);
	}
	
	/**不等于某条件
	 *  
	 * <br>Last Modified @ 2011-7-7 下午09:31:25 
	 * By:Allchin<br>
	 * @Untest
	 * 
	 * @param field
	 * @param value
	 */
	public void ne(String field,Object value){
		cndWraper(MongoDBCndConstant.NE, field, value);
	}
 
	/**介于两个条件之间[不包含条件项]
	 * 
	 * <br>Last Modified @ 2011-7-7 下午09:25:33 
	 * By:Allchin<br>
	 * @Untest
	 *  
	 * @param field
	 * @param low
	 * @param high
	 */
	public void between(String field,Object low,Object high){
		if(root==null){
			root=new BasicDBObject(); 
		}
		
		DBObject cnd=new BasicDBObject();
		  
		cnd.put(MongoDBCndConstant.GT, low);
		cnd.put(MongoDBCndConstant.LT, high);
		
		root.put(field, cnd);
		
	}
	
	/**IN
	 * 
	 * <br>Last Modified @ 2011-7-7 下午09:56:18 
	 * By:Allchin<br>
	 * @Untest
	 * 
	 * @param field
	 * @param values
	 */
	public void in(String field,Object[] values){
		
		cndWraper(MongoDBCndConstant.IN,  field, values.toString());
	}
	
	/**not in
	 *  
	 * <br>Last Modified @ 2011-7-7 下午09:56:27 
	 * By:Allchin<br>
	 * @Untest
	 * 
	 * @param field
	 * @param values
	 */
	public void nin(String field,Object[] values){
		
		cndWraper(MongoDBCndConstant.NIN,field, values.toString());
	}
	
	/**得到条件表达对象,查询的时候调用我吧
	 *  
	 * <br>Last Modified @ 2011-7-9 下午07:32:37 
	 * By:Allchin<br>
	 * @Untest
	 * @return
	 */
	public DBObject getInstance() {
		return root;
	} 
	
}
