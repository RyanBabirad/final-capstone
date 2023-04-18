BEGIN TRANSACTION;

DROP TABLE IF EXISTS rent;
DROP TABLE IF EXISTS staff_assignments;
DROP TABLE IF EXISTS assignments;
DROP TABLE IF EXISTS maintenence_request;
DROP TABLE IF EXISTS maintenance_request;
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
	email varchar(50) NOT NULL UNIQUE,
	phone varchar(12) NOT NULL,
	--user_id int,
	CONSTRAINT pk_landlord PRIMARY KEY (landlord_id),
	CONSTRAINT fk_users_landlord FOREIGN KEY (landlord_id) REFERENCES users (user_id)

);

CREATE TABLE property (
	property_id SERIAL,
	imgSrc varchar NOT NULL,
	streetAddress varchar NOT NULL,
	zipcode int NOT NULL,
	state varchar(2) NOT NULL,
	unit varchar,
	description varchar,
	landlord_id int,
	CONSTRAINT PK_property PRIMARY KEY (property_id),
	CONSTRAINT fk_property_landlord FOREIGN KEY (landlord_id) REFERENCES landlord (landlord_id)
	
);

CREATE TABLE tenant (
	tenant_id int,
	first_name varchar(20) NOT NULL,
	last_name varchar(20) NOT NULL,
	email varchar(50) NOT NULL UNIQUE,
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
	email varchar(50) NOT NULL UNIQUE,
	phone varchar(12) NOT NULL,
	landlord_id int,
	CONSTRAINT pk_staff PRIMARY KEY (staff_id),
	CONSTRAINT fk_landlord_staff FOREIGN KEY (landlord_id) REFERENCES landlord (landlord_id)
	--CONSTRAINT fk_users_staff FOREIGN KEY (user_id) REFERENCES users (user_id)
);

