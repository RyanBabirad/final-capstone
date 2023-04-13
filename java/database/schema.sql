BEGIN TRANSACTION;

DROP TABLE IF EXISTS rent;
DROP TABLE IF EXISTS staff_assignments;
DROP TABLE IF EXISTS assignments;
DROP TABLE IF EXISTS maintenence_request;
DROP TABLE IF EXISTS staff;
DROP TABLE IF EXISTS tenant;
DROP TABLE IF EXISTS property;
DROP TABLE IF EXISTS landlord;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

GRANT ALL
ON ALL TABLES IN SCHEMA public
TO final_capstone_owner;

GRANT ALL
ON ALL SEQUENCES IN SCHEMA public
TO final_capstone_owner;

GRANT SELECT, INSERT, UPDATE, DELETE
ON ALL TABLES IN SCHEMA public
TO final_capstone_appuser;

GRANT USAGE, SELECT
ON ALL SEQUENCES IN SCHEMA public
TO final_capstone_appuser;

CREATE TABLE landlord (
	landlord_id int,
	first_name varchar(20) NOT NULL,
	last_name varchar(20) NOT NULL,
	email varchar(50) NOT NULL,
	phone varchar(12) NOT NULL,
	--user_id int,
	CONSTRAINT pk_landlord PRIMARY KEY (landlord_id),
	CONSTRAINT fk_users_landlord FOREIGN KEY (landlord_id) REFERENCES users (user_id)

);

CREATE TABLE property (
	property_id SERIAL,
	imgSrc varchar,
	streetAddress varchar NOT NULL,
	zipcode int NOT NULL,
	state varchar(2) NOT NULL,
	unit varchar NOT NULL,
	landlord_id int,
	CONSTRAINT PK_property PRIMARY KEY (property_id),
	CONSTRAINT fk_property_landlord FOREIGN KEY (landlord_id) REFERENCES landlord (landlord_id)
	
);

CREATE TABLE tenant (
	tenant_id int,
	first_name varchar(20) NOT NULL,
	last_name varchar(20) NOT NULL,
	email varchar(50) NOT NULL,
	phone varchar(12) NOT NULL,
	property_id int,
	landlord_id int,
	CONSTRAINT user_id PRIMARY KEY(tenant_id),
	CONSTRAINT fk_property_tenant FOREIGN KEY (property_id) REFERENCES property (property_id),
	CONSTRAINT fk_landlord_tenant FOREIGN KEY (landlord_id) REFERENCES landlord (landlord_id)
	--CONSTRAINT fk_users_tenant FOREIGN KEY (user_id) REFERENCES users (user_id)
);

CREATE TABLE staff (
	staff_id int,
	first_name varchar(20) NOT NULL,
	last_name varchar(20) NOT NULL,
	email varchar(50) NOT NULL,
	phone varchar(12) NOT NULL,
	landlord_id int,
	CONSTRAINT pk_staff PRIMARY KEY (staff_id),
	CONSTRAINT fk_landlord_staff FOREIGN KEY (landlord_id) REFERENCES landlord (landlord_id)
	--CONSTRAINT fk_users_staff FOREIGN KEY (user_id) REFERENCES users (user_id)
);

CREATE TABLE maintenence_request (
	request_id SERIAL,
	status boolean DEFAULT false,
	date_requested date,
	description varchar(350),
	tenant_id int,
	property_id int,
	CONSTRAINT pk_main_req PRIMARY KEY (request_id),
	CONSTRAINT fk_tenant_main_req FOREIGN KEY (tenant_id) REFERENCES tenant (tenant_id),
	CONSTRAINT fk_property_main_req FOREIGN KEY (property_id) REFERENCES property (property_id)
);

CREATE TABLE assignments (
	assignments_id SERIAL PRIMARY KEY,
	request_id int,
	is_assigned boolean DEFAULT false,
	date_assigned date,
	property_id int,
	CONSTRAINT fk_main_req_assignments FOREIGN KEY (request_id) REFERENCES maintenence_request (request_id),
	CONSTRAINT fk_property_assignments FOREIGN KEY (property_id) REFERENCES property (property_id)
);

CREATE TABLE staff_assignments (
	staff_id int,
	assignments_id int,
	CONSTRAINT fk_staff_staffassignments FOREIGN KEY (staff_id) REFERENCES staff (staff_id),
	CONSTRAINT fk_staffassignments_assignments FOREIGN KEY (assignments_id) REFERENCES assignments (assignments_id),
	CONSTRAINT pk_staff_staffassignments PRIMARY KEY (staff_id, assignments_id)
);

CREATE TABLE rent (
	rent_id SERIAL PRIMARY KEY,
	due_date date,
	paid_date date,
	payment_status int,
	amount_paid bigint,
	amount_due bigint,
	property_id int,
	tenant_id int,
	landlord_id int,
	CONSTRAINT fk_property_rent FOREIGN KEY (property_id) REFERENCES property (property_id),
	CONSTRAINT fk_tenant_rent FOREIGN KEY (tenant_id) REFERENCES tenant (tenant_id),
	CONSTRAINT fk_landlord_rent FOREIGN KEY (landlord_id) REFERENCES landlord (landlord_id)

);
/*
SELECT * FROM users
JOIN landlord on users.user_id = landlord.landlord_id;
WHERE user_id = '3';
SELECT * FROM landlord;
SELECT * FROM property;
SELECT * FROM tenant
JOIN users on tenant.tenant_id = users.user_id;
SELECT * FROM staff
JOIN users on staff.staff_id = users.user_id;
SELECT * FROM maintenence_request;
SELECT * FROM assignments;
SELECT * FROM staff_assignments;
SELECT * FROM rent;
SELECT * FROM landlord
JOIN users on landlord.landlord_id = users.user_id;
*/

--commit;


INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');



-- INSERT into landlord (first_name, last_name, email, phone, user_id) VALUES ('Ryan', 'Babs', 'test@test.com', '4126168642', '3') RETURNING landlord_id;
-- INSERT into landlord (landlord_id, first_name, last_name, email, phone) VALUES ((select user_id from users where user_id = '3'), 'Colin', 'Baker', 'test@test.com', '4126168642'); --RETURNING landlord_id;


INSERT into landlord (landlord_id, first_name, last_name, email, phone) VALUES ((SELECT user_id from users where user_id = 4), 'Ryan', 'Babs', 'test@test.com', '4124124123'); --RETURNING landlord_id;


INSERT into landlord (landlord_id, first_name, last_name, email, phone) VALUES (DEFAULT, 'Ryan', 'Babs', 'test@test.com', '4124124123');






--ROLLBACK;



CREATE USER final_capstone_owner
WITH PASSWORD 'finalcapstone';

GRANT ALL
ON ALL TABLES IN SCHEMA public
TO final_capstone_owner;

GRANT ALL
ON ALL SEQUENCES IN SCHEMA public
TO final_capstone_owner;

CREATE USER final_capstone_appuser
WITH PASSWORD 'finalcapstone';

GRANT SELECT, INSERT, UPDATE, DELETE
ON ALL TABLES IN SCHEMA public
TO final_capstone_appuser;

GRANT USAGE, SELECT
ON ALL SEQUENCES IN SCHEMA public
TO final_capstone_appuser;









