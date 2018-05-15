package com.sefrys.DataStructures.Stack;

/**
 * Created by Ireneusz Zagan on 15.05.18, 10:41
 * Contact: sefrys@gmail.com
 */
class StackArray<T> {

    private T[] array;
    private int arrayMaxSize;
    private int arrayCurrentCapacity = 0;
    private int top = -1;

    @SuppressWarnings("unchecked")
    public StackArray(int arrayMaxSize) {
        this.array = (T[]) new Object[arrayMaxSize];
        this.arrayMaxSize = arrayMaxSize;
    }

    void push(T element) {
        array[++top] = element;
        arrayCurrentCapacity++;
    }

    public int getRemainingSpace() {
        return arrayMaxSize - arrayCurrentCapacity;
    }
}
