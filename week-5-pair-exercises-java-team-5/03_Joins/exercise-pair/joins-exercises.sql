-- Write queries to return the following:
-- The following queries utilize the "world" database.

-- 1. The city name, country name, and city population of all cities in Europe with population greater than 1 million
-- (36 rows)
SELECT city.name, country.name, city.population
FROM country
INNER JOIN city ON country.code = city.countrycode
WHERE continent = 'Europe' AND city.population > 1000000;

-- 2. The city name, country name, and city population of all cities in countries where French is an official language and the city population is greater than 1 million
-- (2 rows)
SELECT city.name, country.name, city.population
FROM country
INNER JOIN city ON country.code = city.countrycode
INNER JOIN countrylanguage ON countrylanguage.countrycode = country.code
WHERE language = 'French' AND isofficial = true AND city.population > 1000000;


-- 3. The name of the countries and continents where the language Javanese is spoken
-- (1 row)
SELECT country.continent, country.name
FROM country
INNER JOIN countrylanguage ON countrylanguage.countrycode = country.code
WHERE language = 'Javanese';

-- 4. The names of all of the countries in Africa that speak French as an official language
-- (5 row)
SELECT country.name
FROM country
INNER JOIN countrylanguage ON countrylanguage.countrycode = country.code
WHERE language = 'French' AND isofficial = true AND continent = 'Africa';

-- 5. The average city population of cities in Europe
-- (average city population in Europe: 287,684)
SELECT AVG (city.population)
FROM city
INNER JOIN country ON country.code = city.countrycode
WHERE continent = 'Europe';

-- 6. The average city population of cities in Asia
-- (average city population in Asia: 395,019)
SELECT AVG (city.population)
FROM city
INNER JOIN country ON country.code = city.countrycode
WHERE continent = 'Asia';

-- 7. The number of cities in countries where English is an official language
-- (number of cities where English is official language: 523)
SELECT COUNT (city.name)
FROM city
INNER JOIN countrylanguage ON countrylanguage.countrycode = city.countrycode
WHERE language = 'English' AND isofficial = true;

-- 8. The average population of cities in countries where the official language is English
-- (average population of cities where English is official language: 285,809)
SELECT round(AVG (city.population))
FROM city
INNER JOIN countrylanguage ON countrylanguage.countrycode = city.countrycode
WHERE language = 'English' AND isofficial = true;

-- 9. The names of all of the continents and the population of the continent’s largest city
-- (6 rows, largest population for North America: 8,591,309)
SELECT MAX (city.population), country.continent
FROM country
INNER JOIN city ON city.countrycode = country.code
GROUP BY country.continent;

-- 10. The names of all of the cities in South America that have a population of more than 1 million people and the official language of each city’s country
-- (29 rows)
SELECT city.name, countrylanguage.language
FROM country
INNER JOIN city ON city.countrycode = country.code
INNER JOIN countrylanguage ON countrylanguage.countrycode = country.code
WHERE isofficial = true AND country.continent = 'South America' AND city.population > 1000000;
