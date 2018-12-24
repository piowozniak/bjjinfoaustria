INSERT INTO gyms (id,name,city,region,address,phoneNumber,headCoach) VALUES (1,'BJJ','Vienna','LowerAustria','RandomStrasse','44855465465','John');
INSERT INTO gyms (id,name,city,region,address,phoneNumber,headCoach) VALUES (2,'MMA','Vienna','LowerAustria','NullStrasse','44855465465','John');
INSERT INTO gyms (id,name,city,region,address,phoneNumber,headCoach) VALUES (3,'MT','Linz','UpperAustria','PiotrStrasse','448523465465','John');
INSERT INTO gyms (id,name,city,region,address,phoneNumber,headCoach) VALUES (4,'JUDO','Tirol','Tirol','AclStrasse','44555555555','John');

INSERT INTO cities (id, name) VALUES (1,'VIENNA');
INSERT INTO cities (id, name) VALUES (2,'INNSBRUCK');
INSERT INTO cities (id, name) VALUES (3,'LINZ');
INSERT INTO cities (id, name) VALUES (4,'SALZBURG');

INSERT INTO Event (id,nameOfEvent,typeOfEvent,host,organizer,startDate,endDate, startHour, deadline, locationCity, locationAddress,fee, status) VALUES (1,'Summer Camp','Camp','Carlos Maia','John','12-05-2019','20-05-2019', '10:00', '12-04-2019', 'Dupowo', 'Dupowato', '300', 'SUBMITTED');
INSERT INTO Event (id,nameOfEvent,typeOfEvent,host,organizer,startDate,endDate, startHour, deadline, locationCity, locationAddress,fee, status) VALUES (2,'Adam Wardzinski Seminar','Seminar','Pawel Kozlowski','John','12-08-2019','13-05-2019', '10:00', '12-07-2019', 'Vienna', 'Dupowato', '50', 'SUBMITTED');
INSERT INTO Event (id,nameOfEvent,typeOfEvent,host,organizer,startDate,endDate, startHour, deadline, locationCity, locationAddress,fee, status) VALUES (3,'Seminar with Rick Hunley','Seminar','Lemmy Krusic','John','12-05-2019','20-05-2019', '10:00', '12-04-2019', 'Linz', 'IndustrizeilleStrasse', '3000', 'SUBMITTED');
INSERT INTO Event (id,nameOfEvent,typeOfEvent,host,organizer,startDate,endDate, startHour, deadline, locationCity, locationAddress,fee, status) VALUES (4,'Seminar with Frank Artnak','Seminar','Mani','John','12-05-2019','20-05-2019', '10:00', '12-04-2019', 'Linz', 'ShitHole', '1300', 'SUBMITTED');
INSERT INTO Event (id,nameOfEvent,typeOfEvent,host,organizer,startDate,endDate, startHour, deadline, locationCity, locationAddress,fee, status) VALUES (5,'BJJ Austria Open','COMPETITION','Dupa','John','12-05-2019','20-05-2019', '10:00', '12-04-2019', 'Vienna', 'ShitHole', '1300', 'SUBMITTED');

INSERT INTO Division (id, event_id) VALUES (5, 1); 
INSERT INTO Division (id, event_id) VALUES (6, 2); 
INSERT INTO Division (id, event_id) VALUES (7, 3); 
INSERT INTO Division (id, event_id) VALUES (8, 4);
INSERT INTO Division (id, beltCategory, weightCategory, event_id) VALUES (1, 'WHITE', '-57kg', 5); 
INSERT INTO Division (id, beltCategory, weightCategory, event_id) VALUES (2, 'WHITE', '-64kg', 5); 
INSERT INTO Division (id, beltCategory, weightCategory, event_id) VALUES (3, 'WHITE', '-70kg', 5); 
INSERT INTO Division (id, beltCategory, weightCategory, event_id) VALUES (4, 'WHITE', '-76kg', 5); 

