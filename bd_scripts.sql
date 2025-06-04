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
    FOREIGN KEY (idTipoDocumento) REFERENCES MaestroDetalle(id),
    documento VARCHAR(20) UNIQUE,
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
    FOREIGN KEY (idCliente) REFERENCES Cliente(id),
    idTipoVehiculo INT,
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
    FOREIGN KEY (idTipoDocumento) REFERENCES MaestroDetalle(id),
    documento VARCHAR(20) UNIQUE,
    telefono VARCHAR(20),
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
    FOREIGN KEY (idRol) REFERENCES MaestroDetalle(id),
    idEmpleado VARCHAR(40),
    FOREIGN KEY (idEmpleado) REFERENCES Empleado(id),
    usuarioRegistro VARCHAR(100) NOT NULL DEFAULT '',
    fechaRegistro DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    usuarioModifica VARCHAR(100) DEFAULT '',
    fechaModifica DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    activo BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE ZonaParking (
    id INT PRIMARY KEY,
    nombre VARCHAR(100),
    idEstado INT,
    FOREIGN KEY (idEstado) REFERENCES MaestroDetalle(id),
    idTipoVehiculo INT,
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
    FOREIGN KEY (idTipoVehiculo) REFERENCES MaestroDetalle(id),
    precioBase DECIMAL(10, 2) DEFAULT 0,
    precioAdicional DECIMAL(10, 2)  DEFAULT 0,
    usuarioRegistro VARCHAR(100) NOT NULL DEFAULT '',
    fechaRegistro DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    usuarioModifica VARCHAR(100) DEFAULT '',
    fechaModifica DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    activo BOOLEAN NOT NULL DEFAULT TRUE

);


CREATE TABLE Estacionamiento (
    id VARCHAR(40) PRIMARY KEY,
    fechaHoraEntrada DATETIME,
    fechaHoraSalida DATETIME,
    idVehiculo VARCHAR(40),
    idZonaParking INT,
    idTarifa VARCHAR(40),
    idEstado INT,
    cantidad INT,
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
    FOREIGN KEY (idEstacionamiento) REFERENCES Estacionamiento(id),
    numeroComprobante VARCHAR(40),
    tipoTarifa VARCHAR(40),
    zonaParking VARCHAR(40),
    precionBase DECIMAL(10, 2),
    precionAdicional DECIMAL(10, 2),
    montoTotal DECIMAL(10, 2),
    idMetodoPago INT,
    FOREIGN KEY (idMetodoPago) REFERENCES MaestroDetalle(id),
    idEstado INT,
    FOREIGN KEY (idEstado) REFERENCES MaestroDetalle(id),
    fechaPago DATETIME NOT NULL,
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
INSERT INTO MaestroDetalle (idMaestro, valor) VALUES (3, 'CARRO');
INSERT INTO MaestroDetalle (idMaestro, valor) VALUES (3, 'MOTOCICLETA');
INSERT INTO MaestroDetalle (idMaestro, valor) VALUES (4, 'LIBRE');
INSERT INTO MaestroDetalle (idMaestro, valor) VALUES (4, 'OCUPADO');
INSERT INTO MaestroDetalle (idMaestro, valor) VALUES (4, 'EN MANTENIMIENTO');
INSERT INTO MaestroDetalle (idMaestro, valor) VALUES (4, 'FUERA DE SERVICIO');
INSERT INTO MaestroDetalle (idMaestro, valor) VALUES (5, 'EN CURSO');
INSERT INTO MaestroDetalle (idMaestro, valor) VALUES (5, 'FINALIZADO');
INSERT INTO MaestroDetalle (idMaestro, valor) VALUES (6, 'EFECTVO');
INSERT INTO MaestroDetalle (idMaestro, valor) VALUES (6, 'TARJETA');
INSERT INTO MaestroDetalle (idMaestro, valor) VALUES (6, 'YAPE/PLIN');
INSERT INTO MaestroDetalle (idMaestro, valor) VALUES (7, 'PENDIENTE');
INSERT INTO MaestroDetalle (idMaestro, valor) VALUES (7, 'PAGADO');



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
)

