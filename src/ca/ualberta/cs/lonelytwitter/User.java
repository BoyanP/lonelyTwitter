package ca.ualberta.cs.lonelytwitter;

//test class?


public abstract class User
{
	//What's in a class?
	//methods / functions
	//attributes - like variables; hold data
		// they are associated with the class/object
	
	protected String name;
	//public is an access modifier
	 // 4 modifiers:
		//public - anyone/ any class can use/access
		//private - more like class specific
		//protected - from other classes but same package
		// default - from same package, it doesn't allow subclasses.

	//attributes should almost always be private (because of encapsulation)
		
	public User(String name) //it is the constructor. You can tell because class name and this method name are the same. 
	{

		super();
		setName(name);
	}
	
	public User(){
		
		super();
		name = "Anonymous"; 
		
		
	}
	
	
	public String getName()
	{
	
		return name;
	}



	public abstract void setName(String name) throws IOException
	{
	
		this.name = name;
	}
	
	
	
}
