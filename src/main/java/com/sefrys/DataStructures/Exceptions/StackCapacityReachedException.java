package com.sefrys.DataStructures.Exceptions;

/**
 * Created by Ireneusz Zagan on 15.05.18, 11:09
 * Contact: sefrys@gmail.com
 */
public class StackCapacityReachedException extends RuntimeException {

    public StackCapacityReachedException() {}

    public StackCapacityReachedException(String message) {
        super(message);
    }
}
