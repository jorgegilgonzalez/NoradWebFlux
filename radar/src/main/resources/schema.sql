CREATE TABLE IF NOT EXISTS `misiles`( `id` INT UNSIGNED NOT NULL AUTO_INCREMENT , `modelo` VARCHAR(10) NOT NULL , `alcance` FLOAT NOT NULL , PRIMARY KEY (`id`), UNIQUE `modelo_unique` (`modelo`)) ENGINE = InnoDB;