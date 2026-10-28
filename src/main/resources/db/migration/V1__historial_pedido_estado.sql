CREATE TABLE IF NOT EXISTS historial_pedido_estado (
    id_historial INT AUTO_INCREMENT PRIMARY KEY,
    id_pedido INT NOT NULL,
    estado VARCHAR(50) NOT NULL,
    fecha_cambio DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_historial_pedido FOREIGN KEY (id_pedido) REFERENCES pedidos(id)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;