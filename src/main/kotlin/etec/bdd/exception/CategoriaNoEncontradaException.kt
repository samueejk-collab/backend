package etec.bdd.exception

class RecursoNoEncontradoException(recurso: String, id: Any) :
    RuntimeException("$recurso no encontrado con el ID: $id")