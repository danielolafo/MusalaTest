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
id NUMERIC NOT NULL,
name VARCHAR2(50),
weight NUMERIC(3,2),
code VARCHAR2(50),
image BLOB
);

CREATE TABLE DroneCharge(
    id NUMERIC NOT NULL,
    drone_id NUMERIC NOT NULL,
    medicine_id NUMERIC NOT NULL,
    dispatched_amount NUMERIC(3,2) NOT NULL
);

ALTER TABLE DroneCharge ADD FOREIGN KEY (drone_id) REFERENCES Drone(id);

CREATE TABLE DroneFlight(
    id NUMERIC NOT NULL,
    dispatched_date DATE NOT NULL,
    origin VARCHAR2(100) NOT NULL,
    target VARCHAR2(100) NOT NULL,
    observations VARCHAR2(1000)
);

INSERT INTO Drone (id, serial_number, model, weight_limit, battery_percentage, state) VALUES(1,'66570283306607025893','Lightweight',100,10,'IDLE');
INSERT INTO Drone (id, serial_number, model, weight_limit, battery_percentage, state) VALUES(2,'43063547685056829291','Lightweight',100,10,'IDLE');
INSERT INTO Drone (id, serial_number, model, weight_limit, battery_percentage, state) VALUES(3,'26974719634014860409','Lightweight',100,10,'IDLE');
INSERT INTO Drone (id, serial_number, model, weight_limit, battery_percentage, state) VALUES(4,'78678989894302803602','Middleweight',200,10,'IDLE');
INSERT INTO Drone (id, serial_number, model, weight_limit, battery_percentage, state) VALUES(5,'26579457740835037286','Middleweight',200,10,'IDLE');
INSERT INTO Drone (id, serial_number, model, weight_limit, battery_percentage, state) VALUES(6,'78363702506500056353','Cruiserweight',400,10,'IDLE');
INSERT INTO Drone (id, serial_number, model, weight_limit, battery_percentage, state) VALUES(7,'58547062748474092891','Cruiserweight',400,10,'IDLE');
INSERT INTO Drone (id, serial_number, model, weight_limit, battery_percentage, state) VALUES(8,'30422890613774162807','Cruiserweight',400,10,'IDLE');
INSERT INTO Drone (id, serial_number, model, weight_limit, battery_percentage, state) VALUES(9,'58838877457101801928','Cruiserweight',400,10,'IDLE');
INSERT INTO Drone (id, serial_number, model, weight_limit, battery_percentage, state) VALUES(10,'50590487560737392315','Heavyweight',500,10,'IDLE');

INSERT INTO Medicine (id, name, weight, code, image) VALUES(1,'',5,'',NULL);
INSERT INTO Medicine (id, name, weight, code, image) VALUES(2,'',5,'',NULL);
INSERT INTO Medicine (id, name, weight, code, image) VALUES(3,'',5,'',NULL);
INSERT INTO Medicine (id, name, weight, code, image) VALUES(4,'',5,'',NULL);
INSERT INTO Medicine (id, name, weight, code, image) VALUES(5,'',5,'',NULL);
INSERT INTO Medicine (id, name, weight, code, image) VALUES(6,'',5,'',NULL);
INSERT INTO Medicine (id, name, weight, code, image) VALUES(7,'',5,'',NULL);
INSERT INTO Medicine (id, name, weight, code, image) VALUES(8,'',5,'',NULL);
INSERT INTO Medicine (id, name, weight, code, image) VALUES(9,'',5,'',NULL);