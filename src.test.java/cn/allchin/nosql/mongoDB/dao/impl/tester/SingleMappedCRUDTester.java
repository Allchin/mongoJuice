package cn.allchin.nosql.mongoDB.dao.impl.tester;

import cn.allchin.nosql.mongoDB.dao.impl.MappedCRUDMongoDAO;
import cn.allchin.nosql.mongoDB.local.LocalTestDB;
import cn.allchin.test.pojo.Persion;
import cn.allchin.test.pojo.Word;

import com.mongodb.DB;

public class SingleMappedCRUDTester {
	public static void main(String[] args) {
		MappedCRUDMongoDAO dao=null;
		
		try {
			DB db=LocalTestDB.getDb();
			dao =new MappedCRUDMongoDAO(db);
			 
			Persion p=new Persion(1,"B.A","citi008@126.com");
			Word w=Word.getTestWord();
			
			dao.save(p);
			dao.save(w);
			
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
