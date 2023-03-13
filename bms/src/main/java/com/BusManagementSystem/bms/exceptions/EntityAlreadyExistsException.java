package com.BusManagementSystem.bms.exceptions;

public class EntityAlreadyExistsException extends RuntimeException {

    public EntityAlreadyExistsException(String message){
        super(message);
    }

    public EntityAlreadyExistsException(String message, Object... args){
        super(String.format(message, args));
    }
}
