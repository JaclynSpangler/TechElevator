package com.techelevator.countrylanguage;

import org.junit.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;


import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class JDBCCountryLanguageDAOIntegrationTest {

    private static final String TEST_COUNTRY = "XYZ";//create test country, relying on test data and not assumption of whats in there now

    /* Using this particular implementation of DataSource so that
     * every database interaction is part of the same database
     * session and hence the same database transaction */
    private static SingleConnectionDataSource dataSource;//using this implementation so every interaction is the same session and data
    private JDBCCountryLanguageDAO dao;//heres the variable

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
        dao = new JDBCCountryLanguageDAO(dataSource);//using datasource established in beforeclass so it wont autocommit
    }

    /* After each test, we rollback any changes that were made to the database so that
     * everything is clean for the next test */
    @After //after tests
    public void rollback() throws SQLException {
        dataSource.getConnection().rollback();//not auto committing/rolling back
    }

    @Test
    public void test_get_languages_for_country(){
        //add a country language to the DB
        addLanguageForCountryToDatabase(TEST_COUNTRY, 5.5,"Klingon", true);
        CountryLanguage expected = new CountryLanguage(TEST_COUNTRY, true,"Klingon", 5.5);

        //act- get languages for country
        List<CountryLanguage> list = dao.getLanguagesForCountry(TEST_COUNTRY);

        //assert
        assertEquals(1, list.size());
        assertLanguagesAreEqual(expected, list.get(0));
    }

    private void addLanguageForCountryToDatabase(String countryCode, double percent, String name, boolean isOfficial){
        String sql= "INSERT INTO countrylanguage(countrycode, percentage, isofficial, language) "+
                "VALUES (?,?,?,?)";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql, countryCode, percent, isOfficial, name);
    }

    private void assertLanguagesAreEqual(CountryLanguage a, CountryLanguage b){
        assertEquals(a.getCountryCode(), b.getCountryCode());
        assertEquals(a.getLanguage(), b.getLanguage());
        assertEquals(a.isOfficial(), b.isOfficial());
        assertEquals(a.getPercentage(), b.getPercentage(), 01);
    }


}
