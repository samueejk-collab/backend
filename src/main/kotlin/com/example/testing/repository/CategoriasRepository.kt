package com.example.testing.repository

import com.example.testing.entity.Categorias
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

interface CategoriasRepository : JpaRepository<Categorias, Int>