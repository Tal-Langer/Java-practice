package graph;

public class Place {

	private int x , y;
	public Place(int x, int y, int bound) {
		if(x>bound-1 || x<0 || y>bound-1 || y<0)
			throw new IllegalArgumentException();
		this.x=x;
		this.y=y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	@Override
	public boolean equals(Object other) {
		Place p = (Place)other;
		if(x == p.getX() && y==p.getY())
			return true;
		return false;
	}
	
	public int hashCode() {
		final int prime_num = 31;
		int res = 1;
		res = prime_num * res + x;
		res = prime_num * res + y;
		return res;
	}
	
	
}//class
