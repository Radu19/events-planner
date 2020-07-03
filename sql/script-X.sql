CREATE DATABASE  IF NOT EXISTS `test` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `test`;
-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: events_planner_db
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `contact`
--

DROP TABLE IF EXISTS `contact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contact` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `phone_nr` varchar(45) NOT NULL,
  `event_type` varchar(45) NOT NULL,
  `event_date` date NOT NULL,
  `message` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contact`
--

LOCK TABLES `contact` WRITE;
/*!40000 ALTER TABLE `contact` DISABLE KEYS */;
INSERT INTO `contact` VALUES (3,'olesea','test@mail.com','06667779988','wedding','2021-09-16','sdfghj'),(4,'Test','test@mail.com','06667779988','wedding','2020-03-11','sdcvfbgnh'),(5,'olesea','goreanuolesea@gmail.com','0744965392','birthday','2022-09-07','qswadfGBHN'),(6,'Sorina','sorinagoareanu@gmail.com','0744965392','wedding','2021-11-09','sdfgh');
/*!40000 ALTER TABLE `contact` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `phone_nr` varchar(45) DEFAULT NULL,
  `email` varchar(45) NOT NULL,
  `address` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (3,'Olesea','Goreanu','744279994','olesea@gmail.com','str Parcului Nr 9A, Bl E11'),(5,'olesea','goreanu','06667779988','test@mail.com','hgfghj'),(6,'olesea','goreanu','0744965392','goreanuolesea@gmail.com','swdfg'),(7,'sorina','goreanu','975667890','sorinagoareanu@gmail.com','str.parcului nr.9'),(8,'andrei','goreanu','642345672','andreigoreanu@gmail.com','str independentei');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `location`
--

DROP TABLE IF EXISTS `location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `location` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` tinytext NOT NULL,
  `address` varchar(45) NOT NULL,
  `max_guests` int NOT NULL,
  `min_guests` int NOT NULL,
  `price_per_guest` double NOT NULL,
  `own_kitchen` varchar(45) NOT NULL,
  `own_music` varchar(45) NOT NULL,
  `ceremony_types` text NOT NULL,
  `cuisine` text NOT NULL,
  `modify_menu` varchar(45) NOT NULL,
  `special_menu` varchar(45) NOT NULL,
  `payment_method` varchar(45) NOT NULL,
  `description` text NOT NULL,
  `img` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location`
--

