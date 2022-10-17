package com.musalasoft.drones.enums;

public enum States {
    IDLE(1), LOADING(2), LOADED(3), DELIVERING(4), DELIVERED(5), RETURNING(6);

    private final int value;

    States(int value) {
        this.value = value;
    }

    public static States getState(int value) {
        for (States state : States.values()) {
            if (value == state.value) {
                return state;
            }
        }
        return null;
    }

    public int getValue() {
        return value;
    }
}
