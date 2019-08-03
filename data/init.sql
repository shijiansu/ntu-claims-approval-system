CREATE DATABASE  IF NOT EXISTS `ntu-msis-ead-tera-v2` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `ntu-msis-ead-tera-v2`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: test
-- ------------------------------------------------------
-- Server version	5.6.16

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

--
-- Table structure for table `claim_form`
--

DROP TABLE IF EXISTS `claim_form`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `claim_form` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `DEPT_ID` int(11) DEFAULT NULL,
  `USER_ID` int(11) DEFAULT NULL,
  `TRAVEL_OF_YEAR` varchar(4) DEFAULT NULL,
  `TRAVEL_OF_MONTH` varchar(2) DEFAULT NULL,
  `FORM_STATUS_ID` int(11) DEFAULT NULL,
  `TOTAL` decimal(12,2) DEFAULT '0.00',
  `APP_BY_MANAGER` int(11) DEFAULT NULL,
  `APP_BY_FINANCIAL` int(11) DEFAULT NULL,
  `APP_BY_MANAGER_TIME` datetime DEFAULT NULL,
  `APP_BY_FINANCIAL_TIME` datetime DEFAULT NULL,
  `CREATE_BY` varchar(45) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_BY` varchar(45) DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  `REJECT_BY` int(11) DEFAULT NULL,
  `REJECT_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `uuu_idx` (`USER_ID`),
  KEY `ddd_idx` (`DEPT_ID`),
  KEY `mmm_idx` (`APP_BY_MANAGER`),
  KEY `fff_idx` (`APP_BY_FINANCIAL`),
  KEY `fk_sssss` (`FORM_STATUS_ID`),
  CONSTRAINT `ddd` FOREIGN KEY (`DEPT_ID`) REFERENCES `dept` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fff` FOREIGN KEY (`APP_BY_FINANCIAL`) REFERENCES `users` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_sssss` FOREIGN KEY (`FORM_STATUS_ID`) REFERENCES `md_form_status` (`ID`),
  CONSTRAINT `mmm` FOREIGN KEY (`APP_BY_MANAGER`) REFERENCES `users` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `uuu` FOREIGN KEY (`USER_ID`) REFERENCES `users` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=85 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `claim_form`
--

