-- MySQL dump 10.13  Distrib 5.6.23, for Win64 (x86_64)
--
-- Host: 104.196.32.167    Database: movie_gallery_db
-- ------------------------------------------------------
-- Server version	5.7.25-google-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--

SET @@GLOBAL.GTID_PURGED='519c01ce-dc46-11ea-9572-42010a8e0092:1-1125577';

--
-- Table structure for table `LikedMoviesUsers`
--

DROP TABLE IF EXISTS `LikedMoviesUsers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `LikedMoviesUsers` (
  `INT` int(11) NOT NULL AUTO_INCREMENT,
  `movie_id` mediumint(8) unsigned NOT NULL,
  `user_id` int(11) NOT NULL,
  `creation_date` datetime DEFAULT NULL,
  PRIMARY KEY (`INT`),
  KEY `LikedMoviesUsers_FK` (`movie_id`),
  KEY `LikedMoviesUsers_FK_1` (`user_id`),
  CONSTRAINT `LikedMoviesUsers_FK` FOREIGN KEY (`movie_id`) REFERENCES `Movie` (`id`),
  CONSTRAINT `LikedMoviesUsers_FK_1` FOREIGN KEY (`user_id`) REFERENCES `User` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `Movie`
--

DROP TABLE IF EXISTS `Movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Movie` (
  `id` mediumint(8) unsigned NOT NULL AUTO_INCREMENT,
  `tittle` varchar(100) NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  `synopsis` varchar(500) DEFAULT NULL,
  `url_image` varchar(500) DEFAULT NULL COMMENT 'bucket url',
  `category_id` mediumint(3) unsigned NOT NULL,
  `creation_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `sale_price` decimal(10,2) NOT NULL DEFAULT '0.00',
  `percent_discount_sale_price_id` mediumint(3) unsigned DEFAULT NULL,
  `startdate_renting` datetime NOT NULL,
  `enddate_renting` datetime NOT NULL,
  `stock` int(8) NOT NULL DEFAULT '0' COMMENT 'stock',
  `suspend_movie` datetime DEFAULT NULL,
  `availability_status` tinyint(1) NOT NULL DEFAULT '1' COMMENT 'status movie is it suspended',
  `rent_price` decimal(10,2) NOT NULL DEFAULT '0.00',
  `percent_discount_rent_price_id` mediumint(3) unsigned DEFAULT NULL,
  `creator_id` int(11) DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `Movie_FK` (`category_id`),
  KEY `Movie_FK_1` (`percent_discount_sale_price_id`),
  KEY `Movie_FK_2` (`percent_discount_rent_price_id`),
  KEY `Movie_FK_3` (`creator_id`),
  CONSTRAINT `Movie_FK` FOREIGN KEY (`category_id`) REFERENCES `MovieCategory` (`id`),
  CONSTRAINT `Movie_FK_1` FOREIGN KEY (`percent_discount_sale_price_id`) REFERENCES `PercentDiscount` (`id`),
  CONSTRAINT `Movie_FK_2` FOREIGN KEY (`percent_discount_rent_price_id`) REFERENCES `PercentDiscount` (`id`),
  CONSTRAINT `Movie_FK_3` FOREIGN KEY (`creator_id`) REFERENCES `User` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `MovieCategory`
--

DROP TABLE IF EXISTS `MovieCategory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `MovieCategory` (
  `id` mediumint(3) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `MovieLog`
--

DROP TABLE IF EXISTS `MovieLog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `MovieLog` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date_updated` datetime NOT NULL,
  `title` varchar(200) DEFAULT NULL,
  `rent_price` decimal(10,2) DEFAULT NULL,
  `sale_price` decimal(10,2) DEFAULT NULL,
  `movie_id` mediumint(8) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `MovieLog_FK` (`movie_id`),
  CONSTRAINT `MovieLog_FK` FOREIGN KEY (`movie_id`) REFERENCES `Movie` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `PercentDiscount`
--

DROP TABLE IF EXISTS `PercentDiscount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PercentDiscount` (
  `id` mediumint(3) unsigned NOT NULL AUTO_INCREMENT,
  `percent` smallint(3) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `Rol`
--

DROP TABLE IF EXISTS `Rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Rol` (
  `id` mediumint(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  `code` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `Sale`
--

DROP TABLE IF EXISTS `Sale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Sale` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `sale_date` datetime NOT NULL,
  `seller_id` int(11) NOT NULL,
  `customer_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `Sale_FK` (`seller_id`),
  KEY `Sale_FK_1` (`customer_id`),
  CONSTRAINT `Sale_FK` FOREIGN KEY (`seller_id`) REFERENCES `User` (`id`),
  CONSTRAINT `Sale_FK_1` FOREIGN KEY (`customer_id`) REFERENCES `User` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `ShoppingCar`
--

