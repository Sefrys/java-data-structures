package com.sefrys.DataStructures.Stack;

/**
 * Created by Ireneusz Zagan on 15.05.18, 10:41
 * Contact: sefrys@gmail.com
 */
class StackArray<T> {

    private T[] array;

    @SuppressWarnings("unchecked")
    public StackArray(int arrayMaxSize) {
        this.array = (T[]) new Object[arrayMaxSize];
    }

    void push(T element) {

    }
}