LOCK TABLES `claim_form` WRITE;
/*!40000 ALTER TABLE `claim_form` DISABLE KEYS */;
INSERT INTO `claim_form` VALUES (27,5,32,'2014','01',4,325.30,32,38,'2014-04-11 16:46:09','2014-04-11 16:47:07','isadmin','2014-03-15 05:12:35','account-user2-manager','2014-04-11 16:47:07',NULL,NULL),(29,5,32,'2013','03',4,0.00,32,38,'2014-03-15 06:46:12','2014-04-11 16:47:26','isadmin','2014-03-15 06:40:58','account-user2-manager','2014-04-11 16:47:26',NULL,NULL),(30,5,32,'2013','04',4,56.10,32,38,'2014-04-06 20:45:57','2014-04-11 16:47:29','isadmin','2014-03-15 06:41:04','account-user2-manager','2014-04-11 16:47:29',NULL,NULL),(31,5,32,'2013','04',4,0.00,32,38,'2014-03-15 06:46:09','2014-04-11 16:47:28','isadmin','2014-03-15 06:41:09','account-user2-manager','2014-04-11 16:47:28',NULL,NULL),(32,5,32,'2013','04',4,331.45,32,38,'2014-04-11 20:53:26','2014-04-11 20:53:49','isadmin','2014-03-15 06:41:16','account-user2-manager','2014-04-11 20:53:49',NULL,NULL),(34,4,37,'2014','01',4,0.00,38,38,'2014-04-11 20:54:17','2014-04-11 21:09:27','account-user1','2014-03-17 01:34:37','account-user2-manager','2014-04-11 21:09:27',NULL,NULL),(35,4,37,'2014','01',4,300.00,38,38,'2014-04-06 23:18:21','2014-04-11 16:47:09','account-user1','2014-04-06 22:52:38','account-user2-manager','2014-04-11 16:47:09',NULL,NULL),(36,4,37,'2014','01',4,100.00,38,38,'2014-04-06 23:07:40','2014-04-11 16:47:22','account-user1','2014-04-06 22:58:08','account-user2-manager','2014-04-11 16:47:22',NULL,NULL),(37,4,37,'2014','01',4,200.00,38,38,'2014-04-06 23:07:29','2014-04-06 23:07:38','account-user1','2014-04-06 22:58:27','account-user2-manager','2014-04-06 23:07:38',NULL,NULL),(38,4,37,'2013','01',4,0.00,38,38,'2014-04-06 23:07:27','2014-04-06 23:07:37','account-user1','2014-04-06 22:59:02','account-user2-manager','2014-04-06 23:07:37',NULL,NULL),(39,4,37,'2012','01',4,0.00,38,38,'2014-04-06 23:07:26','2014-04-06 23:07:36','account-user1','2014-04-06 22:59:06','account-user2-manager','2014-04-06 23:07:36',NULL,NULL),(40,4,37,'2011','01',4,0.00,38,38,'2014-04-06 23:07:24','2014-04-06 23:07:34','account-user1','2014-04-06 22:59:10','account-user2-manager','2014-04-06 23:07:34',NULL,NULL),(41,4,37,'2013','02',4,0.00,38,38,'2014-04-06 23:07:22','2014-04-06 23:07:33','account-user1','2014-04-06 22:59:15','account-user2-manager','2014-04-06 23:07:33',NULL,NULL),(42,4,37,'2014','01',4,0.00,38,38,'2014-04-06 23:18:20','2014-04-11 16:47:10','account-user1','2014-04-06 23:17:58','account-user2-manager','2014-04-11 16:47:10',NULL,NULL),(43,4,37,'2014','01',4,0.00,38,38,'2014-04-06 23:18:19','2014-04-11 16:47:12','account-user1','2014-04-06 23:18:01','account-user2-manager','2014-04-11 16:47:12',NULL,NULL),(44,4,37,'2014','01',4,0.00,38,38,'2014-04-06 23:18:18','2014-04-11 16:47:20','account-user1','2014-04-06 23:18:03','account-user2-manager','2014-04-11 16:47:20',NULL,NULL),(45,5,32,'2014','01',4,72.06,32,38,'2014-04-11 20:53:28','2014-04-11 20:53:47','isadmin','2014-04-11 01:16:35','account-user2-manager','2014-04-11 20:53:47',NULL,NULL),(46,5,32,'2014','01',4,559.11,32,38,'2014-04-11 20:53:29','2014-04-11 20:53:46','isadmin','2014-04-11 11:16:42','account-user2-manager','2014-04-11 20:53:46',NULL,NULL),(47,5,32,'2013','05',4,507.80,32,38,'2014-04-11 20:53:31','2014-04-11 20:53:42','isadmin','2014-04-11 20:39:14','account-user2-manager','2014-04-11 20:53:42',NULL,NULL),(48,5,32,'2013','05',4,553.17,32,38,'2014-04-11 21:09:01','2014-04-11 21:09:26','isadmin','2014-04-11 20:39:23','account-user2-manager','2014-04-11 21:09:26',NULL,NULL),(49,5,32,'2013','05',4,509.81,32,38,'2014-04-11 21:09:04','2014-04-11 21:09:29','isadmin','2014-04-11 20:39:28','account-user2-manager','2014-04-11 21:09:29',NULL,NULL),(50,5,32,'2013','06',4,416.63,32,38,'2014-04-11 21:09:05','2014-04-11 21:09:25','isadmin','2014-04-11 20:39:34','account-user2-manager','2014-04-11 21:09:25',NULL,NULL),(51,5,32,'2013','06',4,314.50,32,38,'2014-04-11 21:09:07','2014-04-11 21:09:30','isadmin','2014-04-11 20:39:38','account-user2-manager','2014-04-11 21:09:30',NULL,NULL),(52,5,32,'2013','06',4,386.50,32,38,'2014-04-12 01:21:32','2014-04-12 01:22:23','isadmin','2014-04-11 20:39:43','account-user2-manager','2014-04-12 01:22:23',NULL,NULL),(53,5,32,'2013','07',4,284.33,32,38,'2014-04-12 01:21:34','2014-04-12 01:22:22','isadmin','2014-04-11 20:39:48','account-user2-manager','2014-04-12 01:22:22',NULL,NULL),(54,5,32,'2013','07',4,300.00,32,38,'2014-04-12 01:21:35','2014-04-12 01:22:20','isadmin','2014-04-11 20:39:54','account-user2-manager','2014-04-12 01:22:20',NULL,NULL),(55,5,32,'2013','07',4,300.00,32,38,'2014-04-12 01:21:36','2014-04-12 01:22:19','isadmin','2014-04-11 20:39:58','account-user2-manager','2014-04-12 01:22:19',NULL,NULL),(56,5,32,'2013','07',4,206.30,32,38,'2014-04-12 01:21:38','2014-04-12 01:22:18','isadmin','2014-04-11 20:40:03','account-user2-manager','2014-04-12 01:22:18',NULL,NULL),(57,5,32,'2013','08',4,680.00,32,38,'2014-04-12 01:26:41','2014-04-12 01:37:47','isadmin','2014-04-11 20:40:08','account-user2-manager','2014-04-12 01:37:47',NULL,NULL),(58,5,32,'2013','09',4,700.00,32,38,'2014-04-12 01:21:40','2014-04-12 01:22:17','isadmin','2014-04-11 20:40:13','account-user2-manager','2014-04-12 01:22:17',NULL,NULL),(59,5,32,'2013','09',4,250.00,32,38,'2014-04-12 01:21:41','2014-04-12 01:22:15','isadmin','2014-04-11 20:40:17','account-user2-manager','2014-04-12 01:22:15',NULL,NULL),(60,5,32,'2013','09',4,1050.00,32,38,'2014-04-12 01:26:42','2014-04-12 01:37:48','isadmin','2014-04-11 20:40:21','account-user2-manager','2014-04-12 01:37:48',NULL,NULL),(61,5,32,'2013','09',4,45.00,32,38,'2014-04-12 01:21:43','2014-04-12 01:22:14','isadmin','2014-04-11 20:40:27','account-user2-manager','2014-04-12 01:22:14',NULL,NULL),(62,5,32,'2013','09',4,1500.00,32,38,'2014-04-12 01:26:43','2014-04-12 01:37:49','isadmin','2014-04-11 20:40:34','account-user2-manager','2014-04-12 01:37:49',NULL,NULL),(63,5,32,'2013','09',5,50.00,NULL,NULL,NULL,NULL,'isadmin','2014-04-11 20:40:37','account-user2-manager','2014-04-12 06:47:40',38,'2014-04-12 06:47:40'),(64,5,32,'2013','10',4,1900.00,32,38,'2014-04-12 01:26:51','2014-04-12 01:37:49','isadmin','2014-04-11 20:40:43','account-user2-manager','2014-04-12 01:37:49',NULL,NULL),(65,5,32,'2013','10',4,500.00,32,38,'2014-04-12 01:26:44','2014-04-12 01:37:50','isadmin','2014-04-11 20:40:53','account-user2-manager','2014-04-12 01:37:50',NULL,NULL),(66,5,32,'2013','01',4,300.00,32,38,'2014-04-12 01:26:45','2014-04-12 01:37:50','isadmin','2014-04-11 20:41:00','account-user2-manager','2014-04-12 01:37:50',NULL,NULL),(67,5,32,'2013','11',4,250.00,32,38,'2014-04-12 01:26:46','2014-04-12 01:37:51','isadmin','2014-04-11 20:41:06','account-user2-manager','2014-04-12 01:37:51',NULL,NULL),(68,5,32,'2013','11',4,300.00,32,38,'2014-04-12 01:26:48','2014-04-12 01:37:51','isadmin','2014-04-11 20:41:13','account-user2-manager','2014-04-12 01:37:51',NULL,NULL),(69,5,32,'2013','12',4,330.00,32,38,'2014-04-12 01:26:48','2014-04-12 01:37:52','isadmin','2014-04-11 20:41:17','account-user2-manager','2014-04-12 01:37:52',NULL,NULL),(70,5,32,'2014','01',4,690.00,32,38,'2014-04-12 01:26:49','2014-04-12 01:37:52','isadmin','2014-04-11 20:41:21','account-user2-manager','2014-04-12 01:37:52',NULL,NULL),(72,5,32,'2014','02',4,600.00,32,38,'2014-04-12 01:26:50','2014-04-12 01:37:52','isadmin','2014-04-11 20:41:28','account-user2-manager','2014-04-12 01:37:52',NULL,NULL),(74,5,32,'2014','02',4,1000.00,32,38,'2014-04-12 01:26:54','2014-04-12 01:40:03','isadmin','2014-04-11 20:41:33','account-user2-manager','2014-04-12 01:40:03',NULL,NULL),(75,5,32,'2014','03',4,1230.00,32,38,'2014-04-12 01:34:08','2014-04-12 01:40:02','isadmin','2014-04-11 20:41:35','account-user2-manager','2014-04-12 01:40:02',NULL,NULL),(76,5,32,'2014','03',4,560.00,32,38,'2014-04-12 01:34:10','2014-04-12 01:35:51','isadmin','2014-04-11 20:41:38','account-user2-manager','2014-04-12 01:35:51',NULL,NULL),(77,5,32,'2014','03',4,50.00,32,38,'2014-04-12 01:48:42','2014-04-12 01:49:05','isadmin','2014-04-11 20:41:41','account-user2-manager','2014-04-12 01:49:05',NULL,NULL),(78,5,32,'2014','03',4,30.20,32,38,'2014-04-12 01:48:44','2014-04-12 01:49:04','isadmin','2014-04-11 20:41:45','account-user2-manager','2014-04-12 01:49:04',NULL,NULL),(79,5,32,'2014','03',4,555.00,32,38,'2014-04-12 01:34:12','2014-04-12 01:34:47','isadmin','2014-04-11 20:41:49','account-user2-manager','2014-04-12 01:34:47',NULL,NULL),(80,5,32,'2014','03',4,107.76,32,38,'2014-04-11 21:09:17','2014-04-12 01:22:24','isadmin','2014-04-11 20:41:52','account-user2-manager','2014-04-12 01:22:24',NULL,NULL),(81,5,32,'2014','04',2,55.00,NULL,NULL,NULL,NULL,'isadmin','2014-04-11 20:41:54','isadmin',NULL,NULL,NULL),(82,5,32,'2014','04',4,55.00,32,38,'2014-04-12 01:21:45','2014-04-12 01:22:12','isadmin','2014-04-11 20:41:57','account-user2-manager','2014-04-12 01:22:12',NULL,NULL),(83,5,32,'2014','02',4,300.00,32,38,'2014-04-12 01:48:43','2014-04-12 01:49:04','isadmin','2014-04-12 01:48:11','account-user2-manager','2014-04-12 01:49:04',NULL,NULL),(84,5,32,'2014','01',1,12.00,NULL,NULL,NULL,NULL,'isadmin','2014-04-12 06:37:29',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `claim_form` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `claim_form_item`
--

DROP TABLE IF EXISTS `claim_form_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `claim_form_item` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CLAIM_TYPE_ID` int(11) DEFAULT NULL,
  `CLAIM_FORM_ID` int(11) DEFAULT NULL,
  `CLAIM_DATE` date DEFAULT NULL,
  `CLAIM_DESCRIPTION` varchar(255) DEFAULT NULL,
  `CLAIM_AMOUNT` decimal(12,2) DEFAULT NULL,
  `CREATE_BY` varchar(45) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_BY` varchar(45) DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`),
  KEY `PK_CLAIM_FORM_ID_idx` (`CLAIM_FORM_ID`),
  KEY `FK_CLAIM_TYPE_ID_idx` (`CLAIM_TYPE_ID`),
  CONSTRAINT `c` FOREIGN KEY (`CLAIM_FORM_ID`) REFERENCES `claim_form` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `t` FOREIGN KEY (`CLAIM_TYPE_ID`) REFERENCES `md_claim_type` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=150 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `claim_form_item`
