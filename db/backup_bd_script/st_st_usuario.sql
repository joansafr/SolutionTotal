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
-- Table structure for table `st_usuario`
--

DROP TABLE IF EXISTS `st_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `st_usuario` (
  `NombreUsuario` varchar(50) NOT NULL,
  `ApellidoPaternoUsuario` varchar(50) NOT NULL,
  `ApellidoMaternoUsuario` varchar(50) DEFAULT NULL,
  `CorreoElectronicoUsuario` varchar(50) DEFAULT NULL,
  `TelefonoFijoUsuario` varchar(15) DEFAULT NULL,
  `TelefonoMovilUsuario` varchar(15) DEFAULT NULL,
  `IdentificadorUsuario` varchar(20) NOT NULL,
  `ContrasenaUsuario` varchar(64) NOT NULL,
  `CodigoUsuarioTipo` int(11) DEFAULT NULL,
  `CodigoUsuario` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`CodigoUsuario`),
  UNIQUE KEY `IdentificadorUsuario_UNIQUE` (`IdentificadorUsuario`),
  KEY `FK_UsuarioTipo_CodigoUsuarioTipo_idx` (`CodigoUsuarioTipo`),
  CONSTRAINT `FK_UsuarioTipo_CodigoUsuarioTipo` FOREIGN KEY (`CodigoUsuarioTipo`) REFERENCES `st_usuariotipo` (`CodigoUsuarioTipo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `st_usuario`
--

LOCK TABLES `st_usuario` WRITE;
/*!40000 ALTER TABLE `st_usuario` DISABLE KEYS */;
INSERT INTO `st_usuario` VALUES ('Administrador','de todo','el Sistema','admin@admin.com','2547165','986626545','admin','8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918',1,1),('Jose','Salinas','',NULL,NULL,NULL,'jsalinas','f231855a7f3910088e8bf958b0cd16825ad5a7d07c63c6e3fad2133f55d62884',3,2),('Luis','Muga','',NULL,NULL,NULL,'lmuga','a3557462b5280c4b0409311039341dfa3ea7eefb2c066978c60ea4e950230d97',2,3),('Gustavo','Coronel','',NULL,NULL,NULL,'gcoronel','e3b08da16a39f12b12bd80f145f26757556101b4b1d5620d71aba8f3314105b0',1,4);
/*!40000 ALTER TABLE `st_usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-11-25 19:16:20
