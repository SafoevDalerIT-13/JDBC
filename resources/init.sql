CREATE SCHEMA IF NOT EXISTS test;
USE test;

DROP TABLE IF EXISTS test;
CREATE TABLE students (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(80),
    surname VARCHAR(80),
    curse_name VARCHAR(80)
);

INSERT INTO students(name,surname,curse_name)
VALUES ('Alex','kaloved','IT');
