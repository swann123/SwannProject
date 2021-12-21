CREATE DATABASE mydb;

CREATE TABLE `mydb`.`leadregister` 
( `id` INT NOT NULL AUTO_INCREMENT , 
 `name` VARCHAR(30) NOT NULL , 
 `email` VARCHAR(30) NOT NULL , 
 `password` VARCHAR(30) NOT NULL , PRIMARY KEY (`id`)) 
 ENGINE = InnoDB;