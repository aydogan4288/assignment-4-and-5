package assignment4;

public class Singleton {
	
	private static Singleton singleton = new Singleton();
	private String string = "This is a singleton";
	
	private Singleton() {
		System.out.println(string);
	}
	
	public static synchronized Singleton getInstance() {
		if (singleton == null) { 
			 singleton = new Singleton();
		}
		 return singleton;
	}
	
	public String getString() {
		return string;
	}
	
	public void setString(String string) {
		this.string = string;
	}
}
