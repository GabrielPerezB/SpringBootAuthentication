CREATE DATABASE  IF NOT EXISTS `user_directory`;
USE `user_directory`;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `user`
--

INSERT INTO `user` VALUES 
	(1,'Leslie','Andrews','leslie@luv2code.com','1209050c7ee9b12762dc9059a9dac9fd'),
	(2,'Emma','Baumgarten','emma@luv2code.com','1209050c7ee9b12762dc9059a9dac9fd'),
	(3,'Avani','Gupta','avani@luv2code.com','1209050c7ee9b12762dc9059a9dac9fd'),
	(4,'Yuri','Petrov','yuri@luv2code.com','1209050c7ee9b12762dc9059a9dac9fd'),
	(5,'Juan','Vega','juan@luv2code.com','1209050c7ee9b12762dc9059a9dac9fd');
