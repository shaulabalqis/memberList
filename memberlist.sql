-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 01, 2017 at 06:51 PM
-- Server version: 10.1.22-MariaDB
-- PHP Version: 7.1.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `memberlist`
--

-- --------------------------------------------------------

--
-- Table structure for table `datamember`
--

CREATE TABLE `datamember` (
  `nama` text NOT NULL,
  `idUser` text NOT NULL,
  `alamat` text NOT NULL,
  `tanggal lahir` date NOT NULL,
  `nomor telepon` bigint(11) NOT NULL,
  `email` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `datamember`
--

INSERT INTO `datamember` (`nama`, `idUser`, `alamat`, `tanggal lahir`, `nomor telepon`, `email`) VALUES
('Kiki', 'Shaula Balqis Zuhriyah', 'Temanggung', '1993-08-09', 89639590237, 'shaula.balqis@outlook.com');

-- --------------------------------------------------------

--
-- Table structure for table `datauser`
--

CREATE TABLE `datauser` (
  `nama` text NOT NULL,
  `password` text NOT NULL,
  `alamat` text NOT NULL,
  `tanggal lahir` date NOT NULL,
  `nomor telepon` bigint(11) NOT NULL,
  `email` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `datauser`
--

INSERT INTO `datauser` (`nama`, `password`, `alamat`, `tanggal lahir`, `nomor telepon`, `email`) VALUES
('Shaula Balqis Zuhriyah', '1111', 'DIY', '1993-08-09', 89639590237, 'shaula.balqis@outlook.com');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
