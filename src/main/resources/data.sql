-- noinspection SqlDialectInspectionForFile

-- noinspection SqlNoDataSourceInspectionForFile



INSERT INTO KNUFFEL (ID, ANIMAL_NAME, ANIMAL_PRICE, ANIMAL_PIC, ANIMAL_DESCRIPTION) VALUES
( 0, 'De Egel ', '€10', 'img/knuffel_egel.png', 'De egel heeft naalden.');
INSERT INTO KNUFFEL (ID, ANIMAL_NAME, ANIMAL_PRICE, ANIMAL_PIC, ANIMAL_DESCRIPTION) VALUES
( 1, 'De Kangoeroe ', '€10', 'img/knuffel_kangoeroe.png', 'De kangoeroe springt.');
INSERT INTO KNUFFEL (ID, ANIMAL_NAME, ANIMAL_PRICE, ANIMAL_PIC, ANIMAL_DESCRIPTION) VALUES
( 2, 'De Mol ', '€10', 'img/knuffel_mol.png', 'De mol graaft.');



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