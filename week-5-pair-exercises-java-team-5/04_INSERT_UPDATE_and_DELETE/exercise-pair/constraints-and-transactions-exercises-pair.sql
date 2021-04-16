-- Write queries to return the following:
-- Make the following changes in the "world" database.

-- 1. Add Superman's hometown, Smallville, Kansas to the city table. The
-- countrycode is 'USA', and population of 45001.

INSERT INTO city(name, district, population, countrycode)
VALUES ('Smallville', 'Kansas', 45001, 'USA');

SELECT *
FROM city
WHERE name ILIKE 'smallville';

-- 2. Add Kryptonese to the countrylanguage table. Kryptonese is spoken by 0.0001
-- percentage of the 'USA' population.

INSERT INTO countrylanguage (language, countrycode, percentage, isofficial)
VALUES ('Kryptonese', 'USA', 0.0001, false);

-- 3. After heated debate, "Kryptonese" was renamed to "Krypto-babble." Change
-- the appropriate record accordingly.

UPDATE countrylanguage
SET language = 'Krypto-babble'
WHERE language = 'Kryptonese';


SELECT * 
FROM countrylanguage
WHERE language = 'Krypto-babble';



-- 4. Set the US capital to Smallville, Kansas in the country table.

UPDATE country 
SET capital = 4080
WHERE code = 'USA';


SELECT *
FROM country
WHERE code = 'USA';

-- 5. Delete Smallville, Kansas from the city table. (Did it succeed? Why?)

DELETE 
FROM city
WHERE name ILIKE 'smallville';

It didnt succedd becuase smallville is also the capital of the countrycode 'USA' aka foreign key restraint error.

-- 6. Return the US capital to Washington.
UPDATE country 
SET capital = 3813
WHERE code = 'USA';

SELECT *
FROM city 
WHERE name = 'Washington' AND countrycode ='USA';


-- 7. Delete Smallville, Kansas from the city table. (Did it succeed? Why?)


DELETE 
FROM city
WHERE name ILIKE 'smallville';

YES! it is no longer attached to any other table (key).


-- 8. Reverse the "is the official language" setting for all languages where the
-- country's year of independence is within the range of 1800 and 1972
-- (exclusive).
-- (590 rows affected)

UPDATE countrylanguage
SET isofficial = NOT isofficial
FROM country
WHERE countrylanguage.countrycode = country.code AND indepyear > 1800 AND indepyear < 1972;





-- 9. Convert population so it is expressed in 1,000s for all cities. (Round up to
-- the nearest integer value.)
-- (4079 rows affected)

UPDATE city
SET population = round(population/1000);

SELECT * 
FROM city;


-- 10. Assuming a country's surfacearea is expressed in square miles, convert it to
-- square meters for all countries where French is spoken by more than 20% of the
-- population.
-- (7 rows affected)


UPDATE country 
SET surfacearea = (surfacearea*2589988.1103)
FROM countrylanguage
WHERE countrylanguage.countrycode = country.code AND language = 'French' AND percentage > 20;


SELECT *
FROM country
INNER JOIN countrylanguage ON countrylanguage.countrycode = country.code
WHERE language = 'French' AND percentage > 20;

