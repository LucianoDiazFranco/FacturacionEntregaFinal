CREATE TABLE `producto` (
  `id_producto` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `rama` varchar(255) DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  `id_venta` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_producto`),
  KEY `FK35runiej5h8usabugvvbdh4dm` (`id_venta`),
  CONSTRAINT `FK35runiej5h8usabugvvbdh4dm` FOREIGN KEY (`id_venta`) REFERENCES `venta` (`id_venta`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci