package com.example.testing.repository

import com.example.testing.entity.Clientes
import org.springframework.data.jpa.repository.JpaRepository

interface ClientesRepository : JpaRepository<Clientes, Int>