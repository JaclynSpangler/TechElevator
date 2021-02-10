-- The following queries utilize the "dvdstore" database.

-- 1. All of the films that Nick Stallone has appeared in
-- (30 rows)

SELECT film.title
FROM film
INNER JOIN film_actor ON film_actor.film_id = film.film_id
INNER JOIN actor ON actor.actor_id = film_actor.actor_id
WHERE actor.first_name ilike 'Nick' AND actor.last_name ILIKE 'Stallone'
ORDER BY film.title;

-- 2. All of the films that Rita Reynolds has appeared in
-- (20 rows)
SELECT film.title
FROM film
INNER JOIN film_actor ON film_actor.film_id = film.film_id
INNER JOIN actor ON actor.actor_id = film_actor.actor_id
WHERE actor.first_name ilike 'rita' AND actor.last_name ILIKE 'reynolds'
ORDER BY film.title;



-- 3. All of the films that Judy Dean or River Dean have appeared in
-- (46 rows)

SELECT film.title
FROM film
INNER JOIN film_actor ON film_actor.film_id = film.film_id
INNER JOIN actor ON actor.actor_id = film_actor.actor_id
WHERE (actor.first_name ilike 'judy' OR actor.first_name ilike 'river') AND actor.last_name ILIKE 'dean'
ORDER BY film.title;


-- 4. All of the the ‘Documentary’ films
-- (68 rows)

SELECT film.title
FROM film
INNER JOIN film_category ON film.film_id = film_category.film_id
INNER JOIN category ON category.category_id = film_category.category_id
WHERE category.name ILIKE 'documentary';

-- 5. All of the ‘Comedy’ films
-- (58 rows)

SELECT film.title
FROM film
INNER JOIN film_category ON film.film_id = film_category.film_id
INNER JOIN category ON category.category_id = film_category.category_id
WHERE category.name ILIKE 'comedy';

-- 6. All of the ‘Children’ films that are rated ‘G’
-- (10 rows)


SELECT film.title
FROM film
INNER JOIN film_category ON film.film_id = film_category.film_id
INNER JOIN category ON category.category_id = film_category.category_id
WHERE category.name ILIKE 'children' AND film.rating ILIKE 'g';


-- 7. All of the ‘Family’ films that are rated ‘G’ and are less than 2 hours in length
-- (3 rows)

SELECT film.title
FROM film
INNER JOIN film_category ON film.film_id = film_category.film_id
INNER JOIN category ON category.category_id = film_category.category_id
WHERE category.name ILIKE 'family' AND film.rating ILIKE 'g' AND film.length < 120;


-- 8. All of the films featuring actor Matthew Leigh that are rated ‘G’
-- (9 rows)
SELECT film.title
FROM film
INNER JOIN film_actor ON film_actor.film_id = film.film_id
INNER JOIN actor ON actor.actor_id = film_actor.actor_id
WHERE actor.first_name ILIKE 'matthew' AND actor.last_name ILIKE 'leigh' AND film.rating ILIKE 'g';

-- 9. All of the ‘Sci-Fi’ films released in 2006
-- (61 rows)

SELECT film.title
FROM film
INNER JOIN film_category ON film.film_id = film_category.film_id
INNER JOIN category ON category.category_id = film_category.category_id
WHERE category.name ILIKE 'sci-fi' AND film.release_year = 2006;

-- 10. All of the ‘Action’ films starring Nick Stallone
-- (2 rows)
SELECT film.title
FROM film
INNER JOIN film_category ON film.film_id = film_category.film_id
INNER JOIN category ON category.category_id = film_category.category_id
INNER JOIN film_actor ON film_actor.film_id = film.film_id
INNER JOIN actor ON actor.actor_id = film_actor.actor_id
WHERE actor.first_name ilike 'Nick' AND actor.last_name ILIKE 'Stallone' AND category.name ILIKE 'action';



-- 11. The address of all stores, including street address, city, district, and country
-- (2 rows)

SELECT store.store_id, address.address, address.address2, city.city, address.district, country.country
FROM store
INNER JOIN address ON store.address_id = address.address_id
INNER JOIN city ON address.city_id = city.city_id
INNER JOIN country ON city.country_id = country.country_id
ORDER BY store.store_id;





-- 12. A list of all stores by ID, the store’s street address, and the name of the store’s manager
-- (2 rows)

SELECT store.store_id, address.address, staff.first_name, staff.last_name
FROM store
INNER JOIN address ON store.address_id = address.address_id
INNER JOIN staff ON staff.staff_id = store.manager_staff_id
ORDER BY store.store_id;

