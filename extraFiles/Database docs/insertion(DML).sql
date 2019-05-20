/*
This script should be run after running the (DDL) create.sql script.
*/
USE `carportdb`; 

/* 
Creating employee roles. 
Taking use of the default values (auto_increment) for >id_role<. */
ALTER TABLE `carportdb`.`roles` AUTO_INCREMENT = 1; /* Ensuring we start from 1*/
INSERT INTO `carportdb`.`roles` (`role`) VALUES ('admin');
INSERT INTO `carportdb`.`roles` (`role`) VALUES ('salesman');
INSERT INTO `carportdb`.`roles` (`role`) VALUES ('testrole');

/*
Creating employees. 
Taking use of default values (auto_increment) for >id_employee<. */
ALTER TABLE `carportdb`.`employees` AUTO_INCREMENT = 1; /* Ensuring we start from 1*/
INSERT INTO `carportdb`.`employees` (`emp_email`, `id_role`,`password`) VALUES ('admin@fog.dk', '1', '1234'); /* role: admin */
INSERT INTO `carportdb`.`employees` (`emp_email`, `id_role`,`password`) VALUES ('runi@fog.dk', '2', '1234'); /* role: salesman */
INSERT INTO `carportdb`.`employees` (`emp_email`, `id_role`,`password`) VALUES ('asger@fog.dk', '2', '1234'); /* role: salesman */
INSERT INTO `carportdb`.`employees` (`emp_email`, `id_role`,`password`) VALUES ('camilla@fog.dk', '2', '1234'); /* role: salesman */
INSERT INTO `carportdb`.`employees` (`emp_email`, `id_role`,`password`) VALUES ('malte@fog.dk', '2', '1234'); /* role: salesman */
INSERT INTO `carportdb`.`employees` (`emp_email`, `id_role`,`password`) VALUES ('test@fog.dk', '3', '1234'); /* role: testrole */


/*
Creating 100 customers. This was generated here: https://www.generatedata.com/
Taking use of default values (auto_increment) for >id_customer<. */
ALTER TABLE `carportdb`.`customers` AUTO_INCREMENT = 1; /* Ensuring we start from 1*/
INSERT INTO `carportdb`.`customers` (`customer_name`,`phone`,`email`,`password`, `registered`) VALUES ("Test Customer","1234","test@test","1234", true);


/*
Creating material categories.
Taking use of default values (auto_increment) for >id_category<. */
ALTER TABLE `carportdb`.`category` AUTO_INCREMENT = 1; /* Ensuring we start from 1*/
INSERT INTO `carportdb`.`category` (`category_name`) VALUES ('wood');
INSERT INTO `carportdb`.`category` (`category_name`) VALUES ('miscellaneous');
INSERT INTO `carportdb`.`category` (`category_name`) VALUES ('roof');

