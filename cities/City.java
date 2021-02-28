package cities;

public class City implements Comparable<City> {
private String name;
private Country country;
private int population;

	public City(String name, Country country, int population) {
		this.name=name;
		this.country=country;
		this.population=population;
	}
	
	public String getName() {
		return name;
	}
	
	public Country getCountry() {
		return country;
	}
	
	public int getPopulation() {
		return population;
	}
	@Override
	public String toString() {
		return name + " (of " + country.toString() + ")";
	}

	@Override
	public int compareTo(City city2) {
		/*case that diffrent country*/ 
		if(!country.toString().equals(city2.country.toString()))
			return country.toString().compareToIgnoreCase(city2.country.toString());
		/*case that same country*/
		return name.compareToIgnoreCase(city2.name);
	}
	
	
	@Override
	public boolean equals(Object other) {
		City city2 = (City)other;
		/*check if same country*/
		if(country.toString().equals(city2.country.toString()))
			if(name.equals(city2.name))
				return true;
		return false;
	}
	
	
	
	
	
	
	
	
}//class
