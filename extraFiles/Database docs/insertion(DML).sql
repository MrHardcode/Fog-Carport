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
Creating 100 customers. This was generated here: https://www.generatedata.com/
Taking use of default values (auto_increment) for >id_customer<. */
ALTER TABLE `carportdb`.`customers` AUTO_INCREMENT = 1; /* Ensuring we start from 1*/
INSERT INTO `carportdb`.`customers` (`customer_name`,`phone`,`email`,`password`) VALUES ("Martina I. Nichols","31480889","Aliquam@Donecporttitortellus.edu","HGI02YDO3XL"),("Sawyer O. Preston","34096478","non.sapien.molestie@Vivamusmolestie.org","HVM14IKA3MG"),("Abra L. Stevens","78519352","in.consectetuer.ipsum@facilisis.com","WPQ41FQM8EL"),("Martena Stein","75970378","Quisque.porttitor@lectus.net","NAB32GVX5WC"),("Wayne Huff","87313984","Fusce.aliquam@etnuncQuisque.edu","DSY77EPS6MN"),("Garrett T. Walls","58016957","egestas.a@sitamet.net","JWG52ABV2IH"),("Teegan Carpenter","96017271","nisl.sem.consequat@rutrum.com","QNP94AHQ1KG"),("Mohammad Phillips","48094520","laoreet.posuere@dictumProineget.edu","SMV90DSA3DI"),("Jennifer Bishop","64259374","Ut.nec.urna@suscipitestac.org","ETE38QPM9YX"),("Xaviera K. Haney","95380334","convallis.est.vitae@Nunccommodo.net","WET84KYD4BI");
INSERT INTO `carportdb`.`customers` (`customer_name`,`phone`,`email`,`password`) VALUES ("Nissim C. Rice","96703179","ac.mattis.semper@sitamet.net","HSM48IFM9EL"),("Susan Page","64220806","ac.urna.Ut@temporaugue.org","KOP31IAG5JX"),("Allegra Howell","15102815","sem.egestas@non.org","WMJ11ZPE4TI"),("Paki R. Cline","08688913","Pellentesque.habitant@mattisvelitjusto.org","XIH28UCD3YY"),("Basil F. Carey","31882035","ipsum@quamelementum.org","ULF68ZRJ9XZ"),("Tarik Travis","38218615","aliquam@quam.edu","UPJ64LII1YE"),("Ingrid T. Richards","45533534","taciti.sociosqu.ad@enim.co.uk","TOM26UQY6KQ"),("Graiden Pugh","15704036","arcu.Aliquam@hendreritidante.ca","OOT92WWS8CU"),("Elvis W. Herrera","23221877","commodo@anteNuncmauris.ca","CWC96EZQ4LW"),("Lance Bright","73485413","libero@blandit.co.uk","FML61YDW1NP");
INSERT INTO `carportdb`.`customers` (`customer_name`,`phone`,`email`,`password`) VALUES ("Ezekiel K. Goff","16917504","vel.pede@utquamvel.edu","CAX82WAF8HO"),("Kadeem Z. Norris","46855089","ullamcorper.Duis.cursus@vulputate.net","HDE02OVV2JB"),("Madeline French","28574247","egestas.a@imperdietnec.co.uk","PJO26BXD2TU"),("Martina Cruz","91069254","Donec.luctus@sociisnatoquepenatibus.edu","MCZ97BER4GQ"),("Yoko Bruce","81979250","dolor.Donec@gravida.org","NMC17JMJ0IS"),("Dale Alexander","86363209","a.malesuada@nequesedsem.edu","TIW69ABJ3MN"),("Bertha S. Morin","93517638","Curabitur@mauris.org","GUA58QKE6XC"),("Sean Barry","72826706","ut.mi.Duis@scelerisque.edu","QBD45BBV9OE"),("Hollee Q. Madden","52368541","ipsum.primis@eueratsemper.ca","VCI00ZEQ0XZ"),("Colton M. Hammond","29495771","luctus.lobortis.Class@euodiotristique.ca","CDY29FPQ7GS");
INSERT INTO `carportdb`.`customers` (`customer_name`,`phone`,`email`,`password`) VALUES ("Donovan H. Wiggins","86655115","lorem@auctorMauris.org","HFV43XZA2CU"),("Shoshana Kemp","98557596","luctus.et.ultrices@sedpedenec.ca","QKF85OYQ2XU"),("Lester F. Green","89503270","eu@nonmagnaNam.org","TUP61VKO5LE"),("Dexter Hines","25731629","accumsan.convallis.ante@faucibuslectus.com","AAT63UBR0ZO"),("Xenos Rutledge","49818361","enim.Etiam@a.edu","WIN57NHI1MO"),("Noah Riddle","47520135","ipsum.porta@idantedictum.org","DSJ79ACK7FB"),("Davis F. Gutierrez","84038966","scelerisque.dui@Duisatlacus.org","CWE28PVZ6BD"),("Ivor Conner","86221941","Quisque@estMauriseu.co.uk","YIJ39FPA8HF"),("Faith S. Walsh","27131127","erat.vitae.risus@pretium.org","LUZ60LLI0GI"),("Uriel Serrano","29140753","in@viverraDonec.edu","GKR85FAX2IH");
INSERT INTO `carportdb`.`customers` (`customer_name`,`phone`,`email`,`password`) VALUES ("Lev N. Black","26003790","et.commodo@idrisusquis.ca","SYW72BBG2ZQ"),("Amir Schroeder","05739030","pretium.et@euismodestarcu.ca","KRW12CLO3VW"),("Coby N. Richmond","48508654","in@montesnascetur.co.uk","DPP33NQU4WQ"),("Rigel Q. Best","60905204","montes.nascetur.ridiculus@nulla.ca","ULN48VWP9CO"),("Troy Clements","13167849","a.ultricies@lorem.org","RED43RCK5MI"),("Xandra C. Burt","39057980","tellus@dictumauguemalesuada.net","OEZ23KEL6TN"),("Xander I. Simon","46111562","Nunc@sollicitudinamalesuada.com","ZNN40YEW6VY"),("Solomon A. Kirby","42106481","semper.Nam@ornaresagittisfelis.ca","TRG39EZO3JS"),("Amir C. Kim","58809340","scelerisque.lorem.ipsum@lobortisquis.ca","PGU76WFT8UF"),("Jerome Reese","97424366","sem@sociis.com","FED22DXY1QI");
INSERT INTO `carportdb`.`customers` (`customer_name`,`phone`,`email`,`password`) VALUES ("Chester Sharpe","10528455","est.vitae@Suspendissecommodotincidunt.com","YKM89YTO3SS"),("Macey H. Hendrix","47611464","nibh.sit.amet@Sednullaante.edu","ZCL19VQY8RE"),("Dacey Hyde","87523380","sit@ipsumporta.com","CGW94WAQ7BL"),("Malcolm I. Noble","72144846","luctus.aliquet@justosit.edu","LSH53FGJ7XH"),("Cyrus Wilkinson","92186906","eu.eleifend@sedorci.ca","WWA00HEI6KE"),("Montana S. Barry","49964978","Cum.sociis@ametrisusDonec.net","NPU77SIJ6WO"),("Karyn G. Long","51115036","magna.Lorem@primisinfaucibus.edu","GIJ46TWL8AY"),("Larissa C. Kelly","41689950","ullamcorper.velit.in@mollisvitae.co.uk","XPN48VOR6ZE"),("Lois Gardner","73261570","Proin.nisl.sem@Nullasempertellus.ca","TIS09EJL3XM"),("Halee Perkins","33995575","mauris@ultriciesdignissim.net","CUD52PGM5UI");
INSERT INTO `carportdb`.`customers` (`customer_name`,`phone`,`email`,`password`) VALUES ("Chastity F. Barber","92220257","dui.nec.urna@eu.edu","EIS19YWI1OX"),("Rogan Bush","31168701","erat@maurisMorbi.ca","WKM54DCD4CC"),("Sloane Coleman","84603715","elementum.lorem.ut@dictum.org","KSS79SJZ0JE"),("Jesse Graves","27466945","libero.Integer.in@sed.co.uk","SRJ69CRK0ZC"),("Chase Collins","81653781","amet@quamquis.ca","RJO76KWZ3HP"),("Sean Prince","66946908","aliquet.molestie@Nullam.co.uk","RXQ53ZPD5AD"),("Doris G. Burks","04638718","bibendum@luctusipsumleo.edu","TMT94MOK6KE"),("Lucius Lawson","25561123","semper@bibendumfermentum.com","BEQ73OKR5HH"),("Francesca Orr","10980887","sodales@sagittislobortismauris.edu","CCN18AQU9JM"),("Zeus Gay","93866504","non@et.co.uk","ZTB02NTC9WJ");
INSERT INTO `carportdb`.`customers` (`customer_name`,`phone`,`email`,`password`) VALUES ("Macy Mendoza","54087429","risus.a@euismodmauris.edu","WOV29NJV6UB"),("Basil T. Alexander","02181478","Proin@velit.net","TXQ92BPS3WV"),("Sara Dennis","27310815","In@vestibulum.ca","VYP06USR9ZQ"),("Sawyer Olsen","00986306","risus.Morbi@massarutrum.co.uk","BXJ57YDJ8AH"),("Oscar E. Duffy","42136273","turpis@condimentumegetvolutpat.co.uk","FCP08PBE9QN"),("Amaya Wilder","65477858","Donec.elementum@sagittis.ca","JWO97AUI9IN"),("Stone T. Hahn","51323140","sit.amet@duiFusce.com","TBS48FOI4ZS"),("Vaughan Logan","12429085","consectetuer@Duisdignissim.org","IVF93CCB8IO"),("Jessica Q. Byrd","47795584","vitae@dolornonummyac.co.uk","IQT02XQP7TY"),("Tanner S. Stein","52625793","sapien.molestie.orci@nonduinec.net","HVB72SDM1UJ");
INSERT INTO `carportdb`.`customers` (`customer_name`,`phone`,`email`,`password`) VALUES ("Portia Kidd","38912348","dolor@Donecestmauris.net","WEV11FZB3QJ"),("Evangeline Callahan","85486228","tristique@vulputate.co.uk","HRJ87YOQ2YF"),("Duncan Mcleod","45610030","sapien.Aenean.massa@enim.edu","YHZ87MFN0RN"),("Noble B. Mclean","00133505","augue.scelerisque.mollis@ac.edu","WOD74PZP6CN"),("Slade Berry","70201623","lobortis.nisi@augue.net","KCU55BMI1RS"),("Connor W. Foreman","86545609","volutpat@posuerecubilia.ca","GRI31EYT8AG"),("Hop Perez","66159634","at@vel.co.uk","WYA46ZYV8RB"),("Whoopi Haynes","65835763","pede.nonummy.ut@ligula.co.uk","AGX00INY0HS"),("Phoebe Murphy","87746825","rutrum.justo.Praesent@Duis.net","XOX87DXV2LD"),("Quincy Melendez","57512569","Donec.egestas@metus.net","KKP45HSK1ZJ");
INSERT INTO `carportdb`.`customers` (`customer_name`,`phone`,`email`,`password`) VALUES ("Raphael E. Barker","81093542","sapien@ante.net","BJG52CEK2CC"),("Janna Dawson","13820536","auctor@tincidunt.edu","DMQ33XES0JH"),("Bo Haney","18732549","mauris.aliquam@sitametrisus.edu","WPB87LZN8OA"),("Deanna X. Valdez","02664353","ridiculus@Phasellus.org","XJX06DIX5EL"),("Lamar U. Knight","30790702","odio.vel.est@commodoipsumSuspendisse.org","UKG59LCF8IO"),("Desiree Noel","57866498","lacinia@Integer.com","WGD79DYQ4JM"),("Pandora G. Peck","30474213","orci@amet.edu","CAZ43TGG2OZ"),("Daria Castaneda","51130965","est@diamnuncullamcorper.edu","SPK49XVG6EA"),("Allistair Kinney","22139219","sem.egestas@anteNunc.net","OAE27IBH4FD"),("Tashya K. Floyd","35146607","ridiculus.mus.Proin@dolor.edu","JIA85KBE7HI");


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
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`) VALUES ('25x200 mm. trykimp. Bræt', '25', '200', '3600', '37.25', 'Stk', '1');
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`) VALUES ('25x200 mm. trykimp. Bræt', '25', '200', '5400', '42.75', 'Stk', '1');
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`) VALUES ('25x125 mm. trykimp. Bræt', '25', '125', '3600', '36', 'Stk', '1');
INSERT INTO `carportdb`.`materials` (`description`, `height`, `width`, `length`, `cost_price`, `unit`, `id_category`) VALUES ('25x125 mm. trykimp. Bræt', '25', '125', '5400', '39.95', 'Stk', '1');

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
