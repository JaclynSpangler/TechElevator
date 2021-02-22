

DROP DATABASE IF EXISTS project_organizer;
CREATE DATABASE project_organizer;


CREATE TABLE employee
(
        employee_id SERIAL,
        job_title varchar(64) NOT NULL,
        last_name varchar(64) NOT NULL,
        first_name varchar(64) NOT NULL,
        gender varchar(64),
        date_of_birth date,
        date_of_hire date NOT NULL,
        dept_id int NOT NULL,
        
        CONSTRAINT pk_employee PRIMARY KEY(employee_id),
        CONSTRAINT fk_employee_to_dept FOREIGN KEY(dept_id) REFERENCES department(dept_id)
        
);

CREATE TABLE department
(
        dept_id SERIAL,
        name varchar (64) NOT NULL,
        number_of_employees int,
        
        CONSTRAINT pk_department PRIMARY KEY(dept_id)
);

CREATE TABLE project
(
        project_id SERIAL,
        name varchar(64) NOT NULL,
        start_date date NOT NULL,
        projected_end_date date NULL,
        number_of_employees int NULL,
        
        CONSTRAINT pk_project PRIMARY KEY(project_id)
);

CREATE TABLE employee_project
(
        employee_id int NOT NULL,
        project_id int NOT NULL,
        
        CONSTRAINT fk_what_employee_works_on_project FOREIGN KEY(employee_id) REFERENCES employee(employee_id),
        CONSTRAINT fk_what_project_employee_working_on FOREIGN KEY(project_id) REFERENCES project(project_id)
);

ALTER TABLE project
ADD COLUMN completed boolean; 


--add 4 projects, 3 dept, 8 employees 

INSERT INTO department(name, number_of_employees)
VALUES ('Media', 3), ('Sales', 3), ('Human Resources', 2);

INSERT INTO project(name, start_date, projected_end_date, number_of_employees, completed)
VALUES ('Photography Book', '02/13/2021', '02/13/2022', 2, 'false'), ('PROMO video for Photography Book', '02/20/2021', '12/01/2021', 2, 'false'),
        ('New Hire - sales', '10/01/2019', '01/01/2020', 2, 'true'), ('Open Market- Louisville', '07/01/2018', '12/31/2018', 1, 'true');
        
        
INSERT INTO employee(last_name, first_name, job_title, date_of_birth, date_of_hire,dept_id, gender)
VALUES ('Spangler', 'Jacyln', 'Sales Director', '02/10/1991', '01/01/2017', 2, 'female'),
        ('Biggs', 'Trevor', 'Photography Director', '08/28/1994', '07/06/2017', 1, 'male'),
        ('Gerle', 'Ryan', 'Videography Director', '06/26/1986', '11/19/2017', 1, 'non-binary'),
        ('Ulrich', 'Ian', 'Sales Associate', '03/21/1981', '04/01/2019', 2, 'male'),
        ('Stewart', 'Madelyn', 'Human Resource Director', '09/28/1987', '01/01/2017', 3, 'female'),
        ('Hesser', 'Whit', 'Human Resource Assistant', '02/18/1996', '04/01/2019', 3, 'prefer not to answer'),
        ('Barrett', 'Colin', 'Media Associate', '09/22/1991', '05/17/2019', 1, 'male'),
        ('Belle', 'Jessie', 'Sales Associate', '08/31/1995', '12/01/2020', 2, 'female');
        
        
INSERT INTO employee_project(employee_id, project_id)
VALUES (1, 1), (2, 1), (7, 1),
        (3,2), (3,2),
        (5,3), (6,3),
        (1,4), (4,4);
        
        
        
        
        