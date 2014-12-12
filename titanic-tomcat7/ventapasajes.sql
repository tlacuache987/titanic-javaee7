insert into pvm_usuario (ide_usuario, email, nombre_usuario, password, activo,sexo, dni)
values(1, 'jose.diaz@joedayz.pe', 'Jose Diaz', '123', 1, 'MASCULINO', '25723525');

insert into pvm_grupo (ide_grupo, descripcion, nombre_grupo)
	values(1, 'ADMINISTRADORES','ADMINISTRADORES');

insert into pvm_grupo (ide_grupo, descripcion, nombre_grupo)
	values(2, 'AUXILIARES','AUXILIARES');	

insert into pvm_grupo (ide_grupo, descripcion, nombre_grupo)
	values(3, 'VENDEDORES','VENDEDORES');	

insert into pvr_usuario_grupo (ide_usuario, ide_grupo) 
	values(1, 1);

insert into pvr_usuario_grupo (ide_usuario, ide_grupo) 
	values(1, 2);

insert into pvr_usuario_grupo (ide_usuario, ide_grupo) 
	values(1, 3);	

insert into pvm_terminal (ide_terminal, nombre_terminal, direccion_terminal, telefonos_terminal)
values (1, 'Fiori', 'En Fiori de Lima Norte', '');

insert into pvm_terminal (ide_terminal, nombre_terminal, direccion_terminal, telefonos_terminal)
values (2, 'Zapallal', 'En Local de Zapallal', '');

insert into pvm_terminal (ide_terminal, nombre_terminal, direccion_terminal, telefonos_terminal)
values (3, 'Plaza Norte', 'En Local de Plaza Norte', '');

insert into pvm_terminal (ide_terminal, nombre_terminal, direccion_terminal, telefonos_terminal)
values (4, 'Chiclayo', 'En Local de Chiclayo', '');



INSERT INTO `pvm_recorrido` (`ide_recorrido`,`ruta`,`terminal_destino`,`terminal_origen`) VALUES (2,'FIORI-CHICLAYO',4,1);


INSERT INTO `pvm_bus` (`ide_bus`,`con_aire_acondicionado`,`descripcion_bus`,`numero_motor`,`placa`,`tipo_bus`,`tipo_planta`) VALUES (2,1,'BUS001','1234567890','B8N555','COMUN','DOS_PLANTA');


INSERT INTO `pvm_fila_superior` (`ide_fila`,`ubicacion_planta`,`ide_bus`) VALUES (19,'SUPERIOR',2);
INSERT INTO `pvm_fila_superior` (`ide_fila`,`ubicacion_planta`,`ide_bus`) VALUES (20,'SUPERIOR',2);
INSERT INTO `pvm_fila_superior` (`ide_fila`,`ubicacion_planta`,`ide_bus`) VALUES (21,'SUPERIOR',2);
INSERT INTO `pvm_fila_superior` (`ide_fila`,`ubicacion_planta`,`ide_bus`) VALUES (22,'SUPERIOR',2);
INSERT INTO `pvm_fila_superior` (`ide_fila`,`ubicacion_planta`,`ide_bus`) VALUES (23,'SUPERIOR',2);
INSERT INTO `pvm_fila_superior` (`ide_fila`,`ubicacion_planta`,`ide_bus`) VALUES (24,'SUPERIOR',2);
INSERT INTO `pvm_fila_superior` (`ide_fila`,`ubicacion_planta`,`ide_bus`) VALUES (25,'SUPERIOR',2);
INSERT INTO `pvm_fila_superior` (`ide_fila`,`ubicacion_planta`,`ide_bus`) VALUES (26,'SUPERIOR',2);
INSERT INTO `pvm_fila_superior` (`ide_fila`,`ubicacion_planta`,`ide_bus`) VALUES (27,'SUPERIOR',2);
INSERT INTO `pvm_fila_superior` (`ide_fila`,`ubicacion_planta`,`ide_bus`) VALUES (28,'SUPERIOR',2);
INSERT INTO `pvm_fila_superior` (`ide_fila`,`ubicacion_planta`,`ide_bus`) VALUES (29,'SUPERIOR',2);
INSERT INTO `pvm_fila_superior` (`ide_fila`,`ubicacion_planta`,`ide_bus`) VALUES (30,'SUPERIOR',2);
INSERT INTO `pvm_fila_superior` (`ide_fila`,`ubicacion_planta`,`ide_bus`) VALUES (31,'SUPERIOR',2);
INSERT INTO `pvm_fila_superior` (`ide_fila`,`ubicacion_planta`,`ide_bus`) VALUES (32,'SUPERIOR',2);
INSERT INTO `pvm_fila_superior` (`ide_fila`,`ubicacion_planta`,`ide_bus`) VALUES (33,'SUPERIOR',2);
INSERT INTO `pvm_fila_superior` (`ide_fila`,`ubicacion_planta`,`ide_bus`) VALUES (34,'SUPERIOR',2);
INSERT INTO `pvm_fila_superior` (`ide_fila`,`ubicacion_planta`,`ide_bus`) VALUES (35,'SUPERIOR',2);
INSERT INTO `pvm_fila_superior` (`ide_fila`,`ubicacion_planta`,`ide_bus`) VALUES (36,'SUPERIOR',2);


