package com.challenge.parkSystem.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class IntersectionOfTwoArraysServiceImplTest {

    private static final String EXCEPTION_MESSAGE = "Input array is larger than expected";
    private static final int MAX_INPUT_ARRAY_SIZE = 10;

    @InjectMocks
    private IntersectionOfTwoArraysService intersectionOfTwoArraysService = new IntersectionOfTwoArraysServiceImpl();

    @Test
    public void shouldReturnIntersectionArrayWhenThereIsAnIntersectionAvailableBetweenTwoArrays() {
        Integer[] firstArray = {1, 2, 3, 4, 5, 6};
        Integer[] secondArray = {11, 12, 13, 4, 5, 7};
        Integer[] expectedResponse = {4, 5};

        Integer[] actualResponse = intersectionOfTwoArraysService.calculateIntersection(firstArray, secondArray);
        Assertions.assertThat(actualResponse).isEqualTo(expectedResponse);

    }

    @Test
    public void shouldThrowIndexOutOfBoundsExceptionWhenMaximumNumberOfElementsIsExceededInTheFirstArray() {
        Integer[] firstArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 11, 12};
        Integer[] secondArray = {11, 12, 13, 4, 5, 7};

        Assertions.assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> intersectionOfTwoArraysService.calculateIntersection(firstArray, secondArray))
                .withMessage(EXCEPTION_MESSAGE + MAX_INPUT_ARRAY_SIZE);

    }

    @Test
    public void shouldThrowIndexOutOfBoundsExceptionWhenMaximumNumberOfElementsIsExceededInTheSecondArray() {
        Integer[] firstArray = {1, 2, 3, 4, 5, 6, 7, 0};
        Integer[] secondArray = {11, 12, 13, 4, 5, 7, 2, 3, 4, 5, 100, 102, 103};

        Assertions.assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> intersectionOfTwoArraysService.calculateIntersection(firstArray, secondArray))
                .withMessage(EXCEPTION_MESSAGE + MAX_INPUT_ARRAY_SIZE);

    }

    @Test
    public void shouldReturnAnEmptyArrayWhenThereIsNoIntersectionBetweenTwoArraysAndOneOfArraysHasOnlyOneElement() {
        Integer[] firstArray = {1};
        Integer[] secondArray = {};
        Integer[] expectedResponse = {};

        Integer[] actualResponse = intersectionOfTwoArraysService.calculateIntersection(firstArray, secondArray);
        Assertions.assertThat(actualResponse).isEqualTo(expectedResponse);
    }

    @Test
    public void shouldReturnAnEmptyArrayWhenTwoInputArrayArraysProvidedAsInputAreEmpty() {
        Integer[] firstArray = {};
        Integer[] secondArray = {};
        Integer[] expectedResponse = {};

        Integer[] actualResponse = intersectionOfTwoArraysService.calculateIntersection(firstArray, secondArray);
        Assertions.assertThat(actualResponse).isEqualTo(expectedResponse);
    }

    @Test
    public void shouldReturnAnEmptyArrayWhenThereIsNoIntersectionBetweenTwoArrays() {
        Integer[] firstArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Integer[] secondArray = {11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        Integer[] expectedResponse = {};

        Integer[] actualResponse = intersectionOfTwoArraysService.calculateIntersection(firstArray, secondArray);
        Assertions.assertThat(actualResponse).isEqualTo(expectedResponse);
    }


    @Test
    public void shouldReturnAnIntersectionArrayWhenTheProvidedArrayHasOneElementAndBothArraysAreEquals() {
        Integer[] firstArray = {1};
        Integer[] secondArray = {1};
        Integer[] expectedResponse = {1};

        Integer[] actualResponse = intersectionOfTwoArraysService.calculateIntersection(firstArray, secondArray);
        Assertions.assertThat(actualResponse).isEqualTo(expectedResponse);
    }

}