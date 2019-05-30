-- phpMyAdmin SQL Dump
-- version 4.6.6
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Sep 16, 2017 at 02:23 PM
-- Server version: 10.1.20-MariaDB
-- PHP Version: 7.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `food_ordering`
--

-- --------------------------------------------------------

--
-- Table structure for table `food`
--

CREATE TABLE `food` (
  `id` int(5) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `stok` int(9) NOT NULL,
  `harga` int(9) NOT NULL,
  `gambar` varchar(500) NOT NULL,
  `deskripsi` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `food`
--

INSERT INTO `food` (`id`, `nama`, `stok`, `harga`, `gambar`, `deskripsi`) VALUES
(1, 'Sate', 500, 1000, 'http://foodorderingsiliwangi.000webhostapp.com/fo/gambar/Sate.jpg', 'sate tusuk satu tusuk hanya seribu, tapi jangan beli 1 tusuk dong, minimal 5 oke'),
(2, 'Sate Lontong', 298, 7000, 'http://foodorderingsiliwangi.000webhostapp.com/fo/gambar/Sate Lontong.jpg', 'sate lontong murah meriah hanya 7 ribu langsung kenyang'),
(33, 'Sate Nasi', 356, 7000, 'http://foodorderingsiliwangi.000webhostapp.com/fo/gambar/Sate Nasi.jpg', 'Sate nasi murah tapi meriah yang penting halal kenyang murah pula. pasti ketagihan!!..'),
(34, 'Ayam Bakar', 150, 9000, 'http://foodorderingsiliwangi.000webhostapp.com/fo/gambar/Ayam Bakar.jpg', 'ayam bakar, hasil bakaran yang pas dengan suhu yang pas dapat membuat rasa ayam bakar menjadi lebih nikmat seperti ayam bakar ini.'),
(35, 'Nasi Goreng', 123, 10000, 'http://foodorderingsiliwangi.000webhostapp.com/fo/gambar/Nasi Goreng.jpg', 'asli nasi nya di goreng... maka rasanya akan terasa nikmat');

-- --------------------------------------------------------

--
-- Table structure for table `image`
--

CREATE TABLE `image` (
  `id` int(11) NOT NULL,
  `name` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `image`
--

INSERT INTO `image` (`id`, `name`) VALUES
(7, 'Ayam Bakar'),
(8, 'Nasi Goreng'),
(9, 'Sate Nasi'),
(10, '');

-- --------------------------------------------------------

--
-- Table structure for table `pesan`
--

CREATE TABLE `pesan` (
  `id` int(10) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `tlp` varchar(15) NOT NULL,
  `alamat` varchar(500) NOT NULL,
  `food` varchar(100) NOT NULL,
  `waktu` datetime NOT NULL,
  `status` varchar(500) NOT NULL DEFAULT 'Menunggu diproses'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pesan`
--

INSERT INTO `pesan` (`id`, `nama`, `tlp`, `alamat`, `food`, `waktu`, `status`) VALUES
(3, 'Nanda Hardianysah', '08973762356', 'Ibnu Sina, depan universitas siliwangi', 'sate lonton 5', '2017-05-29 12:21:00', 'Sedang diproses'),
(6, 'Astria Sastra Dewi', '08962373542', 'Depan sawah, yang kosannya tingkat, no 1 kamarnya, gang yang di depan pom bensin jln siliwangi', 'Sate 9 Sate Nasi 10', '2017-05-31 22:00:04', 'Sedang diproses'),
(22, 'Ervan Julianus', '08963248764', 'Padayungan gang cemara samping pegadaian jln perintis kemerdekaan', 'Sate Nasi 1, Sate Lontong 2', '2017-06-02 15:07:40', 'Alamat kurang lengkap'),
(26, 'saya', '089654645', 'Banjar', 'Sate 5', '2017-06-12 12:56:51', 'Sedang diproses');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `food`
--
ALTER TABLE `food`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nama` (`nama`);

--
-- Indexes for table `image`
--
ALTER TABLE `image`
  ADD UNIQUE KEY `id` (`id`);

--
-- Indexes for table `pesan`
--
ALTER TABLE `pesan`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`),
  ADD UNIQUE KEY `alamat` (`alamat`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `food`
--
ALTER TABLE `food`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;
--
-- AUTO_INCREMENT for table `image`
--
ALTER TABLE `image`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `pesan`
--
ALTER TABLE `pesan`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
