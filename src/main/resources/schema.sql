DROP TABLE IF EXISTS Drone;
DROP TABLE IF EXISTS Medicine;
DROP TABLE IF EXISTS Drone_Charge;
DROP TABLE IF EXISTS Drone_Flight;
DROP SEQUENCE IF EXISTS SEQ_DRONE;
DROP SEQUENCE IF EXISTS SEQ_DRONE_FLIGHT;
DROP SEQUENCE IF EXISTS SEQ_MEDICINE;
DROP SEQUENCE IF EXISTS SEQ_DRONE_CHARGE;


CREATE TABLE Drone(
id NUMERIC AUTO_INCREMENT NOT NULL PRIMARY KEY,
serial_number VARCHAR(100),
model VARCHAR2(50), 
weight_limit NUMERIC(5,2) NOT NULL ,
battery_percentage NUMERIC(5,2),
state VARCHAR2(50) NOT NULL 
);

ALTER TABLE Drone ADD CONSTRAINT CHK_MODEL CHECK model IN('Lightweight', 'Middleweight', 'Cruiserweight', 'Heavyweight');
ALTER TABLE Drone ADD CONSTRAINT CHK_WEIGHT_LIMIT CHECK  (weight_limit <= 500);
ALTER TABLE Drone ADD CONSTRAINT CHK_STATE CHECK state IN ('IDLE', 'LOADING', 'LOADED', 'DELIVERING', 'DELIVERED', 'RETURNING');

CREATE SEQUENCE SEQ_DRONE START WITH 1 INCREMENT BY 1 NO CYCLE CACHE 10;

CREATE TABLE Medicine(
id NUMERIC AUTO_INCREMENT NOT NULL PRIMARY KEY,
name VARCHAR2(50),
weight NUMERIC(5,2),
code VARCHAR2(50),
image BLOB
);

CREATE SEQUENCE SEQ_MEDICINE START WITH 1 INCREMENT BY 1 NO CYCLE CACHE 10;

CREATE TABLE Drone_Flight(
    id NUMERIC AUTO_INCREMENT NOT NULL PRIMARY KEY,
    dispatched_date DATE NOT NULL,
    arrival_date DATE,
    origin VARCHAR2(100) NOT NULL,
    target VARCHAR2(100) NOT NULL,
    observations VARCHAR2(1000),
    drone_id NUMBER NOT NULL
);

ALTER TABLE Drone_Flight ADD FOREIGN KEY (drone_id) REFERENCES Drone(id);

CREATE SEQUENCE SEQ_DRONE_FLIGHT START WITH 1 INCREMENT BY 1 NO CYCLE CACHE 10;

CREATE TABLE Drone_Charge(
    id NUMERIC AUTO_INCREMENT NOT NULL PRIMARY KEY,
    drone_flight_id NUMERIC NOT NULL,
    medicine_id NUMERIC NOT NULL,
    dispatched_amount NUMERIC(5,2) NOT NULL
);

ALTER TABLE Drone_Charge ADD FOREIGN KEY (drone_flight_id) REFERENCES Drone_Flight(id);
ALTER TABLE Drone_Charge ADD FOREIGN KEY (medicine_id) REFERENCES Medicine(id);

CREATE SEQUENCE SEQ_DRONE_CHARGE START WITH 1 INCREMENT BY 1 NO CYCLE CACHE 10;

