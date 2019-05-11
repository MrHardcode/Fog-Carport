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
INSERT INTO `customers` (`customer_name`,`phone`,`email`,`password`) VALUES ("Sage S. Wells","05 51 03 56 01","magna@semut.com","875"),("Barclay Ramirez","04 85 00 45 22","nunc.nulla@Pellentesque.ca","900"),("Ava Watkins","04 38 54 12 50","aliquet.libero@lectusNullam.net","894"),("Teegan Bowers","06 41 06 28 48","velit.Cras@ametdiameu.edu","587"),("Noelani R. Sullivan","01 28 82 63 55","nonummy@et.ca","858"),("Abel B. Bray","06 49 18 36 30","sem.egestas@dolordolortempus.co.uk","879"),("Chloe Y. Wolfe","09 57 97 71 82","ipsum.primis@non.edu","812"),("Jael Waller","06 31 75 77 15","Morbi.sit.amet@quispedePraesent.net","419"),("Jacob I. Wilder","09 69 16 50 64","Fusce.feugiat.Lorem@Donec.ca","826"),("Ross Reed","02 90 08 38 20","tortor@nibh.co.uk","640");
INSERT INTO `customers` (`customer_name`,`phone`,`email`,`password`) VALUES ("Octavia K. Roth","05 61 00 48 25","accumsan@Cras.net","513"),("Harper Q. Mckee","02 27 40 87 68","nec@mifelis.org","512"),("Teagan N. Wright","08 78 68 27 01","Quisque.purus@necmollis.co.uk","709"),("Kirestin Mcmillan","07 33 39 29 49","mollis.Duis.sit@eteuismod.co.uk","123"),("Hall Shepherd","07 68 83 09 24","Duis.risus@tellusfaucibusleo.ca","154"),("Brianna Russo","09 21 09 06 52","inceptos.hymenaeos@maurissagittis.com","581"),("Jenna Sharp","03 32 58 09 36","at@euaugue.co.uk","244"),("Igor Peterson","05 78 99 99 39","ipsum@nislNulla.co.uk","255"),("Adara Tucker","08 93 00 00 33","lacus@aliquetodioEtiam.edu","286"),("Gail A. Davidson","07 77 67 58 64","Duis.cursus.diam@Donectemporest.ca","499");
INSERT INTO `customers` (`customer_name`,`phone`,`email`,`password`) VALUES ("Yuri U. Reilly","06 63 81 02 45","Vivamus.nibh.dolor@Cumsociis.net","165"),("Cairo X. Rasmussen","03 10 42 84 88","tristique.senectus@egestasascelerisque.edu","808"),("Winter E. Bryan","05 69 39 96 10","erat@Duiscursusdiam.edu","969"),("Ivory Y. Lara","04 18 85 76 32","rhoncus.Proin.nisl@euplacerateget.co.uk","182"),("Elliott Randall","08 29 43 69 18","aliquet.magna.a@mauriserateget.ca","632"),("Ethan Y. Suarez","07 22 83 28 75","ac.mattis.velit@nonnisi.ca","181"),("Candice Ayala","06 80 74 20 46","accumsan.convallis.ante@ultricesmauris.ca","486"),("Leah Fleming","06 82 62 48 59","Fusce.dolor@dictumeueleifend.net","716"),("Lucy S. Fitzgerald","02 98 40 42 15","enim.Suspendisse@primis.net","206"),("Prescott Z. Holman","08 19 16 97 75","non.bibendum@eutellusPhasellus.co.uk","988");
INSERT INTO `customers` (`customer_name`,`phone`,`email`,`password`) VALUES ("Keely P. Oneil","06 99 85 98 56","dui.Cras.pellentesque@IncondimentumDonec.com","396"),("Zia L. Petty","04 98 72 70 14","elementum@Etiamvestibulummassa.com","970"),("Lareina O. Hurst","05 23 37 73 17","ac.tellus.Suspendisse@pede.com","889"),("Galvin V. Farmer","07 79 36 13 24","Nulla.eget@magnaCras.edu","291"),("Gillian Silva","01 07 58 58 64","Suspendisse@Namnullamagna.edu","558"),("Joseph C. Terry","08 58 56 26 82","arcu.Sed@enimSednulla.org","748"),("Quentin Williams","09 71 55 01 76","enim.sit@Maurisut.edu","170"),("Aphrodite L. Shepherd","01 61 27 81 44","Etiam.ligula@Cumsociis.org","370"),("Victor U. Woodward","07 85 45 03 15","arcu.Morbi.sit@lectusrutrum.edu","167"),("Sade Q. Brady","08 30 91 37 51","Morbi@pharetra.org","885");
INSERT INTO `customers` (`customer_name`,`phone`,`email`,`password`) VALUES ("Denton Yates","02 67 50 27 57","lacinia@fermentum.edu","900"),("Caesar V. Melendez","05 55 63 20 72","mauris@eratvitae.co.uk","570"),("Shea F. Richardson","04 93 77 17 26","fermentum.arcu@seddolor.com","398"),("Wang Roth","03 45 93 68 77","ac.fermentum.vel@litora.org","610"),("Mariko A. Acevedo","01 71 54 83 88","ipsum.dolor.sit@euarcu.edu","582"),("Alfonso E. Golden","06 77 18 43 68","at.pede@venenatisvel.edu","442"),("Stewart B. Hoover","07 23 63 67 40","nec@semut.org","191"),("Reese Q. Alexander","03 16 50 14 45","massa@iaculisquispede.org","716"),("Timothy Baldwin","01 90 97 19 91","mauris.ipsum.porta@elitEtiam.com","587"),("Jakeem N. Mills","08 19 27 40 65","tellus.Aenean@convallisincursus.com","366");
INSERT INTO `customers` (`customer_name`,`phone`,`email`,`password`) VALUES ("Kasper J. Pruitt","03 44 42 65 73","ut@euduiCum.org","215"),("Brendan Baker","01 03 90 41 89","sollicitudin@enimconsequatpurus.ca","641"),("Rylee Morrison","08 04 90 13 81","non.massa.non@at.ca","175"),("Amela Massey","06 95 32 88 68","tempus.eu@amet.edu","185"),("Adrienne K. Medina","06 89 52 76 28","risus@Integerinmagna.com","713"),("Tyrone Larson","07 82 53 14 58","lacus.Ut@orci.edu","696"),("Portia Riddle","07 55 17 38 94","ornare@dolortempusnon.net","255"),("Ulysses Mendoza","09 00 54 22 80","ac.turpis.egestas@atarcu.edu","200"),("Flavia Leonard","05 56 69 52 36","hendrerit.neque.In@esttemporbibendum.com","413"),("Donovan Pickett","07 97 35 98 07","Suspendisse@adipiscing.com","350");
INSERT INTO `customers` (`customer_name`,`phone`,`email`,`password`) VALUES ("Clayton Sanford","06 75 61 13 35","facilisis.facilisis@nonvestibulumnec.ca","188"),("Irma P. Hodge","07 02 14 59 69","orci.luctus@pulvinar.com","699"),("Quamar W. Lopez","01 61 20 62 83","convallis.dolor@Vivamusnonlorem.co.uk","321"),("Shaine Sharp","04 87 53 19 90","convallis@turpisnec.org","967"),("Linus Mcclure","06 94 33 46 88","Mauris.nulla@mifelis.net","879"),("Elvis B. Duncan","08 89 61 71 52","eleifend@Aeneangravida.net","769"),("Abdul Foreman","02 13 01 86 26","velit@feugiatnonlobortis.edu","715"),("Ray A. Skinner","02 45 48 49 26","sem.elit@adipiscingnon.org","939"),("Suki F. Foster","01 33 41 39 14","ligula.Nullam.feugiat@ipsumCurabiturconsequat.com","139"),("Anika Simmons","05 42 05 71 74","nulla@Nullamvelit.org","771");
INSERT INTO `customers` (`customer_name`,`phone`,`email`,`password`) VALUES ("Tanek Bray","05 25 81 78 22","Vivamus.non@Duis.net","825"),("Gisela Bailey","09 89 63 09 56","justo.Praesent.luctus@eget.org","929"),("Unity E. Gilliam","06 22 27 07 65","ac@consectetuer.edu","342"),("Thane Stephenson","01 94 69 65 08","aliquet.metus@cubilia.net","223"),("Tucker R. Phillips","01 08 85 27 80","felis.Donec@in.edu","539"),("Kai M. Shelton","05 13 47 57 98","Donec.elementum.lorem@eliteratvitae.ca","813"),("Louis Sherman","08 27 67 80 97","neque.In.ornare@consectetuermauris.org","554"),("Trevor Farmer","02 22 37 81 64","nunc.risus.varius@acmattissemper.org","620"),("Idola Serrano","04 43 99 02 13","vehicula.et@posuere.ca","530"),("Isadora W. Tate","02 65 12 69 89","lorem.sit.amet@ornare.co.uk","142");
INSERT INTO `customers` (`customer_name`,`phone`,`email`,`password`) VALUES ("Tasha Maynard","01 13 55 78 97","quis.diam.Pellentesque@lobortisauguescelerisque.com","875"),("Aaron Dunlap","03 31 81 19 04","volutpat.nunc.sit@arcu.edu","635"),("Herman Bowers","02 07 32 34 52","lacus@convallis.edu","673"),("Hanae Y. Hall","05 81 89 68 62","cursus.purus@lacusQuisqueimperdiet.com","940"),("Lucian Bryant","04 90 84 19 88","Suspendisse.aliquet@Maecenasmalesuada.com","709"),("Adrienne J. Buchanan","02 11 09 34 85","Nunc@suscipitest.net","386"),("Hayfa Gill","03 31 36 43 80","arcu.Aliquam@dolortempus.com","637"),("Brooke Marshall","05 71 55 34 07","ut.aliquam@erat.net","854"),("Maryam N. Cohen","07 14 97 39 11","feugiat.tellus@Pellentesquetincidunt.org","475"),("Galena T. Banks","06 67 25 50 57","massa.Mauris.vestibulum@Donec.net","940");
INSERT INTO `customers` (`customer_name`,`phone`,`email`,`password`) VALUES ("Fay Hays","04 28 75 67 13","Duis.at@eu.com","204"),("Dara Kirkland","06 09 14 24 30","sem@Aliquamnecenim.net","553"),("Cameran S. Pacheco","03 13 81 13 55","eleifend.nec@habitantmorbitristique.ca","639"),("Hedwig Rush","02 44 00 10 04","turpis.egestas@Maurisblanditenim.org","415"),("Rinah H. Higgins","02 30 02 98 25","sem.molestie@nonleoVivamus.net","520"),("Stone Nunez","07 49 37 68 20","Praesent@Nam.com","518"),("Emily W. Wall","02 86 62 76 31","Nullam.lobortis.quam@vestibulumneque.com","184"),("Isadora Thornton","01 84 16 43 24","diam.Duis@Fusce.ca","235"),("Peter H. Curry","04 13 09 58 68","hendrerit.Donec.porttitor@Etiam.edu","457"),("Abdul P. Sargent","09 06 74 36 02","in.magna@ridiculusmusProin.ca","213");


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
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`) VALUES ('25x150mm trykimp. Bræt', '25', '150', '4800', '35', 'Stk', '1');
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`) VALUES ('25x150mm. trykimp. Bræt', '25', '150', '5400', '40', 'Stk', '1');
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`) VALUES ('25x150mm. trykimp. Bræt', '25', '150', '6000', '45', 'Stk', '1');
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`) VALUES ('97x97 mm. trykimp. Stolpe', '97', '97', '3000', '65', 'Stk', '1');
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`) VALUES ('45x195 spærtræ ubh.', '45', '195', '4800', '32.75', 'Stk', '1');
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`) VALUES ('45x95 Reglar ubh.', '45', '95', '2400', '22', 'Stk', '1');
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`) VALUES ('45x95 Reglar ubh.', '45', '95', '3600', '27.5', 'Stk', '1');
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`) VALUES ('19x100mm. trykimp. Bræt', '19', '100', '4800', '33', 'Stk', '1');
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`) VALUES ('19x100mm. trykimp. Bræt', '19', '100', '2400', '24', 'Stk', '1');
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`) VALUES ('19x100mm. trykimp. Bræt', '19', '100', '2100', '21', 'Stk', '1');
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`) VALUES ('25x50 mm. trykimp. Bræt', '25', '50', '5400', '37', 'Stk', '1');
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`) VALUES ('38x73 mm. taglægte T1', '38', '73', '5400', '39', 'Stk', '1');
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`) VALUES ('38x73 mm. taglægte T1', '38', '73', '4200', '36.5', 'Stk', '1');
/*INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`) VALUES ('38x73 mm. Lægte ubh.', '380', '730', '4200', '40', 'Stk', '1');*/ /* Added above, just different items on each BoM */
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`) VALUES ('færdigskåret (byg-selv spær)', '0', '0', '0', '650', 'Stk', '1');

/* miscellaneous (category 2) */
INSERT INTO `carportdb`.`materials` (`description`, `cost_price`, `unit`, `id_category`) VALUES ('universal 190 mm højre', '2.25', 'Stk', '2');
INSERT INTO `carportdb`.`materials` (`description`, `cost_price`, `unit`, `id_category`) VALUES ('universal 190 mm venstre', '2.25', 'Stk', '2');
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `cost_price`, `unit`, `id_category`) VALUES ('Stalddørsgreb 50x75', '500', '750', '85', 'Sæt', '2');
INSERT INTO `carportdb`.`materials` (`description`, `width`, `cost_price`, `unit`, `id_category`) VALUES ('T-hængsel 390mm', '390', '55.85', 'Stk', '2');
INSERT INTO `carportdb`.`materials` (`description`, `cost_price`, `unit`, `id_category`) VALUES ('Vinkelbeslag', '12', 'Stk', '2');
INSERT INTO `carportdb`.`materials` (`description`, `cost_price`, `unit`, `id_category`) VALUES ('4,5x60mm. Skruer (200 stk)', '115', 'Pakke', '2');
INSERT INTO `carportdb`.`materials` (`description`, `cost_price`, `unit`, `id_category`) VALUES ('5,0x40mm. Beslagskruer (250 stk)', '125', 'Pakke', '2');
INSERT INTO `carportdb`.`materials` (`description`, `cost_price`, `unit`, `id_category`) VALUES ('plastmo bundskruer (200 stk)', '85', 'Pakke', '2');
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`) VALUES ('Hulbånd 1x20mm (10 mtr.)', '1', '20', '10000', '18.77', 'Rulle', '2');
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `cost_price`, `unit`, `id_category`) VALUES ('Bræddebolt 10x120 mm.', '10', '120', '3.75', 'Stk', '2');
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`) VALUES ('Firkantskiver 40x40x11mm', '40', '40', '11', '5.25', 'Stk', '2');
INSERT INTO `carportdb`.`materials` (`description`, `cost_price`, `unit`, `id_category`) VALUES ('4,5x70mm. skruer (400 stk)', '185', 'Pakke', '2');
INSERT INTO `carportdb`.`materials` (`description`, `cost_price`, `unit`, `id_category`) VALUES ('4,5x50mm Skruer (300 stk)', '167.75', 'Pakke', '2');

/* roof (category 3) */
	/* Flat roof */
INSERT INTO `carportdb`.`materials` (`description`, `length`, `cost_price`, `unit`, `id_category`) VALUES ('Plastmo Ecolite (Blåtonet)', '6000', '145', 'Stk', '3');
INSERT INTO `carportdb`.`materials` (`description`, `length`, `cost_price`, `unit`, `id_category`) VALUES ('Plastmo Ecolite (Blåtonet)', '3600', '105', 'Stk', '3');
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
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`) VALUES ('Tagpap', '0', '100', '5400', '85', 'Stk', '3');
INSERT INTO `carportdb`.`materials` (`description`, `width`, `length`, `cost_price`, `unit`, `id_category`) VALUES ('Tagpap', '100', '3600', '62.5', 'Stk', '3');
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`) VALUES ('Træplader (Til tagpap)', '0', '0', '0', '1500', 'Pakke', '3');

/* Wooden floor planks */
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`) VALUES ('30x200mm alm. planke (Eg)', '30', '200', '3600', '55', 'Stk', '1');
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`) VALUES ('30x250mm alm. planke (Eg)', '30', '250', '4800', '75', 'Stk', '1');
/* More options for beklædning & gavl */
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`) VALUES ('25x200mm alm. Bræt', '25', '200', '2400', '35', 'Stk', '3');
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`) VALUES ('25x200mm alm. Bræt', '25', '200', '3200', '47.5', 'Stk', '3');

/* More options for remme & spær */
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`) VALUES ('45x195 spærtræ ubh.', '45', '195', '6000', '45', 'Stk', '1'); /*forgotten in initial push, adding here to avoid ID increment */
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`) VALUES ('25x200 mm. trykimp. Brædt', '25', '200', '3600', '37.25', 'Stk', '1');
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`) VALUES ('25x200 mm. trykimp. Brædt', '25', '200', '5400', '42.75', 'Stk', '1');
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`) VALUES ('25x125 mm. trykimp. Brædt', '25', '125', '3600', '36', 'Stk', '1');
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`) VALUES ('25x125 mm. trykimp. Brædt', '25', '125', '5400', '39.95', 'Stk', '1');

