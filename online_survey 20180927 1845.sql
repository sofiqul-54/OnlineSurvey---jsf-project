-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.41-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema onlinesurvey
--

CREATE DATABASE IF NOT EXISTS onlinesurvey;
USE onlinesurvey;

--
-- Definition of table `answers_details`
--

DROP TABLE IF EXISTS `answers_details`;
CREATE TABLE `answers_details` (
  `surveyid` int(5) NOT NULL auto_increment,
  `questionid` int(5) NOT NULL default '0',
  `answer` char(1) default NULL,
  PRIMARY KEY  (`surveyid`,`questionid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `answers_details`
--

/*!40000 ALTER TABLE `answers_details` DISABLE KEYS */;
INSERT INTO `answers_details` (`surveyid`,`questionid`,`answer`) VALUES 
 (1,2001,'1'),
 (2,2000,'1'),
 (2,2001,'2'),
 (3,2002,'2'),
 (3,2003,'1'),
 (4,2002,'1'),
 (4,2003,'3'),
 (5,2007,'1'),
 (6,2008,'1'),
 (7,2000,'1'),
 (8,2001,'1'),
 (9,2004,'1');
/*!40000 ALTER TABLE `answers_details` ENABLE KEYS */;


--
-- Definition of table `answers_master`
--

DROP TABLE IF EXISTS `answers_master`;
CREATE TABLE `answers_master` (
  `surveyid` int(5) NOT NULL auto_increment,
  `topicid` int(5) default NULL,
  `takenon` date default NULL,
  PRIMARY KEY  (`surveyid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `answers_master`
--

/*!40000 ALTER TABLE `answers_master` DISABLE KEYS */;
INSERT INTO `answers_master` (`surveyid`,`topicid`,`takenon`) VALUES 
 (1,1001,'2018-09-27'),
 (2,1001,'2018-09-27'),
 (3,1002,'2018-09-27'),
 (4,1002,'2018-09-27'),
 (5,1005,'2018-09-27'),
 (6,1006,'2018-09-27'),
 (7,1001,'2018-09-27');
/*!40000 ALTER TABLE `answers_master` ENABLE KEYS */;


--
-- Definition of table `questions`
--

DROP TABLE IF EXISTS `questions`;
CREATE TABLE `questions` (
  `questionid` int(5) NOT NULL auto_increment,
  `questiontext` varchar(200) NOT NULL,
  `opt1` varchar(50) NOT NULL,
  `opt2` varchar(50) NOT NULL,
  `opt3` varchar(50) NOT NULL,
  `topicid` int(5) default NULL,
  PRIMARY KEY  (`questionid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `questions`
--

/*!40000 ALTER TABLE `questions` DISABLE KEYS */;
INSERT INTO `questions` (`questionid`,`questiontext`,`opt1`,`opt2`,`opt3`,`topicid`) VALUES 
 (2000,'What is your fav. dynamic Language','Javascript','Ruby','Python',1001),
 (2001,'What is your primary tool for writing code?','IDE','Text Editor','Both',1001),
 (2002,'Which MVC framework do you use?','JSF','Struts','Spring',1002),
 (2003,'Which Javascript library do you use?','JQuery','GWT','Others',1002),
 (2004,'What is Android?','Operating System','Mobile','None',1001),
 (2007,'What is Android?','Operating System','Mobile','None',1005),
 (2008,'What is Android?','Operating System','Mobile','None',1006),
 (2009,'What is html?','Hyper text markup language','asdasd','asdas',1007);
/*!40000 ALTER TABLE `questions` ENABLE KEYS */;


--
-- Definition of table `topics`
--

DROP TABLE IF EXISTS `topics`;
CREATE TABLE `topics` (
  `topicid` int(5) NOT NULL auto_increment,
  `topictitle` varchar(50) default NULL,
  `addedon` date default NULL,
  `uname` varchar(10) default NULL,
  PRIMARY KEY  (`topicid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `topics`
--

/*!40000 ALTER TABLE `topics` DISABLE KEYS */;
INSERT INTO `topics` (`topicid`,`topictitle`,`addedon`,`uname`) VALUES 
 (1001,'Programming Languages','2018-09-27','abc'),
 (1002,'Web Frameworks','2018-09-27','abc'),
 (1005,'Test topic','2018-09-27','def'),
 (1006,'Test topic2','2018-09-27','def'),
 (1007,'HTML','2018-09-27','abc');
/*!40000 ALTER TABLE `topics` ENABLE KEYS */;


--
-- Definition of table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `uname` varchar(10) NOT NULL,
  `password` varchar(10) default NULL,
  PRIMARY KEY  (`uname`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`uname`,`password`) VALUES 
 ('abc','abc'),
 ('def','d');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
