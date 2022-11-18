-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 07-07-2021 a las 17:42:52
-- Versión del servidor: 5.7.31
-- Versión de PHP: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `municipalidad_lq`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleados`
--

DROP TABLE IF EXISTS `empleados`;
CREATE TABLE IF NOT EXISTS `empleados` (
  `nro_legajo` int(11) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `dni` int(11) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `sueldo_basico` float NOT NULL,
  PRIMARY KEY (`nro_legajo`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `empleados`
--

INSERT INTO `empleados` (`nro_legajo`, `apellido`, `nombre`, `dni`, `fecha_nacimiento`, `sueldo_basico`) VALUES
(2, 'Farfan', 'Yamila', 3944044, '3901-06-03', 0),
(1, 'Torrez', 'Miguel', 48485447, '3900-05-12', 0),
(3, 'Cardozo', 'Franco', 947593, '3899-07-11', 0),
(4, 'Carolina', 'Geronimo', 5759483, '3902-10-12', 0),
(5, 'Flores', 'Gustavo', 19364404, '3898-06-03', 0),
(6, 'Quispe', 'Emilio', 84748404, '3898-05-23', 0),
(7, 'Martinez', 'Lautaro', 904753, '3830-10-30', 0),
(8, 'Ramos', 'Maira', 498484, '3894-07-20', 0),
(9, 'Tolaba', 'Maria', 3947484, '3877-08-27', 0),
(10, 'Mamani', 'Celene', 3047559, '3900-05-24', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proyectos`
--

DROP TABLE IF EXISTS `proyectos`;
CREATE TABLE IF NOT EXISTS `proyectos` (
  `codigo` int(11) NOT NULL,
  `nom_proyecto` varchar(50) NOT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_finalizacion` date NOT NULL,
  `monto` float NOT NULL,
  `Integrantes` varchar(50) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `proyectos`
--

INSERT INTO `proyectos` (`codigo`, `nom_proyecto`, `fecha_inicio`, `fecha_finalizacion`, `monto`, `Integrantes`) VALUES
(2, 'Instalaciones', '3910-09-06', '3911-09-18', 25000, '2'),
(1, 'Reconstruccion', '3919-06-10', '3919-07-10', 30000, '1'),
(3, 'Comunitario', '3918-07-30', '3919-06-11', 23000, '');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
