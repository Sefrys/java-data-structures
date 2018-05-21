package com.sefrys.DataStructures.Hash;

import java.util.LinkedList;

/**
 * Created by Ireneusz Zagan on 17.05.18, 10:15
 * Contact: sefrys@gmail.com
 */
public class HashTable extends HashCollection {

    public HashTable() {
        super();
    }

    @Override
    public void add(String value) {

        int idx = hash(value, table.length);
        if (table[idx] == null) table[idx] = new LinkedList<>();
        table[idx].add(value);

        if (table[idx].size() > LINKED_LIST_SIZE) this.table = rehashMap();



    }

    @Override
    public void remove(String value) {
        int idx = hash(value, table.length);
        if (table[idx] == null) return;
        table[idx].remove(value);


    }

    @Override
    public boolean lookUp(String value) {
        int idx = hash(value, table.length);

        if ( table[idx] == null) return false;
        for (String s : table[idx]) {
            if (s.equals(value)) return true;
        }

        return false;

    }
}
