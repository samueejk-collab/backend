package etec.bdd.repository

import etec.bdd.entity.Clientes
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ClientesRepository : JpaRepository<Clientes, Long>