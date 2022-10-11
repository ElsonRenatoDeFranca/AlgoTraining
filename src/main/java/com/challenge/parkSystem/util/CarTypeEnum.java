package com.challenge.parkSystem.util;

public enum CarTypeEnum {
    BIG(1),
    MEDIUM(2),
    SMALL(3);

    private Integer value;

    CarTypeEnum(Integer value){
        this.value = value;
    }

    public Integer getValue(){return value;}
}
