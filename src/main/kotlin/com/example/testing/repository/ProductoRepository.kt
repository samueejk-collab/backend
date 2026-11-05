package com.example.testing.repository

import com.example.testing.entity.Producto

@Repository
interface ProductoRepository : JpaRepository<Producto, Int>