-- The following queries utilize the "world" database.
-- Write queries for the following problems. 
-- Notes:
--   GNP is expressed in units of one million US Dollars
--   The value immediately after the problem statement is the expected number 
--   of rows that should be returned by the query.

-- 1. The name and state plus population of all cities in states that border Ohio 
-- (i.e. cities located in Pennsylvania, West Virginia, Kentucky, Indiana, and 
-- Michigan).
-- The name and state should be returned as a single column called 
-- name_and_state and should contain values such as ‘Detroit, Michigan’.  
-- The results should be ordered alphabetically by state name and then by city 
-- name. 
-- (19 rows)

SELECT name||', '||district AS name_and_state, population 
FROM city
WHERE countrycode = 'USA' AND district IN ('Pennsylvania', 'West Virginia', 'Kentucky', 'Indiana', 'Michigan')
ORDER BY district, name;


-- 2. The name, country code, and region of all countries in Africa.  The name and
-- country code should be returned as a single column named country_and_code 
-- and should contain values such as ‘Angola (AGO)’ 
-- (58 rows)

SELECT name||', '||code AS country_and_code, region
FROM country
WHERE continent = 'Africa';

-- 3. The per capita GNP (i.e. GNP multipled by 1000000 then divided by population) of all countries in the 
-- world sorted from highest to lowest. Recall: GNP is express in units of one million US Dollars 
-- (highest per capita GNP in world: 37459.26)

SELECT name, round(((GNP*1000000)/population),2) AS per_capita
FROM country
WHERE population IS NOT NULL AND population != 0
ORDER BY round(((GNP*1000000)/population),2) DESC;

-- 4. The average life expectancy of countries in South America.
-- (average life expectancy in South America: 70.9461)

SELECT AVG(lifeexpectancy) -- i had the decimals rounded to four and it worked and then all of a sudden it said it wasnt working? so i took it out.
FROM country 
WHERE continent = 'South America';


-- 5. The sum of the population of all cities in California.
-- (total population of all cities in California: 16716706)

SELECT SUM(population)
FROM city
WHERE district = 'California';

-- 6. The sum of the population of all cities in China.
-- (total population of all cities in China: 175953614)


SELECT SUM(population)
FROM city
WHERE countrycode = 'CHN' AND population IS NOT NULL;



-- 7. The maximum population of all countries in the world.
-- (largest country population in world: 1277558000)

SELECT name, MAX(population)
FROM country
GROUP BY name
ORDER BY MAX(population) DESC;


-- 8. The maximum population of all cities in the world.
-- (largest city population in world: 10500000)

SELECT name, MAX(population)
FROM city
GROUP BY name
ORDER BY MAX(population) DESC;

-- 9. The maximum population of all cities in Australia.
-- (largest city population in Australia: 3276207

SELECT name, MAX(population)
FROM city
WHERE countrycode = 'AUS'
GROUP BY name
ORDER BY MAX(population) DESC;

-- 10. The minimum population of all countries in the world.
-- (smallest_country_population in world: 50

SELECT name, MIN(population)
FROM country 
WHERE population != 0
GROUP BY name
ORDER BY MIN(population);


-- 11. The average population of cities in the United States.
-- (avgerage city population in USA: 286955.3795)

SELECT round(AVG(population),4)
FROM city
WHERE countrycode = 'USA';


-- 12. The average population of cities in China.
-- (average city population in China: 484720.6997 approx.)

SELECT round(AVG(population), 4)
FROM city
WHERE countrycode = 'CHN';

-- 13. The surface area of each continent ordered from highest to lowest.
-- (largest continental surface area: 31881000, "Asia")

SELECT continent, SUM(surfacearea) AS combined_surface_area
FROM country
GROUP BY continent
ORDER BY SUM(surfacearea) DESC;


-- 14. The highest population density (population divided by surface area) of all 
-- countries in the world. 
-- (highest population density in world: 26277.7777)

SELECT name, (population/surfacearea) AS pop_density
FROM country
WHERE surfacearea != 0 AND population != 0
GROUP BY name, (population/surfacearea)
ORDER BY (population/surfacearea) DESC;

-- 15. The population density and life expectancy of the top ten countries with the 
-- highest life expectancies in descending order. 
-- (highest life expectancies in world: 83.5, 166.6666, "Andorra")

SELECT name, (population/surfacearea) AS pop_density, lifeexpectancy
FROM country
WHERE surfacearea != 0 AND population != 0 AND lifeexpectancy IS NOT NULL
GROUP BY name, (population/surfacearea), lifeexpectancy
ORDER BY lifeexpectancy DESC
LIMIT 10;



-- 16. The difference between the previous and current GNP of all the countries in 
-- the world ordered by the absolute value of the difference. Display both 
-- difference and absolute difference.
-- (smallest difference: 1.00, 1.00, "Ecuador")

SELECT GNP-GNPOLD AS difference_gnp, abs(gnp- gnpold) AS absolute_difference, name
FROM country
GROUP BY name, gnp-gnpold, abs(gnp-gnpold)
ORDER BY abs(gnp-gnpold); 




-- 17. The average population of cities in each country (hint: use city.countrycode)
-- ordered from highest to lowest.
-- (highest avg population: 4017733.0000, "SGP")

SELECT countrycode, round(AVG(population), 2)
FROM city
group by countrycode
ORDER BY AVG(population) DESC;

	
-- 18. The count of cities in each state in the USA, ordered by state name.
-- (45 rows)

SELECT district, count(name)
FROM city
WHERE countrycode = 'USA'
GROUP BY district
ORDER BY district;

	
-- 19. The count of countries on each continent, ordered from highest to lowest.
-- (highest count: 58, "Africa")

SELECT continent, count(*)
FROM country 
GROUP BY continent
ORDER BY count(*) DESC;

	
-- 20. The count of cities in each country ordered from highest to lowest.
-- (largest number of  cities ib a country: 363, "CHN")

SELECT countrycode, COUNT(*) 
FROM city
GROUP BY countrycode
ORDER BY COUNT(*) DESC;
	
-- 21. The population of the largest city in each country ordered from highest to 
-- lowest.
-- (largest city population in world: 10500000, "IND")


SELECT countrycode, population
FROM city
GROUP BY population, countrycode
ORDER BY population DESC;



-- 22. The average, minimum, and maximum non-null life expectancy of each continent 
-- ordered from lowest to highest average life expectancy. 
-- (lowest average life expectancy: 52.5719, 37.2, 76.8, "Africa")

SELECT continent, AVG(lifeexpectancy), MIN(lifeexpectancy), MAX(lifeexpectancy)
FROM country
WHERE lifeexpectancy IS NOT NULL
GROUP BY continent
ORDER BY AVG(lifeexpectancy);
