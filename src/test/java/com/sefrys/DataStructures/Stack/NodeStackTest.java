package com.sefrys.DataStructures.Stack;

import com.sefrys.DataStructures.Exceptions.StackCapacityReachedException;
import com.sefrys.DataStructures.Exceptions.StackUnderflowException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Ireneusz Zagan on 15.05.18, 12:18
 * Contact: sefrys@gmail.com
 */
class NodeStackTest {

    @Test
    void testNodeStackPush() {
        NodeStack<String> stack = new NodeStack<>(10);

        stack.push("Mitch");
        stack.push("Tom");
        stack.push("Bob");
    }

    @Test
    void testNodeStackPeek() {
        NodeStack<String> stack = new NodeStack<>(10);

        stack.push("Mitch");
        stack.push("Tom");
        stack.push("Bob");

        assertEquals("Bob", stack.peek());
    }

    @Test
    void testNodeStackPop() {
        NodeStack<String> stack = new NodeStack<>(10);

        stack.push("Mitch");
        stack.push("Tom");
        stack.pop();

        assertEquals("Mitch", stack.pop());

    }

    @Test
    void testNodeStackPushWhenFull() {
        NodeStack<String> stack = new NodeStack<>(1);

        stack.push("Mitch");

        assertThrows(StackCapacityReachedException.class, () -> stack.push("Tim"));

    }

    @Test
    void testNodePeekWhenEmpty() {
        NodeStack<String> stack = new NodeStack<>(1);

        assertThrows(StackUnderflowException.class, stack::peek);
    }

    @Test
    void testNodePopWhenEmpty() {
        NodeStack<String> stack = new NodeStack<>(1);

        assertThrows(StackUnderflowException.class, stack::pop);
    }

    @Test
    void testGetStackMaxSize() {
        NodeStack<String> stack = new NodeStack<>(10);

        assertEquals(10, stack.stackMaxSize());
    }

    @Test
    void testGetRemainingStackCapacity() {
        NodeStack<String> stack = new NodeStack<>(10);

        stack.push("Bob");
        stack.push("Tom");
        assertEquals(8, stack.remainingSize());
    }

    @Test
    void testCreateStackWithNegativeMaxSize() {
        assertThrows(IllegalArgumentException.class, () -> new NodeStack<>(-1));
        assertThrows(IllegalArgumentException.class, () -> new NodeStack<>(0));
    }
}


