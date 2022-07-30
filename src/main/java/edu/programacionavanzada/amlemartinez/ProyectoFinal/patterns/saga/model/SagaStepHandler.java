package edu.programacionavanzada.amlemartinez.ProyectoFinal.patterns.saga.model;

public interface SagaStepHandler<T> {

    void handle(SagaPayload<T> sagaPayload);
}
