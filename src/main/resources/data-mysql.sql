DROP DATABASE IF EXISTS fuel;
CREATE DATABASE IF NOT EXISTS fuel CHARACTER SET  utf8mb4;

GRANT ALL PRIVILEGES ON fuel.* TO 'mdbu'@'%';

CREATE TABLE IF NOT EXISTS `fuel`.`station` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `uid` UUID NOT NULL DEFAULT uuid(),
    `name` VARCHAR(60) CHARACTER SET utf8mb4 NOT NULL,
     INDEX (`id`), UNIQUE (`uid`), UNIQUE(`name`)) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `fuel`.`type` (
     `id` INT NOT NULL AUTO_INCREMENT,
     `uid_station` UUID NOT NULL,
     `uid` UUID NOT NULL DEFAULT uuid(),
     `name` VARCHAR(60) CHARACTER SET utf8mb4 NOT NULL,
    PRIMARY KEY (`id`), UNIQUE (`uid`), UNIQUE (`name`),
    FOREIGN KEY (`uid_station`) REFERENCES `station`(`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `fuel`.`cost` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `uid_type` UUID NOT NULL,
    `uid` UUID NOT NULL DEFAULT uuid(),
    `price` FLOAT NOT NULL DEFAULT '0.0',
    PRIMARY KEY (`id`), UNIQUE (`uid`),
    FOREIGN KEY (`uid_type`) REFERENCES `type`(`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `fuel`.`price` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `uid_station` UUID NOT NULL,
    `uid_type` UUID NOT NULL,
    `uid_cost` UUID NOT NULL,

    PRIMARY KEY (`id`), UNIQUE(`uid_type`, `uid_cost`),
    FOREIGN KEY (`uid_station`) REFERENCES `station`(`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
    FOREIGN KEY (`uid_type`) REFERENCES `type`(`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
    FOREIGN KEY (`uid_cost`) REFERENCES `cost`(`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT) ENGINE = InnoDB;


    /*
CREATE TABLE IF NOT EXISTS `fuel`.`type` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `uid_station` UUID NOT NULL,
    `uid` UUID NOT NULL DEFAULT uuid(),
    `name` VARCHAR(60) CHARACTER SET utf8mb4 NOT NULL,
    `price` FLOAT NOT NULL DEFAULT '0.0',
    PRIMARY KEY (`id`), UNIQUE (`uid`), UNIQUE(`name`),
    FOREIGN KEY (`uid_station`) REFERENCES `station`(`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT) ENGINE = InnoDB;
    */
/*
SELECT
	station.name as "АЗС",
    type.name AS "Тип пального",
    cost.price AS "Вартість"
FROM
    price
LEFT JOIN station ON(station.uid = price.uid_station)
LEFT JOIN type ON(type.uid = price.uid_type)
LEFT JOIN cost ON(cost.uid = price.uid_cost)
*/