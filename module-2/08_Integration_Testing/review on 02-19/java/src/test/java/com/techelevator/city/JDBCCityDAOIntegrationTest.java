package com.techelevator.city;

import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)//sort method by name ascending
public class JDBCCityDAOIntegrationTest {

	private static final String TEST_COUNTRY = "XYZ";//create test country, relying on test data and not assumption of whats in there now

	/* Using this particular implementation of DataSource so that
	 * every database interaction is part of the same database
	 * session and hence the same database transaction */
	private static SingleConnectionDataSource dataSource;//using this implementation so every interaction is the same session and data
	private JDBCCityDAO dao;//heres the variable


	@BeforeClass /* Before any tests are run, this method initializes the datasource for testing. */
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();//instantiating the object
		dataSource.setUrl("jdbc:postgresql://localhost:5432/world");//set url where its connected to
		dataSource.setUsername("postgres");//Username
		dataSource.setPassword("postgres1");//password
		/* The following line disables autocommit for connections
		 * returned by this DataSource. This allows us to rollback
		 * any changes after each test */
		dataSource.setAutoCommit(false);//v important --disables commits during each tests, allows to roll back
	}


	@AfterClass /* After all tests have finished running, this method will close the DataSource */
	public static void closeDataSource() throws SQLException {
		dataSource.destroy();
	}

	@Before //before test
	public void setup() {//name
		String sqlInsertCountry = "INSERT INTO country (code, name, continent, region, surfacearea, "+
				"indepyear, population, lifeexpectancy, gnp, gnpold, localname, governmentform, headofstate, capital, code2) "+
				"VALUES (?, 'Afghanistan', 'Asia', 'Southern and Central Asia', 652090, 1919, 22720000, 45.9000015, 5976.00, NULL, "+
				"'Afganistan/Afqanestan', 'Islamic Emirate', 'Mohammad Omar', 1, 'AF')";//generic data but testing ?
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sqlInsertCountry, TEST_COUNTRY);//created up in static final string ^^up
		dao = new JDBCCityDAO(dataSource);//using datasource established in beforeclass so it wont autocommit
	}

	/* After each test, we rollback any changes that were made to the database so that
	 * everything is clean for the next test */
	@After //after tests
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();//not auto committing/rolling back
	}

	@Test
	public void save_new_city_and_read_it_back() {
		City theCity = makeLocalCityObject("SQL Station", "South Dakota", TEST_COUNTRY, 65535);//creates city object and sets the "stuff" test data

		dao.create(theCity);//CALLING CREATE METHOD && what im testing
		City savedCity = dao.findCityById(theCity.getId());

		assertNotEquals(null, theCity.getId());//the city has to have an id
		assertCitiesAreEqual(theCity, savedCity);//making sure the city i tried to create is the city i retrieved

		//sometimes our create will return a City that represents what was saved
		//so City saved City = dao.create();
		//and then the comparison assertCitiesAreEqual(theCity, savedCity);
		//this is bad, dont do this make sure to have the second step of actually reading from db
		//to ensure what youre testing is hwat you mean to test
	}

	@Test
	public void returns_cities_by_country_code() {
		City theCity = makeLocalCityObject("SQL Station", "South Dakota", TEST_COUNTRY, 65535);//create city

		dao.create(theCity);//testing this assuming this worked
		List<City> results = dao.findCityByCountryCode(TEST_COUNTRY);//should find 1 city

		assertNotNull(results);
		assertEquals(1, results.size());//should be only 1
		City savedCity = results.get(0);//should only be 1, so get it
		assertCitiesAreEqual(theCity, savedCity);
	}

	@Test
	public void returns_multiple_cities_by_country_code() {

		//arranged
		dao.create(makeLocalCityObject("SQL Station", "South Dakota", TEST_COUNTRY, 65535));
		dao.create(makeLocalCityObject("Postgres Point", "North Dakota", TEST_COUNTRY, 65535));

		//act
		List<City> results = dao.findCityByCountryCode(TEST_COUNTRY);

		//assert
		assertNotNull(results);
		assertEquals(2, results.size());
	}

	@Test
	public void returns_cities_by_district() {
		String testDistrict = "Tech Elevator";
		City theCity = makeLocalCityObject("SQL Station", testDistrict, TEST_COUNTRY, 65535);
		dao.create(theCity);

		List<City> results = dao.findCityByDistrict(testDistrict);

		assertNotNull(results);//if not null then do the below lines
		assertEquals(1, results.size());
		City savedCity = results.get(0);
		assertCitiesAreEqual(theCity, savedCity);

		//assuming there isnt already a test in the database
	}
	//using the dao to test the dao
	//if you want to blow away aka delete data -->truncate

	@Test
	public void update_city_bad_test_always_passes(){ //DONT DO THIS ONE
		City theCity = makeLocalCityObject("SQL Station", "South Dakota", TEST_COUNTRY, 65535);
		//add the city to db
		dao.create(theCity);

		//update local object
		theCity.setPopulation(1);
		theCity.setDistrict("Disneyland");
		//save to db
		City updatedCity = dao.update(theCity);
		//check that they are the same
		assertCitiesAreEqual(theCity, updatedCity);

		 }

	@Test
	public void update_city_good_test(){
		City theCity = makeLocalCityObject("SQL Station", "South Dakota", TEST_COUNTRY, 65535);
		//add the city to db
		dao.create(theCity);

		//update local object
		theCity.setPopulation(1);
		theCity.setDistrict("Disneyland");
		//save to db
		City updateResult  = dao.update(theCity);

		//resave
		City updatedCity = dao.findCityById((theCity.getId()));
		//check that they are the same
		assertCitiesAreEqual(theCity, updatedCity);

	}

	@Test
	public void delete_city(){

		//correct way
		City theCity = makeLocalCityObject("SQL Station", "South Dakota", TEST_COUNTRY, 65535);
		dao.create(theCity);

		List<City> cities = dao.findCityByCountryCode(TEST_COUNTRY);
		assertEquals(1, cities.size());

		dao.delete(theCity.getId());
		List<City> newResult = dao.findCityByCountryCode(TEST_COUNTRY);

		assertEquals(0, newResult.size());

	}


	private City makeLocalCityObject(String name, String district, String countryCode, int population) {
		City theCity = new City();
		theCity.setName(name);
		theCity.setDistrict(district);
		theCity.setCountryCode(countryCode);
		theCity.setPopulation(population);
		return theCity;
	}

	private void assertCitiesAreEqual(City expected, City actual) {//private helper method used in the tests
		assertEquals(expected.getId(), actual.getId());
		assertEquals(expected.getName(), actual.getName());
		assertEquals(expected.getDistrict(), actual.getDistrict());
		assertEquals(expected.getCountryCode(), actual.getCountryCode());
		assertEquals(expected.getPopulation(), actual.getPopulation());
	}
}