DROP TABLE IF EXISTS `ShoppingCar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ShoppingCar` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_date` datetime NOT NULL,
  `returned_date` datetime DEFAULT NULL,
  `penalty` decimal(10,2) DEFAULT '0.00',
  `sale_id` int(10) unsigned NOT NULL,
  `movie_rent_price` decimal(10,2) DEFAULT '0.00',
  `movie_sale_price` decimal(10,2) DEFAULT '0.00',
  `real_rent_price` decimal(10,2) DEFAULT '0.00',
  `real_sale_price` decimal(10,2) DEFAULT '0.00',
  `status_rented` tinyint(1) DEFAULT NULL,
  `movie_id` mediumint(8) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ShoppingCar_FK` (`sale_id`),
  KEY `ShoppingCar_movie_id_IDX` (`movie_id`) USING BTREE,
  CONSTRAINT `ShoppingCar_FK` FOREIGN KEY (`sale_id`) REFERENCES `Sale` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `User`
--

DROP TABLE IF EXISTS `User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `User` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `lastname` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `phones` varchar(100) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `document` varchar(20) DEFAULT NULL COMMENT 'number of identification',
  `url_picture` varchar(500) DEFAULT NULL,
  `password` varchar(500) NOT NULL,
  `birthdate` date DEFAULT NULL,
  `rol_id` mediumint(5) NOT NULL,
  `actived` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `User_UN` (`email`),
  KEY `User_FK` (`rol_id`),
  CONSTRAINT `User_FK` FOREIGN KEY (`rol_id`) REFERENCES `Rol` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping routines for database 'movie_gallery_db'
--
/*!50003 DROP PROCEDURE IF EXISTS `p_movieUpdated` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`%` PROCEDURE `p_movieUpdated`(IN p_movie_id mediumint(8), IN p_title VARCHAR(200),
IN p_rent_price decimal(10,2), IN p_sale_price decimal(10,2), OUT p_mensaje VARCHARACTER(50))
sp:BEGIN
	INSERT INTO movie_gallery_db.MovieLog (movie_id, title, rent_price, sale_price, date_updated)
	VALUES(p_movie_id, p_title, p_rent_price, p_sale_price, NOW());

 set p_mensaje = LAST_INSERT_ID();
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `p_shopping_car` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`%` PROCEDURE `p_shopping_car`(
IN p_movie_sale_price DECIMAL(10,2),
IN p_real_sale_price decimal(10,2),
IN p_movie_rent_price DECIMAL(10,2),
IN p_real_rent_price decimal(10,2), 
IN p_sale_id INT,
OUT p_message VARCHAR(50))
sp:BEGIN
	
	IF p_sale_id is null then
		SET p_message = 'CODE-99';
	END IF;
	
	IF p_movie_sale_price is not null and  p_real_sale_price is not null
	and p_movie_rent_price is null and p_real_rent_price is null 
	then
		INSERT INTO movie_gallery_db.ShoppingCar(
		created_date, sale_id ,movie_sale_price, real_sale_price)
		VALUES(NOW(), p_sale_id, p_movie_sale_price, p_real_sale_price);
		set p_message = LAST_INSERT_ID(); 
		leave sp;
	END IF;

	IF p_movie_sale_price is  null and  p_real_sale_price is  null
	and p_movie_rent_price is NOT null and p_real_rent_price is NOT null 
	then
		INSERT INTO movie_gallery_db.ShoppingCar(
		created_date, sale_id ,movie_rent_price, real_rent_price, status_rented)
		VALUES(NOW(), p_sale_id, p_movie_rent_price, p_real_rent_price, true);
		set p_message = LAST_INSERT_ID(); 
		leave sp;
	END IF;


set p_message = 'CODE-99';
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_sell_or_renting_movie` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`%` PROCEDURE `sp_sell_or_renting_movie`(IN p_customer_id INT, 
IN p_employee_id INT,
OUT p_message VARCHAR(50))
sp:BEGIN
	
DECLARE EXIT HANDLER FOR SQLEXCEPTION 
    BEGIN
	    SET p_message = 'CODE-99';
        ROLLBACK;   
    END;
 
 IF p_customer_id is null or p_employee_id is null then 
/*Codigo 06 venta rechazada por tener cliente y vendedor nulo*/
	set p_message = 'CODE-06';
        leave sp;
 END IF;

START TRANSACTION;

    INSERT INTO movie_gallery_db.Sale(customer_id, seller_id, sale_date)
	VALUES(p_customer_id, p_employee_id, NOW());
	set p_message = LAST_INSERT_ID(); 
COMMIT;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_UserLikesMovies` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`%` PROCEDURE `sp_UserLikesMovies`(IN p_movie_id INT, IN p_user_id INT, out p_mensaje VARCHAR(50))
BEGIN
	
	INSERT INTO movie_gallery_db.LikedMoviesUsers(movie_id, user_id, creation_date)
	VALUES(p_movie_id, p_user_id, NOW());

 set p_mensaje = LAST_INSERT_ID();
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-10-16  1:10:29
