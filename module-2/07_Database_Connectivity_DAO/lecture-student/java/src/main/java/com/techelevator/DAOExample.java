package com.techelevator;

import org.apache.commons.dbcp2.BasicDataSource;

import com.techelevator.city.City;
import com.techelevator.city.CityDAO;
import com.techelevator.city.JDBCCityDAO;

import java.util.List;

public class DAOExample {

	public static void main(String[] args) {

		BasicDataSource worldDataSource = new BasicDataSource();
		worldDataSource.setUrl("jdbc:postgresql://localhost:5432/world");
		worldDataSource.setUsername("postgres");
		worldDataSource.setPassword("postgres1");

		CityDAO dao = new JDBCCityDAO(worldDataSource);

		City smallville = new City();
		smallville.setCountryCode("USA");
		smallville.setDistrict("KS");
		smallville.setName("Smallville");
		smallville.setPopulation(42080);

		dao.save(smallville);

		City theCity = dao.findCityById(smallville.getId());

		List<City> allTheCities = dao.findCityByCountryCode("USA");
		for (City c : allTheCities) {
			System.out.println(c.getName() + " " + c.getPopulation());
		}

		allTheCities = dao.findCityByDistrict("Ohio");
		for (City c : allTheCities) {
			System.out.println(c.getName() + " " + c.getPopulation());
		}
	//change cities in oh to oz
		for (City c : allTheCities) {
			c.setDistrict("Oz");//this modifies in memory
			dao.update(c);//saves this to the database
		}

		//delete samllville

		dao.delete(theCity.getId());


	}
}
