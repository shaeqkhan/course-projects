-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- المزود: localhost
-- أنشئ في: 03 يناير 2012 الساعة 13:48
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
-- بنية الجدول `account_details`
--

CREATE TABLE IF NOT EXISTS `account_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(50) NOT NULL,
  `username` varchar(10) NOT NULL,
  `password` varchar(50) NOT NULL,
  `aramco_id` varchar(11) DEFAULT NULL,
  `first_name` varchar(20) NOT NULL,
  `last_name` varchar(20) NOT NULL,
  `gender` varchar(1) NOT NULL,
  `mobile_number` varchar(15) DEFAULT NULL,
  `date_of_birth` date NOT NULL,
  `type_flag` tinyint(4) NOT NULL,
  `start_date` date NOT NULL,
  `active_flag` tinyint(4) NOT NULL,
  `assigned_group` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `username` (`username`),
  KEY `assigned_group` (`assigned_group`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- إرجاع أو استيراد بيانات الجدول `account_details`
--

INSERT INTO `account_details` (`id`, `email`, `username`, `password`, `aramco_id`, `first_name`, `last_name`, `gender`, `mobile_number`, `date_of_birth`, `type_flag`, `start_date`, `active_flag`, `assigned_group`) VALUES
(1, 'essam@aramco.com', 'ejalal', 'f69635d6f4cd841d358800dbe0e64bc4', '100000', 'Essam', 'Jalal', 'm', '+966506458951', '1967-12-01', 0, '2011-01-01', 1, NULL),
(2, 'yasir@aramco.com', 'yasir', '8d03ecfad755ab078ae3fd29c63c2d7d', '100001', 'Yasir', 'Al-Agl', 'm', '+966506458852', '1974-06-03', 2, '2011-02-01', 1, 1),
(3, 'allan@aramco.com', 'allan', 'b993e4526238d62f6b1b90e605532ff8', '100002', 'Allan', 'Thompson', 'm', '+966521234681', '1982-08-03', 2, '2011-02-16', 1, 1),
(4, 'healthteam@aramco.com', 'healthteam', 'a08babfe9289402af3e61235c2197542', NULL, 'Healthteam', 'Member', '', NULL, '1964-01-21', 1, '2011-01-01', 1, NULL),
(5, 'haya@gmail.com', 'Hayo121', '5002739a13bb85a16a167ffc0dac6f19', '1001910', 'Haya', 'Abdallah', 'f', '05554333454', '1990-02-14', 2, '2012-01-03', 1, NULL),
(6, 'obad@gmail.com', 'obad321', '99f4bfa6980607c7a75f451979dfacf2', '100020202', 'Abdallah', 'Khaled', 'm', '055655039', '1986-05-09', 2, '2012-01-03', 1, NULL),
(7, 'a.11@gmail.com', 'kitkat', 'f0bf97d2f85c040963f47c03888434c4', '10909038', 'Ahmad', 'Khaled', 'm', '0566677667', '1989-11-20', 2, '2012-01-03', 1, NULL),
(8, 'keamkaze@gmail.com', 'keamkaze', '2dd5c5ff6eddcc12cec72e70b451aa13', '98539', 'Mohammed', 'Ibrahem', 'm', '0555040470', '1989-08-08', 2, '2012-01-03', 1, NULL),
(9, 'fares78@gmail.com', 'fares78', 'a2c1f9f6f62fffca740a03781b1d6fc8', '49283428', 'Fares', 'Firas', 'm', '056893794', '1978-09-11', 2, '2012-01-03', 1, NULL);

-- --------------------------------------------------------

--
-- بنية الجدول `category`
--

CREATE TABLE IF NOT EXISTS `category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(30) NOT NULL,
  `category_description` varchar(500) NOT NULL,
  `deleted_flag` varchar(1) NOT NULL,
  PRIMARY KEY (`category_id`),
  KEY `category_name` (`category_name`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- إرجاع أو استيراد بيانات الجدول `category`
--

INSERT INTO `category` (`category_id`, `category_name`, `category_description`, `deleted_flag`) VALUES
(1, 'physical', 'Goals that are associated with having physical activities', '0'),
(2, 'dietary', 'Goals that are associated with the patient''s diet', '0');

-- --------------------------------------------------------

--
-- بنية الجدول `goal`
--

CREATE TABLE IF NOT EXISTS `goal` (
  `goal_id` int(11) NOT NULL AUTO_INCREMENT,
  `goal_name` varchar(30) NOT NULL,
  `goal_description` text NOT NULL,
  `goal_type` tinyint(4) NOT NULL,
  `goal_category_id` int(11) DEFAULT NULL,
  `min_point_on_scale` int(11) NOT NULL,
  `max_point_on_scale` int(11) NOT NULL,
  `deleted_flag` varchar(1) NOT NULL,
  PRIMARY KEY (`goal_id`),
  UNIQUE KEY `goal_name` (`goal_name`),
  KEY `goal_category_id` (`goal_category_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- إرجاع أو استيراد بيانات الجدول `goal`
--

INSERT INTO `goal` (`goal_id`, `goal_name`, `goal_description`, `goal_type`, `goal_category_id`, `min_point_on_scale`, `max_point_on_scale`, `deleted_flag`) VALUES
(1, 'walking', 'walking in multiples of 10 mins', 0, 1, 0, 10, '0'),
(2, 'sitting', 'sitting down in multiples of 10 mins', 1, 1, 0, 100, '0'),
(3, 'water', 'Drinking number of glasses of water ', 0, 2, 0, 10, '0'),
(4, 'sugar', 'Any meal/snack containing simple sugars', 1, 2, 0, 10, '0'),
(5, 'sleep', 'Number of hours of night sleep', 0, NULL, 0, 8, '0'),
(6, 'fruits/vegetables', 'Number of meals/snacks containing', 0, 2, 0, 10, '0'),
(7, 'multiple meals', 'Number of meals/snacks per day', 0, 2, 0, 5, '0'),
(8, 'healthy cooking', 'Number of meals/snacks', 0, 2, 0, 5, '0'),
(9, 'portion control', 'Number of meals/snacks', 0, 2, 0, 5, '0');

-- --------------------------------------------------------

--
-- بنية الجدول `group_goals`
--

CREATE TABLE IF NOT EXISTS `group_goals` (
  `group_assign_id` int(11) NOT NULL AUTO_INCREMENT,
  `group_id` int(11) NOT NULL,
  `goal_id` int(11) NOT NULL,
  `date_assigned` date NOT NULL,
  `frequency` int(11) NOT NULL,
  `stated_daily_max` int(11) NOT NULL,
  `time_stamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `current_flag` tinytext NOT NULL,
  PRIMARY KEY (`group_assign_id`),
  UNIQUE KEY `group_assign_id` (`group_assign_id`),
  KEY `group_id` (`group_id`),
  KEY `goal_id` (`goal_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- إرجاع أو استيراد بيانات الجدول `group_goals`
--

INSERT INTO `group_goals` (`group_assign_id`, `group_id`, `goal_id`, `date_assigned`, `frequency`, `stated_daily_max`, `time_stamp`, `current_flag`) VALUES
(1, 1, 1, '2011-12-07', 3, 5, '2011-12-25 15:53:32', '1');

-- --------------------------------------------------------

--
-- بنية الجدول `patient_bmi_history`
--

CREATE TABLE IF NOT EXISTS `patient_bmi_history` (
  `bmi_id` int(11) NOT NULL AUTO_INCREMENT,
  `patient_id` int(11) NOT NULL,
  `weight` float NOT NULL,
  `height` float NOT NULL,
  `bmi_time_stamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`bmi_id`),
  KEY `patient_id` (`patient_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- إرجاع أو استيراد بيانات الجدول `patient_bmi_history`
--

INSERT INTO `patient_bmi_history` (`bmi_id`, `patient_id`, `weight`, `height`, `bmi_time_stamp`) VALUES
(1, 2, 122.5, 1.72, '2011-02-28 12:26:48'),
(2, 2, 110, 1.72, '2011-09-13 19:27:16'),
(3, 2, 105, 1.72, '2011-12-01 07:28:02'),
(4, 3, 95, 1.68, '2011-02-01 13:26:19'),
(5, 3, 93, 1.68, '2011-09-01 13:26:47'),
(6, 2, 104, 1.72, '2011-12-20 06:44:27'),
(7, 2, 101, 1.72, '2012-01-02 06:44:57'),
(8, 5, 120, 1.6, '2012-01-03 16:19:23'),
(9, 6, 110, 1.8, '2012-01-03 16:21:58'),
(10, 7, 170, 1.8, '2012-01-03 16:23:26'),
(11, 8, 160, 1.76, '2012-01-03 16:24:23'),
(12, 9, 129, 1.65, '2012-01-03 16:26:05');

-- --------------------------------------------------------

--
-- بنية الجدول `patient_daily_record`
--

CREATE TABLE IF NOT EXISTS `patient_daily_record` (
  `assign_id` int(11) NOT NULL,
  `date` date NOT NULL,
  `score` int(2) NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  KEY `assign_id` (`assign_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- إرجاع أو استيراد بيانات الجدول `patient_daily_record`
--

INSERT INTO `patient_daily_record` (`assign_id`, `date`, `score`, `timestamp`) VALUES
(1, '2011-11-29', 2, '2011-11-29 06:55:57'),
(2, '2011-11-30', 10, '2011-11-30 06:56:35'),
(2, '2011-12-01', 9, '2011-12-01 06:57:49'),
(1, '2011-12-01', 3, '2011-12-01 06:58:24'),
(2, '2011-12-02', 10, '2011-12-02 06:59:09'),
(1, '2011-12-03', 2, '2011-12-03 06:59:48'),
(2, '2011-12-06', 8, '2011-12-06 07:00:43'),
(1, '2011-12-07', 3, '2011-12-07 07:01:06'),
(1, '2011-12-08', 9, '2011-12-08 07:01:42'),
(2, '2011-12-08', 3, '2011-12-08 07:02:19'),
(1, '2011-12-10', 3, '2011-12-10 07:05:38'),
(1, '2011-12-11', 2, '2011-12-11 07:06:01'),
(2, '2011-12-10', 9, '2011-12-10 07:06:21'),
(2, '2011-12-11', 10, '2011-12-11 07:06:58'),
(1, '2011-12-14', 3, '2011-12-14 07:07:21'),
(2, '2011-12-14', 7, '2011-12-14 07:07:43'),
(1, '2011-12-15', 1, '2011-12-15 07:08:21'),
(2, '2011-12-15', 5, '2011-12-15 07:08:40'),
(3, '2011-12-15', 10, '2011-12-15 07:09:17'),
(3, '2011-12-16', 10, '2011-12-16 07:09:25'),
(1, '2011-12-17', 3, '2011-12-17 07:11:21'),
(2, '2011-12-17', 10, '2011-12-17 07:11:21'),
(3, '2011-12-17', 10, '2011-12-17 07:11:21'),
(1, '2011-12-19', 2, '2011-12-19 07:12:15'),
(2, '2011-12-19', 9, '2011-12-19 07:12:15'),
(3, '2011-12-19', 10, '2011-12-19 07:12:15'),
(1, '2011-12-22', 1, '2011-12-22 07:12:52'),
(2, '2011-12-22', 10, '2011-12-22 07:12:52'),
(3, '2011-12-22', 9, '2011-12-22 07:12:52'),
(1, '2011-12-23', 3, '2011-12-23 07:13:55'),
(2, '2011-12-23', 8, '2011-12-23 07:13:55'),
(3, '2011-12-23', 8, '2011-12-23 07:13:55'),
(1, '2011-12-26', 3, '2011-12-26 07:14:29'),
(2, '2011-12-26', 10, '2011-12-26 07:14:29'),
(3, '2011-12-26', 7, '2011-12-26 07:14:29'),
(1, '2011-12-27', 2, '2011-12-27 07:15:03'),
(2, '2011-12-27', 8, '2011-12-27 07:15:03'),
(3, '2011-12-27', 7, '2011-12-27 07:15:03'),
(1, '2011-12-29', 3, '2011-12-29 07:15:55'),
(3, '2011-12-29', 8, '2011-12-29 07:15:55'),
(1, '2011-12-30', 3, '2012-01-03 07:20:43'),
(2, '2011-12-30', 10, '2012-01-03 07:20:43'),
(3, '2011-12-30', 10, '2012-01-03 07:20:43'),
(1, '2011-12-31', 3, '2011-12-31 07:19:25'),
(2, '2011-12-31', 9, '2011-12-31 07:19:25'),
(3, '2011-12-31', 9, '2011-12-31 07:19:25'),
(1, '2012-01-01', 2, '2012-01-01 07:20:33'),
(2, '2012-01-01', 8, '2012-01-01 07:20:30'),
(3, '2012-01-01', 9, '2012-01-01 07:20:27'),
(3, '2012-01-02', 10, '2012-01-02 07:20:24'),
(5, '2011-12-08', 1, '2012-01-03 15:59:25'),
(1, '2012-01-02', 1, '2012-01-03 16:02:44');

-- --------------------------------------------------------

--
-- بنية الجدول `patient_goals`
--

CREATE TABLE IF NOT EXISTS `patient_goals` (
  `assign_id` int(11) NOT NULL AUTO_INCREMENT,
  `goal_id` int(11) NOT NULL,
  `patient_id` int(11) NOT NULL,
  `date_assigned` date NOT NULL,
  `frequency` int(11) NOT NULL DEFAULT '0',
  `stated_daily_max` int(11) NOT NULL DEFAULT '0',
  `time_stamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `current_flag` varchar(1) NOT NULL,
  PRIMARY KEY (`assign_id`),
  KEY `patient_id` (`patient_id`),
  KEY `goal_id` (`goal_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=18 ;

--
-- إرجاع أو استيراد بيانات الجدول `patient_goals`
--

INSERT INTO `patient_goals` (`assign_id`, `goal_id`, `patient_id`, `date_assigned`, `frequency`, `stated_daily_max`, `time_stamp`, `current_flag`) VALUES
(1, 1, 2, '2011-11-28', 5, 3, '2011-11-28 14:33:18', '1'),
(2, 3, 2, '2011-11-30', 7, 10, '2011-11-30 00:00:00', '1'),
(3, 4, 2, '2011-12-15', 7, 10, '2011-12-15 08:35:40', '1'),
(4, 3, 3, '2011-03-02', 7, 6, '2011-03-02 13:30:34', '1'),
(5, 5, 3, '2011-03-05', 7, 8, '2011-03-05 13:30:55', '1'),
(6, 7, 3, '2011-03-04', 7, 5, '2011-03-04 13:31:08', '1'),
(7, 1, 5, '2012-01-03', 3, 3, '2012-01-03 16:20:25', '1'),
(8, 3, 5, '2012-01-03', 10, 6, '2012-01-03 16:20:25', '1'),
(9, 4, 5, '2012-01-03', 7, 3, '2012-01-03 16:20:25', '1'),
(10, 5, 6, '2012-01-03', 4, 4, '2012-01-03 16:22:15', '1'),
(11, 6, 6, '2012-01-03', 5, 2, '2012-01-03 16:22:15', '1'),
(12, 1, 7, '2012-01-03', 7, 7, '2012-01-03 16:23:39', '1'),
(13, 7, 7, '2012-01-03', 7, 7, '2012-01-03 16:23:39', '1'),
(14, 5, 8, '2012-01-03', 1, 1, '2012-01-03 16:24:40', '1'),
(15, 6, 8, '2012-01-03', 7, 4, '2012-01-03 16:24:40', '1'),
(16, 5, 9, '2012-01-03', 6, 10, '2012-01-03 16:26:22', '1'),
(17, 6, 9, '2012-01-03', 7, 6, '2012-01-03 16:26:22', '1');

-- --------------------------------------------------------

--
-- بنية الجدول `patient_group`
--

CREATE TABLE IF NOT EXISTS `patient_group` (
  `group_id` int(11) NOT NULL AUTO_INCREMENT,
  `group_name` varchar(30) NOT NULL,
  `group_description` text NOT NULL,
  `active_flag` tinyint(4) NOT NULL,
  `group_time_stamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`group_id`),
  UNIQUE KEY `group_name` (`group_name`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- إرجاع أو استيراد بيانات الجدول `patient_group`
--

INSERT INTO `patient_group` (`group_id`, `group_name`, `group_description`, `active_flag`, `group_time_stamp`) VALUES
(1, 'Feb 2011', 'Group of patients that joined the clinic on February 2011. ', 1, '2011-02-01 09:05:09'),
(2, 'Sept 2011', 'Group of patients that joined the clinic in Sept 2011', 1, '2011-09-03 10:09:36');

-- --------------------------------------------------------

--
-- بنية الجدول `patient_medical_history`
--

CREATE TABLE IF NOT EXISTS `patient_medical_history` (
  `history_id` int(11) NOT NULL AUTO_INCREMENT,
  `patient_id` int(11) NOT NULL,
  `description` text NOT NULL,
  PRIMARY KEY (`history_id`),
  KEY `patient_id` (`patient_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- إرجاع أو استيراد بيانات الجدول `patient_medical_history`
--

INSERT INTO `patient_medical_history` (`history_id`, `patient_id`, `description`) VALUES
(1, 2, 'Asthma\r\nMigraine'),
(2, 3, 'None');

--
-- قيود الجداول المحفوظة
--

--
-- القيود للجدول `account_details`
--
ALTER TABLE `account_details`
  ADD CONSTRAINT `account_details_ibfk_1` FOREIGN KEY (`assigned_group`) REFERENCES `patient_group` (`group_id`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- القيود للجدول `goal`
--
ALTER TABLE `goal`
  ADD CONSTRAINT `goal_ibfk_1` FOREIGN KEY (`goal_category_id`) REFERENCES `category` (`category_id`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- القيود للجدول `group_goals`
--
ALTER TABLE `group_goals`
  ADD CONSTRAINT `group_goals_ibfk_5` FOREIGN KEY (`group_id`) REFERENCES `patient_group` (`group_id`),
  ADD CONSTRAINT `group_goals_ibfk_6` FOREIGN KEY (`goal_id`) REFERENCES `goal` (`goal_id`);

--
-- القيود للجدول `patient_bmi_history`
--
ALTER TABLE `patient_bmi_history`
  ADD CONSTRAINT `patient_bmi_history_ibfk_1` FOREIGN KEY (`patient_id`) REFERENCES `account_details` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- القيود للجدول `patient_daily_record`
--
ALTER TABLE `patient_daily_record`
  ADD CONSTRAINT `patient_daily_record_ibfk_1` FOREIGN KEY (`assign_id`) REFERENCES `patient_goals` (`assign_id`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- القيود للجدول `patient_goals`
--
ALTER TABLE `patient_goals`
  ADD CONSTRAINT `patient_goals_ibfk_1` FOREIGN KEY (`goal_id`) REFERENCES `goal` (`goal_id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `patient_goals_ibfk_2` FOREIGN KEY (`patient_id`) REFERENCES `account_details` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- القيود للجدول `patient_medical_history`
--
ALTER TABLE `patient_medical_history`
  ADD CONSTRAINT `patient_medical_history_ibfk_1` FOREIGN KEY (`patient_id`) REFERENCES `account_details` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE;
