package com.sefrys.DataStructures.Exceptions;

/**
 * Created by Ireneusz Zagan on 15.05.18, 15:21
 * Contact: sefrys@gmail.com
 */
public class QueueUnderflowException extends RuntimeException {

    public QueueUnderflowException() {
    }

    public QueueUnderflowException(String message) {
        super(message);
    }
}
