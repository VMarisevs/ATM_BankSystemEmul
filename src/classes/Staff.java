package classes;

public final class Staff extends Person {
	// List Of Additional Variables
		private String login;
	    private String password;
	    private boolean admin;
    
    /*------------------------------------------------------------------*/
    // Constructors
    Staff(String Slogin, String Spassword,boolean Sadmin){
    	super();
    	login = Slogin;
    	password = Spassword;
    	admin = Sadmin;
    }
    
    Staff(String Slogin, String Spassword){
    	this(Slogin,Spassword,false);
    }
    
    Staff(String Slogin){
    	this(Slogin,"12345",false);
    }
    
    public Staff(){
    	this("username","12345",false);
    	
    	
    }
    
    // end of Constructors
    /*------------------------------------------------------------------*/
    // Get Methods
    
    public String getLogin(){
        return login;
    }
    
    public String getPassword(){
        return password;
    }
    
    public boolean getAdmin(){
        return admin;
    }
    
    // end of Get Methods
    /*------------------------------------------------------------------*/
    // Set Methods
    
    public Staff setLogin(String val){
        login = val;
        return this;
    }
    
    public Staff setPassword(String val){
        password = val;
        return this;
    }
    
    public Staff setAdmin(String val){
        admin = Boolean.parseBoolean(val);
        return this;
    }
    
    public Staff setAdmin(Boolean val){
        admin = val;
        return this;
    }
    // end of Set Methods

	@Override
	void Display() {
		System.out.println("This method is implemented in Staff");
		
	}
}

/**
* @author Vladislavs Marisevs
*/