/*
Creating materials.
Done with help of the following example (including the Fog video):
https://datsoftlyngby.github.io/dat2sem2019Spring/Modul4/Fog/CAR01_HR.pdf
https://datsoftlyngby.github.io/dat2sem2019Spring/Modul4/Fog/CP01_DUR.pdf
All dimensions are measured in milimeters.
cost_price is the material cost for the company.
"unit" specifies whether the item is bundled or not.
category defines what part of the carport the material belongs to. 
Taking use of default values (auto_increment) for >id_material<. */
ALTER TABLE `carportdb`.`materials` AUTO_INCREMENT = 1; /* Ensuring we start from 1*/
/* wood (category 1) */
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`, `helptext_roof`) VALUES ('25x150mm trykimp. Bræt', '25', '150', '4800', '35', 'Stk', '1', 'Vindskeder på rejsning');
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`, `helptext_roof`) VALUES ('25x150mm. trykimp. Bræt', '25', '150', '5400', '40', 'Stk', '1', 'Sternbrædder til siderne');
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`, `helptext_roof`) VALUES ('25x150mm. trykimp. Bræt', '25', '150', '6000', '45', 'Stk', '1', 'Sternbrædder til siderne');
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`, `helptext_roof`) VALUES ('97x97 mm. trykimp. Stolpe', '97', '97', '3000', '65', 'Stk', '1', 'Stolper nedgraves 90 cm. i jord + skråstiver');
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`, `helptext_base`, `helptext_shed`) VALUES ('45x195 spærtræ ubh.', '45', '195', '4800', '32.75', 'Stk', '1', 'Remme i sider, sadles ned i stolper Carport del', 'Remme i sider, sadles ned i stolper Skur del');
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`, `helptext_shed`) VALUES ('45x95 Reglar ubh.', '45', '95', '2400', '22', 'Stk', '1', 'Løsholter i skur');
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`, `helptext_shed`) VALUES ('45x95 Reglar ubh.', '45', '95', '3600', '27.5', 'Stk', '1', 'Løsholter i skur');
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`, `helptext_roof`) VALUES ('19x100mm. trykimp. Bræt', '19', '100', '4800', '33', 'Stk', '1', 'Vand bræt på vindskeder');
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`, `helptext_roof`) VALUES ('19x100mm. trykimp. Bræt', '19', '100', '2400', '24', 'Stk', '1', 'Beklædning på gavle');
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`, `helptext_shed`) VALUES ('19x100mm. trykimp. Bræt', '19', '100', '2100', '21', 'Stk', '1', 'Beklædning på skur');
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`, `helptext_roof`) VALUES ('25x50 mm. trykimp. Bræt', '25', '50', '5400', '37', 'Stk', '1', 'Til montering oven på tagfodslægte');
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`, `helptext_shed`, `helptext_roof`) VALUES ('38x73 mm. taglægte T1', '38', '73', '5400', '39', 'Stk', '1', 'Til z på bagside af dør', 'Til montering på spær, lægter i rækker på hver skiftevis 1 hel & 1 halv lægte');
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`, `helptext_roof`) VALUES ('38x73 mm. taglægte T1', '38', '73', '4200', '36.5', 'Stk', '1', 'Toplægte til montering af rygsten. Lægges i toplægte holder');
/*INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`) VALUES ('38x73 mm. Lægte ubh.', '380', '730', '4200', '40', 'Stk', '1');*/ /* Added above, just different items on each BoM */
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`, `helptext_roof`) VALUES ('færdigskåret (byg-selv spær)', '0', '0', '0', '650', 'Sæt', '1', 'byg-selv spær (skal samles) 8 stk.');

/* miscellaneous (category 2) */
INSERT INTO `carportdb`.`materials` (`description`, `cost_price`, `unit`, `id_category`, `helptext_roof`) VALUES ('universal 190 mm højre', '2.25', 'Stk', '2', 'Til montering af spær på rem');
INSERT INTO `carportdb`.`materials` (`description`, `cost_price`, `unit`, `id_category`, `helptext_roof`) VALUES ('universal 190 mm venstre', '2.25', 'Stk', '2', 'Til montering af spær på rem');
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `cost_price`, `unit`, `id_category`, `helptext_shed`) VALUES ('Stalddørsgreb 50x75', '500', '750', '85', 'Sæt', '2', 'Til dør i skur');
INSERT INTO `carportdb`.`materials` (`description`, `width`, `cost_price`, `unit`, `id_category`, `helptext_shed`) VALUES ('T-hængsel 390mm', '390', '55.85', 'Stk', '2', 'Til dør i skur');
INSERT INTO `carportdb`.`materials` (`description`, `cost_price`, `unit`, `id_category`, `helptext_shed`) VALUES ('Vinkelbeslag', '12', 'Stk', '2', 'Til montering af løsholter');
INSERT INTO `carportdb`.`materials` (`description`, `cost_price`, `unit`, `id_category`, `helptext_roof`) VALUES ('4,5x60mm. Skruer (200 stk)', '115', 'Pakke', '2', 'Til montering af Stern, vindskeder, vindkryds & vand bræt');
INSERT INTO `carportdb`.`materials` (`description`, `cost_price`, `unit`, `id_category`, `helptext_roof`) VALUES ('5,0x40mm. Beslagskruer (250 stk)', '125', 'Pakke', '2', 'Til montering af universalbeslag + toplægte');
INSERT INTO `carportdb`.`materials` (`description`, `cost_price`, `unit`, `id_category`, `helptext_roof`) VALUES ('plastmo bundskruer (200 stk)', '85', 'Pakke', '2', 'Skruer til tagplader');
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`, `helptext_roof`) VALUES ('Hulbånd 1x20mm (10 mtr.)', '1', '20', '10000', '18.77', 'Rulle', '2', 'Til vindkryds på spær');
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `cost_price`, `unit`, `id_category`, `helptext_base`) VALUES ('Bræddebolt 10x120 mm.', '10', '120', '3.75', 'Stk', '2', 'Til montering af rem på stolper');
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`, `helptext_base`) VALUES ('Firkantskiver 40x40x11mm', '40', '40', '11', '5.25', 'Stk', '2', 'Til montering af rem på stolper');
INSERT INTO `carportdb`.`materials` (`description`, `cost_price`, `unit`, `id_category`, `helptext_shed`) VALUES ('4,5x70mm. skruer (400 stk)', '185', 'Pakke', '2', 'Til montering af yderste bræt ved beklædning');
INSERT INTO `carportdb`.`materials` (`description`, `cost_price`, `unit`, `id_category`, `helptext_shed`) VALUES ('4,5x50mm Skruer (300 stk)', '167.75', 'Pakke', '2', 'Til montering af inderste bræt ved beklædning');

/* roof (category 3) */
	/* Flat roof */
INSERT INTO `carportdb`.`materials` (`description`, `length`, `cost_price`, `unit`, `id_category`, `helptext_roof`) VALUES ('Plastmo Ecolite (Blåtonet)', '6000', '145', 'Stk', '3', 'Tagplader monteres på spær');
INSERT INTO `carportdb`.`materials` (`description`, `length`, `cost_price`, `unit`, `id_category`, `helptext_roof`) VALUES ('Plastmo Ecolite (Blåtonet)', '3600', '105', 'Stk', '3', 'Tagplader monteres på spær');
	/* Tilted roof */
INSERT INTO `carportdb`.`materials` (`description`, `cost_price`, `unit`, `id_category`, `helptext_roof`) VALUES ('B & C Toplægte holder', '25', 'Stk', '3', 'Monteres på toppen af spæret (til toplægte)');
INSERT INTO `carportdb`.`materials` (`description`, `cost_price`, `unit`, `id_category`, `helptext_roof`) VALUES ('B & C Rygstensbeslag', '8', 'Stk', '3', 'Til montering af rygsten');
INSERT INTO `carportdb`.`materials` (`description`, `cost_price`, `unit`, `id_category`, `helptext_roof`) VALUES ('B & C tagstens binder/nakkekrog (kombi)', '18.75', 'Pakke', '3', 'Til montering af tagsten, alle ydersten + hver anden fastgøres');
INSERT INTO `carportdb`.`materials` (`description`, `cost_price`, `unit`, `id_category`, `helptext_roof`) VALUES ('B & C Dobbelt Tagsten (Sort)', '15', 'Stk', '3', 'Monteres på taglægter');
INSERT INTO `carportdb`.`materials` (`description`, `cost_price`, `unit`, `id_category`, `helptext_roof`) VALUES ('B & C Dobbelt Tagsten (Grå)', '15', 'Stk', '3', 'Monteres på taglægter');
INSERT INTO `carportdb`.`materials` (`description`, `cost_price`, `unit`, `id_category`, `helptext_roof`) VALUES ('Eternit Tagsten(Teglrød)', '18', 'Stk', '3', 'Monteres på taglægter');
INSERT INTO `carportdb`.`materials` (`description`, `cost_price`, `unit`, `id_category`, `helptext_roof`) VALUES ('B & C Dobbelt Tagsten (Rød)', '15', 'Stk', '3', 'Monteres på taglægter');
INSERT INTO `carportdb`.`materials` (`description`, `cost_price`, `unit`, `id_category`, `helptext_roof`) VALUES ('B & C Dobbelt Tagsten (Blå)', '15', 'Stk', '3', 'Monteres på taglægter');
INSERT INTO `carportdb`.`materials` (`description`, `cost_price`, `unit`, `id_category`, `helptext_roof`) VALUES ('B & C Dobbelt Tagsten (Sortblå)', '15', 'Stk', '3', 'Monteres på taglægter');
INSERT INTO `carportdb`.`materials` (`description`, `cost_price`, `unit`, `id_category`, `helptext_roof`) VALUES ('B & C Dobbelt Tagsten (Sunlux)', '20', 'Stk', '3', 'Monteres på taglægter');
INSERT INTO `carportdb`.`materials` (`description`, `cost_price`, `unit`, `id_category`, `helptext_roof`) VALUES ('B & C Rygsten (Sort)', '20', 'Stk', '3', 'Monteres på toplægte med medfølgende beslag');
INSERT INTO `carportdb`.`materials` (`description`, `cost_price`, `unit`, `id_category`, `helptext_roof`) VALUES ('B & C Rygsten Tagsten (Grå)', '20', 'Stk', '3', 'Monteres på toplægte med medfølgende beslag');
INSERT INTO `carportdb`.`materials` (`description`, `cost_price`, `unit`, `id_category`, `helptext_roof`) VALUES ('Eternit Rygsten (Teglrød)', '22', 'Stk', '3', 'Monteres på toplægte med medfølgende beslag');
INSERT INTO `carportdb`.`materials` (`description`, `cost_price`, `unit`, `id_category`, `helptext_roof`) VALUES ('B & C Rygsten (Rød)', '23', 'Stk', '3', 'Monteres på toplægte med medfølgende beslag');
INSERT INTO `carportdb`.`materials` (`description`, `cost_price`, `unit`, `id_category`, `helptext_roof`) VALUES ('B & C Rygsten (Blå)', '20', 'Stk', '3', 'Monteres på toplægte med medfølgende beslag');
INSERT INTO `carportdb`.`materials` (`description`, `cost_price`, `unit`, `id_category`, `helptext_roof`) VALUES ('B & C Rygsten (Sortblå)', '20', 'Stk', '3', 'Monteres på toplægte med medfølgende beslag');
INSERT INTO `carportdb`.`materials` (`description`, `cost_price`, `unit`, `id_category`, `helptext_roof`) VALUES ('B & C Rygsten (Sunlux)', '25', 'Stk', '3', 'Monteres på toplægte med medfølgende beslag');

/*
Creating orders.
Taking use of default values (auto_increment) for >id_order<. 
*/
INSERT INTO `carportdb`.`orders` (`build_adress`, `build_zipcode`, `status`, `width`, `length`, `incline`, `roof_tiles_id`, `shed_walls_id`, `shed_floor_id`, `customer_id`, `employee_id`) VALUES ('Nørgaardsvej 30', '2800', 'Awaiting', '3100', '7200', '30', '37', '3', '3', '1', '3');
INSERT INTO `carportdb`.`orders` (`build_adress`, `build_zipcode`, `status`, `width`, `length`, `incline`, `roof_tiles_id`, `shed_walls_id`, `shed_floor_id`, `customer_id`, `employee_id`) VALUES ('Nørgaardsvej 30', '2800', 'Awaiting', '3100', '7200', '30', '37', '3', '3', '1', '4');
INSERT INTO `carportdb`.`orders` (`build_adress`, `build_zipcode`, `status`, `width`, `length`, `incline`, `roof_tiles_id`, `shed_walls_id`, `shed_floor_id`, `customer_id`, `employee_id`) VALUES ('Nørgaardsvej 30', '2800', 'Awaiting', '3100', '7200', '30', '37', '3', '3', '1', '5');
INSERT INTO `carportdb`.`orders` (`build_adress`, `build_zipcode`, `status`, `width`, `length`, `incline`, `roof_tiles_id`, `shed_walls_id`, `shed_floor_id`, `customer_id`, `employee_id`) VALUES ('Nørgaardsvej 30', '2800', 'Awaiting', '3100', '7200', '30', '37', '3', '3', '1', '5');

/*
Creating bills.
Taking use of default values (auto_increment) for >id_bill<. 
*/
INSERT INTO `carportdb`.`bills` (`retail_price`, `final_price`, `id_order`) VALUES ('15600', '23211.75', '1');
INSERT INTO `carportdb`.`bills` (`retail_price`, `final_price`, `id_order`) VALUES ('21000', '25995.95', '2');
INSERT INTO `carportdb`.`bills` (`retail_price`, `final_price`, `id_order`) VALUES ('7800', '9999.95', '3');
INSERT INTO `carportdb`.`bills` (`retail_price`, `final_price`, `id_order`) VALUES ('13273.44', '11849.99', '4');

/*
Updating custom dimensions 
(Added after creating script. The script was created with dimensions where available, rest is set by us).
*/
	/* Roof tiles */
UPDATE `carportdb`.`materials` SET `width` = '300', `length` = '420' WHERE (`id_material` = '33');
UPDATE `carportdb`.`materials` SET `width` = '1100', `length` = '570' WHERE (`id_material` = '35');
UPDATE `carportdb`.`materials` SET `width` = '865', `length` = '2000' WHERE (`id_material` = '39');
UPDATE `carportdb`.`materials` SET `width` = '310', `length` = '390' WHERE (`id_material` = '34');
UPDATE `carportdb`.`materials` SET `width` = '300', `length` = '420' WHERE (`id_material` = '36');
UPDATE `carportdb`.`materials` SET `width` = '300', `length` = '420' WHERE (`id_material` = '37');
UPDATE `carportdb`.`materials` SET `width` = '310', `length` = '390' WHERE (`id_material` = '38');
UPDATE `carportdb`.`materials` SET `width` = '160', `length` = '850' WHERE (`id_material` = '40');
UPDATE `carportdb`.`materials` SET `width` = '140', `length` = '400' WHERE (`id_material` = '41');
UPDATE `carportdb`.`materials` SET `width` = '160', `length` = '850' WHERE (`id_material` = '43');
UPDATE `carportdb`.`materials` SET `width` = '160', `length` = '850' WHERE (`id_material` = '44');
UPDATE `carportdb`.`materials` SET `width` = '140', `length` = '400' WHERE (`id_material` = '45');
UPDATE `carportdb`.`materials` SET `width` = '140', `length` = '400' WHERE (`id_material` = '46');
UPDATE `carportdb`.`materials` SET `width` = '180', `length` = '1200' WHERE (`id_material` = '42');

	/* Flat roof (plastic) parts */
UPDATE `carportdb`.`materials` SET `width` = '1090' WHERE (`id_material` = '28');
UPDATE `carportdb`.`materials` SET `width` = '1090' WHERE (`id_material` = '29');


/* 
Adding custom materials 
(These were not made by Fog, but by us. Or they were made by Fog, but found to be needed later.)
They are added here as to not mess with the current itemIDs.
*/

/* Tagpap related materials */
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`, `helptext_roof`) VALUES ('Tagpap', '0', '100', '5400', '85', 'Stk', '3', 'Sømmes fast i taget');
INSERT INTO `carportdb`.`materials` (`description`, `width`, `length`, `cost_price`, `unit`, `id_category`, `helptext_roof`) VALUES ('Tagpap', '100', '3600', '62.5', 'Stk', '3', 'Sømmes fast i taget');
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`, `helptext_roof`) VALUES ('Træplader (Til tagpap)', '0', '0', '0', '1500', 'Pakke', '3', 'Sømmes fast i taget');

/* Wooden floor planks */
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`, `helptext_shed`) VALUES ('30x200mm alm. planke (Eg)', '30', '200', '3600', '55', 'Stk', '1', 'Til gulvet i skuret');
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`, `helptext_shed`) VALUES ('30x250mm alm. planke (Eg)', '30', '250', '4800', '75', 'Stk', '1', 'Til gulvet i skuret');
/* More options for beklædning & gavl */
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`, `helptext_roof`) VALUES ('25x200mm alm. Bræt', '25', '200', '2400', '35', 'Stk', '3', 'Til gavlen');
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`, `helptext_roof`) VALUES ('25x200mm alm. Bræt', '25', '200', '3200', '47.5', 'Stk', '3', 'Til gavlen');

/* More options for remme & spær */
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`) VALUES ('45x195 spærtræ ubh.', '45', '195', '6000', '45', 'Stk', '1'); /*forgotten in initial push, adding here to avoid ID increment */
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`, `helptext_roof`) VALUES ('25x200 mm. trykimp. Bræt', '25', '200', '3600', '37.25', 'Stk', '1', 'Understernbrædder til for & bagende');
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`, `helptext_roof`) VALUES ('25x200 mm. trykimp. Bræt', '25', '200', '5400', '42.75', 'Stk', '1', 'Understernbrædder til siderne');
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`, `helptext_roof`) VALUES ('25x125 mm. trykimp. Bræt', '25', '125', '3600', '36', 'Stk', '1', 'Oversternbrædder til forendern');
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`, `helptext_roof`) VALUES ('25x125 mm. trykimp. Bræt', '25', '125', '5400', '39.95', 'Stk', '1', 'Oversternbrædder til siderne');

