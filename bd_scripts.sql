CREATE TABLE Maestro (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tabla VARCHAR(100),
    descripcion TEXT,
    usuarioRegistro VARCHAR(100) NOT NULL DEFAULT '',
    fechaRegistro DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    usuarioModifica VARCHAR(100) DEFAULT '',
    fechaModifica DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    activo BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE MaestroDetalle (
    id INT AUTO_INCREMENT PRIMARY KEY,
    valor VARCHAR(100),
    idMaestro INT,
    FOREIGN KEY (idMaestro) REFERENCES Maestro(id),
    usuarioRegistro VARCHAR(100) NOT NULL DEFAULT '',
    fechaRegistro DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    usuarioModifica VARCHAR(100) DEFAULT '',
    fechaModifica DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    activo BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE Cliente (
    id VARCHAR(40) PRIMARY KEY,
    nombre VARCHAR(100),
    apellidos VARCHAR(100),
    idTipoDocumento INT,
    documento VARCHAR(20) UNIQUE,
    telefono VARCHAR(10),
    email VARCHAR(30),
    FOREIGN KEY (idTipoDocumento) REFERENCES MaestroDetalle(id),
    usuarioRegistro VARCHAR(100) NOT NULL DEFAULT '',
    fechaRegistro DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    usuarioModifica VARCHAR(100) DEFAULT '',
    fechaModifica DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    activo BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE Vehiculo (
    id VARCHAR(40) PRIMARY KEY,
    placa VARCHAR(20) UNIQUE,
    marca VARCHAR(50),
    modelo VARCHAR(50),
    color VARCHAR(30),
    idCliente VARCHAR(40),
    idTipoVehiculo INT,
    FOREIGN KEY (idCliente) REFERENCES Cliente(id),
    FOREIGN KEY (idTipoVehiculo) REFERENCES MaestroDetalle(id),
    usuarioRegistro VARCHAR(100) NOT NULL DEFAULT '',
    fechaRegistro DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    usuarioModifica VARCHAR(100) DEFAULT '',
    fechaModifica DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    activo BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE Empleado (
    id VARCHAR(40) PRIMARY KEY,
    nombre VARCHAR(100),
    apellidos VARCHAR(100),
    idTipoDocumento INT,
    documento VARCHAR(20) UNIQUE,
    telefono VARCHAR(20),
    FOREIGN KEY (idTipoDocumento) REFERENCES MaestroDetalle(id),
    usuarioRegistro VARCHAR(100) NOT NULL DEFAULT '',
    fechaRegistro DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    usuarioModifica VARCHAR(100) DEFAULT '',
    fechaModifica DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    activo BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE Usuario (
    id VARCHAR(40) PRIMARY KEY,
    nombreUsuario VARCHAR(50) UNIQUE,
    contrasenia VARCHAR(100),
    idRol INT,
    idEmpleado VARCHAR(40),
    FOREIGN KEY (idRol) REFERENCES MaestroDetalle(id),
    FOREIGN KEY (idEmpleado) REFERENCES Empleado(id),
    usuarioRegistro VARCHAR(100) NOT NULL DEFAULT '',
    fechaRegistro DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    usuarioModifica VARCHAR(100) DEFAULT '',
    fechaModifica DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    activo BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE ZonaParking (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    idEstado INT,
    idTipoVehiculo INT,
    FOREIGN KEY (idEstado) REFERENCES MaestroDetalle(id),
    FOREIGN KEY (idTipoVehiculo) REFERENCES MaestroDetalle(id),
    usuarioRegistro VARCHAR(100) NOT NULL DEFAULT '',
    fechaRegistro DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    usuarioModifica VARCHAR(100) DEFAULT '',
    fechaModifica DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    activo BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE Tarifa (
    id VARCHAR(40) PRIMARY KEY,
    nombre VARCHAR(100),
    idTipoVehiculo INT,
    precioBase DECIMAL(10, 2) DEFAULT 0,
    precioAdicional DECIMAL(10, 2)  DEFAULT 0,
    FOREIGN KEY (idTipoVehiculo) REFERENCES MaestroDetalle(id),
    usuarioRegistro VARCHAR(100) NOT NULL DEFAULT '',
    fechaRegistro DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    usuarioModifica VARCHAR(100) DEFAULT '',
    fechaModifica DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    activo BOOLEAN NOT NULL DEFAULT TRUE

);


CREATE TABLE Estacionamiento (
    id VARCHAR(40) PRIMARY KEY,
    idVehiculo VARCHAR(40),
    idZonaParking INT,
    idTarifa VARCHAR(40),
    idEstado INT,
    cantidad INT,
    fechaHoraEntrada DATETIME,
    fechaHoraSalida DATETIME,
    FOREIGN KEY (idVehiculo) REFERENCES Vehiculo(id),
    FOREIGN KEY (idZonaParking) REFERENCES ZonaParking(id),
    FOREIGN KEY (idTarifa) REFERENCES Tarifa(id),
    FOREIGN KEY (idEstado) REFERENCES MaestroDetalle(id),
    usuarioRegistro VARCHAR(100) NOT NULL DEFAULT '',
    fechaRegistro DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    usuarioModifica VARCHAR(100) DEFAULT '',
    fechaModifica DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    activo BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE Comprobante (
    id VARCHAR(40) PRIMARY KEY,
    idEstacionamiento VARCHAR(40),
    numeroComprobante VARCHAR(40),
    tipoTarifa VARCHAR(40),
    zonaParking VARCHAR(40),
    precioBase DECIMAL(10, 2),
    cantidad INT,
    montoTotal DECIMAL(10, 2),
    idMetodoPago INT,
    idEstado INT,
    fechaPago DATETIME NOT NULL,
    FOREIGN KEY (idEstacionamiento) REFERENCES Estacionamiento(id),
    FOREIGN KEY (idMetodoPago) REFERENCES MaestroDetalle(id),
    FOREIGN KEY (idEstado) REFERENCES MaestroDetalle(id),
    usuarioRegistro VARCHAR(100) NOT NULL DEFAULT '',
    fechaRegistro DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    usuarioModifica VARCHAR(100) DEFAULT '',
    fechaModifica DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    activo BOOLEAN NOT NULL DEFAULT TRUE
);

//INSERT
INSERT INTO Maestro (tabla) VALUES ('Tipo Documento');
INSERT INTO Maestro (tabla) VALUES ('Roles');
INSERT INTO Maestro (tabla) VALUES ('TipoVehiculo');
INSERT INTO Maestro (tabla) VALUES ('EstadoZona');
INSERT INTO Maestro (tabla) VALUES ('EstadoEstacionamiento');
INSERT INTO Maestro (tabla) VALUES ('MetodoPago');
INSERT INTO Maestro (tabla) VALUES ('EstadoComprobante');


INSERT INTO MaestroDetalle (idMaestro, valor) VALUES (1, 'DNI');
INSERT INTO MaestroDetalle (idMaestro, valor) VALUES (1, 'CEX');
INSERT INTO MaestroDetalle (idMaestro, valor) VALUES (1, 'PASS');
INSERT INTO MaestroDetalle (idMaestro, valor) VALUES (2, 'Administrador');
INSERT INTO MaestroDetalle (idMaestro, valor) VALUES (2, 'Recepcionista');
INSERT INTO MaestroDetalle (idMaestro, valor) VALUES (3, 'Carro');
INSERT INTO MaestroDetalle (idMaestro, valor) VALUES (3, 'Motocicleta');
INSERT INTO MaestroDetalle (idMaestro, valor) VALUES (4, 'Libre');
INSERT INTO MaestroDetalle (idMaestro, valor) VALUES (4, 'Ocupado');
INSERT INTO MaestroDetalle (idMaestro, valor) VALUES (4, 'En Mantenimiento');
INSERT INTO MaestroDetalle (idMaestro, valor) VALUES (4, 'Fuera de servicio');
INSERT INTO MaestroDetalle (idMaestro, valor) VALUES (5, 'En Curso');
INSERT INTO MaestroDetalle (idMaestro, valor) VALUES (5, 'Finalizado');
INSERT INTO MaestroDetalle (idMaestro, valor) VALUES (6, 'Efectivo');
INSERT INTO MaestroDetalle (idMaestro, valor) VALUES (6, 'Tarjeta');
INSERT INTO MaestroDetalle (idMaestro, valor) VALUES (6, 'Yape/Plin');
INSERT INTO MaestroDetalle (idMaestro, valor) VALUES (7, 'Pendiente');
INSERT INTO MaestroDetalle (idMaestro, valor) VALUES (7, 'Pagado');



INSERT INTO Empleado (
    id,
    nombre,
    apellidos,
    idTipoDocumento,
    documento,
    telefono
) VALUES (
    uuid(),
    'Juan',
    'Pérez Gómez',
    1,
    '12345678',
    '999888777'
);


INSERT INTO Usuario (
    id,
    nombreUsuario,
    contrasenia,
    idRol,
    idEmpleado
) VALUES (
    uuid(),
    'jperez',
    '123456',
    3, 
    (select id from Empleado where documento = '12345678' limit 1)
);

insert into Cliente
(
    id,
    nombre,
    apellidos,
    idTipoDocumento,
    documento
)
VALUES
(
    uuid(),
    'Juan',
    'Ramirez',
    1,
    '98765432'
),
(
    uuid(),
    'Kiara',
    'Lopez',
    2,
    '12345678'
);

INSERT into Tarifa
(
id,
nombre,
idTipoVehiculo,
precioBase,
precioAdicional
)
VALUES
(uuid(),'Hora',6,6.30,8.40),
(uuid(),'Dia',6,24.00,26.50),
(uuid(),'Semanal',6,156.50,178.00),
(uuid(),'Hora',7,3.50,4.00),
(uuid(),'Dia',7,20.50,22.50),
(uuid(),'Semanal',7,135.00,141.50);

insert into ZonaParking
(
	nombre,
    idEstado,
    idTipoVehiculo
)
VALUES
('ZC001', 8, 6),
('ZC002', 8, 6),
('ZC003', 8, 6),
('ZC004', 8, 6),
('ZC005', 8, 6),
('ZC006', 8, 6),
('ZC007', 8, 6),
('ZC008', 8, 6),
('ZC009', 8, 6),
('ZC010', 8, 6),
('ZM001', 8, 7),
('ZM002', 8, 7),
('ZM003', 8, 7),
('ZM004', 8, 7),
('ZM005', 8, 7),
('ZM006', 8, 7),
('ZM007', 8, 7),
('ZM008', 8, 7),
('ZM009', 8, 7),
('ZM010', 8, 7)