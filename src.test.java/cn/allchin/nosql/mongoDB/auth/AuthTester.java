package cn.allchin.nosql.mongoDB.auth;

import cn.allchin.nosql.mongoDB.dao.impl.MappedCRUDMongoDAO;
import cn.allchin.nosql.mongoDB.factory.DBFactory;
import cn.allchin.nosql.mongoDB.factory.impl.AuthorityDBFactory;
import cn.allchin.nosql.mongoDB.local.LocalTestDB;
import cn.allchin.test.pojo.Persion;

import com.mongodb.DB;

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
		Long l=System.currentTimeMillis();
		Persion p=new Persion();
		
		
		try {
 
			AuthorityDBFactory readOnlyDBF=new AuthorityDBFactory();
			readOnlyDBF.setDbName("test");
			readOnlyDBF.setUserName("test2");
			readOnlyDBF.setUserPwd("test");
			
			l=System.currentTimeMillis();
			System.out.println(l.intValue());
			p.set_id(l.intValue());
			dao.setDbFactory(readOnlyDBF);
			dao.save(p);
			
			writeAbleTest();
			
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}	
	/**同一个JVM中,readOnly 与writeable只能存在一个.
	 *  
	 * <br>Last Modified @ 2011-7-14 下午10:44:05 
	 * By:Allchin<br>
	 * @Untest
	 * @throws Exception
	 */
	private static void writeAbleTest()throws Exception{
		MappedCRUDMongoDAO dao=new MappedCRUDMongoDAO();
		Long l=System.currentTimeMillis();
		Persion p=new Persion();
		AuthorityDBFactory dbf=new AuthorityDBFactory();
		dbf.setDbName("test");
		dbf.setUserName("sa");
		dbf.setUserPwd("root");
		 
		dao.setDbFactory(dbf);
 
		
		
		System.out.println(l.intValue());
		p.set_id(l.intValue());
		dao.save(p);
	}
}
