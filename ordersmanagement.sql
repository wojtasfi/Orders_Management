-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: ordersmanagement
-- ------------------------------------------------------
-- Server version	5.7.13-log

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
-- Table structure for table `clients`
--

DROP TABLE IF EXISTS `clients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clients` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `surname` varchar(20) DEFAULT NULL,
  `street` varchar(30) DEFAULT NULL,
  `houseNumber` int(11) DEFAULT NULL,
  `zip` varchar(6) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clients`
--

LOCK TABLES `clients` WRITE;
/*!40000 ALTER TABLE `clients` DISABLE KEYS */;
INSERT INTO `clients` VALUES (1,'Wojciech','Figas','Hamber Pl',20,'56-987','Vancouver'),(2,'Agatka','Figas','Hboken',10,'56-987','Poznan'),(3,'Tomasz','Figas','Plaza Pl',40,'56-987','Toronto'),(9,'Adam','Słodowy','Piekna',8,'55-234','Toruń');
/*!40000 ALTER TABLE `clients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `c_name` varchar(20) DEFAULT NULL,
  `c_surname` varchar(20) DEFAULT NULL,
  `product` varchar(20) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `deadline` date DEFAULT NULL,
  `status` varchar(15) DEFAULT 'Not started',
  `LOAD_DTE` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (3,'Wojciech','Figas','Dress',1,'2016-08-23','Not started','2016-08-23 00:00:00'),(4,'Wojciech','Figas','Shirt',4,'2016-08-23','Not started','2016-08-23 00:00:00'),(5,'Agatka','Figas','Shirt',4,'2016-08-23','Not started','2016-08-23 00:00:00'),(6,'Agatka','Figas','Shirt',4,'2016-08-23','Not started','2016-08-23 00:00:00'),(7,'Agatka','Figas','Shirt',4,'2016-08-23','Not started','2016-08-23 00:00:00'),(8,'Agatka','Figas','Dress',2,'2016-08-24','Not started','2016-08-24 00:00:00'),(9,'Agatka','Figas','Dress',2,'2016-08-24','Not started','2016-08-24 00:00:00'),(10,'Wojciech','Figas','Dress',2,'2016-08-23','Not started','2016-08-23 00:00:00'),(11,'Wojciech','Figas','Dress',2,'2016-08-23','Not started','2016-08-23 00:00:00'),(12,'Wojciech','Figas','Dress',1,'2016-08-23','Not started','2016-08-23 00:00:00'),(13,'Wojciech','Figas','Dress',2,'2016-08-23','Not started','2016-08-23 00:00:00'),(14,'Wojciech','Figas','Dress',2,'2016-08-23','Not started','2016-08-23 00:00:00'),(16,'Wojciech','Figas','Dress',2,'2016-08-23','Not started','2016-08-23 00:00:00'),(17,'Wojciech','Figas','Shirt',3,'2016-08-23','Not started','2016-08-23 00:00:00'),(18,'Wojciech','Figas','Shirt',3,'2016-08-23','Not started','2016-08-23 00:00:00'),(19,'Wojciech','Figas','Dress',2,'2016-08-23','Not started','2016-08-23 00:00:00'),(21,'Wojciech','Figas','Shirt',3,'2016-08-23','Not started','2016-08-23 00:00:00'),(22,'Agatka','Figas','Shirt',3,'2016-08-23','Not started','2016-08-23 00:00:00'),(23,'Wojciech','Figas','Dress',2,'2016-08-23','Not started','2016-08-23 00:00:00'),(25,'Wojciech','Figas','Shirt',3,'2016-08-23','Not started','2016-08-23 00:00:00'),(26,'Agatka','Figas','Shirt',3,'2016-08-23','Not started','2016-08-23 00:00:00'),(27,'Agatka','Figas','Shirt',3,'2016-08-23','Not started','2016-08-23 00:00:00'),(28,'Tomasz','Figas','Shoes',1,'2016-08-23','Not started','2016-08-23 00:00:00'),(29,'Tomasz','Figas','Shoes',1,'2016-08-23','Not started','2016-08-23 00:00:00'),(30,'Tomasz','Figas','Shirt',1,'2016-08-23','Not started','2016-08-23 00:00:00'),(31,'Wojciech','Figas','Dress',1,'2016-08-23','Not started','2016-08-23 00:00:00'),(32,'Wojciech','Figas','Dress',1,'2016-08-23','Not started','2016-08-23 00:00:00'),(33,'Wojciech','Figas','Dress',1,'2016-08-23','Not started','2016-08-23 00:00:00'),(34,'Wojciech','Figas','Dress',1,'2016-08-23','Not started','2016-08-23 00:00:00'),(35,'Wojciech','Figas','Dress',4,'2016-08-23','Not started','2016-08-23 00:00:00'),(36,'Wojciech','Figas','Dress',1,'2016-08-24','Not started','2016-08-24 00:00:00'),(37,'Wojciech','Figas','Dress',0,'2016-08-24','Not started','2016-08-24 00:00:00'),(38,'Wojciech','Figas','Dress',0,'2016-08-24','Not started','2016-08-24 00:00:00'),(39,'Wojciech','Figas','Dress',0,'2016-08-24','Not started','2016-08-24 00:00:00'),(40,'Wojciech','Figas','Dress',0,'2016-08-24','Not started','2016-08-24 00:00:00'),(41,'Wojciech','Figas','Dress',0,'2016-08-24','Not started','2016-08-24 00:00:00'),(42,'Wojciech','Figas','Dress',0,'2016-08-24','Not started','2016-08-24 00:00:00'),(43,'Wojciech','Figas','Dress',0,'2016-08-24','Not started','2016-08-24 00:00:00');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `products` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(20) DEFAULT NULL,
  `Price` float DEFAULT NULL,
  `Storage` int(11) DEFAULT NULL,
  `Comment` text,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'Dress',35.99,5,NULL),(2,'Shirt',25.99,15,NULL),(3,'Shoes',155.99,3,NULL),(4,'Jeans',60.78,0,NULL),(6,'Hat',5.99,50,NULL);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-18 11:43:08
