package com.sefrys.DataStructures.Queue;

import com.sefrys.DataStructures.Exceptions.QueueUnderflowException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Ireneusz Zagan on 15.05.18, 16:14
 * Contact: sefrys@gmail.com
 */
class NodeQueueTest {

    @Test
    void testNodeQueueEnqueue() {
        NodeQueue<String> queue = new NodeQueue<>();

        queue.enqueue("Mitch");
        queue.enqueue("Bob");
        queue.enqueue("Tim");
        assertEquals("Mitch", queue.peekFirst());
    }

    @Test
    void testNodeQueueDequeue() {
        NodeQueue<String> queue = new NodeQueue<>();

        queue.enqueue("Mitch");
        queue.enqueue("Tim");
        assertEquals("Mitch", queue.dequeue());
        assertEquals("Tim", queue.dequeue());

    }

    @Test
    void testNodeQueuePeekFirst() {
        NodeQueue<String> queue = new NodeQueue<>();

        queue.enqueue("Mitch");
        queue.enqueue("Tim");
        queue.enqueue("Bob");

        assertEquals("Mitch", queue.peekFirst());
    }
    @Test
    void testNodeQueuePeekLast() {
        NodeQueue<String> queue = new NodeQueue<>();

        queue.enqueue("Mitch");
        queue.enqueue("Tim");
        queue.enqueue("Bob");

        assertEquals("Bob", queue.peekLast());
    }

    @Test
    void testNodeQueueDequeueEmpty() {
        NodeQueue<String> queue = new NodeQueue<>();

        assertThrows(QueueUnderflowException.class, queue::dequeue);
    }

    @Test
    void testNodeQueuePeekFirstEmpty() {
        NodeQueue<String> queue = new NodeQueue<>();

        assertThrows(QueueUnderflowException.class, queue::peekFirst);
    }

    @Test
    void testNodeQueuePeekLastEmpty() {
        NodeQueue<String> queue = new NodeQueue<>();

        assertThrows(QueueUnderflowException.class, queue::peekLast);
    }

    @Test
    void testNodeQueueOverDequeueFilledQueue() {
        NodeQueue<String> queue = new NodeQueue<>();

        queue.enqueue("Tom");
        queue.enqueue("Bob");

        queue.dequeue();
        queue.dequeue();
        assertThrows(QueueUnderflowException.class, queue::dequeue);
    }

    @Test
    void testNodeQueueOverPeekFirstFilledQueue() {
        NodeQueue<String> queue = new NodeQueue<>();

        queue.enqueue("Mitch");
        queue.enqueue("Bob");

        queue.dequeue();
        queue.dequeue();
        assertThrows(QueueUnderflowException.class, queue::peekFirst);
    }

    @Test
    void testNodeQueueOverPeekLastFilledQueue() {
        NodeQueue<String> queue = new NodeQueue<>();

        queue.enqueue("Mike");
        queue.enqueue("Bob");

        queue.dequeue();
        queue.dequeue();
        assertThrows(QueueUnderflowException.class, queue::peekLast);
    }
}
