-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Sep 13, 2024 at 10:30 PM
-- Server version: 8.3.0
-- PHP Version: 8.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sistema_viajes`
--

-- --------------------------------------------------------

--
-- Table structure for table `colaboradores`
--

DROP TABLE IF EXISTS `colaboradores`;
CREATE TABLE IF NOT EXISTS `colaboradores` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `apellido` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `nombre` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Dumping data for table `colaboradores`
--

INSERT INTO `colaboradores` (`id`, `apellido`, `nombre`) VALUES
(1, 'Carbajal', 'Elvin'),
(2, 'Perez', 'Daniel'),
(3, 'Marquez', 'Karla'),
(4, 'Pavon', 'Cristina'),
(5, 'Solano', 'Cinthia'),
(6, 'Sosa', 'Derick'),
(7, 'Hernandez', 'Selvin');

-- --------------------------------------------------------

--
-- Table structure for table `sucursales`
--

DROP TABLE IF EXISTS `sucursales`;
CREATE TABLE IF NOT EXISTS `sucursales` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `direccion` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `nombre` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Dumping data for table `sucursales`
--

INSERT INTO `sucursales` (`id`, `direccion`, `nombre`) VALUES
(1, 'Col. Aurora 4 calle', 'Farmacia Simán La Aurora'),
(2, 'Avenidad Circunvalación', 'Farmacia Simán Circunvalacion'),
(3, 'Blvr. Unah Mall Galerías', 'Farmacia Simán Mall Galerias'),
(4, 'Blvr. del Norte 105 abrigada', 'Famasia Simán 105'),
(5, 'Barrio Las Flores, Av juan pablo II', 'Farmacia Simán Bo. Las Flores');

-- --------------------------------------------------------

--
-- Table structure for table `sucursal_colaboradores`
--

DROP TABLE IF EXISTS `sucursal_colaboradores`;
CREATE TABLE IF NOT EXISTS `sucursal_colaboradores` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `distancia` double NOT NULL,
  `colaborador_id` bigint DEFAULT NULL,
  `sucursal_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdark70snbf3q3yo7jt0n1olia` (`colaborador_id`),
  KEY `FKi92ckh7mc0gdcd8f81xpeamsn` (`sucursal_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Dumping data for table `sucursal_colaboradores`
--

INSERT INTO `sucursal_colaboradores` (`id`, `distancia`, `colaborador_id`, `sucursal_id`) VALUES
(1, 2, 1, 1),
(2, 6, 3, 2),
(3, 20, 2, 1),
(4, 80, 5, 1),
(5, 15, 6, 1),
(6, 10, 7, 1),
(7, 10, 4, 1),
(13, 16, 6, 4),
(14, 3, 7, 5),
(15, 21, 6, 5),
(16, 33, 4, 5),
(17, 1, 3, 5),
(18, 22, 5, 4),
(19, 4, 7, 4),
(20, 34, 2, 4),
(21, 10, 7, 3),
(22, 5, 1, 3),
(23, 18, 3, 3),
(24, 12, 4, 3),
(25, 20, 6, 2);

-- --------------------------------------------------------

--
-- Table structure for table `transportistas`
--

DROP TABLE IF EXISTS `transportistas`;
CREATE TABLE IF NOT EXISTS `transportistas` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `apellido` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `nombre` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `tarifa_porkm` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Dumping data for table `transportistas`
--

INSERT INTO `transportistas` (`id`, `apellido`, `nombre`, `tarifa_porkm`) VALUES
(1, 'Rodriguez', 'Juan', 14),
(2, 'Sanchez', 'Hector', 13.5),
(3, 'Martinez', 'Dennis', 13.5),
(4, 'Ramirez', 'Christian', 15);

-- --------------------------------------------------------

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE IF NOT EXISTS `usuarios` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `contrasenia` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `nombre` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `rol` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Dumping data for table `usuarios`
--

INSERT INTO `usuarios` (`id`, `contrasenia`, `nombre`, `rol`) VALUES
(1, '1234', 'Davidr', 'admin'),
(2, '1234', 'IDaniel03', 'gerenteTienda'),
(3, '1234', 'Erick', 'user');

-- --------------------------------------------------------

--
-- Table structure for table `viajes`
--

