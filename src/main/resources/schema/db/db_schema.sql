DROP TABLE IF EXISTS MUSIC

DROP SEQUENCE IF EXISTS MUSIC_ID_SEQUENCE


CREATE SEQUENCE music_id_sequence START WITH 1 INCREMENT BY 1

CREATE TABLE MUSIC(
ID INT UNIQUE not null,
TITLERECORD VARCHAR(256) not null,
LYRICIST VARCHAR(256) not null,
ALBUM VARCHAR(100) not null,
CONSTRAINT MUSIC_PK PRIMARY KEY(id)
)


CREATE  TABLE USERS (
  USERNAME VARCHAR(45) NOT NULL ,
  PASSWORD VARCHAR(45) NOT NULL ,
 CONSTRAINT USERS_PK PRIMARY KEY (USERNAME));
 
 
 CREATE SEQUENCE user_roles_seq;

CREATE TABLE user_roles (
  user_role_id int NOT NULL DEFAULT NEXTVAL ('user_roles_seq'),
  username varchar(45) NOT NULL,
  role varchar(45) NOT NULL,
  PRIMARY KEY (user_role_id),
  CONSTRAINT uni_username_role UNIQUE (role,username),
  CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES users (username));

CREATE INDEX fk_username_idx ON user_roles (username);


INSERT INTO users(username,password)
VALUES ('priya','priya');

INSERT INTO users(username,password)
VALUES ('naveen','naveen');

INSERT INTO user_roles (username, role)
VALUES ('priya', 'ROLE_USER');

INSERT INTO user_roles (username, role)
VALUES ('priya', 'ROLE_ADMIN');

INSERT INTO user_roles (username, role)
VALUES ('naveen', 'ROLE_USER');