INSERT INTO Drone (id, serial_number, model, weight_limit, battery_percentage, state) VALUES(NEXTVAL('SEQ_DRONE'),'66570283306607025893','Lightweight',100,90,'IDLE');
INSERT INTO Drone (id, serial_number, model, weight_limit, battery_percentage, state) VALUES(NEXTVAL('SEQ_DRONE'),'43063547685056829291','Lightweight',100,80,'IDLE');
INSERT INTO Drone (id, serial_number, model, weight_limit, battery_percentage, state) VALUES(NEXTVAL('SEQ_DRONE'),'26974719634014860409','Lightweight',100,70,'IDLE');
INSERT INTO Drone (id, serial_number, model, weight_limit, battery_percentage, state) VALUES(NEXTVAL('SEQ_DRONE'),'78678989894302803602','Middleweight',200,60,'IDLE');
INSERT INTO Drone (id, serial_number, model, weight_limit, battery_percentage, state) VALUES(NEXTVAL('SEQ_DRONE'),'26579457740835037286','Middleweight',200,50,'LOADING');
INSERT INTO Drone (id, serial_number, model, weight_limit, battery_percentage, state) VALUES(NEXTVAL('SEQ_DRONE'),'78363702506500056353','Cruiserweight',400,40,'IDLE');
INSERT INTO Drone (id, serial_number, model, weight_limit, battery_percentage, state) VALUES(NEXTVAL('SEQ_DRONE'),'58547062748474092891','Cruiserweight',400,30,'IDLE');
INSERT INTO Drone (id, serial_number, model, weight_limit, battery_percentage, state) VALUES(NEXTVAL('SEQ_DRONE'),'30422890613774162807','Cruiserweight',400,25,'IDLE');
INSERT INTO Drone (id, serial_number, model, weight_limit, battery_percentage, state) VALUES(NEXTVAL('SEQ_DRONE'),'58838877457101801928','Cruiserweight',400,20,'IDLE');
INSERT INTO Drone (id, serial_number, model, weight_limit, battery_percentage, state) VALUES(NEXTVAL('SEQ_DRONE'),'50590487560737392315','Heavyweight',500,10,'IDLE');

INSERT INTO Medicine (id, name, weight, code, image) VALUES(NEXTVAL('SEQ_MEDICINE'),'Omeprazol_10',5,'',NULL);
INSERT INTO Medicine (id, name, weight, code, image) VALUES(NEXTVAL('SEQ_MEDICINE'),'Lansoprazol-10',5,'',NULL);
INSERT INTO Medicine (id, name, weight, code, image) VALUES(NEXTVAL('SEQ_MEDICINE'),'Ibuprofeno',5,'',NULL);
INSERT INTO Medicine (id, name, weight, code, image) VALUES(NEXTVAL('SEQ_MEDICINE'),'_Penicilina',5,'',NULL);
INSERT INTO Medicine (id, name, weight, code, image) VALUES(NEXTVAL('SEQ_MEDICINE'),'-Acetaminofen',5,'',NULL);
INSERT INTO Medicine (id, name, weight, code, image) VALUES(NEXTVAL('SEQ_MEDICINE'),'-Ranitidina-200',5,'',NULL);
INSERT INTO Medicine (id, name, weight, code, image) VALUES(NEXTVAL('SEQ_MEDICINE'),'_-Dolex-_900',5,'',NULL);
INSERT INTO Medicine (id, name, weight, code, image) VALUES(NEXTVAL('SEQ_MEDICINE'),'Arotvastatina',5,'',NULL);
INSERT INTO Medicine (id, name, weight, code, image) VALUES(NEXTVAL('SEQ_MEDICINE'),'Lovastatina',5,'',NULL);
INSERT INTO Medicine (id, name, weight, code, image) VALUES(NEXTVAL('SEQ_MEDICINE'),'Salbutamol',5,'',NULL);

