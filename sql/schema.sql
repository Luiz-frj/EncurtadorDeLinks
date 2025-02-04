CREATE DATABASE short_link_generator_db;

USE short_link_generator_db;

CREATE TABLE tb_users (
    name VARCHAR(30) PRIMARY KEY ,
    senha VARCHAR(256) NOT NULL
);

CREATE TABLE tb_links (
	link VARCHAR(256) NOT NULL,
    short_link VARCHAR(16) PRIMARY KEY,
    user_name VARCHAR(30),
    FOREIGN KEY (user_name) REFERENCES tb_users(name)
);

CREATE TABLE tb_acess (
	link VARCHAR(16),
	ip VARCHAR(15),
	FOREIGN KEY (link) REFERENCES tb_links(short_link) ON DELETE CASCADE
);