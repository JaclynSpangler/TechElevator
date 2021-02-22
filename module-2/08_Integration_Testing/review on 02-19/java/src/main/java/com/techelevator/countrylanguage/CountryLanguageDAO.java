package com.techelevator.countrylanguage;

import java.util.List;

public interface CountryLanguageDAO {

    List<CountryLanguage> getLanguagesForCountry(String countrycode);
    void updateLanguage(CountryLanguage cl);
}
