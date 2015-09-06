package tests;

import static org.junit.Assert.*;
import classes.Accounts;
import org.junit.Test;

public class AccountsTest {

	@Test
	public void testMakeLodgement() {
		// Testing Make Lodgement method with:
		// funds = 0 lodgement = 100, after funds = 100
		Accounts ac = new Accounts(000000,20000, 0, 0);
		
		assertEquals(100,ac.makeLodgement(100),0);
	}
	
	@Test
	public void testMakeLodgementNegative() {
		// Testing Make Lodgement method with:
		// funds = 0 lodgement = -100 lodgement can't be negative
		Accounts ac = new Accounts(000000,20000, 0, 0);
		
		assertEquals(0,ac.makeLodgement(-100),0);
	}
	
	@Test
	public void testMakeWidthdrawOverdraftLimit() {
		// Testing MakeWidthdraw method with: 
		// overdraft = -500
		// funds = 0
		// after widthraw actual funds should be -500
		Accounts ac = new Accounts(00000,20000, -500,0);
		// System.out.println("Funds: "+ac.getFunds());
		assertEquals(-500F,ac.makeWidthdraw(500),0);
	}
	
	@Test
	public void testMakeWidthdrawGreaterthanOverdraft() {
		// Testing MakeWidthdraw method with: 
		// overdraft = -200
		// funds = 0
		// widthdraw won't gonna happend
		Accounts ac = new Accounts(00000,20000, -200,0);
		// System.out.println("Funds: "+ac.getFunds());
		assertEquals(0F,ac.makeWidthdraw(500),0);
	}
	
	@Test
	public void testMakeWidthdrawLessThanOverdraft() {
		// Testing MakeWidthdraw method with: 
		// overdraft = -500
		// funds = 0
		// after widthraw actual funds should be -100
		Accounts ac = new Accounts(00000,20000, -500,0);
		// System.out.println("Funds: "+ac.getFunds());
		assertEquals(-100F,ac.makeWidthdraw(100),0);
	}

	@Test
	public void testMakeWidthdrawCantBeNegative() {
		// Testing MakeWidthdraw method with: 
		// funds won't gonna changed, because widthdraw can't be negative
		Accounts ac = new Accounts(00000,20000, -500,0);
		// System.out.println("Funds: "+ac.getFunds());
		assertEquals(0,ac.makeWidthdraw(-100),0);
	}


}

/**
* @author Vladislavs Marisevs
*/