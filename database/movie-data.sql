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

SET @@GLOBAL.GTID_PURGED='519c01ce-dc46-11ea-9572-42010a8e0092:1-1125571';

--
-- Dumping data for table `LikedMoviesUsers`
--

LOCK TABLES `LikedMoviesUsers` WRITE;
/*!40000 ALTER TABLE `LikedMoviesUsers` DISABLE KEYS */;
INSERT INTO `LikedMoviesUsers` VALUES (1,3,1,'2020-10-13 04:42:39'),(2,3,1,'2020-10-16 06:26:03');
/*!40000 ALTER TABLE `LikedMoviesUsers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `Movie`
--

LOCK TABLES `Movie` WRITE;
/*!40000 ALTER TABLE `Movie` DISABLE KEYS */;
INSERT INTO `Movie` VALUES (1,'Toy Story',NULL,NULL,NULL,1,'2020-12-01 00:00:00',21.00,1,'2020-12-01 00:00:00','2020-12-10 00:00:00',55,NULL,1,2.00,1,1),(2,'AVANGERS',NULL,NULL,NULL,1,'2020-10-11 21:59:36',15.00,NULL,'2020-10-01 00:00:00','2020-12-10 00:00:00',11,NULL,0,12.00,1,1),(3,'FAST AND FURIOUS',NULL,NULL,NULL,1,'2020-10-12 01:13:28',11.00,NULL,'2020-10-01 00:00:00','2020-12-10 00:00:00',12,NULL,1,11.00,NULL,1);
/*!40000 ALTER TABLE `Movie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `MovieCategory`
--

LOCK TABLES `MovieCategory` WRITE;
/*!40000 ALTER TABLE `MovieCategory` DISABLE KEYS */;
INSERT INTO `MovieCategory` VALUES (1,'Action',NULL),(2,'Comedy',NULL),(3,'Drama',NULL),(4,'Fantasy',NULL),(5,'Horror',NULL),(6,'Mystery',NULL),(7,'Romance',NULL);
/*!40000 ALTER TABLE `MovieCategory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `MovieLog`
--

LOCK TABLES `MovieLog` WRITE;
/*!40000 ALTER TABLE `MovieLog` DISABLE KEYS */;
INSERT INTO `MovieLog` VALUES (1,'2020-10-10 21:32:34','Iron Man',2.00,11.00,1),(36,'2020-10-15 01:25:51','Toy Story 5',2.00,22.00,1),(41,'2020-10-15 01:31:25','Toy Story',2.00,22.00,1),(47,'2020-10-15 01:41:56','Toy Story',2.00,21.00,1),(48,'2020-10-15 01:42:17','Toy Story',2.00,20.00,1),(49,'2020-10-15 01:42:25','Toy Story',2.00,19.00,1);
/*!40000 ALTER TABLE `MovieLog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `PercentDiscount`
--

LOCK TABLES `PercentDiscount` WRITE;
/*!40000 ALTER TABLE `PercentDiscount` DISABLE KEYS */;
INSERT INTO `PercentDiscount` VALUES (1,5),(2,10),(3,20),(4,30),(5,40),(6,50),(7,60),(8,0);
/*!40000 ALTER TABLE `PercentDiscount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `Rol`
--

LOCK TABLES `Rol` WRITE;
/*!40000 ALTER TABLE `Rol` DISABLE KEYS */;
INSERT INTO `Rol` VALUES (1,'Admin',NULL,'0001'),(2,'Merchant',NULL,'0002'),(3,'Customer',NULL,'0003');
/*!40000 ALTER TABLE `Rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `Sale`
--

LOCK TABLES `Sale` WRITE;
/*!40000 ALTER TABLE `Sale` DISABLE KEYS */;
INSERT INTO `Sale` VALUES (11,'2020-10-15 02:50:31',2,1),(12,'2020-10-15 02:51:17',2,1),(14,'2020-10-15 02:55:46',2,1),(15,'2020-10-15 02:56:00',2,1),(16,'2020-10-15 03:06:51',2,1),(17,'2020-10-15 03:37:20',1,1),(18,'2020-10-15 03:37:46',1,1);
/*!40000 ALTER TABLE `Sale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `ShoppingCar`
--

LOCK TABLES `ShoppingCar` WRITE;
/*!40000 ALTER TABLE `ShoppingCar` DISABLE KEYS */;
INSERT INTO `ShoppingCar` VALUES (1,'2020-10-15 03:38:32',NULL,0.00,11,0.00,1.00,0.00,1.00,NULL,0),(2,'2020-10-15 03:44:26',NULL,0.00,11,0.00,1.00,0.00,1.00,NULL,0),(3,'2020-10-15 03:48:41',NULL,0.00,11,0.00,1.00,0.00,1.00,NULL,0),(4,'2020-10-15 03:50:58',NULL,0.00,11,0.00,1.00,0.00,1.00,NULL,0),(5,'2020-10-15 03:53:39',NULL,0.00,11,2.00,0.00,2.00,0.00,1,0);
/*!40000 ALTER TABLE `ShoppingCar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `User`
--

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
INSERT INTO `User` VALUES (1,'Pedro','Jimenez','pedro.jimenez@yopmail.com','7000-0000','San Salvador','05056987-0',NULL,'1234','1994-02-12',1,1),(2,'Laura','Herndandez','laura.hernandez@yopmail.com',NULL,NULL,NULL,NULL,'1234','1994-02-12',3,1);
/*!40000 ALTER TABLE `User` ENABLE KEYS */;
UNLOCK TABLES;

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

-- Dump completed on 2020-10-16  1:09:53
