package com.sefrys.DataStructures.Stack;

import com.sefrys.DataStructures.Exceptions.StackCapacityReachedException;
import com.sefrys.DataStructures.Exceptions.StackUnderflowException;

/**
 * Created by Ireneusz Zagan on 15.05.18, 12:21
 * Contact: sefrys@gmail.com
 */
public class NodeStack<T> implements Stack<T> {

    private final int stackMaxSize;
    private int stackCurrentCapacity;
    private Node<T> top = null;

    public NodeStack(int stackMaxSize) {
        if (stackMaxSize <= 0) {
            throw new IllegalArgumentException("Cannot create a stack with 0 or less capacity");
        }
        this.stackMaxSize = stackMaxSize;
    }

    @Override
    public T pop() {
        if (stackCurrentCapacity <= 0) {
            throw new StackUnderflowException("Stack is empty");
        }
        T data = top.getData();
        top = top.getNextNode();

        return data;
    }

    @Override
    public T peek() {
        if (stackCurrentCapacity <= 0) {
            throw new StackUnderflowException("Stack is empty");
        }
        return top.getData();
    }

    @Override
    public void push(T element) {
        if (stackMaxSize <= stackCurrentCapacity) {
            throw new StackCapacityReachedException("Stack is full with capacity " + stackMaxSize + " of " + stackCurrentCapacity);
        }
        Node<T> elem = new Node<>(element);
        elem.setNextNode(top);

        top = elem;
        stackCurrentCapacity++;

    }

    public int stackMaxSize() {
        return stackMaxSize;
    }

    public int remainingSize() {
        return stackMaxSize - stackCurrentCapacity;
    }
}
