CREATE TABLE `venta` (
  `id_venta` int(11) NOT NULL AUTO_INCREMENT,
  `tipo_de_venta` varchar(255) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `fecha` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_venta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci