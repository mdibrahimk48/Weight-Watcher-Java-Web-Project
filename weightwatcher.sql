-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 06, 2018 at 09:14 PM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `weightwatcher`
--

-- --------------------------------------------------------

--
-- Table structure for table `activity`
--

CREATE TABLE `activity` (
  `activityId` int(11) NOT NULL,
  `activityName` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `activity`
--

INSERT INTO `activity` (`activityId`, `activityName`) VALUES
(2, 'active'),
(3, 'moderate'),
(4, 'inactive');

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

CREATE TABLE `course` (
  `course_id` int(10) NOT NULL,
  `userId` int(11) NOT NULL,
  `startDate` date NOT NULL,
  `endDate` date NOT NULL,
  `BMI` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `course`
--

INSERT INTO `course` (`course_id`, `userId`, `startDate`, `endDate`, `BMI`) VALUES
(6, 17, '2018-01-17', '2018-02-14', 6.612244897959187),
(7, 18, '2018-01-18', '2018-02-16', 19.531249999999996);

-- --------------------------------------------------------

--
-- Table structure for table `dailyexercise`
--

CREATE TABLE `dailyexercise` (
  `dailyExerciseId` int(11) NOT NULL,
  `logId` int(11) NOT NULL,
  `exerciseId` int(11) NOT NULL,
  `time` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dailyexercise`
--

INSERT INTO `dailyexercise` (`dailyExerciseId`, `logId`, `exerciseId`, `time`) VALUES
(3, 7, 1, '10'),
(4, 8, 2, '20'),
(5, 7, 1, '5');

-- --------------------------------------------------------

--
-- Table structure for table `dailylog`
--

CREATE TABLE `dailylog` (
  `logId` int(11) NOT NULL,
  `courseId` int(11) NOT NULL,
  `activityId` int(11) NOT NULL,
  `date` date NOT NULL,
  `progress` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dailylog`
--

INSERT INTO `dailylog` (`logId`, `courseId`, `activityId`, `date`, `progress`) VALUES
(7, 6, 2, '2018-01-17', ''),
(8, 7, 3, '2018-01-18', '');

-- --------------------------------------------------------

--
-- Table structure for table `dailymeal`
--

CREATE TABLE `dailymeal` (
  `dailyMealId` int(11) NOT NULL,
  `logId` int(11) NOT NULL,
  `mealId` int(11) NOT NULL,
  `mealIntake` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dailymeal`
--

INSERT INTO `dailymeal` (`dailyMealId`, `logId`, `mealId`, `mealIntake`) VALUES
(2, 7, 2, 1.6),
(3, 8, 3, 100),
(4, 7, 2, 20),
(5, 7, 2, 30),
(6, 7, 2, 20);

-- --------------------------------------------------------

--
-- Table structure for table `deilymeasurement`
--

CREATE TABLE `deilymeasurement` (
  `dailyMeasurementId` int(11) NOT NULL,
  `logId` int(11) NOT NULL,
  `waistSize` double NOT NULL,
  `weight` double NOT NULL,
  `shift` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `deilymeasurement`
--

INSERT INTO `deilymeasurement` (`dailyMeasurementId`, `logId`, `waistSize`, `weight`, `shift`) VALUES
(1, 7, 32.1, 65, 'Morning'),
(2, 8, 31, 50, 'Evining');

-- --------------------------------------------------------

--
-- Table structure for table `excercise`
--

CREATE TABLE `excercise` (
  `excerciseId` int(11) NOT NULL,
  `excerciseName` varchar(30) DEFAULT NULL,
  `type` varchar(15) DEFAULT NULL,
  `time` int(11) DEFAULT NULL,
  `burnCalorie` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `excercise`
--

INSERT INTO `excercise` (`excerciseId`, `excerciseName`, `type`, `time`, `burnCalorie`) VALUES
(1, 'pushup', 'chest', 1, 20),
(2, 'leg', 'muscle', 10, 100);

-- --------------------------------------------------------

--
-- Table structure for table `meal`
--

CREATE TABLE `meal` (
  `mealId` int(11) NOT NULL,
  `mealName` varchar(25) DEFAULT NULL,
  `mealUnit` int(11) DEFAULT NULL,
  `mealCalorie` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `meal`
--

INSERT INTO `meal` (`mealId`, `mealName`, `mealUnit`, `mealCalorie`) VALUES
(2, 'Dim', 100, 50),
(3, 'milk', 100, 60);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `userId` int(11) NOT NULL,
  `userName` varchar(20) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `weight` double DEFAULT NULL,
  `height` double DEFAULT NULL,
  `waistSize` double NOT NULL,
  `bmi` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`userId`, `userName`, `age`, `gender`, `weight`, `height`, `waistSize`, `bmi`) VALUES
(17, 'Ibrahim', 22, 'Male', 60, 1.4, 34, 30.612244897959187),
(18, 'Jihad', 26, 'Male', 50, 1.6, 30, 19.531249999999996),
(19, 'Kawsar', 24, 'Male', 95, 1.6, 40, 37.10937499999999);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `activity`
--
ALTER TABLE `activity`
  ADD PRIMARY KEY (`activityId`);

--
-- Indexes for table `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`course_id`),
  ADD KEY `ww1` (`userId`);

--
-- Indexes for table `dailyexercise`
--
ALTER TABLE `dailyexercise`
  ADD PRIMARY KEY (`dailyExerciseId`),
  ADD KEY `ww6` (`logId`),
  ADD KEY `ww7` (`exerciseId`);

--
-- Indexes for table `dailylog`
--
ALTER TABLE `dailylog`
  ADD PRIMARY KEY (`logId`),
  ADD KEY `ww2` (`courseId`),
  ADD KEY `ww3` (`activityId`);

--
-- Indexes for table `dailymeal`
--
ALTER TABLE `dailymeal`
  ADD PRIMARY KEY (`dailyMealId`),
  ADD KEY `ww4` (`logId`),
  ADD KEY `ww5` (`mealId`);

--
-- Indexes for table `deilymeasurement`
--
ALTER TABLE `deilymeasurement`
  ADD PRIMARY KEY (`dailyMeasurementId`),
  ADD KEY `ww8` (`logId`);

--
-- Indexes for table `excercise`
--
ALTER TABLE `excercise`
  ADD PRIMARY KEY (`excerciseId`);

--
-- Indexes for table `meal`
--
ALTER TABLE `meal`
  ADD PRIMARY KEY (`mealId`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`userId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `activity`
--
ALTER TABLE `activity`
  MODIFY `activityId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `course`
--
ALTER TABLE `course`
  MODIFY `course_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `dailyexercise`
--
ALTER TABLE `dailyexercise`
  MODIFY `dailyExerciseId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `dailylog`
--
ALTER TABLE `dailylog`
  MODIFY `logId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `dailymeal`
--
ALTER TABLE `dailymeal`
  MODIFY `dailyMealId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `deilymeasurement`
--
ALTER TABLE `deilymeasurement`
  MODIFY `dailyMeasurementId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `excercise`
--
ALTER TABLE `excercise`
  MODIFY `excerciseId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `meal`
--
ALTER TABLE `meal`
  MODIFY `mealId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `userId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `course`
--
ALTER TABLE `course`
  ADD CONSTRAINT `ww1` FOREIGN KEY (`userId`) REFERENCES `users` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `dailyexercise`
--
ALTER TABLE `dailyexercise`
  ADD CONSTRAINT `ww6` FOREIGN KEY (`logId`) REFERENCES `dailylog` (`logId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ww7` FOREIGN KEY (`exerciseId`) REFERENCES `excercise` (`excerciseId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `dailylog`
--
ALTER TABLE `dailylog`
  ADD CONSTRAINT `ww2` FOREIGN KEY (`courseId`) REFERENCES `course` (`course_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ww3` FOREIGN KEY (`activityId`) REFERENCES `activity` (`activityId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `dailymeal`
--
ALTER TABLE `dailymeal`
  ADD CONSTRAINT `ww4` FOREIGN KEY (`logId`) REFERENCES `dailylog` (`logId`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ww5` FOREIGN KEY (`mealId`) REFERENCES `meal` (`mealId`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `deilymeasurement`
--
ALTER TABLE `deilymeasurement`
  ADD CONSTRAINT `ww8` FOREIGN KEY (`logId`) REFERENCES `dailylog` (`logId`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
