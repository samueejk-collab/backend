package com.example.testing.repository

import com.example.testing.entity.DireccionEnvio
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DireccionEnvioRepository : JpaRepository<DireccionEnvio, Int>