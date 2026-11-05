package com.example.testing.repository

import com.example.testing.entity.Categorias
import org.springframework.data.jpa.repository.JpaRepository

interface CategoriasRepository : JpaRepository<Categorias, Int>