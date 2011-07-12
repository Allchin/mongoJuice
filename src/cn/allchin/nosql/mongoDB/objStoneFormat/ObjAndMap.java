package cn.allchin.nosql.mongoDB.objStoneFormat;

import java.util.LinkedHashMap;
import java.util.Map;

import cn.allchin.jackson.SimpleWraper;
import cn.allchin.test.pojo.Word;

/**
 * <p>Title:Obj2Map</p>
 * <p>Description:
 * 将对象 Map互相转换
 * map:{class:"cn.any.class.name",objMapJsonStr:"strictJsonStrOfMap"}
 *
 * </p>	
 * <p>Copyright: Copyright (c) 2011</p>
 

 * @author Allchin
 *
 * @version 1.0 $ 2011-6-16 上午08:18:58
 *
 *
 */
public class ObjAndMap {
	public static void main(String[] args) {
		Word word=new Word();
		
		word.setChinese("中文");
		word.setEnglish("English");
		word.setId(1);
		
		try {
			Map map=ObjAndMap.obj2Map(word);
			Map map2=ObjAndMap.obj2MapAgain(word);
			
			
			//Word word2=ObjAndMap.map2Object(map); //因为这个msp中的对象json不够严格,所以转换失败了
			Word word3=ObjAndMap.map2Object(map2); //使用严格的json才能成功
			System.out.println(word3.getChinese());
			
		}
		catch (Exception e) {
			 
			e.printStackTrace();
		}
		
	 
	}
	
	
	/**
	   将对象转为map
	 * @param obj
	 * @return
	 */
	public static Map obj2Map(Object obj)throws Exception{
		String objStr=SimpleWraper.toJSON(obj);
		Map objMap=SimpleWraper.fromJSON(objStr, LinkedHashMap.class);
		Map resultMap=new LinkedHashMap();
		
		resultMap.put(obj.getClass().getName(), objMap);
		
		return resultMap;
	}
	
	public static Map obj2MapAgain(Object obj)throws Exception{
		String objStr=SimpleWraper.toJSON(obj);
		Map resultMap=new LinkedHashMap();
		
		resultMap.put(obj.getClass().getName(),objStr);
		
		return resultMap;
	}
	
	/**
	   将map转为对象
	 * @param <T>
	 * @param map
	 * @return
	 */
	public static <T> T map2Object(Map map)throws Exception{
		String className=map.keySet().iterator().next().toString();
		
		String jsonStr=map.get(className).toString();
		
		Class<T> c=(Class<T>) Class.forName(className);
		 
		
		return    SimpleWraper.fromJSON(jsonStr, c);
		 
	}
	
	
}
