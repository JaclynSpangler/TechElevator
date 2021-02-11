-- Write queries to return the following:
-- The following changes are applied to the "dvdstore" database.**

-- 1. Add actors, Hampton Avenue, and Lisa Byway to the actor table.

INSERT INTO actor( first_name, last_name)
VALUES ('Hampton', 'Avenue');


INSERT INTO actor( first_name, last_name)
VALUES ('Lisa', 'Byway');

-- 2. Add "Euclidean PI", "The epic story of Euclid as a pizza delivery boy in
-- ancient Greece", to the film table. The movie was released in 2008 in English.
-- Since its an epic, the run length is 3hrs and 18mins. There are no special
-- features, the film speaks for itself, and doesn't need any gimmicks.


INSERT INTO film (title, description, release_year, language_id, length)
VALUES ('Euclidean PI', 'The epic story of Euclid as a pizza delivery boy in ancient Greece',
        2008, 1, 198);

SELECT * 
FROM FILM
WHERE title = 'Euclidean PI';

SELECT language_id
FROM language 
WHERE name = 'English'; 

-- 3. Hampton Avenue plays Euclid, while Lisa Byway plays his slightly
-- overprotective mother, in the film, "Euclidean PI". Add them to the film.

INSERT INTO film_actor(actor_id, film_id)
VALUES (201, 1001);

INSERT INTO film_actor(actor_id, film_id)
VALUES (202, 1001);

SELECT * 
FROM film_actor
WHERE film_id = 1001
ORDER BY actor_id;

SELECT actor_id
FROM actor
WHERE first_name = 'Hampton' AND last_name = 'Avenue';

SELECT actor_id
FROM actor
WHERE first_name = 'Lisa' AND last_name = 'Byway';

-- 4. Add Mathmagical to the category table.

INSERT INTO category(name)
VALUES ('Mathmagical');

SELECT *
FROM category;

-- 5. Assign the Mathmagical category to the following films, "Euclidean PI",
-- "EGG IGBY", "KARATE MOON", "RANDOM GO", and "YOUNG LANGUAGE"
INSERT INTO film_category (film_id, category_id)
VALUES (1001, 17);

UPDATE film_category
SET category_id = 17
WHERE film_id IN(274, 494, 714, 996);

SELECT film_id
FROM film
WHERE title IN('Euclidean PI', 'EGG IGBY', 'KARATE MOON', 'RANDOM GO', 'YOUNG LANGUAGE') ;

SELECT * 
FROM film_category
WHERE film_id = 1001;

-- 6. Mathmagical films always have a "G" rating, adjust all Mathmagical films
-- accordingly.
-- (5 rows affected)

UPDATE film
SET rating = 'G'
FROM film_category
WHERE film.film_id = film_category.film_id AND category_id = 17;

-- 7. Add a copy of "Euclidean PI" to all the stores.

INSERT INTO inventory(film_id, store_id)
VALUES (1001,1);

INSERT INTO inventory(film_id, store_id)
VALUES (1001,2);

SELECT * 
FROM inventory
WHERE film_id = 1001;

-- 8. The Feds have stepped in and have impounded all copies of the pirated film,
-- "Euclidean PI". The film has been seized from all stores, and needs to be
-- deleted from the film table. Delete "Euclidean PI" from the film table.
-- (Did it succeed? Why?)

DELETE
FROM film
WHERE film_id = 1001 

SELECT * 
FROM film 
WHERE title = 'Euclidean PI';

-- <YOUR ANSWER HERE>

-- does not work because it is connected to other tables outside of the film table aka the foreing key constraint!

-- 9. Delete Mathmagical from the category table.
-- (Did it succeed? Why?)
-- <YOUR ANSWER HERE>

DELETE
FROM category
WHERE category_id = 17 ;

--did not work because same reason as above, foreign key restraint aka atteched to other tables 

SELECT * 
FROM category
WHERE name = 'Mathmagical';

-- 10. Delete all links to Mathmagical in the film_category tale.
-- (Did it succeed? Why?)

DELETE 
FROM film_category
WHERE category_id = 17;
-- <YOUR ANSWER HERE>
--YES because it was not a foreign key 


-- 11. Retry deleting Mathmagical from the category table, followed by retrying
-- to delete "Euclidean PI".
-- (Did either deletes succeed? Why?)

DELETE
FROM category
WHERE category_id = 17 ;

-- <YOUR ANSWER HERE>

--YES, it no longer has the foreign key restraint from film_category because we deleted them.

-- 12. Check database metadata to determine all constraints of the film id, and
-- describe any remaining adjustments needed before the film "Euclidean PI" can
-- be removed from the film table.

-- in order to remove the film 'Euclidean PI' we would have to remove it from the 
-- inventory table, film_category, and film_actor table before it will allow us to remove it from the 
--film table.
