package com.challenge.parkSystem.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
class ArrayNumberFinderServiceTest {

    @InjectMocks
    private ArrayNumberFinderService arrayNumberFinderService;

    @ParameterizedTest
    @ValueSource(ints = {-2})
    public void findNumberInArrayUsingBruteForceAlgorithm(int key){
        int [] sortedArray = {-9, -2, 0, 1, 4, 5, 10, 12, 14, 23, 37, 54, 75, 81, 85, 90, 97, 102};

        boolean actualValue = arrayNumberFinderService.bruteForceSearch(sortedArray, key);
        assertThat(actualValue).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {0})
    public void findNumberInArrayUsingBinarySearchAlgorithm(int key){
        int [] sortedArray = {-9, -2, 0, 1, 4, 5, 10, 12, 14, 23, 37, 54, 75, 81, 85, 90, 97, 102};

        boolean actualValue = arrayNumberFinderService.binarySearch(sortedArray, key);
        assertThat(actualValue).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {0})
    public void findNumberInArrayUsingBuiltInBinarySearchAlgorithm(int key){
        int [] sortedArray = {-9, -2, 0, 1, 4, 5, 10, 12, 14, 23, 37, 54, 75, 81, 85, 90, 97, 102};

        boolean actualValue = arrayNumberFinderService.binarySearchUsingJ2SEAPI(sortedArray, key);
        assertThat(actualValue).isTrue();
    }
}