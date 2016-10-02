-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- المزود: localhost
-- أنشئ في: 07 يونيو 2011 الساعة 10:27
-- إصدارة المزود: 5.1.53
--  PHP إصدارة: 5.3.4

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- قاعدة البيانات: `ogc`
--

-- --------------------------------------------------------

--
-- بنية الجدول `account`
--

CREATE TABLE IF NOT EXISTS `account` (
  `username` varchar(20) NOT NULL,
  `aramco_id` varchar(15) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `email` varchar(30) NOT NULL,
  `fname` varchar(15) NOT NULL,
  `lname` varchar(15) NOT NULL,
  `gender` varchar(1) NOT NULL,
  `password` varchar(32) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `type_flag` int(11) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- إرجاع أو استيراد بيانات الجدول `account`
--

INSERT INTO `account` (`username`, `aramco_id`, `dob`, `email`, `fname`, `lname`, `gender`, `password`, `phone`, `type_flag`) VALUES
('testDoctor', '12345678', '1970-05-28', 'doctor@aramco.com', 'Essam', 'Jalal', 'm', '827ccb0eea8a706c4c34a16891f84e7b', '+966506333333', 3),
('patient', '123456123', NULL, 'patient@aramco.com', 'Mohammed', '', 'm', 'patient', '+966504666666', 1),
('testOGCT', '987654321', NULL, 'healthteam@aramco.com', 'Al-Test', 'Test', 'm', 'd0970714757783e6cf17b26fb8e2298f', '+966505555555', 2),
('test', '123456123', '1986-05-20', 'khaled@aramco.com', 'Khaled', 'Al-Khaled', 'm', '81dc9bdb52d04dc20036dbd8313ed055', '+966506333321', 1),
('sameer', NULL, NULL, 'samer@alamri', 'sameer', 'alamri', 'm', '1234', '123456', 1),
('test1', '123', NULL, 'asd', 'q', 'w', 'm', 'c4ca4238a0b923820dcc509a6f75849b', '2345', 1),
('khaled', NULL, NULL, 'asd', 'k', 'k', 'm', '8ce4b16b22b58894aa86c421e8759df3', '2134', 1),
('test2', NULL, NULL, 'a@s.com', 'a', 's', 'm', 'c81e728d9d4c2f636f067f89cc14862c', '234', 1),
('Ahmed', '1234', NULL, 'Ah@yahoo.com', 'Ahmed', 'J', 'm', '37693cfc748049e45d87b8c7d8b9aacd', '05677', 1),
('ali', NULL, NULL, 'ali@alibaba.com', 'ali', 'alali', 'm', 'e10adc3949ba59abbe56e057f20f883e', '0505050505', 1);

-- --------------------------------------------------------

--
-- بنية الجدول `goal`
--

CREATE TABLE IF NOT EXISTS `goal` (
  `goal_id` int(11) NOT NULL AUTO_INCREMENT,
  `goal_creator` varchar(20) NOT NULL,
  `goal_name` varchar(20) NOT NULL,
  `description` text NOT NULL,
  `doc` date NOT NULL,
  `daily_max` int(11) NOT NULL,
  `frequency` int(11) NOT NULL,
  `type` tinyint(4) NOT NULL,
  `deleted_flag` int(11) NOT NULL,
  PRIMARY KEY (`goal_id`),
  KEY `goalid` (`goal_id`,`goal_creator`,`goal_name`,`doc`,`daily_max`,`frequency`,`deleted_flag`),
  KEY `goal_creator` (`goal_creator`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;

--
-- إرجاع أو استيراد بيانات الجدول `goal`
--

INSERT INTO `goal` (`goal_id`, `goal_creator`, `goal_name`, `description`, `doc`, `daily_max`, `frequency`, `type`, `deleted_flag`) VALUES
(1, 'doctor', 'Walking', 'Multiples of 10 minutes ', '2011-05-28', 10, 7, 1, 0),
(2, 'doctor', 'Sitting', 'Multiple of 10 minutes', '2011-05-28', 100, 7, -1, 0),
(3, 'doctor', 'Water', 'Number of glasses', '2011-05-28', 10, 7, 1, 0),
(4, 'healthteam', 'Sugar', 'Any meal/snack containing simple sugar ', '2011-05-28', 10, 7, -1, 0),
(5, 'doctor', 'Sleep', 'Number of hours of night sleep', '2011-05-28', 8, 7, -1, 0),
(6, 'doctor', 'Fruits/Vegetables', 'Number of meals/snack containing fruits/vegetables', '2011-05-28', 10, 7, 1, 0),
(7, 'doctor', 'Multiple Meals', 'Number of meals/snack per day', '2011-05-28', 5, 7, 1, 0),
(8, 'healthteam', 'Healthy Cooking', 'Number of meals/snacks', '2011-05-28', 5, 7, 1, 0),
(9, 'doctor', 'Portion Control', 'Number of meals/snacks', '2011-05-28', 5, 7, 1, 0),
(10, 'testDoctor', 'Jogging', 'J', '0000-00-00', 10, 7, 1, 1),
(11, 'testDoctor', 'JOgging', 'jog', '0000-00-00', 5, 7, 1, 1);

-- --------------------------------------------------------

--
-- بنية الجدول `paitent`
--

CREATE TABLE IF NOT EXISTS `paitent` (
  `username` varchar(20) NOT NULL,
  `address` text NOT NULL,
  `weight` double NOT NULL,
  `height` double NOT NULL,
  `doe` date NOT NULL,
  `dperc` float(10,0) NOT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- إرجاع أو استيراد بيانات الجدول `paitent`
--

INSERT INTO `paitent` (`username`, `address`, `weight`, `height`, `doe`, `dperc`, `status`) VALUES
('patient', 'Aramco, KSA', 110.5, 1.75, '2011-05-28', 0, 2),
('khaled', 'Aramco, KSA', 125, 1.69, '2011-05-28', 0, 2),
('sameer', 'sadeeg st', 60, 150, '0000-00-00', 0, 1),
('test1', 'aramco', 990, 178, '0000-00-00', 0, 1),
('test2', 'as', 80, 189, '0000-00-00', 0, 1),
('Ahmed', 'Da', 100, 160, '0000-00-00', 0, 1),
('ali', 'asdfgh\r\nsadsa', 100, 180, '0000-00-00', 0, 1);

-- --------------------------------------------------------

--
-- بنية الجدول `paitent_goals`
--

CREATE TABLE IF NOT EXISTS `paitent_goals` (
  `assignition_id` int(11) NOT NULL AUTO_INCREMENT,
  `goal` int(11) NOT NULL,
  `paitent` varchar(20) NOT NULL,
  `assigned_by` varchar(20) NOT NULL,
  `doa` date NOT NULL,
  `current_flag` int(11) NOT NULL,
  `stated_daily_max` int(11) NOT NULL,
  `stated_frequency` int(11) NOT NULL,
  PRIMARY KEY (`assignition_id`),
  KEY `paitent` (`paitent`),
  KEY `assigned_by` (`assigned_by`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- إرجاع أو استيراد بيانات الجدول `paitent_goals`
--

INSERT INTO `paitent_goals` (`assignition_id`, `goal`, `paitent`, `assigned_by`, `doa`, `current_flag`, `stated_daily_max`, `stated_frequency`) VALUES
(1, 1, 'test', 'test', '2011-05-28', 1, 3, 5),
(2, 3, 'test', 'test', '2011-05-28', 1, 5, 7),
(3, 4, 'test', 'test', '2011-05-28', 1, 10, 7);

-- --------------------------------------------------------

--
-- بنية الجدول `paitent_goals_history`
--

CREATE TABLE IF NOT EXISTS `paitent_goals_history` (
  `paitent` varchar(20) NOT NULL,
  `assigned_goal` int(11) NOT NULL,
  `week` int(11) NOT NULL,
  `day1` int(11) NOT NULL DEFAULT '0',
  `day2` int(11) NOT NULL DEFAULT '0',
  `day3` int(11) NOT NULL DEFAULT '0',
  `day4` int(11) NOT NULL DEFAULT '0',
  `day5` int(11) NOT NULL DEFAULT '0',
  `day6` int(11) NOT NULL DEFAULT '0',
  `day7` int(11) NOT NULL DEFAULT '0',
  `weight` int(11) DEFAULT NULL,
  PRIMARY KEY (`paitent`,`assigned_goal`,`week`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- إرجاع أو استيراد بيانات الجدول `paitent_goals_history`
--

INSERT INTO `paitent_goals_history` (`paitent`, `assigned_goal`, `week`, `day1`, `day2`, `day3`, `day4`, `day5`, `day6`, `day7`, `weight`) VALUES
('test', 1, 1, 3, 1, 2, 2, 1, 4, 1, NULL),
('test', 2, 1, 5, 5, 3, 0, 5, 5, 5, NULL),
('test', 3, 1, 0, 0, 0, 0, 0, 0, 0, NULL);

-- --------------------------------------------------------

--
-- بنية الجدول `paitent_medical_history`
--

CREATE TABLE IF NOT EXISTS `paitent_medical_history` (
  `history_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `description` text NOT NULL,
  PRIMARY KEY (`history_id`),
  KEY `username` (`username`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- إرجاع أو استيراد بيانات الجدول `paitent_medical_history`
--

