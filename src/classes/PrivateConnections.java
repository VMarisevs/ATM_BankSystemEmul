package classes;

import java.io.PrintWriter;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

import classes.Staff;

public class PrivateConnections {

	/*------------------------------------------------------------------*/
    public void writeToLogFile(String val){
    try{
        Calendar now = Calendar.getInstance();
        val = now.getTime().toString() + "  " + val + "\n";
        PrintWriter filewriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream("log/log.txt", true), "UTF-8"));
        filewriter.println(val);
        filewriter.flush();
        filewriter.close();
    }catch (Exception e){
    e.printStackTrace();
    }
    }
    // end of writeToLogFile
    /*------------------------------------------------------------------*/
    /*------------------------------------------------------------------*/
    
    public ArrayList<Staff> getListOfStaff(){
    	ArrayList<Staff> lstStaff = new ArrayList<Staff>();
    	
    	///
    	try{
            Class.forName("jstels.jdbc.mdb.MDBDriver2");
            Connection conn = DriverManager.getConnection("jdbc:jstels:mdb:" + System.getProperty("user.dir")+"/db/bankSystem.mdb");
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT	 bankstaff.ID, "
            											+ "bankstaff.pps, "
            											+ "bankstaff.firstname, "
            											+ "bankstaff.lastname, "
            											+ "bankstaff.address, "
            											+ "bankstaff.city, "
            											+ "bankstaff.phone, "
            											+ "bankstaff.dateofbirth, "
            											+ "bankstaff.gender, "
            											+ "bankstaff.email, "
            											+ "bankstaff.login, "
            											+ "bankstaff.password, "
            											+ "bankstaff.admin "
            												+ "FROM bankstaff");

           int i=1;
           while (rs.next()) {

           lstStaff.add(new Staff());
           for (int j = 1; j <= rs.getMetaData().getColumnCount(); j++) {

            //TESTING
            //   System.out.print(rs.getObject(j) + "\t");


           }

               lstStaff.get(i-1).setDBID(rs.getObject(1).toString())
               					.setPPSNumber(rs.getObject(2).toString())
               					.setFirstName(rs.getObject(3).toString())
               					.setLastName(rs.getObject(4).toString())
               					.setAddress(rs.getObject(5).toString())
               					.setCity(rs.getObject(6).toString())
               					.setPhone(rs.getObject(7).toString())
               					.setDateOfBirth(rs.getObject(8).toString())
               					.setGender(rs.getObject(9).toString())
               					.setEmail(rs.getObject(10).toString());
               	lstStaff.get(i-1).setLogin(rs.getObject(11).toString())
               					.setPassword(rs.getObject(12).toString())
               					.setAdmin(rs.getObject(13).toString());
               
           i++;
          }




         rs.close();

         stmt.close();

         conn.close();
       }
       catch (Exception e){
           e.printStackTrace();
               writeToLogFile("Error #20001 Connection to db");
        
       }
    	
    	
    	
    	///
    	return lstStaff;
    	
    }
    // end get List of Staff
    /*------------------------------------------------------------------*/
    
    public void saveStaff(Staff xStaff){
    	
    	if (xStaff.getDBID() >0){
    		
    		try{
                Class.forName("jstels.jdbc.mdb.MDBDriver2");
                Connection conn = DriverManager.getConnection("jdbc:jstels:mdb:" + System.getProperty("user.dir")+"/db/bankSystem.mdb");
                Statement stmt = conn.createStatement();

                stmt.executeUpdate("UPDATE bankstaff SET "+
                        "PPS = '" + xStaff.getPPSNumber() + "', " +
                        "FirstName = '" + xStaff.getFirstName() + "', " +
                        "LastName = '" + xStaff.getLastName() + "', " +
                        "Address = '" + xStaff.getAddress() + "', " +
                        "City = '" + xStaff.getCityID() + "', " +
                        "Phone = '" + xStaff.getPhone() + "', " +
                        "DateOfBirth = '" + xStaff.getDateOfBirth() + "', " +
                        "Gender = " + xStaff.getGender() + ", " +
                        "Email = '" + xStaff.getEmail() + "', " +
                        "Login = '" + xStaff.getLogin() + "', " +
                        "Password = '" + xStaff.getPassword() + "', " +
                        "Admin =  " + xStaff.getAdmin() + " " +
                        "WHERE  id =" + xStaff.getDBID());
                
                stmt.close();
                conn.close();

           } catch (Exception e){
               e.printStackTrace();
               writeToLogFile("Error #20002 Connection to db. Saving Staff to db");
           }
    	}
    }
    // end save Staff
    /*------------------------------------------------------------------*/
    
    public boolean insertStaff(){
    	boolean result = true;
    	Staff xStaff = new Staff();
    	
		try{
            Class.forName("jstels.jdbc.mdb.MDBDriver2");
            Connection conn = DriverManager.getConnection("jdbc:jstels:mdb:" + System.getProperty("user.dir")+"/db/bankSystem.mdb");
            Statement stmt = conn.createStatement();

            stmt.execute("INSERT INTO bankstaff ("

            											+ "pps, "
            											+ "firstname, "
            											+ "lastname, "
            											+ "address, "
            											+ "city, "
            											+ "phone, "
            											+ "dateofbirth, "
            											+ "gender, "
            											+ "email, "
            											+ "login, "
            											+ "password, "
            											+ "admin " +
                    ") VALUES (" +
                    								"'"+ xStaff.getPPSNumber() +"'," +
                    								"'"+ xStaff.getFirstName() +"'," +
                    								"'"+ xStaff.getLastName() +"'," +
                    								"'"+ xStaff.getAddress() +"'," +
                    								"'"+ xStaff.getCityID() +"'," +
                    								"'"+ xStaff.getPhone() +"'," +
                    								"'"+ xStaff.getDateOfBirth() +"'," +
                    								"'"+ xStaff.getGender() +"'," +
                    								"'"+ xStaff.getEmail() +"'," +
                    								"'"+ xStaff.getLogin() +"'," +
                    								"'"+ xStaff.getPassword() +"'," +
                    								"'"+ xStaff.getAdmin() +"'" +
                    
                    ")");
            
            stmt.close();
            conn.close();

       } catch (Exception e){
           e.printStackTrace();
           writeToLogFile("Error #20003 Connection to db. Insert into Staff table");
       }	
    	
    	
    	return result;
    }
    // end insert Staff
    /*------------------------------------------------------------------*/
    /*------------------------------------------------------------------*/
    
    public ArrayList<Customer> getListOfCustomers(){
    	ArrayList<Customer> lstCustomers = new ArrayList<Customer>();
    	
    	///
    	try{
            Class.forName("jstels.jdbc.mdb.MDBDriver2");
            Connection conn = DriverManager.getConnection("jdbc:jstels:mdb:" + System.getProperty("user.dir")+"/db/bankSystem.mdb");
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT customers.ID, "
            										+ "customers.pps, "
            										+ "customers.firstname, "
            										+ "customers.lastname, "
            										+ "customers.address, "
            										+ "customers.city, "
            										+ "customers.phone, "
            										+ "customers.dateofbirth, "
            										+ "customers.gender, "
            										+ "customers.email FROM customers;");

           int i=1;
           while (rs.next()) {

           lstCustomers.add(new Customer());
           for (int j = 1; j <= rs.getMetaData().getColumnCount(); j++) {

            //TESTING
            //   System.out.print(rs.getObject(j) + "\t");


           }

               lstCustomers.get(i-1).setDBID(rs.getObject(1).toString())
               					.setPPSNumber(rs.getObject(2).toString())
               					.setFirstName(rs.getObject(3).toString())
               					.setLastName(rs.getObject(4).toString())
               					.setAddress(rs.getObject(5).toString())
               					.setCity(rs.getObject(6).toString())
               					.setPhone(rs.getObject(7).toString())
               					.setDateOfBirth(rs.getObject(8).toString())
               					.setGender(rs.getObject(9).toString())
               					.setEmail(rs.getObject(10).toString());
               
           i++;
          }




         rs.close();

         stmt.close();

         conn.close();
       }
       catch (Exception e){
           e.printStackTrace();
               writeToLogFile("Error #20004 Connection to db. Can't get list of customers");
        
       }
    	
    	
    	
    	///
    	return lstCustomers;
    	
    }
    // end get List of Customers
    /*------------------------------------------------------------------*/
    
    public void saveCustomer(Customer xCustomer){
    	
    	if (xCustomer.getDBID() >0){
    		
    		try{
                Class.forName("jstels.jdbc.mdb.MDBDriver2");
                Connection conn = DriverManager.getConnection("jdbc:jstels:mdb:" + System.getProperty("user.dir")+"/db/bankSystem.mdb");
                Statement stmt = conn.createStatement();

                stmt.executeUpdate("UPDATE customers SET "+
                        "PPS = '" + xCustomer.getPPSNumber() + "', " +
                        "FirstName = '" + xCustomer.getFirstName() + "', " +
                        "LastName = '" + xCustomer.getLastName() + "', " +
                        "Address = '" + xCustomer.getAddress() + "', " +
                        "City = '" + xCustomer.getCityID() + "', " +
                        "Phone = '" + xCustomer.getPhone() + "', " +
                        "DateOfBirth = '" + xCustomer.getDateOfBirth() + "', " +
                        "Gender = " + xCustomer.getGender() + ", " +
                        "Email = '" + xCustomer.getEmail() + "' " +
                        "WHERE  id =" + xCustomer.getDBID());
                
                stmt.close();
                conn.close();

           } catch (Exception e){
               e.printStackTrace();
               writeToLogFile("Error #20005 Connection to db. Saving Customer to db");
           }
    	}
    }
    // end save Customer
    /*------------------------------------------------------------------*/
    
    public boolean insertCustomer(){
    	boolean result = true;
    	Customer xCustomer = new Customer();
    	
		try{
            Class.forName("jstels.jdbc.mdb.MDBDriver2");
            Connection conn = DriverManager.getConnection("jdbc:jstels:mdb:" + System.getProperty("user.dir")+"/db/bankSystem.mdb");
            Statement stmt = conn.createStatement();

            stmt.execute("INSERT INTO customers ("

            											+ "pps, "
            											+ "firstname, "
            											+ "lastname, "
            											+ "address, "
            											+ "city, "
            											+ "phone, "
            											+ "dateofbirth, "
            											+ "gender, "
            											+ "email " 
            											+      											
                    ") VALUES (" +
                    								"'"+ xCustomer.getPPSNumber() +"'," +
                    								"'"+ xCustomer.getFirstName() +"'," +
                    								"'"+ xCustomer.getLastName() +"'," +
                    								"'"+ xCustomer.getAddress() +"'," +
                    								"'"+ xCustomer.getCityID() +"'," +
                    								"'"+ xCustomer.getPhone() +"'," +
                    								"'"+ xCustomer.getDateOfBirth() +"'," +
                    								"'"+ xCustomer.getGender() +"'," +
                    								"'"+ xCustomer.getEmail() +"'" +

                    
                    ")");
            
            stmt.close();
            conn.close();

       } catch (Exception e){
           e.printStackTrace();
           writeToLogFile("Error #20006 Connection to db. Insert into Customer table");
       }	
    	
    	
    	return result;
    }
    // end insert Customer
    /*------------------------------------------------------------------*/
    /*------------------------------------------------------------------*/

    public ArrayList<Accounts> getListOfAccounts(){
    	ArrayList<Accounts> lstAccounts = new ArrayList<Accounts>();
    	
    	try{
            Class.forName("jstels.jdbc.mdb.MDBDriver2");
            Connection conn = DriverManager.getConnection("jdbc:jstels:mdb:" + System.getProperty("user.dir")+"/db/bankSystem.mdb");
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT customers.ID, "
            										+ "customers.pps, "
            										+ "customers.firstname,"
            										+ " customers.lastname, "
            										+ "customers.address, "
            										+ "customers.city, "
            										+ "customers.phone, "
            										+ "customers.dateofbirth, "
            										+ "customers.gender, "
            										+ "customers.email, "
            										
            										+ "accounts.accountNumber, "
            										
            										+ "accounts.overdraft, "
            										+ "accounts.funds, "
            										+ "accounts.monthlimit "
            										+ "FROM customers INNER JOIN accounts "
            										+ "ON customers.ID = accounts.customerID;");

           int i=1;
           while (rs.next()) {

           lstAccounts.add(new Accounts());
           for (int j = 1; j <= rs.getMetaData().getColumnCount(); j++) {

            //TESTING
            //   System.out.print(rs.getObject(j) + "\t");


           }

               lstAccounts.get(i-1).setDBID(rs.getObject(1).toString())
               					.setPPSNumber(rs.getObject(2).toString())
               					.setFirstName(rs.getObject(3).toString())
               					.setLastName(rs.getObject(4).toString())
               					.setAddress(rs.getObject(5).toString())
               					.setCity(rs.getObject(6).toString())
               					.setPhone(rs.getObject(7).toString())
               					.setDateOfBirth(rs.getObject(8).toString())
               					.setGender(rs.getObject(9).toString())
               					.setEmail(rs.getObject(10).toString());
               lstAccounts.get(i-1).setAccountNumber(rs.getObject(11).toString())
               					.setOverdraft(rs.getObject(12).toString())
               					.setFunds(rs.getObject(13).toString())
               					.setLimit(rs.getObject(14).toString());
               
           i++;
          }




         rs.close();

         stmt.close();

         conn.close();
       }
       catch (Exception e){
           e.printStackTrace();
               writeToLogFile("Error #20007 Connection to db. Getting List of Accounts");
        
       }
    	
    	
    	
    	///
    	return lstAccounts;
    	
    }
    // end get List of Accounts
    /*------------------------------------------------------------------*/
    
    public void saveAccounts(Accounts xAccounts){
    	
    	if (xAccounts.getDBID() >0){
    		
    		try{
                Class.forName("jstels.jdbc.mdb.MDBDriver2");
                Connection conn = DriverManager.getConnection("jdbc:jstels:mdb:" + System.getProperty("user.dir")+"/db/bankSystem.mdb");
                Statement stmt = conn.createStatement();

                stmt.executeUpdate("UPDATE accounts SET "+
                        "customerID = " + xAccounts.getDBID() + ", " +
                        "overdraft = " + xAccounts.getOverdraft() + ", " +
                        "funds = " + xAccounts.getFunds() + ", " +
                        "monthlimit = " + xAccounts.getLimit() + " " +
                        "WHERE  accountNumber =" + xAccounts.getAccountNumber());
                
                stmt.close();
                conn.close();

           } catch (Exception e){
               e.printStackTrace();
               writeToLogFile("Error #20008 Connection to db. Saving Accounts to db");
           }
    	}
    }
    // end save Accounts
    /*------------------------------------------------------------------*/
    
    public boolean insertAccount(){
    	boolean result = true;
    	Accounts xAccount = new Accounts();
    	
		try{
            Class.forName("jstels.jdbc.mdb.MDBDriver2");
            Connection conn = DriverManager.getConnection("jdbc:jstels:mdb:" + System.getProperty("user.dir")+"/db/bankSystem.mdb");
            Statement stmt = conn.createStatement();

            stmt.execute("INSERT INTO accounts ("

            											+ "customerID, "
            											+ "overdraft, "
            											+ "funds, "
            											+ "monthlimit "
            											+      											
                    ") VALUES (" +
                    								"'"+ xAccount.getDBID() +"'," +
                    								"'"+ xAccount.getOverdraft() +"'," +
                    								"'"+ xAccount.getFunds() +"'," +
                    								"'"+ xAccount.getLimit() +"'" +

                    
                    ")");
            
            stmt.close();
            conn.close();

       } catch (Exception e){
           e.printStackTrace();
           writeToLogFile("Error #20009 Connection to db. Insert into Customer table");
       }	
    	
    	
    	return result;
    }
    // end insert Customer
    /*------------------------------------------------------------------*/
    /*------------------------------------------------------------------*/
    public ArrayList<Cards> getListOfCards(){
    	ArrayList<Cards> lstCards = new ArrayList<Cards>();
    	
    	try{
            Class.forName("jstels.jdbc.mdb.MDBDriver2");
            Connection conn = DriverManager.getConnection("jdbc:jstels:mdb:" + System.getProperty("user.dir")+"/db/bankSystem.mdb");
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT customers.ID, "
            										+ "customers.pps, "
            										+ "customers.firstname, "
            										+ "customers.lastname, "
            										+ "customers.address, "
            										+ "customers.city, "
            										+ "customers.phone, "
            										+ "customers.dateofbirth, "
            										+ "customers.gender, "
            										+ "customers.email, "
            										
            										+ "accounts.accountNumber, "
            										+ "accounts.overdraft, "
            										+ "accounts.funds, "
            										+ "accounts.monthlimit, "
            										
            										+ "cards.creditcardID1, "
            										+ "cards.creditcardID2, "
            										+ "cards.pin, "
            										+ "cards.expdate, "
            										+ "cards.block "
            										+ "FROM (customers INNER JOIN accounts ON customers.ID = accounts.customerID) "
            										+ "INNER JOIN cards ON accounts.accountNumber = cards.accountID;");

           int i=1;
           while (rs.next()) {

           lstCards.add(new Cards());
           for (int j = 1; j <= rs.getMetaData().getColumnCount(); j++) {

            //TESTING
            //   System.out.print(rs.getObject(j) + "\t");


           }

               lstCards.get(i-1).setDBID(rs.getObject(1).toString())
               					.setPPSNumber(rs.getObject(2).toString())
               					.setFirstName(rs.getObject(3).toString())
               					.setLastName(rs.getObject(4).toString())
               					.setAddress(rs.getObject(5).toString())
               					.setCity(rs.getObject(6).toString())
               					.setPhone(rs.getObject(7).toString())
               					.setDateOfBirth(rs.getObject(8).toString())
               					.setGender(rs.getObject(9).toString())
               					.setEmail(rs.getObject(10).toString());
               lstCards.get(i-1).setAccountNumber(rs.getObject(11).toString())
               					.setOverdraft(rs.getObject(12).toString())
               					.setFunds(rs.getObject(13).toString())
               					.setLimit(rs.getObject(14).toString());
               lstCards.get(i-1).setCardNumber1(rs.getObject(15).toString())
               					.setCardNumber2(rs.getObject(16).toString())
               					.setPin(rs.getObject(17).toString())
               					.setExpDate(rs.getObject(18).toString())
               					.setBlock(rs.getObject(19).toString());
               
           i++;
          }




         rs.close();

         stmt.close();

         conn.close();
       }
       catch (Exception e){
           e.printStackTrace();
               writeToLogFile("Error #20010 Connection to db. Getting List of Cards");
        
       }
    	
    	
    	
    	///
    	return lstCards;
    	
    }
    // end get List of Cards
    /*------------------------------------------------------------------*/
    public void saveCards(Cards xCard){
    	
    	if (xCard.getDBID() >0){
    		
    		try{
                Class.forName("jstels.jdbc.mdb.MDBDriver2");
                Connection conn = DriverManager.getConnection("jdbc:jstels:mdb:" + System.getProperty("user.dir")+"/db/bankSystem.mdb");
                Statement stmt = conn.createStatement();

                stmt.executeUpdate("UPDATE cards SET "+
                        "accountID = " + xCard.getAccountNumber()+ ", " +
                        "pin ='" + xCard.getPin() + "', " +
                        "expdate = '" + xCard.getExpDate() + "' " +
                        "WHERE  creditcardID1 =" + xCard.getCardNumber1() + " AND creditcardID2 =" +xCard.getCardNumber2());
                
                stmt.close();
                conn.close();

           } catch (Exception e){
               e.printStackTrace();
               writeToLogFile("Error #20011 Connection to db. Saving Cards to db");
           }
    	}
    }
    // end save Cards
    /*------------------------------------------------------------------*/
    public boolean insertCard(){
    	boolean result = true;
    	Cards xCard = new Cards();
    	
		try{
            Class.forName("jstels.jdbc.mdb.MDBDriver2");
            Connection conn = DriverManager.getConnection("jdbc:jstels:mdb:" + System.getProperty("user.dir")+"/db/bankSystem.mdb");
            Statement stmt = conn.createStatement();
            //System.out.println("accnum "+ xCard.getAccountNumber());
            stmt.execute("INSERT INTO cards ( creditcardID1, "
            								+ "accountID, "
            								+ "pin, "
            								+ "expdate, "
            								+ "block) VALUES (" 
            								+ "37144963, "
            								+ xCard.getAccountNumber() + ", "
            						  +	" '"	+ xCard.getPin() + "', "
            						  +	" '"	+ xCard.getExpDate() + "', "
            								+ xCard.getBlock()
            								+ ")");
            
            stmt.close();
            conn.close();

       } catch (Exception e){
           e.printStackTrace();
           writeToLogFile("Error #20012 Connection to db. Insert into Cards table");
       }	
    	
    	
    	return result;
    }
    // end insert Customer
    
    
    // ATM CONNECTIONS
    public int checkCardInDatabase(String cardNumber){
    	int result = -1;
    		
    	Cards xCard = new Cards();
    	xCard.setCardNumber(cardNumber);
    	//System.out.println( xCard.getAccountNumber()+" "+ xCard.getCardNumber1() + " " + xCard.getCardNumber2());
    	try{
            Class.forName("jstels.jdbc.mdb.MDBDriver2");
            Connection conn = DriverManager.getConnection("jdbc:jstels:mdb:" + System.getProperty("user.dir")+"/db/bankSystem.mdb");
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT block FROM cards WHERE "
            							+ "creditcardID1 = " + xCard.getCardNumber1()
            							+ "AND creditcardID2 =" + xCard.getCardNumber2());

           int i=1;
           while (rs.next()) {

          
           for (int j = 1; j <= rs.getMetaData().getColumnCount(); j++) {

            //TESTING
             // System.out.print(rs.getObject(j) + "\t");


           }   
           // System.out.println(rs.getObject(1).toString());
           if (!(rs.getObject(1).toString().isEmpty())){

        		   result = Integer.parseInt(rs.getObject(1).toString());
        	   
           }
           
           i++;
          }

         rs.close();

         stmt.close();

         conn.close();
       }
       catch (Exception e){
           e.printStackTrace();
               writeToLogFile("Error #20013 Connection to db. Card validation");
        
       }
    		
    	
    	return result;
    }
    // end Card validation
    /*------------------------------------------------------------------*/
    
    public boolean checkCardAndPinInDatabase(String cardNumber,String cardPin){
    	boolean result = false;
    		
    	Cards xCard = new Cards();
    	Cards aCard = new Cards();
    	xCard.setCardNumber(cardNumber);
    	aCard.setCardNumber(cardNumber);
    	xCard.setPin(cardPin);
    	//System.out.println( xCard.getAccountNumber()+" "+ xCard.getCardNumber1() + " " + xCard.getCardNumber2());
    	try{
            Class.forName("jstels.jdbc.mdb.MDBDriver2");
            Connection conn = DriverManager.getConnection("jdbc:jstels:mdb:" + System.getProperty("user.dir")+"/db/bankSystem.mdb");
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT block, pin FROM cards WHERE "
            							+ "creditcardID1 = " + xCard.getCardNumber1()
            							+ "AND creditcardID2 =" + xCard.getCardNumber2());

           int i=1;
           while (rs.next()) {

          
           for (int j = 1; j <= rs.getMetaData().getColumnCount(); j++) {

            //TESTING
             // System.out.print(rs.getObject(j) + "\t");


           }   
           // System.out.println(rs.getObject(1).toString());
           if (!rs.getObject(1).toString().isEmpty()){
        	   aCard.setBlock(rs.getObject(1).toString());
        	   aCard.setPin(rs.getObject(2).toString());
           }
           
           i++;
          }

         rs.close();

         stmt.close();

         conn.close();
       }
       catch (Exception e){
           e.printStackTrace();
               writeToLogFile("Error #20014 Connection to db.Pin and Card validation");
        
       }
    		
    	if (aCard.getPin().equals(xCard.getPin())){
     	   result = true;
     	   updateBlock(xCard);
        } else {
     	   reduceBlock(aCard);
     	   // block --
        
        }
    	
    	return result;
    }
    // end Card validation
    /*------------------------------------------------------------------*/
    public void updateBlock(Cards xCard){
    	xCard.setBlock("3");
    	try{
            Class.forName("jstels.jdbc.mdb.MDBDriver2");
            Connection conn = DriverManager.getConnection("jdbc:jstels:mdb:" + System.getProperty("user.dir")+"/db/bankSystem.mdb");
            Statement stmt = conn.createStatement();

            stmt.executeUpdate("UPDATE cards SET "+
                    "block = " + xCard.getBlock()+ " " +
                    "WHERE  creditcardID1 =" + xCard.getCardNumber1() + " AND creditcardID2 =" +xCard.getCardNumber2());
            
            stmt.close();
            conn.close();

       } catch (Exception e){
           e.printStackTrace();
           writeToLogFile("Error #20015 Connection to db. Saving block card information to db");
       }
    }// end of update block
    /*------------------------------------------------------------------*/
    public void reduceBlock(Cards xCard){
    	xCard.setBlock(""+(xCard.getBlock()-1));
    	try{
                Class.forName("jstels.jdbc.mdb.MDBDriver2");
                Connection conn = DriverManager.getConnection("jdbc:jstels:mdb:" + System.getProperty("user.dir")+"/db/bankSystem.mdb");
                Statement stmt = conn.createStatement();

                stmt.executeUpdate("UPDATE cards SET "+
                        "block = " + xCard.getBlock()+ " " +
                        "WHERE  creditcardID1 =" + xCard.getCardNumber1() + " AND creditcardID2 =" +xCard.getCardNumber2());
                
                stmt.close();
                conn.close();

           } catch (Exception e){
               e.printStackTrace();
               writeToLogFile("Error #20015 Connection to db. Saving block card information to db");
           }
    }
    /*------------------------------------------------------------------*/
    /*------------------------------------------------------------------*/
    /*------------------------------------------------------------------*/
    /*------------------------------------------------------------------*/
    /*------------------------------------------------------------------*/
    /*------------------------------------------------------------------*/
    /*------------------------------------------------------------------*/
    /*------------------------------------------------------------------*/
    /*------------------------------------------------------------------*/
    /*------------------------------------------------------------------*/
    /*------------------------------------------------------------------*/
    public Cards getCardInfo(Cards xCard){
    	
    	try{
            Class.forName("jstels.jdbc.mdb.MDBDriver2");
            Connection conn = DriverManager.getConnection("jdbc:jstels:mdb:" + System.getProperty("user.dir")+"/db/bankSystem.mdb");
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT customers.ID, "
					+ "customers.pps, "
					+ "customers.firstname, "
					+ "customers.lastname, "
					+ "customers.address, "
					+ "customers.city, "
					+ "customers.phone, "
					+ "customers.dateofbirth, "
					+ "customers.gender, "
					+ "customers.email, "
					
					+ "accounts.accountNumber, "
					+ "accounts.overdraft, "
					+ "accounts.funds, "
					+ "accounts.monthlimit, "
					
					+ "cards.creditcardID1, "
					+ "cards.creditcardID2, "
					+ "cards.pin, "
					+ "cards.expdate, "
					+ "cards.block "
					+ "FROM (customers INNER JOIN accounts ON customers.ID = accounts.customerID) "
					+ "INNER JOIN cards ON accounts.accountNumber = cards.accountID "
					+ "WHERE creditcardID1 =" + xCard.getCardNumber1() + " AND creditcardID2 =" +xCard.getCardNumber2()+";");

           int i=1;
           while (rs.next()) {

          
           for (int j = 1; j <= rs.getMetaData().getColumnCount(); j++) {

            //TESTING
             // System.out.print(rs.getObject(j) + "\t");


           }   
           // System.out.println(rs.getObject(1).toString());
           if (!rs.getObject(1).toString().isEmpty()){
        	           	  
        	  xCard.setDBID(rs.getObject(1).toString())
								.setPPSNumber(rs.getObject(2).toString())
								.setFirstName(rs.getObject(3).toString())
								.setLastName(rs.getObject(4).toString())
								.setAddress(rs.getObject(5).toString())
								.setCity(rs.getObject(6).toString())
								.setPhone(rs.getObject(7).toString())
								.setDateOfBirth(rs.getObject(8).toString())
								.setGender(rs.getObject(9).toString())
								.setEmail(rs.getObject(10).toString());
        	  xCard.setAccountNumber(rs.getObject(11).toString())
								.setOverdraft(rs.getObject(12).toString())
								.setFunds(rs.getObject(13).toString())
								.setLimit(rs.getObject(14).toString());
        	  xCard.setCardNumber1(rs.getObject(15).toString())
								.setCardNumber2(rs.getObject(16).toString())
								.setPin(rs.getObject(17).toString())
								.setExpDate(rs.getObject(18).toString())
								.setBlock(rs.getObject(19).toString());
           }
           
           i++;
          }

         rs.close();

         stmt.close();

         conn.close();
       }
       catch (Exception e){
           e.printStackTrace();
               writeToLogFile("Error #20017 Connection to db.get funds");
        
       }
    	
    	return xCard;
    } 
    
    
}// end of connections





/**
* @author Vladislavs Marisevs
*/