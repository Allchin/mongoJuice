package cn.allchin.jackson;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

import cn.allchin.test.pojo.Word;
 

/**
 * <p>Title:SimpleWraper</p>
 * <p>Description:
 * 对jackson简单包装
 *
 * </p>	
 * <p>Copyright: Copyright (c) 2011</p>
 

 * @author Allchin
 *
 * @version 1.0 $ 2011-6-14 下午04:29:13
 *
 *
 */
public class SimpleWraper {
	
	public static void main(String[] args) {
		
		try {
			Word word=new Word();
			word.setChinese("中国");
			word.setEnglish("English");
			//word.setId(null);
			
			System.out.println(SimpleWraper.toJSON(word));
			
			String str="{\"id\":null,\"chinese\":\"中国\",\"english\":\"English\"}";
			
			Word fromStr=null;
			fromStr=SimpleWraper.fromJSON(str, Word.class);
			
			System.out.println("over");
			
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	private static ObjectMapper mapper=new ObjectMapper();
	
	static{
		//所有字段都序列化
		mapper.getSerializationConfig().setSerializationInclusion(Inclusion.ALWAYS);
		
		//反序列化设这,对于对象不存在的字段,忽略
		mapper.getDeserializationConfig().set(Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}
	
	
	
	public static String toJSON(Object obj)throws Exception{
	 
			return mapper.writeValueAsString(obj);
  
	}
	
	public static <T> T fromJSON(String jsonStr,Class<T> clazz)throws Exception{
		
		return mapper.readValue(jsonStr, clazz);
	}
	
	
	
	
 
 
}
