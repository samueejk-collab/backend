package com.example.testing.repository

import com.example.testing.entity.Producto
import org.springframework.data.jpa.repository.JpaRepository

interface ProductoRepository : JpaRepository<Producto, Long>