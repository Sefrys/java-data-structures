package com.sefrys.DataStructures.BinarySearchTree;

/**
 * Created by Ireneusz Zagan on 16.05.18, 09:48
 * Contact: sefrys@gmail.com
 */
public class Node {

    private int value;
    private Node left, right;

    Node(int value) {
        this.value = value;
        left = null;
        right = null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
