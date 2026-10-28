CREATE TABLE IF NOT EXISTS productos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(120) NOT NULL,
    descripcion VARCHAR(255),
    precio DECIMAL(10,2) NOT NULL,
    stock INT NOT NULL DEFAULT 0,
    categoria_id INT NOT NULL,
    activo BOOLEAN DEFAULT TRUE,

    CONSTRAINT fk_categoria
    FOREIGN KEY (categoria_id)
    REFERENCES categorias(id)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
