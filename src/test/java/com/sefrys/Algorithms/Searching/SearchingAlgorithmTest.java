package com.sefrys.Algorithms.Searching;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Ireneusz Zagan on 21.05.18, 17:16
 * Contact: sefrys@gmail.com
 */
class SearchingAlgorithmTest {

    private SearchingAlgorithm alg;
    private int[] sortedArray;

    @BeforeEach
    void setUp() {
        this.alg = new SearchingAlgorithm();
        this.sortedArray = new int[]{1, 9, 12, 29, 39, 42, 45, 47, 59, 87, 90};
    }

    @Test
    void testValueInArray() {
        assertTrue(alg.binarySearch(sortedArray, 59));
        assertTrue(alg.binarySearch(sortedArray, 1));
        assertTrue(alg.binarySearch(sortedArray, 9));
        assertTrue(alg.binarySearch(sortedArray, 90));
    }

    @Test
    void testValueNotInArray() {
        assertFalse(alg.binarySearch(sortedArray, 19999));
        assertFalse(alg.binarySearch(sortedArray, 0));
        assertFalse(alg.binarySearch(sortedArray, 38));
    }

}