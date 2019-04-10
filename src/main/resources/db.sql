drop database if exists faxianbei;

create database faxianbei DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

DROP TABLE IF EXISTS `chat`;


CREATE TABLE `chat` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `fromid` bigint(20) DEFAULT NULL,
  `toid` bigint(20) DEFAULT NULL,
  `msg` varchar(256) DEFAULT NULL,
  `send_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `is_read` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chat`
--

LOCK TABLES `chat` WRITE;
/*!40000 ALTER TABLE `chat` DISABLE KEYS */;
INSERT INTO `chat` VALUES (2,1002,1000,'sdhjdh','2019-03-07 15:55:08',0),(3,1001,1000,'ffff','2019-03-07 15:57:02',0),(4,1001,1000,'eee','2019-03-07 15:58:07',0);
/*!40000 ALTER TABLE `chat` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `idea`
--

LOCK TABLES `idea` WRITE;
/*!40000 ALTER TABLE `idea` DISABLE KEYS */;
INSERT INTO `idea` VALUES (1,1000,'2019-03-06 07:49:49','哈哈哈哈','好主意','ddd'),(2,1000,'2019-03-06 07:50:15','dshjd','scs','ss'),(3,1000,'2019-03-06 08:41:17','wfsf','w','ss'),(4,1000,'2019-03-06 13:49:52','test','testtest','testtest');
/*!40000 ALTER TABLE `idea` ENABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;
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
) ENGINE=InnoDB AUTO_INCREMENT=1003 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_favorite`
--

LOCK TABLES `project_favorite` WRITE;
/*!40000 ALTER TABLE `project_favorite` DISABLE KEYS */;
INSERT INTO `project_favorite` VALUES (1001,1001,1000,'2019-03-07 15:45:31'),(1002,1002,1000,'2019-03-07 15:45:35');
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
) ENGINE=InnoDB AUTO_INCREMENT=1003 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_detail`
--

LOCK TABLES `student_detail` WRITE;
/*!40000 ALTER TABLE `student_detail` DISABLE KEYS */;
INSERT INTO `student_detail` VALUES (1000,1000,'计算机','计算机171','123444232','12346274@aa.com','男','大数据',NULL,'hadoop, spark, hive'),(1001,1001,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1002,1002,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
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
INSERT INTO `teacher` VALUES (1000,'老师1','副教授','家里蹲','信息管理与信息系统','数据库、java、大数据、云计算','全国优秀教师','大数据，人工智能与电子商务相结合，新型数据库与传统数据库的区别','大数据，人工智能与电子商务相结合，新型数据库与传统数据库的区别','dhasdh@edu.cn',NULL),(1001,'老师2','教授','加里敦','软件工程','智能信息系统','全国教学能手','人工智能，机器学习','Visual FoxPro教程、关系型数据库原理与应用',NULL,NULL),(1002,'老师3','教授','家里蹲','计算机科学与技术','C语言程序设计、面向对象程序设计(C++)、计算机虚拟技术与图形学。','学生满意的老师','图像分析与机器视觉、计算机虚拟技术与图形学。','基于电子商务的农民专业合作社网上销售系统构建.','tom@edu.cn',NULL);
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=1003 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;



LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1000,'tom','$2a$10$IdnKHZIOuJDf9jY5mOihBeAFP3TbbM4ddXbHxrCLEay9DIvsd3rDm',1000,'2019-03-07 11:08:00'),(1001,'kate','$2a$10$L5Hg.krxR03PU4JzzOW5quwAYRZNm8c2mdwK6G72lYsSTqQEip0cS',1001,'2019-03-07 14:06:30'),(1002,'root','$2a$10$h4My4kAFVwMQGcw8V9q5SuJlcIz3.9eFgynAigCbtLDp5m2wI8ege',1002,'2019-03-07 15:06:11');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

