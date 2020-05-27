-- noinspection SqlDialectInspectionForFile

-- noinspection SqlNoDataSourceInspectionForFile



INSERT INTO KNUFFEL (ID, ANIMAL_NAME, ANIMAL_PRICE, ANIMAL_PIC, ANIMAL_DESCRIPTION) VALUES
(nextval('KNUFFEL_SEQ'), 'De Egel', '€10', '/img/knuffel_egel.png ', 'De egel kan je kind leren om geen bang te hebben van naalden.');
INSERT INTO KNUFFEL (ID, ANIMAL_NAME, ANIMAL_PRICE, ANIMAL_PIC, ANIMAL_DESCRIPTION) VALUES
(nextval('KNUFFEL_SEQ'), 'De Kangoeroe', '€10', '/img/knuffel_kangoeroe.png', 'De kangoeroe maakt je kind blij door altijd vrolijk in het rond te huppelen.');
INSERT INTO KNUFFEL (ID, ANIMAL_NAME, ANIMAL_PRICE, ANIMAL_PIC, ANIMAL_DESCRIPTION) VALUES
(nextval('KNUFFEL_SEQ'), 'De Mol', '€10', '/img/knuffel_mol.png', 'De mol kan je kind leren om niet bang te zijn in het donker..');


INSERT INTO VIDEO (ID, TITEL, VIDEO_FILE_NAME, KNUFFEL_ID) VALUES
(0, 'Hondsberoerd', '7UTbpt-56zk', 0);

INSERT INTO VIDEO (ID, TITEL, VIDEO_FILE_NAME, KNUFFEL_ID) VALUES
(1, 'Maya de Bij', '0k93k4rOgJc', 0);

INSERT INTO VIDEO (ID, TITEL, VIDEO_FILE_NAME, KNUFFEL_ID) VALUES
(2, 'Bumba', 'Q-CMnpctd-0', 1);

INSERT INTO VIDEO (ID, TITEL, VIDEO_FILE_NAME, KNUFFEL_ID) VALUES
(3, 'Jokie', 'c6bBzjy1rHk', 1);

INSERT INTO VIDEO (ID, TITEL, VIDEO_FILE_NAME, KNUFFEL_ID) VALUES
(4, 'Nijntje', 'XHKk4wts3vY', 1);

INSERT INTO VIDEO (ID, TITEL, VIDEO_FILE_NAME, KNUFFEL_ID) VALUES
(5, 'Juf Roosje', '9x9dP4Zad6s', 2);

INSERT INTO VIDEO (ID, TITEL, VIDEO_FILE_NAME, KNUFFEL_ID) VALUES
(6, 'Bing', 'eP1rt7GcTuc', 2);


INSERT INTO GAME (ID, PICTURE_GAME, TITEL_GAME, KNUFFEL_ID) VALUES
(0, '/img/game5.png', 'Zoekspel', 0);

INSERT INTO GAME (ID, PICTURE_GAME, TITEL_GAME, KNUFFEL_ID) VALUES
(1, '/img/game1.jpg', 'Cave Man', 0);

INSERT INTO GAME (ID, PICTURE_GAME, TITEL_GAME, KNUFFEL_ID) VALUES
(2, '/img/game2.jpg', 'Puzzle game', 1);

INSERT INTO GAME (ID, PICTURE_GAME, TITEL_GAME, KNUFFEL_ID) VALUES
(3, '/img/game3.jpg', 'Fun Math', 2);

INSERT INTO GAME (ID, PICTURE_GAME, TITEL_GAME, KNUFFEL_ID) VALUES
(4, '/img/game4.png', 'Zoeken', 2);



INSERT INTO USER (ID, USERNAME, PASSWORD, ROLE, KNUFFEL_ID) VALUES
(nextval('USER_SEQ'), 'admin', '$2a$10$9MIX8kYPkuB7uE/H5nHF8.KG6.YdjBA/voOnjSZnZDxLXL/2BIerS', 'ADMIN', 0);
INSERT INTO USER (ID, USERNAME, PASSWORD, ROLE, KNUFFEL_ID) VALUES
(nextval('USER_SEQ'), 'gabriel', '$2a$10$pQnldtWyD5CpMBjWJycMW.jmEOY2zKqjSkCo5V2vKqvW44ORrdpAa', 'USER', 1);
INSERT INTO USER (ID, USERNAME, PASSWORD, ROLE, KNUFFEL_ID) VALUES
(nextval('USER_SEQ'), 'kaan', '$2a$10$pQnldtWyD5CpMBjWJycMW.jmEOY2zKqjSkCo5V2vKqvW44ORrdpAa', 'USER', 2);
INSERT INTO USER (ID, USERNAME, PASSWORD, ROLE, KNUFFEL_ID) VALUES
(nextval('USER_SEQ'), 'seppe', '$2a$10$pQnldtWyD5CpMBjWJycMW.jmEOY2zKqjSkCo5V2vKqvW44ORrdpAa', 'USER', 1);
INSERT INTO USER (ID, USERNAME, PASSWORD, ROLE, KNUFFEL_ID) VALUES
(nextval('USER_SEQ'), 'thomas', '$2a$10$pQnldtWyD5CpMBjWJycMW.jmEOY2zKqjSkCo5V2vKqvW44ORrdpAa', 'USER', 0);
INSERT INTO USER (ID, USERNAME, PASSWORD, ROLE, KNUFFEL_ID) VALUES
(nextval('USER_SEQ'), 'sammy', '$2a$10$pQnldtWyD5CpMBjWJycMW.jmEOY2zKqjSkCo5V2vKqvW44ORrdpAa', 'USER', 1);