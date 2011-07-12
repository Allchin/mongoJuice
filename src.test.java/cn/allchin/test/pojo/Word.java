package cn.allchin.test.pojo;

 
public class Word {
 
	private Integer id;
	
	 
	private String chinese;
	
	 
	private String english;
	
	public Word() {
		 
	}
	
	public Word(int id,String chinese,String english) {
		this.id=id;
		this.chinese=chinese;
		this.english=english;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getChinese() {
		return chinese;
	}
	public void setChinese(String chinese) {
		this.chinese = chinese;
	}
	public String getEnglish() {
		return english;
	}
	public void setEnglish(String english) {
		this.english = english;
	}
	
	public static Word  getTestWord(){
		Word word=new Word();
		word.setChinese("中文");
		word.setEnglish("english");
		word.setId(2);
		
		return word;
	}
	
	@Override
	public String toString() {
		// 
		return id+"-"+this.getChinese()+this.getEnglish();
	}
	
	
}
