package classes;

public class Accounts extends Customer {
	// List Of Additional Variables
		private int accountNumber;
		private float limit;
		private float overdraft;
		private float funds;
		
	    /*------------------------------------------------------------------*/
	    // Constructors
		public Accounts(int CaccountNumber, int Climit, int Coverdraft, float Cfunds){
			accountNumber = CaccountNumber;
			limit = Climit;
			overdraft = Coverdraft;
			funds = Cfunds;
		}
		
		public Accounts(int CaccountNumber, int Climit, int Coverdraft){	
			this(CaccountNumber,Climit,Coverdraft,0);
		}
		
		public Accounts(int CaccountNumber, int Climit){	
			this(CaccountNumber,Climit,1500,0);
		}
		
		public Accounts(int CaccountNumber){	
			this(CaccountNumber,10000,1500,0);
		}
		
		public Accounts(){	
			this(10001,10000,1500,0);
		}
	    // end of Constructors
	    /*------------------------------------------------------------------*/
	    // Get Methods
		public int getAccountNumber(){
	        return accountNumber;
	    }
		
		public float getLimit(){
	        return limit;
	    }
		
		public float getOverdraft(){
	        return overdraft;
	    }
		
		public float getFunds(){
	        return funds;
	    }
	    // end of Get Methods
	    /*------------------------------------------------------------------*/
	    // Set Methods
		
		public Accounts setAccountNumber(String val){
			accountNumber = Integer.parseInt(val);
			return this;
	    }
		
		public Accounts setLimit(String val){
			limit = Float.parseFloat(val);
			return this;
		}
		
		public Accounts setOverdraft(String val){
			overdraft = Float.parseFloat(val);
			return this;
	    }
		
		public Accounts setFunds(String val){
			funds = Float.parseFloat(val);
			return this;
	    }
	    // end of Set Methods		
		/*------------------------------------------------------------------*/
		// widthdraw and lodgement
		
		public float makeWidthdraw(float widthdraw){
			if (widthdraw>0){
				if ((funds - widthdraw)>= overdraft){
					funds = funds - widthdraw;
				}
			}
			return funds;
		}
		
		public float makeLodgement(float lodgement){
			if (lodgement>0){
				funds = funds + lodgement;
			}
			return funds;
		}
}

/**
* @author Vladislavs Marisevs
*/