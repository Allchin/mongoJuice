package cn.allchin.nosql.mongoDB.auth;

import cn.allchin.nosql.mongoDB.dao.impl.MappedCRUDMongoDAO;
import cn.allchin.nosql.mongoDB.local.LocalTestDB;
import cn.allchin.test.pojo.Persion;

import com.mongodb.DB;
import com.mongodb.MongoException;

/**
 * <p>Title:AuthTester</p>
 * <p>Description:
 * mongoDB的安全性只是readonly与writeable的区别,
 * 并且在数据库端没有多大意义.
 * 主要在程序中编码控制.
 * 所有mongoDB要工作在受信任的环境中
 *
 * </p>	
 * <p>Copyright: Copyright (c) 2011</p>
 

 * @author Allchin
 *
 * @version 1.0 $ 2011-7-3 下午03:02:11
 *
 *
 */
public class AuthTester {
	public static void main(String[] args) {
		
		MappedCRUDMongoDAO dao=new MappedCRUDMongoDAO();
		
		try {
			DB db=LocalTestDB.getDb();
			db.authenticate("sa", "root".toCharArray());
			dao.setDb(db);
		}
		catch (MongoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Persion p=new Persion();
			p.setId(1234);
			dao.save(p);
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
