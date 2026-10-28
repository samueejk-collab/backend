CREATE TABLE IF NOT EXISTS detalles_pedidos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    pedido_id INT NOT NULL,
    variante_id INT NOT NULL,
    cantidad INT NOT NULL,
    precio_historico FLOAT NOT NULL,
    CONSTRAINT fk_detalle_pedido FOREIGN KEY (pedido_id) REFERENCES pedidos(id),
    CONSTRAINT fk_detalle_variante FOREIGN KEY (variante_id) REFERENCES productos_talles_colores(id)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;