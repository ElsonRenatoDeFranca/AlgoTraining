package com.challenge.parkSystem.service;

import com.challenge.parkSystem.util.CarTypeEnum;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@NoArgsConstructor
public class ParkingSystemServiceImpl implements ParkingSystemService{

    private static final int MAXIMUM_NUMBER_OF_CARS = 10;
    private int big;
    private int medium;
    private int small;

    private Boolean [] parkedCars = new Boolean[MAXIMUM_NUMBER_OF_CARS];

    public ParkingSystemServiceImpl(int big, int medium, int small){
        this.big = big;
        this.medium = big;
        this.small = small;
    }

    @Override
    public Boolean [] addCar(List<Integer> waitingCarsList){
        if(waitingCarsList != null){
            for(int i = 0; i< waitingCarsList.size(); i++){
                this.parkedCars[i] = addCarByCarType(waitingCarsList.get(i));
            }
        }
        return parkedCars;
    }

    private boolean addCarByCarType(Integer carType){
        if(Objects.equals(carType, CarTypeEnum.BIG.getValue())){
            return isThereSpaceForBigCars();
        }
        else if(Objects.equals(carType, CarTypeEnum.MEDIUM.getValue())){
            return isThereSpaceForMediumCars();
        }
        else if(Objects.equals(carType, CarTypeEnum.SMALL.getValue())){
            return isThereSpaceForSmallCars();
        }

        return false;
    }

    private boolean isThereSpaceForBigCars(){
        return this.big > 0;
    }

    private boolean isThereSpaceForMediumCars(){
        return this.medium > 0;
    }

    private boolean isThereSpaceForSmallCars(){
        return this.small > 0;
    }


}
