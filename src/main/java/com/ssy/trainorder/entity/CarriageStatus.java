package com.ssy.trainorder.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CarriageStatus {
    private int carriage_no;
    private int remaining;

    public CarriageStatus(int carriage_no, int remaining) {
        this.carriage_no = carriage_no;
        this.remaining = remaining;
    }

    @JsonProperty("carriage_no")
    public int getCarriage_no() {
        return carriage_no;
    }

    public void setCarriage_no(int carriage_no) {
        this.carriage_no = carriage_no;
    }

    @JsonProperty("remaining")
    public int getRemaining() {
        return remaining;
    }

    public void setRemaining(int remaining) {
        this.remaining = remaining;
    }
}
