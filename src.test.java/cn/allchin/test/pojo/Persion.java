package cn.allchin.test.pojo;

public class Persion {
	private String name=null;
	private Integer id=null;
	private String email=null	;
	
	public Persion() {
		 
	}

	public Persion(String name) {
		this.name=name;
	}
	
	public Persion(Integer id,String name,String email) {
		this.name=name;
		this.id=id;
		this.email=email;
	}
	
	public Persion(String name,Integer id,String email) {
		this.name=name;
		this.id=id;
		this.email=email;
	}
	
	@Override
	public String toString() {
		return this.id+"-"+this.name+"-"+this.email;
	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
