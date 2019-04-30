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
INSERT INTO `carportdb`.`employees` (`emp_name`, `id_role`) VALUES ('admin', '1'); /* role: admin */
INSERT INTO `carportdb`.`employees` (`emp_name`, `id_role`) VALUES ('runi', '2'); /* role: salesman */
INSERT INTO `carportdb`.`employees` (`emp_name`, `id_role`) VALUES ('asger', '2'); /* role: salesman */
INSERT INTO `carportdb`.`employees` (`emp_name`, `id_role`) VALUES ('camilla', '2'); /* role: salesman */
INSERT INTO `carportdb`.`employees` (`emp_name`, `id_role`) VALUES ('malte', '2'); /* role: salesman */
INSERT INTO `carportdb`.`employees` (`emp_name`, `id_role`) VALUES ('test', '3'); /* role: testrole */


/*
Creating 50 customers. This was generated here: https://www.generatedata.com/
Taking use of default values (auto_increment) for >id_customer<. */
ALTER TABLE `carportdb`.`customers` AUTO_INCREMENT = 1; /* Ensuring we start from 1*/
INSERT INTO `carportdb`.`customers` (`customer_name`,`phone`,`email`) VALUES ("Amanda Whitney","84018351","molestie.arcu.Sed@acnulla.ca");
INSERT INTO `carportdb`.`customers` (`customer_name`,`phone`,`email`) VALUES ("Fleur S. Thomas","86012378","aliquet@orci.org");
INSERT INTO `carportdb`.`customers` (`customer_name`,`phone`,`email`) VALUES ("Reece Z. Hill","71197102","Morbi.non.sapien@diam.org");
INSERT INTO `carportdb`.`customers` (`customer_name`,`phone`,`email`) VALUES ("Len M. Huber","84472045","Fusce.aliquet.magna@telluseuaugue.ca");
INSERT INTO `carportdb`.`customers` (`customer_name`,`phone`,`email`) VALUES ("Paloma T. Mendoza","34034557","vitae@elitfermentumrisus.org");
INSERT INTO `carportdb`.`customers` (`customer_name`,`phone`,`email`) VALUES ("Reuben Richard","26935317","Aliquam.fringilla.cursus@Vivamuseuismod.edu");
INSERT INTO `carportdb`.`customers` (`customer_name`,`phone`,`email`) VALUES ("Hadley Adams","95844978","natoque@in.edu");
INSERT INTO `carportdb`.`customers` (`customer_name`,`phone`,`email`) VALUES ("Montana Bowen","49745906","enim@vulputatemaurissagittis.ca");
INSERT INTO `carportdb`.`customers` (`customer_name`,`phone`,`email`) VALUES ("Benjamin Q. Marsh","82884193","mollis.nec@Vivamusnon.org");
INSERT INTO `carportdb`.`customers` (`customer_name`,`phone`,`email`) VALUES ("Catherine Guerra","90965208","bibendum.fermentum.metus@nibhPhasellusnulla.org");
INSERT INTO `carportdb`.`customers` (`customer_name`,`phone`,`email`) VALUES ("Maya R. Berry","62379970","non@infaucibus.edu");
INSERT INTO `carportdb`.`customers` (`customer_name`,`phone`,`email`) VALUES ("Kimberly Chan","90779509","sit.amet.consectetuer@euerosNam.net");
INSERT INTO `carportdb`.`customers` (`customer_name`,`phone`,`email`) VALUES ("Judah Mcfarland","85996210","aliquet.molestie.tellus@Utsagittis.net");
INSERT INTO `carportdb`.`customers` (`customer_name`,`phone`,`email`) VALUES ("Armand J. Craft","51460179","fermentum.arcu.Vestibulum@arcuvelquam.co.uk");
INSERT INTO `carportdb`.`customers` (`customer_name`,`phone`,`email`) VALUES ("Kennedy O. Sampson","49958981","Integer.id@sitametornare.ca");
INSERT INTO `carportdb`.`customers` (`customer_name`,`phone`,`email`) VALUES ("Melodie Mccall","06848342","quam.quis.diam@lectusquis.com");
INSERT INTO `carportdb`.`customers` (`customer_name`,`phone`,`email`) VALUES ("Jordan V. Norman","83579772","et.commodo.at@consectetueradipiscing.org");
INSERT INTO `carportdb`.`customers` (`customer_name`,`phone`,`email`) VALUES ("Kellie Beach","66546216","rhoncus.Nullam@pretium.ca");
INSERT INTO `carportdb`.`customers` (`customer_name`,`phone`,`email`) VALUES ("Laura Alvarado","25643341","In@semperetlacinia.net");
INSERT INTO `carportdb`.`customers` (`customer_name`,`phone`,`email`) VALUES ("Iris Y. Preston","44686747","faucibus@id.ca");
INSERT INTO `carportdb`.`customers` (`customer_name`,`phone`,`email`) VALUES ("Addison Howe","29166434","Aliquam.erat@anteipsumprimis.ca");
INSERT INTO `carportdb`.`customers` (`customer_name`,`phone`,`email`) VALUES ("Hu Perkins","26589218","nec.tellus@urnanec.ca");
INSERT INTO `carportdb`.`customers` (`customer_name`,`phone`,`email`) VALUES ("Pascale J. Burris","49694491","vestibulum.lorem.sit@sodales.ca");
INSERT INTO `carportdb`.`customers` (`customer_name`,`phone`,`email`) VALUES ("Neville Garcia","42508492","Proin.eget@turpisvitaepurus.edu");
INSERT INTO `carportdb`.`customers` (`customer_name`,`phone`,`email`) VALUES ("India O. Chen","53776018","ultrices.mauris@elit.org");
INSERT INTO `carportdb`.`customers` (`customer_name`,`phone`,`email`) VALUES ("Herrod Gould","42773621","tellus@Aliquamadipiscing.co.uk");
INSERT INTO `carportdb`.`customers` (`customer_name`,`phone`,`email`) VALUES ("Thane Rodriguez","90549812","sit@ac.edu");
INSERT INTO `carportdb`.`customers` (`customer_name`,`phone`,`email`) VALUES ("Lynn Cleveland","77185650","lacus.Nulla@imperdietnec.net");
INSERT INTO `carportdb`.`customers` (`customer_name`,`phone`,`email`) VALUES ("Thor Hendrix","34099346","urna@duiCumsociis.co.uk");
INSERT INTO `carportdb`.`customers` (`customer_name`,`phone`,`email`) VALUES ("Jeremy W. Daniel","72585428","Quisque@parturientmontes.co.uk");
INSERT INTO `carportdb`.`customers` (`customer_name`,`phone`,`email`) VALUES ("Ella Z. Snider","67113516","facilisis.magna@luctus.co.uk");
INSERT INTO `carportdb`.`customers` (`customer_name`,`phone`,`email`) VALUES ("Kiona Hayes","54143752","arcu@mitemporlorem.co.uk");
INSERT INTO `carportdb`.`customers` (`customer_name`,`phone`,`email`) VALUES ("Raphael Johnston","88575765","turpis.In@nibhdolornonummy.net");
INSERT INTO `carportdb`.`customers` (`customer_name`,`phone`,`email`) VALUES ("Deanna M. Pierce","05514724","Donec.tempus@imperdiet.ca");
INSERT INTO `carportdb`.`customers` (`customer_name`,`phone`,`email`) VALUES ("Charity Mason","81100487","dui.nec@feugiatSednec.com");
INSERT INTO `carportdb`.`customers` (`customer_name`,`phone`,`email`) VALUES ("MacKenzie B. Pollard","25567965","vel.venenatis.vel@acnullaIn.edu");
INSERT INTO `carportdb`.`customers` (`customer_name`,`phone`,`email`) VALUES ("Odysseus Mendez","95188746","Quisque@dapibusrutrumjusto.net");
INSERT INTO `carportdb`.`customers` (`customer_name`,`phone`,`email`) VALUES ("Yoko Ramos","75706939","Cum.sociis@Suspendisse.ca");
INSERT INTO `carportdb`.`customers` (`customer_name`,`phone`,`email`) VALUES ("Paki Kaufman","97834879","dictum.eu.eleifend@quis.co.uk");
INSERT INTO `carportdb`.`customers` (`customer_name`,`phone`,`email`) VALUES ("Gail Oneill","34129211","libero.lacus@odio.net");
INSERT INTO `carportdb`.`customers` (`customer_name`,`phone`,`email`) VALUES ("Giacomo N. Gates","65186915","odio@Curae.net");
INSERT INTO `carportdb`.`customers` (`customer_name`,`phone`,`email`) VALUES ("Eugenia Luna","79348738","sem.consequat.nec@orciUtsemper.edu");
INSERT INTO `carportdb`.`customers` (`customer_name`,`phone`,`email`) VALUES ("Shaine Green","39956648","velit@Donecconsectetuer.edu");
INSERT INTO `carportdb`.`customers` (`customer_name`,`phone`,`email`) VALUES ("Noelle C. Mcclure","31061975","orci.Ut.sagittis@ornare.edu");
INSERT INTO `carportdb`.`customers` (`customer_name`,`phone`,`email`) VALUES ("Alisa Joyce","52862941","blandit.congue.In@convallisestvitae.co.uk");
INSERT INTO `carportdb`.`customers` (`customer_name`,`phone`,`email`) VALUES ("Timothy Holt","19637720","faucibus.lectus.a@vitaealiquet.edu");
INSERT INTO `carportdb`.`customers` (`customer_name`,`phone`,`email`) VALUES ("Mark F. Mcintosh","23588201","volutpat@sempereratin.com");
INSERT INTO `carportdb`.`customers` (`customer_name`,`phone`,`email`) VALUES ("Brady Lee","61205521","libero@vitaevelit.ca");
INSERT INTO `carportdb`.`customers` (`customer_name`,`phone`,`email`) VALUES ("Sara Cooley","64894674","elementum.dui@feugiatnon.ca");
INSERT INTO `carportdb`.`customers` (`customer_name`,`phone`,`email`) VALUES ("Gannon Walter","22660142","pede.Suspendisse@sedestNunc.ca");


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
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`) VALUES ('25x150mm trykimp. Bræt', '250', '1500', '4800', '35', 'Stk', '1');
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`) VALUES ('25x150mm. trykimp. Bræt', '250', '1500', '5400', '40', 'Stk', '1');
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`) VALUES ('25x150mm. trykimp. Bræt', '250', '1500', '6000', '45', 'Stk', '1');
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`) VALUES ('97x97 mm. trykimp. Stolpe', '970', '970', '3000', '65', 'Stk', '1');
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`) VALUES ('45x195 spærtre ubh.', '450', '1950', '4800', '32.75', 'Stk', '1');
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`) VALUES ('45x95 Reglar ubh.', '450', '950', '2400', '22', 'Stk', '1');
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`) VALUES ('45x95 Reglar ubh.', '450', '950', '3600', '27.5', 'Stk', '1');
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`) VALUES ('19x100mm. trykimp. Bræt', '190', '1000', '4800', '33', 'Stk', '1');
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`) VALUES ('19x100mm. trykimp. Bræt', '190', '1000', '2400', '24', 'Stk', '1');
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`) VALUES ('19x100mm. trykimp. Bræt', '190', '1000', '2100', '21', 'Stk', '1');
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`) VALUES ('25x50 mm. trykimp. Bræt', '250', '500', '5400', '37', 'Stk', '1');
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`) VALUES ('38x73 mm. taglægte T1', '380', '730', '5400', '39', 'Stk', '1');
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`) VALUES ('38x73 mm. taglægte T1', '380', '730', '4200', '36.5', 'Stk', '1');
/*INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`) VALUES ('38x73 mm. Lægte ubh.', '380', '730', '4200', '40', 'Stk', '1');*/ /* Added above, just different items on each BoM */
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`) VALUES ('færdigskåret (byg-selv spær)', '0', '0', '0', '40', 'Stk', '1');

/* miscellaneous (category 2) */
INSERT INTO `carportdb`.`materials` (`description`, `cost_price`, `unit`, `id_category`) VALUES ('universal 190 mm højre', '2.25', 'Stk', '2');
INSERT INTO `carportdb`.`materials` (`description`, `cost_price`, `unit`, `id_category`) VALUES ('universal 190 mm venstre', '2.25', 'Stk', '2');
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `cost_price`, `unit`, `id_category`) VALUES ('Stalddørsgreb 50x75', '500', '750', '85', 'Sæt', '2');
INSERT INTO `carportdb`.`materials` (`description`, `width`, `cost_price`, `unit`, `id_category`) VALUES ('T-hængsel 390mm', '390', '55.85', 'Stk', '2');
INSERT INTO `carportdb`.`materials` (`description`, `cost_price`, `unit`, `id_category`) VALUES ('Vinkelbeslag', '12', 'Stk', '2');
INSERT INTO `carportdb`.`materials` (`description`, `cost_price`, `unit`, `id_category`) VALUES ('4,5x60mm. Skruer (200 stk)', '115', 'Pakke', '2');
INSERT INTO `carportdb`.`materials` (`description`, `cost_price`, `unit`, `id_category`) VALUES ('5,0x40mm. Beslagskruer (250 stk)', '125', 'Pakke', '2');
INSERT INTO `carportdb`.`materials` (`description`, `cost_price`, `unit`, `id_category`) VALUES ('plastmo bundskruer (200 stk)', '85', 'Pakke', '2');
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`) VALUES ('Hulbånd 1x20mm (10 mtr.)', '10', '200', '10000', '18.77', 'Rulle', '2');
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `cost_price`, `unit`, `id_category`) VALUES ('Bræddebolt 10x120 mm.', '10', '120', '3.75', 'Stk', '2');
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`) VALUES ('Firkantskiver 40x40x11mm', '40', '40', '11', '5.25', 'Stk', '2');
INSERT INTO `carportdb`.`materials` (`description`, `cost_price`, `unit`, `id_category`) VALUES ('4,5x70mm. skruer (400 stk)', '185', 'Pakke', '2');
INSERT INTO `carportdb`.`materials` (`description`, `cost_price`, `unit`, `id_category`) VALUES ('4,5x50mm Skruer (300 stk)', '167.75', 'Pakke', '2');

/* roof (category 3) */
	/* Flat roof */
INSERT INTO `carportdb`.`materials` (`description`, `length`, `cost_price`, `unit`, `id_category`) VALUES ('Plastmo Ecolite (Blåtonet)', '6000', '145', 'Stk', '3');
INSERT INTO `carportdb`.`materials` (`description`, `length`, `cost_price`, `unit`, `id_category`) VALUES ('Plastmo Ecolite (Blåtonet)', '3600', '115', 'Stk', '3');
	/* Tilted roof */
INSERT INTO `carportdb`.`materials` (`description`, `cost_price`, `unit`, `id_category`) VALUES ('B & C Toplægte holder', '25', 'Stk', '3');
INSERT INTO `carportdb`.`materials` (`description`, `cost_price`, `unit`, `id_category`) VALUES ('B & C Rygstensbeslag', '8', 'Stk', '3');
INSERT INTO `carportdb`.`materials` (`description`, `cost_price`, `unit`, `id_category`) VALUES ('B & C tagstens binder/nakkekrog (kombi)', '18.75', 'Pakke', '3');
INSERT INTO `carportdb`.`materials` (`description`, `cost_price`, `unit`, `id_category`) VALUES ('B & C Dobbelt Tagsten (Sort)', '15', 'Stk', '3');
INSERT INTO `carportdb`.`materials` (`description`, `cost_price`, `unit`, `id_category`) VALUES ('B & C Dobbelt Tagsten (Grå)', '15', 'Stk', '3');
INSERT INTO `carportdb`.`materials` (`description`, `cost_price`, `unit`, `id_category`) VALUES ('Eternit Tagsten(Teglrød)', '18', 'Stk', '3');
INSERT INTO `carportdb`.`materials` (`description`, `cost_price`, `unit`, `id_category`) VALUES ('B & C Dobbelt Tagsten (Rød)', '15', 'Stk', '3');
INSERT INTO `carportdb`.`materials` (`description`, `cost_price`, `unit`, `id_category`) VALUES ('B & C Dobbelt Tagsten (Blå)', '15', 'Stk', '3');
INSERT INTO `carportdb`.`materials` (`description`, `cost_price`, `unit`, `id_category`) VALUES ('B & C Dobbelt Tagsten (Sortblå)', '15', 'Stk', '3');
INSERT INTO `carportdb`.`materials` (`description`, `cost_price`, `unit`, `id_category`) VALUES ('B & C Dobbelt Tagsten (Sunlux)', '20', 'Stk', '3');
INSERT INTO `carportdb`.`materials` (`description`, `cost_price`, `unit`, `id_category`) VALUES ('B & C Rygsten (Sort)', '20', 'Stk', '3');
INSERT INTO `carportdb`.`materials` (`description`, `cost_price`, `unit`, `id_category`) VALUES ('B & C Rygsten Tagsten (Grå)', '20', 'Stk', '3');
INSERT INTO `carportdb`.`materials` (`description`, `cost_price`, `unit`, `id_category`) VALUES ('Eternit Rygsten (Teglrød)', '22', 'Stk', '3');
INSERT INTO `carportdb`.`materials` (`description`, `cost_price`, `unit`, `id_category`) VALUES ('B & C Rygsten (Rød)', '23', 'Stk', '3');
INSERT INTO `carportdb`.`materials` (`description`, `cost_price`, `unit`, `id_category`) VALUES ('B & C Rygsten (Blå)', '20', 'Stk', '3');
INSERT INTO `carportdb`.`materials` (`description`, `cost_price`, `unit`, `id_category`) VALUES ('B & C Rygsten (Sortblå)', '20', 'Stk', '3');
INSERT INTO `carportdb`.`materials` (`description`, `cost_price`, `unit`, `id_category`) VALUES ('B & C Rygsten (Sunlux)', '25', 'Stk', '3');

/*
Creating orders.
Taking use of default values (auto_increment) for >id_order<. 
*/
INSERT INTO `carportdb`.`orders` (`build_adress`, `build_zipcode`, `status`, `width`, `length`, `incline`, `roof_tiles_id`, `shed_width`, `shed_length`, `shed_walls_id`, `shed_floor_id`, `customer_id`, `employee_id`) VALUES ('Roadson 1, 9', '2000', 'Processing', '3300', '6000', '0', '33', '2100', '2100', '1', '1', '1', '2');
INSERT INTO `carportdb`.`orders` (`build_adress`, `build_zipcode`, `status`, `width`, `length`, `incline`, `roof_tiles_id`, `shed_width`, `shed_length`, `shed_walls_id`, `shed_floor_id`, `customer_id`, `employee_id`) VALUES ('Roadson 2, 10', '2100', 'Accepted', '3000', '5700', '15', '34', '3000', '2100', '2', '2', '2', '3');
INSERT INTO `carportdb`.`orders` (`build_adress`, `build_zipcode`, `status`, `width`, `length`, `incline`, `roof_tiles_id`, `shed_width`, `shed_length`, `shed_walls_id`, `shed_floor_id`, `customer_id`, `employee_id`) VALUES ('Roadson 3, 11', '2200', 'Awaiting', '3600', '6300', '30', '35', '2900', '2500', '3', '3', '3', '4');
INSERT INTO `carportdb`.`orders` (`build_adress`, `build_zipcode`, `status`, `width`, `length`, `incline`, `roof_tiles_id`, `shed_width`, `shed_length`, `shed_walls_id`, `shed_floor_id`, `customer_id`, `employee_id`) VALUES ('Roadson 4, 12', '2300', 'Finalized', '5400', '7100', '45', '39', '5400', '7100', '4', '4', '4', '5');
INSERT INTO `carportdb`.`orders` (`build_adress`, `build_zipcode`, `status`, `width`, `length`, `incline`, `roof_tiles_id`, `shed_walls_id`, `shed_floor_id`, `customer_id`, `employee_id`) VALUES ('Nørgaardsvej 30', '2800', 'Awaiting', '3100', '7200', '30', '37', '3', '3', '6', '3');
INSERT INTO `carportdb`.`orders` (`build_adress`, `build_zipcode`, `status`, `width`, `length`, `incline`, `roof_tiles_id`, `shed_walls_id`, `shed_floor_id`, `customer_id`, `employee_id`) VALUES ('Nørgaardsvej 30', '2800', 'Awaiting', '3100', '7200', '30', '37', '3', '3', '6', '4');
INSERT INTO `carportdb`.`orders` (`build_adress`, `build_zipcode`, `status`, `width`, `length`, `incline`, `roof_tiles_id`, `shed_walls_id`, `shed_floor_id`, `customer_id`, `employee_id`) VALUES ('Nørgaardsvej 30', '2800', 'Awaiting', '3100', '7200', '30', '37', '3', '3', '6', '5');

/*
Creating bills.
Taking use of default values (auto_increment) for >id_bill<. 
*/
INSERT INTO `carportdb`.`bills` (`retail_price`, `final_price`, `id_order`) VALUES ('15600', '23211.75', '1');
INSERT INTO `carportdb`.`bills` (`retail_price`, `final_price`, `id_order`) VALUES ('21000', '25995.95', '2');
INSERT INTO `carportdb`.`bills` (`retail_price`, `final_price`, `id_order`) VALUES ('7800', '9999.95', '3');
INSERT INTO `carportdb`.`bills` (`retail_price`, `final_price`, `id_order`) VALUES ('13273.44', '11849.99', '4');
