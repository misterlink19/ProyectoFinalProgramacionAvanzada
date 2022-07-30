package edu.programacionavanzada.amlemartinez.ProyectoFinal.patterns.saga.model;

public interface SagaStepCompensator<T> {

    void handle(SagaPayload<T> sagaPayload);
}
