-- MySQL dump 10.13  Distrib 5.5.9, for Win32 (x86)
--
-- Host: localhost    Database: mackenzie
-- ------------------------------------------------------
-- Server version	5.5.15

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
-- Current Database: `mackenzie`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `mackenzie` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `mackenzie`;

--
-- Table structure for table `tbcasacentral`
--

DROP TABLE IF EXISTS `tbcasacentral`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbcasacentral` (
  `IdConstrucao` int(11) NOT NULL,
  `IdOvo` int(11) DEFAULT NULL,
  PRIMARY KEY (`IdConstrucao`),
  KEY `FKEFE495B4FA2D166` (`IdConstrucao`),
  KEY `FKEFE495B5D15A704` (`IdOvo`),
  CONSTRAINT `FKEFE495B5D15A704` FOREIGN KEY (`IdOvo`) REFERENCES `tbdragao` (`IdDragao`),
  CONSTRAINT `FKEFE495B4FA2D166` FOREIGN KEY (`IdConstrucao`) REFERENCES `tbconstrucao` (`IdConstrucao`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbcasacentral`
--

LOCK TABLES `tbcasacentral` WRITE;
/*!40000 ALTER TABLE `tbcasacentral` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbcasacentral` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbconstrucao`
--

DROP TABLE IF EXISTS `tbconstrucao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbconstrucao` (
  `IdConstrucao` int(11) NOT NULL,
  `IdMapaLocal` int(11) DEFAULT NULL,
  PRIMARY KEY (`IdConstrucao`),
  KEY `FKE78D4E395960917` (`IdConstrucao`),
  KEY `FKE78D4E397C378EDC` (`IdMapaLocal`),
  CONSTRAINT `FKE78D4E397C378EDC` FOREIGN KEY (`IdMapaLocal`) REFERENCES `tbmapalocal` (`ID`),
  CONSTRAINT `FKE78D4E395960917` FOREIGN KEY (`IdConstrucao`) REFERENCES `tbentidade` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbconstrucao`
--

LOCK TABLES `tbconstrucao` WRITE;
/*!40000 ALTER TABLE `tbconstrucao` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbconstrucao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbdragao`
--

DROP TABLE IF EXISTS `tbdragao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbdragao` (
  `Level` int(11) DEFAULT NULL,
  `NomeDragao` varchar(255) DEFAULT NULL,
  `TotalExperiencia` int(11) DEFAULT NULL,
  `IdDragao` int(11) NOT NULL,
  `IdDragaoTipo` int(11) DEFAULT NULL,
  `IdJogo` int(11) DEFAULT NULL,
  PRIMARY KEY (`IdDragao`),
  KEY `FKCCA8AC705B34ECEA` (`IdJogo`),
  KEY `FKCCA8AC70B61695CE` (`IdDragao`),
  KEY `FKCCA8AC70EE20385C` (`IdDragaoTipo`),
  CONSTRAINT `FKCCA8AC70EE20385C` FOREIGN KEY (`IdDragaoTipo`) REFERENCES `tbdragaotipo` (`Id`),
  CONSTRAINT `FKCCA8AC705B34ECEA` FOREIGN KEY (`IdJogo`) REFERENCES `tbjogo` (`ID`),
  CONSTRAINT `FKCCA8AC70B61695CE` FOREIGN KEY (`IdDragao`) REFERENCES `tbentidade` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbdragao`
--

LOCK TABLES `tbdragao` WRITE;
/*!40000 ALTER TABLE `tbdragao` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbdragao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbdragaoestado`
--

DROP TABLE IF EXISTS `tbdragaoestado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbdragaoestado` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Imagem` varchar(255) DEFAULT NULL,
  `LevelDe` int(11) DEFAULT NULL,
  `LevalPara` int(11) DEFAULT NULL,
  `NomeEstado` varchar(255) DEFAULT NULL,
  `IdDragaoTipo` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `FKFF7ABDF6EE20385C` (`IdDragaoTipo`),
  CONSTRAINT `FKFF7ABDF6EE20385C` FOREIGN KEY (`IdDragaoTipo`) REFERENCES `tbdragaotipo` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbdragaoestado`
--

LOCK TABLES `tbdragaoestado` WRITE;
/*!40000 ALTER TABLE `tbdragaoestado` DISABLE KEYS */;
INSERT INTO `tbdragaoestado` VALUES (1,NULL,0,0,'Ovo',1),(2,NULL,1,5,'Bebê',1),(3,NULL,6,12,'Semi-Adulto',1),(4,NULL,13,20,'Adulto',1),(5,NULL,0,0,'Ovo',2),(6,NULL,1,5,'Bebê',2),(7,NULL,6,12,'Semi-Adulto',2),(8,NULL,13,20,'Adulto',2),(9,NULL,0,0,'Ovo',3),(11,NULL,6,12,'Semi-Adulto',3),(12,NULL,13,20,'Adulto',3),(13,NULL,0,0,'Ovo',4),(14,NULL,1,5,'Bebê',4),(15,NULL,6,12,'Semi-Adulto',4),(16,NULL,13,20,'Adulto',4),(17,NULL,0,0,'Ovo',5),(18,NULL,1,5,'Bebê',5),(19,NULL,6,12,'Semi-Adulto',5),(20,NULL,13,20,'Adulto',5),(21,NULL,0,0,'Ovo',6),(22,NULL,1,5,'Bebê',6),(23,NULL,6,12,'Semi-Adulto',6),(24,NULL,13,20,'Adulto',6);
/*!40000 ALTER TABLE `tbdragaoestado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbdragaotipo`
--

DROP TABLE IF EXISTS `tbdragaotipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbdragaotipo` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `LevelJogadorRequerido` int(11) DEFAULT NULL,
  `NomeTipoDragao` varchar(255) DEFAULT NULL,
  `OuroFornece` int(11) DEFAULT NULL,
  `PontosXPFornece` int(11) DEFAULT NULL,
  `Valor` int(11) DEFAULT NULL,
  `oHabitatTipo_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `FKB6C4BBC45A6A4D14` (`oHabitatTipo_ID`),
  CONSTRAINT `FKB6C4BBC45A6A4D14` FOREIGN KEY (`oHabitatTipo_ID`) REFERENCES `tbhabitattipo` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbdragaotipo`
--

LOCK TABLES `tbdragaotipo` WRITE;
/*!40000 ALTER TABLE `tbdragaotipo` DISABLE KEYS */;
INSERT INTO `tbdragaotipo` VALUES (1,1,'Fogo',10,10,100,1),(2,3,'Água',20,20,150,2),(3,5,'Gelo',30,30,200,3),(4,7,'Planta',40,40,250,4),(5,10,'Aço',50,50,300,5),(6,15,'Raio',100,100,400,6);
/*!40000 ALTER TABLE `tbdragaotipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbentidade`
--

DROP TABLE IF EXISTS `tbentidade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbentidade` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Imagem` varchar(255) DEFAULT NULL,
  `PontosXP` int(11) DEFAULT NULL,
  `Valor` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbentidade`
--

LOCK TABLES `tbentidade` WRITE;
/*!40000 ALTER TABLE `tbentidade` DISABLE KEYS */;
INSERT INTO `tbentidade` VALUES (1,NULL,20,20);
/*!40000 ALTER TABLE `tbentidade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbfazenda`
--

DROP TABLE IF EXISTS `tbfazenda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbfazenda` (
  `IdFazenda` int(11) NOT NULL,
  PRIMARY KEY (`IdFazenda`),
  KEY `FK169688372DEF99EA` (`IdFazenda`),
  CONSTRAINT `FK169688372DEF99EA` FOREIGN KEY (`IdFazenda`) REFERENCES `tbconstrucao` (`IdConstrucao`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbfazenda`
--

LOCK TABLES `tbfazenda` WRITE;
/*!40000 ALTER TABLE `tbfazenda` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbfazenda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbfruta`
--

DROP TABLE IF EXISTS `tbfruta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbfruta` (
  `Nome` varchar(255) DEFAULT NULL,
  `QuantidadeAlimento` int(11) DEFAULT NULL,
  `IdFruta` int(11) NOT NULL,
  PRIMARY KEY (`IdFruta`),
  KEY `FKA39DCB8822992DAC` (`IdFruta`),
  CONSTRAINT `FKA39DCB8822992DAC` FOREIGN KEY (`IdFruta`) REFERENCES `tbentidade` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbfruta`
--

LOCK TABLES `tbfruta` WRITE;
/*!40000 ALTER TABLE `tbfruta` DISABLE KEYS */;
INSERT INTO `tbfruta` VALUES ('Fruta',20,1);
/*!40000 ALTER TABLE `tbfruta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbhabitat`
--

DROP TABLE IF EXISTS `tbhabitat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbhabitat` (
  `IdHabitat` int(11) NOT NULL,
  `IdHabitatTipo` int(11) DEFAULT NULL,
  `IdDragao` int(11) DEFAULT NULL,
  PRIMARY KEY (`IdHabitat`),
  KEY `FK7F12B259966BC40C` (`IdHabitat`),
  KEY `FK7F12B2597F7C3FC6` (`IdHabitatTipo`),
  KEY `FK7F12B2594D8227D4` (`IdDragao`),
  CONSTRAINT `FK7F12B2594D8227D4` FOREIGN KEY (`IdDragao`) REFERENCES `tbdragao` (`IdDragao`),
  CONSTRAINT `FK7F12B2597F7C3FC6` FOREIGN KEY (`IdHabitatTipo`) REFERENCES `tbhabitattipo` (`ID`),
  CONSTRAINT `FK7F12B259966BC40C` FOREIGN KEY (`IdHabitat`) REFERENCES `tbconstrucao` (`IdConstrucao`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbhabitat`
--

LOCK TABLES `tbhabitat` WRITE;
/*!40000 ALTER TABLE `tbhabitat` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbhabitat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbhabitattipo`
--

DROP TABLE IF EXISTS `tbhabitattipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbhabitattipo` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `PontosXPFornecido` int(11) DEFAULT NULL,
  `Tipo` varchar(255) DEFAULT NULL,
  `Valor` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbhabitattipo`
--

LOCK TABLES `tbhabitattipo` WRITE;
/*!40000 ALTER TABLE `tbhabitattipo` DISABLE KEYS */;
INSERT INTO `tbhabitattipo` VALUES (1,30,'Fogo',100),(2,60,'Água',150),(3,90,'Gelo',200),(4,120,'Planta',250),(5,150,'Aço',300),(6,180,'Raio',400);
/*!40000 ALTER TABLE `tbhabitattipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbjogador`
--

DROP TABLE IF EXISTS `tbjogador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbjogador` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `DataUltimoAcesso` datetime DEFAULT NULL,
  `Login` varchar(255) DEFAULT NULL,
  `Nome` varchar(255) DEFAULT NULL,
  `Senha` varchar(255) DEFAULT NULL,
  `IdJogo` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK10599BA5B34ECEA` (`IdJogo`),
  CONSTRAINT `FK10599BA5B34ECEA` FOREIGN KEY (`IdJogo`) REFERENCES `tbjogo` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbjogador`
--

LOCK TABLES `tbjogador` WRITE;
/*!40000 ALTER TABLE `tbjogador` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbjogador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbjogo`
--

DROP TABLE IF EXISTS `tbjogo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbjogo` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `QtdTotalPontosXP` int(11) DEFAULT NULL,
  `VlrTotalComida` int(11) DEFAULT NULL,
  `VlrTotalOuro` int(11) DEFAULT NULL,
  `IdJogador` int(11) DEFAULT NULL,
  `IdMapa` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKCB7A787B5B37401A` (`IdMapa`),
  KEY `FKCB7A787BD3F44300` (`IdJogador`),
  CONSTRAINT `FKCB7A787BD3F44300` FOREIGN KEY (`IdJogador`) REFERENCES `tbjogador` (`ID`),
  CONSTRAINT `FKCB7A787B5B37401A` FOREIGN KEY (`IdMapa`) REFERENCES `tbmapa` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbjogo`
--

LOCK TABLES `tbjogo` WRITE;
/*!40000 ALTER TABLE `tbjogo` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbjogo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbmapa`
--

DROP TABLE IF EXISTS `tbmapa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbmapa` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbmapa`
--

LOCK TABLES `tbmapa` WRITE;
/*!40000 ALTER TABLE `tbmapa` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbmapa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbmapalocal`
--

DROP TABLE IF EXISTS `tbmapalocal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbmapalocal` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `PosicaoX` int(11) DEFAULT NULL,
  `PosicaoY` int(11) DEFAULT NULL,
  `IdConstrucao` int(11) DEFAULT NULL,
  `IdMapa` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKBF48A1184FA2D166` (`IdConstrucao`),
  KEY `FKBF48A1185B37401A` (`IdMapa`),
  CONSTRAINT `FKBF48A1185B37401A` FOREIGN KEY (`IdMapa`) REFERENCES `tbmapa` (`ID`),
  CONSTRAINT `FKBF48A1184FA2D166` FOREIGN KEY (`IdConstrucao`) REFERENCES `tbconstrucao` (`IdConstrucao`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbmapalocal`
--

LOCK TABLES `tbmapalocal` WRITE;
/*!40000 ALTER TABLE `tbmapalocal` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbmapalocal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbnivel`
--

DROP TABLE IF EXISTS `tbnivel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbnivel` (
  `ID` int(11) NOT NULL,
  `AtePontosXP` int(11) DEFAULT NULL,
  `DePontosXP` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbnivel`
--

LOCK TABLES `tbnivel` WRITE;
/*!40000 ALTER TABLE `tbnivel` DISABLE KEYS */;
INSERT INTO `tbnivel` VALUES (1,99,0),(2,199,100),(3,299,200),(4,399,300),(5,499,400),(6,599,500),(7,699,600),(8,799,700),(9,899,800),(10,999,900),(11,1099,1000),(12,1199,1100),(13,1299,1200),(14,1399,1300),(15,1499,1400),(16,1599,1500),(17,1699,1600),(18,1799,1700),(19,1899,1800),(20,1999,1900),(21,2099,2000),(22,2199,2100),(23,2299,2200),(24,2399,2300),(25,2499,2400),(26,2599,2500),(27,2699,2600),(28,2799,2700),(29,2899,2800),(30,2999,2900),(31,3099,3000),(32,3199,3100),(33,3299,3200),(34,3399,3300),(35,3499,3400),(36,3599,3500),(37,3699,3600),(38,3799,3700),(39,3899,3800),(40,3999,3900),(41,4099,4000),(42,4199,4100),(43,4299,4200),(44,4399,4300),(45,4499,4400),(46,4599,4500),(47,4699,4600),(48,4799,4700),(49,4899,4800),(50,4999,4900),(51,5099,5000),(52,5199,5100),(53,5299,5200),(54,5399,5300),(55,5499,5400),(56,5599,5500),(57,5699,5600),(58,5799,5700),(59,5899,5800),(60,5999,5900),(61,6099,6000),(62,6199,6100),(63,6299,6200),(64,6399,6300),(65,6499,6400),(66,6599,6500),(67,6699,6600),(68,6799,6700),(69,6899,6800),(70,6999,6900),(71,7099,7000),(72,7199,7100),(73,7299,7200),(74,7399,7300),(75,7499,7400),(76,7599,7500),(77,7699,7600),(78,7799,7700),(79,7899,7800),(80,7999,7900),(81,8099,8000),(82,8199,8100),(83,8299,8200),(84,8399,8300),(85,8499,8400),(86,8599,8500),(87,8699,8600),(88,8799,8700),(89,8899,8800),(90,8999,8900),(91,9099,9000),(92,9199,9100),(93,9299,9200),(94,9399,9300),(95,9499,9400),(96,9599,9500),(97,9699,9600),(98,9799,9700),(99,9899,9800),(100,2147483647,9900);
/*!40000 ALTER TABLE `tbnivel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbusuario`
--

DROP TABLE IF EXISTS `tbusuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbusuario` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `data_insercao` datetime DEFAULT NULL,
  `login` varchar(255) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  `data_atualizacao` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbusuario`
--

LOCK TABLES `tbusuario` WRITE;
/*!40000 ALTER TABLE `tbusuario` DISABLE KEYS */;
INSERT INTO `tbusuario` VALUES (1,'2012-10-10 00:00:00','adm','b09c600fddc573f117449b3723f23d64','2012-10-10 00:00:00'),(2,'2012-11-26 00:00:00','admin','b09c600fddc573f117449b3723f23d64',NULL);
/*!40000 ALTER TABLE `tbusuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'mackenzie'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-11-25  4:46:57
