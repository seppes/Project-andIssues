INSERT INTO USER (ID, USERNAME, PASSWORD, ROLE) VALUES
(nextval('USER_SEQ'), 'admin', '$2a$10$9MIX8kYPkuB7uE/H5nHF8.KG6.YdjBA/voOnjSZnZDxLXL/2BIerS', 'ADMIN');
INSERT INTO USER (ID, USERNAME, PASSWORD, ROLE) VALUES
(nextval('USER_SEQ'), 'marie', '$2a$10$pQnldtWyD5CpMBjWJycMW.jmEOY2zKqjSkCo5V2vKqvW44ORrdpAa', 'USER');
INSERT INTO USER (ID, USERNAME, PASSWORD, ROLE) VALUES
(nextval('USER_SEQ'), 'giraf', '$2a$10$pQnldtWyD5CpMBjWJycMW.jmEOY2zKqjSkCo5V2vKqvW44ORrdpAa', 'USER');
INSERT INTO USER (ID, USERNAME, PASSWORD, ROLE) VALUES
(nextval('USER_SEQ'), 'olifant', '$2a$10$pQnldtWyD5CpMBjWJycMW.jmEOY2zKqjSkCo5V2vKqvW44ORrdpAa', 'USER');
INSERT INTO USER (ID, USERNAME, PASSWORD, ROLE) VALUES
(nextval('USER_SEQ'), 'ezel', '$2a$10$pQnldtWyD5CpMBjWJycMW.jmEOY2zKqjSkCo5V2vKqvW44ORrdpAa', 'USER');
INSERT INTO USER (ID, USERNAME, PASSWORD, ROLE) VALUES
(nextval('USER_SEQ'), 'varaan', '$2a$10$pQnldtWyD5CpMBjWJycMW.jmEOY2zKqjSkCo5V2vKqvW44ORrdpAa', 'USER');
INSERT INTO USER (ID, USERNAME, PASSWORD, ROLE) VALUES
(nextval('USER_SEQ'), 'hond', '$2a$10$pQnldtWyD5CpMBjWJycMW.jmEOY2zKqjSkCo5V2vKqvW44ORrdpAa', 'USER');
INSERT INTO USER (ID, USERNAME, PASSWORD, ROLE) VALUES
(nextval('USER_SEQ'), 'aap', '$2a$10$pQnldtWyD5CpMBjWJycMW.jmEOY2zKqjSkCo5V2vKqvW44ORrdpAa', 'USER');
INSERT INTO USER (ID, USERNAME, PASSWORD, ROLE) VALUES
(nextval('USER_SEQ'), 'kip', '$2a$10$pQnldtWyD5CpMBjWJycMW.jmEOY2zKqjSkCo5V2vKqvW44ORrdpAa', 'USER');
















-- voorbeeld van eindopdracht van seppe  =>













-- noinspection SqlDialectInspectionForFile

-- noinspection SqlNoDataSourceInspectionForFile

--
-- INSERT INTO GENRE (ID, NAME, LINK_MORE_INFO) VALUES
-- (0, 'Action-Adventure Games ', 'https://nl.wikipedia.org/wiki/Action-adventure');
-- INSERT INTO GENRE (ID, NAME, LINK_MORE_INFO) VALUES
-- (1, 'Shooter Games ', 'https://en.wikipedia.org/wiki/Shooter_game');
-- INSERT INTO GENRE (ID, NAME, LINK_MORE_INFO) VALUES
-- (2, 'Survival horror ', 'https://nl.wikipedia.org/wiki/Survival_horror');
-- INSERT INTO GENRE (ID, NAME, LINK_MORE_INFO) VALUES
-- (3, 'Race Games ', 'https://nl.wikipedia.org/wiki/Racespel');
-- INSERT INTO GENRE (ID, NAME, LINK_MORE_INFO) VALUES
-- (4, 'Simulation Games ', 'https://nl.wikipedia.org/wiki/Simulatiespel');
-- INSERT INTO GENRE (ID, NAME, LINK_MORE_INFO) VALUES
-- (5, 'Role-Playing Games ', 'https://en.wikipedia.org/wiki/Role-playing_video_game');
-- INSERT INTO GENRE (ID, NAME, LINK_MORE_INFO) VALUES
-- (6, 'Strategy Games ', 'https://en.wikipedia.org/wiki/Strategy_video_game');
--
--
-- insert into GAME
-- (ID, GAME_NAME, IS_THERE_MULTIPLAYER, PURCHASE, INFO_AVAILABLE_MAX_NUMBER_OF_PERSONS, MAX_NUMBER_OF_PERSONS, LINK_MORE_INFO, GENRE_ID)
-- values
-- (0, 'The Last Of Us', false, false, true, 150, 'https://transitm.mechelen.be/de-club', 0);
-- insert into GAME
-- (ID, GAME_NAME, IS_THERE_MULTIPLAYER, PURCHASE, INFO_AVAILABLE_MAX_NUMBER_OF_PERSONS, MAX_NUMBER_OF_PERSONS, LINK_MORE_INFO, GENRE_ID)
-- values
-- (1, 'Call Of Duty', true, true, true, 450, 'https://transitm.mechelen.be/de-club', 1);
-- insert into GAME
-- (ID, GAME_NAME, IS_THERE_MULTIPLAYER, PURCHASE, INFO_AVAILABLE_MAX_NUMBER_OF_PERSONS, MAX_NUMBER_OF_PERSONS, LINK_MORE_INFO, GENRE_ID)
-- values
-- (2, 'Friday the 13th', false, true, true, 80, 'https://transitm.mechelen.be/de-club', 2);
-- insert into GAME
-- (ID, GAME_NAME, IS_THERE_MULTIPLAYER, PURCHASE, INFO_AVAILABLE_MAX_NUMBER_OF_PERSONS, MAX_NUMBER_OF_PERSONS, LINK_MORE_INFO, GENRE_ID)
-- values
-- (3, 'Need For Speed', true, true, true, 310, 'https://transitm.mechelen.be/de-club', 3);
-- insert into GAME
-- (ID, GAME_NAME, IS_THERE_MULTIPLAYER, PURCHASE, INFO_AVAILABLE_MAX_NUMBER_OF_PERSONS, MAX_NUMBER_OF_PERSONS, LINK_MORE_INFO, GENRE_ID)
-- values
-- (4, 'No Mans sky', true, false, true, 110, 'https://transitm.mechelen.be/de-club', 4);
-- insert into GAME
-- (ID, GAME_NAME, IS_THERE_MULTIPLAYER, PURCHASE, INFO_AVAILABLE_MAX_NUMBER_OF_PERSONS, MAX_NUMBER_OF_PERSONS, LINK_MORE_INFO, GENRE_ID)
-- values
-- (5, 'Shadow Of The Collosus', false, false, true, 50, 'https://transitm.mechelen.be/de-club', 5);
