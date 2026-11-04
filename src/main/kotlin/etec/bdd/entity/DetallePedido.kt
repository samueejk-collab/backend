package etec.bdd.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "detallePedido")
open class DetallePedido(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pedido_id", nullable = false)
    var pedido: Pedidos? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "variante_id", nullable = false)
    var variante: Producto? = null,

    @Column(nullable = false)
    var cantidad: Int = 0,

    @Column(name = "precio_historico", nullable = false)
    var precioHistorico: Float = 0.0f
) {
    constructor() : this(null, null, null, 0, 0.0f)
}