/* More options for vandbrædt */
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`, `helptext_roof`) VALUES ('19x100mm. trykimp. Bræt', '19', '100', '5400', '37', 'Stk', '1', 'Vand bræt på vindskeder');
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`, `helptext_roof`) VALUES ('19x100mm. trykimp. Bræt', '19', '100', '3600', '28', 'Stk', '1', 'Vand bræt på vindskeder');

/* More orders */
INSERT INTO `carportdb`.`orders` (`build_adress`, `build_zipcode`, `status`, `width`, `length`, `incline`, `roof_tiles_id`, `shed_walls_id`, `shed_floor_id`, `customer_id`, `employee_id`) VALUES ('Nørgaardsvej 30', '2800', 'Awaiting', '3100', '7200', '30', '28', '3', '3', '1', '4');
INSERT INTO `carportdb`.`orders` (`build_adress`, `build_zipcode`, `status`, `width`, `length`, `incline`, `roof_tiles_id`, `shed_walls_id`, `shed_floor_id`, `customer_id`, `employee_id`) VALUES ('Nørgaardsvej 30', '2800', 'Awaiting', '4100', '6500', '30', '28', '3', '3', '1', '4');
INSERT INTO `carportdb`.`orders` (`build_adress`, `build_zipcode`, `status`, `width`, `length`, `incline`, `roof_tiles_id`, `shed_walls_id`, `shed_floor_id`, `customer_id`, `employee_id`) VALUES ('Nørgaardsvej 30', '2800', 'Awaiting', '3500', '7100', '30', '28', '3', '3', '1', '4');
INSERT INTO `carportdb`.`orders` (`build_adress`, `build_zipcode`, `status`, `width`, `length`, `incline`, `roof_tiles_id`, `shed_walls_id`, `shed_floor_id`, `customer_id`, `employee_id`) VALUES ('Nørgaardsvej 30', '2800', 'Awaiting', '2800', '4200', '30', '29', '3', '3', '1', '4');
INSERT INTO `carportdb`.`orders` (`build_adress`, `build_zipcode`, `status`, `width`, `length`, `incline`, `roof_tiles_id`, `shed_walls_id`, `shed_floor_id`, `customer_id`, `employee_id`) VALUES ('Nørgaardsvej 30', '2800', 'Awaiting', '4100', '4100', '30', '29', '3', '3', '1', '4');
INSERT INTO `carportdb`.`orders` (`build_adress`, `build_zipcode`, `status`, `width`, `length`, `incline`, `roof_tiles_id`, `shed_walls_id`, `shed_floor_id`, `customer_id`, `employee_id`) VALUES ('Nørgaardsvej 30', '2800', 'Awaiting', '6500', '7200', '30', '29', '3', '3', '1', '4');
