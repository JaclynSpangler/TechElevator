BEGIN TRANSACTION;

--CREATE DATABASE database_name

DROP DATABASE IF EXISTS artgallery;-- if exists will get rid of the error by basically checking if the db exists
CREATE DATABASE artgallery;

--create the tables
/* 
CREATE TABLE table_name
(
        column_name1 data_type(size), data type = what it holds 
        column_name2 data_tyoe(size)NOT NULL, <-- forces there to be data in the column
        CONSTRAINT pk_column1 PRIMARY KEY (column_name1)<-- constraint forces it not to be NULL && UNIQUE
        CONSTRAINT fk_column2 FOREIGN KEY (column_name2) REFERENCES table_name2(columnD)<-- constraint forces it to refer to another tableand not NULL
); */

--customer table that has a customer id, name, address, and phone. customer id is the PK

CREATE TABLE customers
(
        customerID SERIAL,
        name varchar(64) NOT NULL, -- varrying length name that cant be bigger than 64
        address varchar(100) NOT NULL,
        phone varchar(11)NULL,
        
        CONSTRAINT pk_customers PRIMARY KEY(customerID)

);

--DROP TABLE IF EXISTS customers;
--DROP TABLE IF EXISTS artists;

--create a table to hold the artist with column artist id, first name, last name, artist id = PK
CREATE TABLE artists
(

        artist_id SERIAL,
        first_name varchar(64) NOT NULL,
        last_name varchar(64) NULL,
        
        CONSTRAINT pk_artists PRIMARY KEY(artist_id)
);

--art code, title, artist

CREATE TABLE art
(
        art_id SERIAL,
        title varchar(64) NOT NULL,
        artist_id int NOT NULL, --if artist_id is serial FK needs to be INT, if varchar then FK needs to be varchar
        
        CONSTRAINT pk_art PRIMARY KEY(art_id),
        CONSTRAINT fk_artists FOREIGN KEY(artist_id) REFERENCES artists(artist_id)

);


--ALTER TABLE 
/* 
ALTER TABLE table_name
ADD CONSTRAINT pk_constraint_name PRIMARY KEY(column);

ALTER TABLE table_name
ADD CONSTRAINT fk_constraint_name FOREIGN KEY (column2) REFERENCES other_table_name(other_column);

ALTER TABLE table_name
ADD CONSTRAINT check_constraint CHECK (column = 'value' OR column_name IN (values));
*/



