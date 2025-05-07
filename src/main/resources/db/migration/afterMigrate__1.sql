TRUNCATE TABLE business.tour CASCADE;
ALTER SEQUENCE business.tour_id_seq RESTART WITH 1;

TRUNCATE TABLE business.agency CASCADE;
ALTER SEQUENCE business.agency_id_seq RESTART WITH 1;

INSERT INTO business.agency (name, stars_count, country_count) VALUES ('WanderPulse Expeditions', 4, 12);
INSERT INTO business.agency (name, stars_count, country_count) VALUES ( 'HorizonHunters', 2, 10);
INSERT INTO business.agency (name, stars_count, country_count) VALUES ('GreenHaven Voyages', 5, 16);
INSERT INTO business.agency (name, stars_count, country_count) VALUES ('Alchemy Roads', 5, 16);


INSERT INTO business.tour (country, price, day_count, agency_id) VALUES ('USA', 12000, 10, 1);
INSERT INTO business.tour (country, price, day_count, agency_id) VALUES ('Great Britain', 10000, 5, 2);
INSERT INTO business.tour (country, price, day_count, agency_id) VALUES ('Russia', 10000, 15, 2);
INSERT INTO business.tour (country, price, day_count, agency_id) VALUES ('India', 4000, 3, 3);
INSERT INTO business.tour (country, price, day_count, agency_id) VALUES ('Sweden', 13000, 10, 4);
