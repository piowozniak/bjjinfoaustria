INSERT INTO gyms (id,name,city,region,address,phoneNumber,headCoach) VALUES (1,'BJJ','Vienna','LowerAustria','RandomStrasse','44855465465','John');
INSERT INTO gyms (id,name,city,region,address,phoneNumber,headCoach) VALUES (2,'MMA','Vienna','LowerAustria','NullStrasse','44855465465','John');
INSERT INTO gyms (id,name,city,region,address,phoneNumber,headCoach) VALUES (3,'MT','Linz','UpperAustria','PiotrStrasse','448523465465','John');
INSERT INTO gyms (id,name,city,region,address,phoneNumber,headCoach) VALUES (4,'JUDO','Tirol','Tirol','AclStrasse','44555555555','John');

INSERT INTO cities (id, name) VALUES (1,'VIENNA');
INSERT INTO cities (id, name) VALUES (2,'INNSBRUCK');
INSERT INTO cities (id, name) VALUES (3,'LINZ');
INSERT INTO cities (id, name) VALUES (4,'SALZBURG');

INSERT INTO Event (id,nameOfEvent,typeOfEvent,host,organizer,startDate,endDate, startHour, deadline, locationCity, locationAddress,fee, status) VALUES (1,'Summer Camp','Camp','Carlos Maia','BJJ Graz','12-05-2019','20-05-2019', '10:00', '12-04-2019', 'Dupowo', 'Dupowato', '300', 'SUBMITTED');
INSERT INTO Event (id,nameOfEvent,typeOfEvent,host,organizer,startDate,endDate, startHour, deadline, locationCity, locationAddress,fee, status) VALUES (2,'Adam Wardzinski Seminar','Seminar','Pawel Kozlowski','Alpha Jiut Jitsu','12-08-2019','13-05-2019', '10:00', '12-07-2019', 'Vienna', 'Dupowato', '50', 'SUBMITTED');
INSERT INTO Event (id,nameOfEvent,typeOfEvent,host,organizer,startDate,endDate, startHour, deadline, locationCity, locationAddress,fee, status) VALUES (3,'Seminar with Rick Hunley','Seminar','Lemmy Krusic','ATT','12-05-2019','20-05-2019', '10:00', '12-04-2019', 'Linz', 'IndustrizeilleStrasse', '3000', 'SUBMITTED');
INSERT INTO Event (id,nameOfEvent,typeOfEvent,host,organizer,startDate,endDate, startHour, deadline, locationCity, locationAddress,fee, status) VALUES (4,'Seminar with Frank Artnak','Seminar','Mani','AK16','12-05-2019','20-05-2019', '10:00', '12-04-2019', 'Linz', 'ShitHole', '1300', 'SUBMITTED');
INSERT INTO Event (id,nameOfEvent,typeOfEvent,host,organizer,startDate,endDate, startHour, deadline, locationCity, locationAddress,fee, status) VALUES (5,'BJJ Austria Open','COMPETITION','Dupa','DDD','12-05-2019','20-05-2019', '10:00', '12-04-2019', 'Vienna', 'ShitHole', '1300', 'SUBMITTED');

INSERT INTO Division (id, beltCategory, weightCategory, event_id) VALUES (1, 'WHITE', '-57kg', 5); 
INSERT INTO Division (id, beltCategory, weightCategory, event_id) VALUES (2, 'WHITE', '-64kg', 5); 
INSERT INTO Division (id, beltCategory, weightCategory, event_id) VALUES (3, 'WHITE', '-70kg', 5); 
INSERT INTO Division (id, beltCategory, weightCategory, event_id) VALUES (4, 'WHITE', '-76kg', 5); 

INSERT INTO User (id, userName, status, firstName, lastName, email, phoneNumber) VALUES (1,'JohnUser', 'N' ,'John','Kebab', 'dupa@dup.dup', '65465465');
INSERT INTO User (id, userName, status, firstName, lastName, email, phoneNumber) VALUES (2,'admin', 'N','Dupa','Dupa', 'dupa@dup.dup', '65465465');
INSERT INTO User (id, userName, status, firstName, lastName, email, phoneNumber) VALUES (3,'user', 'A','Ble','Ble', 'Ble', '65465465');
INSERT INTO User (id, userName, status, firstName, lastName, email, phoneNumber) VALUES (4,'GreUser', 'A','Gre','Gre', 'Gre', '65465465');
INSERT INTO User (id, userName, status, firstName, lastName, email, phoneNumber) VALUES (5,'JustynaUser', 'N','Justyna','Pardon', 'dupa@dup.dup', '65465465');
INSERT INTO User (id, userName, status, firstName, lastName, email, phoneNumber) VALUES (6,'MarekUser', 'N','Marek','ZAustrii', 'dupa@dup.dup', '65465465');
INSERT INTO User (id, userName, status, firstName, lastName, email, phoneNumber) VALUES (7,'PyjotrUser', 'N','Pyjotr','Pyjotr', 'Ble', '65465465');
INSERT INTO User (id, userName, status, firstName, lastName, email, phoneNumber) VALUES (8,'BuraczanyUser', 'N','Buraczany','Grzesiu', 'Gre', '65465465');

INSERT INTO Competitor (id, division_id, user_id, place) VALUES (1, 1, 1, '0');
INSERT INTO Competitor (id, division_id, user_id, place) VALUES (2, 1, 2, '0');
INSERT INTO Competitor (id, division_id, user_id, place) VALUES (3, 1, 3, '0');
INSERT INTO Competitor (id, division_id, user_id, place) VALUES (4, 1, 4, '0');
INSERT INTO Competitor (id, division_id, user_id, place) VALUES (5, 1, 5, '0');
INSERT INTO Competitor (id, division_id, user_id, place) VALUES (6, 1, 6, '0');
INSERT INTO Competitor (id, division_id, user_id, place) VALUES (7, 1, 7, '0');
INSERT INTO Competitor (id, division_id, user_id, place) VALUES (8, 1, 8, '0');