DROP TABLE IF EXISTS `viajes`;
CREATE TABLE IF NOT EXISTS `viajes` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `distancia_total` double NOT NULL,
  `fecha` datetime(6) DEFAULT NULL,
  `sucursal_colaborador_id` bigint DEFAULT NULL,
  `transportista_id` bigint DEFAULT NULL,
  `usuario_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7kdbbk2iv1rp0owfmagkvceeo` (`sucursal_colaborador_id`),
  KEY `FKq8s6yldong4s9ml33r546fr7y` (`transportista_id`),
  KEY `FKgoq4qi4euu9uov10eyjfct3uf` (`usuario_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Dumping data for table `viajes`
--

INSERT INTO `viajes` (`id`, `distancia_total`, `fecha`, `sucursal_colaborador_id`, `transportista_id`, `usuario_id`) VALUES
(4, 43, '2024-09-13 23:14:12.136000', 1, 1, 1),
(5, 43, '2024-09-14 01:53:33.180000', 1, 2, 1),
(7, 37, '2024-09-15 22:08:14.769000', 1, 1, 2),
(8, 55, '2024-09-24 22:17:13.161000', 14, 1, 2),
(9, 100, '2024-09-26 22:17:13.161000', 21, 1, 2),
(10, 92, '2024-09-13 22:20:23.274000', 1, 3, 2),
(11, 58, '2024-09-16 22:22:35.205000', 14, 3, 2),
(12, 58, '2024-09-17 22:22:35.205000', 14, 3, 2),
(13, 72, '2024-09-20 22:22:35.205000', 13, 3, 2),
(14, 72, '2024-09-28 22:22:35.205000', 13, 3, 2),
(15, 57, '2024-09-29 22:22:35.205000', 1, 3, 2),
(16, 57, '2024-09-03 22:22:35.205000', 1, 3, 2),
(17, 57, '2024-09-07 22:22:35.205000', 1, 3, 2),
(18, 76, '2024-09-14 22:22:35.205000', 13, 4, 2),
(19, 76, '2024-09-15 22:22:35.205000', 13, 4, 2),
(20, 76, '2024-09-16 06:00:00.000000', 13, 4, 2),
(21, 45, '2024-09-01 06:00:00.000000', 21, 2, 2),
(22, 45, '2024-09-02 06:00:00.000000', 21, 2, 2),
(23, 45, '2024-09-04 06:00:00.000000', 21, 2, 2);

-- --------------------------------------------------------

--
-- Table structure for table `viaje_colaborador`
--

DROP TABLE IF EXISTS `viaje_colaborador`;
CREATE TABLE IF NOT EXISTS `viaje_colaborador` (
  `viaje_id` bigint DEFAULT NULL,
  `colaborador_id` bigint NOT NULL,
  KEY `FKmogf7cws7liny61rg24cl6vhw` (`colaborador_id`),
  KEY `FK_viaje_colaborador_viaje_id` (`viaje_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Dumping data for table `viaje_colaborador`
--

INSERT INTO `viaje_colaborador` (`viaje_id`, `colaborador_id`) VALUES
(NULL, 1),
(NULL, 3),
(NULL, 2),
(NULL, 6),
(NULL, 1),
(NULL, 3),
(NULL, 5),
(NULL, 1),
(NULL, 3),
(NULL, 2),
(NULL, 6),
(4, 1),
(4, 3),
(4, 2),
(4, 6),
(5, 1),
(5, 3),
(5, 2),
(5, 6),
(NULL, 1),
(7, 1),
(7, 2),
(7, 6),
(8, 6),
(8, 4),
(8, 3),
(9, 1),
(9, 7),
(9, 3),
(9, 4),
(10, 1),
(10, 5),
(10, 7),
(11, 6),
(11, 7),
(11, 4),
(11, 3),
(12, 6),
(12, 7),
(12, 4),
(12, 3),
(13, 2),
(13, 6),
(13, 5),
(14, 2),
(14, 6),
(14, 5),
(15, 7),
(15, 1),
(15, 2),
(15, 6),
(15, 4),
(16, 7),
(16, 1),
(16, 2),
(16, 6),
(16, 4),
(17, 7),
(17, 1),
(17, 2),
(17, 6),
(17, 4),
(18, 6),
(18, 5),
(18, 7),
(18, 2),
(19, 6),
(19, 5),
(19, 7),
(19, 2),
(20, 6),
(20, 5),
(20, 7),
(20, 2),
(21, 7),
(21, 1),
(21, 4),
(21, 3),
(22, 7),
(22, 1),
(22, 4),
(22, 3),
(23, 7),
(23, 1),
(23, 4),
(23, 3);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `sucursal_colaboradores`
--
ALTER TABLE `sucursal_colaboradores`
  ADD CONSTRAINT `FKdark70snbf3q3yo7jt0n1olia` FOREIGN KEY (`colaborador_id`) REFERENCES `colaboradores` (`id`),
  ADD CONSTRAINT `FKi92ckh7mc0gdcd8f81xpeamsn` FOREIGN KEY (`sucursal_id`) REFERENCES `sucursales` (`id`);

--
-- Constraints for table `viajes`
--
ALTER TABLE `viajes`
  ADD CONSTRAINT `FK7kdbbk2iv1rp0owfmagkvceeo` FOREIGN KEY (`sucursal_colaborador_id`) REFERENCES `sucursal_colaboradores` (`id`),
  ADD CONSTRAINT `FKgoq4qi4euu9uov10eyjfct3uf` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`),
  ADD CONSTRAINT `FKq8s6yldong4s9ml33r546fr7y` FOREIGN KEY (`transportista_id`) REFERENCES `transportistas` (`id`);

--
-- Constraints for table `viaje_colaborador`
--
ALTER TABLE `viaje_colaborador`
  ADD CONSTRAINT `FK_viaje_colaborador_viaje_id` FOREIGN KEY (`viaje_id`) REFERENCES `viajes` (`id`) ON DELETE SET NULL,
  ADD CONSTRAINT `FKmogf7cws7liny61rg24cl6vhw` FOREIGN KEY (`colaborador_id`) REFERENCES `colaboradores` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
