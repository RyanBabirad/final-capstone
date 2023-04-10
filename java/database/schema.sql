BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE landlord (
	landlord_id int,
	first_name varchar(20) NOT NULL,
	last_name varchar(20) NOT NULL,
	email varchar(50) NOT NULL,
	phone varchar(12) NOT NULL,
	user_id int,
	CONSTRAINT pk_landlord PRIMARY KEY (landlord_id),
	CONSTRAINT fk_users_landlord FOREIGN KEY (user_id) REFERENCES users (user_id)

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

CREATE TABLE maintenence_requests (
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
	assignment_id SERIAL PRIMARY KEY,
	request_id int,
	is_assigned boolean DEFAULT false,
	date_assigned date,
	property_id int,
	CONSTRAINT fk_main_req_assignments FOREIGN KEY (request_id) REFERENCES maintenence_requests (request_id),
	CONSTRAINT fk_property_assignments FOREIGN KEY (property_id) REFERENCES property (property_id)
);

CREATE TABLE staff_assignment (
	staff_id int,
	assignment_id int,
	CONSTRAINT fk_staff_staffassignment FOREIGN KEY (staff_id) REFERENCES staff (staff_id),
	CONSTRAINT fk_staffassignments_assignment FOREIGN KEY (assignment_id) REFERENCES assignments (assignment_id),
	CONSTRAINT pk_staff_staffassignment PRIMARY KEY (staff_id, assignment_id)
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

SELECT * FROM users
JOIN landlord on landlord.landlord_id = users.user_id;
SELECT * FROM landlord;
SELECT * FROM property;
SELECT * FROM tenant
JOIN users on tenant.tenant_id = users.user_id;
SELECT * FROM staff
JOIN users on staff.staff_id = users.user_id;
SELECT * FROM maintenence_requests;
SELECT * FROM assignments;
SELECT * FROM staff_assignment;
SELECT * FROM rent;








ROLLBACK;



