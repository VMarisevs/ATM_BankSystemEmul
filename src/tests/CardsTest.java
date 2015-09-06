package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import classes.Cards;

public class CardsTest extends Cards {

	@Test
	public void testGeneratePin() {
		Cards xCard = new Cards();
		xCard.generatePin();
		System.out.println("Pin is: " + xCard.getPin());
	}

}
