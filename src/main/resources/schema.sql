DROP TABLE IF EXISTS Drone;
DROP TABLE IF EXISTS Medicine;
DROP TABLE IF EXISTS DroneCharge;
DROP TABLE IF EXISTS DroneFlight;


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

CREATE TABLE Medicine(
id NUMERIC NOT NULL PRIMARY KEY,
name VARCHAR2(50),
weight NUMERIC(3,2),
code VARCHAR2(50),
image BLOB
);

CREATE TABLE DroneFlight(
    id NUMERIC NOT NULL PRIMARY KEY,
    dispatched_date DATE NOT NULL,
    arrival_date DATE,
    origin VARCHAR2(100) NOT NULL,
    target VARCHAR2(100) NOT NULL,
    observations VARCHAR2(1000),
    drone_id NUMBER NOT NULL
);

ALTER TABLE DroneFlight ADD FOREIGN KEY (drone_id) REFERENCES Drone(id);


CREATE TABLE DroneCharge(
    id NUMERIC NOT NULL PRIMARY KEY,
    drone_flight_id NUMERIC NOT NULL,
    medicine_id NUMERIC NOT NULL,
    dispatched_amount NUMERIC(5,2) NOT NULL
);

ALTER TABLE DroneCharge ADD FOREIGN KEY (drone_flight_id) REFERENCES DroneFlight(id);
ALTER TABLE DroneCharge ADD FOREIGN KEY (medicine_id) REFERENCES Medicine(id);


INSERT INTO Drone (id, serial_number, model, weight_limit, battery_percentage, state) VALUES(1,'66570283306607025893','Lightweight',100,90,'IDLE');
INSERT INTO Drone (id, serial_number, model, weight_limit, battery_percentage, state) VALUES(2,'43063547685056829291','Lightweight',100,80,'IDLE');
INSERT INTO Drone (id, serial_number, model, weight_limit, battery_percentage, state) VALUES(3,'26974719634014860409','Lightweight',100,70,'IDLE');
INSERT INTO Drone (id, serial_number, model, weight_limit, battery_percentage, state) VALUES(4,'78678989894302803602','Middleweight',200,60,'IDLE');
INSERT INTO Drone (id, serial_number, model, weight_limit, battery_percentage, state) VALUES(5,'26579457740835037286','Middleweight',200,50,'IDLE');
INSERT INTO Drone (id, serial_number, model, weight_limit, battery_percentage, state) VALUES(6,'78363702506500056353','Cruiserweight',400,40,'IDLE');
INSERT INTO Drone (id, serial_number, model, weight_limit, battery_percentage, state) VALUES(7,'58547062748474092891','Cruiserweight',400,30,'IDLE');
INSERT INTO Drone (id, serial_number, model, weight_limit, battery_percentage, state) VALUES(8,'30422890613774162807','Cruiserweight',400,25,'IDLE');
INSERT INTO Drone (id, serial_number, model, weight_limit, battery_percentage, state) VALUES(9,'58838877457101801928','Cruiserweight',400,20,'IDLE');
INSERT INTO Drone (id, serial_number, model, weight_limit, battery_percentage, state) VALUES(10,'50590487560737392315','Heavyweight',500,10,'IDLE');

INSERT INTO Medicine (id, name, weight, code, image) VALUES(1,'Omeprazol_10',5,'',NULL);
INSERT INTO Medicine (id, name, weight, code, image) VALUES(2,'Lansoprazol-10',5,'',NULL);
INSERT INTO Medicine (id, name, weight, code, image) VALUES(3,'Ibuprofeno',5,'',NULL);
INSERT INTO Medicine (id, name, weight, code, image) VALUES(4,'_Penicilina',5,'',NULL);
INSERT INTO Medicine (id, name, weight, code, image) VALUES(5,'-Acetaminofen',5,'',NULL);
INSERT INTO Medicine (id, name, weight, code, image) VALUES(6,'-Ranitidina-200',5,'',NULL);
INSERT INTO Medicine (id, name, weight, code, image) VALUES(7,'_-Dolex-_900',5,'',NULL);
INSERT INTO Medicine (id, name, weight, code, image) VALUES(8,'Arotvastatina',5,'',NULL);
INSERT INTO Medicine (id, name, weight, code, image) VALUES(9,'Lovastatina',5,'',NULL);
INSERT INTO Medicine (id, name, weight, code, image) VALUES(10,'Salbutamol',5,'',NULL);

