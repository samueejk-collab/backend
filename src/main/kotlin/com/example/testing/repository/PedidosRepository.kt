package com.example.testing.repository

import com.example.testing.entity.Pedidos

@Repository
interface PedidosRepository : JpaRepository<Pedidos, Int>