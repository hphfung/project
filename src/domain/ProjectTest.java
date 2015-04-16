package domain;

import junit.framework.*;

public class ProjectTest extends TestCase{
	private IceCream iceCream;
	private Flavour flavour;
	private Decorator decorator;
	
	public void setUp() {
		iceCream = new IceCream();
		iceCream.setPrice(0);
		flavour = new Flavour("Coffee", 10);
		decorator = new Decorator("Oreo", 3);
	}

	public void testProject() {
		String strExpected = "Coffee";
		assertEquals(strExpected, flavour.getName());
		
		strExpected = "Oreo";
		assertEquals(strExpected, decorator.getName());
		
		int intExpected = 0;
		assertEquals(intExpected, iceCream.getPrice());
		
		intExpected = 10;
		assertEquals(intExpected, flavour.getPrice());
				
		intExpected = 3;
		assertEquals(intExpected, decorator.getPrice());
		
		iceCream.changeFlavour(flavour);
		intExpected = 10;
		assertEquals(intExpected, iceCream.getPrice());
		
		iceCream.addDecorator(decorator);
		intExpected = 13;
		assertEquals(intExpected, iceCream.getPrice());
		
		iceCream.removeDecorator(decorator);
		intExpected = 10;
		assertEquals(intExpected, iceCream.getPrice());
	}
}