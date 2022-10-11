package com.challenge.parkSystem.service;

import java.util.Arrays;
import java.util.HashSet;

public class IntersectionOfTwoArraysServiceImpl implements IntersectionOfTwoArraysService {

    private static final int MAX_INPUT_ARRAY_SIZE = 10;
    private static final String EXCEPTION_MESSAGE = "Input array is larger than expected";
    @Override
    public Integer[] calculateIntersection(Integer[] firstArray, Integer[] secondArray) {
        if(firstArray.length > MAX_INPUT_ARRAY_SIZE || secondArray.length >  MAX_INPUT_ARRAY_SIZE){
            throw new IndexOutOfBoundsException(EXCEPTION_MESSAGE + MAX_INPUT_ARRAY_SIZE);
        }else{
            HashSet<Integer> set = new HashSet<>();
            set.addAll(Arrays.asList(firstArray));
            set.retainAll(Arrays.asList(secondArray));
            Integer [] intersection = {};
            return set.toArray(intersection);
        }
    }
}
