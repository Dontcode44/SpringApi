package com.Api.apiSpring.Errors;

public class RepeatFoundException extends RuntimeException{
    public RepeatFoundException(Long id) {
        super("El usuario con identificación " + id + " ya tiene una cita agendada, " +
                "por lo cual no podrá realizar más agendamientos");
    }
}
