package com.example.testing.exception

class RecursoNoEncontradoException(recurso: String, id: Any) :
    RuntimeException("$recurso no encontrado con el ID: $id")