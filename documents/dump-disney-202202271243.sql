-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: disney
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `genero`
--

DROP TABLE IF EXISTS `genero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `genero` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `image` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genero`
--

LOCK TABLES `genero` WRITE;
/*!40000 ALTER TABLE `genero` DISABLE KEYS */;
INSERT INTO `genero` VALUES (1,'/src/img/Superheros.jpg','Superheros'),(2,'/src/img/Action.jpg','Action'),(3,'/src/img/Drama.jpg','Drama'),(4,'/src/img/Comedy.jpg','Comedy'),(5,'/src/img/Terror.jpg','Terror'),(6,'/src/img/Adventure.jpg','Adventure'),(8,'/src/img/Fantasy.jpg','Fantasy'),(9,'/src/img/Western.jpg','Western');
/*!40000 ALTER TABLE `genero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pelicula`
--

DROP TABLE IF EXISTS `pelicula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pelicula` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `creation_date` date DEFAULT NULL,
  `deleted` bit(1) NOT NULL,
  `genre_id` bigint NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `score` bigint DEFAULT NULL,
  `tittle` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3tuujumkgqkrsgmj3et93xgg8` (`genre_id`),
  CONSTRAINT `FK3tuujumkgqkrsgmj3et93xgg8` FOREIGN KEY (`genre_id`) REFERENCES `genero` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pelicula`
--

LOCK TABLES `pelicula` WRITE;
/*!40000 ALTER TABLE `pelicula` DISABLE KEYS */;
INSERT INTO `pelicula` VALUES (1,'2010-12-21',_binary '\0',1,'/img/movies/x_men.jpg',5,'X Men'),(2,'2010-12-21',_binary '',6,'/img/movies/probando_relaciones.jpg',4,'probando relaciones 2'),(3,'2010-12-21',_binary '',6,'/img/movies/probando_relaciones.jpg',4,'probando relaciones 2'),(4,'1999-06-24',_binary '\0',1,'/img/movies/x_men_2.jpg',5,'X MEN 2'),(5,'2010-12-21',_binary '',1,'/img/movies/x_men_2.jpg',4,'X MEN 2'),(6,'2010-12-21',_binary '\0',1,'/img/movies/x_men_3.jpg',2,'X MEN 3'),(7,'2010-12-21',_binary '',1,'/img/movies/x_men_2.jpg',4,'X MEN 2'),(8,'2010-12-21',_binary '',1,'/img/movies/x_men_2.jpg',4,'X MEN 2');
/*!40000 ALTER TABLE `pelicula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personaje`
--

DROP TABLE IF EXISTS `personaje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personaje` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `age` bigint DEFAULT NULL,
  `deleted` bit(1) NOT NULL,
  `history` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `weight` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personaje`
--

LOCK TABLES `personaje` WRITE;
/*!40000 ALTER TABLE `personaje` DISABLE KEYS */;
INSERT INTO `personaje` VALUES (1,29,_binary '\0','rogue\'s history','/img/characters/rogue.jpg','rogue',1.73),(2,33,_binary '\0','gambit\'s history','/img/characters/gambit.jpg','gambit',1.83),(3,64,_binary '\0','jean_grey\'s history','/img/characters/jean_grey.jpg','Jean Grey',1.81),(4,22,_binary '','test\'s history','/img/characters/test.jpg','probando relaciones 4',2),(5,22,_binary '','test\'s history','/img/characters/test.jpg','probando relaciones 3',2),(6,22,_binary '','test\'s history','/img/characters/test.jpg','probando relaciones 3',2),(7,22,_binary '','test\'s history','/img/characters/test.jpg','probando relaciones 4',2),(8,66,_binary '\0','professor_x\'s history','/img/characters/professor_x.jpg','Professor X',1.66),(9,45,_binary '\0','mastermind\'s history','/img/characters/mastermind.jpg','Mastermind',1.92),(10,39,_binary '','Wolverine\'s history','/img/characters/Wolverine.jpg','Wolverine',1.85),(11,45,_binary '','mastermind\'s history','/img/characters/mastermind.jpg','Mastermind',1.92),(12,66,_binary '','professor_x\'s history','/img/characters/professor_x.jpg','Professor X',1.66),(13,42,_binary '\0','Storm\'s history','/img/characters/Storm.jpg','Storm',1.88),(14,42,_binary '','Storm\'s history','/img/characters/Storm.jpg','Storm',1.88),(15,44,_binary '\0','Wolverine\'s history','/img/characters/Wolverine.jpg','Wolverine',1.9);
/*!40000 ALTER TABLE `personaje` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personaje_pelicula`
--

DROP TABLE IF EXISTS `personaje_pelicula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personaje_pelicula` (
  `movie_id` bigint NOT NULL,
  `character_id` bigint NOT NULL,
  PRIMARY KEY (`movie_id`,`character_id`),
  KEY `FKs4hgx2u059g7aji8i159xbso1` (`character_id`),
  CONSTRAINT `FKl9foaehkejmxqyv2r3ps8u44h` FOREIGN KEY (`movie_id`) REFERENCES `pelicula` (`id`),
  CONSTRAINT `FKs4hgx2u059g7aji8i159xbso1` FOREIGN KEY (`character_id`) REFERENCES `personaje` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personaje_pelicula`
--

LOCK TABLES `personaje_pelicula` WRITE;
/*!40000 ALTER TABLE `personaje_pelicula` DISABLE KEYS */;
INSERT INTO `personaje_pelicula` VALUES (1,1),(1,2),(1,3),(4,8),(4,9);
/*!40000 ALTER TABLE `personaje_pelicula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `account_non_expired` bit(1) NOT NULL,
  `account_non_locked` bit(1) NOT NULL,
  `credentials_non_expired` bit(1) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_sb8bbouer5wak8vyiiy4pf2bx` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (4,_binary '',_binary '',_binary '',_binary '','password1','LucasEmiliano21@hotmail.com'),(5,_binary '',_binary '',_binary '',_binary '','password1','alma.cs310@gmail.com'),(6,_binary '',_binary '',_binary '',_binary '','password1','alma.cs3102@gmail.com'),(7,_binary '',_binary '',_binary '',_binary '','password1','lucases@gmail.com'),(8,_binary '',_binary '',_binary '',_binary '','password1','lucases2@gmail.com'),(9,_binary '',_binary '',_binary '',_binary '','password1','example@gmail.com');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'disney'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-27 12:43:12