INSERT INTO `pvm_fila_inferior` (`ide_fila`,`ubicacion_planta`,`ide_bus`) VALUES (19,'INFERIOR',2);
INSERT INTO `pvm_fila_inferior` (`ide_fila`,`ubicacion_planta`,`ide_bus`) VALUES (20,'INFERIOR',2);
INSERT INTO `pvm_fila_inferior` (`ide_fila`,`ubicacion_planta`,`ide_bus`) VALUES (21,'INFERIOR',2);
INSERT INTO `pvm_fila_inferior` (`ide_fila`,`ubicacion_planta`,`ide_bus`) VALUES (22,'INFERIOR',2);
INSERT INTO `pvm_fila_inferior` (`ide_fila`,`ubicacion_planta`,`ide_bus`) VALUES (23,'INFERIOR',2);
INSERT INTO `pvm_fila_inferior` (`ide_fila`,`ubicacion_planta`,`ide_bus`) VALUES (24,'INFERIOR',2);
INSERT INTO `pvm_fila_inferior` (`ide_fila`,`ubicacion_planta`,`ide_bus`) VALUES (25,'INFERIOR',2);
INSERT INTO `pvm_fila_inferior` (`ide_fila`,`ubicacion_planta`,`ide_bus`) VALUES (26,'INFERIOR',2);
INSERT INTO `pvm_fila_inferior` (`ide_fila`,`ubicacion_planta`,`ide_bus`) VALUES (27,'INFERIOR',2);
INSERT INTO `pvm_fila_inferior` (`ide_fila`,`ubicacion_planta`,`ide_bus`) VALUES (28,'INFERIOR',2);
INSERT INTO `pvm_fila_inferior` (`ide_fila`,`ubicacion_planta`,`ide_bus`) VALUES (29,'INFERIOR',2);
INSERT INTO `pvm_fila_inferior` (`ide_fila`,`ubicacion_planta`,`ide_bus`) VALUES (30,'INFERIOR',2);
INSERT INTO `pvm_fila_inferior` (`ide_fila`,`ubicacion_planta`,`ide_bus`) VALUES (31,'INFERIOR',2);
INSERT INTO `pvm_fila_inferior` (`ide_fila`,`ubicacion_planta`,`ide_bus`) VALUES (32,'INFERIOR',2);
INSERT INTO `pvm_fila_inferior` (`ide_fila`,`ubicacion_planta`,`ide_bus`) VALUES (33,'INFERIOR',2);
INSERT INTO `pvm_fila_inferior` (`ide_fila`,`ubicacion_planta`,`ide_bus`) VALUES (34,'INFERIOR',2);
INSERT INTO `pvm_fila_inferior` (`ide_fila`,`ubicacion_planta`,`ide_bus`) VALUES (35,'INFERIOR',2);
INSERT INTO `pvm_fila_inferior` (`ide_fila`,`ubicacion_planta`,`ide_bus`) VALUES (36,'INFERIOR',2);


INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (91,'COMUN','LIBRE','1','O-1','ASIENTO',19);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (92,'COMUN','LIBRE','2','O-2','ASIENTO',19);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (93,NULL,'LIBRE',NULL,'','OTRO',19);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (94,'COMUN','LIBRE','3','O-3','ASIENTO',19);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (95,'COMUN','LIBRE','4','O-4','ASIENTO',19);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (96,'COMUN','LIBRE','5','O-5','ASIENTO',20);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (97,'COMUN','LIBRE','6','O-6','ASIENTO',20);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (98,NULL,'LIBRE',NULL,'','OTRO',20);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (99,'COMUN','LIBRE','7','O-7','ASIENTO',20);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (100,'COMUN','LIBRE','8','O-8','ASIENTO',20);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (101,NULL,'LIBRE',NULL,'','OTRO',21);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (102,NULL,'LIBRE',NULL,'','OTRO',21);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (103,NULL,'LIBRE',NULL,'','OTRO',21);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (104,NULL,'LIBRE',NULL,'','OTRO',21);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (105,NULL,'LIBRE',NULL,'','OTRO',21);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (106,NULL,'LIBRE',NULL,'','OTRO',22);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (107,NULL,'LIBRE',NULL,'','OTRO',22);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (108,NULL,'LIBRE',NULL,'','OTRO',22);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (109,NULL,'LIBRE',NULL,'','OTRO',22);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (110,NULL,'LIBRE',NULL,'','OTRO',22);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (111,NULL,'LIBRE',NULL,'','OTRO',23);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (112,NULL,'LIBRE',NULL,'','OTRO',23);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (113,NULL,'LIBRE',NULL,'','OTRO',23);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (114,NULL,'LIBRE',NULL,'','OTRO',23);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (115,NULL,'LIBRE',NULL,'','OTRO',23);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (116,NULL,'LIBRE',NULL,'','OTRO',24);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (117,NULL,'LIBRE',NULL,'','OTRO',24);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (118,NULL,'LIBRE',NULL,'','OTRO',24);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (119,NULL,'LIBRE',NULL,'','OTRO',24);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (120,NULL,'LIBRE',NULL,'','OTRO',24);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (121,NULL,'LIBRE',NULL,'','OTRO',25);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (122,NULL,'LIBRE',NULL,'','OTRO',25);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (123,NULL,'LIBRE',NULL,'','OTRO',25);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (124,NULL,'LIBRE',NULL,'','OTRO',25);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (125,NULL,'LIBRE',NULL,'','OTRO',25);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (126,NULL,'LIBRE',NULL,'','OTRO',26);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (127,NULL,'LIBRE',NULL,'','OTRO',26);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (128,NULL,'LIBRE',NULL,'','OTRO',26);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (129,NULL,'LIBRE',NULL,'','OTRO',26);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (130,NULL,'LIBRE',NULL,'','OTRO',26);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (131,NULL,'LIBRE',NULL,'','OTRO',27);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (132,NULL,'LIBRE',NULL,'','OTRO',27);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (133,NULL,'LIBRE',NULL,'','OTRO',27);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (134,NULL,'LIBRE',NULL,'','OTRO',27);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (135,NULL,'LIBRE',NULL,'','OTRO',27);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (136,NULL,'LIBRE',NULL,'','OTRO',28);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (137,NULL,'LIBRE',NULL,'','OTRO',28);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (138,NULL,'LIBRE',NULL,'','OTRO',28);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (139,NULL,'LIBRE',NULL,'','OTRO',28);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (140,NULL,'LIBRE',NULL,'','OTRO',28);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (141,NULL,'LIBRE',NULL,'','OTRO',29);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (142,NULL,'LIBRE',NULL,'','OTRO',29);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (143,NULL,'LIBRE',NULL,'','OTRO',29);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (144,NULL,'LIBRE',NULL,'','OTRO',29);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (145,NULL,'LIBRE',NULL,'','OTRO',29);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (146,NULL,'LIBRE',NULL,'','OTRO',30);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (147,NULL,'LIBRE',NULL,'','OTRO',30);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (148,NULL,'LIBRE',NULL,'','OTRO',30);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (149,NULL,'LIBRE',NULL,'','OTRO',30);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (150,NULL,'LIBRE',NULL,'','OTRO',30);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (151,NULL,'LIBRE',NULL,'','OTRO',31);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (152,NULL,'LIBRE',NULL,'','OTRO',31);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (153,NULL,'LIBRE',NULL,'','OTRO',31);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (154,NULL,'LIBRE',NULL,'','OTRO',31);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (155,NULL,'LIBRE',NULL,'','OTRO',31);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (156,NULL,'LIBRE',NULL,'','OTRO',32);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (157,NULL,'LIBRE',NULL,'','OTRO',32);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (158,NULL,'LIBRE',NULL,'','OTRO',32);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (159,NULL,'LIBRE',NULL,'','OTRO',32);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (160,NULL,'LIBRE',NULL,'','OTRO',32);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (161,NULL,'LIBRE',NULL,'','OTRO',33);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (162,NULL,'LIBRE',NULL,'','OTRO',33);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (163,NULL,'LIBRE',NULL,'','OTRO',33);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (164,NULL,'LIBRE',NULL,'','OTRO',33);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (165,NULL,'LIBRE',NULL,'','OTRO',33);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (166,NULL,'LIBRE',NULL,'','OTRO',34);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (167,NULL,'LIBRE',NULL,'','OTRO',34);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (168,NULL,'LIBRE',NULL,'','OTRO',34);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (169,NULL,'LIBRE',NULL,'','OTRO',34);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (170,NULL,'LIBRE',NULL,'','OTRO',34);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (171,NULL,'LIBRE',NULL,'','OTRO',35);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (172,NULL,'LIBRE',NULL,'','OTRO',35);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (173,NULL,'LIBRE',NULL,'','OTRO',35);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (174,NULL,'LIBRE',NULL,'','OTRO',35);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (175,NULL,'LIBRE',NULL,'','OTRO',35);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (176,NULL,'LIBRE',NULL,'','OTRO',36);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (177,NULL,'LIBRE',NULL,'','OTRO',36);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (178,NULL,'LIBRE',NULL,'','OTRO',36);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (179,NULL,'LIBRE',NULL,'','OTRO',36);
INSERT INTO `pvm_celda_superior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (180,NULL,'LIBRE',NULL,'','OTRO',36);



INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (91,'COMUN','LIBRE','50','O-50','ASIENTO',19);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (92,'COMUN','LIBRE','51','O-51','ASIENTO',19);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (93,NULL,'LIBRE',NULL,'','OTRO',19);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (94,'COMUN','LIBRE','52','O-52','ASIENTO',19);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (95,'COMUN','LIBRE','53','O-53','ASIENTO',19);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (96,'COMUN','LIBRE','54','O-54','ASIENTO',20);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (97,'COMUN','LIBRE','55','O-55','ASIENTO',20);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (98,NULL,'LIBRE',NULL,'','OTRO',20);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (99,'COMUN','LIBRE','56','O-56','ASIENTO',20);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (100,'COMUN','LIBRE','57','O-57','ASIENTO',20);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (101,NULL,'LIBRE',NULL,'','OTRO',21);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (102,NULL,'LIBRE',NULL,'','OTRO',21);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (103,NULL,'LIBRE',NULL,'','OTRO',21);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (104,NULL,'LIBRE',NULL,'','OTRO',21);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (105,NULL,'LIBRE',NULL,'','OTRO',21);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (106,NULL,'LIBRE',NULL,'','OTRO',22);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (107,NULL,'LIBRE',NULL,'','OTRO',22);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (108,NULL,'LIBRE',NULL,'','OTRO',22);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (109,NULL,'LIBRE',NULL,'','OTRO',22);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (110,NULL,'LIBRE',NULL,'','OTRO',22);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (111,NULL,'LIBRE',NULL,'','OTRO',23);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (112,NULL,'LIBRE',NULL,'','OTRO',23);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (113,NULL,'LIBRE',NULL,'','OTRO',23);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (114,NULL,'LIBRE',NULL,'','OTRO',23);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (115,NULL,'LIBRE',NULL,'','OTRO',23);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (116,NULL,'LIBRE',NULL,'','OTRO',24);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (117,NULL,'LIBRE',NULL,'','OTRO',24);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (118,NULL,'LIBRE',NULL,'','OTRO',24);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (119,NULL,'LIBRE',NULL,'','OTRO',24);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (120,NULL,'LIBRE',NULL,'','OTRO',24);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (121,NULL,'LIBRE',NULL,'','OTRO',25);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (122,NULL,'LIBRE',NULL,'','OTRO',25);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (123,NULL,'LIBRE',NULL,'','OTRO',25);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (124,NULL,'LIBRE',NULL,'','OTRO',25);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (125,NULL,'LIBRE',NULL,'','OTRO',25);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (126,NULL,'LIBRE',NULL,'','OTRO',26);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (127,NULL,'LIBRE',NULL,'','OTRO',26);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (128,NULL,'LIBRE',NULL,'','OTRO',26);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (129,NULL,'LIBRE',NULL,'','OTRO',26);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (130,NULL,'LIBRE',NULL,'','OTRO',26);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (131,NULL,'LIBRE',NULL,'','OTRO',27);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (132,NULL,'LIBRE',NULL,'','OTRO',27);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (133,NULL,'LIBRE',NULL,'','OTRO',27);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (134,NULL,'LIBRE',NULL,'','OTRO',27);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (135,NULL,'LIBRE',NULL,'','OTRO',27);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (136,NULL,'LIBRE',NULL,'','OTRO',28);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (137,NULL,'LIBRE',NULL,'','OTRO',28);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (138,NULL,'LIBRE',NULL,'','OTRO',28);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (139,NULL,'LIBRE',NULL,'','OTRO',28);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (140,NULL,'LIBRE',NULL,'','OTRO',28);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (141,NULL,'LIBRE',NULL,'','OTRO',29);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (142,NULL,'LIBRE',NULL,'','OTRO',29);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (143,NULL,'LIBRE',NULL,'','OTRO',29);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (144,NULL,'LIBRE',NULL,'','OTRO',29);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (145,NULL,'LIBRE',NULL,'','OTRO',29);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (146,NULL,'LIBRE',NULL,'','OTRO',30);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (147,NULL,'LIBRE',NULL,'','OTRO',30);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (148,NULL,'LIBRE',NULL,'','OTRO',30);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (149,NULL,'LIBRE',NULL,'','OTRO',30);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (150,NULL,'LIBRE',NULL,'','OTRO',30);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (151,NULL,'LIBRE',NULL,'','OTRO',31);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (152,NULL,'LIBRE',NULL,'','OTRO',31);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (153,NULL,'LIBRE',NULL,'','OTRO',31);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (154,NULL,'LIBRE',NULL,'','OTRO',31);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (155,NULL,'LIBRE',NULL,'','OTRO',31);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (156,NULL,'LIBRE',NULL,'','OTRO',32);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (157,NULL,'LIBRE',NULL,'','OTRO',32);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (158,NULL,'LIBRE',NULL,'','OTRO',32);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (159,NULL,'LIBRE',NULL,'','OTRO',32);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (160,NULL,'LIBRE',NULL,'','OTRO',32);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (161,NULL,'LIBRE',NULL,'','OTRO',33);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (162,NULL,'LIBRE',NULL,'','OTRO',33);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (163,NULL,'LIBRE',NULL,'','OTRO',33);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (164,NULL,'LIBRE',NULL,'','OTRO',33);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (165,NULL,'LIBRE',NULL,'','OTRO',33);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (166,NULL,'LIBRE',NULL,'','OTRO',34);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (167,NULL,'LIBRE',NULL,'','OTRO',34);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (168,NULL,'LIBRE',NULL,'','OTRO',34);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (169,NULL,'LIBRE',NULL,'','OTRO',34);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (170,NULL,'LIBRE',NULL,'','OTRO',34);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (171,NULL,'LIBRE',NULL,'','OTRO',35);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (172,NULL,'LIBRE',NULL,'','OTRO',35);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (173,NULL,'LIBRE',NULL,'','OTRO',35);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (174,NULL,'LIBRE',NULL,'','OTRO',35);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (175,NULL,'LIBRE',NULL,'','OTRO',35);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (176,NULL,'LIBRE',NULL,'','OTRO',36);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (177,NULL,'LIBRE',NULL,'','OTRO',36);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (178,NULL,'LIBRE',NULL,'','OTRO',36);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (179,NULL,'LIBRE',NULL,'','OTRO',36);
INSERT INTO `pvm_celda_inferior` (`ide_celda`,`calidad`,`estado_celda`,`numero_asiento`,`numero_celda`,`tipo_celda`,`ide_fila`) VALUES (180,NULL,'LIBRE',NULL,'','OTRO',36);
