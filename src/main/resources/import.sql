Insert into MOVIES.MOVIE (MOVIE_ID,DURATION,IMG_URL,TITLE,YEAR) values (1,120,'https://m.media-amazon.com/images/M/MV5BN2EwM2I5OWMtMGQyMi00Zjg1LWJkNTctZTdjYTA4OGUwZjMyXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_.jpg','Mad Max: Fury Road',2015);
Insert into MOVIES.MOVIE (MOVIE_ID,DURATION,IMG_URL,TITLE,YEAR) values (2,180,'https://m.media-amazon.com/images/M/MV5BMjIxMjgxNTk0MF5BMl5BanBnXkFtZTgwNjIyOTg2MDE@._V1_SY1000_CR0,0,674,1000_AL_.jpg','The Wolf of Wall Street',2013);
Insert into MOVIES.MOVIE (MOVIE_ID,DURATION,IMG_URL,TITLE,YEAR) values (3,130,'https://m.media-amazon.com/images/M/MV5BMjMyNzExNzQ5OV5BMl5BanBnXkFtZTgwNjM2MjIxNjM@._V1_SY1000_CR0,0,631,1000_AL_.jpg','Green Book',2018);
Insert into MOVIES.MOVIE (MOVIE_ID,DURATION,IMG_URL,TITLE,YEAR) values (4,164,'https://m.media-amazon.com/images/M/MV5BMTk4ODQzNDY3Ml5BMl5BanBnXkFtZTcwODA0NTM4Nw@@._V1_.jpg','The Dark Knight Rises',2012);

Insert into MOVIES.GENRE (GENRE_ID,NAME) values (1,'Action');
Insert into MOVIES.GENRE (GENRE_ID,NAME) values (2,'Adventure');
Insert into MOVIES.GENRE (GENRE_ID,NAME) values (3,'Comedy');
Insert into MOVIES.GENRE (GENRE_ID,NAME) values (4,'Crime');
Insert into MOVIES.GENRE (GENRE_ID,NAME) values (5,'Drama');
Insert into MOVIES.GENRE (GENRE_ID,NAME) values (6,'Fantasy');
Insert into MOVIES.GENRE (GENRE_ID,NAME) values (7,'Historical');
Insert into MOVIES.GENRE (GENRE_ID,NAME) values (9,'Fiction');
Insert into MOVIES.GENRE (GENRE_ID,NAME) values (10,'Horror');
Insert into MOVIES.GENRE (GENRE_ID,NAME) values (11,'Magical');
Insert into MOVIES.GENRE (GENRE_ID,NAME) values (12,'Realism');
Insert into MOVIES.GENRE (GENRE_ID,NAME) values (13,'Mystery');
Insert into MOVIES.GENRE (GENRE_ID,NAME) values (14,'Paranoid');
Insert into MOVIES.GENRE (GENRE_ID,NAME) values (15,'Science');
Insert into MOVIES.GENRE (GENRE_ID,NAME) values (16,'Parody');
Insert into MOVIES.GENRE (GENRE_ID,NAME) values (17,'Philosophical');
Insert into MOVIES.GENRE (GENRE_ID,NAME) values (18,'Political');
Insert into MOVIES.GENRE (GENRE_ID,NAME) values (19,'Romance');
Insert into MOVIES.GENRE (GENRE_ID,NAME) values (20,'Saga');
Insert into MOVIES.GENRE (GENRE_ID,NAME) values (21,'Satire');
Insert into MOVIES.GENRE (GENRE_ID,NAME) values (22,'Science-Fiction');
Insert into MOVIES.GENRE (GENRE_ID,NAME) values (24,'Social');
Insert into MOVIES.GENRE (GENRE_ID,NAME) values (25,'Speculative');
Insert into MOVIES.GENRE (GENRE_ID,NAME) values (26,'Thriller');
Insert into MOVIES.GENRE (GENRE_ID,NAME) values (27,'Urban');
Insert into MOVIES.GENRE (GENRE_ID,NAME) values (28,'Western');

Insert into MOVIES.ACTOR (ACTOR_ID,AGE,FIRST_NAME,GENDER,LAST_NAME) values (1,42,'Tom','MALE','Hardy');
Insert into MOVIES.ACTOR (ACTOR_ID,AGE,FIRST_NAME,GENDER,LAST_NAME) values (2,44,'Charlize','FEMALE','Theron');
Insert into MOVIES.ACTOR (ACTOR_ID,AGE,FIRST_NAME,GENDER,LAST_NAME) values (3,30,'Nicholas','MALE','Hoult');
Insert into MOVIES.ACTOR (ACTOR_ID,AGE,FIRST_NAME,GENDER,LAST_NAME) values (4,72,'Hugh','FEMALE','Keays-Byrne');

Insert into MOVIES.MOVIE_ACTORS (MOVIE_ID,ACTOR_ID) values (1,1);
Insert into MOVIES.MOVIE_ACTORS (MOVIE_ID,ACTOR_ID) values (1,2);
Insert into MOVIES.MOVIE_ACTORS (MOVIE_ID,ACTOR_ID) values (1,3);
Insert into MOVIES.MOVIE_ACTORS (MOVIE_ID,ACTOR_ID) values (1,4);
Insert into MOVIES.MOVIE_ACTORS (MOVIE_ID,ACTOR_ID) values (2,1);