LOCK TABLES `location` WRITE;
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
INSERT INTO `location` VALUES (1,'Greystone Mansion','905 Parcului, Craiova, Romania',200,30,50,'Yes','Yes','charity event, corporate event, dinner party, holiday party, wedding ceremony',' french , english, romanian, moldavian, russian, italian','Yes','vegetarian, vegan','card, cash','Built during the roaring \'20s by a big-name oil tycoon, the property is as grand\r\nas it is historical. Outdoor spaces, beautiful gardens, and rooms in the mansion provide\r\nlocations for your special event in an environment that is convenient to the city yet far\r\nenough away for an enchanting escape.','grey-stone.jpg'),(2,'Cedar Lakes Estate','str. Independentei 9A, Sibiu, Romania',315,25,65,'Yes','Yes','charity event, family reunion, corporate event, dinner party, holiday','french, english, romanian, moldavian, russian, italian','Yes','vegetarian, vegan','card, cash',' At Cedar Lakes, we are committed to maintaining the highest quality of service,\r\ncare and personalization, which is why only host a select number of weddings each year.\r\nThe estate offers both indoor and outdoor event venues with breathtaking views\r\noverlooking tree-lined lakes, rolling green hills and stunning mountains. Whether your\r\nwedding calls for grandeur or intimacy, we guarantee, with unwavering assurance, that\r\nCedar Lakes Estate will host the event of your dreams.','cedar-lake.jpg'),(3,'Winvian Farm','str. Stefan cel Mare, Oradea, Romania',150,30,175,'Yes','Yes','bridal shower,birthday party, family reunion, corporate event, dinner','french , english, romanian, italian','No','vegetarian, vegan','card','Winvian Farm is a luxury resort experience like no other. A lighthearted oasis of\r\npeace, comfort and Five-Star Fine Dining in mountains, where fires are bright, sleep tranquil,\r\nand the mind is free to play.\r\nOur luxury Spa is an afternoon’s delight, and Winvian Farm’s renowned Five-Star Farm-toTable Restaurant is the heartfelt response of a gifted Executive Chef, Chris Eddy.','winvian-farm.jpg'),(4,'San Ysidro Ranch','str. Brasovului nr 708C, Brasov, Romania',200,15,100,'Yes','Yes','charity event, corporate event, dinner party, wedding ceremony,','french, english, romanian','Yes','vegetarian, vegan','card','Private cottages wind along the Brasov’s hillside creek and tree-lined paths. Built in classic\r\nbungalow style, all are individually decorated, all with fireplaces or stoves, decks giving way to sweeping\r\nvistas and outdoor hot tubs. Here, every guest and privileged pet receives a warm welcome. Relaxation\r\nand refuge are premium, enhanced by the discreet personal service and flawless attention to detail that\r\nare Ranch hallmarks.','san-ysidro.jpg'),(5,'Bear Flag Farm','str. Alexandru cel bun, Pieles, Romania',250,60,120,'Yes','Yes','charity event, corporate event, wedding ceremony, wedding','french , english, romanian, italian','Yes','vegetarian','card, cash','Secluded. Private. Magical. Beautiful. You will find an exquisite organic farm\r\nand private estate. Surrounded by orchards, lavender fields and vineyards, Bear Flag Farm\r\nlooks as if it was plucked from the French countryside. The air is filled with the aroma of\r\nlavender, as guests are wrapped in the farm’s tranquility. With a bounty of organic, seasonal\r\nproduce coming from the farm’s fields and orchards, you will experience the best that\r\nnature has to offer. Menus are carefully planned to reflect the rhythm of the seasons and\r\nprepared by the best chefs in the region.','bear-flag.jpg'),(6,'Wythe Hotel','str. Cetatii, nr. 45, Alba Iulia, Romania',140,30,150,'Yes','Yes','anniversary/ engagement party, birthday party, charity events,',' french, english, romanian, italian','No','vegetarian, vegan','card, cash','WYTHE HOTEL was created inside of a former cooperage built in 1901.\r\nYou can expect beautiful brick, original masonry, handmade tile floors and a spectacular\r\nEuropean-inspired courtyard.It is located on the waterfront. All of the inherent character of\r\nthe building has been meticulously preserved--its heavy yellow pine beams, pine ceilings,\r\noriginal masonry and brick walls, arched windows and cast-iron columns are all original.','whythe-hotel.jpg'),(8,'Test','swdfg',60,15,0,'No','No','dsf','dsa','No','','','','whythe-hotel.jpg');
/*!40000 ALTER TABLE `location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `meeting`
--

DROP TABLE IF EXISTS `meeting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `meeting` (
  `id` int NOT NULL AUTO_INCREMENT,
  `location_name` varchar(45) NOT NULL,
  `date_time` datetime NOT NULL,
  `user_id` int NOT NULL,
  `customer_id` int NOT NULL,
  `location_id` int NOT NULL,
  PRIMARY KEY (`id`,`user_id`,`customer_id`,`location_id`),
  KEY `fk_meeting_user1_idx` (`user_id`),
  KEY `fk_meeting_customer1_idx` (`customer_id`),
  KEY `fk_meeting_location1_idx` (`location_id`),
  CONSTRAINT `fk_meeting_customer1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
  CONSTRAINT `fk_meeting_location1` FOREIGN KEY (`location_id`) REFERENCES `location` (`id`),
  CONSTRAINT `fk_meeting_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `meeting`
--

LOCK TABLES `meeting` WRITE;
/*!40000 ALTER TABLE `meeting` DISABLE KEYS */;
INSERT INTO `meeting` VALUES (6,'Greystone Mansion','2020-07-20 06:00:00',3,6,1),(7,'Winvian Farm','2020-07-19 07:00:00',3,7,3);
/*!40000 ALTER TABLE `meeting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `request_info`
--

DROP TABLE IF EXISTS `request_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `request_info` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(45) NOT NULL,
  `phone_nr` varchar(45) NOT NULL,
  `event_date` date NOT NULL,
  `nr_guests` int NOT NULL,
  `message` text NOT NULL,
  `location_id` int NOT NULL,
  PRIMARY KEY (`id`,`location_id`),
  KEY `fk_request_info_location1_idx` (`location_id`),
  CONSTRAINT `fk_request_info_location1` FOREIGN KEY (`location_id`) REFERENCES `location` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `request_info`
--

LOCK TABLES `request_info` WRITE;
/*!40000 ALTER TABLE `request_info` DISABLE KEYS */;
INSERT INTO `request_info` VALUES (7,'test@mail.com','06667779988','2020-08-16',50,'asdfg',2),(8,'sorinagoareanu@gmail.com','975667890','2020-08-16',78,'Afzgth',2),(9,'goreanuolesea@gmail.com','0744279994','2020-07-29',82,'Demo Test',1);
/*!40000 ALTER TABLE `request_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservation` (
  `id` int NOT NULL AUTO_INCREMENT,
  `reservation_date` date NOT NULL,
  `ceremony_type` varchar(45) NOT NULL,
  `nr_guests` int NOT NULL,
  `music_included` varchar(45) NOT NULL,
  `kitchen_included` varchar(45) NOT NULL,
  `cuisine` varchar(45) NOT NULL,
  `details` text NOT NULL,
  `payment_method` varchar(45) NOT NULL,
  `payment_status` varchar(45) NOT NULL,
  `customer_id` int NOT NULL,
  `user_id` int NOT NULL,
  `location_id` int NOT NULL,
  PRIMARY KEY (`id`,`customer_id`,`user_id`,`location_id`),
  KEY `fk_reservation_customer1_idx` (`customer_id`),
  KEY `fk_reservation_user1_idx` (`user_id`),
  KEY `fk_reservation_location1_idx` (`location_id`),
  CONSTRAINT `fk_reservation_customer1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
  CONSTRAINT `fk_reservation_location1` FOREIGN KEY (`location_id`) REFERENCES `location` (`id`),
  CONSTRAINT `fk_reservation_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservation`
--

LOCK TABLES `reservation` WRITE;
/*!40000 ALTER TABLE `reservation` DISABLE KEYS */;
INSERT INTO `reservation` VALUES (5,'2020-07-31',' family reunion',40,'No','Yes',' english','HGHJK','card','Pending',5,3,2),(6,'2020-08-11',' dinner party',75,'Yes','Yes',' moldavian','sadfghj','card','Pending',5,3,1),(7,'2020-08-09',' wedding ceremony',86,'Yes','Yes',' russian','zxcvbn','card','Pending',5,3,1);
/*!40000 ALTER TABLE `reservation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_EMPLOYEE'),(2,'ROLE_MANAGER'),(3,'ROLE_ADMIN');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` char(80) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `address` varchar(45) DEFAULT NULL,
  `phone_nr` int DEFAULT NULL,
  `image` longtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'john','$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K','John','Doe','john@yahoo.com','Str. Test',79955994,'2.jpg'),(2,'mary','$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K','Mary','Frank','mary@yahoo.com','Str. Test',79955994,'3.jpg'),(3,'susan','$2a$04$eFytJDGtjbThXa80FyOOBuFdK2IwjyWefYkMpiBEFlpBwDH.5PM0K','Susan','Ashley','susan@yahoo.com','Str. Test',79955994,'1.jpg'),(9,'pette','$2a$10$eKSyDdWyO4Tov6tqWbkHsef5/F3sxzlJfbuyL5iFKs3b9F3YjOnzS','Peter','Parker','pette@gmail.com','Str. Test',744279994,''),(10,'lesea','$2a$10$2K8xkkBTU78JmpvmcPtIxeMHvuhPNfUZaAxBLK8EqUW5bOaf8kHf6','Olesea','Goreanu','olesea@gmail.com','Str. Demo test',744566632,'');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_roles`
--

DROP TABLE IF EXISTS `users_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users_roles` (
  `user_id` int NOT NULL,
  `role_id` int NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FK_ROLE_idx` (`role_id`),
  CONSTRAINT `FK_ROLE` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `FK_USER_05` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_roles`
--

LOCK TABLES `users_roles` WRITE;
/*!40000 ALTER TABLE `users_roles` DISABLE KEYS */;
INSERT INTO `users_roles` VALUES (1,1),(2,1),(3,1),(2,2),(3,2),(9,2),(10,2),(3,3);
/*!40000 ALTER TABLE `users_roles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-07-01  6:42:46
