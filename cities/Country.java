package cities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Country implements Comparable<Country> {
	private Set<City> cities;
	private String name;

	public Country(String name) {
		this.name = name;
		cities = new TreeSet<City>();
	}

	public void addCity(City city) {
		if (!name.equals(city.getCountry().toString()))
			throw new IllegalArgumentException();
		cities.add(city);
	}

	public int population() {
		int sum=0;
		for (City c : cities)
			sum += c.getPopulation();
		return sum;
	}

	@Override
	public String toString() {
		return name;
	}

	public List<City> smallCities(int under) {
		List<City> under_list = new ArrayList<>();
		for (City c : cities)
			if (c.getPopulation() < under)
				under_list.add(c);
		Collections.sort(under_list);
		return under_list;
	}

	public String report() {
		String temp = name +"(" + population() +") : " ;
		List<City> sorted_cities = smallCities(population()+1);
		/*sorted_cities = all country cities sorted*/
		for(int i=0;i<sorted_cities.size();i++) {
			City city_i = sorted_cities.get(i);
			temp = temp + city_i.getName() +"(" + city_i.getPopulation() + ")";
					/*add , and space*/
					if(i<sorted_cities.size()-1)
						temp = temp + ", ";
			
		}
		return temp;
	}

	@Override
	public int compareTo(Country o) {
		return name.compareToIgnoreCase(o.name);
	}
	
	@Override
	public boolean equals(Object other) {
		Country o =(Country) other;
		return name.equals(o.name);
	}
	

}// class
