package cn.allchin.nosql.mongoDB.dao.impl.tester;

import java.util.List;

import cn.allchin.nosql.mongoDB.dao.impl.BasicCRUDMongoDAO;
import cn.allchin.nosql.mongoDB.factory.DBCollectionFactory;
import cn.allchin.nosql.mongoDB.factory.DBFactory;
import cn.allchin.nosql.mongoDB.factory.MongoFactory;
import cn.allchin.nosql.mongoDB.factory.impl.LocalMongoFactory;
import cn.allchin.nosql.mongoDB.factory.impl.SimpleDBFactory;
import cn.allchin.nosql.mongoDB.factory.impl.SimpleTableFactory;
import cn.allchin.test.pojo.Word;

public class CURDTester{
	public static void main(String[] args) {
		
		try {
			MongoFactory mf=new LocalMongoFactory();
			
			DBFactory df=new SimpleDBFactory();
			df.setMongoFactory(mf);
			df.setDbName("test");
			
			DBCollectionFactory dcf=new SimpleTableFactory();
			dcf.setCollectionName("test");
			dcf.setDb(df.getDB());
			
			BasicCRUDMongoDAO dao=new BasicCRUDMongoDAO();
			dao.setTable(dcf.getDBCollection());
			
			//CRUD object
			Word c=new Word();
			c.setId(44);
			c.setChinese("我靠");
			c.setEnglish("egls");
			
			Word u=new Word(44,"CAO","shit");
			
			Word f=new Word();
			f.setId(44);
			
			Word d=new Word();
			d.setId(44);
			
			//actions
			//ok
			//dao.save(c); 
			
			
			
			List<Word> qResultList= dao.queryPage(f, 1, 4);
			
			for(Word w:qResultList){
				System.out.println(w.toString());
			}
			
			//ok
			//dao.update(u,f);
			
			//ok
			//dao.delete(f);
			 
			
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
	}
	
}
