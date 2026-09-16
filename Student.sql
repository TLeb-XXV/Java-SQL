CREATE TABLE StudentsInformation (
    studentID char(9) NOT NULL,
    firstName varchar (20) NOT NULL,
    lastName varchar (20) NOT NULL,
    address varchar (30) NOT NULL,
    city varchar(30) NOT NULL,
    province char(2) NOT NULL,
    postalCode char(6) NOT NULL,
    
    PRIMARY KEY (studentID)
);

INSERT INTO StudentsInformation VALUES
('301508347', 'Talia', 'Lebano', '10 Griselda Cresent', 'Scarborough','ON','M1G3P6');
commit;

INSERT INTO StudentsInformation VALUES
('300222333', 'Alex', 'Martin', '25 Main Street', 'Toronto', 'ON', 'M2A3B4');

INSERT INTO StudentsInformation VALUES
('300333444', 'Sarah', 'Brown', '15 King Street', 'Ottawa', 'ON', 'K1A2B3');

INSERT INTO StudentsInformation VALUES
('300444555', 'David', 'Lee', '80 Granville Street', 'Vancouver', 'BC', 'V5K2A1');

INSERT INTO StudentsInformation VALUES
('300555666', 'Emily', 'Wilson', '12 College Street', 'Toronto', 'ON', 'M3B4C5');

INSERT INTO StudentsInformation VALUES
('300666777', 'Michael', 'Tremblay', '45 Rue Saint-Paul', 'Montreal', 'QC', 'H2Y1Z1');

INSERT INTO StudentsInformation VALUES
('300777888', 'Jessica', 'MacDonald', '30 Barrington Street', 'Halifax', 'NS', 'B3J1Z1');

INSERT INTO StudentsInformation VALUES
('300888999', 'Daniel', 'Nguyen', '100 Portage Avenue', 'Winnipeg', 'MB', 'R3B2C3');

INSERT INTO StudentsInformation VALUES
('300999111', 'Sophie', 'Gagnon', '55 Jasper Avenue', 'Edmonton', 'AB', 'T5J1N7');

INSERT INTO StudentsInformation VALUES
('301111222', 'Ryan', 'Anderson', '70 Stephen Avenue', 'Calgary', 'AB', 'T2P2V1');

INSERT INTO StudentsInformation VALUES
('301222333', 'Emma', 'Carter', '20 Queen Street', 'Victoria', 'BC', 'V8W1P6');

INSERT INTO StudentsInformation VALUES
('301333444', 'Noah', 'Bouchard', '35 Elgin Street', 'Ottawa', 'ON', 'K2P1L4');

INSERT INTO StudentsInformation VALUES
('301444555', 'Olivia', 'Taylor', '90 Yonge Street', 'Toronto', 'ON', 'M5C2W1');

INSERT INTO StudentsInformation VALUES
('301555666', 'Lucas', 'Roy', '40 Rue Sainte-Catherine', 'Montreal', 'QC', 'H3B1A1');

INSERT INTO StudentsInformation VALUES
('301666777', 'Mia', 'Johnson', '65 Robson Street', 'Vancouver', 'BC', 'V6B2A1');

INSERT INTO StudentsInformation VALUES
('301777888', 'Ethan', 'Clark', '25 Barrington Street', 'Halifax', 'NS', 'B3J3K5');

COMMIT;

SELECT * FROM studentsinformation;
