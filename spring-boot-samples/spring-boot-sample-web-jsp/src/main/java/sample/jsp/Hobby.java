package sample.jsp;

public class Hobby {

	private String hobbyS;
	private String x;
	
	Hobby(){
		
		this.x = "---*---";
	}
	
	public void setX(String x){
		
		this.x = x;
	}
	
	public String getX(){
		
		return this.x;
	}
	
	public void setHobbyS(String h){
		
		this.hobbyS = h;
	}
	
	public String getHobbyS(){
		
		return this.hobbyS;
	}
}
