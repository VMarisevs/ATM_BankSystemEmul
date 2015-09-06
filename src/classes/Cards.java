package classes;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Cards extends Accounts {
	// List Of Additional Variables
		private int cardNumber1;
		private int cardNumber2;
		private String pin;
		private Date expDate;
		private int block;
		
		/*------------------------------------------------------------------*/
	    // Constructors
		 Cards(int CcardNumber1, int CcardNumber2, String Cpin, String CexpDate){
			 block = 3; // card blocks after 3 wrong pins
			 cardNumber1 = CcardNumber1;
			 cardNumber2 = CcardNumber2;
			 pin = Cpin;
			 
			 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		        try{
		        	expDate = sdf.parse(CexpDate);
		        } catch (Exception e){
		            //Error parsing date
		        	PrivateConnections pc = new PrivateConnections();
		        	pc.writeToLogFile("#10004 Error Parsing Date in Cards Constructor, the format is yyyy-mm-dd");
		        }
		 }
		 
		 Cards(int CcardNumber1, int CcardNumber2, String Cpin){
			 this(CcardNumber1, CcardNumber2, Cpin, "2000-01-01");
		 }
		 
		 Cards(int CcardNumber1, int CcardNumber2){
			 this(CcardNumber1, CcardNumber2, "1000", "2000-01-01");
		 }
		 
		 Cards(int CcardNumber1){
			 this(CcardNumber1, 0, "1000", "2000-01-01");
		 }
		 
		public Cards(){
			 this(0, 0, "1000", "2000-01-01");
		 }
		// end of Constructors
	    /*------------------------------------------------------------------*/
	    // Get Methods
		
		 public String getCardNumber(){
		        return ""+cardNumber1+cardNumber2;
		    }
		 
		 public int getCardNumber1(){
		        return cardNumber1;
		    }

		 public int getCardNumber2(){
		        return cardNumber2;
		    }
		 
		 public String getPin(){
		        return pin;
		    }
		 
		 public int getBlock(){
			 return block;
		 }
		 
		 public String getExpDate(){
		        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		        String exp = new String("");
		        try{
		           exp = sdf.format(expDate);
		        } catch (Exception e){
		            //Error parsing date
		        	PrivateConnections pc = new PrivateConnections();
		        	pc.writeToLogFile("#10005 Error Parsing Date in Cards getExpDate method");
		        }
		    return exp;
		    }
		 
		// end of Get Methods
	    /*------------------------------------------------------------------*/
	    // Set Methods
		
		 public Cards setCardNumber(String val){
// !!!separate the string to 2 numbers!!!
			 try{
				 String cn1 = val.substring(0, 8); 
				 String cn2 = val.substring(8,16);
				 setCardNumber1(cn1);
				 setCardNumber2(cn2);
			 } catch (Exception e){
				//Error parsing Card Number
		            PrivateConnections pc = new PrivateConnections();
		        	pc.writeToLogFile("#10006 Error Parsing Card Number!!!");
			 }
			 return this;
		    }
		 
		 public Cards setCardNumber1(String val){
			 cardNumber1 = Integer.parseInt(val);
			 return this;
		    }
		 
		 public Cards setCardNumber2(String val){
			 cardNumber2 = Integer.parseInt(val);
			 return this;
		    }
		 
		 public Cards setExpDate(String val){
		        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		        expDate = null;
			        try{
			        	expDate = sdf.parse(val);
			        } catch (Exception e){
			            System.out.println("Error parsing date. " + val);
			            //Error parsing date
			            PrivateConnections pc = new PrivateConnections();
			        	pc.writeToLogFile("#10007 Error Parsing Date in Cards setExpDate method. You entered \"" + val +"\" but format is \"yyyy-mm-dd\"");
			        }
			     return this;
		    }
		 
		 public Cards generatePin(){
			 pin = ""+ (int)(Math.random()*10)+(int)(Math.random()*10)+(int)(Math.random()*10)+(int)(Math.random()*10);
			 return this;
		 }
		 
		 public Cards setPin(String val){
			 pin = val;
			 return this;
		 }
		 
		 public Cards setBlock(String val){
			 block = Integer.parseInt(val);
			 return this;
		 }
		 
		 public Cards resetBlock(){
			 block = 3;
			 return this;
		 }
		 
		 public void deductBlock(){
			 block--;
		 }
		// end of Set Methods	
}

/**
* @author Vladislavs Marisevs
*/