INSERT INTO Drone_Flight (id,dispatched_date,arrival_date,origin,target,observations,drone_id) VALUES(NEXTVAL('SEQ_DRONE_FLIGHT'),'2022-01-20','2022-02-17','Street 123','London Avenue',NULL,1);
INSERT INTO Drone_Flight (id,dispatched_date,arrival_date,origin,target,observations,drone_id) VALUES(NEXTVAL('SEQ_DRONE_FLIGHT'),'2022-01-20','2022-02-17','Street 45','Street 26',NULL,1);
INSERT INTO Drone_Flight (id,dispatched_date,arrival_date,origin,target,observations,drone_id) VALUES(NEXTVAL('SEQ_DRONE_FLIGHT'),'2022-01-20',NULL,'Street 99','Street 66',NULL,1);
INSERT INTO Drone_Flight (id,dispatched_date,arrival_date,origin,target,observations,drone_id) VALUES(NEXTVAL('SEQ_DRONE_FLIGHT'),'2022-01-20','2022-02-17','Street 76','Street 1',NULL,1);
INSERT INTO Drone_Flight (id,dispatched_date,arrival_date,origin,target,observations,drone_id) VALUES(NEXTVAL('SEQ_DRONE_FLIGHT'),'2022-01-20','2022-02-17','Street 1','Street 89',NULL,2);
INSERT INTO Drone_Flight (id,dispatched_date,arrival_date,origin,target,observations,drone_id) VALUES(NEXTVAL('SEQ_DRONE_FLIGHT'),'2022-01-20',NULL,'Park Avenue','Street 585',NULL,2);
INSERT INTO Drone_Flight (id,dispatched_date,arrival_date,origin,target,observations,drone_id) VALUES(NEXTVAL('SEQ_DRONE_FLIGHT'),'2022-01-20','2022-02-17','Street 66','Park Avenue',NULL,2);
INSERT INTO Drone_Flight (id,dispatched_date,arrival_date,origin,target,observations,drone_id) VALUES(NEXTVAL('SEQ_DRONE_FLIGHT'),'2022-01-20',NULL,'Street 12','Street 55',NULL,3);
INSERT INTO Drone_Flight (id,dispatched_date,arrival_date,origin,target,observations,drone_id) VALUES(NEXTVAL('SEQ_DRONE_FLIGHT'),'2022-01-20','2023-02-22','Street 48','Street 67',NULL,3);
INSERT INTO Drone_Flight (id,dispatched_date,arrival_date,origin,target,observations,drone_id) VALUES(NEXTVAL('SEQ_DRONE_FLIGHT'),'2022-01-20','2022-02-17','Berlin St.','Rome square',NULL,4);
INSERT INTO Drone_Flight (id,dispatched_date,arrival_date,origin,target,observations,drone_id) VALUES(NEXTVAL('SEQ_DRONE_FLIGHT'),'2022-01-20','2022-02-17','St. 5','St. 88',NULL,4);

INSERT INTO Drone_Charge(id, drone_flight_id,medicine_id,dispatched_amount) VALUES(NEXTVAL('SEQ_DRONE_CHARGE'),3,3,50.0);
INSERT INTO Drone_Charge(id, drone_flight_id,medicine_id,dispatched_amount) VALUES(NEXTVAL('SEQ_DRONE_CHARGE'),3,3,10.0);
INSERT INTO Drone_Charge(id, drone_flight_id,medicine_id,dispatched_amount) VALUES(NEXTVAL('SEQ_DRONE_CHARGE'),3,4,11.0);
INSERT INTO Drone_Charge(id, drone_flight_id,medicine_id,dispatched_amount) VALUES(NEXTVAL('SEQ_DRONE_CHARGE'),3,5,14.0);
INSERT INTO Drone_Charge(id, drone_flight_id,medicine_id,dispatched_amount) VALUES(NEXTVAL('SEQ_DRONE_CHARGE'),4,6,24.0);
INSERT INTO Drone_Charge(id, drone_flight_id,medicine_id,dispatched_amount) VALUES(NEXTVAL('SEQ_DRONE_CHARGE'),4,7,1.0);
INSERT INTO Drone_Charge(id, drone_flight_id,medicine_id,dispatched_amount) VALUES(NEXTVAL('SEQ_DRONE_CHARGE'),6,8,82.0);
INSERT INTO Drone_Charge(id, drone_flight_id,medicine_id,dispatched_amount) VALUES(NEXTVAL('SEQ_DRONE_CHARGE'),7,4,300.0);
INSERT INTO Drone_Charge(id, drone_flight_id,medicine_id,dispatched_amount) VALUES(NEXTVAL('SEQ_DRONE_CHARGE'),7,5,20.0);
INSERT INTO Drone_Charge(id, drone_flight_id,medicine_id,dispatched_amount) VALUES(NEXTVAL('SEQ_DRONE_CHARGE'),7,6,40.0);
INSERT INTO Drone_Charge(id, drone_flight_id,medicine_id,dispatched_amount) VALUES(NEXTVAL('SEQ_DRONE_CHARGE'),9,7,31.0);
INSERT INTO Drone_Charge(id, drone_flight_id,medicine_id,dispatched_amount) VALUES(NEXTVAL('SEQ_DRONE_CHARGE'),9,8,90.0);
INSERT INTO Drone_Charge(id, drone_flight_id,medicine_id,dispatched_amount) VALUES(NEXTVAL('SEQ_DRONE_CHARGE'),10,5,22.0);
INSERT INTO Drone_Charge(id, drone_flight_id,medicine_id,dispatched_amount) VALUES(NEXTVAL('SEQ_DRONE_CHARGE'),10,6,66.0);