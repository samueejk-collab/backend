
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "clientes")
class Clientes(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    var idCliente: Long? = null,

    @Column(name = "nombre_cliente", nullable = false, length = 100)
    var nombreCliente: String = "",

    @Column(nullable = false, length = 100)
    var telefono: String = "",

    @Column(nullable = false, unique = true, length = 100)
    var correo: String = "",

    @Column(nullable = false, length = 100)
    var fecha: String = ""
)