package com.sefrys.DataStructures.Hash;

import java.util.LinkedList;

/**
 * Created by Ireneusz Zagan on 17.05.18, 10:16
 * Contact: sefrys@gmail.com
 */
public abstract class HashCollection {

    protected LinkedList<String>[] table;
    protected final int INIT_SIZE = 128;
    protected final int LINKED_LIST_SIZE = 128;
    protected int size;

    protected HashCollection() {
        table = new LinkedList[INIT_SIZE];
        size = INIT_SIZE;
    }

    public abstract void add(String value);
    public abstract void remove(String value);
    public abstract boolean lookUp(String value);

    protected int hash(String s, int tableSize) {
        int hash = 0;
        for (int i = 0; i < s.length(); ++i) {
            hash *= 37;
            hash += s.charAt(i);
        }

        hash %= tableSize;

        return hash > 0 ? hash : Math.abs(-hash);
    }

    protected LinkedList<String>[] rehashMap() {
        size *= 2;
        LinkedList<String>[] newTable = new LinkedList[size];

        for (LinkedList<String> list : table) {
            for (String value : list) {
                int idx = hash(value, newTable.length);
                if (newTable[idx] == null) newTable[idx] = new LinkedList<>();
                newTable[idx].add(value);
            }
        }
        return newTable;
    }

}
