package com.example.testing.repository

import com.example.testing.entity.Categorias

@Repository
interface CategoriasRepository : JpaRepository<Categorias, Int>