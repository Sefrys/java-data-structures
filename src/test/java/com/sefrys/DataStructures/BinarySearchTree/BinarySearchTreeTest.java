package com.sefrys.DataStructures.BinarySearchTree;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by Ireneusz Zagan on 16.05.18, 09:30
 * Contact: sefrys@gmail.com
 */
class BinarySearchTreeTest {

    @Test
    void testBSTAdd() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(21);
        tree.add(4);
        tree.add(6);
        tree.add(3);

        assertTrue( tree.contains(6));
    }

    @Test
    void testBSTFindEmptyTreeReturnsFalse() {
        BinarySearchTree tree = new BinarySearchTree();

        assertFalse(tree.contains(10));
    }

    @Test
    void testBSTFindNonExistentValueReturnsFalse() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(6);
        tree.add(3);
        tree.add(7);
        tree.add(14);
        tree.add(1);
        tree.add(2);

        tree.traverseDisplayBreadth();

        assertFalse(tree.contains(10));
    }

    @Test
    void testBSTContainsFasterThanLinkedList() {
        LinkedList<Integer> li = new LinkedList<>();
        li.add(10);
        li.add(8);
        li.add(19);
        li.add(34);
        li.add(10);
        li.add(11);
        li.add(4);
        li.add(26);
        li.add(14);

        BinarySearchTree tree = new BinarySearchTree();

        tree.add(10);
        tree.add(8);
        tree.add(19);
        tree.add(34);
        tree.add(10);
        tree.add(11);
        tree.add(4);
        tree.add(26);
        tree.add(14);

        long listStartTime = System.nanoTime();
        li.contains(11);
        long listStopTime = System.nanoTime();

        long listTime = listStopTime - listStartTime;

        long treeStartTime = System.nanoTime();
        tree.contains(11);
        long treeStopTime = System.nanoTime();

        long treeTime = treeStopTime - treeStartTime;

        assertTrue(treeTime < listTime);
    }


}
