package com.sefrys.DataStructures.Queue;

import com.sefrys.DataStructures.Exceptions.QueueUnderflowException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Ireneusz Zagan on 15.05.18, 13:11
 * Contact: sefrys@gmail.com
 */
class ArrayQueueTest {

    @Test
    void testArrayQueueEnqueue() {
        ArrayQueue<String> queue = new ArrayQueue<>();

        queue.enqueue("Mitch");
        queue.enqueue("Tom");
        queue.enqueue("Bob");
        queue.enqueue("Mike");
        queue.enqueue("Mike");

        assertEquals("Mitch", queue.peekFirst());
    }

    @Test
    void testArrayQueuePeekFirst() {
        ArrayQueue<String> queue = new ArrayQueue<>();

        queue.enqueue("Mitch");
        queue.enqueue("Tom");
        queue.enqueue("Bob");
        queue.enqueue("Mike");

        assertEquals("Mitch", queue.peekFirst());
    }

    @Test
    void testArrayQueuePeekLast() {
        ArrayQueue<String> queue = new ArrayQueue<>();

        queue.enqueue("Mitch");
        queue.enqueue("Tom");
        queue.enqueue("Bob");
        queue.enqueue("Mike");

        assertEquals("Mike", queue.peekLast());
    }

    @Test
    void testArrayQueueDequeue() {
        ArrayQueue<String> queue = new ArrayQueue<>();

        queue.enqueue("Mitch");
        queue.enqueue("Tom");

        assertEquals("Mitch", queue.dequeue());

    }

    @Test
    void testArrayDequeueEmpty() {
        ArrayQueue<String> queue = new ArrayQueue<>();

        queue.enqueue("Mitch");
        queue.enqueue("Tom");
        queue.enqueue("Bob");
        queue.enqueue("Mike");

        assertEquals("Mitch", queue.dequeue());
        assertEquals("Tom", queue.dequeue());
        assertEquals("Bob", queue.dequeue());
        assertEquals("Mike", queue.dequeue());
        assertThrows(QueueUnderflowException.class, queue::dequeue);
    }

    @Test
    void testArrayDequeuePeekEmpty() {
        ArrayQueue<String> queue = new ArrayQueue<>();

        queue.enqueue("Mitch");
        queue.enqueue("Tom");
        queue.enqueue("Bob");
        queue.enqueue("Mike");

        assertEquals("Mitch", queue.dequeue());
        assertEquals("Tom", queue.dequeue());
        assertEquals("Bob", queue.dequeue());
        assertEquals("Mike", queue.dequeue());
        assertThrows(QueueUnderflowException.class, queue::peekFirst);
        assertThrows(QueueUnderflowException.class, queue::peekLast);

    }
}
