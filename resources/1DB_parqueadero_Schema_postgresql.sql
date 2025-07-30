-- PostgreSQL 17 version


-- Tabla de Usuarios
CREATE TABLE Usuario (
  idUsuario INTEGER NOT NULL,
  nombre VARCHAR(30) NOT NULL,
  apellido VARCHAR(30) NOT NULL,
  cedula INTEGER NOT NULL,
  clave VARCHAR(30) NOT NULL,
  idVehiculo INTEGER NOT NULL,
  PRIMARY KEY (idUsuario)
  FOREIGN KEY (idVehivulo)
);

-- Tabla Vehiculo
CREATE TABLE Vehiculo (
  idVehiculo INTEGER NOT NULL,
  tipo VARCHAR(30),
  placa VarCHAR (10);
  imagen bytea,
  PRIMARY KEY (idVehiculo)
);

-- Tabla Reserva
CREATE TABLE Reserva (
  idReserva INTEGER NOT NULL,
  Inicio TIMESTAMP(),
  Final TIMESTAMP(),
  idUsuario;
  idCelda;
  PRIMARY KEY (idReserva)
  FOREIGN KEY (idUsuario)
  FOREIGN KEY (idCelda)
);

-- Tabla Celda
CREATE TABLE Celda (
  idCelda INTEGER NOT NULL,
  Zona VARCHAR(10);
  PRIMARY KEY (idCelda)
);

