-- se crea el esquema primero
CREATE SCHEMA `melitest` ;


-- se crea la tabla bicicleta
CREATE TABLE registros(
	rid int AUTO_INCREMENT PRIMARY KEY,
    rtipo int,
    rdna varchar
);

-- se crea usuario y contraseña
CREATE USER 'melitest'@'localhost' IDENTIFIED BY 'admin';

-- se se le garantiza los privilegios al usuario creado en cuestion
GRANT ALL PRIVILEGES ON * . * TO 'melitest'@'localhost';