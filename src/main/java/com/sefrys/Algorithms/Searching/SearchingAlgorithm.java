package com.sefrys.Algorithms.Searching;

/**
 * Created by Ireneusz Zagan on 21.05.18, 17:06
 * Contact: sefrys@gmail.com
 */
public class SearchingAlgorithm {

    public boolean binarySearch(int[] array, int value) {
        int lowerBound = 0;
        int upperBound = array.length - 1;

        while (lowerBound <= upperBound) {

            int midPoint = lowerBound + (upperBound - lowerBound) / 2;

            if (array[midPoint] < value) {
                lowerBound = midPoint + 1;
            } else if (array[midPoint] > value) {
                upperBound = midPoint - 1;
            } else if (array[midPoint] == value) return true;
        }
        return false;
    }

}
