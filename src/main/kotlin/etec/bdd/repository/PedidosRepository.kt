package etec.bdd.repository

import etec.bdd.entity.Pedidos
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PedidosRepository : JpaRepository<Pedidos, Long>