package com.example.testing.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "pedidos")
class Pedidos(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = false)
    var cliente: Clientes? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "direccion_id", nullable = false)
    var direccionEnvio: DireccionEnvio? = null,

    @Column(name = "fecha_pedido", nullable = false)
    var fechaPedido: LocalDateTime = LocalDateTime.now(),

    @Column(nullable = false) var subtotal: Float = 0.0f,
    @Column(name = "costo_envio", nullable = false) var costoEnvio: Float = 0.0f,
    @Column(nullable = false) var total: Float = 0.0f,
    @Column(name = "estado_envio", nullable = false, length = 30) var estadoEnvio: String = "Pendiente",
    @Column(name = "mp_payment_id", unique = true, length = 50) var mpPaymentId: String? = null,
    @Column(name = "mp_status", nullable = false, length = 30) var mpStatus: String = "pending",
    @Column(name = "mp_payment_type", length = 30) var mpPaymentType: String? = null,
    @Column(name = "mp_merchant_order_id", length = 50) var mpMerchantOrderId: String? = null,
)