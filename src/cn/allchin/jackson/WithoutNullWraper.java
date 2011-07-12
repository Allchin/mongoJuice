package cn.allchin.jackson;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

public class WithoutNullWraper  {
	private static ObjectMapper mapper=new ObjectMapper();
	
	static{
		//所有字段都序列化
		mapper.getSerializationConfig().setSerializationInclusion(Inclusion.NON_NULL);
		
		//反序列化设这,对于对象不存在的字段,忽略
		mapper.getDeserializationConfig().set(Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
	}

	public static String toJSON(Object obj)throws Exception{
	 
			return getMapper().writeValueAsString(obj);
  
	}
	
	public static <T> T fromJSON(String jsonStr,Class<T> clazz)throws Exception{
		
		return getMapper().readValue(jsonStr, clazz);
	}
	
	public static ObjectMapper getMapper() {
		return mapper;
	}
	
	public static void setMapper(ObjectMapper mapper) {
		WithoutNullWraper.mapper = mapper;
	}
 

}
