package com.sefrys.DataStructures.Hash;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Ireneusz Zagan on 17.05.18, 09:12
 * Contact: sefrys@gmail.com
 */
public class HashTableTest {

    private HashTable map;

    @BeforeEach
    void createHashTable() {
        map = new HashTable();
    }

    @Test
    void testHashTableAdd() {
        map.add("Hello");
        map.add("Hell");
        map.add("Helium");
    }

    @Test
    void testHashTableLookUp() {
        map.add("Hello");
        map.add("Hell");
        map.add("Helium");

        assertTrue(map.lookUp("Hello"));
        assertTrue(map.lookUp("Hell"));
        assertTrue(map.lookUp("Helium"));
    }

    @Test
    void testHashTableLookUpNotExistent() {
        map.add("Heck");

        assertFalse(map.lookUp("Hello"));
    }

    @Test
    void testHashTableRemove() {
        map.add("Hello");
        map.add("Hell");
        map.add("Helium");
        map.remove("Hell");

        assertFalse(map.lookUp("Hell"));
    }

    @Test
    void testHashTableRemoveFromNotExistingList() {
        map.remove("Test");
    }

    @Test
    void testHashTableRemoveTwice() {
        map.add("Help");
        map.remove("Help");
        map.remove("Help");
    }

    @Test
    void testHashTableAddLongWordOverturningInt() {
        map.add("thisIsAReallyLongWordLikeSuperVeryLog");
    }

    @Test
    void testLookUpWithFullDictionary() throws IOException {
        Path dictionaryPath = new File("/home/adonalsium/Documents/Codecool/Java SE/Data Structures/DataStructures/src/main/resources/dictionary.txt").toPath();
        List<String> wordList = Files.readAllLines(dictionaryPath);

        for (String word : wordList) {
            map.add(word);
        }
    }

}
