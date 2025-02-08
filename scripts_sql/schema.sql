CREATE DATABASE short_link_generator_db;

USE short_link_generator_db;

CREATE TABLE tb_users (
    name VARCHAR(30) PRIMARY KEY ,
    password VARCHAR(256) NOT NULL
);

CREATE TABLE tb_links (
	short_link VARCHAR(12) PRIMARY KEY NOT NULL,
	link VARCHAR(256) NOT NULL,
    user_name VARCHAR(30),
    FOREIGN KEY (user_name) REFERENCES tb_users(name) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE tb_access (
	short_link VARCHAR(12),
	ip VARCHAR(15),
	FOREIGN KEY (short_link) REFERENCES tb_links(short_link) ON DELETE CASCADE ON UPDATE CASCADE
);