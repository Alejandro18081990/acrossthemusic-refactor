--Sentencias de inserción de prueba
INSERT IGNORE INTO MUSICO(email,nombre,apellido1,apellido2,edad,anios_experiencia,formacion,tiene_formacion,permiso)
	VALUES('Alex@gmail.com','Alejandro','Núñez','Rodríguez',33,19,'Estudios de música',true,'ADMIN');
INSERT IGNORE INTO MUSICO(email,nombre,apellido1,apellido2,edad,anios_experiencia,formacion,tiene_formacion,permiso)
	VALUES('Raquel@gmail.com','Raquel','Romero','Reina',32,12,'Estudios de músicoterapia',true,'USER');
INSERT IGNORE INTO MUSICO(email,nombre,apellido1,apellido2,edad,anios_experiencia,formacion,tiene_formacion,permiso)
	VALUES('Noah@gmail.com','Noah','Rivera','Núñez',11,2,'Musica cole',true,'USER');
INSERT IGNORE INTO MUSICO(email,nombre,apellido1,apellido2,edad,anios_experiencia,formacion,tiene_formacion,permiso)
	VALUES('Leoh@gmail.com','Leo','Rivera','Núñez',15,2,'Musica cole',true,'USER');
INSERT IGNORE INTO MUSICO(email,nombre,apellido1,apellido2,edad,anios_experiencia,formacion,tiene_formacion,permiso)
	VALUES('Lucia@gmail.com','Lucia','Rodríguez','Ramos',67,10,'-',false,'USER');
INSERT IGNORE INTO MUSICO(email,nombre,apellido1,apellido2,edad,anios_experiencia,formacion,tiene_formacion,permiso)
	VALUES('Manolo@gmail.com','Manolo','Núñez','Lopez',74,20,'-',false,'USER');
INSERT IGNORE INTO MUSICO(email,nombre,apellido1,apellido2,edad,anios_experiencia,formacion,tiene_formacion,permiso)
	VALUES('Esther@gmail.com','Esther','Núñez','Rodríguez',48,20,'Estudios de música',true,'USER');
INSERT IGNORE INTO MUSICO(email,nombre,apellido1,apellido2,edad,anios_experiencia,formacion,tiene_formacion,permiso)
	VALUES('Pluk@gmail.com','Jose Luis','Núñez','Rodríguez',33,19,'Estudios de música',true,'USER');
INSERT IGNORE INTO MUSICO(email,nombre,apellido1,apellido2,edad,anios_experiencia,formacion,tiene_formacion,permiso)
	VALUES('David@gmail.com','David','Jimenez','Real',40,20,'Estudios de música',true,'USER');
INSERT IGNORE INTO MUSICO(email,nombre,apellido1,apellido2,edad,anios_experiencia,formacion,tiene_formacion,permiso)
	VALUES('DavidG@gmail.com','David','Gonzalez','Roales',40,20,'Estudios de música',true,'USER');
INSERT IGNORE INTO MUSICO(email,nombre,apellido1,apellido2,edad,anios_experiencia,formacion,tiene_formacion,permiso)
	VALUES('Edu@gmail.com','Edu','-','-',40,20,'Estudios de música',true,'USER');
INSERT IGNORE INTO MUSICO(email,nombre,apellido1,apellido2,edad,anios_experiencia,formacion,tiene_formacion,permiso)
	VALUES('raquel91@gmail.com','Raquel','Romero','Reina',33,10,'Estudios superiores de música',true,'USER');
