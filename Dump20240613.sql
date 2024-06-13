CREATE DATABASE  IF NOT EXISTS `indus` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `indus`;
-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: indus
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `user_bank_tbl`
--

DROP TABLE IF EXISTS `user_bank_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_bank_tbl` (
  `bank_detail_id` bigint NOT NULL,
  `account_number` varchar(255) DEFAULT NULL,
  `bank_ifsc` varchar(255) DEFAULT NULL,
  `bank_name` varchar(255) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`bank_detail_id`),
  UNIQUE KEY `UKo9mhqhx99cquvw5sbjxqfx2bu` (`user_id`),
  CONSTRAINT `FKlvm8xgkg7h62tr8276vho6696` FOREIGN KEY (`user_id`) REFERENCES `user_tbl` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_bank_tbl`
--

LOCK TABLES `user_bank_tbl` WRITE;
/*!40000 ALTER TABLE `user_bank_tbl` DISABLE KEYS */;
INSERT INTO `user_bank_tbl` VALUES (1,'1234567890123','BKIND123','Bank of India',1),(2,'1234567890123','BKIND123','Bank of India',2),(3,'1234567890123','BKIND123','Bank of India',3),(4,'1234567890123','BKIND123','Bank of India',4),(52,'1234567890123','BKIND123','Bank of India',52);
/*!40000 ALTER TABLE `user_bank_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_bank_tbl_seq`
--

DROP TABLE IF EXISTS `user_bank_tbl_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_bank_tbl_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_bank_tbl_seq`
--

LOCK TABLES `user_bank_tbl_seq` WRITE;
/*!40000 ALTER TABLE `user_bank_tbl_seq` DISABLE KEYS */;
INSERT INTO `user_bank_tbl_seq` VALUES (151);
/*!40000 ALTER TABLE `user_bank_tbl_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_tbl`
--

DROP TABLE IF EXISTS `user_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_tbl` (
  `user_id` bigint NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_tbl`
--

LOCK TABLES `user_tbl` WRITE;
/*!40000 ALTER TABLE `user_tbl` DISABLE KEYS */;
INSERT INTO `user_tbl` VALUES (1,'ravita@yopmail.com','Ravita','Prajapati','8978899089'),(2,'radhika@yopmail.com','Radhika','Prajapati','8978899081'),(3,'niharika@yopmail.com','Niharika','Prajapati','8978899080'),(4,'piush@yopmail.com','Piush','Gupta','8978899056'),(52,'pankaj@yopmail.com','Pankaj','Gupta','8978899078');
/*!40000 ALTER TABLE `user_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_tbl_seq`
--

DROP TABLE IF EXISTS `user_tbl_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_tbl_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_tbl_seq`
--

LOCK TABLES `user_tbl_seq` WRITE;
/*!40000 ALTER TABLE `user_tbl_seq` DISABLE KEYS */;
INSERT INTO `user_tbl_seq` VALUES (151);
/*!40000 ALTER TABLE `user_tbl_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_txn_tbl`
--

DROP TABLE IF EXISTS `user_txn_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_txn_tbl` (
  `txn_id` bigint NOT NULL,
  `amount` double DEFAULT NULL,
  `commission` double DEFAULT NULL,
  `gst` double DEFAULT NULL,
  `service` varchar(255) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`txn_id`),
  KEY `FKf9e8tasvk7dpwvwr19kdff5er` (`user_id`),
  CONSTRAINT `FKf9e8tasvk7dpwvwr19kdff5er` FOREIGN KEY (`user_id`) REFERENCES `user_tbl` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_txn_tbl`
--

LOCK TABLES `user_txn_tbl` WRITE;
/*!40000 ALTER TABLE `user_txn_tbl` DISABLE KEYS */;
INSERT INTO `user_txn_tbl` VALUES (1,100,10,12,'Payment Gateway Provider',1),(2,200,5,10,'Payment Gateway Provider',1),(3,300,5,10,'Payment Gateway Provider',2),(4,500,15,30,'Payment Gateway Provider',2),(5,400,15,30,'Payment Gateway Provider',4),(6,500,15,20,'Payment Gateway Provider',3),(7,700,15,50,'Payment Gateway Provider',4),(52,700,15,50,'Payment Gateway Provider',52);
/*!40000 ALTER TABLE `user_txn_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_txn_tbl_seq`
--

DROP TABLE IF EXISTS `user_txn_tbl_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_txn_tbl_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_txn_tbl_seq`
--

LOCK TABLES `user_txn_tbl_seq` WRITE;
/*!40000 ALTER TABLE `user_txn_tbl_seq` DISABLE KEYS */;
INSERT INTO `user_txn_tbl_seq` VALUES (151);
/*!40000 ALTER TABLE `user_txn_tbl_seq` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-13 23:43:07
