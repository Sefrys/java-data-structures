package com.sefrys.DataStructures.BinarySearchTree;

import com.sefrys.DataStructures.Queue.NodeQueue;

import java.util.Queue;

/**
 * Created by Ireneusz Zagan on 16.05.18, 09:44
 * Contact: sefrys@gmail.com
 */
class BinarySearchTree {

    private Node root;

    BinarySearchTree() {
        root = null;
    }

    void add(int value) {
        root = addRecursive(root, value);
    }

    boolean contains(int value) {
        return containsNodeRecursive(root, value);
    }

    private boolean containsNodeRecursive(Node current, int value) {
        if (current == null) {
            return false;
        }

        if (value == current.getValue()) {
            return true;
        }

        /* runs containsNodeRecursive with current's left child if value < current's value, else runs with right child*/
        return value < current.getValue() ? containsNodeRecursive(current.getLeft(), value) : containsNodeRecursive(current.getRight(), value);
    }

    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.getValue()) {
            current.setLeft(addRecursive(current.getLeft(), value));
        } else if (value > current.getValue()) {
            current.setRight(addRecursive(current.getRight(), value));
        } else {
            return current;
        }

        return current;
    }

    public void traverseDisplayBreadth() {
        if (root == null) {
            return;
        }

        NodeQueue<Node> nodes = new NodeQueue<>();
        nodes.enqueue(root);

        while(!nodes.isEmpty()) {
            Node node = nodes.dequeue();

            System.out.println(" " + node.getValue());

            if (node.getLeft() != null) nodes.enqueue(node.getLeft());
            if (node.getRight() != null) nodes.enqueue(node.getRight());
        }

    }


}
