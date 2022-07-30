package edu.programacionavanzada.amlemartinez.ProyectoFinal.patterns.command;

public interface CommandHandler<R, C extends Command<R>> {

    R handle(C command);
}