-- 13. The first and last name of the top ten customers ranked by number of rentals
-- (#1 should be “ELEANOR HUNT�? with 46 rentals, #10 should have 39 rentals)

SELECT customer.first_name, customer.last_name, COUNT(customer.customer_id) 
FROM customer
INNER JOIN payment ON payment.customer_id = customer.customer_id
GROUP BY customer.first_name, customer.last_name
ORDER BY count(customer.customer_id) DESC
LIMIT 10;

-- 14. The first and last name of the top ten customers ranked by dollars spent
-- (#1 should be “KARL SEAL�? with 221.55 spent, #10 should be “ANA BRADLEY�? with 174.66 spent)



SELECT customer.first_name, customer.last_name, SUM(payment.amount) 
FROM customer
INNER JOIN payment ON payment.customer_id = customer.customer_id
GROUP BY customer.first_name, customer.last_name
ORDER BY SUM(payment.amount) DESC
LIMIT 10;

-- 15. The store ID, street address, total number of rentals, total amount of sales (i.e. payments), and average sale of each store.
-- (NOTE: Keep in mind that while a customer has only one primary store, they may rent from either store.)
-- (Store 1 has 7928 total rentals and Store 2 has 8121 total rentals)

SELECT store.store_id, address.address, COUNT(rental.*), AVG(payment.amount), SUM(payment.amount)
FROM address
INNER JOIN store ON store.address_id = address.address_id
INNER JOIN inventory ON inventory.store_id = store.store_id
INNER JOIN rental ON rental.inventory_id = inventory.inventory_id
INNER JOIN payment ON payment.rental_id = rental.rental_id

GROUP BY store.store_id, address.address;



-- 16. The top ten film titles by number of rentals
-- (#1 should be “BUCKET BROTHERHOOD�? with 34 rentals and #10 should have 31 rentals)

SELECT film.title , COUNT(rental.*)
FROM film 
INNER JOIN inventory ON inventory.film_id = film.film_id
JOIN rental ON rental.inventory_id = inventory.inventory_id
GROUP BY film.title
ORDER BY COUNT(rental.*) DESC 
LIMIT 10;


-- 17. The top five film categories by number of rentals
-- (#1 should be “Sports�? with 1179 rentals and #5 should be “Family�? with 1096 rentals)


SELECT category.name , COUNT(rental.*)
FROM category 
INNER JOIN film_category ON film_category.category_id = category.category_id
INNER JOIN inventory ON inventory.film_id = film_category.film_id
INNER JOIN rental ON rental.inventory_id = inventory.inventory_id
GROUP BY category.name
ORDER BY COUNT(rental.*) DESC 
LIMIT 5;


-- 18. The top five Action film titles by number of rentals
-- (#1 should have 30 rentals and #5 should have 28 rentals)



SELECT film.title , COUNT(rental.*)
FROM film
INNER JOIN film_category ON film_category.film_id = film.film_id 
INNER JOIN category ON film_category.category_id = category.category_id
INNER JOIN inventory ON inventory.film_id = film_category.film_id
INNER JOIN rental ON rental.inventory_id = inventory.inventory_id
WHERE category.name ILIKE 'action'
GROUP BY film.title
ORDER BY COUNT(rental.*) DESC 
LIMIT 5;


-- 19. The top 10 actors ranked by number of rentals of films starring that actor
-- (#1 should be “GINA DEGENERES�? with 753 rentals and #10 should be “SEAN GUINESS�? with 599 rentals)


SELECT actor.first_name, actor.last_name , COUNT(rental.*)
FROM actor
INNER JOIN film_actor ON film_actor.actor_id = actor.actor_id
INNER JOIN film ON film.film_id = film_actor.film_id
INNER JOIN film_category ON film_category.film_id = film.film_id 
INNER JOIN category ON film_category.category_id = category.category_id
INNER JOIN inventory ON inventory.film_id = film_category.film_id
INNER JOIN rental ON rental.inventory_id = inventory.inventory_id
GROUP BY actor.actor_id, actor.first_name, actor.last_name
ORDER BY COUNT(rental.*) DESC 
LIMIT 10;



-- 20. The top 5 “Comedy�? actors ranked by number of rentals of films in the “Comedy�? category starring that actor
-- (#1 should have 87 rentals and #5 should have 72 rentals)


SELECT actor.first_name, actor.last_name , COUNT(rental.*)
FROM actor
INNER JOIN film_actor ON film_actor.actor_id = actor.actor_id
INNER JOIN film ON film.film_id = film_actor.film_id
INNER JOIN film_category ON film_category.film_id = film.film_id 
INNER JOIN category ON film_category.category_id = category.category_id
INNER JOIN inventory ON inventory.film_id = film_category.film_id
INNER JOIN rental ON rental.inventory_id = inventory.inventory_id
WHERE category.name ILIKE 'comedy'
GROUP BY actor.actor_id, actor.first_name, actor.last_name
ORDER BY COUNT(rental.*) DESC 
LIMIT 5;
