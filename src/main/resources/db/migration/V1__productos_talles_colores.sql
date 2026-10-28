CREATE TABLE IF NOT EXISTS productos_talles_colores (
    id INT AUTO_INCREMENT PRIMARY KEY,
    producto_id INT NOT NULL,
    talle VARCHAR(10) NOT NULL,
    color VARCHAR(30) NOT NULL,
    stock INT NOT NULL DEFAULT 0,
    CONSTRAINT fk_variante_producto FOREIGN KEY (producto_id) REFERENCES productos(id)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;