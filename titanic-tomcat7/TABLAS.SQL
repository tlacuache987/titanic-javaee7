

CREATE TABLE `pvm_bus` (
  `ide_bus` bigint(20) NOT NULL AUTO_INCREMENT,
  `con_aire_acondicionado` tinyint(1) DEFAULT NULL,
  `descripcion_bus` varchar(255) NOT NULL,
  `numero_motor` varchar(50) DEFAULT NULL,
  `placa` varchar(10) NOT NULL,
  `tipo_bus` varchar(50) NOT NULL,
  `tipo_planta` varchar(50) NOT NULL,
  PRIMARY KEY (`ide_bus`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;


CREATE TABLE `pvm_fila_inferior` (
  `ide_fila` bigint(20) NOT NULL AUTO_INCREMENT,
  `ubicacion_planta` varchar(50) NOT NULL,
  `ide_bus` bigint(20) NOT NULL,
  PRIMARY KEY (`ide_fila`),
  KEY `FK_pykwwmn74da893b15w35mr2gq` (`ide_bus`),
  CONSTRAINT `FK_pykwwmn74da893b15w35mr2gq` FOREIGN KEY (`ide_bus`) REFERENCES `pvm_bus` (`ide_bus`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;

CREATE TABLE `pvm_fila_superior` (
  `ide_fila` bigint(20) NOT NULL AUTO_INCREMENT,
  `ubicacion_planta` varchar(50) NOT NULL,
  `ide_bus` bigint(20) NOT NULL,
  PRIMARY KEY (`ide_fila`),
  KEY `FK_614antectn477461br9mpxffm` (`ide_bus`),
  CONSTRAINT `FK_614antectn477461br9mpxffm` FOREIGN KEY (`ide_bus`) REFERENCES `pvm_bus` (`ide_bus`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;


CREATE TABLE `pvm_celda_inferior` (
  `ide_celda` bigint(20) NOT NULL AUTO_INCREMENT,
  `calidad` varchar(50) DEFAULT NULL,
  `estado_celda` varchar(50) NOT NULL,
  `numero_asiento` varchar(10) DEFAULT NULL,
  `numero_celda` varchar(10) NOT NULL,
  `tipo_celda` varchar(50) NOT NULL,
  `ide_fila` bigint(20) NOT NULL,
  PRIMARY KEY (`ide_celda`),
  KEY `FK_9064einjkff6d5nhp3exmyw14` (`ide_fila`),
  CONSTRAINT `FK_9064einjkff6d5nhp3exmyw14` FOREIGN KEY (`ide_fila`) REFERENCES `pvm_fila_inferior` (`ide_fila`)
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=latin1;

CREATE TABLE `pvm_celda_superior` (
  `ide_celda` bigint(20) NOT NULL AUTO_INCREMENT,
  `calidad` varchar(50) DEFAULT NULL,
  `estado_celda` varchar(50) NOT NULL,
  `numero_asiento` varchar(10) DEFAULT NULL,
  `numero_celda` varchar(10) NOT NULL,
  `tipo_celda` varchar(50) NOT NULL,
  `ide_fila` bigint(20) NOT NULL,
  PRIMARY KEY (`ide_celda`),
  KEY `FK_n592qhkab8js8ly1xeffu90ds` (`ide_fila`),
  CONSTRAINT `FK_n592qhkab8js8ly1xeffu90ds` FOREIGN KEY (`ide_fila`) REFERENCES `pvm_fila_superior` (`ide_fila`)
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=latin1;

CREATE TABLE `pvm_cliente` (
  `ide_cliente` bigint(20) NOT NULL AUTO_INCREMENT,
  `edad` int(11) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `nombre_cliente` varchar(255) NOT NULL,
  `numero_documento` varchar(11) NOT NULL,
  `sexo` varchar(50) NOT NULL,
  `tipo_documento` varchar(50) NOT NULL,
  `tipo_persona` varchar(50) NOT NULL,
  PRIMARY KEY (`ide_cliente`),
  UNIQUE KEY `UK_mltspc80hk7uiyf2w5s3ovuax` (`numero_documento`),
  UNIQUE KEY `UK_5q329len9ewfauirhy7iicpcf` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;



CREATE TABLE `pvm_grupo` (
  `ide_grupo` bigint(20) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(355) DEFAULT NULL,
  `nombre_grupo` varchar(255) NOT NULL,
  PRIMARY KEY (`ide_grupo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;


CREATE TABLE `pvm_terminal` (
  `ide_terminal` bigint(20) NOT NULL AUTO_INCREMENT,
  `direccion_terminal` varchar(255) NOT NULL,
  `nombre_terminal` varchar(50) NOT NULL,
  `telefonos_terminal` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ide_terminal`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;



CREATE TABLE `pvm_recorrido` (
  `ide_recorrido` bigint(20) NOT NULL AUTO_INCREMENT,
  `ruta` varchar(50) NOT NULL,
  `terminal_destino` bigint(20) NOT NULL,
  `terminal_origen` bigint(20) NOT NULL,
  PRIMARY KEY (`ide_recorrido`),
  KEY `FK_rb6rsegyvyuojomtf1daqtfra` (`terminal_destino`),
  KEY `FK_ckpy4hvr9momo0xxv1ch46y4p` (`terminal_origen`),
  CONSTRAINT `FK_ckpy4hvr9momo0xxv1ch46y4p` FOREIGN KEY (`terminal_origen`) REFERENCES `pvm_terminal` (`ide_terminal`),
  CONSTRAINT `FK_rb6rsegyvyuojomtf1daqtfra` FOREIGN KEY (`terminal_destino`) REFERENCES `pvm_terminal` (`ide_terminal`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;


CREATE TABLE `pvm_hora_salida` (
  `ide_hora_salida` bigint(20) NOT NULL AUTO_INCREMENT,
  `hora_salida` varchar(255) NOT NULL,
  `ide_recorrido` bigint(20) NOT NULL,
  PRIMARY KEY (`ide_hora_salida`),
  KEY `FK_48dvgpd1qb0l87telluptclnb` (`ide_recorrido`),
  CONSTRAINT `FK_48dvgpd1qb0l87telluptclnb` FOREIGN KEY (`ide_recorrido`) REFERENCES `pvm_recorrido` (`ide_recorrido`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `pvm_tarifa_general` (
  `ide_tarifa_general` bigint(20) NOT NULL AUTO_INCREMENT,
  `precio` decimal(10,2) NOT NULL,
  `tipo_bus` varchar(20) NOT NULL,
  `tipo_pasaje` varchar(50) NOT NULL,
  `ide_recorrido` bigint(20) NOT NULL,
  PRIMARY KEY (`ide_tarifa_general`),
  KEY `FK_dc08ve3e2v6h1lgcu08jnhr5y` (`ide_recorrido`),
  CONSTRAINT `FK_dc08ve3e2v6h1lgcu08jnhr5y` FOREIGN KEY (`ide_recorrido`) REFERENCES `pvm_recorrido` (`ide_recorrido`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;


CREATE TABLE `pvm_usuario` (
  `ide_usuario` bigint(20) NOT NULL AUTO_INCREMENT,
  `activo` tinyint(1) DEFAULT NULL,
  `dni` varchar(10) NOT NULL,
  `email` varchar(50) NOT NULL,
  `nombre_usuario` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `sexo` varchar(50) NOT NULL,
  PRIMARY KEY (`ide_usuario`),
  UNIQUE KEY `UK_s53ueirklqhgqy32ptmf9am69` (`dni`),
  UNIQUE KEY `UK_4psi8oj5ie550n6nckh2f6mj9` (`email`),
  UNIQUE KEY `UK_rc5bdw49quyjc7c1ux7d9bqvs` (`nombre_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

CREATE TABLE `pvm_venta` (
  `ide_venta` bigint(20) NOT NULL AUTO_INCREMENT,
  `fecha_venta` date NOT NULL,
  `hora_salida` varchar(10) NOT NULL,
  `total_venta` decimal(10,2) NOT NULL,
  `ide_bus` bigint(20) NOT NULL,
  `ide_recorrido` bigint(20) NOT NULL,
  PRIMARY KEY (`ide_venta`),
  KEY `FK_c5g3wrv8lrwmbq7ri1rp00vqj` (`ide_bus`),
  KEY `FK_l8y2s96h7hyxueoisqf0xf0na` (`ide_recorrido`),
  CONSTRAINT `FK_l8y2s96h7hyxueoisqf0xf0na` FOREIGN KEY (`ide_recorrido`) REFERENCES `pvm_recorrido` (`ide_recorrido`),
  CONSTRAINT `FK_c5g3wrv8lrwmbq7ri1rp00vqj` FOREIGN KEY (`ide_bus`) REFERENCES `pvm_bus` (`ide_bus`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

CREATE TABLE `pvr_usuario_grupo` (
  `ide_usuario` bigint(20) NOT NULL,
  `ide_grupo` bigint(20) NOT NULL,
  KEY `FK_pa8wjiie7sora7a3rh1tg4r44` (`ide_grupo`),
  KEY `FK_kvybvbbr1exo3ve8omcs8mqfp` (`ide_usuario`),
  CONSTRAINT `FK_kvybvbbr1exo3ve8omcs8mqfp` FOREIGN KEY (`ide_usuario`) REFERENCES `pvm_usuario` (`ide_usuario`),
  CONSTRAINT `FK_pa8wjiie7sora7a3rh1tg4r44` FOREIGN KEY (`ide_grupo`) REFERENCES `pvm_grupo` (`ide_grupo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `pvm_boleto` (
  `ide_boleto` bigint(20) NOT NULL AUTO_INCREMENT,
  `asiento` varchar(10) NOT NULL,
  `destino` varchar(50) DEFAULT NULL,
  `estado` varchar(20) NOT NULL,
  `fecha_venta` varchar(12) DEFAULT NULL,
  `hora_salida` varchar(10) DEFAULT NULL,
  `nombre_cliente` varchar(255) DEFAULT NULL,
  `numero_documento` varchar(10) DEFAULT NULL,
  `origen` varchar(50) DEFAULT NULL,
  `precio` decimal(10,2) NOT NULL,
  `presento_carta_notarial` tinyint(1) DEFAULT NULL,
  `ide_cliente` bigint(20) DEFAULT NULL,
  `vendedor` bigint(20) NOT NULL,
  `ide_venta` bigint(20) NOT NULL,
  PRIMARY KEY (`ide_boleto`),
  KEY `FK_kcp63l3nh5xkqd2uyfo2ngy22` (`ide_cliente`),
  KEY `FK_hghldukjk8jcrh8gjn8bsea77` (`vendedor`),
  KEY `FK_nfyckwu66p6r6vmobxbfcphw7` (`ide_venta`),
  CONSTRAINT `FK_nfyckwu66p6r6vmobxbfcphw7` FOREIGN KEY (`ide_venta`) REFERENCES `pvm_venta` (`ide_venta`),
  CONSTRAINT `FK_hghldukjk8jcrh8gjn8bsea77` FOREIGN KEY (`vendedor`) REFERENCES `pvm_usuario` (`ide_usuario`),
  CONSTRAINT `FK_kcp63l3nh5xkqd2uyfo2ngy22` FOREIGN KEY (`ide_cliente`) REFERENCES `pvm_cliente` (`ide_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;
