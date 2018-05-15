package com.sefrys.DataStructures.Queue;

import com.sefrys.DataStructures.Exceptions.QueueUnderflowException;

/**
 * Created by Ireneusz Zagan on 15.05.18, 16:30
 * Contact: sefrys@gmail.com
 */
public class NodeQueue<T> implements Queue<T> {


    private Node<T> head;
    private Node<T> tail;

    NodeQueue() {
        head = null;
        tail = null;

    }

    @Override
    public T dequeue() {
        isEmpty();
        T element = head.getData();
        head = head.getNext();
        return element;
    }

    @Override
    public void enqueue(T element) {

        Node<T> current = tail;
        tail = new Node<>(element);
        tail.setData(element);

        if (head == null) {
            head = tail;
        } else {
            current.setNext(tail);
        }
    }

    T peekFirst() {
        isEmpty();
        return head.getData();
    }

    T peekLast() {
        isEmpty();
        return tail.getData();
    }

    private void isEmpty() {
        if (head == null) {
            throw new QueueUnderflowException("Empty queue");
        }
    }
}
