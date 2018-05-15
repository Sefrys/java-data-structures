package com.sefrys.DataStructures.Stack;

/**
 * Created by Ireneusz Zagan on 15.05.18, 12:13
 * Contact: sefrys@gmail.com
 */
class StackNode<T> {
    private T data;
    private StackNode<T> nextNode;

    StackNode(T data) {
        this.data = data;
    }

    public StackNode<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(StackNode<T> nextNode) {
        this.nextNode = nextNode;
    }

    public T getData() {
        return data;
    }
}
