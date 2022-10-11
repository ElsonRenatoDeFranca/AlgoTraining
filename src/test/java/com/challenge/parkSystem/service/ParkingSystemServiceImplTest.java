package com.challenge.parkSystem.service;

import com.challenge.parkSystem.util.CarTypeEnum;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

@ExtendWith(MockitoExtension.class)
class ParkingSystemServiceImplTest {

    private static final int MAX_NUMBER_OF_ARRIVING_CARS = 10;
    private static final int MINIMUM_NUMBER_OF_ARRIVING_CARS = 1;

    @InjectMocks
    private ParkingSystemServiceImpl parkingSystemService;

    @Test
    public void shouldReturnTrueWhenThereIsSpaceAvailableForBigCarsOnly() {
        this.parkingSystemService = new ParkingSystemServiceImpl(1, 0, 0);
        Boolean[] actualResponse = parkingSystemService.addCar(getWaitingList());
     }

    @Test
    public void shouldReturnTrueWhenThereIsSpaceAvailableForMediumCarsOnly() {
        this.parkingSystemService = new ParkingSystemServiceImpl(0, 1, 0);
        Boolean[] actualResponse = parkingSystemService.addCar(getWaitingList());
        Assertions.assertThat(actualResponse).containsAnyOf(false, false, true);
    }

    @Test
    public void shouldReturnTrueWhenThereIsSpaceAvailableForSmallCarsOnly() {
        this.parkingSystemService = new ParkingSystemServiceImpl(0, 0, 1);
        Boolean[] actualResponse = parkingSystemService.addCar(getWaitingList());
        Assertions.assertThat(actualResponse).containsAnyOf(true, false, true);
    }


    @Test
    public void shouldReturnFalseWhenThereIsNoSpaceAvailable() {
        this.parkingSystemService = new ParkingSystemServiceImpl(0, 0, 0);
        Boolean[] actualResponse = parkingSystemService.addCar(getWaitingList());
        Assertions.assertThat(actualResponse).containsAnyOf(false, false, false);
    }

    @Test
    public void shouldThrowIndexOutOfBoundsExceptionWhenMaximumNumberOfCarsHasBeenReached() {
        this.parkingSystemService = new ParkingSystemServiceImpl(0, 0, 0);
        List<Integer> randomCarTypeList = generateRandomCarList();
        randomCarTypeList.add(CarTypeEnum.BIG.getValue());

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> parkingSystemService.addCar(randomCarTypeList))
                .withMessage(""+MAX_NUMBER_OF_ARRIVING_CARS);
    }

    private List<Integer> generateRandomCarList() {
        List<Integer> randomCarTypeList = new ArrayList<>();
        IntStream.rangeClosed(MINIMUM_NUMBER_OF_ARRIVING_CARS, MAX_NUMBER_OF_ARRIVING_CARS).forEach(value -> {
            randomCarTypeList.add(generateRandomInteger());
        });

        return randomCarTypeList;
    }

    private Integer generateRandomInteger() {
        int minimum = 1;
        int maximum = 3;
        Random rand = new Random();
        return rand.nextInt((maximum - minimum) + 1) + minimum;
    }


    private List<Integer> getWaitingList() {
        List<Integer> waitingList = new ArrayList<>();
        waitingList.add(3);
        waitingList.add(1);
        waitingList.add(2);

        return waitingList;
    }
}