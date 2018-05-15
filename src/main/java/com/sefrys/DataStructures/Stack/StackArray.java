package com.sefrys.DataStructures.Stack;

import com.sefrys.DataStructures.Exceptions.StackCapacityReachedException;

/**
 * Created by Ireneusz Zagan on 15.05.18, 10:41
 * Contact: sefrys@gmail.com
 */
class StackArray<T> implements Stack<T>{

    private T[] array;
    private int arrayMaxSize;
    private int arrayCurrentCapacity = 0;
    private int top = -1;

    @SuppressWarnings("unchecked")
    StackArray(int arrayMaxSize) {
        this.array = (T[]) new Object[arrayMaxSize];
        this.arrayMaxSize = arrayMaxSize;
    }

    public T pop() {
        return null;
    }

    public T peek() {
        return null;
    }

    public void push(T element) {
        if(isFull()) {
            throw new StackCapacityReachedException();
        }
        array[++top] = element;
        arrayCurrentCapacity++;
    }

    private boolean isFull() {
        return arrayCurrentCapacity >= arrayMaxSize;
    }

    int getRemainingSpace() {
        return arrayMaxSize - arrayCurrentCapacity;
    }

}
