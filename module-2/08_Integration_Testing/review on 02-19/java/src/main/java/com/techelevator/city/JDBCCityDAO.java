package com.techelevator.city;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCCityDAO implements CityDAO {//implements interface

	private JdbcTemplate jdbcTemplate;

	public JDBCCityDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);//giving me the jdbc template, dont have a main method
	}

	@Override
	public void create(City newCity) {//takes in a city and
		String sqlInsertCity = "INSERT INTO city(id, name, countrycode, district, population) "
				+ "VALUES(?, ?, ?, ?, ?)";
		newCity.setId(getNextCityId());
		jdbcTemplate.update(sqlInsertCity, newCity.getId(), newCity.getName(), newCity.getCountryCode(),
				newCity.getDistrict(), newCity.getPopulation());
	}

	@Override
	public City findCityById(long id) {//
		City theCity = null;//just in case i dont find something so it will return null
		String sqlFindCityById = "SELECT id, name, countrycode, district, population " +
				"FROM city " +
				"WHERE id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindCityById, id);//
		if (results.next()) {//if there isnt anything then you dont want to map.
			theCity = mapRowToCity(results);
		}
		return theCity;
	}

	@Override
	public List<City> findCityByCountryCode(String countryCode) {
		ArrayList<City> cities = new ArrayList<>();
		String sqlFindCityByCountryCode = "SELECT id, name, countrycode, district, population " +
				"FROM city " +
				"WHERE countrycode = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindCityByCountryCode, countryCode);
		while (results.next()) {
			City theCity = mapRowToCity(results);//have to make all of the column names, better to list them instead of *
			cities.add(theCity);//if you use SELECT * it could pull derived columns and it could take time and energy
		}
		return cities;
	}

	@Override
	public List<City> findCityByDistrict(String district) {
		ArrayList<City> cities = new ArrayList<>();
		String sqlFindCityByCountryCode = "SELECT id, name, countrycode, district, population " + "FROM city "
				+ "WHERE district = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindCityByCountryCode, district);
		while (results.next()) {
			City theCity = mapRowToCity(results);
			cities.add(theCity);
		}
		return cities;
	}

	@Override
	public City update(City city) {//dont update primary keys usually where clause will utilize PK
		String sql = "UPDATE city set name = ?, countrycode = ?, district = ?, population = ? "+
				"WHERE id = ?";
		jdbcTemplate.update(sql,city.getName(),city.getCountryCode(),city.getDistrict(),city.getPopulation(),city.getId());
		return city;
	}

	@Override
	public void delete(long id) {
		jdbcTemplate.update("DELETE FROM city WHERE id = ?",id);//didnt need an extra string
	}

	private long getNextCityId() {
		SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('seq_city_id')");
		if (nextIdResult.next()) {
			return nextIdResult.getLong(1);
		} else {
			throw new RuntimeException("Something went wrong while getting an id for the new city");
		}
	}

	private City mapRowToCity(SqlRowSet results) {//private so the user of the class only gets info they want to get
		City theCity;
		theCity = new City();
		theCity.setId(results.getLong("id"));
		theCity.setName(results.getString("name"));
		theCity.setCountryCode(results.getString("countrycode"));
		theCity.setDistrict(results.getString("district"));
		theCity.setPopulation(results.getInt("population"));
		return theCity;
		//cant call a method on something thats null-- can remedy with if(statement)
		//if(results.getstring("name") != null){
		//theCity.setName(seulst.getString("name"));}
	}
}
