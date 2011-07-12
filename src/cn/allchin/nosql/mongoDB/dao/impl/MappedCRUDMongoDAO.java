package cn.allchin.nosql.mongoDB.dao.impl;

import java.util.HashMap;
import java.util.Map;

import com.mongodb.DB;

/**
 * <p>Title:SingleMappedCRUDMongoDAO</p>
 * <p>Description:
 * 给我一个数据库,我将能够自动根据对象映射到不同的表,并切维护不同表的dao,
 * 对对象自动分类CRUD操作,
 * 完成这一切,只需要给我一个DB
 *
 * </p>	
 * <p>Copyright: Copyright (c) 2011</p>
 

 * @author Allchin
 *
 * @version 1.0 $ 2011-6-19 上午09:58:46
 *
 *
 */
public class MappedCRUDMongoDAO  {
 	
	private   DB db=null;
	
 
	
	private static  Map<String  ,BasicCRUDMongoDAO> daoMap=new HashMap<String,BasicCRUDMongoDAO>();
 	
	public MappedCRUDMongoDAO() {
		 
	}
	
	/**指定数据源
	 * @param db
	 */
	public MappedCRUDMongoDAO(DB db) {
		this.db=db;
	}
 
	/**get BasicCRUDMongoDAO
	 *  
	 * <br>Last Modified @ 2011-7-6 下午09:26:37 
	 * By:Allchin<br>
	 *  
	 * @param dataLike
	 * @return 基本的crudDAO
	 */
	public     BasicCRUDMongoDAO getDAO(Object dataLike){
		
		BasicCRUDMongoDAO dao=null;
		
		String daoKey=dataLike.getClass().getSimpleName();
		dao=daoMap.get(daoKey);
		if(dao==null){
			dao=new BasicCRUDMongoDAO(db,dataLike);
			daoMap.put(daoKey, dao);
		}
		return dao;
		
	}
	
	 
	/**删除
	 *  
	 * <br>Last Modified @ 2011-7-6 下午09:25:39 
	 * By:Allchin<br>
	 * @Untest
	 * @param like
	 * @throws Exception
	 */
	public     void deleteAs(Object like) throws Exception {
		getDAO(like).delete(like);
		
	}
	
	/**分页查询
	 * 
	 * <br>Last Modified @ 2011-7-6 下午09:24:10 
	 * By:Allchin<br>
	 * @Untest
	 * @param <T>  结果类型
	 * @param like 类似参数
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public   <T> java.util.List<T> queryPage(T like, int pageNo, int pageSize) throws Exception {
		return getDAO(like).queryPage(like, pageNo, pageSize);
		
	};
	
 
	/**update
	 *  
	 * <br>Last Modified @ 2011-7-6 下午09:23:56 
	 * By:Allchin<br>
	 *  
	 * @param obj
	 * @param like
	 * @throws Exception
	 */
	public    void update(Object obj, Object like) throws Exception {
		getDAO(like).update(obj, like);
		 
	}
	
	 
	/**Save
	 * 
	 * <br>Last Modified @ 2011-7-6 下午09:23:18 
	 * By:Allchin<br>
	 * 	
	 * @param obj
	 * @throws Exception
	 */
	public    void save(Object obj) throws Exception {
		getDAO(obj).save(obj);
		 
	}
	
	/**
	 * 设置数据源
	 * <br>Last Modified @ 2011-7-6 下午09:23:33 
	 * By:Allchin<br>
	 * 	
	 * @param db
	 */
	public    void setDb(DB db) {
		this.db = db;
	}
	
	
	 	
}