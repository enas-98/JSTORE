-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 02, 2020 at 04:00 PM
-- Server version: 10.3.16-MariaDB
-- PHP Version: 7.3.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db`
--

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `id` int(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `price` int(255) NOT NULL,
  `details` varchar(255) NOT NULL,
  `quantity` int(255) NOT NULL,
  `url` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`id`, `name`, `price`, `details`, `quantity`, `url`, `type`) VALUES
(1, 'GUCCI BLOOM', 92, 'This fragrance was created by the house of gucci with perfumer alberto morillas and released in 2017. It is a floral perfume with a smooth silky personality. With a powdery side this scent allows you to indulge yourself in the creamy flowers in the blend.', 2, 'https://media.gucci.com/style/DarkGray_South_0_160_316x316/1560964508/565806_XJBTX_1007_001_100_0000_Light-Online-Exclusive-Gucci-Manifesto-T-shirt.jpg', 'PARFUM , AU DE PARFUM , GUCCI , pink'),
(5, 'GUCCI BLOOM', 92, 'This fragrance was created by the house of gucci with perfumer alberto morillas and released in 2017. It is a floral perfume with a smooth silky personality. With a powdery side this scent allows you to indulge yourself in the creamy flowers in the blend.', 2, 'https://media.gucci.com/style/DarkGray_South_0_160_316x316/1560964508/565806_XJBTX_1007_001_100_0000_Light-Online-Exclusive-Gucci-Manifesto-T-shirt.jpg', 'PARFUM , AU DE PARFUM , GUCCI , pink'),
(6, 'GUCCI BLOOM', 92, 'This fragrance was created by the house of gucci with perfumer alberto morillas and released in 2017. It is a floral perfume with a smooth silky personality. With a powdery side this scent allows you to indulge yourself in the creamy flowers in the blend.', 2, 'https://media.gucci.com/style/DarkGray_South_0_160_316x316/1560964508/565806_XJBTX_1007_001_100_0000_Light-Online-Exclusive-Gucci-Manifesto-T-shirt.jpg', 'PARFUM , AU DE PARFUM , GUCCI , pink'),
(7, 'GUCCI BLOOM', 92, 'This fragrance was created by the house of gucci with perfumer alberto morillas and released in 2017. It is a floral perfume with a smooth silky personality. With a powdery side this scent allows you to indulge yourself in the creamy flowers in the blend.', 2, 'https://media.gucci.com/style/DarkGray_South_0_160_316x316/1560964508/565806_XJBTX_1007_001_100_0000_Light-Online-Exclusive-Gucci-Manifesto-T-shirt.jpg', 'PARFUM , AU DE PARFUM , GUCCI , pink'),
(8, 'GUCCI BLOOM', 92, 'This fragrance was created by the house of gucci with perfumer alberto morillas and released in 2017. It is a floral perfume with a smooth silky personality. With a powdery side this scent allows you to indulge yourself in the creamy flowers in the blend.', 2, 'https://media.gucci.com/style/DarkGray_South_0_160_316x316/1560964508/565806_XJBTX_1007_001_100_0000_Light-Online-Exclusive-Gucci-Manifesto-T-shirt.jpg', 'PARFUM , AU DE PARFUM , GUCCI , pink');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `ID` int(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `Age` int(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `Gender` varchar(255) NOT NULL,
  `Flag` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`ID`, `username`, `password`, `Age`, `email`, `Gender`, `Flag`) VALUES
(2, 'cpp', 'password', 30, 'cs@csharp', 'male', 1),
(46, 'ruby', 'ruby', 40, 'ruby@RUBY', 'female', 1),
(52, 'java', '123', 20, 'java@java', 'male', 1),
(53, 'csharp', '123', 32, 'c@cs', 'female', 1);

-- --------------------------------------------------------

--
-- Table structure for table `wishlist`
--

CREATE TABLE `wishlist` (
  `id` int(255) NOT NULL,
  `u_id` int(255) NOT NULL,
  `p_id` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `wishlist`
--

INSERT INTO `wishlist` (`id`, `u_id`, `p_id`) VALUES
(1, 0, 1),
(2, 0, 8),
(3, 0, 6),
(4, 46, 6),
(5, 46, 1),
(6, 0, 7),
(7, 0, 8),
(8, 53, 5);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `wishlist`
--
ALTER TABLE `wishlist`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `ID` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=54;

--
-- AUTO_INCREMENT for table `wishlist`
--
ALTER TABLE `wishlist`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
