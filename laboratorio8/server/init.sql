CREATE DATABASE Empresa;
USE Empresa;

-- Crear la tabla de Departamentos
CREATE TABLE Departamento (
    idDepartamentos INT AUTO_INCREMENT PRIMARY KEY,
    Nombre CHAR(200) NOT NULL,
    Telefono VARCHAR(20),
    Fax VARCHAR(20)
);

-- Crear la tabla de Proyectos
CREATE TABLE Proyecto (
    idProyecto INT AUTO_INCREMENT PRIMARY KEY,
    Nombre CHAR(200) NOT NULL,
    Fec_Inicio DATE NOT NULL,
    Fec_Final DATE,
    idDepartamentos INT,
    FOREIGN KEY (idDepartamentos) REFERENCES Departamento(idDepartamentos)
);

-- Crear la tabla de Ingenieros
CREATE TABLE Ingenieros (
    idIngeniero INT AUTO_INCREMENT PRIMARY KEY,
    Especialidad CHAR(100) NOT NULL,
    Cargo CHAR(120) NOT NULL,
    idProyecto INT,
    FOREIGN KEY (idProyecto) REFERENCES Proyecto(idProyecto)
);

-- Crear índices secundarios para búsquedas rápidas
CREATE INDEX idx_nombre_departamento ON Departamento(Nombre);
CREATE INDEX idx_nombre_proyecto ON Proyecto(Nombre);
CREATE INDEX idx_especialidad_ingeniero ON Ingenieros(Especialidad);

-- Procedimientos almacenados para inserción de datos
DELIMITER //
CREATE PROCEDURE InsertarDepartamento(
    IN p_Nombre CHAR(200),
    IN p_Telefono VARCHAR(20),
    IN p_Fax VARCHAR(20)
)
BEGIN
    INSERT INTO Departamento (Nombre, Telefono, Fax) VALUES (p_Nombre, p_Telefono, p_Fax);
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE InsertarProyecto(
    IN p_Nombre CHAR(200),
    IN p_Fec_Inicio DATE,
    IN p_Fec_Final DATE,
    IN p_idDepartamentos INT
)
BEGIN
    INSERT INTO Proyecto (Nombre, Fec_Inicio, Fec_Final, idDepartamentos) VALUES (p_Nombre, p_Fec_Inicio, p_Fec_Final, p_idDepartamentos);
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE InsertarIngeniero(
    IN p_Especialidad CHAR(100),
    IN p_Cargo CHAR(120),
    IN p_idProyecto INT
)
BEGIN
    INSERT INTO Ingenieros (Especialidad, Cargo, idProyecto) VALUES (p_Especialidad, p_Cargo, p_idProyecto);
END //
DELIMITER ;

-- Procedimiento almacenado para consultar todos los proyectos de un determinado departamento
DELIMITER //
CREATE PROCEDURE ConsultarProyectosPorDepartamento(
    IN p_idDepartamentos INT
)
BEGIN
    SELECT p.idProyecto, p.Nombre, p.Fec_Inicio, p.Fec_Final
    FROM Proyecto p
    WHERE p.idDepartamentos = p_idDepartamentos;
END //
DELIMITER ;

-- Procedimiento almacenado para consultar todos los ingenieros que participan en un determinado proyecto
DELIMITER //
CREATE PROCEDURE ConsultarIngenierosPorProyecto(
    IN p_idProyecto INT
)
BEGIN
    SELECT i.idIngeniero, i.Especialidad, i.Cargo
    FROM Ingenieros i
    WHERE i.idProyecto = p_idProyecto;
END //
DELIMITER ;

-- Restricciones para mantener la consistencia de los datos
ALTER TABLE Proyecto
    ADD CONSTRAINT chk_fechas CHECK (Fec_Final >= Fec_Inicio);
