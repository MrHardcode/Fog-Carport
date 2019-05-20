DROP SCHEMA if EXISTS`carportdb`;
CREATE SCHEMA `carportdb` ;
USE carportdb;

CREATE TABLE `carportdb`.`category` (
  `id_category` INT NOT NULL AUTO_INCREMENT,
  `category_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_category`),
  UNIQUE INDEX `id_category_UNIQUE` (`id_category` ASC) VISIBLE);
  
  CREATE TABLE `carportdb`.`roles` (
  `id_role` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_role`),
  UNIQUE INDEX `id_role_UNIQUE` (`id_role` ASC) VISIBLE);

CREATE TABLE `carportdb`.`customers` (
  `id_customer` INT NOT NULL AUTO_INCREMENT,
  `customer_name` VARCHAR(45) NOT NULL,
  `phone` INT(10) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `password` VARCHAR(30) NOT NULL DEFAULT '',
  `registered` BOOLEAN DEFAULT false,
  PRIMARY KEY (`id_customer`),
  UNIQUE INDEX `id_customer_UNIQUE` (`id_customer` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE);


CREATE TABLE `carportdb`.`materials` (
  `id_material` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(200) NOT NULL,
  `height` INT NOT NULL DEFAULT 0,
  `width` INT NOT NULL DEFAULT 0,
  `length` INT NOT NULL DEFAULT 0,
  `cost_price` DOUBLE NOT NULL,
  `unit` VARCHAR(45) NOT NULL,
  `id_category` INT NOT NULL,
  `helptext_base` VARCHAR(500) NOT NULL DEFAULT 'Helptext not available',
  `helptext_roof` VARCHAR(500) NOT NULL DEFAULT 'Helptext not available',
  `helptext_shed` VARCHAR(500) NOT NULL DEFAULT 'Helptext not available',
  PRIMARY KEY (`id_material`),
  UNIQUE INDEX `id_material_UNIQUE` (`id_material` ASC) VISIBLE,
  INDEX `id_category_idx` (`id_category` ASC) VISIBLE,
  CONSTRAINT `id_category`
    FOREIGN KEY (`id_category`)
    REFERENCES `carportdb`.`category` (`id_category`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
	
CREATE TABLE `carportdb`.`employees` (
  `id_employee` INT NOT NULL AUTO_INCREMENT,
  `emp_email` VARCHAR(45) NOT NULL,
  `id_role` INT NOT NULL,
  `password` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`id_employee`),
  UNIQUE INDEX `id_employee_UNIQUE` (`id_employee` ASC) VISIBLE,
  INDEX `id_role_idx` (`id_role` ASC) VISIBLE,
  CONSTRAINT `id_role`
    FOREIGN KEY (`id_role`)
    REFERENCES `carportdb`.`roles` (`id_role`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE `carportdb`.`orders` (
  `id_order` INT NOT NULL AUTO_INCREMENT,
  `build_adress` VARCHAR(45) NOT NULL,
  `build_zipcode` INT NOT NULL,
  `status` VARCHAR(45) NOT NULL,
  `width` INT NOT NULL,
  `length` INT NOT NULL,
  `incline` INT NOT NULL,
  `roof_tiles_id` INT NOT NULL DEFAULT 35,
  `shed_width` INT NULL,
  `shed_length` INT NULL,
  `shed_walls_id` INT NOT NULL DEFAULT 10,
  `shed_floor_id` INT NOT NULL DEFAULT 50,
  `customer_id` INT NOT NULL,
  `employee_id` INT NOT NULL,
  PRIMARY KEY (`id_order`),
  UNIQUE INDEX `id_order_UNIQUE` (`id_order` ASC) VISIBLE,
  INDEX `roof_tiles_id_idx` (`roof_tiles_id` ASC) VISIBLE,
  INDEX `shed_walls_id_idx` (`shed_walls_id` ASC) VISIBLE,
  INDEX `shed_floor_id_idx` (`shed_floor_id` ASC) VISIBLE,
  INDEX `customer_id_idx` (`customer_id` ASC) VISIBLE,
  INDEX `employee_id_idx` (`employee_id` ASC) VISIBLE,
  CONSTRAINT `roof_tiles_id`
    FOREIGN KEY (`roof_tiles_id`)
    REFERENCES `carportdb`.`materials` (`id_material`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `shed_walls_id`
    FOREIGN KEY (`shed_walls_id`)
    REFERENCES `carportdb`.`materials` (`id_material`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `shed_floor_id`
    FOREIGN KEY (`shed_floor_id`)
    REFERENCES `carportdb`.`materials` (`id_material`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `customer_id`
    FOREIGN KEY (`customer_id`)
    REFERENCES `carportdb`.`customers` (`id_customer`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `employee_id`
    FOREIGN KEY (`employee_id`)
    REFERENCES `carportdb`.`employees` (`id_employee`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

		
	
CREATE TABLE `carportdb`.`bills` (
  `id_bill` INT NOT NULL AUTO_INCREMENT,
  `retail_price` DOUBLE NOT NULL,
  `final_price` DOUBLE NOT NULL,
  `id_order` INT NOT NULL,
  PRIMARY KEY (`id_bill`),
  UNIQUE INDEX `id_bill_UNIQUE` (`id_bill` ASC) VISIBLE,
  INDEX `id_order_idx` (`id_order` ASC) VISIBLE,
  CONSTRAINT `id_order_bills`
    FOREIGN KEY (`id_order`)
    REFERENCES `carportdb`.`orders` (`id_order`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
