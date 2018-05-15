package com.sefrys.DataStructures.Stack;

/**
 * Created by Ireneusz Zagan on 15.05.18, 12:13
 * Contact: sefrys@gmail.com
 */
class Node<T> {
    private T data;
    private Node<T> nextNode;

    Node(T data) {
        this.data = data;
    }

    public Node<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
    }

    public T getData() {
        return data;
    }
}
