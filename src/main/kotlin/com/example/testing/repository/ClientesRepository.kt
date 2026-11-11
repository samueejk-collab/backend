package com.example.testing.repository

import com.example.testing.entity.Clientes
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ClientesRepository : JpaRepository<Clientes, Int>