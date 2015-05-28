-- phpMyAdmin SQL Dump
-- version 4.2.10
-- http://www.phpmyadmin.net
--
-- Host: localhost:3306
-- Generation Time: May 28, 2015 at 04:36 PM
-- Server version: 5.5.38
-- PHP Version: 5.6.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `asistente_natacion_cr`
--
CREATE DATABASE IF NOT EXISTS `asistente_natacion_cr` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `asistente_natacion_cr`;

-- --------------------------------------------------------

--
-- Table structure for table `entrenamiento`
--

DROP TABLE IF EXISTS `entrenamiento`;
CREATE TABLE `entrenamiento` (
`id` int(11) NOT NULL,
  `id_equipo` int(11) NOT NULL,
  `fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `equipo`
--

DROP TABLE IF EXISTS `equipo`;
CREATE TABLE `equipo` (
`id` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `id_usuario` varchar(45) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `equipo`
--

INSERT INTO `equipo` (`id`, `nombre`, `id_usuario`) VALUES
(1, 'Heredia', 'mkyong'),
(2, 'Chepe', 'mkyong');

-- --------------------------------------------------------

--
-- Table structure for table `prueba`
--

DROP TABLE IF EXISTS `prueba`;
CREATE TABLE `prueba` (
`id` int(11) NOT NULL,
  `id_entrenamiento` int(11) NOT NULL,
  `distancia` int(11) NOT NULL,
  `estilo` int(11) NOT NULL,
  `consecutivo` int(11) NOT NULL,
  `tipo` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
CREATE TABLE `rol` (
`id_rol_usuario` int(11) NOT NULL,
  `nombre_usuario` varchar(45) NOT NULL,
  `rol` varchar(45) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `rol`
--

INSERT INTO `rol` (`id_rol_usuario`, `nombre_usuario`, `rol`) VALUES
(3, 'mkyong', 'ROLE_ADMIN'),
(4, 'alex', 'ROLE_USER'),
(2, 'mkyong', 'ROLE_USER');

-- --------------------------------------------------------

--
-- Table structure for table `tiempo`
--

DROP TABLE IF EXISTS `tiempo`;
CREATE TABLE `tiempo` (
`id` int(11) NOT NULL,
  `id_prueba` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `tiempo` datetime NOT NULL,
  `distancia_prueba` int(11) DEFAULT NULL,
  `estilo_prueba` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario` (
  `nombre_usuario` varchar(45) NOT NULL,
  `contrasena` varchar(150) NOT NULL,
  `activo` tinyint(4) NOT NULL DEFAULT '1',
  `apellidos` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `tipo` int(11) DEFAULT NULL,
  `id_nadador` int(11) DEFAULT NULL,
  `nombre` varchar(45) NOT NULL,
  `edad` int(11) DEFAULT NULL,
  `categoria` int(11) DEFAULT NULL,
  `especialidad` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `usuario`
--

INSERT INTO `usuario` (`nombre_usuario`, `contrasena`, `activo`, `apellidos`, `email`, `tipo`, `id_nadador`, `nombre`, `edad`, `categoria`, `especialidad`) VALUES
('alex', '$2a$10$04TVADrR6/SPLBjsK0N30.Jf5fNjBugSACeGv1S69dZALR7lSov0y', 1, 'sanders', 'alex@sanders.com', 1, 2, 'Alex Sanders', 18, 2, 1),
('mkyong', '$2a$10$04TVADrR6/SPLBjsK0N30.Jf5fNjBugSACeGv1S69dZALR7lSov0y', 1, 'Chino', 'mkyong@chino.com', 1, 3, 'Mkyong', 21, 3, 4);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `entrenamiento`
--
ALTER TABLE `entrenamiento`
 ADD PRIMARY KEY (`id`), ADD KEY `id_equipo_idx` (`id_equipo`);

--
-- Indexes for table `equipo`
--
ALTER TABLE `equipo`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `prueba`
--
ALTER TABLE `prueba`
 ADD PRIMARY KEY (`id`), ADD KEY `prueba_entrenamiento_idx` (`id_entrenamiento`);

--
-- Indexes for table `rol`
--
ALTER TABLE `rol`
 ADD PRIMARY KEY (`id_rol_usuario`), ADD UNIQUE KEY `usuario_rol` (`rol`,`nombre_usuario`), ADD KEY `fk_username_idx` (`nombre_usuario`);

--
-- Indexes for table `tiempo`
--
ALTER TABLE `tiempo`
 ADD PRIMARY KEY (`id`), ADD KEY `tiempo_prueba_idx` (`id_prueba`), ADD KEY `tiempo_nadador_idx` (`id_usuario`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
 ADD PRIMARY KEY (`nombre_usuario`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `entrenamiento`
--
ALTER TABLE `entrenamiento`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `equipo`
--
ALTER TABLE `equipo`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `prueba`
--
ALTER TABLE `prueba`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `rol`
--
ALTER TABLE `rol`
MODIFY `id_rol_usuario` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `tiempo`
--
ALTER TABLE `tiempo`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `rol`
--
ALTER TABLE `rol`
ADD CONSTRAINT `fk_username` FOREIGN KEY (`nombre_usuario`) REFERENCES `usuario` (`nombre_usuario`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
