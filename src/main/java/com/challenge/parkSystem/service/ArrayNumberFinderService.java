package com.challenge.parkSystem.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;

@Service
public class ArrayNumberFinderService {

    public boolean bruteForceSearch(int[] sortedArray, int key) {
        for (int i = 0; i < sortedArray.length; i++) {
            if (key == sortedArray[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean binarySearch(int[] sortedArray, int key) {
        int minimum = 0;
        int maximum = sortedArray.length;

        if (isArrayNullOrEmpty(sortedArray)) {
            return false;
        } else {
            while (minimum < maximum) {
                int middle = (minimum + maximum) / 2;

                if (key == sortedArray[middle]) {
                    return true;
                } else {
                    if (key > sortedArray[middle]) {
                        minimum = middle + 1;
                    } else if (key < sortedArray[middle]) {
                        maximum = middle - 1;
                    }
                }
            }
        }
        return false;
    }

    public boolean binarySearchUsingJ2SEAPI(int[] sortedArray, int key) {

        int returnedIndex = Arrays.binarySearch(sortedArray, key);
        return (key == sortedArray[returnedIndex]);
    }

    private boolean isArrayNullOrEmpty(int[] array) {
        return array == null || array.length == 0;
    }
}
