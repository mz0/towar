-- as e.g. root@localhost
create user tomC@localhost IDENTIFIED BY 'at9';
grant all on Tomcar.* to tomC@localhost WITH GRANT OPTION;

-- as tomC@localhost
create database Tomcar;
use Tomcar;

CREATE TABLE CARS(
  ID BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  Name VARCHAR(31),
  Price INT);

INSERT INTO CARS(Name, Price) VALUES('Audi', 52642);
INSERT INTO CARS(Name, Price) VALUES('Mercedes', 57127);
INSERT INTO CARS(Name, Price) VALUES('Skoda', 9000);
INSERT INTO CARS(Name, Price) VALUES('Volvo', 29000);
INSERT INTO CARS(Name, Price) VALUES('Bentley', 350000);
INSERT INTO CARS(Name, Price) VALUES('Citroen', 21000);
INSERT INTO CARS(Name, Price) VALUES('Hummer', 41400);
INSERT INTO CARS(Name, Price) VALUES('Volkswagen', 21600);
