package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import classes.PrivateConnections;

public class PrivateConnectionsTest extends PrivateConnections {

	@Test
	public void checkCardInDatabaseTest() {
		PrivateConnections pc = new PrivateConnections();
		System.out.println(pc.checkCardInDatabase("3714496320003000"));
	}

}
