DROP SCHEMA if EXISTS `carportdb`;
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
  `adress` VARCHAR(200) NOT NULL,
  `zipcode` INT NOT NULL,
  `phone` VARCHAR(20) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id_customer`),
  UNIQUE INDEX `id_customer_UNIQUE` (`id_customer` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE);

CREATE TABLE `carportdb`.`order_details_category` (
  `id_order_details_category` INT NOT NULL AUTO_INCREMENT,
  `details_category_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_order_details_category`),
  UNIQUE INDEX `id_order_details_category_UNIQUE` (`id_order_details_category`));

CREATE TABLE `carportdb`.`materials` (
  `id_material` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(200) NOT NULL,
  `helptext` MEDIUMTEXT NULL,
  `height` INT NULL,
  `width` INT NULL,
  `length` INT NULL,
  `cost price` DOUBLE NOT NULL,
  `unit` VARCHAR(45) NOT NULL,
  `id_category` INT NOT NULL,
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
  `emp_name` VARCHAR(45) NOT NULL,
  `id_role` INT NOT NULL,
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
  `status` VARCHAR(45) NOT NULL DEFAULT 'accepted',
  `order_width` INT NOT NULL,
  `order_length` INT NOT NULL,
  `incline` INT NOT NULL DEFAULT 0,
  `id_customer` INT NOT NULL,
  `id_employee` INT NOT NULL,
  PRIMARY KEY (`id_order`),
  UNIQUE INDEX `id_order_UNIQUE` (`id_order` ASC) VISIBLE,
  INDEX `id_customer_idx` (`id_customer` ASC) VISIBLE,
  INDEX `id_employee_idx` (`id_employee` ASC) VISIBLE,
  CONSTRAINT `id_customer`
    FOREIGN KEY (`id_customer`)
    REFERENCES `carportdb`.`customers` (`id_customer`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `id_employee`
    FOREIGN KEY (`id_employee`)
    REFERENCES `carportdb`.`employees` (`id_employee`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
	
CREATE TABLE `carportdb`.`order_details` (
  `id_order_detail` INT NOT NULL AUTO_INCREMENT,
  `id_material` INT NOT NULL,
  `id_order` INT NOT NULL,
  `id_order_detail_category` INT NOT NULL,
  PRIMARY KEY (`id_order_detail`),
  UNIQUE INDEX `id_order_detail_UNIQUE` (`id_order_detail` ASC) VISIBLE,
  INDEX `id_material_idx` (`id_material` ASC) VISIBLE,
  INDEX `id_order_idx` (`id_order` ASC) VISIBLE,
  INDEX `id_order_detail_category_idx` (`id_order_detail_category` ASC) VISIBLE,
  CONSTRAINT `id_material`
    FOREIGN KEY (`id_material`)
    REFERENCES `carportdb`.`materials` (`id_material`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `id_order`
    FOREIGN KEY (`id_order`)
    REFERENCES `carportdb`.`orders` (`id_order`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `id_order_detail_category`
    FOREIGN KEY (`id_order_detail_category`)
    REFERENCES `carportdb`.`order_details_category` (`id_order_details_category`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
		
CREATE TABLE `carportdb`.`bills` (
  `id_bill` INT NOT NULL AUTO_INCREMENT,
  `retail price` DOUBLE NOT NULL,
  `final price` DOUBLE NOT NULL,
  `id_order` INT NOT NULL,
  PRIMARY KEY (`id_bill`),
  UNIQUE INDEX `id_bill_UNIQUE` (`id_bill` ASC) VISIBLE,
  INDEX `id_order_idx` (`id_order` ASC) VISIBLE,
  CONSTRAINT `id_order_bills`
    FOREIGN KEY (`id_order`)
    REFERENCES `carportdb`.`orders` (`id_order`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
