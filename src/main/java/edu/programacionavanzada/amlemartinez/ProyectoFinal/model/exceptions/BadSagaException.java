package edu.programacionavanzada.amlemartinez.ProyectoFinal.model.exceptions;


public class BadSagaException extends RuntimeException {

    public BadSagaException() {
        super("Mi Saga explotó BUM!");
    }
}
