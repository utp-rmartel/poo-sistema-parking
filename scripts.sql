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
    tipo VARCHAR(50),
    marca VARCHAR(50),
    modelo VARCHAR(50),
    color VARCHAR(30),
    idCliente VARCHAR(40),
    FOREIGN KEY (idCliente) REFERENCES Cliente(id),
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
    nombreZona VARCHAR(100),
    descripcion TEXT,
    idEstado INT,
    FOREIGN KEY (idEstado) REFERENCES MaestroDetalle(id),
    idTipoZona INT,
    FOREIGN KEY (idTipoZona) REFERENCES MaestroDetalle(id),
    usuarioRegistro VARCHAR(100) NOT NULL DEFAULT '',
    fechaRegistro DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    usuarioModifica VARCHAR(100) DEFAULT '',
    fechaModifica DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    activo BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE Tarifa (
    id INT PRIMARY KEY,
    nombre VARCHAR(100),
    idTipoZona INT,
    FOREIGN KEY (idTipoZona) REFERENCES MaestroDetalle(id),
    idTipoVehiculo INT,
    FOREIGN KEY (idTipoVehiculo) REFERENCES MaestroDetalle(id),
    usuarioRegistro VARCHAR(100) NOT NULL DEFAULT '',
    fechaRegistro DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    usuarioModifica VARCHAR(100) DEFAULT '',
    fechaModifica DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    activo BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE TarifaPrecio (
    id VARCHAR(40) PRIMARY KEY,
    idTarifa INT,
    FOREIGN KEY (idTarifa) REFERENCES Tarifa(id),
    idTipoZona INT,
    FOREIGN KEY (idTipoZona) REFERENCES MaestroDetalle(id),
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
    fechaHoraIngreso DATETIME,
    fechaHoraSalida DATETIME,
    idVehiculo VARCHAR(40),
    idZonaParking INT,
    idTarifaPrecio VARCHAR(40),
    idEstado INT,
    cantidad INT,
    FOREIGN KEY (idVehiculo) REFERENCES Vehiculo(id),
    FOREIGN KEY (idZonaParking) REFERENCES ZonaParking(id),
    FOREIGN KEY (idTarifaPrecio) REFERENCES TarifaPrecio(id),
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
    tipoTarifa VARCHAR(40),
    zonaParking VARCHAR(40),
    tipoZona VARCHAR(40),
    precionBase DECIMAL(10, 2),
    precionAdicional DECIMAL(10, 2),
    montoTotal DECIMAL(10, 2),
    idMetodoPago INT,
    FOREIGN KEY (idMetodoPago) REFERENCES MaestroDetalle(id),
    fechaPago DATETIME NOT NULL,
    usuarioRegistro VARCHAR(100) NOT NULL DEFAULT '',
    fechaRegistro DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    usuarioModifica VARCHAR(100) DEFAULT '',
    fechaModifica DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    activo BOOLEAN NOT NULL DEFAULT TRUE
);
