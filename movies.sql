--------------------------------------------------------
--  File created - Thursday-January-31-2019   
--------------------------------------------------------

  ALTER SESSION SET "_ORACLE_SCRIPT"=true;
  CREATE USER movies IDENTIFIED BY "987321456";
  GRANT CONNECT TO movies;
  GRANT CONNECT, RESOURCE, DBA TO movies;
  GRANT UNLIMITED TABLESPACE TO movies;
  GRANT SELECT, INSERT, UPDATE, DELETE ON schema.movies TO movies;

--------------------------------------------------------
--  DDL for Table ACTOR
--------------------------------------------------------

  CREATE TABLE "MOVIES"."ACTOR" 
   (	"ACTOR_ID" NUMBER(19,0), 
	"AGE" NUMBER(10,0), 
	"FIRST_NAME" VARCHAR2(255 CHAR), 
	"GENDER" VARCHAR2(255 CHAR), 
	"LAST_NAME" VARCHAR2(255 CHAR)
   );

--------------------------------------------------------
--  DDL for Table GENRE
--------------------------------------------------------

  CREATE TABLE "MOVIES"."GENRE" 
   (	"GENRE_ID" NUMBER(19,0), 
	"NAME" VARCHAR2(255 CHAR)
   );
--------------------------------------------------------
--  DDL for Table MOVIE
--------------------------------------------------------

  CREATE TABLE "MOVIES"."MOVIE" 
   (	"MOVIE_ID" NUMBER(19,0), 
	"DURATION" NUMBER(10,0), 
	"IMG_URL" VARCHAR2(255 CHAR), 
	"TITLE" VARCHAR2(255 CHAR), 
	"YEAR" NUMBER(10,0)
   );
--------------------------------------------------------
--  DDL for Table MOVIE_ACTORS
--------------------------------------------------------

  CREATE TABLE "MOVIES"."MOVIE_ACTORS" 
   (	"MOVIE_ID" NUMBER(19,0), 
	"ACTOR_ID" NUMBER(19,0)
   );
--------------------------------------------------------
--  DDL for Table MOVIE_GENRES
--------------------------------------------------------

  CREATE TABLE "MOVIES"."MOVIE_GENRES" 
   (	"MOVIE_ID" NUMBER(19,0), 
	"GENRE_ID" NUMBER(19,0)
   );

--------------------------------------------------------
--  DDL for Index SYS_C008785
--------------------------------------------------------

  CREATE UNIQUE INDEX "MOVIES"."SYS_C008785" ON "MOVIES"."ACTOR" ("ACTOR_ID");
--------------------------------------------------------
--  DDL for Index SYS_C008787
--------------------------------------------------------

  CREATE UNIQUE INDEX "MOVIES"."SYS_C008787" ON "MOVIES"."GENRE" ("GENRE_ID");
--------------------------------------------------------
--  DDL for Index UK_CTFFRBU4484FT8DLSA5VMQDKA
--------------------------------------------------------

  CREATE UNIQUE INDEX "MOVIES"."UK_CTFFRBU4484FT8DLSA5VMQDKA" ON "MOVIES"."GENRE" ("NAME");
--------------------------------------------------------
--  DDL for Index SYS_C008789
--------------------------------------------------------

  CREATE UNIQUE INDEX "MOVIES"."SYS_C008789" ON "MOVIES"."MOVIE" ("MOVIE_ID");
--------------------------------------------------------
--  Constraints for Table ACTOR
--------------------------------------------------------

  ALTER TABLE "MOVIES"."ACTOR" MODIFY ("ACTOR_ID" NOT NULL ENABLE);
  ALTER TABLE "MOVIES"."ACTOR" ADD PRIMARY KEY ("ACTOR_ID");
--------------------------------------------------------
--  Constraints for Table GENRE
--------------------------------------------------------

  ALTER TABLE "MOVIES"."GENRE" MODIFY ("GENRE_ID" NOT NULL ENABLE);
  ALTER TABLE "MOVIES"."GENRE" ADD PRIMARY KEY ("GENRE_ID");
  ALTER TABLE "MOVIES"."GENRE" ADD CONSTRAINT "UK_CTFFRBU4484FT8DLSA5VMQDKA" UNIQUE ("NAME");
--------------------------------------------------------
--  Constraints for Table MOVIE
--------------------------------------------------------

  ALTER TABLE "MOVIES"."MOVIE" MODIFY ("MOVIE_ID" NOT NULL ENABLE);
  ALTER TABLE "MOVIES"."MOVIE" ADD PRIMARY KEY ("MOVIE_ID");
--------------------------------------------------------
--  Constraints for Table MOVIE_ACTORS
--------------------------------------------------------

  ALTER TABLE "MOVIES"."MOVIE_ACTORS" MODIFY ("MOVIE_ID" NOT NULL ENABLE);
  ALTER TABLE "MOVIES"."MOVIE_ACTORS" MODIFY ("ACTOR_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table MOVIE_GENRES
--------------------------------------------------------

  ALTER TABLE "MOVIES"."MOVIE_GENRES" MODIFY ("MOVIE_ID" NOT NULL ENABLE);
  ALTER TABLE "MOVIES"."MOVIE_GENRES" MODIFY ("GENRE_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table MOVIE_ACTORS
--------------------------------------------------------

  ALTER TABLE "MOVIES"."MOVIE_ACTORS" ADD CONSTRAINT "FKCIFY69O6K32MJ8HOYA3SKQGHV" FOREIGN KEY ("ACTOR_ID")
	  REFERENCES "MOVIES"."ACTOR" ("ACTOR_ID") ENABLE;
  ALTER TABLE "MOVIES"."MOVIE_ACTORS" ADD CONSTRAINT "FKBSTO8YEF4BTOKHVEIHMKG8876" FOREIGN KEY ("MOVIE_ID")
	  REFERENCES "MOVIES"."MOVIE" ("MOVIE_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table MOVIE_GENRES
--------------------------------------------------------

  ALTER TABLE "MOVIES"."MOVIE_GENRES" ADD CONSTRAINT "FKNUP1HM4TK18OM6DGAWFGO5AY9" FOREIGN KEY ("GENRE_ID")
	  REFERENCES "MOVIES"."GENRE" ("GENRE_ID") ENABLE;
  ALTER TABLE "MOVIES"."MOVIE_GENRES" ADD CONSTRAINT "FKS2XL3SIRBON75MJCONGWHRBI3" FOREIGN KEY ("MOVIE_ID")
	  REFERENCES "MOVIES"."MOVIE" ("MOVIE_ID") ENABLE;
