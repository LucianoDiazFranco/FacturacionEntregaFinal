CREATE TABLE `cliente` (
  `dni` int(11) NOT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `orden` int(11) DEFAULT NULL,
  `id_producto` int(11) DEFAULT NULL,
  PRIMARY KEY (`dni`),
  KEY `FKm1d6n3lm1peiwas4jsk8oi7vn` (`id_producto`),
  CONSTRAINT `FKm1d6n3lm1peiwas4jsk8oi7vn` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id_producto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci