package com.techelevator.city;

import java.util.List;

public interface CityDAO {//what we expect to do with city

	public void create(City newCity);

	public City findCityById(long id);

	public List<City> findCityByCountryCode(String countryCode);

	public List<City> findCityByDistrict(String district);

	public City update(City city);

	public void delete(long id);
}
