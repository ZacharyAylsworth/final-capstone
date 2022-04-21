BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS cards;
DROP TABLE IF EXISTS decks;
DROP TABLE IF EXISTS categories;
DROP TABLE IF EXISTS difficulty;
DROP SEQUENCE IF EXISTS seq_user_id;



CREATE SEQUENCE seq_user_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;

CREATE TABLE difficulty (
  difficulty_id int primary key,
  difficulty_name varchar(20)
  );

CREATE TABLE decks (
    deck_id serial primary key,
    deck_name varchar(200) NOT NULL,
    card_id int
);

ALTER SEQUENCE decks_deck_id_seq RESTART WITH 4;

CREATE TABLE categories (
    category_id int primary key,
    category_name varchar(100) NOT NULL
);

CREATE TABLE users (
	user_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

CREATE TABLE cards (
	card_id serial primary key,
	deck_id int,
	card_front varchar(50) NOT NULL,
	card_back varchar(1000) NOT NULL
--	category_id int NOT NULL,
--	card_difficulty_id int NOT NULL,


--	CONSTRAINT FK_cards FOREIGN KEY (category_id) references categories (category_id)
);
--dummy data
--INSERT INTO decks (deck_id, deck_name, card_id) VALUES (1, 'decks', 1);
INSERT INTO categories (category_id, category_name) VALUES (1, 'vocabulary');
--INSERT INTO cards (card_id, deck_id, card_front, card_back) VALUES (DEFAULT, 1, 'front', 'back');
--real data
INSERT INTO difficulty (difficulty_id, difficulty_name) VALUES (1, 'Easy');
INSERT INTO difficulty (difficulty_id, difficulty_name) VALUES (2, 'Medium');
INSERT INTO difficulty (difficulty_id, difficulty_name) VALUES (3, 'Hard');

COMMIT TRANSACTION;