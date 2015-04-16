package domain;

public class IceCream {
	String strName;
	int intTotal;

	public void setPrice(int intTotal) {
		this.intTotal = intTotal;
	}
	
	public int getPrice() {
		return intTotal;
	}

	public void changeFlavour(Flavour FlavourChange) {
		intTotal = FlavourChange.getPrice();
	}

	public void addDecorator(Decorator DecoratorAdd) {
		intTotal = intTotal + DecoratorAdd.getPrice();
	}

	public void removeDecorator(Decorator DecoratorRemove) {
		intTotal = intTotal - DecoratorRemove.getPrice();
	}
}