/* More options for vandbrædt */
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`) VALUES ('19x100mm. trykimp. Bræt', '19', '100', '5400', '37', 'Stk', '1');
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`) VALUES ('19x100mm. trykimp. Bræt', '19', '100', '3600', '28', 'Stk', '1');

/* More orders */
INSERT INTO `carportdb`.`orders` (`build_adress`, `build_zipcode`, `status`, `width`, `length`, `incline`, `roof_tiles_id`, `shed_walls_id`, `shed_floor_id`, `customer_id`, `employee_id`) VALUES ('Nørgaardsvej 30', '2800', 'Awaiting', '3100', '7200', '30', '28', '3', '3', '6', '4');
INSERT INTO `carportdb`.`orders` (`build_adress`, `build_zipcode`, `status`, `width`, `length`, `incline`, `roof_tiles_id`, `shed_walls_id`, `shed_floor_id`, `customer_id`, `employee_id`) VALUES ('Nørgaardsvej 30', '2800', 'Awaiting', '4100', '6500', '30', '28', '3', '3', '6', '4');
INSERT INTO `carportdb`.`orders` (`build_adress`, `build_zipcode`, `status`, `width`, `length`, `incline`, `roof_tiles_id`, `shed_walls_id`, `shed_floor_id`, `customer_id`, `employee_id`) VALUES ('Nørgaardsvej 30', '2800', 'Awaiting', '3500', '7100', '30', '28', '3', '3', '6', '4');
INSERT INTO `carportdb`.`orders` (`build_adress`, `build_zipcode`, `status`, `width`, `length`, `incline`, `roof_tiles_id`, `shed_walls_id`, `shed_floor_id`, `customer_id`, `employee_id`) VALUES ('Nørgaardsvej 30', '2800', 'Awaiting', '2800', '4200', '30', '29', '3', '3', '6', '4');
INSERT INTO `carportdb`.`orders` (`build_adress`, `build_zipcode`, `status`, `width`, `length`, `incline`, `roof_tiles_id`, `shed_walls_id`, `shed_floor_id`, `customer_id`, `employee_id`) VALUES ('Nørgaardsvej 30', '2800', 'Awaiting', '4100', '4100', '30', '29', '3', '3', '6', '4');
INSERT INTO `carportdb`.`orders` (`build_adress`, `build_zipcode`, `status`, `width`, `length`, `incline`, `roof_tiles_id`, `shed_walls_id`, `shed_floor_id`, `customer_id`, `employee_id`) VALUES ('Nørgaardsvej 30', '2800', 'Awaiting', '6500', '7200', '30', '29', '3', '3', '6', '4');