--11 estilos
INSERT IGNORE INTO ESTILO(nombre_estilo) VALUES ('Metal progresivo');
INSERT IGNORE INTO ESTILO(nombre_estilo) VALUES ('Rock');
INSERT IGNORE INTO ESTILO(nombre_estilo) VALUES ('Pop');
INSERT IGNORE INTO ESTILO(nombre_estilo) VALUES ('Heavy metal clasico');
INSERT IGNORE INTO ESTILO(nombre_estilo) VALUES ('Jazz');
INSERT IGNORE INTO ESTILO(nombre_estilo) VALUES ('Funk');
INSERT IGNORE INTO ESTILO(nombre_estilo) VALUES ('Soul');
INSERT IGNORE INTO ESTILO(nombre_estilo) VALUES ('Musica clasica');
INSERT IGNORE INTO ESTILO(nombre_estilo) VALUES ('Flamenco');
INSERT IGNORE INTO ESTILO(nombre_estilo) VALUES ('Rap');
INSERT IGNORE INTO ESTILO(nombre_estilo) VALUES ('Blues');
--12 instrumentos
INSERT IGNORE INTO INSTRUMENTO(nombre_instrumento) values ('Guitarra eléctrica');
INSERT INTO INSTRUMENTO (NOMBRE_INSTRUMENTO) VALUES ("Bateria");
INSERT INTO INSTRUMENTO (NOMBRE_INSTRUMENTO) VALUES ("Piano");
INSERT INTO INSTRUMENTO (NOMBRE_INSTRUMENTO) VALUES ("Guitarra clasica");
INSERT INTO INSTRUMENTO (NOMBRE_INSTRUMENTO) VALUES ("Guitarra española");
INSERT INTO INSTRUMENTO (NOMBRE_INSTRUMENTO) VALUES ("Bajo");
INSERT INTO INSTRUMENTO (NOMBRE_INSTRUMENTO) VALUES ("Violin");
INSERT INTO INSTRUMENTO (NOMBRE_INSTRUMENTO) VALUES ("Contrabajo");
INSERT INTO INSTRUMENTO (NOMBRE_INSTRUMENTO) VALUES ("Clarinete");
INSERT INTO INSTRUMENTO (NOMBRE_INSTRUMENTO) VALUES ("Tuba");
INSERT INTO INSTRUMENTO (NOMBRE_INSTRUMENTO) VALUES ("Trompeta");
INSERT INTO INSTRUMENTO (NOMBRE_INSTRUMENTO) VALUES ("Voz");

INSERT INTO JAM_SESSION(nombre_jam,id_estilo,fecha) values("JamMetalera",1, ('2024-08-18 22:00:00'));
INSERT INTO JAM_SESSION(nombre_jam,id_estilo,fecha) values("JamMetaleraClasica",4, ('2024-08-18 22:00:00'));
INSERT INTO JAM_SESSION(nombre_jam,id_estilo,fecha) values("JamJazzera",5, ('2024-08-19 22:00:00'));
INSERT INTO JAM_SESSION(nombre_jam,id_estilo,fecha) values("JamPopera",3, ('2024-08-28 22:00:00'));
INSERT INTO JAM_SESSION(nombre_jam,id_estilo,fecha) values("JamBlusera",9, ('2024-08-10 22:00:00'));

INSERT INTO GRUPO(nombre_grupo,anio_formacion)values("Hybernia",1999);



INSERT IGNORE INTO MUSICO_TOCA_INSTRUMENTO(musico,instrumento) values (1,1);
INSERT IGNORE INTO MUSICO_TOCA_INSTRUMENTO(musico,instrumento) values (1,2);

INSERT IGNORE INTO MUSICO_TOCA_INSTRUMENTO(musico,instrumento) values (1,3);
INSERT IGNORE INTO MUSICO_TOCA_ESTILO(musico,estilo)values (1,1);

INSERT IGNORE INTO MUSICO_TOCA_INSTRUMENTO(musico,instrumento)values (2,2);
insert into musico_toca_estilo (musico,estilo) values (2,2);

INSERT IGNORE INTO MUSICO_TOCA_INSTRUMENTO(musico,instrumento)values (3,5);
insert into musico_toca_estilo (musico,estilo) values (3,6);
insert into musico_toca_estilo (musico,estilo) values (3,7);
insert into musico_toca_estilo (musico,estilo) values (3,8);

