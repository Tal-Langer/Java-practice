package shop;

public enum Type {
	ACOUSTIC, ELECTRIC, CLASSICAL;
	
	@Override
	public String toString(){
		switch(this)
		{
		case ACOUSTIC:return "Acoustic";
		case ELECTRIC:return "Electric";
		default:return "Classical";
		
		}
	}
}
