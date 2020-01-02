-- MySQL dump 10.13  Distrib 5.7.25, for macos10.14 (x86_64)
--
-- Host: localhost    Database: bgjug
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
INSERT INTO `Article` VALUES ('Article',1,'<div class=\"et_pb_row\">\n			<div class=\"et_pb_column et_pb_column_1_2\">\n			<div class=\"et_pb_text et_pb_bg_layout_light et_pb_text_align_left\">\n			\n<h2>Welcome!</h2>\n<p>The Bulgarian Java Users Group (BGJUG) is the World’s Java community&nbsp;representative in Bulgaria. The Java Users Groups are local organizations all around the world, which unites various groups of specialists, who are strongly interested in the Java-related technologies. Java Users Groups organize regular formal and informal meetings, conferences and seminars, on which they gather their members in order to exchange information related to Java. Usually, BGJUG members organize seminars and discussions monthly. The invitations for the events are published on this site, in the section&nbsp;“<a title=\"Events\" href=\"http://java-bg.org/?page_id=89&amp;lang=en\">Events</a>“. The materials (such as presentations and demos), created by BGJUG members are collected and stored in the BGJUG’s&nbsp;<a href=\"http://code.google.com/p/bg-jug-resource-repository/\">Google Code Repository</a> \n		</p></div> <!-- .et_pb_text --><div class=\"et_pb_text et_pb_bg_layout_light et_pb_text_align_left\">\n			\n<p><a href=\"https://jug.bg/wp-content/uploads/2015/01/Cd8nEOmUYAEVYN-.jpg\" rel=\"attachment wp-att-49460\"><img class=\"\" src=\"https://jug.bg/wp-content/uploads/2015/01/Cd8nEOmUYAEVYN-.jpg\" alt=\"Cd8nEOmUYAEVYN-\" width=\"250\" height=\"293\"></a></p>\n<p>Bulgarian Java User Group is proud to be&nbsp;<a href=\"https://twitter.com/javaee_guardian\">JavaEE Guardian</a></p>\n\n		</div> <!-- .et_pb_text -->\n		</div> <!-- .et_pb_column --><div class=\"et_pb_column et_pb_column_1_2\">\n			<div class=\"et_pb_text et_pb_bg_layout_light et_pb_text_align_left\">\n			\n<h2>A Bit of History</h2>\n<p>The first oficial meeting of the Bulgarian JUG took place on 26th of September 2007. Group’s chairman/coordinator is Petar Tahchiev. Since 12th of October 2007 BGJUG maintains mailing list, where are considered questions and problems from the Java World, ideas for future seminars and topics related to the Java-community in Buglaria as well. The mailing list is accessible on the following URL: http://groups.google.com/group/bg-jug. At the same time had been created the BGJUG’s first site, but its mainatanance was discontinued after a few months. On 28th of July 2011 was created the current site, which aim is to represent the group in Internet and to serve as an information board for meetings organisations. The site aggregates the posts from the group’s members’ blogs related somehow to Java. On 23rd of September 2011 was created a Twitter account of The BGJUG, which main aim is to representat us in Twitter. It will be used also for sharing news, announcements for meetings and seminars, i.e. everything which concerns BGJUG activities. \n		</p></div> <!-- .et_pb_text -->\n		</div> <!-- .et_pb_column -->\n		</div>\n\n<div class=\"et_pb_section et_section_regular\">\n			\n			\n				\n				<div class=\"et_pb_row\">\n			<div class=\"et_pb_column et_pb_column_4_4\">\n			<div class=\"et_pb_text et_pb_bg_layout_light et_pb_text_align_center\">\n			\n<h1 style=\"text-align: center;\">The JUG team</h1>\n\n		</div> <!-- .et_pb_text -->\n		</div> <!-- .et_pb_column -->\n		</div> <!-- .et_pb_row --><div class=\"et_pb_row\">\n			<div class=\"et_pb_column et_pb_column_1_4\">\n			<a href=\"http://nosoftskills.com\"><img src=\"https://jug.bg/wp-content/uploads/2015/01/ivan-e1441996160692.jpg\" alt=\"\" class=\"et-waypoint et_pb_image et_pb_animation_left et_pb_image_sticky et-animated\"></a>\n		</div> <!-- .et_pb_column --><div class=\"et_pb_column et_pb_column_3_4\">\n			<div class=\"et_pb_text et_pb_bg_layout_light et_pb_text_align_left\">\n			Ivan St. Ivanov is development architect at SAP Labs Bulgaria, working in the HANA Cloud Platform performance team. He is active JUG member, driving the adoption of OpenJDK in Bulgaria. In his free time he likes contributing to open source software, mostly to JBoss Forge. Ivan is doing his PhD in the area of cloud multi-tenancy in the University of National and World Economy in Sofia. He is teaching Java, Java EE and SOA in three Universities in Sofia.<br>\n<a href=\"http://nosoftskills.com/\">nosoftskills.com</a>\n		</div> <!-- .et_pb_text -->\n		</div> <!-- .et_pb_column -->\n		</div> <!-- .et_pb_row --><div class=\"et_pb_row\">\n			<div class=\"et_pb_column et_pb_column_1_4\">\n			<a href=\"https://mihail.stoynov.com\"><img src=\"https://jug.bg/wp-content/uploads/2015/01/mihail-e1441996139965.jpg\" alt=\"\" class=\"et-waypoint et_pb_image et_pb_animation_left et_pb_image_sticky et-animated\"></a>\n		</div> <!-- .et_pb_column --><div class=\"et_pb_column et_pb_column_3_4\">\n			<div class=\"et_pb_text et_pb_bg_layout_light et_pb_text_align_left\">\n			Mihail is a security and software consultant, trainer and author. His resume includes projects in companies like Saudi Aramco, Boeing, HP, Siemens, USAF, several foreign banks and government entities. Mihail is the co-author of 6 books on software, and has 10 years of training experience in local and foreign companies and most of the local universities.<br>\n<a href=\"https://mihail.stoynov.com\">mihail.stoynov.com</a>\n		</div> <!-- .et_pb_text -->\n		</div> <!-- .et_pb_column -->\n		</div> <!-- .et_pb_row --><div class=\"et_pb_row\">\n			<div class=\"et_pb_column et_pb_column_1_4\">\n			<a href=\"http://gochev.org\"><img src=\"https://jug.bg/wp-content/uploads/2015/01/nayden-e1441996771948.jpg\" alt=\"\" width=100 height=100></a>\n		</div> <!-- .et_pb_column --><div class=\"et_pb_column et_pb_column_3_4\">\n			<div class=\"et_pb_text et_pb_bg_layout_light et_pb_text_align_left\">\n			Nayden Gochev is senior software developer and trailer with more then 10 years of experience in the field. Worked in many Bulgarian and international companies, some of them include ISY Intellect, ProxiAD, Insight Technologies, Unic AG, Phamola and Telerik. Participated in many Java User Group seminars, made multiple internal company trainings and trainings for java developers at Pragmatic academy, Plovdiv University, NASD and SoftUni. His personal blog can be found at <a href=\"http://gochev.org\">http://gochev.org</a>\n		</div> <!-- .et_pb_text -->\n		</div> <!-- .et_pb_column -->\n		</div> <!-- .et_pb_row --><div class=\"et_pb_row\">\n			<div class=\"et_pb_column et_pb_column_1_4\">\n			<a href=\"http://martin-toshev.com\"><img src=\"https://jug.bg/wp-content/uploads/2015/01/martin-e1441996957287.jpg\" alt=\"\" class=\"et-waypoint et_pb_image et_pb_animation_left et_pb_image_sticky et-animated\"></a>\n		</div> <!-- .et_pb_column --><div class=\"et_pb_column et_pb_column_3_4\">\n			<div class=\"et_pb_text et_pb_bg_layout_light et_pb_text_align_left\">\n			Martin is a Java enthusiast. He is a graduate of Computer Science from the University of Sofia. He is also a certified Java professional (SCJP6) and a certified IBM cloud computing solution advisor. His areas of interest include the wide range of Java-related technologies (such as Servlets, JSP, JAXB, JAXP, JMS, JMX, JAX-RS, JAX-WS, Hibernate, Spring Framework, Liferay Portal and Eclipse RCP), cloud computing technologies, cloud-based software architectures, enterprise application integration, relational and NoSQL databases. You can reach him for any Java and FOSS-related topics (especially Eclipse and the OpenJDK).<br>\n<a href=\"martin-toshev.com/\">http://martin-toshev.com/</a>\n		</div> <!-- .et_pb_text -->\n		</div> <!-- .et_pb_column -->\n		</div> <!-- .et_pb_row --><div class=\"et_pb_row\">\n			<div class=\"et_pb_column et_pb_column_1_4\">\n			<a href=\"http://dmitryalexandrov.net\"><img src=\"https://jug.bg/wp-content/uploads/2015/01/mitia-e1441996945181.jpg\" alt=\"\" class=\"et-waypoint et_pb_image et_pb_animation_left et_pb_image_sticky et-animated\"></a>\n		</div> <!-- .et_pb_column --><div class=\"et_pb_column et_pb_column_3_4\">\n			<div class=\"et_pb_text et_pb_bg_layout_light et_pb_text_align_left\">\n			Dmitry is a passionate Java developer. Through his 8+ years career he has gained a huge experience with different web technologies. His areas of interest include the wide range of Java-related technologies, enterprise solutions, cloud computing technologies, Eclipse plug-ins, as well as non-Java like NodeJs and NoSql. He’s big enthusiast of distributed multinational, multi location software development. At his free time he’s trying to contribute to OpenJDK and supports his own opensource project. His latest passion is Oracles Javascript runtime on JVM – Nashorn.\n		</div> <!-- .et_pb_text -->\n		</div> <!-- .et_pb_column -->\n		</div> <!-- .et_pb_row --><div class=\"et_pb_row\">\n			<div class=\"et_pb_column et_pb_column_1_4\">\n			<img src=\"https://jug.bg/wp-content/uploads/2018/09/picture_doychin.png\" alt=\"\" class=\"et-waypoint et_pb_image et_pb_animation_left et_pb_image_sticky et-animated\">\n		</div> <!-- .et_pb_column --><div class=\"et_pb_column et_pb_column_3_4\">\n			<div class=\"et_pb_text et_pb_bg_layout_light et_pb_text_align_left\">\n			Doychin Bondzhev is Java developer with experience in many technologies. His work includes software for different businesses like telecommunications, warehouse management, point of sale, service management, billing , service provisioning, customer support, banking and many more. In his free time he contributes to some Open Source projects. He is a big fan of JavaEE and Microprofile.\n		</div> <!-- .et_pb_text -->\n		</div> <!-- .et_pb_column -->\n		</div> <!-- .et_pb_row -->\n			\n		</div>','2019-11-12 14:15:23',_binary '\0','Home',NULL,NULL,NULL),('Article',3,'<div class=\"entry-content\">\n					<h1>Welcome!</h1>\n<p>The Bulgarian Java Users Group (BGJUG) is the World’s Java community&nbsp;representative in Bulgaria.</p>\n<p>The Java Users Groups are local organizations all around the world, which unites various groups of specialists, who are strongly interested in the Java-related technologies. Java Users Groups organize regular formal and informal meetings, conferences and seminars, on which they gather their members in order to exchange information related to Java.</p>\n<p>Usually, BGJUG members organize seminars and discussions monthly. The invitations for the events are published on this site, in the section&nbsp;“<a title=\"Events\" href=\"http://java-bg.org/?page_id=89&amp;lang=en\">Events</a>“.</p>\n<p>The materials (such as presentations and demos), created by BGJUG members are collected and stored in the BGJUG’s&nbsp;<a href=\"http://code.google.com/p/bg-jug-resource-repository/\">Google Code Repository</a>.</p>\n<h1>A Bit of History</h1>\n<ul>\n<li>The first oficial meeting of the Bulgarian JUG took place on 26th of September 2007. Group’s chairman/coordinator is&nbsp;<a title=\"Petar Tahchiev\" href=\"http://www.java.net/blogs/paranoiabla\">Petar Tahchiev</a>.</li>\n<li>Since 12th of October 2007 BGJUG maintains mailing list, where are considered questions and problems from the Java World, ideas for future seminars and topics related to the Java-community in Buglaria as well. The mailing list is accessible on the following URL:&nbsp;<a href=\"http://groups.google.com/group/bg-jug\" target=\"_blank\">http://groups.google.com/group/bg-jug</a>.</li>\n<li>At the same time had been created the BGJUG’s first site, but its mainatanance was discontinued after a few months.</li>\n<li>On 28th of July 2011 was created the current site, which aim is to represent the group in Internet and to serve as an information board for meetings organisations. The site aggregates the posts from the group’s members’ blogs related somehow to Java.</li>\n<li>On 23rd of September 2011 was created a Twitter account of The BGJUG, which main aim is to&nbsp;representat us in Twitter. It will be used also for sharing news, announcements for meetings and seminars, i.e. everything which concerns BGJUG&nbsp;activities.</li>\n<li>As of January 2015 our JUG have an Leaders Board consisting of 5 people(Ivan St. Ivanov (<a href=\"https://twitter.com/ivan_stefanov\">@ivan_stefanov</a>), Dmitry Alexandrov (<a href=\"https://twitter.com/bercut2000\">@bercut2000</a>), Mihail Stoynov (<a href=\"https://twitter.com/mihailstoynov\">@mihailstoynov</a>), Martin Toshev (<a href=\"https://twitter.com/martin_fmi\">@martin_fmi</a>) and Nayden Gochev (<a href=\"https://twitter.com/gochev\">@gochev</a>) </li>\n<li>In May 2015 our JUG made a premium conference for Java in Bulgaria called jPrime (http://jprime.io)</li>\n<li>In June 2015 we decided to change the domain to http://jug.bg because it is shorter.</li>\n<li>In November 2015 we made a small, free java conference called jProfessionals https://jug.bg/jprofessionals/</li>\n<li>In February 2016 we made the second iteration of our small and free java conference called jProfessionals https://jug.bg/jprofessionals-2-0/</li>\n</ul>\n<h1>Membership</h1>\n<p>Everybody who is interested in the Java technologies could become part of BGJUG. The only formal procedure is applying for membership on the following URL:</p>\n<p><a href=\"http://groups.google.com/group/bg-jug/subscribe?hl=en\">http://groups.google.com/group/bg-jug/subscribe?hl=bg</a>&nbsp;. This will add your email address to the mailing list. In case you are no longer interested being part of the group, the unsubscription is always available.</p>\n<p>In case you would like to contribute to the work on this site or the Twitter account administration, write us to:&nbsp;<em>admin @ java-bg.org</em>.</p>\n<h1>Colaborations</h1>\n<p>BGJUG collaborates with the&nbsp;<a title=\"Bulgarian Association of Software Developers (BASD) \" href=\"http://www.devbg.org/en/index.html\">Bulgarian Association of Software Developers (BASD)</a>.</p>\n					</div> <!-- .entry-content -->\n','2019-11-12 16:04:30',_binary '\0','About',NULL,NULL,NULL),('Event',19,'dada ','2019-12-18 12:37:36',_binary '\0','dfsadasdsa 23 23','2019-09-16 13:04:09','Sofia, Bulgaria',NULL),('Article',7,'<p class=\"post-meta\"> by <a href=\"https://jug.bg/en/author/joke/\" title=\"Posts by JOKe\" rel=\"author\">JOKe</a> | Feb 19, 2015 | <a href=\"https://jug.bg/category/blog/\" rel=\"category tag\">Blog</a> | <span class=\"comments-number\"><a href=\"https://jug.bg/2015/02/official-facebook-group-of-the-bulgarian-java-user-group/#respond\">0 comments</a></span></p>\n					\n					<div class=\"entry-content\">\n					<p>We are trying to resurrect the old facebook group we had for the “Bulgarian Java User Group”.</p>\n<p>You can join here&nbsp;<a href=\"https://www.facebook.com/groups/19635702600/\">https://www.facebook.com/groups/19635702600/</a> (&nbsp;around 100 members currently)</p>\n<p><strong>Update</strong>: Facebook killed our group ! Not kidding the facebook group doesnt exist anymore.<br>\nFacebook decided to remove it without any information why, because of that we officially DON’T have facebook group, also we do not have google+ or linkedin group.</p>\n<p>if you want to join our group use google mailing list <a href=\"https://groups.google.com/forum/#!forum/bg-jug\">https://groups.google.com/forum/#!forum/bg-jug</a> thats the only official channel to contact BG JUG and to be part of BG JUG.</p>\n<p>We do spam in Java Developers Bulgaria facbeook group <a href=\"https://www.facebook.com/groups/javabg/\">https://www.facebook.com/groups/javabg/ </a>but this group is NOT ours.</p>\n					</div> <!-- .entry-content -->','2019-11-12 16:07:46',_binary '\0','Official Facebook Group of the Bulgarian Java User Group',NULL,NULL,NULL),('Article',8,'<div class=\"entry-content\">\n					<p>We do now have a Youtube channel with several videos :</p>\n<p><a href=\"https://www.youtube.com/user/BulgarianJUG/videos\">https://www.youtube.com/user/BulgarianJUG/videos</a></p>\n<p>You MUST check them out </p>\n</div>','2019-11-12 16:06:14',_binary '\0','Youtube channel of the Bulgarian Java User Group',NULL,NULL,NULL),('Article',14,'Hello peoples','2019-11-12 14:13:29',_binary '','Some amazing ArticleDTO',NULL,NULL,13),('Article',18,'<div class=\"entry-content\">\n					<p>The places where you can find find out more about us and understand what we are doing are as follows:</p>\n<ul>\n<li style=\"list-style-type: none;\">\n<ul>\n<li><strong>Google Groups</strong>: <a href=\"http://groups.google.com/group/bg-jug\" target=\"_blank\" rel=\"noopener\">http://groups.google.com/group/bg-jug</a><br>\nMailing list</li>\n</ul>\n</li>\n</ul>\n<ul>\n<li style=\"list-style-type: none;\">\n<ul>\n<li><strong>Twitter</strong>: <a href=\"https://twitter.com/#!/bgjug\">https://twitter.com/#!/bgjug</a><br>\nTwitter account</li>\n</ul>\n</li>\n</ul>\n<ul>\n<li style=\"list-style-type: none;\">\n<ul>\n<li><strong>Google Code</strong>: <a href=\"http://code.google.com/p/bg-jug-resource-repository/\" target=\"_blank\" rel=\"noopener\">http://code.google.com/p/bg-jug-resource-repository</a><br>\nRepository with materials (presentations, demos) created by Bulgarian JUG members</li>\n</ul>\n</li>\n</ul>\n<ul>\n<li style=\"list-style-type: none;\">\n<ul>\n<li><strong>YouTube</strong>: <a href=\"http://www.youtube.com/user/BulgarianJUG\" target=\"_blank\" rel=\"noopener\">http://www.youtube.com/user/BulgarianJUG</a><br>\nYouTube Official Channel</li>\n</ul>\n</li>\n</ul>\n<ul>\n<li style=\"list-style-type: none;\">\n<ul>\n<li><b>Facebook:&nbsp;</b><a href=\"https://www.facebook.com/groups/19635702600/\">https://www.facebook.com/groups/19635702600/</a><br>\nОфициалната facebook група</li>\n</ul>\n</li>\n</ul>\n<ul>\n<li><strong>E-mail</strong>: <em>go6@jug.bg</em><br>\nDrop us an email </li>\n</ul>\n					</div> <!-- .entry-content -->\n','2019-11-12 16:09:29',_binary '\0','Contacts',NULL,NULL,NULL);
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

-- Dump completed on 2019-12-18 12:42:09
