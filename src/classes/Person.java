package classes;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Person {
	// List Of Variables
		private int dbID; 			// database id number
	    private String ppsNumber;	// Personal Public Service Number
	    private String firstName;	// Person's First Name
	    private String lastName;	// Person's Last Name
	    private String address;		// Person's Address
	    private int city;			// Person's City as integer (name from city table)
	    private String phone;		// Person's Phone Number
	    private boolean gender;		// Person's Gender T or F
	    private Date dateOfBirth;	// Person's Date of birth
	    private String email;		// Person's Email
	    
	    /*------------------------------------------------------------------*/
	    // Constructors
	    
	    public Person(int dbid, String PPS, String FName, String LName, 
	    				String Paddress, int Pcity, String Pphone, 
	    				boolean Pgender, String PDateOfBirth, String Pemail){
	    	
		    	dbID = dbid;
		    	ppsNumber = PPS;
		    	firstName = FName;
		    	lastName = LName;
		    	address = Paddress;
		    	city = Pcity;
		    	phone = Pphone;
		    	gender = Pgender;
		    		    	
		        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		        try{
		           dateOfBirth = sdf.parse(PDateOfBirth);
		        } catch (Exception e){
		            //Error parsing date
		        	PrivateConnections pc = new PrivateConnections();
		        	pc.writeToLogFile("#10001 Error Parsing Date in Person Constructor, the format is yyyy-mm-dd");
		        }
		    	email = Pemail;
		    }

	    public Person(int dbid, String PPS, String FName, String LName, String Paddress, int Pcity, String Pphone, boolean Pgender, String PDateOfBirth){
	    	
	    	this(dbid, PPS, FName, LName, Paddress, Pcity, Pphone, Pgender, PDateOfBirth, "noemail@nomail.no");
	    	
	    }
	    
	    public Person(int dbid, String PPS, String FName, String LName, String Paddress, int Pcity, String Pphone, boolean Pgender){
	    	
	    	this(dbid, PPS, FName, LName, Paddress, Pcity, Pphone, Pgender, "2000-01-01", "noemail@nomail.no");
	    	
	    }
	    
	    public Person(int dbid, String PPS, String FName, String LName, String Paddress, int Pcity, String Pphone){
	    	
	    	this(dbid, PPS, FName, LName, Paddress, Pcity, Pphone, true, "2000-01-01", "noemail@nomail.no");
	    	
	    }
	    
	    public Person(int dbid, String PPS, String FName, String LName, String Paddress, int Pcity){
	    	
	    	this(dbid, PPS, FName, LName, Paddress, Pcity, "0850000000", true, "2000-01-01", "noemail@nomail.no");
	    	
	    }
	    
	    public Person(int dbid, String PPS, String FName, String LName, String Paddress){
	    	
	    	this(dbid, PPS, FName, LName, Paddress, 1, "0850000000", true, "2000-01-01", "noemail@nomail.no");
	    	
	    }
	    
	    public Person(int dbid, String PPS, String FName, String LName){
	    	
	    	this(dbid, PPS, FName, LName, "No Address", 1, "0850000000", true, "2000-01-01", "noemail@nomail.no");
	    	
	    }
	    
	    public Person(int dbid, String PPS, String FName){
	    	
	    	this(dbid, PPS, FName, "Nosurname", "No Address", 1, "0850000000", true, "2000-01-01", "noemail@nomail.no");
	    	
	    }
	    
	    public Person(int dbid, String PPS){
	    	
	    	this(dbid, PPS, "Noname", "Nosurname", "No Address", 1, "0850000000", true, "2000-01-01", "noemail@nomail.no");
	    	
	    }

	    public Person(int dbid){
	    	
	    	this(dbid, "0000000AA", "Noname", "Nosurname", "No Address", 1, "0850000000", true, "2000-01-01", "noemail@nomail.no");
	    	
	    }

	    public Person(){
	    	
	    	this(10001, "0000000AA", "Noname", "Nosurname", "No Address", 1, "0850000000", true, "2000-01-01", "noemail@nomail.no");
	    	
	    }
	    // end of Constructors
	    /*------------------------------------------------------------------*/
	    // Get Methods
	    	
	    
	    public int getDBID(){
	        return dbID;
	    }
	    
	    public String getPPSNumber(){
	        return ppsNumber;
	    }

	    public String getFirstName(){
	        return firstName;
	    }

	    public String getLastName(){
	        return lastName;
	    }

	    public String getAddress(){
	        return address;
	    }

	    public int getCityID(){
// !!!need connection to get city from table!!!
	        return city;
	    }

	    public String getPhone(){
	        return phone;
	    }

	    public boolean getGender(){
	        return gender;
	    }
	    
	    public String getDateOfBirth(){
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
	        String dob = new String("");
	        try{
	           dob = sdf.format(dateOfBirth);
	        } catch (Exception e){
	            //Error parsing date
	        	PrivateConnections pc = new PrivateConnections();
	        	pc.writeToLogFile("#10002 Error Parsing Date in Person getDoB method");
	        }
	    return dob;
	    }
	    
	    public String getEmail(){
	        return email;
	    }
	    
	    // end of Get Methods
	    /*------------------------------------------------------------------*/
	    // Set Methods
	    
	    public Person setDBID(String val){
	        dbID = Integer.parseInt(val);
	        return this;
	    }

	    public Person setPPSNumber(String val){
	        ppsNumber = val;
	        return this;
	    }

	    public Person setFirstName(String val){
	        firstName = val;
	        return this;
	    }

	    public Person setLastName(String val){
	        lastName = val;
	        return this;
	    }

	    public Person setAddress(String val){
	        address = val;
	        return this;
	    }

	    public Person setCity(String val){

	        city = Integer.parseInt(val); 
	        return this;
	    }

	    public Person setPhone(String val){
	        phone = val;
	        return this;
	    }

	    public Person setGender(String val){
	        gender = Boolean.parseBoolean(val);
	        return this;
	    }
	    
	    public Person setDateOfBirth(String val){
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
	        dateOfBirth = null;
		        try{
		            dateOfBirth = sdf.parse(val);
		        } catch (Exception e){
		            System.out.println("Error parsing date. " + val);
		            //Error parsing date
		            PrivateConnections pc = new PrivateConnections();
		        	pc.writeToLogFile("#10003 Error Parsing Date in Person setDOB method. You entered \"" + val +"\" but format is \"yyyy-mm-dd\"");
		        }
		        return this;
	    }
	    
	    public Person setEmail(String val){
	        email = val;
	        return this;
	    }
	    // end of Set Methods
	    
	    
	    abstract void Display();
}

/**
* @author Vladislavs Marisevs
*/
