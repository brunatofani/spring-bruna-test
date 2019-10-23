use mysql_db;
select * from user;

CREATE TABLE user (
   user_id int(11) NOT NULL AUTO_INCREMENT,
   name varchar(50),
   PRIMARY KEY (user_id));