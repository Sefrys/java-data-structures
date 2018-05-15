package com.sefrys.DataStructures.Exceptions;

/**
 * Created by Ireneusz Zagan on 15.05.18, 11:23
 * Contact: sefrys@gmail.com
 */
public class StackUnderflowException extends RuntimeException {

    public StackUnderflowException() {}

    public StackUnderflowException(String message) {
        super(message);
    }
}
