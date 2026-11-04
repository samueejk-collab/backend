package etec.bdd.repository

import etec.bdd.entity.Categorias
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoriasRepository : JpaRepository<Categorias, Int>
