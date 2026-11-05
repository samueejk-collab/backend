package com.example.testing.repository

import com.example.testing.entity.Pedidos
import org.springframework.data.jpa.repository.JpaRepository

interface PedidosRepository : JpaRepository<Pedidos, Int>