INSERT IGNORE INTO MUSICO_TOCA_INSTRUMENTO(musico,instrumento)values (4,5);
insert into musico_toca_estilo (musico,estilo) values (4,3);

INSERT IGNORE INTO MUSICO_TOCA_INSTRUMENTO(musico,instrumento)values (5,9);
insert into musico_toca_estilo (musico,estilo) values (5,6);

INSERT IGNORE INTO MUSICO_TOCA_INSTRUMENTO(musico,instrumento)values (6,3);
insert into musico_toca_estilo (musico,estilo) values (6,1);

INSERT IGNORE INTO MUSICO_TOCA_INSTRUMENTO(musico,instrumento)values (7,3);
insert into musico_toca_estilo (musico,estilo) values (7,1);

INSERT IGNORE INTO MUSICO_TOCA_INSTRUMENTO(musico,instrumento)values (8,3);
insert into musico_toca_estilo (musico,estilo) values (8,1);

INSERT IGNORE INTO MUSICO_TOCA_INSTRUMENTO(musico,instrumento)values (9,2);
insert into musico_toca_estilo (musico,estilo) values (8,3);

INSERT IGNORE INTO MUSICO_TOCA_INSTRUMENTO(musico,instrumento)values (10,6);
insert into musico_toca_estilo (musico,estilo) values (10,3);

INSERT IGNORE INTO MUSICO_TOCA_INSTRUMENTO(musico,instrumento)values (11,12);
insert into musico_toca_estilo (musico,estilo) values (11,3);

INSERT IGNORE INTO MUSICO_TOCA_INSTRUMENTO(musico,instrumento) values (12,2);
INSERT IGNORE INTO MUSICO_TOCA_INSTRUMENTO(musico,instrumento) values (12,6);
insert into musico_toca_estilo (musico,estilo) values (12,3);
insert into musico_toca_estilo (musico,estilo) values (12,1);


INSERT INTO MUSICO_TOCA_JAM(id_musico,id_jam_session) values(1,1);
INSERT INTO MUSICO_TOCA_JAM(id_musico,id_jam_session) values(2,2);
INSERT INTO MUSICO_TOCA_JAM(id_musico,id_jam_session) values(3,2);
INSERT INTO MUSICO_TOCA_JAM(id_musico,id_jam_session) values(4,2);
INSERT INTO MUSICO_TOCA_JAM(id_musico,id_jam_session) values(5,1);
INSERT INTO MUSICO_TOCA_JAM(id_musico,id_jam_session) values(5,3);
INSERT INTO MUSICO_TOCA_JAM(id_musico,id_jam_session) values(5,4);
INSERT INTO MUSICO_TOCA_JAM(id_musico,id_jam_session) values(5,5);

INSERT INTO MUSICO_TOCA_GRUPO(idmusico,idgrupo) values(1,1);
INSERT INTO MUSICO_TOCA_GRUPO(idmusico,idgrupo) values(8,1);
INSERT INTO MUSICO_TOCA_GRUPO(idmusico,idgrupo) values(9,1);
INSERT INTO MUSICO_TOCA_GRUPO(idmusico,idgrupo) values(10,1);
INSERT INTO MUSICO_TOCA_GRUPO(idmusico,idgrupo) values(11,1);

--INSERT INTO MUSICO_MENSAJE (musico_remitente,musico_destinatario,mensaje) VALUES(1,2,1);
--INSERT INTO MENSAJE (mensaje) VALUES("Hola");
--INSERT INTO MUSICO_MENSAJE (musico_remitente,musico_destinatario,cuerpo_mensaje) VALUES(1,12,"¿Hola qué tal?");
--INSERT INTO MUSICO_MENSAJE (musico_remitente,musico_destinatario,cuerpo_mensaje) VALUES(1,12,"¿Hola qué tal?");
