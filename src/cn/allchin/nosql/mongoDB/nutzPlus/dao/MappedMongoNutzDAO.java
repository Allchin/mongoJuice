package cn.allchin.nosql.mongoDB.nutzPlus.dao;

import java.sql.ResultSet;
import java.util.List;

import org.nutz.dao.Chain;
import org.nutz.dao.Condition;
import org.nutz.dao.ConnCallback;
import org.nutz.dao.Dao;
import org.nutz.dao.DatabaseMeta;
import org.nutz.dao.FieldMatcher;
import org.nutz.dao.SqlManager;
import org.nutz.dao.entity.Entity;
import org.nutz.dao.entity.Record;
import org.nutz.dao.pager.Pager;
import org.nutz.dao.sql.Sql;

import cn.allchin.nosql.mongoDB.dao.impl.MappedCRUDMongoDAO;

import com.mongodb.DBCollection;
import com.mongodb.MongoException;

/**
 * <p>Title:MongoNutzDAO</p>
 * <p>Description:
 *  
 * @TODO nutz DAO 支持实现 
 * </p>	
 * <p>Copyright: Copyright (c) 2011</p>
 

 * @author Allchin
 *
 * @version 1.0 $ 2011-6-16 下午09:09:37
 * 
 * @deprecated 考虑取消这个接口的实现,这个接口定义太多的方法,并不适合与nosql数据库特征
 */
 
public class MappedMongoNutzDAO  extends MappedCRUDMongoDAO   implements Dao  {

	 
	/**Clear the table ,in fact ,drop it !  
	 *  @TODO test
	 *  @return -1:Exception
	 */
	public int clear(Class<?> clazz) {
		int count=-1;
		try {
			DBCollection table=this.getDAO(clazz.newInstance()).getTable();
			count=(int)table.count();
			table.drop();
		}
		catch (MongoException e) {
			 
			e.printStackTrace();
		}
		catch (InstantiationException e) {
			 
			e.printStackTrace();
		}
		catch (IllegalAccessException e) {
			 
			e.printStackTrace();
		}
		 
		 
		 
		return count;
	}

 
	/** drop the table
	 *  @TODO test
	 *  @See {@link #clear(Class)}
	 */
	public int clear(String tableName) {
		int count=-1;
		try {
			count = clear(Class.forName(tableName));
		}
		catch (ClassNotFoundException e) {
		 
			e.printStackTrace();
		}
		
		return count;
	}

	 
	 
	/**clear by condition 
	 * 
	 */
	public int clear(Class<?> clazz, Condition arg1) {
		
		return 0;
	}

	@Override
	public int clear(String arg0, Condition arg1) {
		// 
		return 0;
	}

	@Override
	public <T> T clearLinks(T arg0, String arg1) {
		// 
		return null;
	}

	@Override
	public int count(Class<?> arg0) {
		// 
		return 0;
	}

	@Override
	public int count(String arg0) {
		// 
		return 0;
	}

	@Override
	public int count(Class<?> arg0, Condition arg1) {
		// 
		return 0;
	}

	@Override
	public int count(String arg0, Condition arg1) {
		// 
		return 0;
	}

	@Override
	public <T> Entity<T> create(Class<T> arg0, boolean arg1) {
		// 
		return null;
	}

	@Override
	public Pager createPager(int arg0, int arg1) {
		// 
		return null;
	}

 
	public int delete(Object arg0) {
		// 
		return 0;
	}

	@Override
	public int delete(Class<?> arg0, long arg1) {
		// 
		return 0;
	}

	@Override
	public int delete(Class<?> arg0, String arg1) {
		// 
		return 0;
	}

	@Override
	public int deleteLinks(Object arg0, String arg1) {
		// 
		return 0;
	}

	@Override
	public int deleteWith(Object arg0, String arg1) {
		// 
		return 0;
	}

	@Override
	public <T> int deletex(Class<T> arg0, Object... arg1) {
		// 
		return 0;
	}

	@Override
	public boolean drop(Class<?> arg0) {
		// 
		return false;
	}

	@Override
	public boolean drop(String arg0) {
		// 
		return false;
	}

	@Override
	public void execute(Sql... arg0) {
		// 
		
	}

	@Override
	public boolean exists(Class<?> arg0) {
		// 
		return false;
	}

	@Override
	public boolean exists(String arg0) {
		// 
		return false;
	}

	@Override
	public <T> T fastInsert(T arg0) {
		// 
		return null;
	}

	@Override
	public <T> T fetch(Class<T> arg0) {
		// 
		return null;
	}

	@Override
	public <T> T fetch(T arg0) {
		// 
		return null;
	}

	@Override
	public <T> T fetch(Class<T> arg0, long arg1) {
		// 
		return null;
	}

	@Override
	public <T> T fetch(Class<T> arg0, String arg1) {
		// 
		return null;
	}

	@Override
	public <T> T fetch(Class<T> arg0, Condition arg1) {
		// 
		return null;
	}

	@Override
	public Record fetch(String arg0, Condition arg1) {
		// 
		return null;
	}

	@Override
	public <T> T fetchLinks(T arg0, String arg1) {
		// 
		return null;
	}

	@Override
	public <T> T fetchx(Class<T> arg0, Object... arg1) {
		// 
		return null;
	}

	@Override
	public int func(Class<?> arg0, String arg1, String arg2) {
		// 
		return 0;
	}

	@Override
	public int func(String arg0, String arg1, String arg2) {
		// 
		return 0;
	}

	@Override
	public <T> Entity<T> getEntity(Class<T> arg0) {
		// 
		return null;
	}

	@Override
	public int getMaxId(Class<?> arg0) {
		// 
		return 0;
	}

	@Override
	public <T> T getObject(Class<T> arg0, ResultSet arg1, FieldMatcher arg2) {
		// 
		return null;
	}

	@Override
	public <T> T insert(T arg0) {
		// 
		return null;
	}

	@Override
	public void insert(String arg0, Chain arg1) {
		// 
		
	}

	@Override
	public void insert(Class<?> arg0, Chain arg1) {
		// 
		
	}

	@Override
	public <T> T insertLinks(T arg0, String arg1) {
		// 
		return null;
	}

	@Override
	public <T> T insertRelation(T arg0, String arg1) {
		// 
		return null;
	}

	@Override
	public <T> T insertWith(T arg0, String arg1) {
		// 
		return null;
	}

	@Override
	public DatabaseMeta meta() {
		// 
		return null;
	}

	@Override
	public <T> List<T> query(Class<T> arg0, Condition arg1, Pager arg2) {
		// 
		return null;
	}

	@Override
	public List<Record> query(String arg0, Condition arg1, Pager arg2) {
		// 
		return null;
	}

	@Override
	public void run(ConnCallback arg0) {
		// 
		
	}

	@Override
	public SqlManager sqls() {
		// 
		return null;
	}

	@Override
	public int update(Object arg0) {
		// 
		return 0;
	}

	@Override
	public int update(String arg0, Chain arg1, Condition arg2) {
		// 
		return 0;
	}

	@Override
	public int update(Class<?> arg0, Chain arg1, Condition arg2) {
		// 
		return 0;
	}

	@Override
	public int updateIgnoreNull(Object arg0) {
		// 
		return 0;
	}

	@Override
	public <T> T updateLinks(T arg0, String arg1) {
		// 
		return null;
	}

	@Override
	public int updateRelation(Class<?> arg0, String arg1, Chain arg2,
			Condition arg3) {
		// 
		return 0;
	}

	@Override
	public <T> T updateWith(T arg0, String arg1) {
		// 
		return null;
	} 
	
	
}
