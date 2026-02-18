CREATE DATABASE IF NOT EXISTS salud;

CREATE USER IF NOT EXISTS 'usuario2'@'%' IDENTIFIED BY 'usuario';

GRANT ALL PRIVILEGES ON salud.* TO 'usuario2'@'%';

FLUSH PRIVILEGES;

CREATE TABLE salud.paciente (
    id_paciente BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    dni VARCHAR(10) UNIQUE NOT NULL
);
INSERT INTO salud.paciente (nombre, dni) VALUES 
('Juan Pérez', '12345678A'),
('María López', '23456789B'),
('Carlos Sánchez', '34567890C'),
('Ana González', '45678901D'),
('Pedro Martínez', '56789012E');
INSERT INTO salud.pacientes (nombre, dni) VALUES 
('Juan Pérez', '12345678A'),
('María López', '23456789B'),
('Carlos Sánchez', '34567890C'),
('Ana González', '45678901D'),
('Pedro Martínez', '56789012E');