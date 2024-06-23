-- Borrar la base de datos si ya existe
DROP DATABASE IF EXISTS prueba;

-- Crear la base de datos
CREATE DATABASE prueba;

-- Usar la base de datos recién creada
USE prueba;

CREATE TABLE RESERVAS (
    id INT AUTO_INCREMENT PRIMARY KEY,
    pasajero VARCHAR(50) NOT NULL,
    origen VARCHAR(50) NOT NULL,
    destino VARCHAR(50) NOT NULL
);



