CREATE DATABASE  IF NOT EXISTS `st` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `st`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: st
-- ------------------------------------------------------
-- Server version	5.5.10

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
-- Table structure for table `st_curso`
--

DROP TABLE IF EXISTS `st_curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `st_curso` (
  `CodigoCurso` int(11) NOT NULL AUTO_INCREMENT,
  `NombreCurso` varchar(50) NOT NULL,
  `CodigoCursoTipo` int(11) DEFAULT NULL,
  `MaximaCantidadHorasCurso` int(11) NOT NULL,
  PRIMARY KEY (`CodigoCurso`),
  KEY `R_1` (`CodigoCursoTipo`),
  CONSTRAINT `st_curso_ibfk_1` FOREIGN KEY (`CodigoCursoTipo`) REFERENCES `st_cursotipo` (`CodigoCursoTipo`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `st_curso`
--

LOCK TABLES `st_curso` WRITE;
/*!40000 ALTER TABLE `st_curso` DISABLE KEYS */;
INSERT INTO `st_curso` VALUES (1,'PHP',1,44),(2,'NET',1,25),(3,'Java',1,40),(4,'MS  SQL Server',2,4),(5,'MySQL',2,30),(6,'Oracle',2,16),(7,'XML',3,50),(8,'Web Services',3,52);
/*!40000 ALTER TABLE `st_curso` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-11-25 19:16:21
