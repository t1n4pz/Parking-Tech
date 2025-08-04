-- PostgreSQL 17 version


-- Tabla Vehiculo
CREATE TABLE Vehiculo (
  idVehiculo SERIAL NOT NULL,
  tipo VARCHAR(30),
  placa VarCHAR (10);
  PRIMARY KEY (idVehiculo)
);

-- Tabla de Usuarios
CREATE TABLE Usuario (
  idUsuario SERIAL NOT NULL,
  nombre VARCHAR(30) NOT NULL,
  apellido VARCHAR(30) NOT NULL,
  cedula INTEGER NOT NULL,
  clave VARCHAR(30) NOT NULL,
  idVehiculo INTEGER NOT NULL,
  PRIMARY KEY (idUsuario),
  FOREIGN KEY (idVehiculo) REFERENCES Vehiculo(idVehiculo)
);

-- Tabla Reserva
CREATE TABLE Reserva (
  idReserva SERIAL NOT NULL,
  Inicio TIMESTAMP(),
  Final TIMESTAMP(),
  idUsuario;
  idCelda;
  PRIMARY KEY (idReserva)
  FOREIGN KEY (idUsuario) REFERENCES Usuario(idUsuario)
  FOREIGN KEY (idCelda) REFERENCES Celda(idCelda)
);

-- Tabla Celda
CREATE TABLE Celda (
  idCelda SERIAL NOT NULL,
  Zona VARCHAR(10);
  PRIMARY KEY (idCelda)
);

