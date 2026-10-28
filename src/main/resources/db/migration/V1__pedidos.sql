CREATE TABLE IF NOT EXISTS pedidos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cliente_id INT NOT NULL,
    direccion_id INT NOT NULL,
    fecha_pedido DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    subtotal FLOAT NOT NULL,
    costo_envio FLOAT NOT NULL DEFAULT 0.0,
    total FLOAT NOT NULL,
    estado_envio VARCHAR(30) NOT NULL DEFAULT 'Pendiente',
    mp_payment_id VARCHAR(50) UNIQUE DEFAULT NULL,
    mp_status VARCHAR(30) NOT NULL DEFAULT 'pending',
    mp_payment_type VARCHAR(30) DEFAULT NULL,
    mp_merchant_order_id VARCHAR(50) DEFAULT NULL,
    CONSTRAINT fk_pedido_cliente FOREIGN KEY (cliente_id) REFERENCES clientes(id_cliente),
    CONSTRAINT fk_pedido_direccion FOREIGN KEY (direccion_id) REFERENCES direccion_envio(id)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;