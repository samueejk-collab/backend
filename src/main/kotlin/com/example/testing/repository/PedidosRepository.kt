package com.example.testing.repository

import com.example.testing.entity.Pedidos
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
interface PedidosRepository : JpaRepository<Pedidos, Int>