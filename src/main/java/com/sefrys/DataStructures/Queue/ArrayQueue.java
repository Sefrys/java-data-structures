package com.sefrys.DataStructures.Queue;

import com.sefrys.DataStructures.Exceptions.QueueUnderflowException;

import java.util.Arrays;

/**
 * Created by Ireneusz Zagan on 15.05.18, 13:13
 * Contact: sefrys@gmail.com
 */
public class ArrayQueue<T> implements Queue<T> {

    private T[] array;
    private int tailPosition;
    private int headPosition;


    @SuppressWarnings("unchecked")
    public ArrayQueue() {
        array =  (T[]) new Object[2];
        tailPosition = -1;
        headPosition = 0;
    }

    @Override
    public T dequeue() {
        isEmpty();
        return array[headPosition++];
    }

    @Override
    public void enqueue(T object) {
        if(isFull()) expand();
        array[++tailPosition] = object;
    }

    @SuppressWarnings("unchecked")
    private void expand() {
        T[] expandedArray = (T[]) new Object[array.length * 2];
        System.arraycopy(array, 0, expandedArray, 0, array.length);
        tailPosition = array.length - 1;
        headPosition = 0;

        array = expandedArray;
    }

    private boolean isFull() {
        return tailPosition == array.length -1;
    }

    public T peekFirst() {
        isEmpty();
        return array[headPosition];
    }

    public T peekLast() {
        isEmpty();
        return array[tailPosition];
    }

    private void isEmpty() {
        if(tailPosition == -1 || headPosition > tailPosition) {
            throw new QueueUnderflowException("Queue is empty");
        }

    }
}
