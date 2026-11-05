package etec.bdd.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "direccion_envio")
class DireccionEnvio(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column(nullable = false, length = 100)
    var calle: String = "",

    @Column(nullable = false, length = 20)
    var numero: String = "",

    @Column(name = "piso_depto", length = 20)
    var pisoDepto: String? = null,

    @Column(nullable = false, length = 100)
    var barrio: String = "",

    @Column(nullable = false, length = 50)
    var ciudad: String = "",

    @Column(nullable = false, length = 50)
    var provincia: String = "",

    @Column(name = "codigo_postal", nullable = false, length = 20)
    var codigoPostal: String = ""
)