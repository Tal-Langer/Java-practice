package shop;

public abstract class Instrument {
	protected int count;
	public static int counter=0;
	protected String company;
	protected int price;
	
	public Instrument(String company,int price) {
		this.company=company;
		this.price=price;
		count=counter;
		counter++;
	}

public int getPrice() {
	return price;
}
public String getCompany() {
	return company;
}
public int getSerial() {
	return count;
}


}
