package com.sefrys.DataStructures.Queue;

/**
 * Created by Ireneusz Zagan on 15.05.18, 14:45
 * Contact: sefrys@gmail.com
 */
class Node<T> {
    private T data;
    private Node<T> next;

    Node(T data) {
        this.data = data;

    }

    T getData() {
        return data;
    }

    void setData(T data) {
        this.data = data;
    }

    Node<T> getNext() {
        return next;
    }

    void setNext(Node<T> next) {
        this.next = next;
    }
}
