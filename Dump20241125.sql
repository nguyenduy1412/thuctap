CREATE DATABASE  IF NOT EXISTS `electro` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `electro`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: electro
-- ------------------------------------------------------
-- Server version	8.1.0

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
-- Table structure for table `address_order`
--

DROP TABLE IF EXISTS `address_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address_order` (
  `id` int NOT NULL AUTO_INCREMENT,
  `address` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `city` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `code_zip` varchar(255) DEFAULT NULL,
  `country` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `last_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `order_id` int DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8v8w4oawbk0vpdxxekt8yoj1j` (`order_id`),
  KEY `FKfkqouyksy0f3f57wku6823yn2` (`user_id`),
  CONSTRAINT `FK8v8w4oawbk0vpdxxekt8yoj1j` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`),
  CONSTRAINT `FKfkqouyksy0f3f57wku6823yn2` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address_order`
--

LOCK TABLES `address_order` WRITE;
/*!40000 ALTER TABLE `address_order` DISABLE KEYS */;
INSERT INTO `address_order` VALUES (1,'hqv','hanoi','4534',NULL,'duy2172003@gmail.com','duy','nguyen','0947669387',1,3),(2,'hqv','hanoi','4534',NULL,'duy2172003@gmail.com','duy','nguyen','0947669387',2,4),(3,'hqv','hanoi','4534','vn','duy2172003@gmail.com','duy','nguyen','0947669387',3,4);
/*!40000 ALTER TABLE `address_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `brand`
--

DROP TABLE IF EXISTS `brand`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `brand` (
  `id` int NOT NULL AUTO_INCREMENT,
  `brand_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brand`
--

LOCK TABLES `brand` WRITE;
/*!40000 ALTER TABLE `brand` DISABLE KEYS */;
INSERT INTO `brand` VALUES (3,'MacBook',_binary ''),(4,'ASUS',_binary ''),(5,'Lenovo',_binary ''),(6,'MSI',_binary ''),(7,'Acer',_binary ''),(8,'HP',_binary ''),(9,'DELL',_binary ''),(10,'SAMSUNG',_binary ''),(11,'APPLE',_binary ''),(12,'Xiaomi',_binary ''),(13,'OPPO',_binary ''),(14,'iPad',_binary '');
/*!40000 ALTER TABLE `brand` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
  `id` int NOT NULL AUTO_INCREMENT,
  `total` double DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK9emlp6m95v5er2bcqkjsw48he` (`user_id`),
  CONSTRAINT `FKg5uhi8vpsuy0lgloxk2h4w5o6` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
INSERT INTO `cart` VALUES (1,0,2),(2,0,3),(3,0,4);
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `category_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (8,'Laptops',_binary ''),(9,'Smartphones',_binary ''),(10,'Cameras',_binary ''),(11,'Accessories',_binary '');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `color`
--

DROP TABLE IF EXISTS `color`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `color` (
  `id` int NOT NULL AUTO_INCREMENT,
  `color_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `color`
--

LOCK TABLES `color` WRITE;
/*!40000 ALTER TABLE `color` DISABLE KEYS */;
INSERT INTO `color` VALUES (3,'Red'),(4,'Blue'),(5,'Black'),(6,'White');
/*!40000 ALTER TABLE `color` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detail_cart`
--

DROP TABLE IF EXISTS `detail_cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detail_cart` (
  `id` int NOT NULL AUTO_INCREMENT,
  `quantity` int DEFAULT NULL,
  `cart_id` int DEFAULT NULL,
  `product_id` int DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `size` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7htydudqi1f8p95axt7thuk9t` (`cart_id`),
  KEY `FKbbsqv99lt0j5c3xfm0srcieja` (`product_id`),
  CONSTRAINT `FK7htydudqi1f8p95axt7thuk9t` FOREIGN KEY (`cart_id`) REFERENCES `cart` (`id`),
  CONSTRAINT `FKbbsqv99lt0j5c3xfm0srcieja` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detail_cart`
--

LOCK TABLES `detail_cart` WRITE;
/*!40000 ALTER TABLE `detail_cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `detail_cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detail_product_img`
--

DROP TABLE IF EXISTS `detail_product_img`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detail_product_img` (
  `id` int NOT NULL AUTO_INCREMENT,
  `image` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `product_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKf80iny29m58vgwi3pwlyh4w89` (`product_id`),
  CONSTRAINT `FKf80iny29m58vgwi3pwlyh4w89` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detail_product_img`
--

LOCK TABLES `detail_product_img` WRITE;
/*!40000 ALTER TABLE `detail_product_img` DISABLE KEYS */;
INSERT INTO `detail_product_img` VALUES (10,'2024-11-12-08-05-27.jpg',7),(11,'2024-11-12-08-05-27.jpg',7),(12,'2024-11-12-08-05-27.jpg',7),(22,'laptop_msi_1__2_2.webp2024-11-12-08-31-52.jpg',8),(23,'laptop_msi_2__2_2.webp2024-11-12-08-31-52.jpg',8),(24,'laptop_msi_4_2.webp2024-11-12-08-31-52.jpg',8),(25,'text_ng_n_3__2_25.webp2024-11-12-08-32-23.jpg',9),(26,'text_ng_n_4__3_23.webp2024-11-12-08-32-23.jpg',9),(27,'text_ng_n_5__3_19.webp2024-11-12-08-32-23.jpg',9),(28,'text_ng_n_60__1_5.webp2024-11-12-08-37-57.jpg',10),(29,'text_ng_n_61__2_7.webp2024-11-12-08-37-57.jpg',10),(30,'text_ng_n_64__2_2.webp2024-11-12-08-37-57.jpg',10),(31,'text_ng_n_1__3_36.webp2024-11-12-11-06-14.jpg',11),(32,'text_ng_n_5__4_26.webp2024-11-12-11-06-14.jpg',11),(33,'text_ng_n_6_39.webp2024-11-12-11-06-14.jpg',11),(34,'mac_air_ksp.webp2024-11-12-11-09-24.jpg',12),(35,'macbook-air-2020-m1_4_.webp2024-11-12-11-09-24.jpg',12),(36,'macbook-air-2020-m1_6_.webp2024-11-12-11-09-24.jpg',12),(37,'samsung_galaxy_s24_ultra_256gb_-_3.webp2024-11-12-11-13-07.jpg',13),(38,'samsung_galaxy_s24_ultra_256gb_-_6.webp2024-11-12-11-13-07.jpg',13),(39,'samsung_galaxy_s24_ultra_256gb_-_9.webp2024-11-12-11-13-07.jpg',13),(40,'iphone-15-pro-max_1__1.webp2024-11-12-11-56-58.jpg',14),(41,'iphone-15-pro-max_7__1.webp2024-11-12-11-56-58.jpg',14),(42,'iphone-15-pro-max_9__1.webp2024-11-12-11-56-58.jpg',14),(43,'xiaomi_14t_13_.webp2024-11-12-11-59-31.jpg',15),(44,'xiaomi_14t_14_.webp2024-11-12-11-59-31.jpg',15),(45,'xiaomi_14t_18_.webp2024-11-12-11-59-31.jpg',15),(46,'oppo_reno10_pro_plus_-_4.webp2024-11-12-12-01-40.jpg',16),(47,'oppo-reno10-pro-plus-tim.webp2024-11-12-12-01-40.jpg',16),(48,'oppo-reno10-pro-plus-xam.webp2024-11-12-12-01-40.jpg',16);
/*!40000 ALTER TABLE `detail_product_img` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detail_wish_list`
--

DROP TABLE IF EXISTS `detail_wish_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detail_wish_list` (
  `id` int NOT NULL AUTO_INCREMENT,
  `product_id` int DEFAULT NULL,
  `favourite_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKsrh3kmyd3ctce7nrdh5w87s4g` (`product_id`),
  KEY `FK9qeej0g172vf0dtbsoxu623p4` (`favourite_id`),
  CONSTRAINT `FK9qeej0g172vf0dtbsoxu623p4` FOREIGN KEY (`favourite_id`) REFERENCES `wish_list` (`id`),
  CONSTRAINT `FKsrh3kmyd3ctce7nrdh5w87s4g` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detail_wish_list`
--

LOCK TABLES `detail_wish_list` WRITE;
/*!40000 ALTER TABLE `detail_wish_list` DISABLE KEYS */;
INSERT INTO `detail_wish_list` VALUES (1,9,2),(2,15,2);
/*!40000 ALTER TABLE `detail_wish_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `method_pay`
--

DROP TABLE IF EXISTS `method_pay`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `method_pay` (
  `id` int NOT NULL AUTO_INCREMENT,
  `pay_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `method_pay`
--

LOCK TABLES `method_pay` WRITE;
/*!40000 ALTER TABLE `method_pay` DISABLE KEYS */;
/*!40000 ALTER TABLE `method_pay` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_detail`
--

DROP TABLE IF EXISTS `order_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_detail` (
  `id` int NOT NULL AUTO_INCREMENT,
  `color` varchar(255) DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `size` varchar(255) DEFAULT NULL,
  `total` double DEFAULT NULL,
  `order_id` int DEFAULT NULL,
  `product_id` int DEFAULT NULL,
  `price` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKrws2q0si6oyd6il8gqe2aennc` (`order_id`),
  KEY `FKb8bg2bkty0oksa3wiq5mp5qnc` (`product_id`),
  CONSTRAINT `FKb8bg2bkty0oksa3wiq5mp5qnc` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `FKrws2q0si6oyd6il8gqe2aennc` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_detail`
--

LOCK TABLES `order_detail` WRITE;
/*!40000 ALTER TABLE `order_detail` DISABLE KEYS */;
INSERT INTO `order_detail` VALUES (1,'Black',1,'M',NULL,1,15,580.8),(2,'White',1,'M',NULL,1,13,1152),(3,'Blue',1,'L',NULL,1,9,1320),(4,'Red',1,'M',NULL,2,10,1089),(5,'Blue',1,'M',NULL,3,15,580.8),(6,'Blue',1,'M',NULL,3,16,488.75);
/*!40000 ALTER TABLE `order_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `id` int NOT NULL AUTO_INCREMENT,
  `address_ship` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `date_order` datetime(6) DEFAULT NULL,
  `note` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `status` int DEFAULT NULL,
  `status_pay` bit(1) DEFAULT NULL,
  `sum_money` double DEFAULT NULL,
  `pay_id` int DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKd4aunm885xy75ke0mv4i7du1p` (`pay_id`),
  KEY `FK32ql8ubntj5uh44ph9659tiih` (`user_id`),
  CONSTRAINT `FK32ql8ubntj5uh44ph9659tiih` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKd4aunm885xy75ke0mv4i7du1p` FOREIGN KEY (`pay_id`) REFERENCES `method_pay` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,NULL,'2024-11-13 14:35:09.803000','ádffds',NULL,0,_binary '\0',0,NULL,3),(2,NULL,'2024-11-13 15:20:24.545000','',NULL,0,_binary '\0',1089,NULL,4),(3,NULL,'2024-11-13 16:43:31.867000','',NULL,0,_binary '\0',1069.55,NULL,4);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `description` varchar(4000) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `price_enter` double DEFAULT NULL,
  `price_sale` double DEFAULT NULL,
  `product_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `profit` int DEFAULT NULL,
  `sale` int DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `category_id` int DEFAULT NULL,
  `star` double DEFAULT NULL,
  `brand_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1mtsbur82frn64de7balymq9s` (`category_id`),
  KEY `FKs6cydsualtsrprvlf2bb3lcam` (`brand_id`),
  CONSTRAINT `FK1mtsbur82frn64de7balymq9s` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  CONSTRAINT `FKs6cydsualtsrprvlf2bb3lcam` FOREIGN KEY (`brand_id`) REFERENCES `brand` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (7,'<h2>Đặc điểm nổi bật</h2>\r\n\r\n<ul>\r\n	<li>Thiết kế 2-trong-1 linh hoạt, kết hợp giữa laptop v&agrave; m&aacute;y t&iacute;nh bảng với m&agrave;n h&igrave;nh cảm ứng xoay 360 độ.</li>\r\n	<li>M&agrave;n h&igrave;nh 14 inch Full HD+ cung cấp h&igrave;nh ảnh sắc n&eacute;t v&agrave; g&oacute;c nh&igrave;n rộng, ph&ugrave; hợp cho cả c&ocirc;ng việc v&agrave; giải tr&iacute;.</li>\r\n	<li>Bộ vi xử l&yacute; Intel Core i3-N305 thế hệ mới đảm bảo hiệu suất ổn định cho c&aacute;c t&aacute;c vụ h&agrave;ng ng&agrave;y v&agrave; đa nhiệm nhẹ.</li>\r\n	<li>Với 8GB RAM v&agrave; ổ cứng SSD 512GB, m&aacute;y cho ph&eacute;p khởi động nhanh, mở ứng dụng mượt m&agrave; v&agrave; lưu trữ dữ liệu đủ d&ugrave;ng.</li>\r\n	<li>Thiết kế m&agrave;u x&aacute;m trang nh&atilde; kết hợp với khung m&aacute;y mỏng nhẹ, gi&uacute;p dễ d&agrave;ng mang theo khi di chuyển.</li>\r\n</ul>\r\n','2024-11-12-08-03-54.jpg',1100,1000,1100,'Acer Aspire 3 Spin',10,0,_binary '',8,0,7),(8,'<h2>Đặc điểm nổi bật</h2>\r\n\r\n<ul>\r\n	<li>Trang bị chip Intel Core i5-12500H v&agrave; card đồ họa NVIDIA GeForce RTX 3050 4GB, chiến mượt c&aacute;c tựa game Esports mức c&agrave;i đặt đồ họa cao.</li>\r\n	<li>M&agrave;n h&igrave;nh 16 inch WUXGA (1920x1200) với tần số qu&eacute;t 144Hz, cho trải nghiệm gaming mượt m&agrave;, h&igrave;nh ảnh sắc n&eacute;t.</li>\r\n	<li>Vỏ m&aacute;y m&agrave;u đen kết hợp c&ugrave;ng c&aacute;c đường n&eacute;t thiết kế gaming tạo n&ecirc;n vẻ ngo&agrave;i năng động, c&aacute; t&iacute;nh.</li>\r\n	<li>C&ocirc;ng nghệ tản nhiệt ASUS gi&uacute;p m&aacute;y lu&ocirc;n m&aacute;t mẻ, ổn định hiệu năng trong thời gian d&agrave;i chơi game.</li>\r\n	<li>C&ocirc;ng nghệ &acirc;m thanh mang đến trải nghiệm &acirc;m thanh v&ograve;m sống động, tăng th&ecirc;m phần hấp dẫn cho game thủ.</li>\r\n</ul>\r\n','2024-11-12-08-33-28.jpg',990,900,940.5,'ASUS Gaming VivoBook',10,5,_binary '',8,0,4),(9,'<h2>Đặc điểm nổi bật</h2>\r\n\r\n<ul>\r\n	<li>Sở hữu thiết kế thanh lịch với gam m&agrave;u đen sang trọng</li>\r\n	<li>CPU&nbsp;Intel Core i7-1255U mạnh mẽ c&acirc;n mọi t&aacute;c vụ văn ph&ograve;ng, học tập</li>\r\n	<li>RAM&nbsp;16GB chuẩn DDR4 đa nhiệm, hỗ trợ duyệt web nhanh, kh&ocirc;ng giật, lag</li>\r\n	<li>Ổ cứng&nbsp;512GB&nbsp;SSD gi&uacute;p mở m&aacute;y, mở ứng dụng nhanh ch&oacute;ng</li>\r\n	<li>M&agrave;n h&igrave;nh 15.6 inch Full HD cho h&igrave;nh ảnh cực sắc n&eacute;t, m&agrave;u sắc ch&acirc;n thực</li>\r\n</ul>\r\n','2024-11-12-08-32-23.jpg',1320,1200,1320,'MSI Modern 15',10,0,_binary '',8,0,6),(10,'<h2>Đặc điểm nổi bật</h2>\r\n\r\n<ul>\r\n	<li>Bộ xử l&yacute; Intel Core i5-13420H mạnh mẽ, cho hiệu suất xử l&yacute; mượt m&agrave;, đ&aacute;p ứng tốt nhu cầu chơi game ở mức cấu h&igrave;nh cao.</li>\r\n	<li>RAM 16GB v&agrave; ổ cứng SSD 512GB PCIe mang đến tốc độ xử l&yacute; nhanh ch&oacute;ng, khởi động m&aacute;y v&agrave; mở ứng dụng nhanh ch&oacute;ng.</li>\r\n	<li>Card đồ họa NVIDIA GeForce RTX 3050 4GB cho khả năng xử l&yacute; đồ họa mạnh mẽ, mang đến trải nghiệm game mượt m&agrave;, h&igrave;nh ảnh đẹp mắt.</li>\r\n	<li>M&agrave;n h&igrave;nh 15.6 inch FHD 144Hz sắc n&eacute;t, tốc độ l&agrave;m tươi cao, cho h&igrave;nh ảnh chuyển động mượt m&agrave;, kh&ocirc;ng bị giật lag.</li>\r\n</ul>\r\n','text_d_i_5__2.webp2024-11-12-08-37-56.jpg',1210,1100,1089,'MSI Gaming Thin',10,10,_binary '',8,0,6),(11,'<h2>Đặc điểm nổi bật</h2>\r\n\r\n<ul>\r\n	<li>Thiết kế đơn giản, trẻ trung với tone m&agrave;u đen bao phủ.</li>\r\n	<li>M&agrave;n h&igrave;nh cảm ứng 15.6 inch Full HD cho trải nghiệm h&igrave;nh ảnh v&ocirc; c&ugrave;ng sắc n&eacute;t.</li>\r\n	<li>CPU Intel core i5-1155G7 c&ugrave;ng 8 GB RAM DDR4 xử l&yacute; mượt c&aacute;c t&aacute;c vụ văn ph&ograve;ng: Word, Excel,...</li>\r\n	<li>Card đồ họa&nbsp;Intel Iris Xe&nbsp;Graphics&nbsp;hỗ trợ chỉnh ảnh đơn giản.</li>\r\n	<li>Kh&ocirc;ng gian lưu trữ vừa phải với ổ cứng 256 GB SSD.</li>\r\n</ul>\r\n','text_ng_n_2__4_28.webp2024-11-12-11-06-14.jpg',825,750,825,'Dell Inspiron 15',10,0,_binary '',8,0,9),(12,'<h2>Đặc điểm nổi bật</h2>\r\n\r\n<ul>\r\n	<li>Ph&ugrave; hợp cho lập tr&igrave;nh vi&ecirc;n, thiết kế đồ họa 2D, d&acirc;n văn ph&ograve;ng</li>\r\n	<li>Hiệu năng vượt trội - C&acirc;n mọi t&aacute;c vụ từ word, exel đến chỉnh sửa ảnh tr&ecirc;n c&aacute;c phần mềm như AI, PTS</li>\r\n	<li>Đa nhiệm mượt m&agrave; - Ram 8GB cho ph&eacute;p vừa mở tr&igrave;nh duyệt để tra cứu th&ocirc;ng tin, vừa l&agrave;m việc tr&ecirc;n phần mềm</li>\r\n	<li>Trang bị SSD 256GB - Cho thời gian khởi động nhanh ch&oacute;ng, tối ưu ho&aacute; thời gian load ứng dụng</li>\r\n	<li>Chất lượng h&igrave;nh ảnh sắc n&eacute;t - M&agrave;n h&igrave;nh Retina cao cấp c&ugrave;ng c&ocirc;ng nghệ TrueTone c&acirc;n bằng m&agrave;u sắc</li>\r\n	<li>Thiết kế sang trọng - Nặng chỉ 1.29KG, độ d&agrave;y 16.1mm. Tiện lợi mang theo mọi nơi</li>\r\n</ul>\r\n','2024-11-12-11-34-34.jpg',1430,1300,1258.4,'Apple MacBook Air M1',10,12,_binary '',8,NULL,11),(13,'<h2>Đặc điểm nổi bật của Samsung Galaxy S24 Ultra 12GB 256GB</h2>\r\n\r\n<ul>\r\n	<li>Trải nghiệm đỉnh cao với hiệu năng mạnh mẽ từ vi xử l&yacute; t&acirc;n tiến, kết hợp c&ugrave;ng RAM 12GB cho khả năng đa nhiệm mượt m&agrave;.</li>\r\n	<li>Lưu trữ thoải m&aacute;i mọi ứng dụng, h&igrave;nh ảnh v&agrave; video với bộ nhớ trong 256GB.</li>\r\n	<li>N&acirc;ng tầm nhiếp ảnh di động với hệ thống camera ti&ecirc;n tiến, cho ra đời những bức ảnh v&agrave; video chất lượng chuy&ecirc;n nghiệp.</li>\r\n	<li>Thiết kế sang trọng, đẳng cấp, khẳng định phong c&aacute;ch thời thượng.</li>\r\n</ul>\r\n','ss-s24-ultra-xam-222.webp2024-11-12-11-13-07.jpg',1800,1500,1152,'Samsung Galaxy S24 Ultra',20,36,_binary '',9,0,10),(14,'<h2>Đặc điểm nổi bật của iPhone 15 Pro Max 256GB | Ch&iacute;nh h&atilde;ng VN/A</h2>\r\n\r\n<ul>\r\n	<li>Thiết kế khung viền từ titan chuẩn h&agrave;ng kh&ocirc;ng vũ trụ - Cực nhẹ, bền c&ugrave;ng viền cạnh mỏng cầm nắm thoải m&aacute;i</li>\r\n	<li>Hiệu năng Pro chiến game thả ga - Chip A17 Pro mang lại hiệu năng đồ họa v&ocirc; c&ugrave;ng sống động v&agrave; ch&acirc;n thực</li>\r\n	<li>Thoả sức s&aacute;ng tạo v&agrave; quay phim chuy&ecirc;n nghiệp - Cụm 3 camera sau đến 48MP v&agrave; nhiều chế độ ti&ecirc;n tiến</li>\r\n	<li>N&uacute;t t&aacute;c vụ mới gi&uacute;p nhanh ch&oacute;ng k&iacute;ch hoạt t&iacute;nh năng y&ecirc;u th&iacute;ch của bạn</li>\r\n</ul>\r\n','iphone-15-pro-max_3.webp2024-11-12-11-56-58.jpg',3000,2500,3000,'iPhone 15 Pro Max',20,0,_binary '',9,0,11),(15,'<h2>Đặc điểm nổi bật của Xiaomi 14T 12GB 512GB</h2>\r\n\r\n<ul>\r\n	<li>Hiệu năng mạnh mẽ với chip&nbsp;MediaTek Dimensity 8300-Ultra -&nbsp;Mang lại hiệu năng tốt cho c&aacute;c t&aacute;c vụ h&agrave;ng ng&agrave;y, từ lướt web, xem video đến chơi game với độ ổn định cao.</li>\r\n	<li>Thấu k&iacute;nh quang học Leica Summilux - Ghi lại những bức ảnh chi tiết, sắc n&eacute;t ph&ugrave; hợp với nhu cầu nhiếp ảnh di động v&agrave; quay phim chất lượng cao.</li>\r\n	<li>M&agrave;n h&igrave;nh 144Hz AMOLED cho m&agrave;u sắc sống động, độ s&aacute;ng cao v&agrave; khả năng t&aacute;i hiện h&igrave;nh ảnh ch&acirc;n thực, mang lại trải nghiệm xem phim, chơi game tuyệt vời.</li>\r\n	<li>Xiaomi 14T trang bị pin lớn 5.000mAh, kết hợp với c&ocirc;ng nghệ sạc nhanh 67W - Sạc đầy nhanh ch&oacute;ng v&agrave; duy tr&igrave; thời gian sử dụng suốt cả ng&agrave;y.</li>\r\n</ul>\r\n','xiaomi_14t_2_.webp2024-11-12-11-59-31.jpg',660,600,580.8,'Xiaomi 14T',10,12,_binary '',9,0,12),(16,'<h2>Đặc điểm nổi bật của OPPO Reno10 Pro+ 5G 12GB 256GB</h2>\r\n\r\n<ul>\r\n	<li>Trải nghiệm h&igrave;nh ảnh sống động, rực rỡ v&agrave; sắc n&eacute;t với tấm nền AMOLED 6.74 inch c&ugrave;ng tần số qu&eacute;t 120Hz mượt m&agrave;.</li>\r\n	<li>Hiệu năng mạnh mẽ cho khả năng xử l&yacute; đa nhiệm mượt m&agrave;, chơi game cấu h&igrave;nh cao.</li>\r\n	<li>Chụp ảnh chuy&ecirc;n nghiệp, sắc n&eacute;t v&agrave; ấn tượng với camera sau AI 50MP (ch&iacute;nh)&nbsp;&amp; Phụ 64 MP, 8 MP</li>\r\n	<li>Sử dụng thoải m&aacute;i cả ng&agrave;y d&agrave;i với pin dung lượng cao 4700mAh, hỗ trợ sạc nhanh SuperVOOC 100W.</li>\r\n</ul>\r\n','oppo-reno10-pro-plus-tim (1).webp2024-11-12-12-01-40.jpg',575,500,488.75,'OPPO Reno10 Pro+',15,15,_binary '',9,0,13);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_color`
--

DROP TABLE IF EXISTS `product_color`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_color` (
  `id` int NOT NULL AUTO_INCREMENT,
  `color_id` int DEFAULT NULL,
  `product_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3iys6jgmsdkw7w5ncgm55wgj3` (`color_id`),
  KEY `FKqb6lncpndi0w5po3rr5r9up5e` (`product_id`),
  CONSTRAINT `FK3iys6jgmsdkw7w5ncgm55wgj3` FOREIGN KEY (`color_id`) REFERENCES `color` (`id`),
  CONSTRAINT `FKqb6lncpndi0w5po3rr5r9up5e` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=118 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_color`
--

LOCK TABLES `product_color` WRITE;
/*!40000 ALTER TABLE `product_color` DISABLE KEYS */;
INSERT INTO `product_color` VALUES (63,3,7),(64,4,7),(65,5,7),(66,6,7),(82,4,9),(83,5,9),(84,6,9),(85,4,8),(86,5,8),(87,6,8),(88,3,10),(89,5,10),(90,6,10),(91,4,11),(92,5,11),(93,6,11),(100,3,13),(101,4,13),(102,5,13),(103,6,13),(104,4,12),(105,5,12),(106,6,12),(107,3,14),(108,4,14),(109,5,14),(110,6,14),(111,4,15),(112,5,15),(113,6,15),(114,3,16),(115,4,16),(116,5,16),(117,6,16);
/*!40000 ALTER TABLE `product_color` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_size`
--

DROP TABLE IF EXISTS `product_size`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_size` (
  `id` int NOT NULL AUTO_INCREMENT,
  `product_id` int DEFAULT NULL,
  `size_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8i3jm2ctt0lsyeik2wt76yvv0` (`product_id`),
  KEY `FKnlkh5xcjuopsnoimdvmumioia` (`size_id`),
  CONSTRAINT `FK8i3jm2ctt0lsyeik2wt76yvv0` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `FKnlkh5xcjuopsnoimdvmumioia` FOREIGN KEY (`size_id`) REFERENCES `size` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_size`
--

LOCK TABLES `product_size` WRITE;
/*!40000 ALTER TABLE `product_size` DISABLE KEYS */;
INSERT INTO `product_size` VALUES (37,7,2),(43,9,2),(44,8,2),(45,10,1),(46,10,2),(47,10,3),(48,11,2),(55,13,1),(56,13,2),(57,13,3),(58,12,1),(59,12,2),(60,12,3),(61,14,1),(62,14,2),(63,14,3),(64,15,1),(65,15,2),(66,15,3),(67,16,1),(68,16,2),(69,16,3);
/*!40000 ALTER TABLE `product_size` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `review`
--

DROP TABLE IF EXISTS `review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `review` (
  `id` int NOT NULL AUTO_INCREMENT,
  `rating` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `review_date` datetime(6) DEFAULT NULL,
  `star` int DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `product_id` int DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKiyof1sindb9qiqr9o8npj8klt` (`product_id`),
  KEY `FK6cpw2nlklblpvc7hyt7ko6v3e` (`user_id`),
  CONSTRAINT `FK6cpw2nlklblpvc7hyt7ko6v3e` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKiyof1sindb9qiqr9o8npj8klt` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review`
--

LOCK TABLES `review` WRITE;
/*!40000 ALTER TABLE `review` DISABLE KEYS */;
/*!40000 ALTER TABLE `review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ADMIN'),(2,'USER');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `size`
--

DROP TABLE IF EXISTS `size`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `size` (
  `id` int NOT NULL AUTO_INCREMENT,
  `size_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `size`
--

LOCK TABLES `size` WRITE;
/*!40000 ALTER TABLE `size` DISABLE KEYS */;
INSERT INTO `size` VALUES (1,'M'),(2,'L'),(3,'S');
/*!40000 ALTER TABLE `size` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `role_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`),
  KEY `FKj345gk1bovqvfame88rcx7yyx` (`user_id`),
  CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `FKj345gk1bovqvfame88rcx7yyx` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,1,3);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `code_otp` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `enabled` bit(1) DEFAULT NULL,
  `full_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `gender` int DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL,
  `pass_word` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKk8d0f2n7n88w1a16yhua64onx` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,NULL,NULL,NULL,NULL,_binary '',NULL,NULL,NULL,'21313','09475','acc1'),(2,NULL,NULL,NULL,NULL,_binary '',NULL,NULL,NULL,'$2a$10$xZaEDxZ7YGR9aRJ8E6rgIOeQfFGDZIQ8IEnNpTZ9fYCdMOTb5YvbO','0947669387','acc'),(3,NULL,NULL,NULL,NULL,_binary '',NULL,NULL,NULL,'$2a$10$P5O1Wts3IEiY1R2t1w30VuA0kC/c/lkrXKkBg.TAJyOZ1l9EzJp76','0947669387','duy'),(4,NULL,NULL,NULL,NULL,_binary '',NULL,NULL,NULL,'$2a$10$EqPaKol4fMco4NNLwAYwR.e291.HihXkWHilsLzyLqD5lNC0YRXQq','0947669387','ad');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wish_list`
--

DROP TABLE IF EXISTS `wish_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wish_list` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKr1w2h67p25icr918heol9jisu` (`user_id`),
  CONSTRAINT `FKit8ap20bpapw291y78egje6f3` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wish_list`
--

LOCK TABLES `wish_list` WRITE;
/*!40000 ALTER TABLE `wish_list` DISABLE KEYS */;
INSERT INTO `wish_list` VALUES (1,3),(2,4);
/*!40000 ALTER TABLE `wish_list` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-11-25 15:55:32
