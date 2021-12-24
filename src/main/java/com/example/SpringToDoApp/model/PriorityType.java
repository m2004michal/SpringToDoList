package com.example.SpringToDoApp.model;

import com.example.SpringToDoApp.exceptions.SpringToDoException;

import java.util.Arrays;

public enum PriorityType {
    HIGH(2), MEDIUM(1), LOW(-1),;

    private int direction;

    PriorityType(int direction){
    }

    public static PriorityType lookup(Integer direction) throws Exception{
        return Arrays.stream(PriorityType.values())
                .filter(value -> value.getDirection().equals(direction))
                .findAny()
                .orElseThrow(() -> new SpringToDoException("Priority not found"));
    }

    public Integer getDirection() {
        return direction;
    }
}
