package com.sefrys.DataStructures.Stack;

import com.sefrys.DataStructures.Exceptions.StackCapacityReachedException;
import com.sefrys.DataStructures.Exceptions.StackUnderflowException;

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
        if(arrayMaxSize <= 0) {
            throw new IllegalArgumentException("Stack maximum size must be greater than 0");
        }

        this.array = (T[]) new Object[arrayMaxSize];
        this.arrayMaxSize = arrayMaxSize;
    }

    public T pop() {
        if(top <= -1) {
            throw new StackUnderflowException("Stack is empty – Cannot pop from empty stack.");
        }

        return array[top--];
    }

    public T peek() {
        if(top <= -1) {
            throw new StackUnderflowException("Stack is empty – Cannot peek empty stack.");
        }

        return array[top];
    }

    public void push(T element) {
        if(isFull()) {
            throw new StackCapacityReachedException("Stack is full with capacity " + arrayMaxSize + " of " + arrayCurrentCapacity);
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
