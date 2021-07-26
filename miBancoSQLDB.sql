CREATE DATABASE  IF NOT EXISTS `mibanco` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `mibanco`;
-- MySQL dump 10.13  Distrib 8.0.24, for Win64 (x86_64)
--
-- Host: localhost    Database: mibanco
-- ------------------------------------------------------
-- Server version	8.0.25

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
-- Table structure for table `CLIENTE`
--

DROP TABLE IF EXISTS `CLIENTE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `CLIENTE` (
  `rut` varchar(20) NOT NULL,
  `nombre` varchar(20) DEFAULT NULL,
  `apellido` varchar(20) DEFAULT NULL,
  `clave` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`rut`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CLIENTE`
--

LOCK TABLES `CLIENTE` WRITE;
/*!40000 ALTER TABLE `CLIENTE` DISABLE KEYS */;
INSERT INTO `CLIENTE` VALUES ('c-1','Pablo','Rojas','123'),('c-2','Maria','Poblete','123');
/*!40000 ALTER TABLE `CLIENTE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CUENTA`
--

DROP TABLE IF EXISTS `CUENTA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `CUENTA` (
  `numerocta` int NOT NULL,
  `saldo` int DEFAULT NULL,
  `clavetransaccion` varchar(100) DEFAULT NULL,
  `saldolineacredito` int DEFAULT NULL,
  `saldolineacreditousado` int DEFAULT NULL,
  `estado` int DEFAULT NULL,
  `clienteFK` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`numerocta`),
  KEY `clienteFK` (`clienteFK`),
  CONSTRAINT `CUENTA_ibfk_1` FOREIGN KEY (`clienteFK`) REFERENCES `CLIENTE` (`rut`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CUENTA`
--

LOCK TABLES `CUENTA` WRITE;
/*!40000 ALTER TABLE `CUENTA` DISABLE KEYS */;
INSERT INTO `CUENTA` VALUES (111111,84600,'123',400000,0,1,'c-1'),(222222,110400,'123',400000,0,1,'c-2');
/*!40000 ALTER TABLE `CUENTA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MOVIMIENTOS`
--

DROP TABLE IF EXISTS `MOVIMIENTOS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `MOVIMIENTOS` (
  `idmovimiento` int NOT NULL AUTO_INCREMENT,
  `fecha` date DEFAULT NULL,
  `descripcion` varchar(200) DEFAULT NULL,
  `cuentaFK` int DEFAULT NULL,
  PRIMARY KEY (`idmovimiento`),
  KEY `cuentaFK` (`cuentaFK`),
  CONSTRAINT `MOVIMIENTOS_ibfk_1` FOREIGN KEY (`cuentaFK`) REFERENCES `CUENTA` (`numerocta`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=89 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MOVIMIENTOS`
--

LOCK TABLES `MOVIMIENTOS` WRITE;
/*!40000 ALTER TABLE `MOVIMIENTOS` DISABLE KEYS */;
INSERT INTO `MOVIMIENTOS` VALUES (1,'2018-12-12','deposito por 100000',111111),(2,'2018-12-10','deposito por 100000',222222),(81,'2021-07-26','Transferencia por 400',111111),(82,'2021-07-26','Deposito por $400',222222),(83,'2021-07-26','Transferencia por 5000',111111),(85,'2021-07-26','Transferencia por 5000',111111),(86,'2021-07-26','Deposito por $5000',222222),(87,'2021-07-26','Transferencia por 5000',111111),(88,'2021-07-26','Deposito por $5000',222222);
/*!40000 ALTER TABLE `MOVIMIENTOS` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-26 12:55:07
