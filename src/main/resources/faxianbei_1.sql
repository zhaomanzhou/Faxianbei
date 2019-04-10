-- MySQL dump 10.13  Distrib 5.7.25, for Linux (x86_64)
--
-- Host: localhost    Database: faxianbei
-- ------------------------------------------------------
-- Server version	5.7.25-0ubuntu0.18.10.2

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
-- Current Database: `faxianbei`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `faxianbei` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `faxianbei`;

--
-- Table structure for table `idea`
--

DROP TABLE IF EXISTS `idea`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `idea` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `person_id` bigint(20) DEFAULT NULL COMMENT '记录者id',
  `record_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录时间',
  `name` varchar(20) DEFAULT NULL COMMENT '金点子名称',
  `description` varchar(200) DEFAULT NULL COMMENT '详细信息',
  `meaning` varchar(100) DEFAULT NULL COMMENT '意义',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `idea`
--

LOCK TABLES `idea` WRITE;
/*!40000 ALTER TABLE `idea` DISABLE KEYS */;
/*!40000 ALTER TABLE `idea` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `interest_tag`
--

DROP TABLE IF EXISTS `interest_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `interest_tag` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `s_id` bigint(20) DEFAULT NULL,
  `tag` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `interest_tag`
--

LOCK TABLES `interest_tag` WRITE;
/*!40000 ALTER TABLE `interest_tag` DISABLE KEYS */;
/*!40000 ALTER TABLE `interest_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_experience`
--

DROP TABLE IF EXISTS `project_experience`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project_experience` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `s_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `description` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_experience`
--

LOCK TABLES `project_experience` WRITE;
/*!40000 ALTER TABLE `project_experience` DISABLE KEYS */;
/*!40000 ALTER TABLE `project_experience` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_favorite`
--

DROP TABLE IF EXISTS `project_favorite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project_favorite` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `project_id` bigint(20) DEFAULT NULL COMMENT '收藏项目id',
  `person_id` bigint(20) DEFAULT NULL COMMENT '收藏者id',
  `collect_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '收藏时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_favorite`
--

LOCK TABLES `project_favorite` WRITE;
/*!40000 ALTER TABLE `project_favorite` DISABLE KEYS */;
/*!40000 ALTER TABLE `project_favorite` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_public`
--

DROP TABLE IF EXISTS `project_public`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project_public` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `s_id` bigint(20) DEFAULT NULL COMMENT '发布者id',
  `logo_path` varchar(100) DEFAULT NULL COMMENT 'logo图片保存的路径',
  `publish_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '发布时间',
  `title` varchar(50) DEFAULT NULL COMMENT '项目标题',
  `tiny_description` varchar(100) DEFAULT NULL COMMENT '简介',
  `catalog` varchar(20) DEFAULT NULL COMMENT '级别',
  `academy` varchar(50) DEFAULT NULL COMMENT '所属学院',
  `caption` varchar(50) DEFAULT NULL COMMENT '队长姓名',
  `direction` varchar(50) DEFAULT NULL COMMENT '项目方向',
  `type` varchar(20) DEFAULT NULL COMMENT '类型',
  `total_num` tinyint(4) DEFAULT NULL COMMENT '总人数',
  `cur_num` tinyint(4) DEFAULT '1' COMMENT '当前人数',
  `detail_description` text COMMENT '项目详情',
  `technology` varchar(50) DEFAULT NULL COMMENT '项目牵涉到的技术',
  `is_show` tinyint(4) DEFAULT '1' COMMENT '是否展示 0不展示  1 展示',
  `establish` tinyint(4) DEFAULT '0' COMMENT '项目人员是否招募完毕并启动 0否  1是',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1003 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_public`
--

LOCK TABLES `project_public` WRITE;
/*!40000 ALTER TABLE `project_public` DISABLE KEYS */;
INSERT INTO `project_public` VALUES (1000,1000,NULL,'2019-03-04 13:25:26','勇闯天涯','恩厉害的项目','国家级','信息工程学院','tom','web网站','比赛',8,1,NULL,NULL,1,0),(1001,1000,NULL,'2019-03-04 13:27:17','基于docker的容器化实战','ocker容器化技术','国家级','信息工程学院','tom','容器化','比赛',4,1,NULL,NULL,1,0),(1002,1001,NULL,'2019-03-04 13:29:09','新果树栽培技术','新的技术，你值得一试?','校级','园艺学院','jim','果树栽培','科创',6,1,NULL,NULL,1,0);
/*!40000 ALTER TABLE `project_public` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `publish_project_statue`
--

DROP TABLE IF EXISTS `publish_project_statue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `publish_project_statue` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `p_id` bigint(20) DEFAULT NULL COMMENT '项目id',
  `caption_id` bigint(20) DEFAULT NULL COMMENT '队长id',
  `s_id` bigint(20) DEFAULT NULL COMMENT '加入者id',
  `statue` int(11) DEFAULT '0' COMMENT '审核装态 0 未审核 1通过  -1拒绝加入',
  `request_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '操作时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1002 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `publish_project_statue`
--

LOCK TABLES `publish_project_statue` WRITE;
/*!40000 ALTER TABLE `publish_project_statue` DISABLE KEYS */;
INSERT INTO `publish_project_statue` VALUES (1000,1000,1000,1002,1,'2019-03-04 13:30:37'),(1001,1000,1000,1003,0,'2019-03-04 13:31:11');
/*!40000 ALTER TABLE `publish_project_statue` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_detail`
--

DROP TABLE IF EXISTS `student_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `academy` varchar(50) DEFAULT NULL COMMENT '学院',
  `major_and_class` varchar(70) DEFAULT NULL COMMENT '年纪专业',
  `tel` varchar(50) DEFAULT NULL COMMENT '电话',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `sex` varchar(4) DEFAULT NULL COMMENT '性别 字符串 ''男'' ''女''',
  `interest_direction` varchar(50) DEFAULT NULL COMMENT '兴趣方向',
  `image_path` varchar(100) DEFAULT NULL COMMENT '头像路径',
  `interest_tag` varchar(100) DEFAULT NULL COMMENT '兴趣标签',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1004 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_detail`
--

LOCK TABLES `student_detail` WRITE;
/*!40000 ALTER TABLE `student_detail` DISABLE KEYS */;
INSERT INTO `student_detail` VALUES (1000,1000,'信息工程学院','软件161','110120119','123@nwafu.edu.cn','男','大数据',NULL,'adoop， spark'),(1001,1001,'园艺学院','园艺161','32418248124','2424@nwafu.edu.cn','女','果树育种',NULL,'园艺，栽培'),(1002,1002,'动物科技学院','动科161','1318248184','jjdhsdfh@nwafu.edu.cn','男','动物营养学',NULL,'育种，繁殖'),(1003,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `student_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `rank` varchar(50) DEFAULT NULL,
  `school` varchar(64) DEFAULT NULL,
  `major` varchar(64) DEFAULT NULL,
  `courses` varchar(256) DEFAULT NULL,
  `award` varchar(512) DEFAULT NULL,
  `direction` varchar(128) DEFAULT NULL,
  `paper` varchar(256) DEFAULT NULL,
  `email` varchar(64) DEFAULT NULL,
  `logo_path` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1003 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (1000,'杨丽丽','副教授','西北农林科技大学','信息管理与信息系统','数据库、java、大数据、云计算','sci论文10篇，全国优秀讲师，多次代表学校参与全国大赛','大数据，人工智能与电子商务相结合，新型数据库与传统数据库的区别','大数据，人工智能与电子商务相结合，新型数据库与传统数据库的区别','ylili@nwafu.edu.cn',NULL),(1001,'李书琴','教授','西北农林科技大学','软件工程','智能信息系统','曾荣获校级教学名师和先进教师等称号，也获得了杨陵优秀青年和陕西省优秀青年教师荣誉。  ','人工智能，机器学习','Visual FoxPro教程、关系型数据库原理与应用',NULL,NULL),(1002,'耿楠','教授','西北农林科技大学','计算机科学与技术','C语言程序设计、面向对象程序设计(C++)、计算机虚拟技术与图形学。','2013年基本科研业务费专项资金科技创新一般项目作物生长三维形态快速获取与重构技术研究。','图像分析与机器视觉、计算机虚拟技术与图形学。','李志楠与耿楠, 基于电子商务的农民专业合作社网上销售系统构建.','nangeng@nwsuaf.edu.cn',NULL);
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher_detail`
--

DROP TABLE IF EXISTS `teacher_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher_detail`
--

LOCK TABLES `teacher_detail` WRITE;
/*!40000 ALTER TABLE `teacher_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `teacher_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `password` varchar(256) NOT NULL,
  `detail_id` int(11) DEFAULT NULL COMMENT '详细信息记录表对应id',
  `register_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1006 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1000,'tom','123',1000,'2019-03-04 13:14:39'),(1001,'jim','1234',NULL,'2019-03-04 13:16:54'),(1002,'zhangsan','111',NULL,'2019-03-04 13:17:30'),(1003,'lisi','222',NULL,'2019-03-04 13:17:41'),(1004,'wangwu','112',NULL,'2019-03-04 13:18:02'),(1005,'王五','$2a$10$047UwyZM1rHIiCP.za7ACu626DVoo39W2zu5GRECwTVh2150J//uK',NULL,'2019-03-05 03:20:25');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-03-05 12:20:25
