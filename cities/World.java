package cities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class World {
	private Map<String, Country> countries;
	
	public World() {
		countries = new HashMap<>();
	}
	
	public void addCountry(String name) {
		countries.put(name, new Country(name));
	}
	
	public void addCity(String name, String countryName, int population) {
		if(!countries.containsKey(countryName))
			throw new IllegalArgumentException();
		Country country = countries.get(countryName);
		/*create new city*/
		country.addCity(new City(name, country, population)); 
	}
	
	public int population() {
		int sum=0;
		for(Country c : countries.values())
			sum+=c.population();
		return sum;
	}
	
	public List<City> smallCities(int under){
		List<Country> Country_list = new ArrayList<>();
		for (Country c : countries.values())
				Country_list.add(c);
		Collections.sort(Country_list);
		/*Country_list = sorted list of all the Countries in the world*/
		List<City> city_list = new ArrayList<>();
		/*add sorted cities to city list*/
		for (Country c : Country_list)
			city_list.addAll(c.smallCities(under));
		
		return city_list;
			
	}
	
	public String report() {
		String temp = "";
		/*sort by country*/
		List<Country> Country_list = new ArrayList<>();
		for (Country c : countries.values())
				Country_list.add(c);
		Collections.sort(Country_list);
		
		for (Country c : Country_list)
			temp+=c.report() +"\n";	
		
		temp += "Total population is " + population()+"\n";
		
		return temp;
	}
	
	private static void main(String[] args) {
		World w = new World();
		w.addCountry("Spain");
		w.addCity("Granada", "Spain", 233764);
		w.addCountry("Brazil");
		w.addCity("Salvador",  "Brazil", 2677000);
		w.addCity("Barcelona", "Spain", 1615000);
		w.addCity("Rio de Janeiro",  "Brazil", 6320000);

		System.out.println(w.report());
		int bound = 2000000;
		System.out.println("Cities with population under " + bound + ":");
		System.out.println(w.smallCities(bound));

	}
	
	
}//class
