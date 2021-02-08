-- SELECT ... FROM
-- Selecting the names for all countries
SELECT name
FROM country;
--doesnt matter if its one line or two, uppercase or lowercase.. if more than one statement at ;

-- Selecting the name and population of all countries
SELECT name, population
FROM country;


-- Selecting all columns from the city table
SELECT *
FROM city;

-- SELECT ... FROM ... WHERE
-- Selecting the cities in Ohio
SELECT name, district
FROM city
WHERE district = 'Ohio';  

SELECT name, district
FROM city
WHERE district ILIKE 'OHIO';-- case insensitive compare

SELECT name, district
FROM city
WHERE district LIKE 'O%';--case sensitive starts with capital O

SELECT name, district
FROM city
WHERE district LIKE '%x%'; --contains x use _ to say only one

-- Selecting countries that gained independence in the year 1776

SELECT name, indepyear
FROM country
WHERE idepyear = 1776;--doesnt need quotes because it is an int

SELECT name, indepyear
FROM country 
WHERE indepyear IN (1776, 1901);-- 1776 or 1901, also NOTIN will search for data not in certain 


SELECT name, indepyear
FROM country 
WHERE indepyear BETWEEN 1776 AND 1901; --between/and are key words that have to go together, is inclusive


-- Selecting countries not in Asia

SELECT name, continent
FROM country
WHERE continent != 'Asia';


-- Selecting countries that do not have an independence year

SELECT name, indepyear
FROM country
WHERE indepyear IS NULL;

-- Selecting countries that do have an independence year

SELECT name, indepyear
FROM country 
WHERE indepyear IS NOT NULL;


-- Selecting countries that have a population greater than 5 million

SELECT name, population
FROM country
WHERE population > 5000000;



-- SELECT ... FROM ... WHERE ... AND/OR
-- Selecting cities in Ohio and Population greater than 400,000

SELECT name, district, population
FROM city
WHERE district = 'Ohio' AND population > 400000;


-- Selecting country names on the continent North America or South America

SELECT name, continent 
FROM country
WHERE continent IN ('North America', 'South America');




-- SELECTING DATA w/arithmetic
-- Selecting the population, life expectancy, and population per area
--	note the use of the 'as' keyword

SELECT name, population, lifeexpectancy, surfacearea, population/surfacearea AS Pop_Per_Area
FROM country;
-- how many different districts are in my stuff

SELECT DISTINCT district
FROM city;

