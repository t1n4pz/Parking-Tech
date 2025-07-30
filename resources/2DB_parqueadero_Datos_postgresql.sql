-- PostgreSQL 17 version - Data insertion
-- SET search_path TO universidad;

INSERT INTO Usuario (idUsuario, nombre, apellido, cedula, clave, idVehiculo) 
VALUES 
  (1, 'Carlos', 'Caicedo', 1234, '1234', 1),
  (2, 'Luisa', 'Caicedo', 1235, '1235', 2),
  (3, 'Miguel', 'Caicedo', 1236, '1236', 3),
  (4, 'Pablo', 'Caicedo', 1237, '1237', 4),

INSERT INTO Vehiculo (idVehiculo, tipo, placa, imagen)
VALUES 
  (1, 'Antonio', 'Carro', 654321, 101),
  (2, 'Patricia', 'Carro', 789123, 100),
  (3, 'Alberto', 'Moto', 159753, 001),
  (4, 'Mercedes', 'Moto', 357951, 010);

INSERT INTO Reserva (idReserva, Inicio, Final, idUsuario, idCelda) 
VALUES 
  (1, 1, '2025-07-30 1:30:00', '2025-07-30 2:30:00', 1),
  (2, 2, '2025-07-30 3:30:00', '2025-07-30 4:30:00',2),
  (3, 3, '2025-07-30 5:30:00', '2025-07-30 6:30:00',3),
  (4, 4, '2025-07-30 7:30:00', '2025-07-30 8:30:00',4);

INSERT INTO Celda (idCelda, Zona)
VALUES 
  (1, 'Zona Norte'),
  (2, 'Zona Sur'),
  (3, 'Zona Este'),
  (4, 'Zona Oeste');
