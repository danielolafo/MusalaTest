CREATE TABLE Drone(
id NUMBER NOT NULL,
serial_number VARCHAR(100),
model VARCHAR2(50),
weight_ NUMBER,
battery_percentage NUMBER,
state_ VARCHAR2(50)
);

CREATE TABLE Medicine(
id NUMBER NOT NULL,
name_ VARCHAR2(50),
weight_ NUMBER,
code VARCHAR2(50),
image_ BLOB
);

INSERT INTO Drone (id, serial_number, model, weight_, battery_percentage, state_) VALUES(1,'','',500,10,'');
INSERT INTO Drone (id, serial_number, model, weight_, battery_percentage, state_) VALUES(2,'','',500,10,'');
INSERT INTO Drone (id, serial_number, model, weight_, battery_percentage, state_) VALUES(3,'','',500,10,'');
INSERT INTO Drone (id, serial_number, model, weight_, battery_percentage, state_) VALUES(4,'','',500,10,'');
INSERT INTO Drone (id, serial_number, model, weight_, battery_percentage, state_) VALUES(5,'','',500,10,'');
INSERT INTO Drone (id, serial_number, model, weight_, battery_percentage, state_) VALUES(6,'','',500,10,'');
INSERT INTO Drone (id, serial_number, model, weight_, battery_percentage, state_) VALUES(7,'','',500,10,'');
INSERT INTO Drone (id, serial_number, model, weight_, battery_percentage, state_) VALUES(8,'','',500,10,'');
INSERT INTO Drone (id, serial_number, model, weight_, battery_percentage, state_) VALUES(9,'','',500,10,'');
INSERT INTO Drone (id, serial_number, model, weight_, battery_percentage, state_) VALUES(10,'','',500,10,'');

INSERT INTO Medicine (id, name_, weight_, code, image_) VALUES(1,'',5,'',NULL);
INSERT INTO Medicine (id, name_, weight_, code, image_) VALUES(2,'',5,'',NULL);
INSERT INTO Medicine (id, name_, weight_, code, image_) VALUES(3,'',5,'',NULL);
INSERT INTO Medicine (id, name_, weight_, code, image_) VALUES(4,'',5,'',NULL);
INSERT INTO Medicine (id, name_, weight_, code, image_) VALUES(5,'',5,'',NULL);
INSERT INTO Medicine (id, name_, weight_, code, image_) VALUES(6,'',5,'',NULL);
INSERT INTO Medicine (id, name_, weight_, code, image_) VALUES(7,'',5,'',NULL);
INSERT INTO Medicine (id, name_, weight_, code, image_) VALUES(8,'',5,'',NULL);
INSERT INTO Medicine (id, name_, weight_, code, image_) VALUES(9,'',5,'',NULL);