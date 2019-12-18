-- MySQL dump 10.13  Distrib 5.7.25, for macos10.14 (x86_64)
--
-- Host: localhost    Database: jpro
-- ------------------------------------------------------
-- Server version	5.7.25

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
-- Table structure for table `Article`
--

DROP TABLE IF EXISTS `Article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Article` (
  `DTYPE` varchar(31) COLLATE utf8mb4_unicode_ci NOT NULL,
  `id` bigint(20) NOT NULL,
  `content` longtext COLLATE utf8mb4_unicode_ci,
  `createdDate` datetime DEFAULT NULL,
  `published` bit(1) NOT NULL,
  `title` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `eventDate` datetime DEFAULT NULL,
  `location` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `AUTHOR_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKoyqyto5gh7h6uf2v9e94y9b61` (`AUTHOR_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Article`
--

LOCK TABLES `Article` WRITE;
/*!40000 ALTER TABLE `Article` DISABLE KEYS */;
INSERT INTO `Article` VALUES ('Article',1,'<article id=\"post-50363\" class=\"post-50363 page type-page status-publish hentry\">\n\n				\n					<h1 class=\"main_title\">jProfessionals</h1>\n				\n				\n					<div class=\"entry-content\">\n					\n<img src=\"../img/bg/logo_jprofessionals-1.png\" style=\"width:80%\" />\n\n\n<p><strong>Howdy!</strong></p>\n\n\n\n<p><strong>jProfessionals</strong> is a local Bulgarian one day conference with mostly, but not only, Bulgarian speakers. You will have a full day of different Java related topics .<br>The conference will be fully community driven, its sponsors will be basically every Bulgarian Java User Group. This will not be an annual conference, instead we plan to make mini conference like that every 3-4 months!<br>So if you want to give it a try as a speaker or if you want to propose a nice topic, but you are not sure about the interest and scared from the big stage like&nbsp;<a href=\"http://jprime.io/\">jPrime</a>, then this conference is for you!<br>The talks slots depend on you! You can speak the regular 45 minutes or you can speak 1 hour and 15 minutes if you like. Just let us know how much time you need (between 0:45h and 1:30h). You can submit your talk at BG JUG CFP page&nbsp;<strong><a rel=\"noreferrer noopener\" href=\"https://www.facebook.com/l.php?u=https%3A%2F%2Fjug.bg%2Fsubmit-a-talk%2F&amp;h=CAQH-sgAwAQEFoywb_DsTFO7tH1JahnVLHMGED7Axvj5-FQ&amp;enc=AZO6_DT41GXGbUKVwlUiYCVijnvMmXfIRjmsGZo3L-pbqfcVZe-OlZM6AM4pDkYrZ5HgO3lV1Dm7giBaAMsnuYE4nnDsuly604wiJc2jupgpf5EBTiFRjth9foWKuiKxLK4HtO8yFVY0A9y1ilNqMrADVkWwqB1IeSWC5H0xaXlFgIdFd4jmED7ko2LJ9Masnuz2r7IOG9rGC1wcuy5k3KNp&amp;s=1\" target=\"_blank\">https://jug.bg/submit-a-talk/</a>&nbsp;</strong>. Just add in the description the talk duration with the description and specify that this is for&nbsp;<strong>jProfessionals</strong>&nbsp;and not for the regular monthly JUG seminars.<br>Lets make a bigger and better Java community, lets meet, lets talk, lets discuss!</p>\n\n\n\n<p>You can think about&nbsp;<strong>jProffesionals</strong>&nbsp;as a mini, but free&nbsp;<a href=\"http://jprime.io/\">jPrime</a>, which is mostly in Bulgarian presented by people you probably know, people from our community.</p>\n\n\n\n<p>The editions we had so far:</p>\n\n\n\n<ul><li><a href=\"https://jug.bg/jprofessionals-first-edition\">https://jug.bg/jprofessionals-first-edition</a></li><li><a href=\"https://jug.bg/jprofessionals-2-0\">https://jug.bg/jprofessionals-2-0</a></li><li><a href=\"https://jug.bg/jprofessionals-java-day-with-venkat/\">https://jug.bg/jprofessionals-java-day-with-venkat/</a></li><li><a href=\"https://jug.bg/jprofessionals-on-tour-plovdiv/\">https://jug.bg/jprofessionals-on-tour-plovdiv/</a></li><li><a href=\"https://jug.bg/events/jprofessionals-adopt-cdi/\">https://jug.bg/events/jprofessionals-adopt-cdi/</a></li><li><a href=\"https://jug.bg/events/jprofessionals-on-tour-varna/\">https://jug.bg/events/jprofessionals-on-tour-varna/</a></li><li><a href=\"https://jug.bg/events/jprofessionals-winter-edition/\">https://jug.bg/events/jprofessionals-winter-edition/</a></li><li><a href=\"https://jug.bg/events/jprofessionals-on-tour-plovdiv-2/\">https://jug.bg/events/jprofessionals-on-tour-plovdiv-2/</a></li><li>… and more to come!</li></ul>\n\n\n\n<p></p>\n					</div> <!-- .entry-content -->\n\n				\n				</article>','2019-12-18 12:49:30',_binary '\0','Home',NULL,NULL,NULL),('Article',3,'<div class=\"entry-content\">\n					<p>For those of you that hear it for the first time, <strong>jProfessionals</strong> is the one day conference&nbsp;by Bulgarian JUG, where&nbsp;<strong>the stage is yours.</strong> After a few successful events in Sofia we decided to give the opportunity to other Bulgarian cities to host it.</p>\n					</div> <!-- .entry-content -->\n','2019-12-18 12:50:33',_binary '\0','About',NULL,NULL,NULL),('Event',19,'dada jProfessionals Plovdiv 2020','2019-12-18 12:50:51',_binary '\0','jProfessionals Plovdiv 2020','2019-09-16 13:04:09','Sofia, Bulgaria',NULL),('Article',7,'<p class=\"post-meta\"> by <a href=\"https://jug.bg/en/author/joke/\" title=\"Posts by JOKe\" rel=\"author\">JOKe</a> | Feb 19, 2015 | <a href=\"https://jug.bg/category/blog/\" rel=\"category tag\">Blog</a> | <span class=\"comments-number\"><a href=\"https://jug.bg/2015/02/official-facebook-group-of-the-bulgarian-java-user-group/#respond\">0 comments</a></span></p>\n					\n					<div class=\"entry-content\">\n					<p>We are trying to resurrect the old facebook group we had for the “Bulgarian Java User Group”.</p>\n<p>You can join here&nbsp;<a href=\"https://www.facebook.com/groups/19635702600/\">https://www.facebook.com/groups/19635702600/</a> (&nbsp;around 100 members currently)</p>\n<p><strong>Update</strong>: Facebook killed our group ! Not kidding the facebook group doesnt exist anymore.<br>\nFacebook decided to remove it without any information why, because of that we officially DON’T have facebook group, also we do not have google+ or linkedin group.</p>\n<p>if you want to join our group use google mailing list <a href=\"https://groups.google.com/forum/#!forum/bg-jug\">https://groups.google.com/forum/#!forum/bg-jug</a> thats the only official channel to contact BG JUG and to be part of BG JUG.</p>\n<p>We do spam in Java Developers Bulgaria facbeook group <a href=\"https://www.facebook.com/groups/javabg/\">https://www.facebook.com/groups/javabg/ </a>but this group is NOT ours.</p>\n					</div> <!-- .entry-content -->','2019-11-12 16:07:46',_binary '\0','Official Facebook Group of the Bulgarian Java User Group',NULL,NULL,NULL),('Article',8,'<div class=\"entry-content\">\n					<p>We do now have a Youtube channel with several videos :</p>\n<p><a href=\"https://www.youtube.com/user/BulgarianJUG/videos\">https://www.youtube.com/user/BulgarianJUG/videos</a></p>\n<p>You MUST check them out </p>\n</div>','2019-11-12 16:06:14',_binary '\0','Youtube channel of the Bulgarian Java User Group',NULL,NULL,NULL),('Article',14,'Hello peoples','2019-11-12 14:13:29',_binary '','Some amazing ArticleDTO',NULL,NULL,13),('Article',18,'<div class=\"entry-content\">\n					<p>The places where you can find find out more about us and understand what we are doing are as follows:</p>\n<ul>\n<li style=\"list-style-type: none;\">\n<ul>\n<li><strong>Google Groups</strong>: <a href=\"http://groups.google.com/group/bg-jug\" target=\"_blank\" rel=\"noopener\">http://groups.google.com/group/bg-jug</a><br>\nMailing list</li>\n</ul>\n</li>\n</ul>\n<ul>\n<li style=\"list-style-type: none;\">\n<ul>\n<li><strong>Twitter</strong>: <a href=\"https://twitter.com/#!/bgjug\">https://twitter.com/#!/bgjug</a><br>\nTwitter account</li>\n</ul>\n</li>\n</ul>\n<ul>\n<li style=\"list-style-type: none;\">\n<ul>\n<li><strong>Google Code</strong>: <a href=\"http://code.google.com/p/bg-jug-resource-repository/\" target=\"_blank\" rel=\"noopener\">http://code.google.com/p/bg-jug-resource-repository</a><br>\nRepository with materials (presentations, demos) created by Bulgarian JUG members</li>\n</ul>\n</li>\n</ul>\n<ul>\n<li style=\"list-style-type: none;\">\n<ul>\n<li><strong>YouTube</strong>: <a href=\"http://www.youtube.com/user/BulgarianJUG\" target=\"_blank\" rel=\"noopener\">http://www.youtube.com/user/BulgarianJUG</a><br>\nYouTube Official Channel</li>\n</ul>\n</li>\n</ul>\n<ul>\n<li style=\"list-style-type: none;\">\n<ul>\n<li><b>Facebook:&nbsp;</b><a href=\"https://www.facebook.com/groups/19635702600/\">https://www.facebook.com/groups/19635702600/</a><br>\nОфициалната facebook група</li>\n</ul>\n</li>\n</ul>\n<ul>\n<li><strong>E-mail</strong>: <em>go6@jug.bg</em><br>\nDrop us an email </li>\n</ul>\n					</div> <!-- .entry-content -->\n','2019-11-12 16:09:29',_binary '\0','Contacts',NULL,NULL,NULL);
/*!40000 ALTER TABLE `Article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Page`
--

DROP TABLE IF EXISTS `Page`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Page` (
  `id` bigint(20) NOT NULL,
  `content` longtext COLLATE utf8mb4_unicode_ci,
  `published` bit(1) NOT NULL,
  `title` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Page`
--

LOCK TABLES `Page` WRITE;
/*!40000 ALTER TABLE `Page` DISABLE KEYS */;
/*!40000 ALTER TABLE `Page` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Submission`
--

DROP TABLE IF EXISTS `Submission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Submission` (
  `id` bigint(20) NOT NULL,
  `details` longtext COLLATE utf8mb4_unicode_ci,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `title` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Submission`
--

LOCK TABLES `Submission` WRITE;
/*!40000 ALTER TABLE `Submission` DISABLE KEYS */;
/*!40000 ALTER TABLE `Submission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Tag`
--

DROP TABLE IF EXISTS `Tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Tag` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Tag`
--

LOCK TABLES `Tag` WRITE;
/*!40000 ALTER TABLE `Tag` DISABLE KEYS */;
INSERT INTO `Tag` VALUES (2,'home'),(4,'about'),(6,'events'),(9,'news'),(10,'submit a talk'),(11,'contacts'),(12,'login'),(20,'events');
/*!40000 ALTER TABLE `Tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User`
--

DROP TABLE IF EXISTS `User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `User` (
  `id` bigint(20) NOT NULL,
  `bio` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `fullname` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `nickname` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `photo` longblob,
  `salt` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User`
--

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
INSERT INTO `User` VALUES (13,NULL,'nayden@example.org','Nayden Gochev',NULL,'m�FI�*Ħr�866��',NULL,''),(15,NULL,'mitya@example.org','Dmitry Alexandrov',NULL,'m�FI�*Ħr�866��',NULL,''),(16,NULL,'admin',NULL,NULL,'���\0�t�%�׫��B�1���!V�J[\\��K�',NULL,'QTtxjhBdzIGERiffxyZ4');
/*!40000 ALTER TABLE `User` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User_roles`
--

DROP TABLE IF EXISTS `User_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `User_roles` (
  `User_id` bigint(20) NOT NULL,
  `roles` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  KEY `FKi81fp6mx433heb7dvbxqaqvpv` (`User_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User_roles`
--

LOCK TABLES `User_roles` WRITE;
/*!40000 ALTER TABLE `User_roles` DISABLE KEYS */;
INSERT INTO `User_roles` VALUES (15,'admin'),(16,'admin');
/*!40000 ALTER TABLE `User_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `article_tag`
--

DROP TABLE IF EXISTS `article_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `article_tag` (
  `article_id` bigint(20) NOT NULL,
  `tag_id` bigint(20) NOT NULL,
  PRIMARY KEY (`article_id`,`tag_id`),
  KEY `FK90wcwa9v0ajbnriip2bgfxs8t` (`tag_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article_tag`
--

LOCK TABLES `article_tag` WRITE;
/*!40000 ALTER TABLE `article_tag` DISABLE KEYS */;
INSERT INTO `article_tag` VALUES (1,2),(3,4),(7,9),(8,9),(18,11),(19,20);
/*!40000 ALTER TABLE `article_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (21),(21),(21),(21);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `page_tag`
--

DROP TABLE IF EXISTS `page_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `page_tag` (
  `page_id` bigint(20) NOT NULL,
  `tag_id` bigint(20) NOT NULL,
  PRIMARY KEY (`page_id`,`tag_id`),
  KEY `FKh1kxv4c8wv4r5v21qdgabyvps` (`tag_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `page_tag`
--

LOCK TABLES `page_tag` WRITE;
/*!40000 ALTER TABLE `page_tag` DISABLE KEYS */;
/*!40000 ALTER TABLE `page_tag` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-18 12:55:55
