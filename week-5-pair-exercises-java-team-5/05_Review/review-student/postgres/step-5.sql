/*
 STEP ONE: Add a new park with the following data:
  ------------------------------
  name: Ohiopyle State Park
  location: Pennsylvania
  establish date: 1965-01-01
  area: 19052
  visitors: 1000000
  description: Ohiopyle State Park is a Pennsylvania state park on 19,052 acres in Dunbar, Henry Clay and Stewart Townships, Fayette County, Pennsylvania in the United States. The focal point of the park is the more than 14 miles of the Youghiogheny River Gorge that passes through the park.
  ------------------------------
*/
INSERT INTO park(name, location, establish_date, area, visitors, description)
VALUES ('Ohiopyle State Park', 'Pennsylvania', '1965-01-01', 19052, 1000000,'Ohiopyle State Park is a Pennsylvania state park on 19,052 acres in Dunbar, Henry Clay and Stewart Townships, Fayette County, Pennsylvania in the United States. The focal point of the park is the more than 14 miles of the Youghiogheny River Gorge that passes through the park.');




/*
  STEP TWO: You just found out that there was an error with the park data. Please update the park visitors to 1.5 million anually.

*/
UPDATE park
SET visitors = 1500000
WHERE park_id = 4;

-->looking for park_id VVV
SELECT *
FROM park 
WHERE name ILIKE 'Ohiopyle%';

/*
 STEP THREE: Insert new campground with the following data:
  ------------------------------------------------------------
  park_id: 4 (this should be the id of the new park you just added)
  name: Youghiogheny
  open_from_mm: 01
  open_to_mm: 12
  daily_fee: 95.00
  ------------------------------------------------------------
*/

INSERT INTO campground (park_id, name, open_from_mm, open_to_mm, daily_fee)
VALUES (4, 'Youghiogheny', '01', '12', '$95.00');



/*
 STEP FOUR: Insert 3 new sites with the following data:
 ------------------------------------------------------------
  site_number: 623, campground_id: 8
  site_number: 624, campground_id: 8
  site_number: 625, campground_id: 8
 ------------------------------------------------------------

 > campground_id 8 should be the id of the campground you just added 'Youghiogheny'

*/

INSERT INTO site(site_number, campground_id)
VALUES (623, 8), (624, 8), (625, 8);


/*
 STEP FIVE: Insert 3 reservations, 1 for each site with the following data:
------------------------------------------------------------------------------------
  site_id: 623, name: Wayne Family, from_date: today + 10 days, to_date: today + 20 days
  site_id: 624, name: Parker Family, from_date: today + 11 days, to_date: today + 20 days
  site_id: 625, name: Kent Family, from_date: today + 12 days, to_date: today + 20 days
------------------------------------------------------------------------------------

*/

INSERT INTO reservation( site_id, name, from_date, to_date)
VALUES(623, 'Wayne Family', current_date + 10, current_date +20);

INSERT INTO reservation( site_id, name, from_date, to_date)
VALUES(624, 'Parker Family', current_date + 11, current_date +20), (625, 'Kent Family', current_date + 12, current_date + 20);



SELECT *
FROM reservation
WHERE site_id = 623;


/*
 STEP SIX: The Wayne Family called and asked if they could change their reservation to today. Update the from_date to today and the to_date to a week from today.

 */


BEGIN TRANSACTION;
UPDATE reservation
SET from_date = current_date
WHERE reservation_id = 50;

UPDATE reservation 
SET to_date = current_date + 7
WHERE reservation_id =50;
COMMIT;


--check :)
SELECT *
FROM reservation 
WHERE site_id= 623; 


/*
 STEP SEVEN: The Kent family called and they would like to cancel their reservation. Delete the reservation for Kent Family.

*/

DELETE 
FROM reservation
WHERE reservation_id = 52;

SELECT * 
FROM reservation
WHERE site_id = 625;



