package com.sefrys.DataStructures.Queue;

import com.sefrys.DataStructures.Exceptions.QueueUnderflowException;

/**
 * Created by Ireneusz Zagan on 15.05.18, 16:30
 * Contact: sefrys@gmail.com
 */
public class NodeQueue<T> implements Queue<T> {


    private Node<T> head;
    private Node<T> tail;

    public NodeQueue() {
        head = null;
        tail = null;

    }

    @Override
    public T dequeue() {
        if(isEmpty()){
           throw new QueueUnderflowException("Empty queue");
        }
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
        if(isEmpty()){
            throw new QueueUnderflowException("Empty queue");
        }
        return head.getData();
    }

    T peekLast() {
        if(isEmpty()){
            throw new QueueUnderflowException("Empty queue");
        }
        return tail.getData();
    }

    public boolean isEmpty() {
        return head == null;
    }
}