INSERT INTO user (id, username, password, passwordConfirm, status, firstName, lastName, email, phoneNumber) VALUES (1,'john', '$2a$10$4bMJX7eR2fd2xiUSo/gtr.kci.jPY06N0THDnhjW/uB/jI7cKYetm', 'testtest','A' ,'John','Kebab', 'dupa@dup.dup', '65465465');
INSERT INTO user (id, username,	password, passwordConfirm, status, firstName, lastName, email, phoneNumber) VALUES (2,'userrole', '$2a$10$4bMJX7eR2fd2xiUSo/gtr.kci.jPY06N0THDnhjW/uB/jI7cKYetm', 'as','N','test','test', 'test@dusp.dsup', '65465465');
INSERT INTO user (id, username, password, passwordConfirm, status, firstName, lastName, email, phoneNumber) VALUES (3,'organizerrole', '$2a$10$4bMJX7eR2fd2xiUSo/gtr.kci.jPY06N0THDnhjW/uB/jI7cKYetm', 'testtest','A','Ble','Ble', 'Ble', '65465465');
INSERT INTO user (id, username, password, passwordConfirm, status, firstName, lastName, email, phoneNumber) VALUES (4,'GreUser', 'tesasdt', 'tesasdt','A','Gre','Gre', 'Gre', '65465465');
INSERT INTO user (id, username, password, passwordConfirm, status, firstName, lastName, email, phoneNumber) VALUES (5,'JustynaUser', 'tasdest', 'tasdest','N','Justyna','Pardon', 'dupa@dup.dup', '65465465');
INSERT INTO user (id, username, password, passwordConfirm, status, firstName, lastName, email, phoneNumber) VALUES (6,'MarekUser', 'teasdst', 'teasdst','N','Marek','ZAustrii', 'dupa@dup.dup', '65465465');
INSERT INTO user (id, username, password, passwordConfirm, status, firstName, lastName, email, phoneNumber) VALUES (7,'PyjotrUser', 'teasdst', 'teasdst','N','Pyjotr','Pyjotr', 'Ble', '65465465');
INSERT INTO user (id, username, password, passwordConfirm, status, firstName, lastName, email, phoneNumber) VALUES (8,'BuraczanyUser', 'teasdst', 'teasdst','N','Buraczany','Grzesiu', 'Gre', '65465465');

INSERT INTO Competitor (id, division_id, user_id, place, status) VALUES (1, 1, 1, '0', 'A');
INSERT INTO Competitor (id, division_id, user_id, place, status) VALUES (2, 1, 2, '0', 'A');
INSERT INTO Competitor (id, division_id, user_id, place, status) VALUES (3, 1, 3, '0', 'A');
INSERT INTO Competitor (id, division_id, user_id, place, status) VALUES (4, 1, 4, '0', 'A');
INSERT INTO Competitor (id, division_id, user_id, place, status) VALUES (5, 1, 5, '0', 'A');
INSERT INTO Competitor (id, division_id, user_id, place, status) VALUES (6, 1, 6, '0', 'A');
INSERT INTO Competitor (id, division_id, user_id, place, status) VALUES (7, 1, 7, '0', 'A');
INSERT INTO Competitor (id, division_id, user_id, place, status) VALUES (8, 1, 8, '0', 'A');

INSERT INTO role (id, name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO role (id, name) VALUES (2, 'ROLE_USER');
INSERT INTO role (id, name) VALUES (3, 'ROLE_ORGANIZER');

INSERT INTO user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO user_role (user_id, role_id) VALUES (1, 2);
INSERT INTO user_role (user_id, role_id) VALUES (1, 3);
INSERT INTO user_role (user_id, role_id) VALUES (2, 2);
INSERT INTO user_role (user_id, role_id) VALUES (3, 2);
INSERT INTO user_role (user_id, role_id) VALUES (3, 3);