CREATE TABLE maintenance_request (
	request_id SERIAL,
	status boolean DEFAULT false,
	date_requested varchar,
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
	date_assigned varchar,
	property_id int,
	CONSTRAINT fk_main_req_assignments FOREIGN KEY (request_id) REFERENCES maintenance_request (request_id),
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
	due_date varchar(10),
	paid_date varchar(10),
	payment_status int,  -- 0 for due, 1 for paid, 2 for overdue
	amount_paid decimal(10, 2),
	amount_due decimal(10, 2),
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
SELECT * FROM maintenance_request;
SELECT * FROM assignments;
SELECT * FROM staff_assignments;
SELECT * FROM rent;
SELECT * FROM landlord
JOIN users on landlord.landlord_id = users.user_id;
SELECT * from landlord
JOIN property on landlord.landlord_id = property.landlord_id;
SELECT * from property
JOIN landlord on property.landlord_id = landlord.landlord_id
JOIN users on landlord.landlord_id = users.user_id
WHERE username = 'LandlordTwo';
*/





INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');	-- ID 1
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN'); -- ID 2

INSERT INTO users (username,password_hash,role) VALUES ('LandlordUserThree','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER'); -- ID 3
INSERT INTO users (username,password_hash,role) VALUES ('LandlordUserFour','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER'); -- ID 4
INSERT INTO users (username,password_hash,role) VALUES ('LandlordUserFive','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER'); -- ID 5
INSERT INTO users (username,password_hash,role) VALUES ('TenantUserSix','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER'); -- ID 6
INSERT INTO users (username,password_hash,role) VALUES ('TenantUserSeven','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER'); -- ID 7
INSERT INTO users (username,password_hash,role) VALUES ('TenantUserEight','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER'); -- ID 8
INSERT INTO users (username,password_hash,role) VALUES ('TenantUserNine','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER'); -- ID 9
INSERT INTO users (username,password_hash,role) VALUES ('TenantUserTen','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER'); -- ID 10
INSERT INTO users (username,password_hash,role) VALUES ('StaffUserEleven','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER'); -- ID 11
INSERT INTO users (username,password_hash,role) VALUES ('StaffUserTwelve','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER'); -- ID 12
INSERT INTO users (username,password_hash,role) VALUES ('StaffUserThirteen','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER'); -- ID 13



INSERT INTO landlord (landlord_id, first_name, last_name, email, phone) VALUES ('3', 'Fred', 'Johnson', 'fredjohnson@gmail.com', '7245167878');
INSERT INTO landlord (landlord_id, first_name, last_name, email, phone) VALUES ('4', 'Charles', 'Cobos', 'charlescobos@gmail.com', '8002005000');
INSERT INTO landlord (landlord_id, first_name, last_name, email, phone) VALUES ('5', 'Lawrence', 'Duarte', 'lawrencedu@hotmail.com', '9175302300');

INSERT INTO tenant (tenant_id, first_name, last_name, email, phone) VALUES ('6', 'Donald', 'Barry', 'donaldbarry@aol.com', '4126718990');
INSERT INTO tenant (tenant_id, first_name, last_name, email, phone) VALUES ('7', 'Paul', 'Ray', 'pauloray@gmail.com', '5167819020');
INSERT INTO tenant (tenant_id, first_name, last_name, email, phone) VALUES ('8', 'Michelle', 'Halter', 'michellehalter@verizon.net', '2314607801');
INSERT INTO tenant (tenant_id, first_name, last_name, email, phone) VALUES ('9', 'Jon', 'Toney', 'toneyjon@gmail.com', '5167809645');
INSERT INTO tenant (tenant_id, first_name, last_name, email, phone) VALUES ('10', 'Billy', 'Hudson', 'hudbillson@hotmail.com', '4302785454');



INSERT INTO property (imgsrc, streetaddress, zipcode, state, unit, description, landlord_id) 
VALUES ('propertyOne.jpg', '2357 White Lane', '31206', 'GA', 'B113', 'A REWARDING ESCAPE PEACEFULLY SITUATED: Luxurious and upgraded, this 4 bedroom, 4.5 bathroom home of 5,281 sq. ft. (including poolhouse, per independent third-party measurement) rests on a lot of 1.23 acres (per county) on a peaceful cul-de-sac in the Lakeside neighborhood. Richly-appointed spaces include large gathering areas, a bright, professional-grade kitchen, spectacular dining room, two walk-out master suites, and a home theater. Contemporary amenities include solar PV and a Tesla EV charging station. The expansive backyard includes a sparkling pool and spa plus a comfortable poolhouse all in private, verdant surroundings. You’ll appreciate the short drive to downtown Los Altos, Rancho Shopping Center, access to Interstate 280, and numerous parks and preserves.', '3');
INSERT INTO property (imgsrc, streetaddress, zipcode, state, unit, description, landlord_id) 
VALUES ('propertyTwo.jpg', '2856 Pick Street', '81611', 'CO', 'G27', 'Boasting an array of sleek finishes and a thoughtful open plan layout, this immaculate 1-bedroom, 1-bathroom condo is a paradigm of contemporary Brooklyn living. Features of this 531 sq. ft. home include wide plank engineered hardwood floors, huge Pella windows with western exposure, central heating and cooling, and a convenient washer/dryer hook-up. Beyond a functional entryway space the home flows into a luminous, open- concept living, dining, and kitchen area. The galley-style kitchen is equipped with white quartz countertops, a white tile backsplash, Nolte cabinets, and a suite of high-end stainless steel appliances from Samsung and Fisher & Paykel. The bedroom sits just off the living area and has a large reach-in closet. The bathroom has ceramic tile flooring, textured walls, and chic Kohler and Delta fixtures. The Hill is a brand new boutique condominium located in Ocean Hill. The building has an elevator, a bicycle room, private storage, and parking spaces. It is less than a block away from all the restaurants, shops, and grocery stores that line Rockaway Avenue, and is close to several parks and playgrounds. Nearby subway lines include the A/C/L/J. Pets are welcome.', '4');
INSERT INTO property (imgsrc, streetaddress, zipcode, state, unit, description, landlord_id) 
VALUES ('propertyThree.jpg', '4401 Prospect Street', '08102', 'NJ', 'A13', 'This 3 Bedroom W/ 2 Full Bathroom Ranch Home Is Immaculate & Full Of Upgrades! Enjoy The Open Floor Plan W/ Vaulted 15ft Ceilings & Large Windows Throughout. The Beautiful Kitchen Is The Heart Of The Home Complete With Large Customized Granite Island & Stainless Steel Appliances. Updated Lighting Throughout The Entire Home. Fully Updated Guest Bathroom And Laundry Room. This Floorplan Includes 2′ Extension On Every Side Increasing The Square Footage, Large Extended Patio For Entertaining Right Off The Dining Area. The Large Master Bedroom W/ Large Garden Tub, Double Sinks & Huge Walk-In Closet. Enjoy The Fully Fenced Backyard Perfect For Kids & Pets. The 2.5 Car Extended Garage Allows Room For Extra Storage Or Work Area.', '5');
INSERT INTO property (imgsrc, streetaddress, zipcode, state, unit, description, landlord_id) 
VALUES ('propertyFour.jpg', '1878 Bingamon Road', '44115', 'OH', 'C17', 'Stunning large late 80’s contemporary home with soaring ceilings and windows, split levels, great floor plan including open dining and living room. Located in the beautiful hilly and treed, desirable Windmill Hill section of Desoto you are conveniently located to shops, dining, and 20 minutes to downtown Dallas. This 3 bedroom, 3.1 bath home is large and accommodating to both guests for entertaining with 2 living areas, office, wet bar, with a Master suite located on the 1st floor. Great structure and bones and are waiting for new owners to bring their decorating ideas. Wonderful opportunity! 2020-08-11', '3');
INSERT INTO property (imgsrc, streetaddress, zipcode, state, unit, description, landlord_id) 
VALUES ('propertyFive.jpg', '2330 Little Acres Lane', '61602', 'IL', '18', 'Excellent little home superbly located right off Old Fredericksburg Road!! The original owner is selling this home that backs up to a GREEN BELT. 3 bedrooms, 2 baths, with a covered back patio. The home also features a water softener, refrigerator, clothes washer, and clothes dryer!!! The roof was replaced in 2019, garage floor was professionally epoxied in 2019, exterior got new paint in 2019, and there has NEVER been a fire in the wood burning fireplace!!!', '4');

UPDATE TENANT SET property_id = '1', landlord_id = '3' WHERE tenant_id = '6';
UPDATE TENANT SET property_id = '2', landlord_id = '4' WHERE tenant_id = '7';
UPDATE TENANT SET property_id = '3', landlord_id = '5' WHERE tenant_id = '8';
UPDATE TENANT SET property_id = '4', landlord_id = '3' WHERE tenant_id = '9';
UPDATE TENANT SET property_id = '5', landlord_id = '4' WHERE tenant_id = '10';

INSERT INTO staff (staff_id, first_name, last_name, email, phone) VALUES ('11', 'Charles', 'Koss', 'kosscharles@gmail.com', '2314657878');
INSERT INTO staff (staff_id, first_name, last_name, email, phone) VALUES ('12', 'Joyce', 'Long', 'joycelong@aol.com', '4128552335');
INSERT INTO staff (staff_id, first_name, last_name, email, phone) VALUES ('13', 'Randy', 'Smith', 'smithrandy@hotmail.com', '7244732421');


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






-- INSERT into property (imgSrc, streetAddress, zipCode, state, unit, landlord_id) VALUES ('testImg', '123 Test Ln', '15101', 'PA', '5B', (SELECT landlord_id from landlord where landlord_id = '3'));
-- SELECT landlord_id from landlord where email = 'test@test.com';

-- INSERT into property (imgSrc, streetAddress, zipCode, state, unit, landlord_id)
-- VALUES ('secondTestImg', '246 Testing Dr', '15101', 'PA', '6B', (SELECT landlord_id from landlord where email = 'test@test.com'));


commit;





SELECT * FROM landlord JOIN users ON (users.user_id = landlord.landlord_id);



