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
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb3;
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
  `genre_id` bigint DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `score` bigint DEFAULT NULL,
  `tittle` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3tuujumkgqkrsgmj3et93xgg8` (`genre_id`),
  CONSTRAINT `FK3tuujumkgqkrsgmj3et93xgg8` FOREIGN KEY (`genre_id`) REFERENCES `genero` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pelicula`
--

LOCK TABLES `pelicula` WRITE;
/*!40000 ALTER TABLE `pelicula` DISABLE KEYS */;
INSERT INTO `pelicula` VALUES (1,'2010-12-21',_binary '\0',1,'/img/movies/x_men.jpg',5,'X Men'),(4,'1999-06-24',_binary '\0',1,'/img/movies/x_men_2.jpg',5,'X MEN 2'),(6,'2010-12-21',_binary '',1,'/img/movies/x_men_4.jpg',2,'X MEN 4'),(9,'1987-03-01',_binary '\0',6,'/img/movies/looney_tunes.jpg',5,'Looney Tunes'),(10,'1987-03-01',_binary '\0',6,'/img/movies/looney_tunes_2.jpg',5,'Looney Tunes 2'),(12,'2011-11-11',_binary '\0',1,'/img/movies/the_vengers.jpg',4,'The Avengers');
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
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personaje`
--

LOCK TABLES `personaje` WRITE;
/*!40000 ALTER TABLE `personaje` DISABLE KEYS */;
INSERT INTO `personaje` VALUES (1,29,_binary '\0','rogue\'s history','/img/characters/rogue.jpg','rogue',1.73),(2,33,_binary '\0','gambit\'s history','/img/characters/gambit.jpg','gambit',1.83),(3,64,_binary '\0','jean_grey\'s history','/img/characters/jean_grey.jpg','Jean Grey',1.81),(8,66,_binary '\0','professor_x\'s history','/img/characters/professor_x.jpg','Professor X',1.66),(9,45,_binary '\0','mastermind\'s history','/img/characters/mastermind.jpg','Mastermind',1.92),(10,39,_binary '','Wolverine\'s history','/img/characters/Wolverine.jpg','Wolverine',1.85),(11,45,_binary '','mastermind\'s history','/img/characters/mastermind.jpg','Mastermind',1.92),(12,66,_binary '','professor_x\'s history','/img/characters/professor_x.jpg','Professor X',1.66),(13,42,_binary '\0','Storm\'s history','/img/characters/Storm.jpg','Storm',1.88),(14,42,_binary '','Storm\'s history','/img/characters/Storm.jpg','Storm',1.88),(15,44,_binary '\0','Wolverine\'s history','/img/characters/Wolverine.jpg','Wolverine',1.9),(16,48,_binary '\0','Yosemite Sam\'s history','/img/characters/yosemite_sam.jpg','Yosemite Sam',1.44),(17,18,_binary '\0','Buggs bunny\'s history','/img/characters/buggs_bunny.jpg','Buggs Bunny',1.98),(18,98,_binary '\0','Marvin\'s history','/img/characters/marvin.jpg','Marvin the martian',1.2),(19,45,_binary '\0','Elmer\'s history','/img/characters/elmer_fudd.jpg','Elmer Fudd',1.59),(20,24,_binary '\0','Speedy\'s history','/img/characters/speedy_gonzales.jpg','Speedy Gonzales',0.33),(21,13,_binary '\0','Tasmanian Devil\'s history','/img/characters/tasmanian_devil.jpg','Tasmanian Devil',1.51),(22,15,_binary '\0','Wile\'s history','/img/characters/wile_coyote.jpg','Wile E. Coyote',1.89),(23,19,_binary '\0','Pepé\'s history','/img/characters/pepé_le_pew.jpg','Pepé Le Pew',0.84),(40,38,_binary '\0','Iron man\'s history','/img/characters/iron_man.jpg','Iron Man',1.68);
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
INSERT INTO `personaje_pelicula` VALUES (1,1),(1,2),(4,2),(1,3),(4,8),(4,9),(9,16),(9,17),(9,18),(9,19),(9,20),(9,21),(9,22),(9,23);
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
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (14,_binary '',_binary '',_binary '',_binary '','$argon2id$v=19$m=4096,t=3,p=1$xJlU0Cx2YEiHcQo89FgpgQ$f50SCQBFYqJADZxbrTTUqy1OutJUX4DM+GuSsiPXT2o','lukaku@gmail.com'),(15,_binary '',_binary '',_binary '',_binary '','$argon2id$v=19$m=4096,t=3,p=1$UVS/zgm4DXA60oxf2DrpMA$Up8ZxyrwsHpOWOxHxzKTi9Ymu7jaEPsf9K/doJKQ3c0','LucasEmiliano21@hotmail.com'),(16,_binary '',_binary '',_binary '',_binary '','$argon2id$v=19$m=4096,t=3,p=1$wMgsK7JYMXovxOxnfd82Nw$tPOtIshw7ed4cs76woUG2VP6/Kin9Qh56/wCpbuFP1A','admin@DisneyChallenge.com'),(17,_binary '',_binary '',_binary '',_binary '','$argon2id$v=19$m=4096,t=3,p=1$lRor1rjXM+DyWcnsAqoSCw$tqf7veEk8yNyE/Gzvwlxoiznj7FYcNu+JS4ORHs/Q2I','Support@DisneyChallenge.com'),(18,_binary '',_binary '',_binary '',_binary '','$argon2id$v=19$m=4096,t=3,p=1$gTxlfG28Y0XRlykrKkrtFQ$0R8mSSjnS9hkfbvp7MShOXX2j8spfB16Djvcpr989nA','RRHH@DisneyChallenge.com'),(19,_binary '',_binary '',_binary '',_binary '','$argon2id$v=19$m=4096,t=3,p=1$aRWISx/+dRPx7N5PsjGxjA$yITx/2Nja2x0HnuschaLlwr+JBxBb58aa5GlCchsM4Y','example@example.com'),(21,_binary '',_binary '',_binary '',_binary '','$argon2id$v=19$m=4096,t=3,p=1$Ir7Jaym8JfU46GHxdsJDAQ$P+tSN4QL5WQtjmRQFCSsOQ0SsYFFXt0x6C39PlRlkgc','example2@example.com'),(23,_binary '',_binary '',_binary '',_binary '','$argon2id$v=19$m=4096,t=3,p=1$SPkG54ssq6NwT/atAZD8dg$RAWZfgLLcF9kthKKf9mAuIHcD+WFwzaRwEpVEROdKXA','example3@example.com'),(25,_binary '',_binary '',_binary '',_binary '','$argon2id$v=19$m=4096,t=3,p=1$0hjTL8pT5p2POTejPu3D2w$nmop2SXIE9zXSGxQdJ4lgnVQsoE6XzFuqspM1QQZ8/M','example4@example.com'),(26,_binary '',_binary '',_binary '',_binary '','$argon2id$v=19$m=4096,t=3,p=1$T4TeMlN/vMxpz1abX/dOcQ$OnM3bgyAvViPBi3CEnfC2rOQij5CvoR9ZmnRNQKP6ls','example5@example.com'),(27,_binary '',_binary '',_binary '',_binary '','$argon2id$v=19$m=4096,t=3,p=1$OHsBz2AQW+R767yG2fdIdg$HPBJcRKads9eGthqbB2Bapf9L2r+SmfZrSB1QKuyoQM','example6@example.com'),(28,_binary '',_binary '',_binary '',_binary '','$2a$10$WNlpv7fUBy/AitqBEui0uehpV46M26YWurdJBon3H8PHdPgxZKbFi','example7@example.com'),(29,_binary '',_binary '',_binary '',_binary '','$2a$10$1cegVI0a9Sm/WSDIvXilE.zqZbg0DoHNRfb9XqEhJbGcgIn/VMVaS','example8@example.com'),(30,_binary '',_binary '',_binary '',_binary '','example1','example9@example.com'),(31,_binary '',_binary '',_binary '',_binary '','example1','example10@example.com'),(32,_binary '',_binary '',_binary '',_binary '','password1','CEO@Disney.com'),(33,_binary '',_binary '',_binary '',_binary '','$argon2id$v=19$m=4096,t=3,p=1$XBW/i7Y/eQVC8VlP64f0EA$Yhdxsom5ijXnxigpttSu/thy/nsAG5TZZp8y8vkpj2Q','CEO1@Disney.com'),(34,_binary '',_binary '',_binary '',_binary '','$argon2id$v=19$m=4096,t=3,p=1$YEymcAWRxjaSR6LTobL1GQ$zwYus9qOqJgwZAfnPMAeVCyAvmcBw0/L7hW4p1zfqo8','CEO3@Disney.com'),(35,_binary '',_binary '',_binary '',_binary '','$argon2id$v=19$m=4096,t=3,p=1$v9+GgAzef36FPw+1S+KsSQ$QwfxXBRFXCuw1loIAPBQ3a2HjE2Iw2+rSLhkrjQVDMk','CEO4@Disney.com'),(36,_binary '',_binary '',_binary '',_binary '','$argon2id$v=19$m=4096,t=3,p=1$ZtVPoYT1ZDx2aI6mpLftMg$YQo5cGG0a2OwanOP+N1DmegGva2dvBeCTGR3HUihWXE','example@gmail.com');
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

-- Dump completed on 2022-03-04 14:02:06
