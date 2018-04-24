/*
Navicat MySQL Data Transfer

Source Server         : Localhost
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : elib

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-04-24 00:34:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for books
-- ----------------------------
DROP TABLE IF EXISTS `books`;
CREATE TABLE `books` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `description` text,
  `image` varchar(100) DEFAULT NULL,
  `download` varchar(100) NOT NULL,
  `language` varchar(100) NOT NULL,
  `publisher_id` int(11) DEFAULT NULL,
  `page` int(11) NOT NULL DEFAULT '0',
  `status` varchar(30) NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`),
  KEY `fk_publisher` (`publisher_id`),
  CONSTRAINT `fk_publisher` FOREIGN KEY (`publisher_id`) REFERENCES `publishers` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of books
-- ----------------------------
INSERT INTO `books` VALUES ('1', 'Qarishqa', 'Ajfskdjfskj', 'thumb.jpg', '1', 'az', null, '0', 'TRUE', '2017-11-22');
INSERT INTO `books` VALUES ('2', 'Qaeasfdd', 'Ajfskdjfskj', 'thumb.jpg', '1', 'az', null, '0', 'TRUE', '2017-11-22');
INSERT INTO `books` VALUES ('3', 'fsfsaf', 'Ajfskdjfskj', 'thumb.jpg', '1', 'az', null, '0', 'TRUE', '2017-11-22');
INSERT INTO `books` VALUES ('4', 'sgrda', 'Ajfskdjfskj', 'thumb.jpg', '1', 'az', null, '0', 'TRUE', '2017-11-22');

-- ----------------------------
-- Table structure for categories
-- ----------------------------
DROP TABLE IF EXISTS `categories`;
CREATE TABLE `categories` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `category_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`),
  KEY `fk_category` (`category_id`),
  CONSTRAINT `fk_category` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of categories
-- ----------------------------

-- ----------------------------
-- Table structure for category_book
-- ----------------------------
DROP TABLE IF EXISTS `category_book`;
CREATE TABLE `category_book` (
  `Category_Id` int(11) NOT NULL,
  `Book_Id` int(11) NOT NULL,
  KEY `fk_ck_category` (`Category_Id`),
  KEY `fk_ck_book` (`Book_Id`),
  CONSTRAINT `fk_ck_book` FOREIGN KEY (`Book_Id`) REFERENCES `books` (`id`),
  CONSTRAINT `fk_ck_category` FOREIGN KEY (`Category_Id`) REFERENCES `categories` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category_book
-- ----------------------------

-- ----------------------------
-- Table structure for counter
-- ----------------------------
DROP TABLE IF EXISTS `counter`;
CREATE TABLE `counter` (
  `Id` int(11) NOT NULL,
  `View` int(11) NOT NULL DEFAULT '0',
  `Download` int(11) NOT NULL DEFAULT '0',
  KEY `fk_counter_book` (`Id`),
  CONSTRAINT `fk_counter_book` FOREIGN KEY (`Id`) REFERENCES `books` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of counter
-- ----------------------------

-- ----------------------------
-- Table structure for feedbacks
-- ----------------------------
DROP TABLE IF EXISTS `feedbacks`;
CREATE TABLE `feedbacks` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(150) NOT NULL,
  `email` varchar(150) NOT NULL,
  `message` text NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of feedbacks
-- ----------------------------

-- ----------------------------
-- Table structure for publishers
-- ----------------------------
DROP TABLE IF EXISTS `publishers`;
CREATE TABLE `publishers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(150) NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of publishers
-- ----------------------------

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `FULLNAME` varchar(200) NOT NULL,
  `EMAIL` varchar(200) NOT NULL,
  `PASSWORD` varchar(60) NOT NULL,
  `IMAGE` varchar(200) DEFAULT NULL,
  `PHONE` varchar(30) DEFAULT NULL,
  `ROLE` varchar(50) NOT NULL DEFAULT '0',
  `STATUS` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `EMAIL` (`EMAIL`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'Shahin Nazarov', 'shaheen.nazarov@mail.ru', '$2a$10$qKg6jnMJfvWeK30nwIlrw.0v.8a.ARPPwxrIqK1Ilu66uxx81MaRK', null, '+994708900999', 'ADMIN', 'TRUE');
