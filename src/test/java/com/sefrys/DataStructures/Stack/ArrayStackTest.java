package com.sefrys.DataStructures.Stack;

import com.sefrys.DataStructures.Exceptions.StackCapacityReachedException;
import com.sefrys.DataStructures.Exceptions.StackUnderflowException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Ireneusz Zagan on 15.05.18, 10:42
 * Contact: sefrys@gmail.com
 */
class StackArrayTest {

    @Test
    void testStackArrayPush() {
        ArrayStack<String> stack = new ArrayStack<>(10);

        stack.push("Test_1");
        stack.push("Test_2");

        assertEquals("Test_2", stack.peek());
    }

    @Test
    void testGetRemainingSpace() {
        ArrayStack<String> stack = new ArrayStack<>(10);


        stack.push("Test_1");
        stack.push("Test_2");

        assertEquals(8, stack.getRemainingSpace());
    }

    @Test
    void testPushToFullStack() {
        ArrayStack<String> stack = new ArrayStack<>(1);

        stack.push("Test_1");

        assertThrows(StackCapacityReachedException.class, () -> stack.push("Test_2"));

    }

    @Test
    void testPopFromStack() {
        ArrayStack<String> stack = new ArrayStack<>(10);

        stack.push("Test_1");
        stack.push("Test_2");
        stack.push("Test_3");

        stack.pop();

        assertEquals("Test_2", stack.pop());
    }

    @Test
    void testPopFromEmptyStack() {
        ArrayStack<String> stack = new ArrayStack<>(10);

        assertThrows(StackUnderflowException.class, stack::pop);
    }

    @Test
    void testPeekEmptyStack() {
        ArrayStack<String> stack = new ArrayStack<>(10);

        assertThrows(StackUnderflowException.class, stack::peek);

    }

    @Test
    void testCreateStackWithNegativeSize() {
        assertThrows(IllegalArgumentException.class, () -> new ArrayStack<>(-1));
    }
}