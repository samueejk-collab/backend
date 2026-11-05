package com.example.testing.repository

import com.example.testing.entity.Clientes

@Repository
interface ClientesRepository : JpaRepository<Clientes, Long>