--

LOCK TABLES `claim_form_item` WRITE;
/*!40000 ALTER TABLE `claim_form_item` DISABLE KEYS */;
INSERT INTO `claim_form_item` VALUES (27,10,27,'2014-01-22','25.3',25.30,'isadmin','2014-03-15 06:40:03',NULL,NULL),(28,8,27,'2014-01-14','300',300.00,'isadmin','2014-03-15 06:40:20',NULL,NULL),(29,6,30,'2013-04-24','56.1',56.10,'isadmin','2014-03-15 06:41:45',NULL,NULL),(34,1,35,'2014-01-01','100',200.00,'account-user1','2014-04-06 22:54:27','account-user1','2014-04-06 22:55:33'),(35,1,35,'2014-01-02','100',100.00,'account-user1','2014-04-06 22:55:21',NULL,NULL),(36,1,36,'2014-01-01','100',100.00,'account-user1','2014-04-06 22:58:21',NULL,NULL),(37,1,37,'2014-01-01','100',100.00,'account-user1','2014-04-06 22:58:38',NULL,NULL),(38,4,37,'2014-01-02','100',100.00,'account-user1','2014-04-06 22:58:48',NULL,NULL),(40,1,45,'2014-01-01','10',10.00,'isadmin','2014-04-11 01:36:40','isadmin','2014-04-11 20:49:12'),(41,1,45,'2014-01-01','12',12.00,'isadmin','2014-04-11 01:51:45','isadmin','2014-04-11 20:49:07'),(42,1,46,'2014-01-01','200.1',200.01,'isadmin','2014-04-11 11:16:55','isadmin','2014-04-11 20:49:24'),(43,1,45,'2014-01-01','50.06',50.06,'isadmin','2014-04-11 11:34:01','isadmin','2014-04-11 20:49:00'),(52,1,32,'2013-04-03','103.55',103.55,'isadmin','2014-04-11 20:47:15',NULL,NULL),(53,3,32,'2013-04-01','55.3',55.30,'isadmin','2014-04-11 20:47:27',NULL,NULL),(54,4,32,'2013-04-11','33.2',33.20,'isadmin','2014-04-11 20:47:52',NULL,NULL),(55,13,32,'2013-04-02','100',100.00,'isadmin','2014-04-11 20:48:07',NULL,NULL),(56,11,32,'2013-04-25','23.6',23.60,'isadmin','2014-04-11 20:48:20',NULL,NULL),(57,10,32,'2013-04-13','15.8',15.80,'isadmin','2014-04-11 20:48:34',NULL,NULL),(58,6,46,'2014-01-18','103.3',103.30,'isadmin','2014-04-11 20:49:41',NULL,NULL),(59,10,46,'2014-01-11','56.6',56.60,'isadmin','2014-04-11 20:49:53',NULL,NULL),(60,15,46,'2014-01-12','35.6',35.60,'isadmin','2014-04-11 20:50:10',NULL,NULL),(61,6,46,'2014-01-12','88.6',88.60,'isadmin','2014-04-11 20:50:28',NULL,NULL),(62,6,46,'2014-01-20','75',75.00,'isadmin','2014-04-11 20:50:45',NULL,NULL),(63,2,47,'2013-05-01','200.1',200.10,'isadmin','2014-04-11 20:51:08',NULL,NULL),(64,2,47,'2013-05-01','30.5',30.50,'isadmin','2014-04-11 20:51:24',NULL,NULL),(65,4,47,'2013-05-03','66.7',66.70,'isadmin','2014-04-11 20:51:49',NULL,NULL),(66,12,47,'2013-05-17','100.3',100.30,'isadmin','2014-04-11 20:52:24',NULL,NULL),(67,12,47,'2013-05-18','55',55.00,'isadmin','2014-04-11 20:52:40',NULL,NULL),(68,6,47,'2013-05-21','18.6',18.60,'isadmin','2014-04-11 20:52:55',NULL,NULL),(69,12,47,'2013-05-21','36.6',36.60,'isadmin','2014-04-11 20:53:11',NULL,NULL),(70,2,48,'2013-05-02','100',100.00,'isadmin','2014-04-11 20:55:53',NULL,NULL),(71,1,48,'2013-05-03','200.55',200.55,'isadmin','2014-04-11 20:56:41',NULL,NULL),(72,10,48,'2013-05-12','56.66',56.66,'isadmin','2014-04-11 20:57:01',NULL,NULL),(73,15,48,'2013-05-12','98.8',98.80,'isadmin','2014-04-11 20:57:12',NULL,NULL),(74,5,48,'2013-05-18','10',10.00,'isadmin','2014-04-11 20:57:23',NULL,NULL),(75,13,48,'2013-05-18','20.36',20.36,'isadmin','2014-04-11 20:57:37',NULL,NULL),(76,2,48,'2013-05-26','66.8',66.80,'isadmin','2014-04-11 20:57:53',NULL,NULL),(77,1,49,'2013-05-03','10.1',10.10,'isadmin','2014-04-11 20:59:50',NULL,NULL),(78,1,49,'2013-05-04','10.55',10.55,'isadmin','2014-04-11 21:00:02',NULL,NULL),(79,3,49,'2013-05-12','55.5',55.50,'isadmin','2014-04-11 21:00:14',NULL,NULL),(80,10,49,'2013-05-11','30.66',30.66,'isadmin','2014-04-11 21:00:28',NULL,NULL),(81,15,49,'2013-05-22','105.6',105.60,'isadmin','2014-04-11 21:00:45',NULL,NULL),(82,13,49,'2013-05-11','186.6',186.60,'isadmin','2014-04-11 21:01:09',NULL,NULL),(83,7,49,'2013-05-12','30.2',30.20,'isadmin','2014-04-11 21:01:19',NULL,NULL),(84,12,49,'2013-05-25','80.6',80.60,'isadmin','2014-04-11 21:01:35',NULL,NULL),(92,2,50,'2013-06-05','65.33',65.33,'isadmin','2014-04-11 21:04:10',NULL,NULL),(93,3,50,'2013-06-02','44.6',44.60,'isadmin','2014-04-11 21:04:21',NULL,NULL),(94,11,50,'2013-06-03','59',59.00,'isadmin','2014-04-11 21:04:32',NULL,NULL),(95,8,50,'2013-06-15','69',69.00,'isadmin','2014-04-11 21:04:40',NULL,NULL),(96,4,50,'2013-06-16','70.3',70.30,'isadmin','2014-04-11 21:04:55',NULL,NULL),(97,5,50,'2013-06-13','19.6',19.60,'isadmin','2014-04-11 21:05:09',NULL,NULL),(98,11,50,'2013-06-22','88.8',88.80,'isadmin','2014-04-11 21:05:26',NULL,NULL),(99,2,51,'2013-06-10','16',16.00,'isadmin','2014-04-11 21:06:31',NULL,NULL),(100,4,51,'2013-06-15','67.3',67.30,'isadmin','2014-04-11 21:06:51',NULL,NULL),(101,10,51,'2013-06-17','46',46.00,'isadmin','2014-04-11 21:07:06',NULL,NULL),(102,7,51,'2013-06-15','98.6',98.60,'isadmin','2014-04-11 21:07:20',NULL,NULL),(103,7,51,'2013-06-12','63.6',63.60,'isadmin','2014-04-11 21:07:41',NULL,NULL),(104,10,51,'2013-06-16','23',23.00,'isadmin','2014-04-11 21:07:52',NULL,NULL),(105,1,80,'2014-03-01','33.3',33.30,'isadmin','2014-04-11 21:08:15',NULL,NULL),(106,4,80,'2014-03-17','17.8',17.80,'isadmin','2014-04-11 21:08:26',NULL,NULL),(107,10,80,'2014-03-14','56.66',56.66,'isadmin','2014-04-11 21:08:41',NULL,NULL),(108,2,52,'2013-06-01','100',100.00,'isadmin','2014-04-12 01:17:44',NULL,NULL),(109,4,52,'2013-06-15','83',83.00,'isadmin','2014-04-12 01:17:55',NULL,NULL),(110,11,52,'2013-06-12','99.9',99.90,'isadmin','2014-04-12 01:18:06',NULL,NULL),(111,15,52,'2013-06-22','10',10.00,'isadmin','2014-04-12 01:18:16',NULL,NULL),(112,5,52,'2013-06-16','15.6',15.60,'isadmin','2014-04-12 01:18:27',NULL,NULL),(113,5,52,'2013-06-15','55',55.00,'isadmin','2014-04-12 01:18:36',NULL,NULL),(114,13,52,'2013-06-29','23',23.00,'isadmin','2014-04-12 01:18:46',NULL,NULL),(115,2,53,'2013-07-02','33.33',33.33,'isadmin','2014-04-12 01:19:04',NULL,NULL),(116,5,53,'2013-07-04','4',4.00,'isadmin','2014-04-12 01:19:13',NULL,NULL),(117,9,53,'2013-07-27','96',96.00,'isadmin','2014-04-12 01:19:23',NULL,NULL),(118,13,53,'2013-07-11','96',96.00,'isadmin','2014-04-12 01:19:32',NULL,NULL),(119,15,53,'2013-07-19','55',55.00,'isadmin','2014-04-12 01:19:40',NULL,NULL),(120,1,54,'2013-07-17','300',300.00,'isadmin','2014-04-12 01:19:55',NULL,NULL),(121,13,56,'2013-07-27','206.3',206.30,'isadmin','2014-04-12 01:20:08',NULL,NULL),(122,13,58,'2013-09-23','700',700.00,'isadmin','2014-04-12 01:20:22',NULL,NULL),(123,3,59,'2013-09-12','250',250.00,'isadmin','2014-04-12 01:20:35',NULL,NULL),(124,8,55,'2013-07-27','300',300.00,'isadmin','2014-04-12 01:20:51',NULL,NULL),(125,1,82,'2014-04-26','55',55.00,'isadmin','2014-04-12 01:21:13',NULL,NULL),(126,7,61,'2013-09-11','45',45.00,'isadmin','2014-04-12 01:21:27',NULL,NULL),(127,6,60,'2013-09-17','1050',1050.00,'isadmin','2014-04-12 01:23:13',NULL,NULL),(128,9,62,'2013-09-07','1500',1500.00,'isadmin','2014-04-12 01:23:27',NULL,NULL),(129,13,64,'2013-10-04','1900',1900.00,'isadmin','2014-04-12 01:23:42',NULL,NULL),(130,15,65,'2013-10-12','500',500.00,'isadmin','2014-04-12 01:23:54',NULL,NULL),(131,11,57,'2013-08-17','680',680.00,'isadmin','2014-04-12 01:24:06',NULL,NULL),(132,12,66,'2013-01-12','300',300.00,'isadmin','2014-04-12 01:24:21',NULL,NULL),(133,14,67,'2013-11-16','250',250.00,'isadmin','2014-04-12 01:24:42',NULL,NULL),(134,2,69,'2013-12-14','330',330.00,'isadmin','2014-04-12 01:24:56',NULL,NULL),(135,6,68,'2013-11-07','300',300.00,'isadmin','2014-04-12 01:25:13',NULL,NULL),(136,9,72,'2014-02-10','600',600.00,'isadmin','2014-04-12 01:25:30',NULL,NULL),(137,13,70,'2014-01-10','690',690.00,'isadmin','2014-04-12 01:25:43',NULL,NULL),(139,8,74,'2014-02-14','1000',1000.00,'isadmin','2014-04-12 01:26:21',NULL,NULL),(140,6,76,'2014-03-17','560',560.00,'isadmin','2014-04-12 01:26:37',NULL,NULL),(141,4,75,'2014-03-07','1230',1230.00,'isadmin','2014-04-12 01:32:20',NULL,NULL),(142,6,79,'2014-03-08','555',555.00,'isadmin','2014-04-12 01:33:48',NULL,NULL),(143,1,77,'2014-03-14','50',50.00,'isadmin','2014-04-12 01:47:46',NULL,NULL),(144,15,78,'2014-03-08','30.2',30.20,'isadmin','2014-04-12 01:48:03',NULL,NULL),(145,1,83,'2014-02-13','300',300.00,'isadmin','2014-04-12 01:48:30',NULL,NULL),(146,1,63,'2013-09-12','50',50.00,'isadmin','2014-04-12 01:48:55','isadmin','2014-04-12 06:45:26'),(148,1,81,'2014-04-01','55',55.00,'isadmin','2014-04-12 06:42:54',NULL,NULL),(149,3,84,'2014-01-10','12',12.00,'isadmin','2014-04-12 06:56:45',NULL,NULL);
/*!40000 ALTER TABLE `claim_form_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dept`
--

DROP TABLE IF EXISTS `dept`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dept` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `DEPT_NAME` varchar(45) DEFAULT NULL,
  `OPS_AREA_ID` int(11) DEFAULT NULL,
  `REGION_ID` int(11) DEFAULT NULL,
  `TEL_NUMBER` varchar(45) DEFAULT NULL,
  `OFFICE_ADDR` varchar(255) DEFAULT NULL,
  `MANAGER_ID` int(11) DEFAULT NULL,
  `CREATE_BY` varchar(45) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_BY` varchar(45) DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`),
  KEY `FK_OPS_AREA_ID_idx` (`OPS_AREA_ID`),
  KEY `FK_REGION_ID_idx` (`REGION_ID`),
  KEY `FK_MANAGER_ID_idx` (`MANAGER_ID`),
  CONSTRAINT `m` FOREIGN KEY (`MANAGER_ID`) REFERENCES `users` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `o` FOREIGN KEY (`OPS_AREA_ID`) REFERENCES `md_ops_area` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `r` FOREIGN KEY (`REGION_ID`) REFERENCES `md_region` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dept`
--

LOCK TABLES `dept` WRITE;
/*!40000 ALTER TABLE `dept` DISABLE KEYS */;
INSERT INTO `dept` VALUES (4,'Account',6,1,'','Level 8, Geylang Rd Singapore 409286',38,'user1','2014-03-13 19:08:53','isadmin','2014-04-06 21:45:38'),(5,'Information Service',7,1,'98721655','Level 8, Geylang Rd Singapore 409286',32,'isadmin','2014-03-15 05:59:25','isadmin','2014-03-15 06:42:28'),(6,'HR',5,1,'98721658','Level 8, Geylang Rd Singapore 409286',NULL,'isadmin','2014-03-15 05:59:54',NULL,NULL),(7,'Global Sale Team 1',4,4,'98721620','Level 8, Geylang Rd Singapore 409286',NULL,'isadmin','2014-03-15 06:00:28',NULL,NULL);
/*!40000 ALTER TABLE `dept` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `md_claim_type`
--

DROP TABLE IF EXISTS `md_claim_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `md_claim_type` (
  `ID` int(11) NOT NULL,
  `CLAIM_TYPE` varchar(45) NOT NULL,
  `CREATE_BY` varchar(45) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_BY` varchar(45) DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `CLAIM_TYPE_UNIQUE` (`CLAIM_TYPE`),
  UNIQUE KEY `ID_UNIQUE` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `md_claim_type`
--

LOCK TABLES `md_claim_type` WRITE;
/*!40000 ALTER TABLE `md_claim_type` DISABLE KEYS */;
INSERT INTO `md_claim_type` VALUES (1,'Allowance (Shift)',NULL,NULL,NULL,NULL),(2,'Allowance (Meal)',NULL,NULL,NULL,NULL),(3,'Transport (Airfare)',NULL,NULL,NULL,NULL),(4,'Transport (MRT/Bus)',NULL,NULL,NULL,NULL),(5,'Transport (Taxi)',NULL,NULL,NULL,NULL),(6,'Transport (Rental Car)',NULL,NULL,NULL,NULL),(7,'Transport (Parking)',NULL,NULL,NULL,NULL),(8,'Transport (Train)',NULL,NULL,NULL,NULL),(9,'Transport (Other)',NULL,NULL,NULL,NULL),(10,'Miscellaneous (Phone)',NULL,NULL,NULL,NULL),(11,'Miscellaneous (Hotel)',NULL,NULL,NULL,NULL),(12,'Miscellaneous (Visa)',NULL,NULL,NULL,NULL),(13,'Miscellaneous (Meeting)',NULL,NULL,NULL,NULL),(14,'Miscellaneous (Laundry)',NULL,NULL,NULL,NULL),(15,'Other',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `md_claim_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `md_form_status`
--

DROP TABLE IF EXISTS `md_form_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `md_form_status` (
  `ID` int(11) NOT NULL,
  `FORM_STATUS` varchar(45) NOT NULL,
  `CREATE_BY` varchar(45) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_BY` varchar(45) DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `FORM_STATUS_UNIQUE` (`FORM_STATUS`),
  UNIQUE KEY `ID_UNIQUE` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `md_form_status`
--

LOCK TABLES `md_form_status` WRITE;
/*!40000 ALTER TABLE `md_form_status` DISABLE KEYS */;
INSERT INTO `md_form_status` VALUES (1,'Saved',NULL,NULL,NULL,NULL),(2,'Submited',NULL,NULL,NULL,NULL),(3,'Department Approved',NULL,NULL,NULL,NULL),(4,'Financia Approved',NULL,NULL,NULL,NULL),(5,'Rejected',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `md_form_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `md_ops_area`
--

DROP TABLE IF EXISTS `md_ops_area`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `md_ops_area` (
  `ID` int(11) NOT NULL,
  `AREA_NAME` varchar(45) NOT NULL,
  `IS_FINANCIAL` varchar(1) NOT NULL,
  `CREATE_BY` varchar(45) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_BY` varchar(45) DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `AREA_NAME_UNIQUE` (`AREA_NAME`),
  UNIQUE KEY `ID_UNIQUE` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `md_ops_area`
--

LOCK TABLES `md_ops_area` WRITE;
/*!40000 ALTER TABLE `md_ops_area` DISABLE KEYS */;
INSERT INTO `md_ops_area` VALUES (1,'Sale-Singapore','N','Administrator','2014-02-28 00:00:00',NULL,NULL),(2,'Sale-Malaysia','N','Administrator','2014-02-28 00:00:00',NULL,NULL),(3,'Sale-China','N','Administrator','2014-02-28 00:00:00',NULL,NULL),(4,'Sale-India','N','Administrator','2014-02-28 00:00:00',NULL,NULL),(5,'Human Resource','N','Administrator','2014-02-28 00:00:00',NULL,NULL),(6,'Finacial','Y','Administrator','2014-02-28 00:00:00',NULL,NULL),(7,'Information','N','Administrator','2014-02-28 00:00:00',NULL,NULL);
/*!40000 ALTER TABLE `md_ops_area` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `md_region`
--

DROP TABLE IF EXISTS `md_region`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `md_region` (
  `ID` int(11) NOT NULL,
  `REGION_NAME` varchar(45) NOT NULL,
  `CREATE_BY` varchar(45) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_BY` varchar(45) DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `REGION_NAME_UNIQUE` (`REGION_NAME`),
  UNIQUE KEY `ID_UNIQUE` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `md_region`
--

LOCK TABLES `md_region` WRITE;
/*!40000 ALTER TABLE `md_region` DISABLE KEYS */;
INSERT INTO `md_region` VALUES (1,'Singapore','Administrator','2014-02-28 00:00:00',NULL,NULL),(2,'Malaysia-Kuala Lumpur','Administrator','2014-02-28 00:00:00',NULL,NULL),(3,'Malaysia-Johor Bahru','Administrator','2014-02-28 00:00:00',NULL,NULL),(4,'India-New Delhi','Administrator','2014-02-28 00:00:00',NULL,NULL),(5,'China-Beijing','Administrator','2014-02-28 00:00:00',NULL,NULL),(6,'China-Shanghai','Administrator','2014-02-28 00:00:00',NULL,NULL);
/*!40000 ALTER TABLE `md_region` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_NAME` varchar(45) DEFAULT NULL,
  `PASSWORD` varchar(45) DEFAULT NULL,
  `FIRST_NAME` varchar(45) DEFAULT NULL,
  `LAST_NAME` varchar(45) DEFAULT NULL,
  `GENDER` varchar(1) DEFAULT NULL,
  `BIRTH_DATE` date DEFAULT NULL,
  `EMAIL_ADDR` varchar(255) DEFAULT NULL,
  `IS_ADMIN` varchar(1) DEFAULT NULL,
  `DEPT_ID` int(11) DEFAULT NULL,
  `CREATE_BY` varchar(45) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `UPDATE_BY` varchar(45) DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_UNIQUE` (`ID`),
  KEY `FK_DEPT_ID_idx` (`DEPT_ID`),
  CONSTRAINT `d` FOREIGN KEY (`DEPT_ID`) REFERENCES `dept` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (32,'isadmin','root','System Administrator','IS','M','1989-01-01','isadmin@google.com','Y',5,NULL,NULL,'isadmin','2014-04-06 21:56:28'),(34,'hr-user1','root','User','One','F','1976-01-15','hr-user1@gmail.com','N',6,'isadmin','2014-03-15 05:46:59',NULL,'2014-03-15 06:00:45'),(35,'hr-user2','root','User','Two','M','1993-01-06','hr-user2@gmail.com','N',6,'isadmin','2014-03-15 05:47:27',NULL,'2014-03-15 06:00:51'),(36,'hr-user3-manager','root','User','Thress','M','1989-01-01','hr-user3-manager@gmail.com','N',6,'isadmin','2014-03-15 05:48:16','isadmin','2014-04-12 01:11:35'),(37,'account-user1','root','Jacky','Liang','M','1989-01-18','financial-user1@gmail.com','N',4,'isadmin','2014-03-15 05:48:58','isadmin','2014-04-12 01:11:50'),(38,'account-user2-manager','root','Judy','Wang','F','1974-01-09','account-user2-manager@gmail.com','N',4,'isadmin','2014-03-15 05:49:26','isadmin','2014-04-12 01:10:47');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-04-12  6:58:55
