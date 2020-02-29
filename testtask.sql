-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: testtask
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tbldepartments`
--

DROP TABLE IF EXISTS `tbldepartments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tbldepartments` (
  `dpID` int NOT NULL AUTO_INCREMENT,
  `dpName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`dpID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbldepartments`
--

LOCK TABLES `tbldepartments` WRITE;
/*!40000 ALTER TABLE `tbldepartments` DISABLE KEYS */;
INSERT INTO `tbldepartments` VALUES (1,'HR'),(2,'Tech'),(3,'Finance'),(4,'Production'),(5,'Research'),(6,'Marketing');
/*!40000 ALTER TABLE `tbldepartments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tblemployees`
--

DROP TABLE IF EXISTS `tblemployees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblemployees` (
  `empID` int NOT NULL AUTO_INCREMENT,
  `empActive` tinyint(1) DEFAULT '0',
  `empName` varchar(255) DEFAULT NULL,
  `emp_dpID` int DEFAULT NULL,
  PRIMARY KEY (`empID`),
  KEY `FK_tblemployees_emp_dpID` (`emp_dpID`),
  CONSTRAINT `FK_tblemployees_emp_dpID` FOREIGN KEY (`emp_dpID`) REFERENCES `tbldepartments` (`dpID`)
) ENGINE=InnoDB AUTO_INCREMENT=136 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblemployees`
--

LOCK TABLES `tblemployees` WRITE;
/*!40000 ALTER TABLE `tblemployees` DISABLE KEYS */;
INSERT INTO `tblemployees` VALUES (1,1,'Ba',1),(2,0,'Be',2),(3,1,'Bi',2),(4,1,'Bo',1),(7,0,'Bu',1),(9,1,'Ca',4),(12,0,'Ce',5),(13,0,'Ci',1),(14,1,'Co',2),(15,1,'Cu',3),(16,1,'Da',4),(17,0,'De',1),(18,0,'Di',2),(19,0,'Do',3),(20,1,'Du',4),(21,1,'Fa',5),(22,1,'Fe',1),(23,0,'Fi',2),(24,1,'Fo',3),(25,1,'Fu',5),(26,1,'Ga',5),(27,0,'Ge',1),(28,1,'Gi',2),(29,0,'Go',6),(30,1,'Gu',5),(31,1,'Ha',4),(32,0,'He',3),(33,0,'Hi',2),(34,0,'Ho',1),(35,1,'Hu',2),(36,0,'Ja',1),(37,0,'Je',3),(38,1,'Ji',4),(39,0,'Jo',5),(40,0,'Ju',6),(41,1,'Ka',5),(42,1,'Ke',4),(43,1,'Ki',3),(44,0,'Ko',2),(45,1,'Ku',1),(46,0,'La',1),(47,1,'Le',2),(48,0,'Li',3),(49,0,'Lo',4),(50,0,'Lu',5),(51,1,'Ma',6),(52,0,'Me',6),(53,1,'Mi',4),(54,0,'Mo',5),(55,0,'Mu',2),(56,0,'Na',1),(57,1,'Ne',4),(58,1,'Ni',2),(59,1,'No',5),(60,0,'Nu',4),(61,1,'Pa',6),(62,1,'Pe',4),(63,1,'Pi',2),(64,0,'Po',3),(65,0,'Pu',1),(66,0,'Qa',2),(67,1,'Qe',3),(68,0,'Qi',5),(69,0,'Qo',4),(70,1,'Qu',3),(71,0,'Ra',2),(72,0,'Re',1),(73,0,'Ri',2),(74,1,'Ro',3),(75,1,'Ru',4),(76,0,'Sa',5),(77,0,'Se',6),(78,0,'Si',6),(79,1,'So',6),(80,0,'Su',6),(81,1,'Ta',2),(82,0,'Te',5),(83,1,'Ti',4),(84,0,'To',2),(85,1,'Tu',3),(86,0,'Va',6),(87,1,'Ve',3),(88,0,'Vi',4),(89,1,'Vo',1),(90,0,'Vu',2),(91,1,'Wa',3),(92,0,'We',4),(93,0,'Wi',5),(94,0,'Wo',6),(95,1,'Wu',4),(96,0,'Xa',3),(97,0,'Xe',2),(98,1,'Xi',1),(99,1,'Xo',2),(100,1,'Xu',5),(101,0,'Ya',6),(102,0,'Ye',4),(103,0,'Yi',3),(104,1,'Yo',2),(105,1,'Yu',1),(106,0,'Za',2),(107,1,'Ze',3),(108,1,'Zi',4),(109,0,'Zo',5),(110,0,'Zu',2),(127,1,'Anna',6),(128,1,'Albert',4),(129,0,'Alicia',3),(130,0,'Baron',2),(131,1,'Barton',4),(132,1,'Tommy',6),(133,1,'Tatiana',5),(134,0,'Paul',1),(135,1,'Mark',2);
/*!40000 ALTER TABLE `tblemployees` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-02-29 16:44:50
