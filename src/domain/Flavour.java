package domain;

public class Flavour {
	String strName;
	int intPrice;

	public Flavour(String strName, int intPrice) {
		this.strName = strName;
		this.intPrice = intPrice;
	}

	public void setName(String strName) {
		this.strName = strName;
	}

	public String getName() {
		return strName;
	}

	public void setPrice(int intPrice) {
		this.intPrice = intPrice;
	}

	public int getPrice() {
		return intPrice;
	}
}