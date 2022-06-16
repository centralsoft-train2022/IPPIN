-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: mydb
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `food_history`
--

DROP TABLE IF EXISTS `food_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `food_history` (
  `historyid` int NOT NULL AUTO_INCREMENT,
  `date` timestamp NOT NULL,
  `User_userID` int NOT NULL,
  `Food_FoodID` int NOT NULL,
  PRIMARY KEY (`historyid`),
  KEY `fk_FoodCareer_User1_idx` (`User_userID`),
  KEY `fk_FoodCareer_Food1_idx` (`Food_FoodID`),
  CONSTRAINT `fk_FoodCareer_Food1` FOREIGN KEY (`Food_FoodID`) REFERENCES `food` (`FoodID`),
  CONSTRAINT `fk_FoodCareer_User1` FOREIGN KEY (`User_userID`) REFERENCES `user` (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `food_history`
--

LOCK TABLES `food_history` WRITE;
/*!40000 ALTER TABLE `food_history` DISABLE KEYS */;
INSERT INTO `food_history` VALUES (1,'2022-06-15 03:55:38',1,3),(2,'2022-06-15 03:55:41',1,1),(3,'2022-06-15 03:55:45',1,4),(4,'2022-06-15 05:04:32',1,3),(5,'2022-06-15 05:04:54',1,2),(6,'2022-06-15 05:06:01',1,3),(7,'2022-06-15 05:07:43',1,2),(8,'2022-06-15 05:10:17',1,1),(9,'2022-06-15 05:11:43',1,2),(10,'2022-06-15 05:47:17',1,4),(11,'2022-06-15 07:55:25',1,1),(12,'2022-06-15 07:55:30',1,1),(13,'2022-06-15 07:59:33',1,2),(14,'2022-06-15 23:50:34',1,3);
/*!40000 ALTER TABLE `food_history` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-16 10:21:00