INSERT INTO DroneFlight (id,dispatched_date,arrival_date,origin,target,observations,drone_id) VALUES(1,'2022-01-20','2022-02-17','','',NULL,1);
INSERT INTO DroneFlight (id,dispatched_date,arrival_date,origin,target,observations,drone_id) VALUES(2,'2022-01-20','2022-02-17','','',NULL,1);
INSERT INTO DroneFlight (id,dispatched_date,arrival_date,origin,target,observations,drone_id) VALUES(3,'2022-01-20',NULL,'','',NULL,1);
INSERT INTO DroneFlight (id,dispatched_date,arrival_date,origin,target,observations,drone_id) VALUES(4,'2022-01-20','2022-02-17','','',NULL,1);
INSERT INTO DroneFlight (id,dispatched_date,arrival_date,origin,target,observations,drone_id) VALUES(5,'2022-01-20','2022-02-17','','',NULL,2);
INSERT INTO DroneFlight (id,dispatched_date,arrival_date,origin,target,observations,drone_id) VALUES(6,'2022-01-20',NULL,'','',NULL,2);
INSERT INTO DroneFlight (id,dispatched_date,arrival_date,origin,target,observations,drone_id) VALUES(7,'2022-01-20','2022-02-17','','',NULL,2);
INSERT INTO DroneFlight (id,dispatched_date,arrival_date,origin,target,observations,drone_id) VALUES(8,'2022-01-20',NULL,'','',NULL,3);
INSERT INTO DroneFlight (id,dispatched_date,arrival_date,origin,target,observations,drone_id) VALUES(9,'2022-01-20',NULL,'','',NULL,3);
INSERT INTO DroneFlight (id,dispatched_date,arrival_date,origin,target,observations,drone_id) VALUES(10,'2022-01-20','2022-02-17','','',NULL,4);
INSERT INTO DroneFlight (id,dispatched_date,arrival_date,origin,target,observations,drone_id) VALUES(11,'2022-01-20','2022-02-17','','',NULL,4);

INSERT INTO DroneCharge(id, drone_flight_id,medicine_id,dispatched_amount) VALUES(1,3,3,50.0);
INSERT INTO DroneCharge(id, drone_flight_id,medicine_id,dispatched_amount) VALUES(2,3,3,10.0);
INSERT INTO DroneCharge(id, drone_flight_id,medicine_id,dispatched_amount) VALUES(3,3,4,11.0);
INSERT INTO DroneCharge(id, drone_flight_id,medicine_id,dispatched_amount) VALUES(4,3,5,14.0);
INSERT INTO DroneCharge(id, drone_flight_id,medicine_id,dispatched_amount) VALUES(5,4,6,24.0);
INSERT INTO DroneCharge(id, drone_flight_id,medicine_id,dispatched_amount) VALUES(6,4,7,1.0);
INSERT INTO DroneCharge(id, drone_flight_id,medicine_id,dispatched_amount) VALUES(7,6,8,82.0);
INSERT INTO DroneCharge(id, drone_flight_id,medicine_id,dispatched_amount) VALUES(8,7,4,300.0);
INSERT INTO DroneCharge(id, drone_flight_id,medicine_id,dispatched_amount) VALUES(9,7,5,20.0);
INSERT INTO DroneCharge(id, drone_flight_id,medicine_id,dispatched_amount) VALUES(10,7,6,40.0);
INSERT INTO DroneCharge(id, drone_flight_id,medicine_id,dispatched_amount) VALUES(11,9,7,31.0);
INSERT INTO DroneCharge(id, drone_flight_id,medicine_id,dispatched_amount) VALUES(12,9,8,90.0);
INSERT INTO DroneCharge(id, drone_flight_id,medicine_id,dispatched_amount) VALUES(13,10,5,22.0);
INSERT INTO DroneCharge(id, drone_flight_id,medicine_id,dispatched_amount) VALUES(14,10,6,66.0);