CREATE TABLE Director(
                         director_id int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
                         name varchar(100) NOT NULL UNIQUE,
                         age int CHECK (age > 10)
);


CREATE TABLE Movie(
                      movie_id int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
                      director_id int NOT NULL REFERENCES director(director_id),
                      name varchar(200) NOT NULL,
                      year_of_production int CHECK(year_of_production > 1900)
);


    INSERT INTO Director(name, age) VALUES ('Quentin Tarantino', 57);
INSERT INTO Director(name, age) VALUES ('Martin Scorsese', 78);
INSERT INTO Director(name, age) VALUES ('Guy Ritchie', 52);
INSERT INTO Director(name, age) VALUES ('Woody Allen', 85);
INSERT INTO Director(name, age) VALUES ('David Lynch', 74);
INSERT INTO Director(name, age) VALUES ('Christopher Nolan', 50);


INSERT INTO Movie(director_id, name, year_of_production) VALUES (1, 'Reservoir Dogs', 1992);
INSERT INTO Movie(director_id, name, year_of_production) VALUES (1, 'Pulp Fiction', 1994);
INSERT INTO Movie(director_id, name, year_of_production) VALUES (1, 'The Hateful Eight', 2015);
INSERT INTO Movie(director_id, name, year_of_production) VALUES (1, 'Once Upon a Time in Hollywood', 2019);
INSERT INTO Movie(director_id, name, year_of_production) VALUES (2, 'Taxi Driver', 1976);
INSERT INTO Movie(director_id, name, year_of_production) VALUES (2, 'Goodfellas', 1990);
INSERT INTO Movie(director_id, name, year_of_production) VALUES (2, 'The Wolf of Wall Street', 2013);
INSERT INTO Movie(director_id, name, year_of_production) VALUES (3, 'Lock, Stock and Two Smoking Barrels', 1998);
INSERT INTO Movie(director_id, name, year_of_production) VALUES (3, 'Snatch', 2000);
INSERT INTO Movie(director_id, name, year_of_production) VALUES (4, 'Midnight in Paris', 2011);
INSERT INTO Movie(director_id, name, year_of_production) VALUES (6, 'Inception', 2010);