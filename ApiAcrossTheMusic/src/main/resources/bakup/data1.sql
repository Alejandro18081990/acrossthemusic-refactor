
CREATE TABLE IF NOT EXISTS Musico (
    idMusico int AUTO_INCREMENT,
    email VARCHAR(255)  NOT NULL,
    nombre VARCHAR(255) NOT NULL,
    apellido1 VARCHAR(255) NOT NULL,
    apellido2 VARCHAR(255) NOT NULL,
    edad INT NOT NULL,
    aniosExperiencia INT NOT NULL,
    formacion VARCHAR(255),
    tieneFormacion BOOLEAN,
    PRIMARY KEY (idMusico, email)	
);

CREATE TABLE IF NOT EXISTS Estilo (
	idEstilo int AUTO_INCREMENT PRIMARY KEY,
	nombreEstilo VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS Instrumento(
	idInstrumento int AUTO_INCREMENT PRIMARY KEY,
	nombreInstrumento VARCHAR(255)
);


CREATE TABLE IF NOT EXISTS MusicoTocaInstrumento(
	id int AUTO_INCREMENT PRIMARY KEY,
	idMusico int,
	idInstrumento int
);

CREATE TABLE IF NOT EXISTS MusicoTocaEstilo(
	id int AUTO_INCREMENT PRIMARY KEY,
	idMusico int,
	idEstilo int
);



--Sentencias de inserción de prueba
INSERT IGNORE INTO ESTILO(nombreEstilo) VALUES ("Metal progresivo");
INSERT IGNORE INTO INSTRUMENTO(nombreInstrumento) values ("Guitarra eléctrica");
INSERT IGNORE INTO MUSICO(email,nombre,apellido1,apellido2,edad,aniosExperiencia,formacion,tieneFormacion)
	VALUES("Alex@gmail.com","Alejandro","Núñez","Rodríguez",33,19,"Estudios de música",true);
INSERT IGNORE INTO MUSICOTOCAINSTRUMENTO(idMusico,idInstrumento) values (1,1);
INSERT IGNORE INTO MUSICOTOCAESTILO(idMusico,idEstilo)values (1,1);
