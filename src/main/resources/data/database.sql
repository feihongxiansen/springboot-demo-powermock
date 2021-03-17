-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: test_mock
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `mc_article`
--

DROP TABLE IF EXISTS `mc_article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mc_article` (
                              `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
                              `title` varchar(100) NOT NULL DEFAULT '' COMMENT '标题',
                              `author` varchar(50) NOT NULL DEFAULT '' COMMENT '作者',
                              `content` text COMMENT '内容',
                              `release_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '发布时间',
                              `likes` int NOT NULL DEFAULT '0' COMMENT '点赞数',
                              PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='文章表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mc_article`
--

LOCK TABLES `mc_article` WRITE;
/*!40000 ALTER TABLE `mc_article` DISABLE KEYS */;
INSERT INTO `mc_article` VALUES (1,'5G打开虚拟现实的想象空间 预计2022年中国成为全球虚拟现实市场增长中心','徐大铮','戴上VR（虚拟现实）眼镜，新疆喀纳斯湖的美景实时呈现在眼前；通过VR修复技术，人们可以观赏景德镇御窑昔日盛景；进入微信小程序，足不出户就能全景观看楼盘样板房……虚拟现实技术解锁的多种应用新场景正变成现实。近年来，中国虚拟现实产业发展稳中向好，市场规模持续扩大，行业应用愈加丰富。据赛迪顾问公司预计，中国VR、AR（增强现实）市场规模将在2022年突破千亿元，成为全球虚拟现实市场的增长中心。','2020-12-12 01:20:19',0),(2,'5G叠加国产化趋势 半导体景气度中长期向上','李静','2020年三季度机构重仓持股申万电子二级分类行业配置比例资料来源：Wind、华西证券研究所；今年以来，居家经济火爆，5G手机、汽车、物联网等渗透率快速提升，驱动半导体需求增长。尤其是近期，以8寸晶圆制造的产能紧缺为发端，半导体产业链缺货、涨价行情逐步蔓延。机构认为，电子行业已步入以5G为主线的新一轮创新周期，展望2021年，苹果开启5G超级周期，产业链向国内转移，设计、制造、封测、设备等产业链各环节国产替代加速，消费电子龙头有望崛起，半导体行业景气度将迎来复苏。','2020-12-11 17:20:19',0);
/*!40000 ALTER TABLE `mc_article` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-17 13:53:21
