-- MySQL dump 10.13  Distrib 8.0.22, for macos10.15 (x86_64)
--
-- Host: localhost    Database: seminar
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book` (
  `id` varchar(255) NOT NULL,
  `author_name` varchar(255) DEFAULT NULL,
  `book_name` varchar(255) DEFAULT NULL,
  `category` varchar(255) DEFAULT NULL,
  `publisher` varchar(255) DEFAULT NULL,
  `year` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES ('001','Maddie Mortimer','Maps of Our Spectacular Bodies','Genre Fiction','Picador',2022),('002','Tove Ditlevsen','The Copenhagen Trilogy: Childhood; Youth; Dependency','Arts & Literature','Farrar, Straus and Giroux',2021),('003','Julia Armfield','Our Wives Under the Sea','Literature & Fiction','Flatiron Books',2022),('004','mbolo Mbue','How Beautiful We Were: A Novel','Genre Fiction','Random House',2021),('005','Patricia Lockwood','No One Is Talking About This: A Novel','Humor','Riverhead Books',2021);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `borrow`
--

DROP TABLE IF EXISTS `borrow`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `borrow` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `borrow_date` datetime DEFAULT NULL,
  `card_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10004 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `borrow`
--

LOCK TABLES `borrow` WRITE;
/*!40000 ALTER TABLE `borrow` DISABLE KEYS */;
INSERT INTO `borrow` VALUES (10001,'2021-04-04 00:00:00',1001),(10002,'2022-05-05 00:00:00',1002),(10003,'2022-03-28 00:00:00',1003);
/*!40000 ALTER TABLE `borrow` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detail`
--

DROP TABLE IF EXISTS `detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detail` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `book_id` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `returned_date` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `borrow` bigint DEFAULT NULL,
  `bookdetail` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmeev3e8t4rosfibo7eqxp1q5r` (`borrow`),
  KEY `FKol9u0vaatx8sf88joi95gvtj3` (`bookdetail`),
  CONSTRAINT `FKmeev3e8t4rosfibo7eqxp1q5r` FOREIGN KEY (`borrow`) REFERENCES `borrow` (`id`),
  CONSTRAINT `FKol9u0vaatx8sf88joi95gvtj3` FOREIGN KEY (`bookdetail`) REFERENCES `book` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10004 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detail`
--

LOCK TABLES `detail` WRITE;
/*!40000 ALTER TABLE `detail` DISABLE KEYS */;
INSERT INTO `detail` VALUES (1,'001','true','2022-05-04 00:00:00','returned',10001,'001'),(2,'002','true','2022-05-04 00:00:00','returned',10001,'002'),(3,'001','false','2022-06-05 00:00:00','borrowing',10002,'001'),(4,'003','false','2022-06-05 00:00:00','borrowing',10002,'003');
/*!40000 ALTER TABLE `detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tag_read`
--

DROP TABLE IF EXISTS `tag_read`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tag_read` (
  `tag_rfid` varchar(255) NOT NULL,
  `tag_time` datetime DEFAULT NULL,
  `book` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`tag_rfid`),
  KEY `FKoxyy6plexpdlhhptf5bu4gjmf` (`book`),
  CONSTRAINT `FKoxyy6plexpdlhhptf5bu4gjmf` FOREIGN KEY (`book`) REFERENCES `book` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tag_read`
--

LOCK TABLES `tag_read` WRITE;
/*!40000 ALTER TABLE `tag_read` DISABLE KEYS */;
INSERT INTO `tag_read` VALUES ('300F4F573AD001C08369A230',NULL,'004'),('300F4F573AD001C08369A241',NULL,'002'),('300F4F573AD001C08369A245',NULL,'001'),('300F4F573AD001C08369A249',NULL,'003'),('300F4F573AD001C08369A28F',NULL,'005');
/*!40000 ALTER TABLE `tag_read` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-05  6:18:49
