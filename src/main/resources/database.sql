CREATE database taskdb;

USE taskdb;

CREATE TABLE task (
	id SERIAL NOT NULL PRIMARY KEY,
    name VARCHAR(250) NOT NULL,
    status INTEGER NOT NULL COMMENT "1 - To do, 2 - In progress, 3 - Done",
    createdat DATETIME NOT NULL,
    updatedat DATETIME NOT NULL
);